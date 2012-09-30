<#include "/website/include/head_js_css.ftl">

<form name="formlanmuadmin" id=formlanmuadmin method="post"  target="mainFrame"></form>
<body style="">
	<table  width=100% style="border-bottom:1px solid #c9d7f1;background:#F6F7FB; " >
		<tr>
			<td align=center  valign=bottom style="width:160px" >
				<div class="out" >
					<div class="in ltin tpin" style="cursor:hand;" onMouseOver="style.background='#f00'; " onclick="parent.mainFrame.location='genhtml.ftl'" onMouseOut="style.background='#0063dc';">
						<span  class=bt-update style="padding:5 0 5 0"  >生&nbsp;成&nbsp;html&nbsp;网&nbsp;页</span>		
					</div>
				</div>			
			</td>
			<td style="padding-left:20px" > 
				<a title=预览${Session["clientlogined"].username?if_exists}  href="/site/${Session["clientlogined"].username?if_exists}" target=_blank ><span  class="snp-icon ui-icon-search"></span></a>
			</td>
			<td  align=right  valign=bottom>
			    <#if Session["clientlogined"].enddate?exists >到期时间:${Session["clientlogined"].enddate?if_exists}</#if>
                <a id=export title='导出网页发布包（网页电子杂志）' href="export_userdata.ftl;" target="mainFrame" >导出网页数据包</a>&nbsp;&nbsp;&nbsp;
			    <a id=import title='导入网页发布包' href="import_userdata.ftl;" target="mainFrame">导入</a>&nbsp;&nbsp;&nbsp;
			    <a  id=replace title='一次性替换所有网页中出现的某些关键字' href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_replace.ftl','1','${Session["clientlogined"].local}');"> 替换文字</a>&nbsp;&nbsp;&nbsp
               <a title="多国语言设置"    href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_language.ftl','1','${Session["clientlogined"].local}');">多国语言</a>&nbsp;&nbsp; &nbsp;                  
               
                <a id=soe title='搜索引擎优化排名'  href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_search.ftl','1','${Session["clientlogined"].local}');" >SEO</a>&nbsp; &nbsp;&nbsp;
                <a  id=qq title='网页显示在线QQ不用加为好友就可以互聊'  href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_qq.ftl','1','${Session["clientlogined"].local}');" >QQ设置</a>&nbsp; &nbsp;
                <a title="设置密码"   href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_setpassword.ftl','1','${Session["clientlogined"].local}');" >密码</a>&nbsp; &nbsp;
			    <a target=_blank href="/website/siteadmin/content_main.ftl">帮助</a>  
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		      
			</td>
		</tr>
	</table>
</body>
</html>