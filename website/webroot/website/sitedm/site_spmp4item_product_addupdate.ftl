<link href="/website/css/content.css" rel="stylesheet" type="text/css">

 
<script type="text/javascript" src="/common/edit/fckeditor.js"></script>
<#include "/website/macro/fckedit.ftl">
<#include "/website/macro/commonfun.ftl">

<form name="form1" action="siteoperationControl.action" method="post" >

<div class="area-edit">
<table width="600" >
<tr>
<td>
	<div class="title" ><span class=bold>修改内容</span></div>
	<div class="content" >
   <table width="700">
	   <tr>
	   <td id=oursite_tb_data>
		<@fckeditupdate user=Session["clientlogined"]     
		                vartxt="DM.Instance.SiteProduct.detail"  
		                title=""
		                v1=results["DM.Reload.SiteProduct.Result"].detail?if_exists
		                v2=results["DM.Reload.SiteProduct.Result"].detail2?if_exists
		                v3=results["DM.Reload.SiteProduct.Result"].detail3?if_exists
		/>	
		</td>	
		</tr>								
        <tr>
        <td id=oursite_tb_data>
			<p align=center>	
						<a class=bt href="javascript:form1.submit();">确定</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a class=bt href="javascript:history.go(-1);">返回</a>
			</p>
        </td>
        </tr>
	</table>
	<div>

</td>
</tr>
</table>	
</div>

	<input type="hidden" name="DM.Update.SiteProduct" value="">
	<input type="hidden" name="DM.Instance.SiteProduct.id" value="${results["DM.Reload.SiteProduct.Result"].id}">
	<input type="hidden" name="spmp4id" value=${tempvar["spmp4id"]}>  	  
 	  	  
	  
	<input type="hidden" name="OT.Token.type" value="apply">
    <input type="hidden" name="OT.Token.name" value="about">
    <input type="hidden" name="OT.Token.value" value="${results["OT.Token.Result"]}">
	<input type="hidden" name="DM.Object.SiteProduct" value="SiteProduct">
	<input type="hidden" name="DM.Reload.SiteSpmp4Item" value="SiteSpmp4Item">
	<input type="hidden" name="DM.Instance.SiteSpmp4Item.id" value="${results["DM.Reload.SiteSpmp4Item.Result"].id}">
	<input type="hidden" name="DM.Object.SiteSpmp4Item" value="SiteSpmp4Item">
	<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
	<input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/site_spmp4item_product_admin.ftl">
							
</form>



