<link href="/website/css/content.css" rel="stylesheet" type="text/css">
<p align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </p>
<table border="0" align="left"  >
	<tr>
		
		<td>
		 	操作异常!请进行其他继续其它操作！
		 	<br> <a id=oursite_a href="http://hi.baidu.com/worldwebdesign/blog" target=_blank>在线技术支持站点.</a>
			<br>如果对您造成困饶，复制下面错误信息，发送到技术支持 QQ：870133482 .
			<br>
		<#if systemErrors?exists>  
		  <#list systemErrors as error>  
		   <br> ${error}
		  </#list>
		</#if>
		<#if oprationErrors?exists>  
		  <#list oprationErrors as error>  
		    <br> ${error}
		  </#list>
		</#if>	
		</td>
		
	</tr>
    <tr>

</table>
