<#macro spmpitemaddupdate  nob spmp  varimagealign spmpitem="" >
<link href="/website/css/content.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../edit/fckeditor.js"></script>
<#include "/website/macro/map_language_title.ftl">
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
		  		<td>
		  		
				<@fckeditupdate user=results["DM.Reload.SiteSpmp4.Result"].siteUser  
			                vartxt="DM.Instance.SiteSpmp4Item.title"  
			                title="图片标题"
			                v1=results["DM.Reload.SiteSpmp4Item.Result"].title?if_exists
			                v2=results["DM.Reload.SiteSpmp4Item.Result"].title2?if_exists
			                v3=results["DM.Reload.SiteSpmp4Item.Result"].title3?if_exists
			    />		  		
		  		
		  		
				</td>	
			</tr>	
		 	<tr>
		     <td align=center>
				<input  class=bt type="submit" value="确定"> 
		  	</tr>
		</table>
		<input type="hidden" name="DM.Instance.SiteSpmp${nob}Item.id" value="${spmpitem.id}">			
		<input type="hidden" name="DM.Update.SiteSpmp${nob}Item" value="">
		<input type="hidden" name="DM.Object.SiteSpmp${nob}Item" value="SiteSpmp${nob}Item">
		<input type="hidden" name="DM.Reload.SiteSpmp${nob}" value="SiteSpmp${nob}">	
		  	  
		<input type="hidden" name="lanmutitle" value=${tempvar["lanmutitle"]}>
		   										
		<input type="hidden" name="DM.Instance.SiteSpmp${nob}.id" value="${spmp.id}">
		<input type="hidden" name="DM.Object.SiteSpmp${nob}" value="SiteSpmp${nob}">
		<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
		<input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/site_spmp${nob}_detail.ftl">
		</form>
        </div>
</td>
</tr>
</table>	
</div>
</#macro>
		
<@spmpitemaddupdate nob=4 spmp=results["DM.Reload.SiteSpmp4.Result"]  spmpitem=results["DM.Reload.SiteSpmp4Item.Result"] varimagealign="DM.Instance.SiteSpmp4Item.imagealign"   />
		
		
	
	

