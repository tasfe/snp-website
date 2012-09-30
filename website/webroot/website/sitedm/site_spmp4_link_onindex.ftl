<link href="/website/css/content.css" rel="stylesheet" type="text/css">
<script language="javascript" src="/website/js/site_admin.js"></script>
<#include "/website/macro/commonfun.ftl">
<#assign SiteUser=results["DM.Reload.SiteUser.Result"]/>
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


<script language="javascript">
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
<br>
<@tt width="600"/>
<form name="form_productlink" action="siteoperationControl.action" method="post"  >
<div  class="title">
    <span class=bold>选择在首页中显示的图片（请选择5张以上已产生滚动效果）：</span>
</div>

<div  class="content">
<table>
    <#if SiteUser.spmp4Lanmu?exists>
		<tr>
			<td align=left id=sa-bd >
				 <a class=bt href="javascript:form_productlink.submit();">确定</a> 
	            <a class=bt href="javascript:history.go(-1);">返回</a>		
	            <input type="checkbox" value="ON" id="chkall" name="chkall" onclick="CheckAll(form_productlink)"><span class=bold>全选</span>
	            <hr>  	       
	  		</td>
	  	</tr>		  	
	  	<tr>
	  		<td id=sa-bd >
			    <table >
					<tr>
						<td  align=left id=oursite_tb_data>  	
						<#list SiteUser.siteSpmp4s as x>
				  			 <b><@strbylanguage v1=x.name v2=x.name2?if_exists v3=x.name3?if_exists /></b>
					  			<table>
						            <tr>
							        <#assign i=0/>
									<#assign num=0/>
									<#assign colnum=5/>
									<#assign items=x.siteSpmp4Items/>
									   <#list items as x>  
									   <#assign i=i+1/>
									   <td valign=top  style="">
									   <input type="checkbox"   name="productlink"  value="${x.id}"
													<#if  results["DM.Reload.SiteUser.Result"].productlinkstring?exists>
														<#if results["DM.Reload.SiteUser.Result"].productlinkstring?index_of(x.id+',')<0><#else>checked</#if> 
													<#else>
													</#if>
											><@strbylanguage v1=x.title v2=x.title2?if_exists v3=x.title3?if_exists />	
											<br>
									    <img   id=snp-image width=${x.getImg_spmp4_sm_width()?if_exists} height=${x.getImg_spmp4_sm_height()?if_exists}  src="/site<#if x.filepath?exists>${x.filepath?replace(".", "_sm.")}</#if>" />
											
																	        		
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
						</#list>
					    </td>
				    </tr>
				</table>
			</td>
		</tr>
   <#else>
   </#if>   
        <input type="hidden" name="DM.business.UpdateProductLink" value="">
	    	
	    	
	    <input type="hidden" name="DM.Reload.SiteUser" value="SiteUser">
	    <input type="hidden" name="DM.Instance.SiteUser.id" value="${results["DM.Reload.SiteUser.Result"].id}">
	    <input type="hidden" name="DM.Object.SiteUser" value="SiteUser">
	    <input type="hidden" name="OT.Forward.success.Type" value="freemarker">
	    <input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/site_spmp4_admin.ftl"> 
	    <input type="hidden" name="flag" value="home">
</form>
</table>
</div>
<@bb/>
