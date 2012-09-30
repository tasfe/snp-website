<HEAD> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="0"> 
</HEAD>
<link href="/website/css/content.css" rel="stylesheet" type="text/css">
<#assign LanmuObject=Session["lanmuobject"]/>
<#include "/website/macro/tree.ftl">
<#include "/website/macro/commonfun.ftl">
<script language="javascript" src="/website/js/site_admin.js"></script>
<script language="javaScript" src="/other/jquery151/jquery-1.5.1.min.js"></script>

<SCRIPT language="javascript">

	var  common_user_reload="siteoperationControl.action?local=${Session["clientlogined"].local?if_exists}&language=${Session["clientlogined"].language?if_exists}&OT.Forward.success.Type=freemarker"
		                        +"&DM.Reload.SiteUser=&DM.Object.SiteUser=SiteUser"
		                        +"&DM.Instance.SiteUser.id=${Session["clientlogined"].id?if_exists}&OT.Forward.success.URL=";
	function nav_edit(lanmu_id,op){
		    document.getElementById('formlanmuadmin').action=common_user_reload+"/website/sitedm/globe_navedit.ftl"
		                      +"&DM.business.NavEdit="
	                          +"&lanmu_id="+lanmu_id
	                          +"&op="+op
	                          +"&DM.Reload.SiteUser.__Depends=DM.business.NavEdit" 
		                         ;  
		   // alert(document.getElementById('formlanmuadmin').action);
		  	document.getElementById('formlanmuadmin').submit();
	}

   function  set_panle(){
       if(document.getElementById('panle_setting').style.display=='none')
		    document.getElementById('panle_setting').style.display='';
		else
		   document.getElementById('panle_setting').style.display='none';
   }
   

   function  set_display(id){
       if(document.getElementById(id).style.display=='none')
		    document.getElementById(id).style.display='';
		else
		   document.getElementById(id).style.display='none';
   }


	function	update_setting(name,value,page){
		   var  action=common_user_reload
                             +page
                             +"&DM.business.LanmuSetting="
                             +"&DM.Reload.SiteUser.__Depends=DM.business.LanmuSetting"  
                             +"&paraname="+name
                             +"&"+name+"="+value
                             +"&userid=${Session["clientlogined"].id?if_exists}"
           document.getElementById('formlanmuadmin').action=action;
		   document.getElementById('formlanmuadmin').submit();	    		
	
	}	   
</script>

<#if Session?exists><#else>
<SCRIPT language="javascript">
	parent.location = "index.ftl";
</SCRIPT>
</#if>
<body  style="padding-left: 3px;margin-right: 4px;">
<form name="formlanmuadmin" method="post" target="mainFrame"></form>
<form name="formtree" method="post" target="menutree"></form>
<table>
    <tr>
    	<td  valign="top">


<div class="content">
    <table  width="180" >
		<tr>
			<td  style="text-align:center;">
			    <div style="float:left; z-index:5;  " >
				    <a     title="添加链接" href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'site_spmp9_admin.ftl','1','${Session["clientlogined"].local}');">
						
						 <span title="添加链接" class="icon icon-link"></span>
					</a>
				</div>
			</td>	
			<td colspan=2>
			  <div style="float:right;">
		
	           </div>
	        </td>
		</tr>
		<tr>
			<td colspan=3 style="text-align:center;background:#F6F7FB;" width="190"  class="content"  height=22>
			   
			    <a title="顶部内容修改" href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_top.ftl','1','${Session["clientlogined"].local}');">
			         顶部
			    </a>
	　                </td>
		</tr>
				
		<tr height=16>
			<td  valign=top   >  
			   <#if LanmuObject.lanmualldirdisplay=="onlyright"||LanmuObject.lanmualldirdisplay=="none">
               <#else>
			    <a title="左上部分的目录显示设置"  href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_dir.ftl','1','${Session["clientlogined"].local}');">
					<span  class="icon icon-dir"></span>
			    </a>
			    </#if>
            </td>
            <td  width=189></td>
            <td align=right>
                <#if LanmuObject.lanmualldirdisplay=="onlyleft"||LanmuObject.lanmualldirdisplay=="none">
                <#else>
                    <a  title="右上部分的内容编辑"   href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'site_link_admin.ftl','1','${Session["clientlogined"].local}');"><span  class="icon icon-edit"></span></a> 
		        </#if>
             </td>
	    <tr>		
			<td  colspan=3 style="text-align:center;" height=22>
			    
				   	       <a   title="'首页'栏目标题修改" href = "javaScript:singlanmutitleeidt(${Session["clientlogined"].id},'globe_lanmutitle_null.ftl','1','${Session["clientlogined"].local}','site_about_admin.ftl');"  >
								
					        <span  class="icon icon-home" ></span>
					        
					        </a> 
					        <a   href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'site_about_admin.ftl','1','${Session["clientlogined"].local}');">${Session["clientlogined"].indexLanmu?if_exists}</a>		    
				    
			 </td>
		 <tr>

				<tr>
					<td  valign=top  >  
					   <#if LanmuObject.lanmualldirdisplay=="onlyright"||LanmuObject.lanmualldirdisplay=="none">
		               <#else>					
						<a  title="左下部分的内容编辑"  class=bt_tree     href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_left.ftl','1','${Session["clientlogined"].local}');">
						 <span  class="icon icon-edit"></span></a>
						</#if>
                    </td>
                    <td>
                    </td>
		            <td>
		                <#if LanmuObject.lanmualldirdisplay=="onlyleft"||LanmuObject.lanmualldirdisplay=="none">
		                <#else>		            
		               	  <a title="右下部分的内容编辑"   class=bt_tree  href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_right.ftl','1','${Session["clientlogined"].local}');"><span  class="icon icon-edit"></span></a> 
   						</#if>
                     </td>
			     
				<tr height=16>
				    <td colspan=3 style="text-align:center;background: #F6F7FB;" height=22 class="content">
				    <a   title="底部内容编辑"     href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_bottom.ftl','1','${Session["clientlogined"].local}');">底部</a>	          
			           
			        </td>
				</tr>
	
	</table>
