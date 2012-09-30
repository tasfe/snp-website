<#include "top.ftl">
<#include "left.ftl">
<!-------------------------内容变化区----------------------------->
			<script language="javascript" type="text/javascript">
				document.getElementById('hengtiao').innerHTML = '${SiteUser.aboutht?if_exists}';
			</script>
			<td valign=top width=100%>
			   	<div id=div-mid>
			   	        <table style="table-layout:fixed">
			   	            <#if SiteUser.marquee?exists&&SiteUser.marquee?length!=0> 
			                <tr><td id=snp-detail>
			                	<marquee scrollamount="3"><@strbylanguage v1=SiteUser.marquee v2=SiteUser.marquee2?if_exists v3=SiteUser.marquee3?if_exists /></marquee>
			                </td></tr>
			                </#if>   
			                <tr><td><@SiteSingleData classes=SiteUser.siteAbouts/></td></tr>

			            </table>
			     </div>      	   		    		
			</td>	          
<!-------------------------内容变化区----------------------------->		
<#include "right.ftl">			
<#include "bottom.ftl">			



			                <#---
			                <#include "/website/sitetemplateweb/include/move.ftl">
			                
			                <tr><td>
			                    <table>
					                <tr valign="top">
					                    <td width=50% id=snp-detail >
					                            
					                            <@lanmuindex lanmuname=LanmuObject.lanmuindex1  />
					                            <@lanmuindex lanmuname=LanmuObject.lanmuindex2 />
					                            
					                    </td>
					                    <td width=50% id=snp-detail style="padding-left:20px">
					                            
					                            <@lanmuindex lanmuname=LanmuObject.lanmuindex3 />
					                            <@lanmuindex lanmuname=LanmuObject.lanmuindex4 />
					                    </td>		                    
					                </tr>
					            </table>
			                 </td></tr>
			                 -->
			      
