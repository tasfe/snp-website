<!DOCTYPE html>
<html>
<#assign LanmuObject=Session["lanmuobject"]/>
<#include "/website/macro/tree.ftl">
<#include "/website/macro/commonfun.ftl">
<#include "/website/include/head_js_css.ftl">


<style type="text/css">
	.snp-icon { width: 16px; height: 16px; background-image: url(/website/css/images/ui-icons_469bdd_256x240.png); display: block;  text-indent: -99999px; overflow: hidden; background-repeat: no-repeat;  }
	.snp-icon  {margin: 0px; padding: 0px ; position: relative; cursor: pointer; float: left;  list-style: none;}/*间隔为0不能去掉*/
	.ui-icon-trash { background-position: -176px -96px; }
	.ui-icon-image { background-position: -208px -128px; }
	.ui-icon-video { background-position: -224px -128px; }
</style>	
	</head>
	<body>




<body style="padding-left:10px;">	
	<form name="formlanmuadmin" id="tree_formlanmuadmin" method="post" target="mainFrame"></form>
	<form name="formtree" method="post" target="menutree"></form>	
	<#if Session["clientlogined"].username="snp">
	    &nbsp;&nbsp;<span id=sa-tree-title>平台</span>
		<a target="mainFrame" href="/sitedm/siteoperationControl.action?DM.Query.SiteUser=&DM.Object.SiteUser=SiteUser&DM.Query.SiteUser.Type=Results&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/all_user_list.ftl&DM.Query.SiteUser.Pagination.CurrentPage=1&DM.Query.SiteUser.Pagination.Size=300">
		帐号管理</a>			
       <br>
	<#else>
	</#if>
	<table style="border-right:1px solid #c3d9ff;width:220">	
		<tr>
			<td>
				<p style="padding:8px">
					<a title="设置栏目的标题"   href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_lanmutitle_all.ftl','1','${Session["clientlogined"].local}');" >栏目设置</a>&nbsp; &nbsp
					<a title="设置栏目的摆放位置" href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_sort.ftl','1','${Session["clientlogined"].local}');" >排序</a>&nbsp; &nbsp;
				    <a title="设置色调和版面"  href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_style.ftl','1','${Session["clientlogined"].local}');">模板</a>&nbsp;&nbsp; 
		            <a title="多国语言设置"    href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_language.ftl','1','${Session["clientlogined"].local}');">语言</a>&nbsp;&nbsp;                   
				</p>		
			    <table  width="190" >
					<tr>
						<td style="background:#F6F7FB;" class="content"  >
						    	<a id=link href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'site_spmp9_admin.ftl','1','${Session["clientlogined"].local}');">
									<span title="添加链接">link</span>
								</a>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    <a id=top href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_top.ftl','1','${Session["clientlogined"].local}');">
						        顶部
						    </a>
				　                </td>
					</tr>
					<tr >
						<td  valign=top   style="padding-left:150px;" >  
			                 <#if LanmuObject.lanmualldirdisplay=="onlyleft"||LanmuObject.lanmualldirdisplay=="none">
			                 <#else>
			                 	 <a  title="右上部分的内容编辑"   href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'site_link_admin.ftl','1','${Session["clientlogined"].local}');">
			                 	 <#--<span  class="icon icon-edit"></span>-->
			                 	 <span class="ui-state-default ui-corner-all" ><span  class="snp-icon ui-icon-clipboard"></span></span>
			                 	 </a> 
					       		
					         </#if>
			             </td>
				    </tr>		
					<tr >
						<td  height=15 style="padding-left:65px;" >
						  
			        	    <a   title="'首页'栏目标题修改" href = "javaScript:singlanmutitleeidt(${Session["clientlogined"].id},'globe_lanmutitle_null.ftl','1','${Session["clientlogined"].local}','site_about_admin.ftl');"  >
							<span  class="snp-icon ui-icon-home"></span>
							
					        </a> 
					        <a   href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'site_about_admin.ftl','1','${Session["clientlogined"].local}');">${Session["clientlogined"].indexLanmu?if_exists}</a>		    
						 </td>
					</tr>
					<tr >
						<td  valign=top height=15 style="padding-left:10px;" >  
						<#if LanmuObject.lanmualldirdisplay=="onlyright"||LanmuObject.lanmualldirdisplay=="none">
						 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				        <#else>					
							<a  title="左下部分的内容编辑"  class=bt_tree     href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_left.ftl','1','${Session["clientlogined"].local}');">
						
							<span class="ui-state-default ui-corner-all" ><span  class="snp-icon ui-icon-clipboard"></span></span>
							
							
							</a>
						</#if>
						    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						
						</td>
					</tr>
			
					<tr>
					    <td style="background:#F6F7FB;" align=center class="content"  >
				            <a   title="底部内容编辑"     href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_bottom.ftl','1','${Session["clientlogined"].local}');">底部</a>	          
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


