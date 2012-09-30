<link href="/website/css/content.css" rel="stylesheet" type="text/css">
<script language="javascript" src="/website/js/site_admin.js"></script>
<#include "/website/macro/commonfun.ftl">
<#assign SiteUser=results["DM.Reload.SiteUser.Result"]/>

<#if results["DM.Reload.SiteSpmp4.Result"]?exists >
	<#assign SiteSpmp4=results["DM.Reload.SiteSpmp4.Result"]/>
</#if>	

<#if results["DM.Reload.SiteSpmp4Sub.Result"]?exists >
	<#assign SiteSpmp4Sub =results["DM.Reload.SiteSpmp4Sub.Result"]/>
</#if>	


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
<form name="form_productlink" action="siteoperationControl.action" method="post"  >
    	
    	
    <input type="hidden" name="DM.Reload.SiteUser" value="SiteUser">
    <input type="hidden" name="DM.Instance.SiteUser.id" value="${results["DM.Reload.SiteUser.Result"].id}">
    <input type="hidden" name="DM.Object.SiteUser" value="SiteUser">
    <input type="hidden" name="OT.Forward.success.Type" value="freemarker">
    <input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/site_spmp4_admin.ftl"> 