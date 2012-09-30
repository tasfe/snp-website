<#include "/website/include/head_js_css.ftl">
<#include "/website/include/uploadfile_js.ftl">	
<@tt width="500"/>
<form  name="uploadFlvForm" action="siteoperationControl.action" method="post"  enctype="multipart/form-data">
	<div  class="title">插入视频</div>
    <div class="content">	
    <br>
			<#--支持的视频文件格式：：(${Session["clientlogined"].get_video_support_format()?if_exists})-->
			请选择flv格式文件:
			<p><input  class=input  type="File" name="fileLocation"  size=25 onChange="javascript:checkvdofile();">
			（普通视频文件请用视频格式转换工具处理）
			  </p>
			宽<input size=6 class=input-number name="DM.Instance.upld.width" value="${Session["clientlogined"].get_video_init_width()?if_exists}">
			高<input size=6 class=input-number  name="DM.Instance.upld.height" value="${Session["clientlogined"].get_video_init_height()?if_exists}">
			
			<br>
			<p align=center>
			<input id=bt-sure class=bt type="button"  disabled=true  onclick="javascript:uploadFlvForm.submit();"     value="确定"> 
			    &nbsp;&nbsp;&nbsp;
	         <input  class=bt type="button"  value="返回" onclick="javascript:history.go(-1);">
		      
		    </p>
		<br> 
	</div>
 
			
<@bb/>