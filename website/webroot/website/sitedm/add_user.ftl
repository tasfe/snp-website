<link href="/website/css/content.css" rel="stylesheet" type="text/css">
<script language="javascript">
        function verifyValue(){	
			return true;
		}
</script>

<form name="formadmin" action="siteoperationControl.action?OT.Forward.success.URL=/website/sitedm/all_user_list.ftl&DM.business.CreateNewUser=&DM.Query.SiteUser=&DM.Object.SiteUser=SiteUser&DM.Query.SiteUser.__Depends=DM.business.CreateNewUser&OT.Forward.success.Type=freemarker&DM.Query.SiteUser.Type=Results" method="post" target="_self" >

<table border="0" align="left" cellpadding="0" cellspacing="1" width="630" class="content_tab_input">
 	<tr>
		<td align="left"  id=oursite_tb_data >
			用户名&nbsp;&nbsp;：<input  class=input type="text" size="20" value=""  name="username">&nbsp;<font color="red">*</font>
			<BR>密&nbsp;&nbsp;码&nbsp;&nbsp;：<input class=input class=input type="text" size="20" value=""  name="password">
			<BR>用户说明：<input class=input class=input type="text" size="30" value=""  name="DM.Instance.SiteUser.comment">
		</td>
	</tr> 
	
	<tr>
		<td align=center>
			<a class=bt href="javascript:formadmin.submit();">确定</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class=bt href="javascript:history.go(-1);">返回</a>
		</td>
	</tr>	  
	
	</form>
</table>

 