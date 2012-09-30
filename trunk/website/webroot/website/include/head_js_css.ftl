<#assign LanmuObject=Session["lanmuobject"]/>
<#include "/website/macro/commonfun.ftl">
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="/website/css/content.css" >
<link rel="stylesheet" type="text/css" href="/other/highslide/highslide.css" />
<link rel="stylesheet" type="text/css" href="/common/qtip/20110717/jquery.qtip.css" />
<script type="text/javascript" src="/common/yui330/build/yui/yui-min.js"></script>
<script type="text/javascript" src="/other/jquery151/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="/common/qtip/20110717/jquery.qtip.js"></script>
<script type="text/javascript" src="/website/js/site_admin.js"></script>
<#include "/website/macro/admin_preview.ftl">
<#include "/website/macro/commonfun.ftl">
<#include "/website/macro/map_language_title.ftl">
<#include "/website/macro/fckedit.ftl">
<script type="text/javascript" src="/other/highslide/highslide-with-html.js"></script>
<script type="text/javascript" src="/fckeditor.js"></script>

<script language="javascript"> 
<#assign LanmuObject=Session["lanmuobject"]/>
var common_user_reload="siteoperationControl.action?OT.Forward.success.Type=freemarker"
                        +"&DM.Reload.SiteUser=&DM.Object.SiteUser=SiteUser"
                        +"&DM.Instance.SiteUser.id=${Session["clientlogined"].id?if_exists}&OT.Forward.success.URL=/website/sitedm/";
				 
function lanmupageadmin(siteuserid,pagename,language,local){
	document.getElementById('formlanmuadmin').action="siteoperationControl.action?local="+local+"&language="+language+"&DM.Instance.SiteUser.id="+siteuserid+"&DM.Object.SiteUser=SiteUser&DM.Reload.SiteUser=&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/"+pagename+"&OT.Forward.error.URL=/website/error/operr_admin_tree.ftl&OT.Forward.error.Type=freemarker";  
	document.getElementById('formlanmuadmin').submit();
}
</script>