
<#include "top.ftl">
<!-------------------------内容变化区----------------------------->
 <td  valign=top>
<!--leftbegin--> 
 <#if lanmuname=="spmp4"&&SiteUser.getSiteSpmp4s()?size==1><#--每行的个数-->

 <#else>
   <div  id="div-dir"  style="width:220px"> 
    <ul id="navlist">
 	    <@lanmudirleft  lanmuname=lanmuname title=SiteSpmp.getTitle()?if_exists title1=SiteSpmp.getTitle1()?if_exists title2=SiteSpmp.siteUser.getTitle2()?if_exists  items=SiteSpmp.getAllItems()  cssStyle=SiteUser.cssStyle?number    />
    </ul>
	</div>   
  </#if>

<!--leftend-->     
</td>
<td valign=top width=100%>
 	<div id=div-mid>
	<div class="highslide-gallery">
		<table  align=left  style="text-align:left;table-layout: fixed">
	        <#assign i=0/>
			<#assign num=0/>
			<#assign colnum=4/>
		    <tr>
		        <td colspan=${colnum}>
	   			    <span id=snp-listclasses-title >
	                <@strbylanguage v1=SiteSpmp.name?if_exists v2=SiteSpmp.name2?if_exists v3=SiteSpmp.name3?if_exists />
	            <#assign items=SiteSpmp.getPoductLinklist()/>
		   
	       <#--
	        <#if subid=="">
	            <#assign items=SiteSpmp.getPoductLinklist()/>
		    <#else>
		        ${ results["subitem"].title?if_exists }
		   		<#assign items=SiteSpmp.getSubPoductLinklist(subid)/>
		    </#if>  
	         -->  
	             	</span>	
		            <p id=snp-detail><@strbylanguage v1=SiteSpmp.detail?if_exists v2=SiteSpmp.detail2?if_exists v3=SiteSpmp.detail3?if_exists /></p>
		       </td>
	        </tr>
		    <tr>
			   <#list items as x>  
			   <#assign i=i+1/>
			   <td valign=top    style="text-align:left;">
	        	   	<a href="../../site/${SiteUser.username}/${x.filepath}" class="highslide" onclick="return hs.expand(this)">
					<img  src="../../site/${SiteUser.username}/<#if x.filepath?exists>${x.filepath?replace(".", "_sm.")}</#if>" alt="Highslide JS"
					title="Click to enlarge" />
					</a>
  			        <p style="text-align:left"> <@strbylanguage v1=x.title v2=x.title2?if_exists v3=x.title3?if_exists /> </p>					
					<div class="highslide-caption">
						${x.title}
						<p>
						<@strbylanguage v1=x.getSiteSpmp4().getCommon() v2=x.getSiteSpmp4().getCommon2()?if_exists v3=x.getSiteSpmp4().getCommon3()?if_exists />
						</p>						
						<p>
						${x.getSiteSpmp4().getSiteUser().getSpmp4common()?if_exists}
						</p>
						<@SiteSingleData classes=x.siteProducts/>
					</div>
			   </td>
		             <#if i<colnum><#--每行的个数-->
					 <#else>
					     <#assign i=0/>
					     <#assign num=num+1/>
				         </tr>
					     <tr>
					  </#if>
				</#list>
			 </tr>											
	    </table>
	</div>	 	
	</div>
</td>
<!-------------------------内容变化区----------------------------->			
<#include "bottom.ftl">			
			      
