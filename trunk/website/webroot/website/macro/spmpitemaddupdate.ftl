<#macro spmpitemaddupdate  nob spmp  varimagealign spmpitem="" >
<#include "/website/include/head_js_css.ftl">

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
		  		   	<#if nob!=9 >
		  		    <@fckeditupdate user=Session["clientlogined"]  
					                  vartxt="DM.Instance.SiteSpmp${nob}Item.title"  title="章节标题"
					                  v1=spmpitem.title?if_exists v2=spmpitem.title2?if_exists v3=spmpitem.title3?if_exists model="simple"/>		 		
		  		   	</#if>  
					<@fckeditupdate user=Session["clientlogined"] 
					                vartxt="DM.Instance.SiteSpmp${nob}Item.detail"  
					                title="章节内容"
					                v1=spmpitem.detail?if_exists
					                v2=spmpitem.detail2?if_exists
					                v3=spmpitem.detail3?if_exists
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
		
		
		
	

