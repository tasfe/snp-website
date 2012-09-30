<link href="/website/css/content.css" rel="stylesheet" type="text/css">

 
<script type="text/javascript" src="../edit/fckeditor.js"></script>
<#include "/website/macro/commonfun.ftl">
<#include "/website/macro/fckedit.ftl">
<script language="javascript">
        function verifyValue(){	
			return true;
		}
</script>


<div class="div">
<table width="700">
<#--1.更新操作开始-->
<#if (results?exists && results["DM.Reload.SiteSpmp4Item.Result"]?exists )>
<form name="form1" action="siteoperationControl.action" method="post" onsubmit="return verifyValue();" enctype="multipart/form-data">

			<input class=admin type="hidden" name="DM.Instance.SiteSpmp4Item.id" value="${results["DM.Reload.SiteSpmp4Item.Result"].id}">
			<tr>
			<td id=oursite_tb_data>
					 		<font color="#CC3300"><br><b>[&nbsp;'${results["DM.Reload.SiteSpmp4Item.Result"].title?if_exists}'内容修改&nbsp;]</b></font>
				
			</td>
			</tr>
           
           
				
            <tr>
            <td id=oursite_tb_data>
			<@fckeditupdate user=results["DM.Reload.SiteSpmp4.Result"].siteUser  
			                vartxt="DM.Instance.SiteSpmp4Item.detail"  
			                title="图片标题"
			                v1=results["DM.Reload.SiteSpmp4Item.Result"].detail?if_exists
			                v2=results["DM.Reload.SiteSpmp4Item.Result"].detail2?if_exists
			                v3=results["DM.Reload.SiteSpmp4Item.Result"].detail3?if_exists
			                
			/>	
			</td>	
			</tr>	
			<tr>
				<td id=oursite_tb_data colspan="2" >
				   <p align="center">
					<a class=bt href="javascript:form1.submit();">确定</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a class=bt href="javascript:history.go(-1);">返回</a>
				   </p>
				</td>
			</tr>
 
    <#--名称结束-->				
	<input type="hidden" name="DM.Update.SiteSpmp4Item" value="">
<#--1.update操作结束-->
<#--2.add操作开始-->
<#else>

		 	<tr>
		 	<td id=oursite_tb_data>
		 	<b><font color="#CC3300"><br><b>[&nbsp;"${results["DM.Reload.SiteSpmp4.Result"].name?if_exists}&nbsp;]</b></font>
			</td>
			</tr>
			
		    <tr>
		    <td id=oursite_tb_data>
			<#include "/website/include/uploadpicfile.ftl">
 		    <input id=oursite_input type="hidden" size="50" value="@{upld.fileName}"   name="DM.Instance.SiteSpmp4Item.title">
			<input id=oursite_input type="hidden" size="50" value="@{upld.fileName}"   name="DM.Instance.SiteSpmp4Item.title2">
			<input id=oursite_input type="hidden" size="50" value="@{upld.fileName}"   name="DM.Instance.SiteSpmp4Item.title3">
			
          <input type="hidden" name="DM.Instance.SiteSpmp4Item.sortstr" value="0">
			<input type="hidden" name="DM.Object.upld" value="uploadPicFile">
			<input type="hidden" name="DM.Upload.upld" value="">			
			<input type="hidden" name="DM.Instance.upld.uploadFileName" value="fileLocation">	
			<input type="hidden" name="DM.Instance.upld.subdir" value="/${results["DM.Reload.SiteSpmp4.Result"].siteUser.username}/">
			<input type="hidden" name="DM.Instance.upld.docroot" value="path_userhome">
			<input type="hidden" name="DM.Instance.upld.smallpic" value="yes">
			<input type="hidden" name="DM.Instance.SiteSpmp4Item.filepath" value="@{upld.filepath}">
			<input type="hidden" name="DM.Instance.SiteSpmp4Item.filename" value="@{upld.fileName}">
			<input type="hidden" name="DM.Instance.SiteSpmp4Item.width" value="@{upld.width}">
			<input type="hidden" name="DM.Instance.SiteSpmp4Item.height" value="@{upld.height}">
			<input type="hidden" name="DM.Create.SiteSpmp4Item.__Depends" value="DM.Upload.upld">
			<input type="hidden" name="DM.Object.SiteSpmp4" value="SiteSpmp4">
			<input type="hidden" name="DM.Reload.SiteSpmp4" value="">
				<input type="hidden" name="DM.Reload.SiteSpmp4.__Depends" value="DM.Create.SiteSpmp4Item">
			<input type="hidden" name="DM.Create.SiteSpmp4Item" value="">
			<input type="hidden" name="DM.Instance.SiteSpmp4Item.SiteSpmp4" value="@{SiteSpmp4}">	    
		    </td>
		    </tr>
		
			
			


			
			
</#if>		
<#--2.add操作结束-->
</table>
					<input type="hidden" name="DM.Object.SiteSpmp4Item" value="SiteSpmp4Item">
					<input type="hidden" name="DM.Reload.SiteSpmp4" value="SiteSpmp4">	
				      	  
				       										
					<input type="hidden" name="DM.Instance.SiteSpmp4.id" value="${results["DM.Reload.SiteSpmp4.Result"].id}">
					<input type="hidden" name="DM.Object.SiteSpmp4" value="SiteSpmp4">
					<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
					<input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/site_spmp4_detail.ftl">

</form>
</div>

		
		
		
	

