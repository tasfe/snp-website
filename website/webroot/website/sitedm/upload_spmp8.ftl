<link rel="stylesheet" type="text/css" href="/website/css/content.css" >
<#include "/website/macro/templetehtml.ftl">
<script type="text/javascript" src="/common/swfupload220/swfupload.js"></script>
<script type="text/javascript" src="/common/swfupload220/handlers.js"></script>
<script type="text/javascript" src="/common/swfupload220/swfupload.queue.js"></script>
<script type="text/javascript" src="/common/swfupload220/fileprogress.js"></script>
<script type="text/javascript">
	var swfu;
	window.onload = function() {
		var settings = {			
			flash_url : "/common/swfupload220/swfupload.swf",
			upload_url: "fileupload!filespmp8.action",
            post_params: {"id":"${Session["clientlogined"].id?if_exists}","sitename":"${Session["clientlogined"].username?if_exists}"},				
			file_size_limit : "100 MB",
			file_types : "*.flv",
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
		document.location="siteoperationControl.action?DM.Instance.SiteUser.id=${Session["clientlogined"].id}&DM.Object.SiteUser=SiteUser&DM.Reload.SiteUser=&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/upload_spmp.ftl";
	    parent.document.location="siteoperationControl.action?local=zh-cn&language=1&DM.Instance.SiteUser.id=${Session["clientlogined"].id}&DM.Object.SiteUser=SiteUser&DM.Reload.SiteUser=&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/site_spmp8_admin.ftl";
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



<br>[视频文件列表]<br><br>
<table style="table-layout: fixed" > 
    <#list  results["DM.Reload.SiteUser.Result"].siteSpmp8s as y>
		<#if y.filename?exists >
			<tr>
			    <td id=snp-detail align=left  style="padding-left: 16px;">
			       <a id=snp-detail href="#" >
				    	${y.filename?if_exists}				      	
			      	</a>	
			    </td>
			</tr>                   
											    
		</#if>				   
    </#list>

</table>	


	

