<#include "/website/macro/commonfun.ftl">
<link href="/website/css/content.css" rel="stylesheet" type="text/css">
<body >
<div class="area-edit" >
	<table width=400px>
		<tr><td>
		<div  class="title">导出的网页数据包下载</div>
		<div class="content">
			<a id=oursite_tree_a href="/bak/${Session["clientlogined"].username}.zip"><img   src="/other/blue/dr.gif" align="absmiddle" > ${Session["clientlogined"].username}.zip</a>
		</div>
		</td></tr>
	</table>
</div>
</body>