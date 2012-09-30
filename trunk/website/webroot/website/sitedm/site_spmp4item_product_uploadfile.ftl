<#include "/website/include/uploadpicfile.ftl">

	<input type="hidden" name="spmp4id" value=${tempvar["spmp4id"]}>  	
	 	
		
	<input type="hidden" name="DM.Object.upld" value="uploadPicFile">
	<input type="hidden" name="DM.Upload.upld" value="">			
	<input type="hidden" name="DM.Instance.upld.uploadFileName" value="fileLocation">	
	<input type="hidden" name="DM.Instance.upld.subdir" value="/${Session["clientlogined"].username}/">
	<input type="hidden" name="DM.Instance.upld.docroot" value="path_userhome">

	<input type="hidden" name="DM.Instance.SiteProduct.filename" value="@{upld.fileName}">
	<input type="hidden" name="DM.Instance.SiteProduct.filepath" value="@{upld.filepath}">

	<input type="hidden" name="DM.Object.SiteProduct" value="SiteProduct">
	<input type="hidden" name="DM.Query.SiteProduct" value="">
	<input type="hidden" name="DM.Query.SiteProduct.Type" value="Results">
	<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
	<input type="hidden" name="DM.Instance.SiteProduct.id" value="${results["DM.Reload.SiteProduct.Result"].id}">	
			
	<input type="hidden" name="DM.Update.SiteProduct" value="">
	<input type="hidden" name="DM.Update.SiteProduct.__Depends" value="DM.Upload.upld">
	<input type="hidden" name="DM.Query.SiteProduct.__Depends" value="DM.Update.SiteProduct">	
	<input type="hidden" name="DM.Object.SiteProduct" value="SiteProduct">
	
	<input type="hidden" name="DM.Reload.SiteSpmp4Item" value="SiteSpmp4Item">
	<input type="hidden" name="DM.Instance.SiteSpmp4Item.id" value="${results["DM.Reload.SiteSpmp4Item.Result"].id}">
	<input type="hidden" name="DM.Object.SiteSpmp4Item" value="SiteSpmp4Item">
	
	<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
	<input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/site_spmp4item_product_admin.ftl">					
</form>
</div>
