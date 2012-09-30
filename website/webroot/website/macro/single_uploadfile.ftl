
<#macro singleuploadfile beanname   qianzhui   >
	<#include "/website/include/uploadpicfile.ftl">
	<input type="hidden" name="DM.Object.upld" value="uploadPicFile">
	<input type="hidden" name="DM.Upload.upld" value="">			
	<input type="hidden" name="DM.Instance.upld.uploadFileName" value="fileLocation">	
	<input type="hidden" name="DM.Instance.upld.subdir" value="/${results["DM.Reload.SiteUser.Result"].username}/">
	<input type="hidden" name="DM.Instance.${beanname}.filename" value="@{upld.fileName}">
	<input type="hidden" name="DM.Instance.${beanname}.filepath" value="@{upld.filepath}">
	<input type="hidden" name="DM.Instance.${beanname}.width" value="@{upld.width}">
	<input type="hidden" name="DM.Instance.${beanname}.height" value="@{upld.height}">		
	<input type="hidden" name="DM.Object.${beanname}" value="${beanname}">
	<input type="hidden" name="DM.Query.${beanname}" value="">
	<input type="hidden" name="DM.Query.${beanname}.Type" value="Results">
	<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
	<input type="hidden" name="DM.Instance.${beanname}.id" value="${results["DM.Reload.${beanname}.Result"].id}">					
	<input type="hidden" name="DM.Update.${beanname}" value="">
	<input type="hidden" name="DM.Update.${beanname}.__Depends" value="DM.Upload.upld">
	<input type="hidden" name="DM.Query.${beanname}.__Depends" value="DM.Update.${beanname}">	
	<input type="hidden" name="DM.Object.${beanname}" value="${beanname}">
	<input type="hidden" name="DM.Reload.SiteUser" value="SiteUser">
	<input type="hidden" name="DM.Instance.SiteUser.id" value="${results["DM.Reload.SiteUser.Result"].id}">
	<input type="hidden" name="DM.Object.SiteUser" value="SiteUser">
	<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
	<input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/${qianzhui}_admin.ftl">					
	</form>
</#macro>	


		
		
		
	

