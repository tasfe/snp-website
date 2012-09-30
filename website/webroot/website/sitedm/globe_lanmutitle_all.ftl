<#include "/website/include/head_js_css.ftl">
<#include "/website/macro/map_language_title.ftl">	
<#include "/website/macro/admin_preview.ftl">

<#macro modifylanmutitle name title1="" title2="" title3="" info="" >
     <input size="20" class=input type="text" id="DM.Instance.SiteUser.${name}" name="DM.Instance.SiteUser.${name}" value="${title1?if_exists}">
	 <#if results["DM.Reload.SiteUser.Result"].language2="">
	 <#else>								    
         <font class=info>${language_name[results["DM.Reload.SiteUser.Result"].local2]}</font>
         <input size="15" class=input type="text" name="DM.Instance.SiteUser.${name}2" value="${title2?if_exists}">
     </#if>
     <#if results["DM.Reload.SiteUser.Result"].language3="">
	 <#else>	
	 	 <font class=info>${language_name[results["DM.Reload.SiteUser.Result"].local3]}</font>
   		 <input size="15" class=input type="text" name="DM.Instance.SiteUser.${name}3" value="${title3?if_exists}">
     	
	 </#if>
</#macro>	

<SCRIPT language="javascript">
	parent.menutree.location="/website/siteadmin!refreshUser.action";
	$(document).ready(function()
	{
		$('#home').qtip({
			content: '首页栏目标题<br><br>例如： 首页/home/index等',
			<#include "/website/include/qtip.ftl">
		});	
		$('td.single').qtip({
			content: '单页栏目<br>整个栏目就一个网页显示显示所有内容<br><br>例如：联系方式/银行帐号/招聘/公司简介',
			<#include "/website/include/qtip.ftl">
		});
		$('td.dir').qtip({
			content: '目录栏目<br>整个栏目需要发布多篇文章<br><br>例如：公司章程/服务介绍/行业动态/等',
			<#include "/website/include/qtip.ftl">
		});	
	
	});    
</script>

<body style="background: #fff;">
<form name="formlanmuadmin" method="post"  target="mainFrame"></form>

