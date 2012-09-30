
<#include "/website/macro/map_language_title.ftl"> 
<#macro preview_iframe  lanmutemplete  >	
    <br><br>
     <span class=info-big> 预览区域（请不要点击下面链接，真实网站效果，请点顶部的‘生成网页’再预览）</span>
   	<#if Session["clientlogined"].language2?default('')!=''||Session["clientlogined"].language3?default('')!="">
		<a  onclick="javaScript:document.getElementById('iframe_preview').src='siteoperationControl.action?local=${Session["clientlogined"].local?if_exists}&language=1&DM.Instance.SiteUser.id=${Session["clientlogined"].id}&DM.Object.SiteUser=SiteUser&DM.Reload.SiteUser=&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/site_preview.ftl&lanmutemplete=${lanmutemplete}';" href="#"/>
			${language_name[Session["clientlogined"].local]?default('english')}
		</a>
	</#if>
	<#if Session["clientlogined"].language2?default('')!="">
		<a  onclick="javaScript:document.getElementById('iframe_preview').src='siteoperationControl.action?local=${Session["clientlogined"].local2?if_exists}&language=2&DM.Instance.SiteUser.id=${Session["clientlogined"].id}&DM.Object.SiteUser=SiteUser&DM.Reload.SiteUser=&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/site_preview.ftl&lanmutemplete=${lanmutemplete}';" href="#"/>
			${language_name[Session["clientlogined"].local2]?default('english')}
		</a>
	</#if>
	<#if Session["clientlogined"].language3?default('')!="">
		<a  onclick="javaScript:document.getElementById('iframe_preview').src='siteoperationControl.action?local=${Session["clientlogined"].local3?if_exists}&language=3&DM.Instance.SiteUser.id=${Session["clientlogined"].id}&DM.Object.SiteUser=SiteUser&DM.Reload.SiteUser=&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/site_preview.ftl&lanmutemplete=${lanmutemplete}';" href="#"/>
			${language_name[Session["clientlogined"].local3]?default('english')}
		</a>
	</#if> 
 	<br><br>
	<iframe id=iframe_preview  style="border:#ccc 1px solid;"  
		src='siteoperationControl.action?local=${Session["clientlogined"].local?if_exists}&language=1&DM.Instance.SiteUser.id=${Session["clientlogined"].id}&DM.Object.SiteUser=SiteUser&DM.Reload.SiteUser=&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/site_preview.ftl&lanmutemplete=${lanmutemplete}'
	 	frameborder="0" width="1000" scrolling="yes" height="830">
	</iframe>	
 	 
</#macro>



	
		



