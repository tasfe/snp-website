<#macro filedetail beanname qianzhui   spmp subitems  adminftl=''>
<link href="/website/css/content.css" rel="stylesheet" type="text/css">
<script language="javascript" src="/website/js/site_admin.js"></script>

<#include "/website/macro/map_language_title.ftl">
<#include "/website/macro/admin_preview.ftl">
<#include "/website/macro/commonfun.ftl">
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
<script language="javascript">
    var  ftlpath="/website/sitedm/";
    var  common="siteoperationControl.action?DM.Instance.SiteUser.id=${Session["clientlogined"].id}&DM.Object.SiteUser=SiteUser&DM.Reload.SiteUser=&OT.Forward.success.Type=freemarker";
    var parent_reload="&DM.Reload.${beanname}=&DM.Object.${beanname}=${beanname}&DM.Instance.${beanname}.id=";
  	 var  reload_${qianzhui}=common+parent_reload+${results["DM.Reload.${beanname}.Result"].id}+"&OT.Forward.success.URL=/website/sitedm/";
 
	  function update_filename(id,filename){
	  var  update_filename=reload_${qianzhui}
		                                         +"site_${qianzhui}_detail.ftl"
		                                         +"&DM.Instance.${beanname}Item.id="+id
		                                         +"&DM.Object.${beanname}Item=${beanname}Item"
		                                         +"&DM.Update.${beanname}Item="
		                                         +"&DM.Instance.${beanname}Item.filename="+filename
		                                         ;
		       document.getElementById('formlanmuadmin').action=update_filename;
			   document.getElementById('formlanmuadmin').submit();	       	          
		   	  
	   }	 
 
  	   function modifychild_${beanname}Item(id_parent,id_child,editflag){
	   	  var  modifychild_${beanname}Item_Action=common+parent_reload+id_parent
	                                         +"&OT.Forward.success.URL="
	                                         +ftlpath
	                                         +"site_${qianzhui}item_addupdate.ftl"
	                                         +"&DM.Reload.${beanname}Item="
	                                         +"&DM.Instance.${beanname}Item.id="+id_child
	                                         +"&DM.Object.${beanname}Item=${beanname}Item"
	                                         +"&editflag="+editflag
	                                         ;
	       document.getElementById('formlanmuadmin').action=modifychild_${beanname}Item_Action;
		   document.getElementById('formlanmuadmin').submit();
		}
       function addchild_${beanname}Item(id_parent){
	       var  addchild_${beanname}Item_Action=common+parent_reload+id_parent
	                                         +"&OT.Forward.success.URL="
	                                         +ftlpath
	                                         +"site_${qianzhui}item_addupdate.ftl" 
	                                         
	                                                                 
	                                         ;	   
         	document.getElementById('formlanmuadmin').action =addchild_${beanname}Item_Action;
			document.getElementById('formlanmuadmin').submit();
		}
		 function deletechild_${beanname}Item(id_parent,id_child){
		   if (confirm('确定要删除吗？')){
		       var  deletechild_${beanname}Item_Action=common+parent_reload+id_parent
		                                         +"&OT.Forward.success.URL="
		                                         +ftlpath
		                                         +"site_${qianzhui}_detail.ftl"    
		                                         +"&DM.business.DeleteFileOnServer="
		                                         +"&jdpath="
		                                         +"&fileid="+id_child
		                                         +"&fileponame=${beanname}Item"
		                                         +"&DM.Reload.${beanname}.__Depends=DM.business.DeleteFileOnServer"  
		                                        ;	   
	         	document.getElementById('formlanmuadmin').action =deletechild_${beanname}Item_Action;
				document.getElementById('formlanmuadmin').submit();
			}else{} 
		}		

	function uploadmodifychild_${beanname}Item(id_parent,id_child){
	   	  var  modifychild_${beanname}Item_Action=common+parent_reload+id_parent
	                                         +"&OT.Forward.success.URL="
	                                         +ftlpath
	                                         +"site_${qianzhui}item_uploadfile.ftl"
	                                         +"&DM.Reload.${beanname}Item="
	                                         +"&DM.Instance.${beanname}Item.id="+id_child
	                                         +"&DM.Object.${beanname}Item=${beanname}Item"
	                                         ;
	       document.getElementById('formlanmuadmin').action=modifychild_${beanname}Item_Action;
		   document.getElementById('formlanmuadmin').submit();
	}  
	function spmpdetail(id,pagename,language,local){
		    document.getElementById('formlanmuadmin').action="siteoperationControl.action?local="+local+"&language="+language+"&DM.Instance.${beanname}.id="+id+"&DM.Object.${beanname}=${beanname}&DM.Reload.${beanname}=&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/"+"site_${qianzhui}_detail.ftl"+"&OT.Forward.error.URL=/website/error/operr_admin_tree.ftl&OT.Forward.error.Type=freemarker";  
		  	document.getElementById('formlanmuadmin').submit();
	}		
	  function update_rank(id,rank){
	  var  update_rank_Action=common+parent_reload+ '${results["DM.Reload.${beanname}.Result"].id}'
		                                         +"&OT.Forward.success.URL="
		                                         +ftlpath
		                                         +"site_${qianzhui}_detail.ftl"
		                                         +"&DM.Instance.${beanname}Item.id="+id
		                                         +"&DM.Object.${beanname}Item=${beanname}Item"
		                                         +"&DM.Update.${beanname}Item="
		                                         +"&DM.Instance.${beanname}Item.sortstr="+rank
		                                         ;
		       document.getElementById('formlanmuadmin').action=update_rank_Action;
			   document.getElementById('formlanmuadmin').submit();	    	          	   	  
	    }		

		function change_rank(id_from,id_to ){
		 	  var  action=reload_${qianzhui}
	                     +"site_${qianzhui}_detail.ftl"
	                      +"&DM.Reload.SiteUser.__Depends=DM.business.ChangeRank"  
	                      +"&DM.business.ChangeRank="
	                      +"&id_from="+id_from
	                      +"&id_to="+id_to
	                      +"&beanname=${beanname}Item"
	                      ;
	               document.getElementById('formlanmuadmin').action=action;
				   document.getElementById('formlanmuadmin').submit();	    	          
		}				 
