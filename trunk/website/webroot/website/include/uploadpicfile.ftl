<link href="/website/css/content.css" rel="stylesheet" type="text/css">
<#include "/website/macro/commonfun.ftl">
<#include "/website/include/uploadfile_js.ftl">	

<div class="area-edit">
<table width=500>
<tr>
<td>

	<div  class="title"><p class=bold>上传图片</p></div>
	<div class="content">
	     
			<form  name="uploadPicForm" action="siteoperationControl.action" onsubmit="document.getElementById('p-img').style.display='';" method="post"  enctype="multipart/form-data">
	                                                                                  
			<input class=input type="File" name="fileLocation" size=20 onChange="javascript:checkimgfile();myphoto.src=this.value;">
	         &nbsp;&nbsp;
	          
	         <input id=bt-sure class=bt type="button"  disabled=true  onclick="javascript:uploadPicForm.submit();"     value="确定"> 
			&nbsp;&nbsp;
	         <input  class=bt type="button" name="a" value="返回" onclick="javascript:history.go(-1);">
		    <p align=center>
				<img name='myphoto' id="myphoto" src="/website/images/img_preview.png" width="130" height="110" alt ="图片预览" >
	        </p>
	         <br><input    type="CheckBox" name="DM.Instance.upld.compress" value="yes" >在线压缩 
	</div>
</td>
</tr>
</table>
</div>					