<link href="/website/css/content.css" rel="stylesheet" type="text/css">

<script language="javascript" src="/website/js/site_admin.js"></script>
<#include "/website/macro/map_language_title.ftl">	
<#include "/website/macro/admin_preview.ftl">
<#include "/website/macro/commonfun.ftl">


<#macro modifylanmutitle name title1="" title2="" title3="" info="" >
		     <input size="20" class=input type="text" id="DM.Instance.SiteUser.${name}" name="DM.Instance.SiteUser.${name}" value="${title1?if_exists}">
			 <#if results["DM.Reload.SiteUser.Result"].language2="">
			 <#else>								    
		     <font class=info>[${language_name[results["DM.Reload.SiteUser.Result"].local2]}]</font>：<input size="20" class=input type="text" name="DM.Instance.SiteUser.${name}2" value="${title2?if_exists}">
		     </#if>
		     <#if results["DM.Reload.SiteUser.Result"].language3="">
			 <#else>	
		     <font class=info>[${language_name[results["DM.Reload.SiteUser.Result"].local3]}]</font>：<input size="20" class=input type="text" name="DM.Instance.SiteUser.${name}3" value="${title3?if_exists}">
			 </#if>
</#macro>	

<SCRIPT language="javascript">
		parent.menutree.location="/website/siteadmin!refreshUser.action?showsetting=lanmutitle";
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
<form name="formlanmuadmin" method="post"  target="mainFrame"></form>


