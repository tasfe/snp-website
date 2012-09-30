<#macro singleadmin beaname lanmutemplete  qianzhui title spmp >
<#assign LanmuObject=Session["lanmuobject"]/>
<#include "/website/include/head_js_css.ftl">
<script language="javascript">

	function	update_setting(name,value,page){
		   var  action=common_user_reload
                             +page
                             +"&DM.business.LanmuSetting="
                             +"&DM.Reload.SiteUser.__Depends=DM.business.LanmuSetting"  
                             +"&paraname="+name
                             +"&"+name+"="+value
                             +"&userid=${Session["clientlogined"].id?if_exists}"
           document.getElementById('formlanmuadmin').action=action;
		   document.getElementById('formlanmuadmin').submit();	    		
	
		}	
		
	
									       
</script>	

<body>
	<form name="formlanmuadmin" id="formlanmuadmin" method="post"  target="mainFrame"></form>

	<#assign listx = []>
	<#list spmp as P0>
		<#assign listx = listx + [P0]>
	</#list>				
<div class="area-edit">
    <table>
	    <tr>
		    <td width=680>
				<div class="title" >QQ在线咨询设置   </div>
			 	<div class="content" >
			 		<br> 如果想显示多个QQ号码，请用逗号隔开.&nbsp;&nbsp;&nbsp;&nbsp;例如：8323233,3332298
			 		<br> 如果需要显示职位，请在QQ号后面用冒号说明职位.&nbsp;&nbsp;&nbsp;&nbsp;例如:8323233:经理,3332298：销售
			 		<br>
					<br><img  src="../../other/qq_online.gif" align="absmiddle" >&nbsp;&nbsp;网站右边
					 <input  class=input  size="80" onchange="javascript:update_setting('qq',this.value,'globe_qq.ftl');"  type="text" name="qq" value="${LanmuObject.qq?if_exists}"> 
					<br><img  src="../../other/qq_online.gif" align="absmiddle" >&nbsp;&nbsp;网站顶部
					 <input  class=input  size="80" onchange="javascript:update_setting('qqtop',this.value,'globe_qq.ftl');"  type="text" name="qq" value="${LanmuObject.qqtop?if_exists}"> 
					<br><img  src="../../other/qq_online.gif" align="absmiddle" >&nbsp;&nbsp;网站左部
					 <input  class=input  size="80" onchange="javascript:update_setting('qqleft',this.value,'globe_qq.ftl');"  type="text" name="qq" value="${LanmuObject.qqleft?if_exists}"> 
					<br><img  src="../../other/qq_online.gif" align="absmiddle" >&nbsp;&nbsp;网站底部
					 <input  class=input  size="80" onchange="javascript:update_setting('qqbottom',this.value,'globe_qq.ftl');"  type="text" name="qq" value="${LanmuObject.qqbottom?if_exists}"> 
			        
				</div>
			</td>
		</tr>
	</table>
</div>

<@preview_iframe "${lanmutemplete}" />		
</#macro>		

<@singleadmin beaname="SiteLink" lanmutemplete="index.ftl"  qianzhui="site_link" title=""  spmp=results["DM.Reload.SiteUser.Result"].siteLinks/>
