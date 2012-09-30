<link href="/website/css/content.css" rel="stylesheet" type="text/css">
<#include "/website/macro/commonfun.ftl">
<script language="javascript">
	function CheckForm(form) {
	    if(form.fileLocation.value.length == 0){
			form.fileLocation.focus();
			return false;
		}
	    if(/^.+\.(${Session["clientlogined"].get_video_support_format()?if_exists})$/i.test(form.fileLocation.value)){
			return true;
		}else{
			alert("支持的视频文件格式：${Session["clientlogined"].get_video_support_format()?if_exists}");
			form.fileLocation.focus();
			return false;
		}
	}		
</script>
<@tt width="600"/>
<form name="uploadFlvForm" action="siteoperationControl.action" method="post" onsubmit="return CheckForm(this)" enctype="multipart/form-data">
	<div class="title"><span class=bold>替换视频</span></div>
	<div class="content">
	<table>
		<tr>
			<td id=sa-bd>
			支持的视频文件格式：(${Session["clientlogined"].get_video_support_format()?if_exists})
			<br><input  class=input  type="File" name="fileLocation" size=40 >
	           <p align=center>
	           <input  class=bt type="submit"  value="上传文件"> 
	           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	           <input  class=bt type="button"  value="返回" onclick="javascript:history.go(-1);">
				</p>
				</td>
			</tr>
		<tr>
	</table>	
	 	
		
	<input type="hidden" name="DM.Object.upld" value="uploadFlvFile">
	<input type="hidden" name="DM.Upload.upld" value="">			
	<input type="hidden" name="DM.Instance.upld.uploadFileName" value="fileLocation">	
	<input type="hidden" name="DM.Instance.upld.subdir" value="/${results["DM.Reload.SiteSpmp8.Result"].siteUser.username}/">
	<input type="hidden" name="DM.Instance.upld.docroot" value="path_userhome">
	<input type="hidden" name="DM.Instance.SiteSpmp8.filepath" value="@{upld.filepath}">
	<input type="hidden" name="DM.Instance.SiteSpmp8.filename" value="@{upld.fileName}">
	<input type="hidden" name="DM.Update.SiteSpmp8" value="">
	<input type="hidden" name="DM.Update.SiteSpmp8.__Depends" value="DM.Upload.upld">
	<input type="hidden" name="DM.Query.SiteSpmp8.__Depends" value="DM.Update.SiteSpmp8">	
	<input type="hidden" name="DM.Object.SiteSpmp8" value="SiteSpmp8">
	<input type="hidden" name="DM.Reload.SiteUser" value="SiteUser">
	<input type="hidden" name="DM.Instance.SiteUser.id" value="${results["DM.Reload.SiteUser.Result"].id}">
	<input type="hidden" name="DM.Object.SiteUser" value="SiteUser">
			
	<input type="hidden" name="DM.Object.SiteSpmp8" value="SiteSpmp8">
	<input type="hidden" name="DM.Reload.SiteSpmp8" value="">
	<input type="hidden" name="DM.Instance.SiteSpmp8.id" value="${results["DM.Reload.SiteSpmp8.Result"].id}">	
	<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
	<input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/site_spmp8_admin.ftl">

</form>
</div>
<@bb/>
