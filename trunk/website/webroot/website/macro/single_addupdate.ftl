<#macro singleaddupdate beanname  title qianzhui  vardetail spmp="">
<#include "/website/include/head_js_css.ftl">
<@tt width=600 /> 
	<div class="title" ><span class=info-big>修改内容</span></div>
	<div class="content" >
	    <table width=600>
			<tr>
				<td>	
				<form name="form" action="siteoperationControl.action" method="post" >
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
							<td >
								<p align="center">
								<input class="bt"  type="submit" value="确定"> 
								
						           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						           <input  class="bt"  type="button"  value="返回" onclick="javascript:history.go(-1);">
								</p>
						<input type="hidden" name="DM.Instance.${beanname}.id" value="${spmp.id}">		
						<input type="hidden" name="DM.Update.${beanname}" value="">				
						<input type="hidden" name="OT.Token.type" value="apply">
					    <input type="hidden" name="OT.Token.name" value="createnew">
					    <input type="hidden" name="OT.Token.value" value="${results["OT.Token.Result"]}">
					    <input type="hidden" name="DM.Object.${beanname}" value="${beanname}">                                     
						<input type="hidden" name="DM.Reload.SiteUser" value="SiteUser">
						<input type="hidden" name="DM.Instance.SiteUser.id" value="${results["DM.Reload.SiteUser.Result"].id}">
						<input type="hidden" name="DM.Object.SiteUser" value="SiteUser">
						<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
						<input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/${qianzhui}_admin.ftl">		
				   </form>
				 </td>
			</tr>
		</table>	
	<div>

<@bb /> 
</#macro>	


		
		
		
	

