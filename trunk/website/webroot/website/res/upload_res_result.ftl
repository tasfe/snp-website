<html>
<script src="/website/js/cookie.js" type="text/javascript"></script>
<script typt="text/javascript">
function change_parent(){
   //alert(parent.document.getElementById("txtUrl").value);
   parent.document.getElementById("txtUrl").value="../../site/${results["DM.Reload.SiteUser.Result"].username}/${results["filepath"]?if_exists}";
   parent.document.getElementById("txtUrl").onblur();
   document.location="/resoperationControl.action?DM.Instance.SiteUser.id=${results["DM.Reload.SiteUser.Result"].id}&DM.Object.SiteUser=SiteUser&DM.Reload.SiteUser=&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/res/upload_res.ftl&filetype=${tempvar["filetype"]}"
   
}
</script>
<body onload="change_parent()">

</body>
</html>