				flash_url : "/js/swfupload/swfupload.swf",
				flash9_url : "/js/swfupload/swfupload_fp9.swf",
				file_upload_limit : 100,
				file_queue_limit : 0,
				custom_settings : { //自定义了进度条很取消
					progressTarget : "fsUploadProgress",
					cancelButtonId : "btnCancel"
				},
				debug: false,
				// Button settings
				button_image_url: "/images/swfupload/TestImageNoText_65x29.png",
				button_width: "60",
				button_height: "22",
				button_placeholder_id: "spanButtonPlaceHolder",

				button_text_style: ".theFont { font-size: 12; }",
				button_text_left_padding: 5,
				button_text_top_padding: 3,
				// The event handler functions are defined in handlers.js
				file_queued_handler : fileQueued,
				file_queue_error_handler : fileQueueError,
				file_dialog_complete_handler : fileDialogComplete,
				
				upload_start_handler : uploadStart,
				upload_progress_handler : uploadProgress,
				upload_error_handler : uploadError,
				upload_success_handler : uploadSuccess,
				upload_complete_handler : uploadComplete,
				queue_complete_handler : queueComplete	// Queue plugin event
			};
			swfu = new SWFUpload(settings);
	     };
	</script>
	<form name="formlanmuadmin" method="post"  target="mainFrame"></form>