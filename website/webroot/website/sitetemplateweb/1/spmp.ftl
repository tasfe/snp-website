<#include "top.ftl">
<!-------------------------内容变化区----------------------------->
	<td  valign=top>
	    <!--leftbegin--> 
	    <div  id="div-dir" style="width:220px"> 
	        <#---
	        <ul id="navlist">
	 	      <@lanmudirleft  lanmuname=lanmuname title=SiteSpmp.getTitle()?if_exists title1=SiteSpmp.getTitle1()?if_exists title2=SiteSpmp.siteUser.getTitle2()?if_exists  items=SiteSpmp.getAllItems()   op="detail" id=SiteSpmp.id  />
	        </ul>
	        -->
	        
	        <div id="navlist">
	          <@lanmudirleft lanmuname=lanmuname title=SiteSpmp.getTitle()?if_exists title1=SiteSpmp.getTitle1()?if_exists title2=SiteSpmp.siteUser.getTitle2()?if_exists  items=SiteSpmp.getAllItems() cssStyle=SiteUser.cssStyle?number   />
	        
	        </div>
	    </div>
	    <!--leftend-->     
	</td>
	<td valign=top width=100%>
	 	<div id=div-mid>
	 	 	<table style="table-layout:fixed">
		 	    <tr>
		 	     	<td>
				 	    <p id=snp-listclasses-title><@strbylanguage v1=SiteSpmp.name v2=SiteSpmp.name2?if_exists v3=SiteSpmp.name3?if_exists />	</p>
				 	     <span id=snp-detail><@strbylanguage v1=SiteSpmp.detail v2=SiteSpmp.detail2?if_exists v3=SiteSpmp.detail3?if_exists /></span>
					     <@SiteSingleData classes=SiteSpmp.getSubItems()/>
			    	</td>
			    </tr>
		    </table>
	    </div>
	</td>
<!-------------------------内容变化区----------------------------->			
<#include "bottom.ftl">			
			      
