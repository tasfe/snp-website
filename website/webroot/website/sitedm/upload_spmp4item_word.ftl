<#include "/website/include/swfupload/head.ftl">
				
				upload_url: "fileupload!filespmp4itemword.action",
				post_params: {"id" : "${req.getParameter("id")?if_exists}","sitename":"${Session["clientlogined"].username?if_exists}"},
				file_size_limit : "10 MB",
				file_types : "*.doc",
				file_types_description : "All Files",
				button_text: '上传文件',
				
				
				
<#include "/website/include/swfupload/para.ftl">
<div id="content">
	<form id="form1" action="test.ftl" method="post" enctype="multipart/form-data">
			<div>
			
			 
			   
				<span id="spanButtonPlaceHolder" ></span>
				  <br>   自动导入WORD文件中的图片和文字
				<input id="btnCancel" type="button" value="取消所有队列" onclick="swfu.cancelQueue();" disabled="disabled" style="margin-left: 2px; font-size: 8pt; height: 29px;display:none" />
			</div>
			<br>
			<div class="fieldset flash" id="fsUploadProgress">
			<span class="legend">上传队列<div id="divStatus">0 </div></span>
			</div>
		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>	


	</form>
</div>
</html>
