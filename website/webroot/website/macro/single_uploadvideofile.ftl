<#macro singleuploadvideofile beanname   qianzhui   >
	<#include "/website/include/uploadvideo.ftl">
		<input type="hidden" name="DM.Object.upld" value="uploadFlvFile">
		<input type="hidden" name="DM.Upload.upld" value="">			
		<input type="hidden" name="DM.Instance.upld.uploadFileName" value="fileLocation">	
		<input type="hidden" name="DM.Instance.upld.subdir" value="/${Session["clientlogined"].username?if_exists}/">
		<input type="hidden" name="DM.Instance.upld.docroot" value="path_userhome">
		
		<input type="hidden" name="DM.Instance.${beanname}.filepathvideo" value="@{upld.filepath}">
		<input type="hidden" name="DM.Instance.${beanname}.widthvideo" value="@{upld.width}">
		<input type="hidden" name="DM.Instance.${beanname}.heightvideo" value="@{upld.heigth}">
		<input type="hidden" name="DM.Update.${beanname}.__Depends" value="DM.Upload.upld">
		<input type="hidden" name="DM.Reload.SiteUse.__Depends" value="DM.Update.${beanname}">	
		<input type="hidden" name="DM.Object.${beanname}" value="${beanname}">
		<input type="hidden" name="DM.Instance.${beanname}.id" value="${results["DM.Reload.${beanname}.Result"].id}">
		<input type="hidden" name="DM.Update.${beanname}" value="">
		<input type="hidden" name="DM.Reload.SiteUser" value="SiteUser">
		<input type="hidden" name="DM.Instance.SiteUser.id" value="${Session["clientlogined"].id?if_exists}">
		<input type="hidden" name="DM.Object.SiteUser" value="SiteUser">	
		<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
		<input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/${qianzhui}_admin.ftl">
	</form>
</#macro>	


		
		
		
	

