<link href="../website/css/content.css" rel="stylesheet" type="text/css">

<script language="javascript" src="/website/js/site_admin.js"></script>

<script>
var rT=true;//允许图像过渡  这段脚本是用来做消息提示用的
var bT=true;//允许图像淡入淡出
var tw=150;//提示框宽度
var endaction=false;//结束动画

var ns4 = document.layers;
var ns6 = document.getElementById && !document.all;
var ie4 = document.all;
offsetX = 0;
offsetY = 20;
var toolTipSTYLE="";
function initToolTips()
{
  if(ns4||ns6||ie4)
  {
    if(ns4) toolTipSTYLE = document.toolTipLayer;
    else if(ns6) toolTipSTYLE = document.getElementById("toolTipLayer").style;
    else if(ie4) toolTipSTYLE = document.all.toolTipLayer.style;
    if(ns4) document.captureEvents(Event.MOUSEMOVE);
    else
    {
      toolTipSTYLE.visibility = "visible";
      toolTipSTYLE.display = "none";
    }
    document.onmousemove = moveToMouseLoc;
  }
}
function toolTip(msg, fg, bg)
{
  if(toolTip.arguments.length < 1) // hide
  {
    if(ns4) 
    {
    toolTipSTYLE.visibility = "hidden";
    }
    else 
    {
      if (!endaction) {toolTipSTYLE.display = "none";}
      if (rT) document.all("msg1").filters[1].Apply();
      if (bT) document.all("msg1").filters[2].Apply();
      document.all("msg1").filters[0].opacity=0;
      if (rT) document.all("msg1").filters[1].Play();
      if (bT) document.all("msg1").filters[2].Play();
      if (rT){ 
      if (document.all("msg1").filters[1].status==1 || document.all("msg1").filters[1].status==0){  
      toolTipSTYLE.display = "none";}
      }
      if (bT){
      if (document.all("msg1").filters[2].status==1 || document.all("msg1").filters[2].status==0){  
      toolTipSTYLE.display = "none";}
      }
      if (!rT && !bT) toolTipSTYLE.display = "none";
      //----------------------
    }
  }
  else // show
  {
    if(!fg) fg = "#777777";
    if(!bg) bg = "#eeeeee";
    var content =
    '<table id="msg1" name="msg1" border="0" cellspacing="0" cellpadding="1" bgcolor="' + fg + '" class="trans_msg"><td>' +
    '<table border="0" cellspacing="0" cellpadding="3" bgcolor="' + bg + 
    '"><td width=' + tw + '><font face="Arial" color="' + fg +
    '" size="-2">' + msg +
    '&nbsp;</font></td></table></td></table>';

    if(ns4)
    {
      toolTipSTYLE.document.write(content);
      toolTipSTYLE.document.close();
      toolTipSTYLE.visibility = "visible";
    }
    if(ns6)
    {
      document.getElementById("toolTipLayer").innerHTML = content;
      toolTipSTYLE.display='block'
    }
    if(ie4)
    {
      document.all("toolTipLayer").innerHTML=content;
      toolTipSTYLE.display='block'
      //--图象过渡，淡入处理--
      var cssopaction=document.all("msg1").filters[0].opacity
      document.all("msg1").filters[0].opacity=0;
      if (rT) document.all("msg1").filters[1].Apply();
      if (bT) document.all("msg1").filters[2].Apply();
      document.all("msg1").filters[0].opacity=cssopaction;
      if (rT) document.all("msg1").filters[1].Play();
      if (bT) document.all("msg1").filters[2].Play();
      //----------------------
    }
  }
}
function moveToMouseLoc(e)
{
  if(ns4||ns6)
  {
    x = e.pageX;
    y = e.pageY;
  }
  else
  {
    x = event.x + document.body.scrollLeft;
    y = event.y + document.body.scrollTop;
  }
  toolTipSTYLE.left = x + offsetX;
  toolTipSTYLE.top = y + offsetY;
  return true;
}
</script>

<#include "../macro/option_dir.ftl">		
<#include "../macro/option_templete_client.ftl">

