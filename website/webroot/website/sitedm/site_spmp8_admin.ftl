<#include "/website/include/head_js_css.ftl">
	<script type="text/javascript">
		hs.graphicsDir = '../../other/highslide/graphics/';
		hs.outlineType = 'rounded-white';
		hs.wrapperClassName = 'draggable-header';
		hs.minWidth=600;
		hs.minHeight=700;
	</script>
		

<script language="javascript">
	
    function add(){
       var  add_Action=common_user_reload
                         +"site_spmp8_addupdate.ftl" 
                         +"&OT.Token.name=createnew&OT.Token.type=get"
                         ;	   
       document.getElementById('formlanmuadmin').action =add_Action;       	
	   document.getElementById('formlanmuadmin').submit();
	}
  	function modify(id_child){
   	   var  modify_Action=common_user_reload
                         +"site_spmp8_addupdate.ftl"
                         +"&DM.Reload.SiteSpmp8="
                         +"&DM.Instance.SiteSpmp8.id="+id_child
                         +"&DM.Object.SiteSpmp8=SiteSpmp8"
                         ;
       document.getElementById('formlanmuadmin').action=modify_Action;
	   document.getElementById('formlanmuadmin').submit();
	}
    function del(id_child){
		if (confirm('确定要删除吗？')){ 
		var  del_Action=common_user_reload
                                         +"site_spmp8_admin.ftl"    
                                         +"&DM.business.DeleteSpmp8="
                                         +"&fileid="+id_child
                                         +"&fileponame=SiteSpmp8"
                                         +"&DM.Reload.SiteUser.__Depends=DM.business.DeleteSpmp8"  
                                        ;	   
     	document.getElementById('formlanmuadmin').action =del_Action;
		document.getElementById('formlanmuadmin').submit();
		}			
	}
  	function uploadvideofile(id){
   	    document.getElementById('formlanmuadmin').action=common_user_reload
                 +"site_spmp8_uploadfile.ftl"
                 +"&DM.Reload.SiteSpmp8="
                 +"&DM.Instance.SiteSpmp8.id="+id
                 +"&DM.Object.SiteSpmp8=SiteSpmp8"
                 ;
	    document.getElementById('formlanmuadmin').submit();
	}

	function change_rank(id_from,id_to ){
 	    var action=common_user_reload
 	              +"site_spmp8_admin.ftl"
                  +"&DM.Reload.SiteUser.__Depends=DM.business.ChangeRank"  
                  +"&DM.business.ChangeRank="
                  +"&id_from="+id_from
                  +"&id_to="+id_to
                  +"&beanname=SiteSpmp8"
                  ;
        document.getElementById('formlanmuadmin').action=action;
	    document.getElementById('formlanmuadmin').submit();	    	          
	}
	function update_setting(name,value,page){
	   var  action=common_user_reload
                 +page
                 +"&DM.business.LanmuSetting="
                 +"&DM.Reload.SiteUser.__Depends=DM.business.LanmuSetting"  
                 +"&paraname="+name
                 +"&"+name+"="+value
                 +"&userid=${Session["clientlogined"].id?if_exists}"
                 +"&showsetting=display";
       document.getElementById('formlanmuadmin').action=action;
	   document.getElementById('formlanmuadmin').submit();	    		
	}							    			 
</script>
<script language="javascript">

	function preview(id){
	    var url="";
	  	$('#iframe_preview').attr('src',$('#iframe_preview').attr('src'));
	}		
</script>

<body>


<@tt width="600"/>
<form name="formlanmuadmin" id=formlanmuadmin method="post"  target="mainFrame"></form>

<div  class="title">
    <span class=bold> ${results["DM.Reload.SiteUser.Result"].spmp8Lanmu}</span>
 </div>
