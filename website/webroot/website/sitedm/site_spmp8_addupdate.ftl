<#include "/website/include/head_js_css.ftl">
<script language="javascript">
function CheckForm(form) {
	if (form.fileLocation.value.length == 0){
		form.fileLocation.focus();
		return false;
	}
    if(/^.+\.(${Session["clientlogined"].get_video_support_format()?if_exists})$/i.test(form.fileLocation.value)){
		return true;
	}
	else{
	    alert("支持的视频文件格式：${Session["clientlogined"].get_video_support_format()?if_exists}");
		form.fileLocation.focus();
		return false;
	}
}		
</script>
<@tt width=700/>                                                                               
<form  name="uploadFlvForm" action="siteoperationControl.action" method="post" onsubmit="return CheckForm(this);" enctype="multipart/form-data">
	<div class="title" ><span class=info-big>视频描述</span></div>
	<div class="content" >
		<table  width="700">
		 	<tr>
			 	<td >
					<@fckeditupdate user=results["DM.Reload.SiteUser.Result"]  
						vartxt="DM.Instance.SiteSpmp8.detail"  
						title=""
		                v1=results["DM.Reload.SiteSpmp8.Result"].detail?if_exists
		                v2=results["DM.Reload.SiteSpmp8.Result"].detail2?if_exists
		                v3=results["DM.Reload.SiteSpmp8.Result"].detail3?if_exists						  
				      />	
				</td>
			</tr>
			<tr>
				<td>
			    <p align=center>
	            	<input  class=bt type="submit"  value="确定"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	           		<input  class=bt type="button"  value="返回" onclick="javascript:history.go(-1);">
				</p>				
				 </td>
			</tr>
		</table>	
		</div>
		<input  id=oursite_input type="hidden" name="DM.Instance.SiteSpmp8.id" value="${results["DM.Reload.SiteSpmp8.Result"].id}">		
		<input  id=oursite_input type="hidden" name="DM.Update.SiteSpmp8" value="">		

	    <input type="hidden" name="DM.Object.SiteSpmp8" value="SiteSpmp8">                                     
		<input type="hidden" name="DM.Reload.SiteUser" value="SiteUser">
		<input type="hidden" name="DM.Instance.SiteUser.id" value="${results["DM.Reload.SiteUser.Result"].id}">
		<input type="hidden" name="DM.Object.SiteUser" value="SiteUser">
		<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
		<input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/site_spmp8_admin.ftl">		

</form>


<@bb/>

