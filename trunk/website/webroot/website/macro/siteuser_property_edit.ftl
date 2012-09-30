<#macro siteglobe property ftl palace width=700 height=200 value="" ftl_return="site_about_admin.ftl" ftl_preview="index.ftl">
<#include "/website/include/head_js_css.ftl">

<script type="text/javascript">
	window.onload = function(){
		var sBasePath ='/';
		var oFCKeditor = new FCKeditor('DM.Instance.SiteUser.${property}',${width},${height});
		oFCKeditor.BasePath	= sBasePath;
		oFCKeditor.ToolbarSet ='1_2';
		oFCKeditor.ReplaceTextarea() ;
	}
</script>	
<body>
<div class="area-edit">
	<table width=${width}>
		<tr>
			<td>
				<div class="title">${palace}</div>
				<div class="content">
					<form  action="siteoperationControl.action" method="post" >
				        <table width=${width}>
							<tr>
								<td align="center">
									<textarea id="DM.Instance.SiteUser.${property}" name="DM.Instance.SiteUser.${property}" style="WIDTH: 100%; HEIGHT: 200px">${value}</textarea>
								    <p class="bt-top">
								    <input class="bt" type="submit" value="确定">
								    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								    <#if ftl_preview!="none" >
								    <input class="bt" type="button" value="返回" onclick="javascript:lanmupageadmin(${results["DM.Reload.SiteUser.Result"].id},'${ftl_return}','','');">
									</#if>				   
								    </p>
								</td>
							</tr>
						</table>
						<input type="hidden" name="DM.Reload.SiteUser" value="SiteUser">
						<input type="hidden" name="DM.Instance.SiteUser.id" value="${results["DM.Reload.SiteUser.Result"].id}">
						<input type="hidden" name="DM.Object.SiteUser" value="SiteUser">
						<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
						<input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/${ftl}">
					</form>	
				<div>	  
			</td>
		</tr>
	</table>
</div>
<#if ftl_preview!="none" >
	<@preview_iframe "${ftl_preview}" />
</#if>	
</HTML>
</#macro>		