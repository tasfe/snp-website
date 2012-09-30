<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link href="/website/css/content.css" type="text/css" rel="stylesheet">
<#include "/website/macro/map_language_title.ftl">
<#include "/website/macro/commonfun.ftl">
</head>
<SCRIPT language="javascript">
	function changlanguage(language){
    	document.location="site!chang_admin_lang.action?lang="+language;
  	}
	function focusto(){
       if(parent.location.pathname!="/siteadmin/index.ftl" ){
           parent.location = "index.ftl";
       }
		document.all.account.focus()
    }       
	function send(){
		if (document.all.account.value ==""){
			alert("用户名不能为空 ");
			document.all.account.focus();
			return false;
		}
		return true;
	}
</SCRIPT>
<body  style="padding-top:100px;text-align:center;">

<#if Session?exists>
<form  name=form_login action="sitelogin.action" onsubmit="javascript:return send();" method="POST">
<div style="width:400px;Margin-Right: auto;Margin-Left: auto;">
	<div>
		<table style="text-align:center;">
		<tr>
		<td valign=top>
		
			<div style="border: 1px solid #c9d7f1;">
				<div style=" margin:3px;padding:20px; background-color:#E8EEFA;">
				<table width="300" align=center>
				    <tr><td colspan=2>
						<span class=logo-login   style="color:#0000FF">S</span>
						<font class=logo-login   style="color:#FF0000">n</font>
						<font class=logo-login   style="color:#FF9933">p</font>
						<font class=logo-login   style="color:#0000FF">S</font>
						<font class=logo-login   style="color:#008000">o</font>
						<font class=logo-login   style="color:#FF0000">f</font>
					    <font class=logo-login    style="color:#0000FF">t</font>
					   
		     		</td></tr>
				  
				    <tr>
				        <td >用户名</td>
				        <td ><input class=input  name="account" type="text"  id="account" value="" size="15"></td>
				    </tr>
				    <tr>
				        <td >密码</td>
				        <td ><input class=input  name="passwd" type="password"  value="${results["password"]?if_exists}" size="15"></td>
				    </tr>
				    <tr>
				      <td align="center" colspan=2 >
				        <br>

				 			             
				      	 <input class=bt type="submit"   value="登录" width="30" height="17">${results["info"]?if_exists}
				      </td>
				  </tr>
				</table>
				</div>
			</div>
			</form>
		   <br><br><br>
		   
			<#else>
			 	<script type="text/javascript" language="javascript">
			 	   document.location="site!chang_admin_lang.action?lang=zh-CN&page=chang_login_lang";
				</script>
			</#if>  
		
		</td>
		</tr>	
		
		</table>
	</div>
	
	<div style="padding:30">
	            2011© snpsoft-<a target=_blank title=www.snpsoft.net href='http://www.snpsoft.net'> snpsoft.net首页</a> - 服务条款  -<a target=_blank href='http://hi.baidu.com/snpsoft/blog'>帮助</font></a>	
	</div>	
</div>
</body>
</html>