<link href="/website/css/content.css" rel="stylesheet" type="text/css">
<#include "/website/macro/commonfun.ftl">
<script language="javascript">

<#--检查实际表单提交的内容不要被无意修改了-->
function CheckForm(form) {
	if (form.fileLocation.value.length == 0){
		alert("文件地址不能为空");
		form.fileLocation.focus();
		return false;
	}
	var fileext=form.fileLocation.value.substring(form.fileLocation.value.length-4,form.fileLocation.value.length);
	fileext=fileext.toLowerCase();
	<#---->
	if (!(fileext=='.flv'|| fileext=='.mov'||fileext=='.avi'||fileext=='.mpeg'||fileext=='.3gp'||fileext=='.mpeg'||fileext=='.wmv')) {
		alert("支持的视频文件格式：");
		form.fileLocation.focus();
		return false;
	}
	
	return true;
}		

</script>


<div class="div">
<form  name="uploadPicForm" action="siteoperationControl.action" method="post" onsubmit="return CheckForm(this)" enctype="multipart/form-data">
<p id=sa-title>[&nbsp;替换视频&nbsp;]</p>
<table >
	<tr>
		<td id=sa-bd>
		支持的视频文件格式：：
		<br><input  id=oursite_input  type="File" name="fileLocation" size=40 >
           
           <p align=center>
           <input  id=oursite_input type="submit"  value="上传文件"> 
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           <input  id=oursite_input type="button"  value="返回" onclick="javascript:history.go(-1);">
			</p>
			</td>
		</tr>
	<tr>
</table>	
	 	
		
	<input type="hidden" name="DM.Object.upld" value="uploadFlvFile">
	<input type="hidden" name="DM.Upload.upld" value="">			
	<input type="hidden" name="DM.Instance.upld.uploadFileName" value="fileLocation">	
	<input type="hidden" name="DM.Instance.upld.subdir" value="/${results["DM.Reload.SiteSpmp4Item.Result"].siteSpmp4.siteUser.username}/">
	<input type="hidden" name="DM.Instance.upld.docroot" value="path_userhome">
	<input type="hidden" name="DM.Instance.SiteSpmp4Item.filepathvideo" value="@{upld.filepath}">
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
</div>