<#include "/website/macro/commonfun.ftl">
<#include "/website/macro/admin_preview.ftl">

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
	var  op_string="siteoperationControl.action?OT.Forward.success.Type=freemarker"
                    +"&DM.Reload.SiteUser=SiteUser&DM.Update.SiteUser=SiteUser&DM.Reload.SiteUser.__Depends=DM.Update.SiteUser"
                     +"&DM.Instance.SiteUser.id=${results["DM.Reload.SiteUser.Result"].id}&DM.Object.SiteUser=SiteUser";

	var  common=op_string+"&OT.Forward.success.URL=/website/sitedm/globe_style.ftl";
	var  op_css_define=op_string+"&OT.Forward.success.URL=/website/sitedm/site_selfdefine_css.ftl";
	
	function up_lg_default(value){
		document.getElementById('formlanmuadmin').action =common+"&DM.Instance.SiteUser.local="+value;
		document.getElementById('formlanmuadmin').submit();
	}
	function up_lg_local2(value){
		document.getElementById('formlanmuadmin').action =common+"&DM.Instance.SiteUser.local2="+value;
		document.getElementById('formlanmuadmin').submit();
	}	
	function up_lg_language2(value){
		document.getElementById('formlanmuadmin').action =common+"&DM.Instance.SiteUser.language2="+value;
		document.getElementById('formlanmuadmin').submit();
	}	
	function up_lg_local3(value){
		document.getElementById('formlanmuadmin').action =common+"&DM.Instance.SiteUser.local3="+value;
		document.getElementById('formlanmuadmin').submit();
	}	
	function up_lg_language3(value){
		document.getElementById('formlanmuadmin').action =common+"&DM.Instance.SiteUser.language3="+value;
		document.getElementById('formlanmuadmin').submit();
	}		
	function up_style_css(value){
		document.getElementById('formlanmuadmin').action =common+"&DM.Instance.SiteUser.cssStyle="+value;
		document.getElementById('formlanmuadmin').submit();
	}
	function up_style_dir(value){
		document.getElementById('formlanmuadmin').action =common+"&DM.Instance.SiteUser.dirStyle="+value;
		document.getElementById('formlanmuadmin').submit();
	}	
	function updatestyle(indexstyle,dirstyle){
			document.getElementById('formlanmuadmin').action =common+"&DM.Instance.SiteUser.cssStyle="+indexstyle+"&DM.Instance.SiteUser.dirStyle="+dirstyle;
		document.getElementById('formlanmuadmin').submit();
	}	

	function closeselfdefine(selfdefine){
			document.getElementById('formlanmuadmin').action =common+"&DM.Instance.SiteUser.cssdefineself="+selfdefine;
		document.getElementById('formlanmuadmin').submit();
	}
	function openselfdefine(selfdefine){
			document.getElementById('formlanmuadmin').action =op_css_define+"&DM.Instance.SiteUser.cssdefineself="+selfdefine;
		document.getElementById('formlanmuadmin').submit();
	}	
</script>

<body style="background: #fff;">
<#include "/website/macro/commonfun.ftl">
<#macro listclasses classes   actionname title title2 title3>
	<#if title=="">
	<#else>
        <table cellspacing="0" cellpadding="1" border="0" >
        <tbody>
            <tr>
                <td colspan="2" id=snp-listclasses-title ><@strbylanguage v1=title v2=title2  v3=title3/></td>
            </tr>
            <#list classes as x>
            <tr>
                <td colspan="2" height="10"><img height="1" alt="" width="1" border="0" src="/images/index/blank.gif" /></td>
            </tr>
            <tr>
                <td><img height="3" alt="" width="3" align="absMiddle" border="0" src="/images/index/bult_com1.gif" /></td>
                <td >
                <a style="padding:0px 1px 0px 0px;" href="site!${actionname}.action?id=#{x.id}&fullscreen=${Session["lanmuobject"].fullscreen}" target=_self><@strbylanguage v1=x.name v2=x.name2?if_exists v3=x.name3?if_exists /></a>	</td>
            </tr>
            <tr>
                <td colspan="2"><img height="1" alt="" width="150" border="0" src="/images/index/main_dot.gif" /></td>
            </tr>
            </#list>
        </tbody>
    </table>		
		
	</#if>			    		
</#macro> 

<link type="text/css" title="www" rel="stylesheet" media="all" href="/sitetemplateweb/index/16/main${Session["lanmuobject"].fullscreen}.css" />
<link type="text/css" title="www" rel="stylesheet" media="all" href="/sitetemplateweb/include/css_lanmu/${results["DM.Reload.SiteUser.Result"].cssStyle?default("0")?if_exists}.css" />
<link type="text/css" title="www" rel="stylesheet" media="all" href="/sitetemplateweb/include/dir/${results["DM.Reload.SiteUser.Result"].dirStyle?default("0")?if_exists}.css" />
<br>素材库连接
<#list results["DM.Reload.SiteUser.Result"].sitePresources as SitePresource>
	<#if SitePresource.filetype=="pic">
		<#assign str_picture='<img src=/site'+SitePresource.filepath+' height=159  width=235 border=0>'/>
        <br>
        <span  onmouseout="toolTip();" onMouseOver="toolTip('${str_picture}');">${str_picture?html} </span>    
	<#else>
	
	</#if>
</#list>
	
