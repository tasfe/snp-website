<#include "/website/include/head_js_css.ftl">

	<#if (tempvar["filetype"]=="pic")>
	  	<#assign fliter=Session["clientlogined"].get_img_support_format() />	
	<#else>
	    <#assign fliter="swf" />	
	</#if>
<script language="javascript">
var common_user_reload="resoperationControl.action?OT.Forward.success.Type=freemarker"
                        +"&DM.Reload.SiteUser=&DM.Object.SiteUser=SiteUser"
                        +"&DM.Instance.SiteUser.id=${Session["clientlogined"].id?if_exists}&OT.Forward.success.URL=/website/res/";
	
    function del(id){
        if(confirm("确定要是删除吗")){ }
            var  action=common_user_reload
	                  +"upload_res.ftl"  
	                  +"&DM.business.DeleteFileOnServer="
	                  +"&fileid="+id
	                  +"&fileponame=SitePresource"
	                   +"&filetype=${tempvar["filetype"]}"
	                  +"&DM.Reload.SiteUser._Depends=DM.business.DeleteFileOnServer" ;	  
         	document.getElementById('formlanmuadmin').action =action;
			document.getElementById('formlanmuadmin').submit();
		
	}	
function CheckForm(form) {
     var name = document.uploadPicForm.fileLocation.value;
	if (form.fileLocation.value.length == 0){
		alert("文件地址不能为空");
		form.fileLocation.focus();
		return false;
	}

	
	
	if(/^.+\.(${fliter})$/i.test(name)){
	   	return true;
	}
	
	else{
		uploadPicForm.reset();
		alert("支持的图片文件格式：${Session["clientlogined"].get_img_support_format()?if_exists}");
		return false;
   }
	
	return true;
}		
</script>
<form name="formlanmuadmin" id=formlanmuadmin method="post" target="_self"></form>
<form  name="uploadPicForm" action="resoperationControl.action" method="post" onsubmit="return CheckForm(this)" enctype="multipart/form-data">
<table width=380>    
	<tr>
		<td  style="padding:5px"  valign=top>
			<p id=sa-title>上传本地文件(格式:${fliter})</p>
			<input  class=input type="File" name="fileLocation" size=30 >
	        <input class=bt name="forme_submit" type="submit"  value="确定"> 
	        
         	<p id=sa-title style="padding-top:5px">素材库 <#if results["DM.Reload.SiteUser.Result"].sitePresources?size==0>(请上传图片)</#if></p>
            <p>
           	<table style="width:250px;border: 1px solid #c9d7f1;">
           	<#list results["DM.Reload.SiteUser.Result"].sitePresources as x>
            <tr style="cursor: hand;" onclick="javascript:parent.document.getElementById('txtUrl').value='../../site/${Session["clientlogined"].username?if_exists}/${x.filepath?if_exists}';"  title="点击选择，插入该图片">
            	<td>
            		${x.filename?if_exists} 
				</td>
				<td align=right>
					<a  title="删除资源" onclick="javascript:del(${x.id});"  align=right>删除</a>   
				</td>
			</tr>
			</#list>
			</table>
			</p>
			<#--
           	<select id="select_res"  style="width:250px;border: 1px solid #c9d7f1;"  size="6" onchange="javascript:parent.document.getElementById('txtUrl').value='../../site/${Session["clientlogined"].username?if_exists}/'+this.value;parent.document.getElementById('txtUrl').onblur();">	
			    <#list results["DM.Reload.SiteUser.Result"].sitePresources as x>
			        <#if x.filetype?exists&&tempvar["filetype"]=="pic"&&x.filetype=="pic">
						<option value="${x.filepath?if_exists}">${x.filename?if_exists}</option>
					</#if>			    
			        <#if x.filetype?exists&&tempvar["filetype"]=="swf"&&x.filetype=="swf">
						<option value="${x.filepath?if_exists}">${x.filename?if_exists}</option>
					</#if>
				</#list>
			</select>	
			-->   
			<br><br>
			
        </td>
	</tr>
</table>	
	<input type="hidden" name="DM.Object.upld" value="uploadPicFile"> 
	<input type="hidden" name="DM.Upload.upld" value="">			
	<input type="hidden" name="DM.Instance.upld.uploadFileName" value="fileLocation">	
    <input type="hidden" name="DM.Instance.upld.subdir" value="/${Session["clientlogined"].username}/">

    <input type="hidden" name="DM.Object.SiteUser" value="SiteUser">
	<input type="hidden" name="DM.Reload.SiteUser" value="SiteUser">
  	<input type="hidden" name="DM.Object.SitePresource" value="SitePresource">
    <input type="hidden" name="DM.Instance.SiteUser.id" value="${results["DM.Reload.SiteUser.Result"].id}">
	<input type="hidden" name="DM.Instance.SitePresource.filename" value="@{upld.fileName}">
   	<input type="hidden" name="DM.Instance.SitePresource.SiteUser" value="@{SiteUser}">		
   	<input type="hidden" name="DM.Instance.SitePresource.filetype" value="${tempvar["filetype"]}">
	<input type="hidden" name="DM.Instance.SitePresource.filename" value="@{upld.fileName}">
	<input type="hidden" name="DM.Instance.SitePresource.filepath" value="@{upld.filepath}">	
    <input type="hidden" name="DM.Create.SitePresource" value="">	 
    <input type="hidden" name="filetype" value="${tempvar["filetype"]}">		
    <input type="hidden" name="DM.Create.SitePresource.__Depends" value="DM.Upload.upld">	
	<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
    <input type="hidden" name="OT.Forward.success.URL" value="/website/res/upload_res_result.ftl">					
</form>
