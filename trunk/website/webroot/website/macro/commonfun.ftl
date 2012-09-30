<#macro tt width='800px' >
	<div class="area-edit">
		<table width=${width}>
			<tr>
				<td>
</#macro>

<#macro bb >
				</td>
			</tr>
		</table>
	</div>
</#macro>


<#macro quickedit>
    <a id=oursite_a   href="#" onclick="javascript:get_spmp('${Session["clientlogined"].id?if_exists}');"> <span class="icon icon-quick " title="快捷编辑方式"></span></a>
    <div id="div_quick_edit" ></div>
</#macro>

<#macro strbylanguage v1=""  v2=""  v3="">
	<#switch language>
		  <#case "1">${v1?if_exists?trim}<#break>
		  <#case "2">${v2?if_exists?trim}<#break>
		  <#case "3">${v3?if_exists?trim}<#break>
		  <#default>
	</#switch>				
</#macro>


<#macro align flag="left"  >
	<#switch flag>
		  <#case "left">左<#break>
		  <#case "right">右<#break>
		  <#case "up">上<#break>
		  <#case "down">下<#break>
		  <#default>
	</#switch>				
</#macro>

