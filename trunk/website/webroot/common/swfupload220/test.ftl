
<style type="text/css">
	.swfupload {
		position: absolute;
		z-index: 1;
	}
</style>

<script type="text/javascript" src="swfupload.js"></script>
<script type="text/javascript" src="fileprogress.js"></script>
<script type="text/javascript" src="swfupload.queue.js"></script>
<script type="text/javascript" src="handlers.js"></script>
<script type="text/javascript" src="swfupload.swfobject.js"></script>
<script type="text/javascript">
var swfu;
SWFUpload.onload = function () {
	var settings = {
		flash_url : "swfupload.swf",
		upload_url: "upload.php",
		file_size_limit : "100 MB",
		file_types : "*.*",
		file_types_description : "All Files",
		file_upload_limit : 100,
		file_queue_limit : 0,
		custom_settings : {
			progressTarget : "fsUploadProgress",
			cancelButtonId : "btnCancel"
		},
		debug: false,

		// Button Settings
		button_placeholder_id : "spanButtonPlaceholder",
		button_width: 61,
		button_height: 22,
		button_window_mode: SWFUpload.WINDOW_MODE.TRANSPARENT,
		button_cursor: SWFUpload.CURSOR.HAND,

		// The event handler functions are defined in handlers.js
		swfupload_loaded_handler : swfUploadLoaded,
		file_queued_handler : fileQueued,
		file_queue_error_handler : fileQueueError,
		file_dialog_complete_handler : fileDialogComplete,
		upload_start_handler : uploadStart,
		upload_progress_handler : uploadProgress,
		upload_error_handler : uploadError,
		upload_success_handler : uploadSuccess,
		upload_complete_handler : uploadComplete,
		queue_complete_handler : queueComplete,	// Queue plugin event
		
		// SWFObject settings
		minimum_flash_version : "9.0.28",
		swfupload_pre_load_handler : swfUploadPreLoad,
		swfupload_load_failed_handler : swfUploadLoadFailed
	};

	swfu = new SWFUpload(settings);
}

</script>
<form id="form1" action="index.php" method="post" enctype="multipart/form-data">
	<div id="divSWFUploadUI">
		<div class="fieldset flash" id="fsUploadProgress">
		
		</div>
		<p id="divStatus"></p>
		<p>
			<span id="spanButtonPlaceholder"></span>
			<input id="btnUpload" type="button" value="Select Files" style="width: 61px; height: 22px; font-size: 8pt;" />
			<input id="btnCancel" type="button" value="Cancel All Uploads" disabled="disabled" style="margin-left: 2px; height: 22px; font-size: 8pt;" />
		</p>
		<br style="clear: both;" />
	</div>
	<noscript style="background-color: #FFFF66; border-top: solid 4px #FF9966; border-bottom: solid 4px #FF9966; margin: 10px 25px; padding: 10px 15px;">
		您禁止了使用脚本
	</noscript>
	<div id="divLoadingContent" class="content" style="background-color: #FFFF66; border-top: solid 4px #FF9966; border-bottom: solid 4px #FF9966; margin: 10px 25px; padding: 10px 15px; display: none;">
		请稍候...
	</div>
	<div id="divLongLoading" class="content" style="background-color: #FFFF66; border-top: solid 4px #FF9966; border-bottom: solid 4px #FF9966; margin: 10px 25px; padding: 10px 15px; display: none;">
		太长时间加载，请检查FLASH版本是否安装
      
	</div>
	<div id="divAlternateContent" class="content" style="background-color: #FFFF66; border-top: solid 4px #FF9966; border-bottom: solid 4px #FF9966; margin: 10px 25px; padding: 10px 15px; display: none;">
		请下载FLASH播放器.
		Visit the <a href="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash">Adobe website</a> to get the Flash Player.
	</div>
</form>
