			
	<#if Session["clientlogined"].username="admin">
﻿	    <span id=sa-tree-title>平台</span>
	    <a target="mainFrame" href="/sitedm/siteoperationControl.action?DM.Query.SiteUser=&DM.Object.SiteUser=SiteUser&DM.Query.SiteUser.Type=Results&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/all_user_list.ftl&DM.Query.SiteUser.Pagination.CurrentPage=1&DM.Query.SiteUser.Pagination.Size=300">
		帐号管理</a>
	<#else>
	</#if>	
	