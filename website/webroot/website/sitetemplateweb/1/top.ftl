<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#include "/website/macro/templetehtml.ftl">
<#include "/website/macro/map_language_title.ftl">  
<title>${SiteUser.searchTitle?if_exists}</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="Keywords" content="${SiteUser.searchKeys?if_exists}" />
<meta name="Description" content="${SiteUser.searchDesc?if_exists}" />
<script type="text/javascript" src="../../other/highslide/highslide-with-html.js"></script>
<script type="text/javascript" src="../../other/jquery151/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="../../other/website/snp.js"></script>
<script type="text/javascript" src="../../other/swfobject.js"></script>
<#--
<script type="text/javascript" src="../../other/jquery184/development-bundle/ui/minified/jquery.ui.core.min.js"></script>
<script type="text/javascript" src="../../other/jquery184/development-bundle/ui/minified/jquery.ui.widget.min.js"></script>
<script type="text/javascript" src="../../other/jquery184/development-bundle/ui/minified/jquery.ui.mouse.min.js"></script>
<script type="text/javascript" src="../../other/jquery184/development-bundle/ui/minified/jquery.ui.draggable.min.js"></script>
<script type="text/javascript" src="../../other/jquery184/development-bundle/ui/minified/jquery.ui.resizable.min.js"></script>	
<script type="text/javascript" src="../../other/jquery184/development-bundle/ui/minified/jquery-ui-1.8.13.custom.min.js"></script>	
-->
<script type="text/javascript" src="../../other/jquery184/development-bundle/ui/minified/jquery184.js"></script>	

<link type="text/css" href="../../other/cssfile/main${SiteUser.cssStyle}.css" rel="stylesheet" />
<link type="text/css" href="../../other/highslide/highslide.css" rel="stylesheet" />
<script type="text/javascript">
	$(function(){
		$("#top-lanmu").buttonset();
		$("#div-dir").accordion({ header: "h3" });
	});
	hs.graphicsDir = '../../other/highslide/graphics/';
	hs.outlineType = 'rounded-white';
	hs.wrapperClassName = 'draggable-header';
	hs.minWidth=600;
	hs.height=300;	
</script>
	
<#assign username=SiteUser.username?if_exists> 	
<#if LanmuObject.fullscreen=="full">
<body style="text-align:center;" >
	<div id=div-page>
	<div id=div-content style="width:100%; ">
</#if>
<#if LanmuObject.fullscreen=="left">
<body>
	<div id=div-page>
	<div id="div-content" >
</#if>
<#if LanmuObject.fullscreen==""> 
<body style="text-align:center;">
<div id=div-page>
<div id=div-content  style="margin-left:auto;margin-right:auto;"> 
</#if>
<!--top-->
<div id="div-top-link" >
	<div style="float:left;" >
 		<span id="top-extlink">
 		<@qqdisplay  qqstr=LanmuObject.qqtop  layout=""/>  		
  		<@extlink  palace='menu_top'/>
		
  		</span>
    </div>  
     <div id="div-language"><@SiteLanguage/></div>
</div>
<div id=div-title>
    <table style="table-layout:fixed;"> 
        <tr>
        	<td>
              <div >${SiteUser.title?if_exists}</div>     
            </td>
        </tr>
    </table>
</div>
   

<div> 
    <ul id=top-lanmu <#if LanmuObject.lanmudiralign=="right">style="text-align:right"</#if> <#if LanmuObject.lanmudiralign=="left">style="text-align:left"</#if> >
	    <@lanmulink lanmuname="index"/> 
	    <@lanmulink lanmuname=LanmuObject.lanmu1?default("")/>                 
		<@lanmulink lanmuname=LanmuObject.lanmu2?default("")/>   
		<@lanmulink lanmuname=LanmuObject.lanmu3?default("")/>   
		<@lanmulink lanmuname=LanmuObject.lanmu4?default("")/>   
		<@lanmulink lanmuname=LanmuObject.lanmu5?default("") />   
		<@lanmulink lanmuname=LanmuObject.lanmu6?default("")/>   
		<@lanmulink lanmuname=LanmuObject.lanmu7?default("")/>   
		<@lanmulink lanmuname=LanmuObject.lanmu8?default("")/>   
		<@lanmulink lanmuname=LanmuObject.lanmu9?default("")/>   
    </ul>  
    <div class="ui-state-default " style="border-bottom: 0px"></div>       
</div>
<div id=hengtiao></div>    
<div id=ht></div>  
<!--lanmu end-->		            
		
	
<div id=div-main  >
    <table width=100%>
        <tr>