</script>
<form name="formlanmuadmin" method="post"  target="mainFrame"></form>

<@tt width="700"/>
    <#--
	<div  class="title"><span class=bold> 上传文件</span></div>
	<div class="content">
		<form name="form1" action="siteoperationControl.action?DM.Instance.SiteUser.id=${Session["clientlogined"].id}&DM.Object.SiteUser=SiteUser&DM.Reload.SiteUser=" method="post"  enctype="multipart/form-data">
	        <br><input  class=input type="File" name="fileLocation" size=40 >
			<input  class=bt type="submit" value="确定"> 
	        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <input  class=bt type="button"  value="返回" onclick="javaScript:lanmupageadmin(${results["DM.Reload.${beanname}.Result"].siteUser.id},'site_${qianzhui}_admin.ftl','','');"">
			<br><br>
			<input type="hidden" name="DM.Object.upld" value="uploadPicFile">
			<input type="hidden" name="DM.Upload.upld" value="">			
			<input type="hidden" name="DM.Instance.upld.uploadFileName" value="fileLocation">	
			<input type="hidden" name="DM.Instance.upld.subdir" value="/${Session["clientlogined"].username}/">
			<input type="hidden" name="DM.Instance.upld.docroot" value="path_userhome">	
			<input type="hidden" name="DM.Create.${beanname}Item" value="">
			<input type="hidden" name="DM.Instance.${beanname}Item.filepath" value="@{upld.saveFolder}">
			<input type="hidden" name="DM.Instance.${beanname}Item.filename" value="@{upld.fileName}">	
			<input type="hidden" name="DM.Instance.${beanname}Item.${beanname}" value="@{${beanname}}">
			<input type="hidden" name="DM.Create.${beanname}Item.__Depends" value="DM.Upload.upld">	
			<input type="hidden" name="DM.Reload.${beanname}.__Depends" value="DM.Create.${beanname}Item">
		    <input type="hidden" name="DM.Instance.${beanname}Item.updatedate" value="@{System:date}">
			<input type="hidden" name="DM.Object.${beanname}Item" value="${beanname}Item">
			<input type="hidden" name="DM.Reload.${beanname}" value="${beanname}">	
		      	  
		       										
			<input type="hidden" name="DM.Instance.${beanname}.id" value="${results["DM.Reload.${beanname}.Result"].id}">
			<input type="hidden" name="DM.Object.${beanname}" value="${beanname}">
			<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
			<input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/site_${qianzhui}_detail.ftl">
			</form>
  	</div>
  	 -->  
  	   <br>
  	文件管理:${spmp.detail?if_exists}
	<table id=area-data class="area-data"  cellSpacing="1"  style="width:700px" >
   	<#assign listx = []>
	<#list subitems as P0>
		<#assign listx = listx + [P0]>
	</#list>			 
    <#list listx as x>
  		<td class=td-data>
			文件名:
			<input class=input size=20 onchange="javascript:update_filename(${x.id},this.value);"   type="txt"  value="${x.filename?if_exists}">
			<br>								
		<@strbylanguage v1=x.detail?if_exists v2=x.detail2?if_exists?if_exists v3=x.detail3?if_exists />
		</td>
 	    <td class=td-op style="width:130px">
		     <a class=bt href="javascript:modifychild_${beanname}Item(${results["DM.Reload.${beanname}.Result"].id},${x.id},'true');">编辑</a>
         	 <a class=bt href="javascript:uploadmodifychild_${beanname}Item(${results["DM.Reload.${beanname}.Result"].id},${x.id});">替换 </a>
		     <#include "/website/include/rank.ftl">
		     <a class=bt href="javascript:deletechild_${beanname}Item(${results["DM.Reload.${beanname}.Result"].id},${x.id});">删除</a>
         </td> 
		</tr>
    </#list>			
	</table>

<@bb/>
<@preview_iframe "${'spmp5'}.ftl" />
</#macro>		