<p><b>FTP空间文件连接代码(复制URL就可以在网店商品描述中使用)</b></P>
<p>
<b>图片文件</b>
<#if results["DM.Reload.SiteUser.Result"].getFtpFile()["picture"]?exists>
	<#list results["DM.Reload.SiteUser.Result"].getFtpFile()["picture"] as path>
	    
	    <#assign str_picture='<img src='+results["DM.Reload.SiteUser.Result"].getWebPath(path) +' height=159  width=235 border=0>'/>
	    <br>
	    <span  onmouseout="toolTip();" onMouseOver="toolTip('${str_picture}');">${str_picture?html} </span>    
	</#list>   
</#if>
</p>	

<p><br>
<b>视频文件文件</b>
<#list results["DM.Reload.SiteUser.Result"].getFtpFile()["video"] as path>
	   <#assign str_video='<object classid=clsid:D27CDB6E-AE6D-11cf-96B8-444553540000 codebase=http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0 width=240 height=140>'
		+'<param name=movie value=/other/video/vcastr22.swf>'
		+'<param name=FlashVars value=\'LogoText=www.snpsoft.net&allowFullScreen=true&IsAutoPlay=1&vcastr_file='+results["DM.Reload.SiteUser.Result"].getWebPath(path) +'\'/></object>'/>
		<br>${str_video?html} <br>
</#list>   
</p>	


<p><br><b>[${results["DM.Reload.SiteUser.Result"].spmp4Lanmu}]图片栏目中的图片</b></p> 
	<#list results["DM.Reload.SiteUser.Result"].siteSpmp4s as x>
		<br><b>${x.name}</b>
		 <#list x.siteSpmp4Items as y>
		       <#if y.filepath?exists>
		       <br> <#assign aa='<img src=http://'+results["DM.Reload.SiteUser.Result"].getDomainname()+'/site'+y.filepath+ ' width=40 height=50  border=0>'/>
				 <img src=/site<#if y.filepath?exists>${y.filepath?replace(".", "_sm.")}</#if> width=40 height=50  border=0>${y.title}
				 连接代码：
				 ${aa?html}
			   </#if>
		  </#list>
	 </#list>
	

<p><b>各栏目连接目录列表</b></P>
    <table cellspacing="0" cellpadding="0"  border="0">
            <tr>
                <td valign="top" >
					<@listclasses classes=results["DM.Reload.SiteUser.Result"].siteSpmp1s  actionname="siteSpmp1Detail" title=results["DM.Reload.SiteUser.Result"].spmp1Lanmu?if_exists title2=results["DM.Reload.SiteUser.Result"].spmp1Lanmu2?if_exists title3=results["DM.Reload.SiteUser.Result"].spmp1Lanmu3?if_exists/>
                </td>
                <td valign="top"  style=" padding:0px 0 0 16px; ">
					<@listclasses classes=results["DM.Reload.SiteUser.Result"].siteSpmp2s  actionname="siteSpmp2Detail" title=results["DM.Reload.SiteUser.Result"].spmp2Lanmu?if_exists title2=results["DM.Reload.SiteUser.Result"].spmp2Lanmu2?if_exists title3=results["DM.Reload.SiteUser.Result"].spmp2Lanmu3?if_exists/>
                </td>
                <td valign="top"  style=" padding:0px 0 0 16px; ">
					<@listclasses classes=results["DM.Reload.SiteUser.Result"].siteSpmp3s  actionname="siteSpmp3Detail" title=results["DM.Reload.SiteUser.Result"].spmp3Lanmu?if_exists title2=results["DM.Reload.SiteUser.Result"].spmp3Lanmu2?if_exists title3=results["DM.Reload.SiteUser.Result"].spmp3Lanmu3?if_exists/>
                </td> 
                <td valign="top"  style=" padding:0px 0 0 16px; ">
					<@listclasses classes=results["DM.Reload.SiteUser.Result"].siteSpmp6s  actionname="siteSpmp6Detail" title=results["DM.Reload.SiteUser.Result"].spmp6Lanmu?if_exists title2=results["DM.Reload.SiteUser.Result"].spmp4Lanmu2?if_exists title3=results["DM.Reload.SiteUser.Result"].spmp4Lanmu3?if_exists/>
                </td>                              
            </tr>

    </table>
<hr>
<p>
    <b> QQ代码</b><br>
		<textarea cols=80 rows=5 id=oursite_input><script>document.write("<a target=blank href=tencent://message/?uin=33333&Site=www.snpsoft.net&Menu=yes><img align=absmiddle border=0  src=../../other/qq_online.gif >职位</a>");</script>
		</textarea>
</p>		
<hr>
<p>
    <b>iframe代码</b><br>
     <textarea cols=80 rows=5 id=oursite_input><iframe id="iframe-link" name="iframe-link" src="" frameborder="0" width="710" scrolling="no" height="240"></iframe>	
     </textarea>
</p>




