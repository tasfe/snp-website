<#include "/website/include/head_js_css.ftl">
<#include "/website/macro/tree.ftl">
<SCRIPT language="javascript">
	$(document).ready(function()
	{
		$('#link').qtip({
			content: '网站顶部或者增加文章链接<br>例如：版权声明',
			<#include "/website/include/qtip.ftl">
		});	
		$('#top').qtip({
			content: '网站顶部的内容<br>一般是网站的名称<br>或者logo等',
			<#include "/website/include/qtip.ftl">
		});	
	});			
</script>
<#if Session?exists><#else>
<SCRIPT language="javascript">
	parent.location = "index.ftl";
</SCRIPT>
</#if>		
<body style="padding-left:10px;">	
<form name="formlanmuadmin" id="formlanmuadmin" method="post"  target="mainFrame"></form>
<#include "/website/include/snp_admin.ftl">
	<table style="width:230">	
		<tr>
			<td>
				<p style="padding-top:0px;padding-bottom:10px">
					<a title="设置栏目的标题"   href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_lanmutitle_all.ftl','1','${Session["clientlogined"].local}');" >栏目标题</a>&nbsp;&nbsp;&nbsp;
					<a title="设置栏目的摆放位置" href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_sort.ftl','1','${Session["clientlogined"].local}');" >栏目位置</a>&nbsp;&nbsp; &nbsp;
				    <a title="设置色调和版面"  href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_style.ftl','1','${Session["clientlogined"].local}');">模板设置</a>
		  				</p>		
			    <table  width="180" >
					<tr>
						<td style="background:#F6F7FB;" class="content"  >
						    <a id=link href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'site_spmp9_admin.ftl','1','${Session["clientlogined"].local}');">
								<span >link</span>
							</a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    <a id=top href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_top.ftl','1','${Session["clientlogined"].local}');">
						        顶部
						    </a>
				　                </td>
					</tr>
					<tr>
						<td  valign=top   style="padding-left:145px;" >  
			                <#if LanmuObject.lanmualldirdisplay=="onlyleft"||LanmuObject.lanmualldirdisplay=="none">
			                <#else>
			                 	<a  title="右上部分的内容编辑"   href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'site_link_admin.ftl','1','${Session["clientlogined"].local}');">
			                 		<span class="ui-state-default ui-corner-all" ><span  class="snp-icon ui-icon-clipboard"></span></span>
			                 	</a> 
					       	 </#if>
			             </td>
				    </tr>		
					<tr>
						<td  style="padding-left:50px;" >
						   <#-- <a title="'首页'栏目标题修改" href = "javaScript:singlanmutitleeidt(${Session["clientlogined"].id},'globe_lanmutitle_null.ftl','1','${Session["clientlogined"].local}','site_about_admin.ftl');"  >	</a> -->
							<br>
								<span style="cursor: none;"  class="snp-icon ui-icon-home" title="首页"></span>
						
					        <a href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'site_about_admin.ftl','1','${Session["clientlogined"].local}');">${Session["clientlogined"].indexLanmu?if_exists}</a>		    
						 </td>
					</tr>
					<tr>
						<td  valign=bottom style="padding-left:10px;" >  
						<#if LanmuObject.lanmualldirdisplay=="onlyright"||LanmuObject.lanmualldirdisplay=="none">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				        <#else>	
				            <br>	
				            <#--			
							<a  title="左下部分的内容编辑"      href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_left.ftl','1','${Session["clientlogined"].local}');">
							<span class="ui-state-default ui-corner-all" ><span  class="snp-icon ui-icon-clipboard"></span></span>
							</a>
							-->
						</#if>
						</td>
					</tr>
			
					<tr>
					    <td style="background:#F6F7FB;" align=center class="content"  >
				            <a title="底部内容编辑"     href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_bottom.ftl','1','${Session["clientlogined"].local}');">底部</a>	          
						</td>
					</tr>
				</table>       
		    </td>
		</tr> 
		<tr>
			<td align=left>
			    <br>
				<@lmmenu  lanmuname=Session["clientlogined"].addressLanmu?if_exists  ftlfilename="site_address_admin.ftl" titlediv="lanmu_desc_single"/>
				<@lmmenu  lanmuname=Session["clientlogined"].jobLanmu?if_exists      ftlfilename="site_job_admin.ftl" titlediv="lanmu_desc_single"/>			
				<@lmmenu  lanmuname=Session["clientlogined"].s1Lanmu?if_exists       ftlfilename="site_s1_admin.ftl" titlediv="lanmu_desc_single"/>			
				<@lmmenu  lanmuname=Session["clientlogined"].s2Lanmu?if_exists       ftlfilename="site_s2_admin.ftl" titlediv="lanmu_desc_single"/>			
				<@lmmenu  lanmuname=Session["clientlogined"].spmp1Lanmu?if_exists  ftlfilename="site_spmp1_admin.ftl"  titlediv="lanmu_desc_dir"  />			
				<@lmmenu  lanmuname=Session["clientlogined"].spmp2Lanmu?if_exists  ftlfilename="site_spmp2_admin.ftl"  titlediv="lanmu_desc_dir" />			
				<@lmmenu  lanmuname=Session["clientlogined"].spmp3Lanmu?if_exists  ftlfilename="site_spmp3_admin.ftl"  titlediv="lanmu_desc_dir" />			
				<@lmmenu  lanmuname=Session["clientlogined"].spmp6Lanmu?if_exists  ftlfilename="site_spmp6_admin.ftl"  titlediv="lanmu_desc_dir" />	       
				<@lmmenu  lanmuname=Session["clientlogined"].spmp4Lanmu?if_exists   ftlfilename="site_spmp4_admin.ftl"  titlediv="lanmu_desc_img"  />						
			    <@lmmenu  lanmuname=Session["clientlogined"].spmp5Lanmu?if_exists   ftlfilename="site_spmp5_admin.ftl" titlediv="lanmu_desc_file"/>							
				<@lmmenu  lanmuname=Session["clientlogined"].guestLanmu?if_exists   ftlfilename="site_guest_admin.ftl" titlediv="lanmu_desc_guest"/>	
				<@lmmenu  lanmuname=Session["clientlogined"].spmp8Lanmu?if_exists   ftlfilename="site_spmp8_admin.ftl" titlediv="lanmu_desc_video"/>
		    </td>
		</tr> 
	</table>
</body>
</html>
