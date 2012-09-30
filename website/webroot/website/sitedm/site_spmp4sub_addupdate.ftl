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
<#if (results?exists && results["DM.Reload.SiteSpmp4Sub.Result"]?exists )>
<form name="form1" action="siteoperationControl.action" method="post" onsubmit="return verifyValue();" enctype="multipart/form-data">

			<input class=admin type="hidden" name="DM.Instance.SiteSpmp4Sub.id" value="${results["DM.Reload.SiteSpmp4Sub.Result"].id}">
			<tr>
			<td id=oursite_tb_data>
					 		<font color="#CC3300"><br><b>[&nbsp;${results["DM.Reload.SiteSpmp4.Result"].name?if_exists}内容修改&nbsp;]</b></font>
				
			</td>
			</tr>
           
           
				
            <tr>
            <td id=oursite_tb_data>
			<@fckeditupdate user=results["DM.Reload.SiteSpmp4.Result"].siteUser  
			                vartxt="DM.Instance.SiteSpmp4Sub.title"  
			               title="图片描述"
			                v1=results["DM.Reload.SiteSpmp4Sub.Result"].title?if_exists
			                v2=results["DM.Reload.SiteSpmp4Sub.Result"].title2?if_exists
			                v3=results["DM.Reload.SiteSpmp4Sub.Result"].title3?if_exists
			                
			/>	
			</td>	
			</tr>	
			<tr>
				<td id=oursite_tb_data colspan="2" >
				   <p align="center">
					<a id=oursite_a href="javascript:form1.submit();">确定</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a id=oursite_a href="javascript:history.go(-1);">返回</a>
				   </p>
				</td>
			</tr>
 
    <#--名称结束-->				
	<input type="hidden" name="DM.Update.SiteSpmp4Sub" value="">
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
                
		   <br>图片标题<span id=sa-lg>[${language_name[Session["clientlogined"].local]}]</span>:<input id=oursite_input type="text" size="50" value=""   name="DM.Instance.SiteSpmp4Sub.title">
			<#if Session["clientlogined"].language2="" >
		    <#else>
			<br>图片标题<span id=sa-lg>[${language_name[Session["clientlogined"].local2]}]</span>
			<input id=oursite_input type="text" size="50" value=""  name="DM.Instance.SiteSpmp4Sub.title2">&nbsp;<font color="red">*</font>
			</#if>			   
     	    <#if Session["clientlogined"].language3="">
		    <#else>
			<br>图片标题<span id=sa-lg>[${language_name[Session["clientlogined"].local3]}]</span>
			<input id=oursite_input type="text" size="50" value=""  name="DM.Instance.SiteSpmp4Sub.title3">&nbsp;<font color="red">*</font>
			</#if>		   
	       
			<br>宽:<input  id=oursite_input type="txt" size="10" name="DM.Instance.upld.width" value="800">
			高:<input  id=oursite_input type="txt" size="10" name="DM.Instance.upld.height" value="600">		
			
 <input type="hidden" name="DM.Instance.SiteSpmp4Sub.sortstr" value="0">
			<input type="hidden" name="DM.Object.upld" value="uploadPicFile">
			<input type="hidden" name="DM.Upload.upld" value="">			
			<input type="hidden" name="DM.Instance.upld.uploadFileName" value="fileLocation">	
			<input type="hidden" name="DM.Instance.upld.subdir" value="/${results["DM.Reload.SiteSpmp4.Result"].siteUser.username}/">
			<input type="hidden" name="DM.Instance.upld.docroot" value="path_userhome">
			<input type="hidden" name="DM.Instance.upld.smallpic" value="yes">
			<input type="hidden" name="DM.Instance.SiteSpmp4Sub.filepath" value="@{upld.filepath}">
			<input type="hidden" name="DM.Instance.SiteSpmp4Sub.filename" value="@{upld.fileName}">
			<input type="hidden" name="DM.Instance.SiteSpmp4Sub.width" value="@{upld.width}">
			<input type="hidden" name="DM.Instance.SiteSpmp4Sub.height" value="@{upld.height}">
			<input type="hidden" name="DM.Create.SiteSpmp4Sub.__Depends" value="DM.Upload.upld">
			<input type="hidden" name="DM.Object.SiteSpmp4" value="SiteSpmp4">
			<input type="hidden" name="DM.Reload.SiteSpmp4" value="">
				    
		    </td>
		    </tr>
			<input type="hidden" name="DM.Reload.SiteSpmp4.__Depends" value="DM.Create.SiteSpmp4Sub">
			<input type="hidden" name="DM.Create.SiteSpmp4Sub" value="">
			<input type="hidden" name="DM.Instance.SiteSpmp4Sub.SiteSpmp4" value="@{SiteSpmp4}">
			
			<tr>
				<td id=oursite_tb_data colspan="2" >
				   <p align="center">
					<input  id=oursite_input type="submit" name="submit2"  value=确定> 
					<input id=oursite_input type="button" name="a" value="返回" onclick="javascript:history.go(-1);">
					
					
				   </p>
				</td>
			</tr>


			
			
</#if>		
<#--2.add操作结束-->
</table>
					<input type="hidden" name="DM.Object.SiteSpmp4Sub" value="SiteSpmp4Sub">
					<input type="hidden" name="DM.Reload.SiteSpmp4" value="SiteSpmp4">	
				      	  
				       										
					<input type="hidden" name="DM.Instance.SiteSpmp4.id" value="${results["DM.Reload.SiteSpmp4.Result"].id}">
					<input type="hidden" name="DM.Object.SiteSpmp4" value="SiteSpmp4">
					<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
					<input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/site_spmp4_detail.ftl">

</form>
</div>

		
		
		
	

