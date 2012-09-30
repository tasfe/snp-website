 <#if x.filepath?exists||x.filepathvideo?exists>
	       
					
	    <#if x.imagealign?default("left")=='NO'>
	    	<a id=oursite_a  href="#" onclick="javascript:set_value('${x.id}','imagealign','left');"> <span title="显示" class="snp-icon ui-icon-circlesmall-plus"></span></a>
	    	
	    <#else>	
	        <a id=oursite_a href="#"  onclick="javascript:set_value('${x.id}','imagealign','NO');"><span title="隐藏" class="snp-icon ui-icon-circlesmall-minus"></span></a>
                                
            <select title=对齐 class=bd onchange="javascript:set_value('${x.id}','imagealign',this.value);"
            name="DM.Instance.x.imagealign" value="${x.imagealign?default("left")}" size="1">
	        <option value="${x.imagealign?default("left")}"><@align  x.imagealign?default("left")/></option>
		    <#include "/website/include/option_imagealign.ftl">
		    </select> 		        
                
                <#if x.filepath?exists>
                   <br> <span  class="snp-icon ui-icon-image"></span><span title='删除该图片'  onclick="javascript:set_value('${x.id}','filepath','@{System:null}');"  class="snp-icon ui-icon-trash"></span> 
				                           
                                                      宽<input  class=input-number   onchange="javascript:set_value('${x.id}','width',this.value);"  value="${x.width?default("300")}"/>	
					 高<input class=input-number type="input" style="width:25px;"  onchange="javascript:set_value('${x.id}','height',this.value);"  value="${x.height?default("220")}"/>	
				</#if>

                <#if x.filepathvideo?exists>
                    <br> <span  class="snp-icon ui-icon-video"></span><span title='删除该视频' onclick="javascript:set_value('${x.id}','filepathvideo','@{System:null}');"  class="snp-icon ui-icon-trash"></span>   
				
	          		 宽<input  class=input-number   onchange="javascript:set_value('${x.id}','widthvideo',this.value);"  value="${x.widthvideo?default(Session["clientlogined"].get_video_init_width())}"/>			
			      	高<input class=input-number type="input" style="width:25px;"  onchange="javascript:set_value('${x.id}','heightvideo',this.value);"  value="${x.heightvideo?default(Session["clientlogined"].get_video_init_height())}"/>
				</#if>
				<#--
                <#if x.filepathdown?exists>
                    <br>
	                    ${x.filenamedown?if_exists} <a id=oursite_a href="javascript:set_value('${x.id}')">
			             <img  title="删除文件" src="/imagesadmin/website/siteadmin/file-upload.ico" align="absmiddle" >
				</#if>	
				-->									                    																					
         </#if>

<#else>
</#if>	