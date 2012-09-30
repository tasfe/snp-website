<#include "/website/macro/commonfun.ftl">
<#macro spmpitemupload  nob spmpitem   varimagealign spmpid >
<#include "/website/include/uploadpicfile.ftl">
	
	 	
		
	<input type="hidden" name="DM.Object.upld" value="uploadPicFile">
	<input type="hidden" name="DM.Upload.upld" value="">			
	<input type="hidden" name="DM.Instance.upld.uploadFileName" value="fileLocation">	
	<input type="hidden" name="DM.Instance.upld.subdir" value="/${Session["clientlogined"].username}/">
	<input type="hidden" name="DM.Instance.upld.docroot" value="path_userhome">

	<input type="hidden" name="DM.Instance.SiteSpmp${nob}Item.filepath" value="@{upld.filepath}">

	<input type="hidden" name="DM.Instance.SiteSpmp${nob}Item.filename" value="@{upld.fileName}">
	<#--
	<input type="hidden" name="DM.Instance.SiteSpmp${nob}Item.width" value="@{upld.width}">
	<input type="hidden" name="DM.Instance.SiteSpmp${nob}Item.height" value="@{upld.height}">
	-->
	<input type="hidden" name="DM.Instance.SiteSpmp${nob}Item.id" value="${spmpitem.id}">
	<input type="hidden" name="DM.Update.SiteSpmp${nob}Item" value="">
	<input type="hidden" name="DM.Update.SiteSpmp${nob}Item.__Depends" value="DM.Upload.upld">
	<input type="hidden" name="DM.Reload.SiteSpmp${nob}Item.__Depends" value="DM.Update.SiteSpmp${nob}Item">	
	<input type="hidden" name="DM.Object.SiteSpmp${nob}Item" value="SiteSpmp${nob}Item">
	
	<input type="hidden" name="DM.Object.SiteSpmp${nob}" value="SiteSpmp${nob}">
	<input type="hidden" name="DM.Reload.SiteSpmp${nob}" value="">
	<input type="hidden" name="DM.Instance.SiteSpmp${nob}.id" value="${spmpid}">	
	<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
	<input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/site_spmp${nob}_detail.ftl">
	</form>

</#macro>