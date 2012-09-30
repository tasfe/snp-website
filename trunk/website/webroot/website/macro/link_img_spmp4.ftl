<#macro linkimgspmp4 items title="" productlinkstring="" >	
	
	<link href="/website/css/content.css" rel="stylesheet" type="text/css">
	<script language="javascript" src="/website/js/site_admin.js"></script>
	<#include "/website/macro/commonfun.ftl">
	<#assign SiteUser=results["DM.Reload.SiteUser.Result"]/>
	
	<#if tempvar["language"]?exists >
	    <#assign language=tempvar["language"]?if_exists />	
	<#else>
		<#assign language=results["DM.Reload.SiteUser.Result"].language?if_exists/>	
	</#if>	
	<#if tempvar["local"]?exists >
	    <#assign local=tempvar["local"]?if_exists />
	<#else>
		<#assign local=results["DM.Reload.SiteUser.Result"].local?if_exists/>	
	</#if>	
	
	<br>
	<form name="formlanmuadmin" method="post"  target="mainFrame"></form>
	<form name="form_productlink" action="siteoperationControl.action" method="post"  >
	<span id=sa-title> 
	请选择图片添加到：[${title}]
	</span>
	<table   id=sa-bd  >
	  <#if SiteUser.spmp4Lanmu?exists>
				<tr><td align=center id=oursite_tb_data>
		           <a id=oursite_a href="javascript:form_productlink.submit();">确定</a> 
		           <a id=oursite_a href="javascript:history.go(-1);">返回</a>			       
			  	</td></tr>		  	
			  	<tr><td id=oursite_tb_data>
					   <table >
							<tr>
								<td  align=left id=oursite_tb_data>  	
								<#list SiteUser.siteSpmp4s as x>
						  			 <b><@strbylanguage v1=x.name v2=x.name2?if_exists v3=x.name3?if_exists /></b>
							  			<table>
								            <tr>
									        <#assign i=0/>
											<#assign num=0/>
											<#assign colnum=5/>
									
											   <#list items as x>  
											   <#assign i=i+1/>
											   <td valign=top  style="">
											         <img   id=snp-image width=${x.getImg_spmp4_sm_width()?if_exists} height=${x.getImg_spmp4_sm_height()?if_exists}  src="/site<#if x.filepath?exists>${x.filepath?replace(".", "_sm.")}</#if>" />
													<br><input type="checkbox"   name="productlink"  value="${x.id}"
																<#if productlinkstring?index_of(x.id+',')<0><#else>checked</#if> 
															
													><@strbylanguage v1=x.title v2=x.title2?if_exists v3=x.title3?if_exists />							        		
									          	</td>
										             <#if i<colnum><#--每行的个数-->
													 <#else>
													     <#assign i=0/>
													     <#assign num=num+1/>
													     </tr>
													     <tr>
													  </#if>
												</#list>		
										</table>										 
								</#list>
							    </td>
						    </tr>
						</table>
				</td></tr>
			
	   <#else>
	   </#if>
	        <input type="hidden" name="DM.business.UpdateProductLink" value="">
		    	
		    	
		    <input type="hidden" name="DM.Reload.SiteUser" value="SiteUser">
		    <input type="hidden" name="DM.Instance.SiteUser.id" value="${results["DM.Reload.SiteUser.Result"].id}">
		    <input type="hidden" name="DM.Object.SiteUser" value="SiteUser">
		    <input type="hidden" name="OT.Forward.success.Type" value="freemarker">
		    <input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/site_spmp4_admin.ftl"> 
	</table>
</#macro>			