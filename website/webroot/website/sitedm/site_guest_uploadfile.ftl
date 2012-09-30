<link href="/website/css/content.css" rel="stylesheet" type="text/css">

<#include "/website/macro/commonfun.ftl">
<script language="javascript">
        function verifyValue(){	
        if (form1.testFile.value.length == 0){
		alert("文件地址不能为空");
		form1.testFile.focus();
		return false;
	    }
	    
		return true;
		}
</script>	

<form name="form1" action="siteoperationControl.action" method="post" onsubmit="return verifyValue();" enctype="multipart/form-data">
<table id=sa-bd width=400>
 <#if (results?exists && results["DM.Reload.SiteGuest.Result"]?exists )>
				<tr>
					<td id=oursite_data width="20%"><span id=sa-title>上传文件</span><br>选择文件
						<input id=oursite_input type="file" name="testFile" value="">
						<input type="hidden" name="DM.Object.upld" value="uploadFile">
						<input type="hidden" name="DM.Instance.upld.uploadFileName" value="testFile">
						<input type="hidden" name="DM.Instance.upld.subdir" value="/${results["DM.Reload.SiteUser.Result"].username}/">
						<input type="hidden" name="DM.Instance.upld.docroot" value="path_userhome">
						<input type="hidden" name="DM.Instance.upld.timeprefix" value="">
						<input type="hidden" name="DM.Instance.SiteGuest.filename" value="@{upld.fileName}">
						<input type="hidden" name="DM.Instance.SiteGuest.filepath" value="@{upld.filepath}">
						<input type="hidden" name="DM.Upload.upld" value="">
						<input type="hidden" name="DM.Update.SiteGuest" value="">
						<input type="hidden" name="DM.Update.SiteGuest.__Depends" value="DM.Upload.upld">
					</td>
				</tr>
			   
				<tr><td align=center>
				<input id=oursite_a type="hidden" name="DM.Instance.SiteGuest.id" value="${results["DM.Reload.SiteGuest.Result"].id}">					
				
				<input id=oursite_input type="submit" name="submit2" value="上传图片">
				 <input  id=oursite_input type="button" name="a" value="返回" onclick="javascript:history.go(-1);">
	
				</td></tr>
</#if> 	
<input type="hidden" name="DM.Object.SiteGuest" value="SiteGuest">
<input type="hidden" name="DM.Reload.SiteUser" value="SiteUser">
<input type="hidden" name="noprefix" value="">	
<input type="hidden" name="DM.Instance.SiteUser.id" value="${results["DM.Reload.SiteUser.Result"].id}">
<input type="hidden" name="DM.Object.SiteUser" value="SiteUser">
<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
<input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/site_guest_admin.ftl">
</table>					
</form>

