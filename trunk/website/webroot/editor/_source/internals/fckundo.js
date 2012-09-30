/*
 * FCKeditor - The text editor for Internet - http://www.fckeditor.net
 * Copyright (C) 2003-2007 Frederico Caldeira Knabben
 *
 * == BEGIN LICENSE ==
 *
 * Licensed under the terms of any of the following licenses at your
 * choice:
 *
 *  - GNU General Public License Version 2 or later (the "GPL")
 *    http://www.gnu.org/licenses/gpl.html
 *
 *  - GNU Lesser General Public License Version 2.1 or later (the "LGPL")
 *    http://www.gnu.org/licenses/lgpl.html
 *
 *  - Mozilla Public License Version 1.1 or later (the "MPL")
 *    http://www.mozilla.org/MPL/MPL-1.1.html
 *
 * == END LICENSE ==
 *
 * Gecko specific implementation for the Undo/Redo system.
 */

var FCKUndo = new Object() ;

FCKUndo.SavedData = new Array() ;
FCKUndo.CurrentIndex = -1 ;
FCKUndo.TypesCount = 0 ;
FCKUndo.Changed = false ;	// Is the document changed in respect to its initial image?
FCKUndo.MaxTypes = 25 ;
FCKUndo.Typing = false ;

FCKUndo._GetBookmark = function()
{
	if ( FCKBrowserInfo.IsIE )
	{
		var selection = FCK.EditorDocument.selection ;
		if ( selection.type == 'Text' )
			return selection.createRange().getBookmark() ;
		else
			return null ;
	}
	else
	{
		var range = new FCKDomRange( FCK.EditorWindow ) ;
		range.MoveToSelection() ;
		return range.CreateBookmark2() ;
	}
}

FCKUndo._SelectBookmark = function( bookmark )
{
	if ( ! bookmark )
		return ;
	if ( FCKBrowserInfo.IsIE )
	{
		var range = FCK.EditorDocument.selection.createRange() ;
		range.moveToBookmark( bookmark ) ;
		range.select() ;
	}
	else
	{
		var range = new FCKDomRange( FCK.EditorWindow ) ;
		if ( bookmark instanceof Object )
		{
			range.MoveToBookmark2( bookmark ) ;
			try
			{
				// this does not always succeed, there are still some tricky cases where it fails
				// e.g. add a special character at end of document, undo, redo -> error
				range.Select() ;
			}
			catch ( e )
			{
				// if select restore fails, put the caret at the end of the document
				range.MoveToPosition( FCK.EditorDocument.body, 4 ) ;
				range.Select() ;
			}
		}
	}
}

FCKUndo.SaveUndoStep = function()
{
	if ( FCK.EditMode != FCK_EDITMODE_WYSIWYG )
		return ;

	// Assume the editor content is changed when SaveUndoStep() is called after the first time.
	// This also enables the undo button in toolbar.
	if ( FCKUndo.SavedData.length )
		FCKUndo.Changed = true ;

	// Get the HTML content.
	var sHtml = FCK.EditorDocument.body.innerHTML ;

	// Shrink the array to the current level.
	FCKUndo.SavedData = FCKUndo.SavedData.slice( 0, FCKUndo.CurrentIndex + 1 ) ;

	// Cancel operation if the new step is identical to the previous one.
	if ( FCKUndo.CurrentIndex > 0 && sHtml == FCKUndo.SavedData[ FCKUndo.CurrentIndex ][0] )
		return ;
	// Save the selection and caret position in the first undo level for the first change.
	else if ( FCKUndo.CurrentIndex == 0 && sHtml == FCKUndo.SavedData[0][0] )
	{
		FCKUndo.SavedData[0][1] = FCKUndo._GetBookmark() ;
		return ;
	}

	// If we reach the Maximun number of undo levels, we must remove the first
	// entry of the list shifting all elements.
	if ( FCKUndo.CurrentIndex + 1 >= FCKConfig.MaxUndoLevels )
		FCKUndo.SavedData.shift() ;
	else
		FCKUndo.CurrentIndex++ ;

	// Save the new level in front of the actual position.
	FCKUndo.SavedData[ FCKUndo.CurrentIndex ] = [ sHtml, FCKUndo._GetBookmark() ] ;

	FCK.Events.FireEvent( "OnSelectionChange" ) ;
}

FCKUndo.CheckUndoState = function()
{
	return ( FCKUndo.Changed || FCKUndo.CurrentIndex > 0 ) ;
}

FCKUndo.CheckRedoState = function()
{
	return ( FCKUndo.CurrentIndex < ( FCKUndo.SavedData.length - 1 ) ) ;
}

FCKUndo.Undo = function()
{
	if ( FCKUndo.CheckUndoState() )
	{
		// If it is the first step.
		if ( FCKUndo.CurrentIndex == ( FCKUndo.SavedData.length - 1 ) )
		{
			// Save the actual state for a possible "Redo" call.
			FCKUndo.SaveUndoStep() ;
		}

		// Go a step back.
		FCKUndo._ApplyUndoLevel( --FCKUndo.CurrentIndex ) ;

		FCK.Events.FireEvent( "OnSelectionChange" ) ;
	}
}

FCKUndo.Redo = function()
{
	if ( FCKUndo.CheckRedoState() )
	{
		// Go a step forward.
		FCKUndo._ApplyUndoLevel( ++FCKUndo.CurrentIndex ) ;

		FCK.Events.FireEvent( "OnSelectionChange" ) ;
	}
}

FCKUndo._ApplyUndoLevel = function( level )
{
	var oData = FCKUndo.SavedData[ level ] ;

	if ( !oData )
		return ;

	// Update the editor contents with that step data.
	if ( FCKBrowserInfo.IsIE )
		FCK.SetInnerHtml( oData[0] ) ;
	else
		FCK.EditorDocument.body.innerHTML = oData[0] ;

	// Restore the selection
	FCKUndo._SelectBookmark( oData[1] ) ;

	FCKUndo.TypesCount = 0 ;
	FCKUndo.Changed = false ;
	FCKUndo.Typing = false ;
}
