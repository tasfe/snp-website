<#macro fileuploadfielitem  beanname qianzhui  spmpitem  spmpid>
<#include "/website/macro/commonfun.ftl">
<link href="/website/css/content.css" rel="stylesheet" type="text/css">
<form  name="uploadPicForm" action="siteoperationControl.action" method="post" onsubmit="" enctype="multipart/form-data">
<@tt width="500"/>
<p class=title>文件替换</p>
<table  width="500" >
	<tr>
		<td class=td-data>
		   <br>
		   <input class=input type="File" name="fileLocation" size=30 >
		   <br><br>
		   <p align=center>
		   <input  class=bt type="submit"  value="确定"> 
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           <input  class=bt type="button"  value="返回" onclick="javascript:history.go(-1);">
           <br><br>
           </p>
		</td>
	</tr>
</table>	
	 	
		
	<input type="hidden" name="DM.Object.upld" value="uploadFile">
	<input type="hidden" name="DM.Upload.upld" value="">			
	<input type="hidden" name="DM.Instance.upld.uploadFileName" value="fileLocation">	
	<input type="hidden" name="DM.Instance.upld.subdir" value="/${Session["clientlogined"].username}/">
	<input type="hidden" name="DM.Reload.SiteUser" value="SiteUser">
	<input type="hidden" name="DM.Instance.SiteUser.id" value="${Session["clientlogined"].id}">
	<input type="hidden" name="DM.Object.SiteUser" value="SiteUser">
	<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
	<input type="hidden" name="DM.Instance.${beanname}Item.filepath" value="@{upld.saveFolder}">
	<input type="hidden" name="DM.Instance.${beanname}Item.filename" value="@{upld.fileName}">
	<input type="hidden" name="DM.Instance.${beanname}Item.id" value="${spmpitem.id}">
	<input type="hidden" name="DM.Update.${beanname}Item" value="">
	<input type="hidden" name="DM.Update.${beanname}Item.__Depends" value="DM.Upload.upld">
	<input type="hidden" name="DM.Query.${beanname}Item.__Depends" value="DM.Update.${beanname}Item">	
	<input type="hidden" name="DM.Object.${beanname}Item" value="${beanname}Item">
	<input type="hidden" name="DM.Instance.${beanname}Item.updatedate" value="@{System:date}">
	<input type="hidden" name="DM.Object.${beanname}" value="${beanname}">
	<input type="hidden" name="DM.Reload.${beanname}" value="">
	<input type="hidden" name="DM.Instance.${beanname}.id" value="${spmpid}">	
	<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
	<input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/site_${qianzhui}_detail.ftl">
	
</form>
<@bb/>
</#macro>		