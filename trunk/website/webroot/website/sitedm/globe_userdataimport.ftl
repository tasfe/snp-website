<link href="/website/css/content.css" rel="stylesheet" type="text/css">

  
<script language="javascript" src="/website/js/site_admin.js"></script>
<#include "/website/macro/map_language_title.ftl">	
<#include "/website/macro/admin_preview.ftl">
<#include "/website/macro/commonfun.ftl">
<#include "/website/macro/fckedit.ftl">

<script language="javascript">
		parent.menutree.location="siteadmin!refreshUser.action";
	 	<#if tempvar["language"]?exists >
		    <#assign language=tempvar["language"]?if_exists />	<#--默认语言，写在PO里面不合理还是adoOperation-->
		<#else>
			<#assign language=results["DM.Reload.SiteUser.Result"].language?if_exists/>	
		</#if>	
	 	<#if tempvar["local"]?exists >
	 	    <#assign local=tempvar["local"]?if_exists />
		<#else>
			<#assign local=results["DM.Reload.SiteUser.Result"].local?if_exists/>	
		</#if>	
</script>
<body style="background: #fff;">

<@preview_iframe "index.ftl" />
</body>
</HTML>