<div class="area-edit">
	<table cellSpacing="0" width=650>
		<tr>
			<td class=td-data>
				<div  class="title">栏目标题设置（栏目必须设置标题才能显示）</div>
				<div class="content">	
					<form name="form_all" action="siteoperationControl.action" method="post"  >
					<table id=sa-tb-content   cellSpacing="1" >
						<tr>
						    <td id=home>
								 <span class="snp-icon ui-icon-home"></span>
							     <input size="20" class=input type="text" id="DM.Instance.SiteUser.indexLanmu" name="DM.Instance.SiteUser.indexLanmu" value="${results["DM.Reload.SiteUser.Result"].indexLanmu?if_exists}">
								 <#if results["DM.Reload.SiteUser.Result"].language2="">
								 <#else>								    
						             <font class=info>${language_name[results["DM.Reload.SiteUser.Result"].local2]}</font>
							         <input size="15" class=input type="text" name="DM.Instance.SiteUser.indexLanmu2" value="${results["DM.Reload.SiteUser.Result"].indexLanmu2?if_exists}">
							     </#if>
							     <#if results["DM.Reload.SiteUser.Result"].language3="">
								 <#else>	
								 	 <font class=info>${language_name[results["DM.Reload.SiteUser.Result"].local3]}</font>
								   	 <input size="15" class=input type="text" name="DM.Instance.SiteUser.indexLanmu3" value="${results["DM.Reload.SiteUser.Result"].indexLanmu3?if_exists}">
							     </#if>							
							</td>
						</tr>		
						
				        <tr><td class="single">
						    <span class="snp-icon ui-icon-document"></span><@modifylanmutitle name="jobLanmu"            title1=results["DM.Reload.SiteUser.Result"].jobLanmu?if_exists  title2=results["DM.Reload.SiteUser.Result"].jobLanmu2?if_exists  title3=results["DM.Reload.SiteUser.Result"].jobLanmu3?if_exists/>	
						</td></tr>
						<tr><td class="single">
						    <span class="snp-icon ui-icon-document"></span><@modifylanmutitle name="addressLanmu"  title1=results["DM.Reload.SiteUser.Result"].addressLanmu?if_exists title2=results["DM.Reload.SiteUser.Result"].addressLanmu2  title3=results["DM.Reload.SiteUser.Result"].addressLanmu3?if_exists/>			
						</td></tr>									
						<tr><td class="single">
							<span class="snp-icon ui-icon-document"></span><@modifylanmutitle name="s1Lanmu"     title1=results["DM.Reload.SiteUser.Result"].s1Lanmu?if_exists title2=results["DM.Reload.SiteUser.Result"].s1Lanmu2  title3=results["DM.Reload.SiteUser.Result"].s1Lanmu3?if_exists/>	
						</td></tr>													
						<tr><td class="single">
							<span class="snp-icon ui-icon-document"></span><@modifylanmutitle name="s2Lanmu"     title1=results["DM.Reload.SiteUser.Result"].s2Lanmu?if_exists title2=results["DM.Reload.SiteUser.Result"].s2Lanmu2  title3=results["DM.Reload.SiteUser.Result"].s2Lanmu3?if_exists/>
						</td></tr>			
				  		
				 		<tr>
				 			<td class="dir"><span   class="snp-icon ui-icon-folder-open"></span><@modifylanmutitle name="spmp1Lanmu"    title1=results["DM.Reload.SiteUser.Result"].spmp1Lanmu?if_exists  title2=results["DM.Reload.SiteUser.Result"].spmp1Lanmu2?if_exists  title3=results["DM.Reload.SiteUser.Result"].spmp1Lanmu3?if_exists/></td>			
						</tr>	
						<tr>
							<td class="dir"><span   class="snp-icon ui-icon-folder-open"></span><@modifylanmutitle name="spmp2Lanmu"     title1=results["DM.Reload.SiteUser.Result"].spmp2Lanmu?if_exists  title2=results["DM.Reload.SiteUser.Result"].spmp2Lanmu2?if_exists  title3=results["DM.Reload.SiteUser.Result"].spmp2Lanmu3?if_exists/></td>		
						</tr>	
						<tr>
							<td class="dir"><span   class="snp-icon ui-icon-folder-open"></span><@modifylanmutitle name="spmp3Lanmu"     title1=results["DM.Reload.SiteUser.Result"].spmp3Lanmu?if_exists  title2=results["DM.Reload.SiteUser.Result"].spmp3Lanmu2?if_exists  title3=results["DM.Reload.SiteUser.Result"].spmp3Lanmu3?if_exists/></td>			
						</tr>	
						<tr>	
							<td class="dir"><span   class="snp-icon ui-icon-folder-open"></span><@modifylanmutitle name="spmp6Lanmu"     title1=results["DM.Reload.SiteUser.Result"].spmp6Lanmu?if_exists  title2=results["DM.Reload.SiteUser.Result"].spmp6Lanmu2?if_exists title3=results["DM.Reload.SiteUser.Result"].spmp6Lanmu3?if_exists/></td>
						</tr>	
						
						<tr>
							<td class="spmp4"  ><span   class="snp-icon ui-icon-image"></span><@modifylanmutitle name="spmp4Lanmu"      title1=results["DM.Reload.SiteUser.Result"].spmp4Lanmu  title2=results["DM.Reload.SiteUser.Result"].spmp4Lanmu2?if_exists  title3=results["DM.Reload.SiteUser.Result"].spmp4Lanmu3?if_exists/></td>		
						</tr>
						<tr>	
							<td class="spmp5"  ><span   class="snp-icon ui-icon-arrowthickstop-1-s"></span><@modifylanmutitle name="spmp5Lanmu"    title1=results["DM.Reload.SiteUser.Result"].spmp5Lanmu?if_exists  title2=results["DM.Reload.SiteUser.Result"].spmp5Lanmu2 ?if_exists title3=results["DM.Reload.SiteUser.Result"].spmp5Lanmu3?if_exists/>&nbsp;下载栏目&nbsp;&nbsp;例如：文件下载	</td>		
						</tr>		
						<tr>	
							<td class="guest" valign=bottom ><span  class="snp-icon ui-icon-comment"></span>	<@modifylanmutitle name="guestLanmu"    title1=results["DM.Reload.SiteUser.Result"].guestLanmu?if_exists   title2=results["DM.Reload.SiteUser.Result"].guestLanmu2?if_exists  title3=results["DM.Reload.SiteUser.Result"].guestLanmu3?if_exists />&nbsp;留言板栏目&nbsp;&nbsp;例如：客户留言</td>
						</tr>  
						<tr>
						   <td class="spmp8"  valign=bottom><span  class="snp-icon ui-icon-video"></span><@modifylanmutitle name="spmp8Lanmu"     title1=results["DM.Reload.SiteUser.Result"].spmp8Lanmu?if_exists  title2=results["DM.Reload.SiteUser.Result"].spmp8Lanmu2?if_exists title3=results["DM.Reload.SiteUser.Result"].spmp8Lanmu3?if_exists/>&nbsp;视频栏目&nbsp;&nbsp;例如：企业电台/多媒体展示/视频广告/等</td>	
						</tr>		
						<tr id=oursite_tb_data >
							<td  align="center" width=550 >
						     <input class=bt  type="submit"  value="确定"> 
				             <input  class=bt type="button"  value="返回" onclick="javascript:history.go(-1);">
							</td>
						</tr>
									
					</table>
						<input type="hidden" name="DM.Reload.SiteUser" value="SiteUser">
						<input type="hidden" name="DM.Instance.SiteUser.id" value="${results["DM.Reload.SiteUser.Result"].id}">
						<input type="hidden" name="DM.Object.SiteUser" value="SiteUser">
						<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
						<input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/globe_lanmutitle_all.ftl">
					</form>
				</div>	
			</td>
			
		</tr>
	</table>
	
</div>


<@preview_iframe "index.ftl" />
</HTML>
