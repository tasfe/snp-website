<#include "/website/include/img_op.ftl">
<script language="javascript">
 	<#if tempvar["language"]?exists >
	    <#assign language=tempvar["language"]?if_exists />	
	<#else>
		<#assign language=results["DM.Reload.SiteUser.Result"].language?if_exists/>	
	</#if>	
 	<#if tempvar["local"]?exists >
 	    <#assign local=tempvar["local"]?if_exists />
	<#else>
		<#assign local=results["DM.Reload.SiteUser.Result"].local?if_exists/>	
	</#if>
	
   var  ftlpath="/website/sitedm/";
   var  common="siteoperationControl.action?OT.Forward.success.Type=freemarker";
   var parent_reload="&DM.Reload.SiteSpmp4=&DM.Object.SiteSpmp4=SiteSpmp4&DM.Instance.SiteSpmp4.id=";
  
   var  reload_spmp4=common+parent_reload+${results["DM.Reload.SiteSpmp4.Result"].id}+"&OT.Forward.success.URL=/website/sitedm/";
	function checkAll() {
		for (var j = 1; j <= 9; j++) {
		box = eval("document.document.getElementById('formlanmuadmin').C" + j); 
		if (box.checked == false) box.checked = true;
		   }
	}
	
	function uncheckAll() {
		for (var j = 1; j <= 9; j++) {
		box = eval("document.document.getElementById('formlanmuadmin').C" + j); 
		if (box.checked == true) box.checked = false;
		   }
	}
	
		function CheckAll(form)
				  {
				  for (var i=0;i<form.elements.length;i++)
				    {
				    var e = form.elements[i];
				    if (e.name != 'chkall')
				       e.checked = form.chkall.checked;
				    }
				  }
</script>
<@tt width="700"/>
<div  class="title"><span class=bold>${results["DM.Reload.SiteSpmp4.Result"].name?if_exists}：图片移动</span>
</div>
<div class="content">

	<table>
		<tr>
			<td  align=left >  
			    <br>
				<input class=bt type="checkbox" value="ON" id="chkall" name="chkall" onclick="CheckAll(form_productlink)">全选
	                                          移动到相册<select name="spmp4id"  onchange="changlanguage(this.value);">
	                             <#list results["DM.Reload.SiteUser.Result"].siteSpmp4s as SiteSpmp4>  
		                             <#if SiteSpmp4.id!=results["DM.Reload.SiteSpmp4.Result"].id>
			                             <option value="${SiteSpmp4.id?if_exists}">
			                            	 ${SiteSpmp4.name?if_exists}       
					                     </option>
			                         </#if>
							 	  </#list>
							  </select>
	          <a class=bt href="javascript:form_productlink.submit();">确定</a>
	           <a class=bt href="javascript:history.go(-1);">返回</a>			       		
	     <br> <br>
	     </td> 
		</tr>		
		<tr>
			<td>      	
		        <table>
		            <tr>
				        <#assign i=0/>
						<#assign num=0/>
						<#assign colnum=5/>
						<#assign items=results["DM.Reload.SiteSpmp4.Result"].siteSpmp4Items/>
					    <#list items as x>  
					    <#assign i=i+1/>
					    <td valign=top >
					     
			        		<img   class=img-list  width="100" height="120"   src="/site/${Session["clientlogined"].username?if_exists}/<#if x.filepath?exists>${x.filepath?replace(".", "_sm.")}</#if>" />
			          		<br> <input type="checkbox"   name="moveid"  value="${x.id}">
			          		<br><@strbylanguage v1=x.title v2=x.title2?if_exists v3=x.title3?if_exists />
			          		
			        		
			          	</td>
				             <#if i<colnum><#--每行的个数-->
							 <#else>
							     <#assign i=0/>
							     <#assign num=num+1/>
							     </tr>
							     <tr>
							  </#if>
						</#list>		
				</table>	
			</td>
		</tr>
	</table>	
</div>	
	<input type="hidden" name="DM.business.MoveSpmp4Item" value="">
<form>       								

<@bb/>