<div class="area-edit">
<table id=area-data class="area-data"  cellSpacing="1" width=400>
<tr>
<td class=td-data>
	<div  class="title"><span class=bold >栏目标题设置 </span></span></div>
	<div class="content">
		    <form name="form2" action="siteoperationControl.action" method="post"  >
		 		<#switch tempvar["ftlfilename"]>
	 		    <#case "site_about_admin.ftl"><@modifylanmutitle name="indexLanmu"       title1=results["DM.Reload.SiteUser.Result"].indexLanmu?if_exists  title2=results["DM.Reload.SiteUser.Result"].indexLanmu2?if_exists  title3=results["DM.Reload.SiteUser.Result"].indexLanmu3?if_exists/>
	 		    <#break>
	 		     
	 		 	<#case "site_link_admin.ftl"><@modifylanmutitle name="linkLanmu"     title1=results["DM.Reload.SiteUser.Result"].linkLanmu?if_exists  title2=results["DM.Reload.SiteUser.Result"].linkLanmu2?if_exists  title3=results["DM.Reload.SiteUser.Result"].linkLanmu3?if_exists/>	
				<#break>
				<#case "site_order_design.ftl"><#assign lanmu_id="check"/><@modifylanmutitle name="checkLanmu"   title1=results["DM.Reload.SiteUser.Result"].checkLanmu?if_exists title2=results["DM.Reload.SiteUser.Result"].checkLanmu2?if_exists  title3=results["DM.Reload.SiteUser.Result"].checkLanmu3?if_exists/>			
				<#break>
				<#case "site_job_admin.ftl"><#assign lanmu_id="job"/> <@modifylanmutitle name="jobLanmu"      title1=results["DM.Reload.SiteUser.Result"].jobLanmu?if_exists  title2=results["DM.Reload.SiteUser.Result"].jobLanmu2?if_exists  title3=results["DM.Reload.SiteUser.Result"].jobLanmu3?if_exists/>		
				<#break>
				<#case "site_guest_admin.ftl"><#assign lanmu_id="guest"/><@modifylanmutitle name="guestLanmu"    title1=results["DM.Reload.SiteUser.Result"].guestLanmu?if_exists   title2=results["DM.Reload.SiteUser.Result"].guestLanmu2?if_exists  title3=results["DM.Reload.SiteUser.Result"].guestLanmu3?if_exists />		
				<#break>
				<#case "site_address_admin.ftl"><#assign lanmu_id="address"/><@modifylanmutitle name="addressLanmu"     title1=results["DM.Reload.SiteUser.Result"].addressLanmu?if_exists title2=results["DM.Reload.SiteUser.Result"].addressLanmu2  title3=results["DM.Reload.SiteUser.Result"].addressLanmu3?if_exists/>		
				<#break>
				<#case "site_s1_admin.ftl"><#assign lanmu_id="s1"/><@modifylanmutitle name="s1Lanmu"     title1=results["DM.Reload.SiteUser.Result"].s1Lanmu?if_exists  title2=results["DM.Reload.SiteUser.Result"].s1Lanmu2?if_exists title3=results["DM.Reload.SiteUser.Result"].s1Lanmu3?if_exists/>
			    <#break>				
			    <#case "site_s2_admin.ftl"><#assign lanmu_id="s2"/><@modifylanmutitle name="s2Lanmu"     title1=results["DM.Reload.SiteUser.Result"].s2Lanmu?if_exists  title2=results["DM.Reload.SiteUser.Result"].s2Lanmu2?if_exists title3=results["DM.Reload.SiteUser.Result"].s2Lanmu3?if_exists/>
			    <#break>				
				<#case "site_spmp1_admin.ftl"><#assign lanmu_id="spmp1"/><@modifylanmutitle name="spmp1Lanmu"    title1=results["DM.Reload.SiteUser.Result"].spmp1Lanmu?if_exists  title2=results["DM.Reload.SiteUser.Result"].spmp1Lanmu2?if_exists  title3=results["DM.Reload.SiteUser.Result"].spmp1Lanmu3?if_exists/>		
			    <#break>
			    <#case "site_spmp2_admin.ftl"><#assign lanmu_id="spmp2"/><@modifylanmutitle name="spmp2Lanmu"     title1=results["DM.Reload.SiteUser.Result"].spmp2Lanmu?if_exists  title2=results["DM.Reload.SiteUser.Result"].spmp2Lanmu2?if_exists  title3=results["DM.Reload.SiteUser.Result"].spmp2Lanmu3?if_exists/>		
			    <#break>
			    <#case "site_spmp3_admin.ftl"><#assign lanmu_id="spmp3"/><@modifylanmutitle name="spmp3Lanmu"     title1=results["DM.Reload.SiteUser.Result"].spmp3Lanmu?if_exists  title2=results["DM.Reload.SiteUser.Result"].spmp3Lanmu2?if_exists  title3=results["DM.Reload.SiteUser.Result"].spmp3Lanmu3?if_exists/>		
			    <#break>
			    <#case "site_spmp4_admin.ftl"><#assign lanmu_id="spmp4"/><@modifylanmutitle name="spmp4Lanmu"      title1=results["DM.Reload.SiteUser.Result"].spmp4Lanmu  title2=results["DM.Reload.SiteUser.Result"].spmp4Lanmu2?if_exists  title3=results["DM.Reload.SiteUser.Result"].spmp4Lanmu3?if_exists/>		
			    <#break>
			    <#case "site_spmp5_admin.ftl"><#assign lanmu_id="spmp5"/><@modifylanmutitle name="spmp5Lanmu"    title1=results["DM.Reload.SiteUser.Result"].spmp5Lanmu?if_exists  title2=results["DM.Reload.SiteUser.Result"].spmp5Lanmu2 ?if_exists title3=results["DM.Reload.SiteUser.Result"].spmp5Lanmu3?if_exists/>		
			    <#break>
			  	<#case "site_spmp6_admin.ftl"><#assign lanmu_id="spmp6"/><@modifylanmutitle name="spmp6Lanmu"     title1=results["DM.Reload.SiteUser.Result"].spmp6Lanmu?if_exists  title2=results["DM.Reload.SiteUser.Result"].spmp6Lanmu2?if_exists title3=results["DM.Reload.SiteUser.Result"].spmp6Lanmu3?if_exists/>
			    <#break>				  				  				  
			    <#case "site_spmp7_admin.ftl"><#assign lanmu_id="spmp7"/><@modifylanmutitle name="spmp7Lanmu"    title1=results["DM.Reload.SiteUser.Result"].spmp7Lanmu?if_exists  title2=results["DM.Reload.SiteUser.Result"].spmp7Lanmu2?if_exists title3=results["DM.Reload.SiteUser.Result"].spmp7Lanmu3?if_exists/>
			    <#break>
			    <#case "site_spmp8_admin.ftl"><#assign lanmu_id="spmp8"/><@modifylanmutitle name="spmp8Lanmu"     title1=results["DM.Reload.SiteUser.Result"].spmp8Lanmu?if_exists  title2=results["DM.Reload.SiteUser.Result"].spmp8Lanmu2?if_exists title3=results["DM.Reload.SiteUser.Result"].spmp8Lanmu3?if_exists/>
			    <#break>				  
			  <#default>
			</#switch>
			 <br><br>
			 <p align=center>
		   	         <input class=bt  type="submit"  value="确定"> 
			  </p>       

				<#--设置为显示-->
				<#if lanmu_id?exists> 
				<input type="hidden" name="DM.business.NavEdit" value="">	
				<input type="hidden" name="lanmu_id" value="${lanmu_id}">	
				<input type="hidden" name="op" value="treeshowlanmu">	
				<input type="hidden" name="DM.Reload.SiteUser.__Depends" value="DM.business.NavEdit">
			    </#if>
					
		    			
				<input type="hidden" name="DM.Reload.SiteUser" value="SiteUser">
				<input type="hidden" name="DM.Instance.SiteUser.id" value="${results["DM.Reload.SiteUser.Result"].id}">
			
				<input type="hidden" name="DM.Object.SiteUser" value="SiteUser">
				<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
				<input type="hidden" name="ftlfilename" value="${tempvar["ftlfilename"]}">
				<input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/globe_lanmutitle_null.ftl">
	        </form>
	</div>
	


</td>
</tr>
</table>
</div>


<@preview_iframe "index.ftl" />
</HTML>
