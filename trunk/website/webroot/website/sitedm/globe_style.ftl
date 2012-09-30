<#include "/website/include/head_js_css.ftl">
<script language="javascript">
	var  common=common_user_reload+"globe_style.ftl";
	
	function up_templete(indexStyle,cssstyle){
		parent.menutree.location="siteadmin!refreshUser.action";
		document.getElementById('formlanmuadmin').action =common+"&DM.Instance.SiteUser.indexStyle="+indexStyle+"&DM.Instance.SiteUser.cssStyle="+cssstyle;
		document.getElementById('formlanmuadmin').submit();
	}

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
<form name="formlanmuadmin" id=formlanmuadmin method="post"  target="mainFrame"></form>
<@tt  width="600"/> 
	<div  class="title">色调</div>
	<div class="content">
 	  	<span class=style-color title=blitzer   Style="background:#eeeeee;cursor: hand;<#if results["DM.Reload.SiteUser.Result"].cssStyle=='53'>border:2px solid #f00;<#else>border:1px solid #ccc; </#if> " onclick="up_templete(1,53);">&nbsp; </span>&nbsp; 				
 	  	<span class=style-color title=cupertino   Style="background:#aed0ea;cursor: hand;<#if results["DM.Reload.SiteUser.Result"].cssStyle=='54'>border:2px solid #f00;<#else>border:1px solid #ccc; </#if> " onclick="up_templete(1,54);">&nbsp; </span>&nbsp; 				
 	  	<span class=style-color title=flick   Style="background:#dddddd;cursor: hand;<#if results["DM.Reload.SiteUser.Result"].cssStyle=='50'>border:2px solid #f00;<#else>border:1px solid #ccc; </#if> " onclick="up_templete(1,50);">&nbsp; </span>&nbsp; 				
 	  	<span class=style-color title=humanity   Style="background:#cdc3b7;cursor: hand;<#if results["DM.Reload.SiteUser.Result"].cssStyle=='55'>border:2px solid #f00;<#else>border:1px solid #ccc; </#if> " onclick="up_templete(1,55);">&nbsp; </span>&nbsp; 				
	  	<span class=style-color title=le-frog Style="background:#45930b;cursor: hand;<#if results["DM.Reload.SiteUser.Result"].cssStyle=='51'>border:2px solid #f00;<#else>border:1px solid #ccc; </#if> " onclick="up_templete(1,51);" title="绿色">&nbsp; </span>&nbsp; 				
 	  	<span class=style-color title=overcast   Style="background:#cccccc;cursor: hand;<#if results["DM.Reload.SiteUser.Result"].cssStyle=='56'>border:2px solid #f00;<#else>border:1px solid #ccc; </#if> " onclick="up_templete(1,56);">&nbsp; </span>&nbsp; 				
 	  	<span class=style-color title=redmond   Style="background:#c5dbec;cursor: hand;<#if results["DM.Reload.SiteUser.Result"].cssStyle=='52'>border:2px solid #f00;<#else>border:1px solid #ccc; </#if> " onclick="up_templete(1,52);">&nbsp;</span>&nbsp; 				

 	  	<span class=style-color title=smoothness   Style="background:#d3d3d3;cursor: hand;<#if results["DM.Reload.SiteUser.Result"].cssStyle=='57'>border:2px solid #f00;<#else>border:1px solid #ccc; </#if> " onclick="up_templete(1,57);">&nbsp;</span>&nbsp; 				
 	  	<span class=style-color title=south-street   Style="background:#327e04;cursor: hand;<#if results["DM.Reload.SiteUser.Result"].cssStyle=='58'>border:2px solid #f00;<#else>border:1px solid #ccc; </#if> " onclick="up_templete(1,58);">&nbsp;</span>&nbsp; 				
 	  	<span class=style-color title=sunny   Style="background:#FFA600;cursor: hand;<#if results["DM.Reload.SiteUser.Result"].cssStyle=='59'>border:2px solid #f00;<#else>border:1px solid #ccc; </#if> " onclick="up_templete(1,59);">&nbsp;</span>&nbsp; 				
 	  	<span class=style-color title=start   Style="background:#77d5f7;cursor: hand;<#if results["DM.Reload.SiteUser.Result"].cssStyle=='64'>border:2px solid #f00;<#else>border:1px solid #ccc; </#if> " onclick="up_templete(1,64);">&nbsp;</span>&nbsp; 				

 	  	<span class=style-color title=swanky-purse   Style="background:#362917;cursor: hand;<#if results["DM.Reload.SiteUser.Result"].cssStyle=='60'>border:2px solid #f00;<#else>border:1px solid #ccc; </#if> " onclick="up_templete(1,60);">&nbsp;</span>&nbsp; 				
 	  	<span class=style-color title=trontastic   Style="background:#1b1613;cursor: hand;<#if results["DM.Reload.SiteUser.Result"].cssStyle=='61'>border:2px solid #f00;<#else>border:1px solid #ccc; </#if> " onclick="up_templete(1,61);">&nbsp;</span>&nbsp; 				
 	  	<span class=style-color title=ui-darkness   Style="background:#666666;cursor: hand;<#if results["DM.Reload.SiteUser.Result"].cssStyle=='62'>border:2px solid #f00;<#else>border:1px solid #ccc; </#if> " onclick="up_templete(1,62);">&nbsp;</span>&nbsp; 				
 	  	<span class=style-color title=ui-lightness   Style="background:#cccccc;cursor: hand;<#if results["DM.Reload.SiteUser.Result"].cssStyle=='63'>border:2px solid #f00;<#else>border:1px solid #ccc; </#if> " onclick="up_templete(1,63);">&nbsp;</span>&nbsp; 				

       <br><br>
 	  	<span class=style-color Style="cursor: hand;<#if results["DM.Reload.SiteUser.Result"].cssStyle=='11'>border:2px solid #f00;<#else>border:1px solid #ccc; </#if> " onclick="up_templete(1,11);">&nbsp;</span>&nbsp; 				
	  	<span class=style-color Style="background:#468cad;<#if results["DM.Reload.SiteUser.Result"].cssStyle=='15'>border:2px solid #f00;<#else>border:1px solid #ccc; </#if>" onclick="up_templete(1,15);">&nbsp;</span>&nbsp; 
      	<span class=style-color Style="background:#f00;<#if results["DM.Reload.SiteUser.Result"].cssStyle=='10'>border:4px solid #f00;<#else>border:1px solid #ccc; </#if>" onclick="up_templete(1,10);">&nbsp;</span>&nbsp; 	
      		
      	<span class=style-color Style="background:#A7D11C;<#if results["DM.Reload.SiteUser.Result"].cssStyle=='9'>border:2px solid #f00;<#else>border:1px solid #ccc; </#if>" onclick="up_templete(1,9);">&nbsp;</span>&nbsp; 	
      	<span class=style-color Style="background:#A9B8DF;<#if results["DM.Reload.SiteUser.Result"].cssStyle=='13'>border:2px solid #f00;<#else>border:1px solid #ccc; </#if>" onclick="up_templete(1,13);">&nbsp;</span>&nbsp; 
 		<span class=style-color Style="color:#fff;background:#000;<#if results["DM.Reload.SiteUser.Result"].cssStyle=='1'>border:2px solid #f00;<#else>border:1px solid #ccc; </#if>" onclick="up_templete(1,1);">1</span>&nbsp; 			
 		<span class=style-color Style="color:#fff;background:#000;<#if results["DM.Reload.SiteUser.Result"].cssStyle=='12'>border:2px solid #f00;<#else>border:1px solid #ccc; </#if>" onclick="up_templete(1,12);">2</span>&nbsp; 			
		<#--
		<span class=style-color Style="background:#396106;<#if results["DM.Reload.SiteUser.Result"].cssStyle=='14'>border:2px solid #f00;<#else>border:1px solid #ccc; </#if>" onclick="up_templete(1,14);">&nbsp;</span>&nbsp; 		 		
 		-->
 		<span class=style-color Style="background:#2AB7EE; <#if results["DM.Reload.SiteUser.Result"].cssStyle=='16'>border:2px solid #f00;<#else>border:1px solid #ccc; </#if>" onclick="up_templete(1,16);">&nbsp;</span>&nbsp; 
	
	</div>
	
	<div class="title">排版布局</div>
	<div class="content" >
	   <table>
		   <tr>
			   <td>
			   	   <br>
			   	   <table>
				   	   <tr>
				   	   	   <td style="border:1px solid #ccc;">&nbsp;</td>
				   	   	   <td style="border:1px solid #ccc;">&nbsp;&nbsp;&nbsp;</td>
				   	   	   <td style="border:1px solid #ccc;">&nbsp;</td>
				   	   </tr>
				   </table>
				   <br>
			   </td>
			   <td> 
			       <br>网站整体显示列模式
				   <span class=style-layout style="<#if LanmuObject.lanmualldirdisplay=="none">border:2px solid #f00;<#else>border:1px solid #ccc;</#if>"  onclick="javascript:update_setting('lanmualldirdisplay','none','globe_style.ftl');">1列</span>
				   <span class=style-layout style="<#if LanmuObject.lanmualldirdisplay=="">border:2px solid #f00;<#else>border:1px solid #ccc;</#if>"     onclick="javascript:update_setting('lanmualldirdisplay','','globe_style.ftl');">3列</span>
				   <span class=style-layout style="<#if LanmuObject.lanmualldirdisplay=="onlyleft">border:2px solid #f00;<#else>border:1px solid #ccc;</#if>"  onclick="javascript:update_setting('lanmualldirdisplay','onlyleft','globe_style.ftl');">左2列</span>
				   <span class=style-layout style="<#if LanmuObject.lanmualldirdisplay=="onlyright">border:2px solid #f00;<#else>border:1px solid #ccc;</#if>"  onclick="javascript:update_setting('lanmualldirdisplay','onlyright','globe_style.ftl');">右2列</span>
			   </td>
		   </tr>
	   </table>	
		网站整体布局
		<span class=style-layout Style="<#if LanmuObject.fullscreen=="full">border:2px solid #f00;<#else>border:1px solid #ccc; </#if>  " onclick="javascript:update_setting('fullscreen','full','globe_style.ftl');">
		    &nbsp;全屏显示&nbsp;   
	    </span>&nbsp;&nbsp;&nbsp;   
		<span  class=style-layout  Style="<#if LanmuObject.fullscreen=="left">border:2px solid #f00;<#else>border:1px solid #ccc; </#if>  " onclick="javascript:update_setting('fullscreen','left','globe_style.ftl');">
		    &nbsp;居左&nbsp;  
	    </span>&nbsp;&nbsp;&nbsp;   
		<span  class=style-layout Style="<#if LanmuObject.fullscreen=="">border:2px solid #f00;<#else>border:1px solid #ccc; </#if>  " onclick="javascript:update_setting('fullscreen','','globe_style.ftl');">
		    &nbsp;居中 &nbsp; 
	    </span>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;   
	     
	    <br><br>          
	                   栏目标题对齐位置
		<span class=style-layout Style="<#if LanmuObject.lanmudiralign=="right">border:2px solid #f00;<#else>border:1px solid #ccc; </#if>  " onclick="javascript:update_setting('lanmudiralign','right','globe_style.ftl');">
		    &nbsp;靠右&nbsp;   
	    </span>&nbsp;&nbsp;&nbsp;   
		<span  class=style-layout  Style="<#if LanmuObject.lanmudiralign=="left">border:2px solid #f00;<#else>border:1px solid #ccc; </#if>  " onclick="javascript:update_setting('lanmudiralign','left','globe_style.ftl');">
		    &nbsp;靠左&nbsp;  
	    </span>&nbsp;&nbsp;&nbsp;   
		<span  class=style-layout Style="<#if LanmuObject.lanmudiralign=="">border:2px solid #f00;<#else>border:1px solid #ccc; </#if>  " onclick="javascript:update_setting('lanmudiralign','','globe_style.ftl');">
			&nbsp;中间 &nbsp; 
	    </span>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;   

		<br>
		<br>
		
		<br>		 		 
	</div>
<@bb/>
<@preview_iframe "index.ftl" />

</HTML>
