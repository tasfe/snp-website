<link rel="stylesheet" type="text/css" href="/website/css/content.css" >
<#include "/website/macro/templetehtml.ftl">
<#assign SiteSpmp=results["DM.Reload.SiteSpmp4.Result"]/>	
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

<script type="text/javascript">
	var swfu;
	window.onload = function() {
		var settings = {			
			flash_url : "/common/swfupload220/swfupload.swf",
			upload_url: "fileupload!filespmp4.action",
			post_params: {"id" : "${results["DM.Reload.SiteSpmp4.Result"].id?if_exists}","sitename":"${Session["clientlogined"].username?if_exists}"},		
			file_size_limit : "100 MB",
			file_types : "*.jpg;*.gif;",
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
			button_text : '<span class="button">上传图片 </span>',
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
		document.location="siteoperationControl.action?DM.Instance.SiteUser.id=${Session["clientlogined"].id}&DM.Object.SiteUser=SiteUser&DM.Reload.SiteUser=&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/upload_spmp4.ftl&DM.Reload.SiteSpmp4=&DM.Instance.SiteSpmp4.id=${results["DM.Reload.SiteSpmp4.Result"].id?if_exists}&DM.Object.SiteSpmp4=SiteSpmp4";
	
	}

</script>

<form name="formlanmuadmin" method="post"  target="mainFrame"></form>

<div id="content">
	<div>
		<div style="display: inline; border: solid 1px #7FAAFF; background-color: #C5D9FF; padding: 2px;">
			<span id="spanButtonPlaceHolder" ></span>
		</div>
		<input id="btnCancel" type="button" value="取消所有队列" onclick="swfu.cancelQueue();" disabled="disabled" style="margin-left: 2px; font-size: 8pt; height: 29px;display:none" />
  	  
	</div>	
	<div class="flash" id="fsUploadProgress" style="float:right;"></div>	  
</div>



<table  align=left  style="text-align:left;table-layout: fixed">
    <#assign i=0/>
	<#assign num=0/>
	<#assign colnum=4/>
    <tr>
        <td colspan=${colnum}>
   			
        </td>
    </tr>
    <tr>
	   <#list results["DM.Reload.SiteSpmp4.Result"].siteSpmp4Items   as x>  
	   <#assign i=i+1/>
	   <td valign=top    style="text-align:left;">
    	   <img width=80 height=70 src="../../site/${Session["clientlogined"].username?if_exists}/<#if x.filepath?exists>${x.filepath?replace(".", "_sm.")}</#if>" 
		   <p><@strbylanguage v1=x.title v2=x.title2?if_exists v3=x.title3?if_exists />	</p>				
	   </td>
             <#if i<colnum><#--每行的个数-->
			 <#else>
			     <#assign i=0/>
			     <#assign num=num+1/>
		         </tr>
			     <tr>
			  </#if>
		</#list>
	 </tr>											
</table>
	

