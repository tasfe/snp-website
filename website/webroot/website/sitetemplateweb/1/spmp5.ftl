<#include "top.ftl">
<#include "left.ftl">
<!-------------------------内容变化区----------------------------->

	<td valign=top width=100%>
	 	<div id=div-mid>
	 	 	<table style="table-layout:fixed">
		 	    <tr>
		 	     	<td>

				 	    <#assign data=SiteUser.siteSpmp5s />	  
					
								<table style="table-layout: fixed" width=100%> 
								<#list data as x>
									<tr>
										<td id=snp-detail colspan=2>
								   	 		<@strbylanguage v1=x.detail?if_exists v2=x.detail2?if_exists v3=x.detail3?if_exists />	
										</td> 
									</tr>
								    <#list x.getSubItems() as y>
										<#if y.filename?exists >
											<tr>
											    <td id=snp-detail align=left  style="padding-left: 16px;">
											        <#if y.detail?exists&&y.detail!=""><@strbylanguage v1=y.detail v2=y.detail2?if_exists v3=y.detail3?if_exists /><#else>${y.filename?if_exists}</#if>						      	
											     </td>
											    <td width=150> 	
											      	<a id=snp-detail href="filedownload!filedown_lanmu.action?fileid=${y.id?if_exists}&userid=${x.siteUser.id?if_exists}" target=_blank>
												        &nbsp;&nbsp;&nbsp;[下载]
												    </a>	
											      	<a id=snp-detail href="../../site/${x.siteUser.username?if_exists}/${y.filepath?if_exists}" target=_blank>
												        &nbsp;&nbsp;&nbsp;[浏览]
												    </a>							    
											    </td>
											</tr>                   
										<#else>
											<tr>
											    <td id=snp-detail align=left  colspan=2>
								                    <@strbylanguage v1=y.detail?if_exists v2=y.detail2?if_exists v3=y.detail3?if_exists />
												</td>
											</tr>										    
										</#if>				   
								    </#list>
								</#list>	
								</table>		
						   				 	    
				 	     
			    	</td>
			    </tr>
		    </table>
	    </div>
	</td>
<!-------------------------内容变化区----------------------------->			
<#include "bottom.ftl">			
			      
