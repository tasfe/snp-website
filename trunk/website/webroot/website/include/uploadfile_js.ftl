<script language="javascript">
	function  checkvdofile(){
		var name = document.uploadFlvForm.fileLocation.value;
		if (name.length == 0){
			alert("文件地址不能为空");
			return false;
	    }
		if(/^.+\.(${Session["clientlogined"].get_video_support_format()?if_exists})$/i.test(name)){
			document.getElementById('bt-sure').disabled=false;
			return true;
		}
		else{
		    alert("支持的视频文件格式：${Session["clientlogined"].get_video_support_format()?if_exists}");
			uploadFlvForm.reset();
			return false;
		}
	}    
	function  checkimgfile(){
		var name = document.uploadPicForm.fileLocation.value;
		if (name.length == 0){
		alert("文件地址不能为空");
		return false;
	    }
		if(/^.+\.(${Session["clientlogined"].get_img_support_format()?if_exists})$/i.test(name)){
			document.getElementById('bt-sure').disabled=false;
		}
		else{
			uploadPicForm.reset();
			alert("支持的图片文件格式：${Session["clientlogined"].get_img_support_format()?if_exists}");}
		return true;
	}	
</script>