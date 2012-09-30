<link rel="stylesheet" type="text/css" href="/website/css/content.css" >
<#include "/website/macro/templetehtml.ftl">
<#assign SiteSpmp=results["DM.Reload.SiteSpmp5.Result"]/>	
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
<script type="text/javascript" src="/common/swfupload220/swfupload.js"></script>
<script type="text/javascript" src="/common/swfupload220/handlers.js"></script>
<script type="text/javascript" src="/common/swfupload220/swfupload.queue.js"></script>
<script type="text/javascript" src="/common/swfupload220/fileprogress.js"></script>
<script type="text/javascript" src="/common/iframe.js"></script>
<script type="text/javascript">
	var swfu;
	window.onload = function() {
		var settings = {			
			flash_url : "/common/swfupload220/swfupload.swf",
			upload_url: "fileupload!filespmp5.action",
			post_params: {"id" : "${results["DM.Reload.SiteSpmp5.Result"].id?if_exists}","sitename":"${Session["clientlogined"].username?if_exists}"},		
			file_size_limit : "100 MB",
			file_types : "*.*",
			file_types_description : "All Files",

			flash_url : "/common/swfupload220/swfupload.swf",
			flash9_url : "/js/swfupload/swfupload_fp9.swf",
			file_upload_limit : 100,
			file_queue_limit : 0,
			custom_settings : { //自定义了进度条和取消
				progressTarget : "fsUploadProgress",
				cancelButtonId : "btnCancel"
			},
			debug: false,
			// Button settings
        	button_image_url : "/common/swfupload220/SmallSpyGlassWithTransperancy_17x18.png",
			button_placeholder_id : "spanButtonPlaceholder",
			button_width: 180,
			button_height: 18,
			button_text : '<span class="button">选择要上传的文件 <span class="buttonSmall"></span></span>',
			button_text_style : '.button { font-family: Helvetica, Arial, sans-serif; font-size: 12pt; } .buttonSmall { font-size: 10pt; }',
			button_text_top_padding: 0,
			button_text_left_padding: 18,
			button_window_mode: SWFUpload.WINDOW_MODE.TRANSPARENT,
			button_cursor: SWFUpload.CURSOR.HAND,

			// The event handler functions are defined in handlers.js
			file_queued_handler : fileQueued,
			file_queue_error_handler : fileQueueError,
			file_dialog_complete_handler : fileDialogComplete,
			upload_start_handler : uploadStart,
			upload_progress_handler : uploadProgress,
			//upload_error_handler : uploadError,
			upload_success_handler : uploadSuccess,
			upload_complete_handler : uploadComplete,
			queue_complete_handler : queueComplete	// Queue plugin event
		};
		swfu = new SWFUpload(settings);
     };
	function queueComplete(numFilesUploaded) {
		//var preview_url=parent.document.getElementById("iframe_preview").src;
		//parent.document.getElementById("iframe_preview").src=preview_url;
		//alert(preview_url);
		document.location="siteoperationControl.action?DM.Instance.SiteUser.id=${Session["clientlogined"].id}&DM.Object.SiteUser=SiteUser&DM.Reload.SiteUser=&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/upload_spmp5.ftl&DM.Reload.SiteSpmp5=&DM.Instance.SiteSpmp5.id=${results["DM.Reload.SiteSpmp5.Result"].id?if_exists}&DM.Object.SiteSpmp5=SiteSpmp5";
	    parent.document.location="siteoperationControl.action?local=zh-cn&language=1&DM.Instance.SiteUser.id=${Session["clientlogined"].id}&DM.Object.SiteUser=SiteUser&DM.Reload.SiteUser=&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/site_spmp5_admin.ftl";
	}
	function close_iframe(){
	}	
</script>


<form name="formlanmuadmin" method="post"  target="mainFrame"></form>

<div id="content">
	<div>
		<div style="display: inline; border: solid 1px #7FAAFF; background-color: #C5D9FF; padding: 2px;">
			<span id="spanButtonPlaceHolder" ></span>
		</div>
		<input id="btnCancel" type="button" value="取消所有队列" onclick="swfu.cancelQueue();" disabled="disabled" style="margin-left: 2px; font-size: 8pt; height: 29px;display:none" />
   	   <#-- <input  class=bt type="button" value="关闭"  onclick="javascript:close_iframe();" /> -->
  	  
	</div>	
	<div class="flash" id="fsUploadProgress" style="float:right;"></div>	  
</div>



<br>[文件列表]<br><br>
<table style="table-layout: fixed" > 
    <#list SiteSpmp.getSubItems() as y>
		<#if y.filename?exists >
			<tr>
			    <td id=snp-detail align=left  style="padding-left: 16px;">
			       <a id=snp-detail href="#" >
				    	<@strbylanguage v1=y.detail v2=y.detail2?if_exists v3=y.detail3?if_exists />
						<#if y.detail?exists&&y.detail!=""><#else>${y.filename?if_exists}</#if>						      	
			      	</a>	
			    </td>
			</tr>                   
		<#else>
			<tr>
			    <td id=snp-detail align=left>
                    <@strbylanguage v1=y.detail?if_exists v2=y.detail2?if_exists v3=y.detail3?if_exists />
				</td>
			</tr>										    
		</#if>				   
    </#list>

</table>	


	

