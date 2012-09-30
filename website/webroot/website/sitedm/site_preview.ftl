<#assign SiteUser=results["DM.Reload.SiteUser.Result"]/>
<#assign LanmuObject=Session["lanmuobject"]/>	  
<#assign lanmutemplete=tempvar["lanmutemplete"]?if_exists/> 
<#assign admin="YES"/>	 
<#assign infomap=results["static"]["com.snp.common.I18n"]/>  
<#assign language=tempvar["language"]?if_exists />	
<#assign local=tempvar["local"]?if_exists />
<#include "/website/macro/commonfun.ftl">	
<#include "/website/macro/map_language_title.ftl">
<#assign infomap=results["static"]["com.snp.common.I18n"]/>
<#assign lanmuname=""/>							
						
<#include "/website/sitetemplateweb/${SiteUser.indexStyle}/${lanmutemplete}">

