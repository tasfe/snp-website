<link href="/website/css/content.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="/common/edit/fckeditor.js"></script>

<div class="div">
<form name="form1" action="siteoperationControl.action" method="post"  enctype="multipart/form-data">
<table border="0" align="left" cellpadding="0" cellspacing="1" width="630" class="content_tab_input">

	<input class=input type="hidden" name="DM.Instance.SiteUser.id" value=" ${results["DM.Reload.SiteUser.Result"].id}">
 	<tr>
		<td align="left"  id=oursite_tb_data title="用户名必须设置，不要重名，取英文名字">
		用户名&nbsp;&nbsp;：<input class=input class=input type="text" size="20" value="${results["DM.Reload.SiteUser.Result"].username?if_exists}"  name="DM.Instance.SiteUser.username">&nbsp;<font color="red">*</font>
		<BR>密&nbsp;&nbsp;码&nbsp;&nbsp;：<input class=input class=input type="text" size="20" value="${results["DM.Reload.SiteUser.Result"].password?if_exists}"  name="DM.Instance.SiteUser.password">
	<#--	<BR>用户说明：<input class=input class=input type="text" size="30" value="${results["DM.Reload.SiteUser.Result"].comment?if_exists}"  name="DM.Instance.SiteUser.comment"></td>
	-->
	</tr> 
	

	<tr>
		<td align="left"  id=oursite_tb_data title="给客户单独留言">子站点管理员通知信息：<br>
		<textarea class=input cols="60" rows="3" id="DM.Instance.SiteUser.usernotify" name="DM.Instance.SiteUser.usernotify">${results["DM.Reload.SiteUser.Result"].usernotify?if_exists}</textarea>
		</td>
	</tr>  
	<tr>
		<td>
			<table width="99%" border="0" align="center" cellpadding="0" cellspacing="1">
				<tr>
					<td colspan="2" align="center">
						<input class=input class=input type="hidden" name="DM.Update.SiteUser" value="">
					    <input class=input class=input type="hidden" name="DM.Query.SiteUser.__Depends" value="DM.Update.SiteUser">		
						<input class=input class=input type="hidden" name="DM.Object.SiteUser" value="SiteUser">
						<input class=input class=input type="hidden" name="DM.Query.SiteUser" value="">
						<input class=input class=input type="hidden" name="DM.Query.SiteUser.Type" value="Results">
						<input class=input class=input type="hidden" name="OT.Forward.success.Type" value="freemarker">
						<input class=input class=input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/all_user_list.ftl">
						<input class=input class=input type="hidden" name="noprefix" value="">
						
						<a id=oursite_a href="javascript:form1.submit();">确定</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a id=oursite_a href="javascript:history.go(-1);">返回</a>
					</td>
				</tr>
			</table>
		</td></tr>	  
	</form>
</table>
</div>
 