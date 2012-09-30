<#macro fileupdate nob   title   vardetail spmp="">
<link href="/website/css/content.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/common/edit/fckeditor.js"></script>
<#include "/website/macro/commonfun.ftl">
<#include "/website/macro/fckedit.ftl">
<@tt width="600"/>
<div class=title> 文件描述</div>
<form name="form1" action="siteoperationControl.action" method="post"  enctype="multipart/form-data">
<table border="0" cellpadding="0" cellspacing="1" width="600" >

		<tr>
 		<td class=td-data>
 		
					<@fckeditupdate user=results["DM.Reload.SiteUser.Result"]  
						  vartxt="DM.Instance.SiteSpmp${nob}.detail"  
						  title=""
		                  v1=results["DM.Reload.SiteSpmp${nob}.Result"].detail?if_exists
		                  v2=results["DM.Reload.SiteSpmp${nob}.Result"].detail2?if_exists
		                  v3=results["DM.Reload.SiteSpmp${nob}.Result"].detail3?if_exists						  
			/>	
		
			
		<input  id=oursite_input type="hidden" name="DM.Instance.SiteSpmp${nob}.id" value="${results["DM.Reload.SiteSpmp${nob}.Result"].id}">		
		<input  id=oursite_input type="hidden" name="DM.Update.SiteSpmp${nob}" value="">		

		<tr>
			<td  id=oursite_tb_data colspan="2" >
				
			<p align="center">
				<input  class=bt type="submit" value="确定"> 
	            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            <input  class=bt type="button"  value="返回" onclick="javascript:history.go(-1);">
			</p>				
				
			</td>
		</tr>
		</table>
		
		<input type="hidden" name="OT.Token.type" value="apply">
	    <input type="hidden" name="OT.Token.name" value="createnew">
	    <input type="hidden" name="OT.Token.value" value="${results["OT.Token.Result"]}">
	      	  
	                                
	    <input type="hidden" name="DM.Object.SiteSpmp${nob}" value="SiteSpmp${nob}">                                     
		<input type="hidden" name="DM.Object.SiteSpmp${nob}" value="SiteSpmp${nob}">
		<input type="hidden" name="DM.Reload.SiteUser" value="SiteUser">
		<input type="hidden" name="DM.Instance.SiteUser.id" value="${results["DM.Reload.SiteUser.Result"].id}">
		<input type="hidden" name="DM.Object.SiteUser" value="SiteUser">
		<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
		<input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/site_spmp${nob}_admin.ftl">		
</form>

	<@bb/>	
		
		
	


</#macro>		