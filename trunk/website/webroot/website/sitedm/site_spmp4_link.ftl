<#include "/website/include/img_op.ftl">
<@tt width="700"/>
	<div  class="title"><span class=bold> 选择图片关联到下面相册目录中显示：[${results["DM.Reload.SiteSpmp4.Result"].name?if_exists}]</span>
	</div>
   <div class="content">
   	   <p align=center>
	       	<input class="bt"  type="button" onclick="javascript:form_productlink.submit();" value="确定"> 
			<input class="bt"  type="button"  value="返回" onclick="javascript:history.go(-1);">	
	   </p>
	   <table>
			<tr>
				<td  align=left id=oursite_tb_data>  	
				<#list SiteUser.siteSpmp4s as x>
				<#if results["DM.Reload.SiteSpmp4.Result"].name==x.name><#--每行的个数-->
			    <#else>
				
				     <br>
	  			 <span class=title><@strbylanguage v1=x.name v2=x.name2?if_exists v3=x.name3?if_exists /></span>
		  			<table>
			            <tr>
				        <#assign i=0/>
						<#assign num=0/>
						<#assign colnum=6/>
						<#assign items=x.siteSpmp4Items/>
						   <#list items as x>  
						   <#assign i=i+1/>
						   <td valign=top >
						       <span>
		 							<img  class=img-list width="100" height="120"  src="/site/${Session["clientlogined"].username?if_exists}/<#if x.filepath?exists>${x.filepath?replace(".", "_sm.")}</#if>" />
									<br>
									<input type="checkbox"   name="productlink"  value="${x.id}"
											<#if  results["DM.Reload.SiteSpmp4.Result"].productlinkstring?exists>
												<#if results["DM.Reload.SiteSpmp4.Result"].productlinkstring?index_of(x.id+',')<0><#else>checked</#if> 
											<#else>
											</#if>
									><br><@strbylanguage v1=x.title v2=x.title2?if_exists v3=x.title3?if_exists />					
								</span>						        		
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
					</#if>										 
				</#list>
		    <input type="hidden" name="spmp4id" value="${tempvar["spmp4id"]}">
		    <input type="hidden" name="flag" value="spmp4">
	        <input type="hidden" name="DM.business.UpdateProductLink" value="">

	</form>
	</table>
</div>
<@bb/>