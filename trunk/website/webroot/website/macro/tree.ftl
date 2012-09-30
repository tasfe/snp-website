<#macro lmmenu  lanmuname  ftlfilename titlediv=""  lanmutitle="" hreftitle="" >
	<#assign op="treeshowlanmu"/>
	<#assign imgfilename="edit.gif"/>

	<#switch ftlfilename>
		<#case "site_spmp5_admin.ftl"><#assign lanmu_id="spmp5"/><#assign imgfilename="arrowthickstop-1-s"/><#break>
		<#case "site_guest_admin.ftl"><#assign lanmu_id="guest"/><#assign imgfilename="comment"/><#assign info="留言板"/> <#break>
		<#case "site_spmp8_admin.ftl"><#assign lanmu_id="spmp8"/><#assign imgfilename="video"/><#break>
		<#case "site_spmp4_admin.ftl"><#assign lanmu_id="spmp4"/><#assign op="setdir"/><#assign imgfilename="image"/><#break>
		<#case "site_address_admin.ftl"><#assign lanmu_id="address"/><#assign imgfilename="document"/><#break>
		<#case "site_job_admin.ftl"><#assign lanmu_id="job"/> <#assign imgfilename="document"/><#break>
		<#case "site_s1_admin.ftl"><#assign lanmu_id="s1"/><#assign imgfilename="document"/><#break>
		<#case "site_s2_admin.ftl"><#assign lanmu_id="s2"/><#assign imgfilename="document"/><#break>
		<#case "site_spmp1_admin.ftl"><#assign lanmu_id="spmp1"/><#assign imgfilename="folder-open"/><#break>					  
        <#case "site_spmp2_admin.ftl"><#assign lanmu_id="spmp2"/><#assign imgfilename="folder-open"/><#break>
        <#case "site_spmp3_admin.ftl"><#assign lanmu_id="spmp3"/><#assign imgfilename="folder-open"/><#break>
        <#case "site_spmp6_admin.ftl"><#assign lanmu_id="spmp6"/><#assign imgfilename="folder-open"/><#break>
		<#default>
	</#switch>		 				
	<#if lanmuname=""> 
	<#else> 
	    <#--
		<a  href = "javaScript:singlanmutitleeidt(${Session["clientlogined"].id},'globe_lanmutitle_null.ftl','1','${Session["clientlogined"].local}','${ftlfilename}');"  > </a>
		-->
			
	

		<p style="padding:5px 0px 5px 0px;"/>
			<span  style="cursor: none;"  class="snp-icon ui-icon-${imgfilename}"></span>
				<a  href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'${ftlfilename}','1','${Session["clientlogined"].local}');">
			${lanmuname}
		</a>
		</p>
	</#if>
		
</#macro>	
