<#include "/website/include/uploadpicfile.ftl">

	 	
		
	<input type="hidden" name="DM.Object.upld" value="uploadPicFile">
	<input type="hidden" name="DM.Upload.upld" value="">			
	<input type="hidden" name="DM.Instance.upld.uploadFileName" value="fileLocation">	
	<input type="hidden" name="DM.Instance.upld.subdir" value="/${results["DM.Reload.SiteSpmp4Item.Result"].siteSpmp4.siteUser.username}/">
	<input type="hidden" name="DM.Instance.upld.docroot" value="path_userhome">
	<input type="hidden" name="DM.Instance.upld.smallpic" value="yes">

	<input type="hidden" name="DM.Instance.SiteSpmp4Item.filepath" value="@{upld.filepath}">
	<input type="hidden" name="DM.Instance.SiteSpmp4Item.filename" value="@{upld.fileName}">
	<input type="hidden" name="DM.Instance.SiteSpmp4Item.width" value="@{upld.width}">
	<input type="hidden" name="DM.Instance.SiteSpmp4Item.height" value="@{upld.height}">
	
	<input type="hidden" name="DM.Instance.SiteSpmp4Item.id" value=" ${results["DM.Reload.SiteSpmp4Item.Result"].id}">
	<input type="hidden" name="DM.Update.SiteSpmp4Item" value="">
	<input type="hidden" name="DM.Update.SiteSpmp4Item.__Depends" value="DM.Upload.upld">
	<input type="hidden" name="DM.Query.SiteSpmp4Item.__Depends" value="DM.Update.SiteSpmp4Item">	
	<input type="hidden" name="DM.Object.SiteSpmp4Item" value="SiteSpmp4Item">
	
	<input type="hidden" name="DM.Object.SiteSpmp4" value="SiteSpmp4">
	<input type="hidden" name="DM.Reload.SiteSpmp4" value="">
	<input type="hidden" name="DM.Instance.SiteSpmp4.id" value="${results["DM.Reload.SiteSpmp4Item.Result"].siteSpmp4.id}">	
	<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
	<input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/site_spmp4_detail.ftl">
	
	
</form>

