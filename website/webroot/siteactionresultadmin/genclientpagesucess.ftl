<link href="/website/css/content.css" rel="stylesheet" type="text/css">
<script language="javascript" src="/website/js/site_admin.js"></script>
<body>

<div class="area-edit">
	<table width=600px>
		<tr>
			<td>
			            网页生成成功,
				<a title="预览 ：${Session["clientlogined"].username?if_exists}" 
				 href="/site/${Session["clientlogined"].username?if_exists}"target=_blank>点击预览</a>&nbsp;&nbsp;&nbsp;&nbsp;
	            
			</td>
		</tr>
	</table>
</div> 
<#--
<script language="javascript">
	document.location="/site/${results["username"]?if_exists}";
</script> 
-->