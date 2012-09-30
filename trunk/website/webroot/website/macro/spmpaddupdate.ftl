
<#macro spmpaddupdate nob  title  varimagealign  varname vardetail spmp="">
<link href="/website/css/content.css" rel="stylesheet" type="text/css">

<script language="javaScript" src="/other/jquery151/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="../edit/fckeditor.js"></script>
<script language="javascript" src="/website/js/site_admin.js"></script>
<#include "/website/macro/commonfun.ftl">
<#include "/website/macro/fckedit.ftl">
<div class="area-edit">
<table width="600" >
<tr>
<td>

	<div class="title" ><span class=info-big>修改内容</span><@quickedit/></div>
	<div class="content" >
		<form name="form1" action="siteoperationControl.action" method="post" >
		<table width="700" >
	
	
		 	<tr>
		 	<td  id=sa-bd>
		 	 <@fckeditupdate user=results["DM.Reload.SiteUser.Result"] 
			                  vartxt=varname  title=""
			                  v1=spmp.name?if_exists v2=spmp.name2?if_exists v3=spmp.name3?if_exists model="simple"/>						
		 	  <@fckeditupdate user=results["DM.Reload.SiteUser.Result"]  
				                vartxt=vardetail
				                title=""
				                v1=spmp.detail?if_exists
				                v2=spmp.detail2?if_exists
				                v3=spmp.detail3?if_exists
				/>						
		 	</td>
		 	</tr>		 	
			
			<tr>
			<td class=admin>
				<p align="center">
					<input  class=bt type="submit" value="确定"> 
		      	</p>
			</td>
			</tr>
			</table>
			<input   type="hidden" name="DM.Instance.SiteSpmp${nob}.id" value="${spmp.id}">		
			<input   type="hidden" name="previewid" value="${spmp.id}">		
			<input  type="hidden" name="DM.Update.SiteSpmp${nob}" value="">	
			<input type="hidden" name="OT.Token.type" value="apply">
		    <input type="hidden" name="OT.Token.name" value="createnew">
		    <input type="hidden" name="OT.Token.value" value="${results["OT.Token.Result"]}">
		      	  
		                                
		    <input type="hidden" name="DM.Object.SiteSpmp${nob}" value="SiteSpmp${nob}">                                     
			<input type="hidden" name="DM.Reload.SiteUser" value="SiteUser">
			<input type="hidden" name="DM.Instance.SiteUser.id" value="${results["DM.Reload.SiteUser.Result"].id}">
			<input type="hidden" name="DM.Object.SiteUser" value="SiteUser">
			<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
			<input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/site_spmp${nob}_admin.ftl">		
		</form>
		
	</div>
</td>
</tr>
</table>	
</div>
</#macro>	

		
		
		
	

