<#include "/website/include/swfupload/head.ftl">
			
				upload_url: "fileupload!import_word_single.action",
				post_params: {"beanname" : "${req.getParameter("beaname")?if_exists}","userid":"${Session["clientlogined"].id?if_exists}"},
				file_types : "*.doc;*.txt",
				file_types_description : "All Files",
				button_text: '上传文件',

<#include "/website/include/swfupload/para.ftl">
<div id="content">
	<div>
		<span id="spanButtonPlaceHolder" ></span>
		<input id="btnCancel" type="button" value="取消所有队列" onclick="swfu.cancelQueue();" disabled="disabled" style="margin-left: 2px; font-size: 8pt; height: 29px;display:none" />
	    <input  class=bt type="button" value="返回"  onclick="javascript:lanmupageadmin(${Session["clientlogined"].id?if_exists},'${req.getParameter("qianzhui")?if_exists}_admin.ftl','1','zh-cn');"> 
	</div>
	<div id="divStatus">文件上传个数：0 </div>
	<div class="fieldset flash" id="fsUploadProgress">    <br>
	<span class="legend">上传队列</span>
	</div>
</div>

