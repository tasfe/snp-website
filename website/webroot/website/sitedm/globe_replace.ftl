<link href="/website/css/content.css" rel="stylesheet" type="text/css">
<script language="javascript" src="/website/js/site_admin.js"></script>
<body>

<div class="area-edit">
	<table width=600px>
		<tr>
			<td>
				<div class="title">文字替换&nbsp;&nbsp;&nbsp;(&nbsp;可以一次替所有网页面中的文字内容：比如更换电话号码，公司名字等&nbsp;)</div>
				<div class="content">
					<form name="formadmin" action="siteadmin!genReplace.action?siteuserid=${Session["clientlogined"].id}" method="post" target="_self" >
						 查找内容  <input class=input id=str_find  name=str_find type="text" size="10" value=""   />
						 替换为   <input class=input id=str_replace  name=str_replace type="text" size="10" value=""   />
						&nbsp;&nbsp;&nbsp;<input  class=bt type="submit" value="确定"> 
					</form>
				</div>		
			</td>
		</tr>
	</table>
</div>
<iframe id=iframe_preview  style="BORDER:#ccc 1px solid;"  
  src='siteoperationControl.action?language=1&DM.Instance.SiteUser.id=${Session["clientlogined"].id}&DM.Object.SiteUser=SiteUser&DM.Reload.SiteUser=&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/site_preview.ftl&lanmutemplete=index.ftl'
  frameborder="0" width="1000" scrolling="yes" height="830">
</iframe>	
</HTML>