<div class="content" style="padding:15px"> 
	<#--
	<div align=center>
		<div style="display: inline; border: solid 1px #7FAAFF; background-color: #C5D9FF; padding: 2px;">
			<br>
			<span id="spanButtonPlaceHolder" ></span>
		</div>
		<input id="btnCancel" type="button" value="取消所有队列" onclick="swfu.cancelQueue();" disabled="disabled" style="margin-left: 2px; font-size: 8pt; height: 29px;display:none" />
 	</div>	
	<div class="flash" id="fsUploadProgress" style="float:right; border: solid 1px #7FAAFF; background-color: #F7F7F7; padding: 2px;"></div>	  
    -->
   <a class=bt  style="padding:8px" href="siteoperationControl.action?DM.Instance.SiteUser.id=${Session["clientlogined"].id}&DM.Object.SiteUser=SiteUser&DM.Reload.SiteUser=&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/upload_spmp8.ftl" title="1次上传多个文件" onclick="return hs.htmlExpand(this, { objectType: 'iframe' } )">
				上传视频文件</a>		
    <br>
     <br> 

	  <p class=para-bg style="padding:15px">
	
	
        <span  class="snp-icon ui-icon-home"></span> <span class=bold>首页</span>
	    <input  id=tpl_input  type="radio" onclick="javascript:update_setting('vphonindex',this.value,'site_spmp8_admin.ftl');" 
	    <#if LanmuObject.vphonindex=="YES">checked<#else></#if> name="vphonindex" value="YES">显示
		<input id=tpl_input  type="radio" onclick="javascript:update_setting('vphonindex',this.value,'site_spmp8_admin.ftl');"   
		<#if LanmuObject.vphonindex=="">checked<#else></#if>  name="vphonindex" value=""> 不显示        
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<span class=bold>播放</span> 
		<input id=tpl_input  type="radio" onclick="javascript:update_setting('videoautoplay',this.value,'site_spmp8_admin.ftl');"  <#if LanmuObject.videoautoplay=="">checked<#else></#if> name="videoautoplay" value="">      	
		 自动
		<input id=tpl_input  type="radio" onclick="javascript:update_setting('videoautoplay',this.value,'site_spmp8_admin.ftl');"  <#if LanmuObject.videoautoplay=="0">checked<#else></#if>  name="videoautoplay" value="0">
	                   手动
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                   
	    <span class=bold>播放屏大小：</span> 
		宽<input   class=input-number  onchange="javascript:update_setting('videowidth',this.value,'site_spmp8_admin.ftl');"   size="4"  type="text" name="width" value="<#if LanmuObject.videowidth=="">${Session["clientlogined"].get_video_init_width()?if_exists}<#else>${LanmuObject.videowidth?if_exists}</#if>">   
		高<input class=input-number   onchange="javascript:update_setting('videoheight',this.value,'site_spmp8_admin.ftl');"  size="4"  type="text" name="height" value="<#if LanmuObject.videoheight=="">${Session["clientlogined"].get_video_init_height()?if_exists}<#else>${LanmuObject.videoheight?if_exists}</#if>">  
 	</p>

 <br>
     <table id=area-data class="area-data"  cellSpacing="1" width=600>
	<#assign listx = []>
	<#list results["DM.Reload.SiteUser.Result"].siteSpmp8s as P0>
		<#assign listx = listx + [P0]>
	</#list>		
    <#list listx as x>
            <td> 
	            <td class=td-data>
	            
		       	<form name="form_${x.id}" action="siteoperationControl.action?OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/site_spmp8_admin.ftl&DM.Object.SiteSpmp8=SiteSpmp8&DM.Update.SiteSpmp8=&DM.Instance.SiteSpmp8.id=${x.id}&DM.Reload.SiteUser=&DM.Object.SiteUser=SiteUser&DM.Instance.SiteUser.id=${results["DM.Reload.SiteUser.Result"].id?if_exists}" method="post" >
			 	  	<span class=info>视频标题:</span>
			 	    <input class=input  onchange="javascript:form_${x.id}.submit();"   type="text" size="20" value="${x.name?if_exists}"   name="DM.Instance.SiteSpmp8.name">
					<#if results["DM.Reload.SiteUser.Result"].language2="" >
				    <#else>
					<span class=info>${language_name[results["DM.Reload.SiteUser.Result"].local2]}</span>
					<input class=input  onchange="javascript:form_${x.id}.submit();"  type="text" size="20" value="${x.name2?if_exists}"  name="DM.Instance.SiteSpmp8.name2">
					</#if>			   
		     	    <#if results["DM.Reload.SiteUser.Result"].language3="">
				    <#else>
					 <span class=info>${language_name[results["DM.Reload.SiteUser.Result"].local3]}</span>
					<input class=input  onchange="javascript:form_${x.id}.submit();"   type="text" size="20" value="${x.name3?if_exists}"  name="DM.Instance.SiteSpmp8.name3">
					</#if>
		        </form>				 			            
	            <#--
				<@strbylanguage v1=x.name?if_exists?if_exists v2=x.name2?if_exists?if_exists v3=x.name3?if_exists />
				-->
				</td>
				
	 			<td class=td-op width=140>
					<a class=bt  href="javascript:modify(${x.id});">
					  编辑
					</a>
					
		            <a class=bt href="javascript:uploadvideofile('${x.id}')">
		                                  替换
		            </a> 
		    	  <a class=bt href="javascript:del(${x.id});">
		          		   删除
		            </a>
		            <br>
		             <#include "/website/include/rank.ftl">
			   	</td>  
    	   </tr>
	    </#list>
		</table>
   

<@bb/>
<#if tempvar["paraname"]?exists&&tempvar["paraname"]=="vphonindex" >
	<@preview_iframe "index.ftl" />
<#else>
	<@preview_iframe "spmp8.ftl" />
</#if>

</BODY>