</div>
<#---
<span onClick="javascript:set_display('panle_lanmu');" class=bt-lanmu title="单击展开" >
<img align="absmiddle" src="/imagesadmin/siteadmin/sh_open.gif">&nbsp;单页栏目
</span>
-->
<br>
<div class="lanmu-type " >
	<div class="lanmu-in ltin tpin" style="cursor:hand;"  onClick="javascript:set_display('panle_lanmu');" >
		<img align="absmiddle" src="/imagesadmin/siteadmin/sh_open.gif">
		单页栏目
	</div>
</div>	

<div id="panle_lanmu" class="content"  style="display:<#if results?exists&&results["showsetting"]?exists&&results["showsetting"]=="lanmutitle"><#else>none</#if>;" >		
	<@lmmenu  lanmuname=Session["clientlogined"].addressLanmu?if_exists  ftlfilename="site_address_admin.ftl" titlediv="lanmu_desc_single"/>
	<@lmmenu  lanmuname=Session["clientlogined"].jobLanmu?if_exists      ftlfilename="site_job_admin.ftl" titlediv="lanmu_desc_single"/>			
	<@lmmenu  lanmuname=Session["clientlogined"].s1Lanmu?if_exists       ftlfilename="site_s1_admin.ftl" titlediv="lanmu_desc_single"/>			
	<@lmmenu  lanmuname=Session["clientlogined"].s2Lanmu?if_exists       ftlfilename="site_s2_admin.ftl" titlediv="lanmu_desc_single"/>			

</div> 	
<br>
<#---
<span onClick="javascript:set_display('panle_dirlanmu');" class=bt-lanmu title="单击展开" ><img align="absmiddle" src="/imagesadmin/siteadmin/sh_open.gif">&nbsp;目录结构栏目</span>
-->
<div class="lanmu-type " >
		<div class="lanmu-in ltin tpin" style="cursor:hand;"  onClick="javascript:set_display('panle_dirlanmu');" >
		<img align="absmiddle" src="/imagesadmin/siteadmin/sh_open.gif">
		&nbsp;目录结构栏目	
	</div>
</div>	
	
<div id="panle_dirlanmu" class="content"  style="display:<#if results?exists&&results["showsetting"]?exists&&results["showsetting"]=="lanmutitle"><#else>none</#if>;" >

		<@lmmenu  lanmuname=Session["clientlogined"].spmp1Lanmu?if_exists  ftlfilename="site_spmp1_admin.ftl"  titlediv="lanmu_desc_dir"  />			
		<@lmmenu  lanmuname=Session["clientlogined"].spmp2Lanmu?if_exists  ftlfilename="site_spmp2_admin.ftl"  titlediv="lanmu_desc_dir" />			
		<@lmmenu  lanmuname=Session["clientlogined"].spmp3Lanmu?if_exists  ftlfilename="site_spmp3_admin.ftl"  titlediv="lanmu_desc_dir" />			
		<@lmmenu  lanmuname=Session["clientlogined"].spmp6Lanmu?if_exists  ftlfilename="site_spmp6_admin.ftl"  titlediv="lanmu_desc_dir" />	
<p align=right>
<a id=oursite_a   href="#" onclick="javascript:get_spmp('${Session["clientlogined"].id?if_exists}');">*<#-- <span class="icon icon-quick " title="快捷编辑方式"></span>--></a>
</p>
</div>
<br>	
<#--
<span onClick="javascript:set_display('panle_other');" class=bt-lanmu title="单击展开" ><img align="absmiddle" src="/imagesadmin/siteadmin/sh_open.gif">&nbsp;其它栏目</span>
--->
<div class="lanmu-type " >
	<div class="lanmu-in ltin tpin" style="cursor:hand;"  onClick="javascript:set_display('panle_other');" >
		<img align="absmiddle" src="/imagesadmin/siteadmin/sh_open.gif">
		&nbsp;其它栏目	
	</div>
</div>	
<div id="panle_other" class="content"  style="display:<#if results?exists&&results["showsetting"]?exists&&results["showsetting"]=="lanmutitle"><#else>none</#if>;" >
	<@lmmenu  lanmuname=Session["clientlogined"].spmp4Lanmu?if_exists   ftlfilename="site_spmp4_admin.ftl"  titlediv="lanmu_desc_img"  />						
    <@lmmenu  lanmuname=Session["clientlogined"].spmp8Lanmu?if_exists   ftlfilename="site_spmp8_admin.ftl" titlediv="lanmu_desc_video"/>
    <@lmmenu  lanmuname=Session["clientlogined"].spmp5Lanmu?if_exists   ftlfilename="site_spmp5_admin.ftl" titlediv="lanmu_desc_file"/>							

	<@lmmenu  lanmuname=Session["clientlogined"].checkLanmu?if_exists   ftlfilename="site_order_design.ftl" titlediv="lanmu_desc_order"/>		
	<@lmmenu  lanmuname=Session["clientlogined"].guestLanmu?if_exists   ftlfilename="site_guest_admin.ftl" titlediv="lanmu_desc_guest"/>	
	<@lmmenu  lanmuname=Session["clientlogined"].spmp7Lanmu?if_exists   ftlfilename="site_spmp7_admin.ftl" titlediv="lanmu_desc_memeber"/>	
</div> 		

</body>
