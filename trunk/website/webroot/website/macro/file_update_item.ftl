<#macro fileupdateitem beanname qianzhui  spmp  spmpitem="" >
<link href="/website/css/content.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/common/edit/fckeditor.js"></script>
<#include "/website/macro/fckedit.ftl">
<#include "/website/macro/commonfun.ftl">

<form name="form1" action="siteoperationControl.action" method="post"  enctype="multipart/form-data">
<@tt width="600"/>
<#if (results?exists && results["DM.Reload.${beanname}Item.Result"]?exists )>
	 <div class=title>修改</div>	
		<div class=content>
		<table   style="width:590px" >	
		    <tr>
			   <td>
				  
				<@fckeditupdate user=results["DM.Reload.${beanname}.Result"].siteUser  
				                vartxt="DM.Instance.${beanname}Item.detail"  
				                title=""
				                v1=results["DM.Reload.${beanname}Item.Result"].detail?if_exists
				                v2=results["DM.Reload.${beanname}Item.Result"].detail2?if_exists
				                v3=results["DM.Reload.${beanname}Item.Result"].detail3?if_exists
				/>			
				</td>
			</tr>	
		    <tr>
			   <td class=td-data>
				
				
				 <p align=center>
						<input  class=bt type="submit" value="确定"> 
			           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			           <input  class=bt type="button"  value="返回" onclick="javascript:history.go(-1);">	        
				 </p>	
				
				</td>
					
			</tr>				
		</table>	
		</div>
	<input type="hidden" name="DM.Instance.${beanname}Item.id" value="${results["DM.Reload.${beanname}Item.Result"].id}">
 
	<input type="hidden" name="DM.Update.${beanname}Item" value="">
	
<#else>
	
			<div class=title>上传文件</div>	
	<div class=content>
		 
		   <br><input  class=input type="File" name="fileLocation" size=40 >
				<input  class=bt type="submit" value="确定"> 
	           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	           <input  class=bt type="button"  value="返回" onclick="javascript:history.go(-1);">	         </td>
	</div>		
		
	   
	<input type="hidden" name="DM.Object.upld" value="uploadPicFile">
	<input type="hidden" name="DM.Upload.upld" value="">			
	<input type="hidden" name="DM.Instance.upld.uploadFileName" value="fileLocation">	
	<input type="hidden" name="DM.Instance.upld.subdir" value="/${Session["clientlogined"].username}/">
	<input type="hidden" name="DM.Instance.upld.docroot" value="path_userhome">	
	<input type="hidden" name="DM.Create.${beanname}Item" value="">
	<input type="hidden" name="DM.Instance.${beanname}Item.filepath" value="@{upld.saveFolder}">
	<input type="hidden" name="DM.Instance.${beanname}Item.filename" value="@{upld.fileName}">	
	<input type="hidden" name="DM.Instance.${beanname}Item.${beanname}" value="@{${beanname}}">
	<input type="hidden" name="DM.Create.${beanname}Item.__Depends" value="DM.Upload.upld">	
	<input type="hidden" name="DM.Reload.${beanname}.__Depends" value="DM.Create.${beanname}Item">
	
	
</#if>		
		<input type="hidden" name="DM.Reload.SiteUser" value="SiteUser">  
		<input type="hidden" name="DM.Instance.SiteUser.id" value="${Session["clientlogined"].id?if_exists}">
		<input type="hidden" name="DM.Object.SiteUser" value="SiteUser">
	    <input type="hidden" name="DM.Instance.${beanname}Item.updatedate" value="@{System:date}">
		<input type="hidden" name="DM.Object.${beanname}Item" value="${beanname}Item">
		<input type="hidden" name="DM.Reload.${beanname}" value="${beanname}">	
	      	  
	       										
		<input type="hidden" name="DM.Instance.${beanname}.id" value="${results["DM.Reload.${beanname}.Result"].id}">
		<input type="hidden" name="DM.Object.${beanname}" value="${beanname}">
		<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
		<input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/site_${qianzhui}_detail.ftl">
	
</table>
				

</form>

<@bb/>

</#macro>		