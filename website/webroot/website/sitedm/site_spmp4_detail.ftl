<#include "/website/include/head_js_css.ftl">
<#include "/website/macro/commonfun.ftl">
<#include "/website/macro/map_language_title.ftl">
<#include "/website/macro/admin_preview.ftl">

<#include "/website/macro/templetehtml.ftl">
<#assign SiteUser=Session["clientlogined"] />
<script type="text/javascript">
	
	hs.graphicsDir = '../../other/highslide/graphics/';
	hs.outlineType = 'rounded-white';
	hs.wrapperClassName = 'draggable-header';
	hs.minWidth=600;
	hs.height=300;	
</script>
<script language="javascript">
 	<#if tempvar["language"]?exists >
	    <#assign language=tempvar["language"]?if_exists />	
	<#else>
		<#assign language=Session["clientlogined"].language?if_exists/>	
	</#if>	
 	<#if tempvar["local"]?exists >
 	    <#assign local=tempvar["local"]?if_exists />
	<#else>
		<#assign local=Session["clientlogined"].local?if_exists/>	
	</#if>
	<#assign lanmutitle=tempvar["lanmutitle"]?if_exists />
	<#assign LanmuObject=Session["lanmuobject"]/>	  
    var ftlpath="/website/sitedm/";
    var common="siteoperationControl.action?OT.Forward.success.Type=freemarker"
			     +"&DM.Reload.SiteUser=&DM.Object.SiteUser=SiteUser&DM.Instance.SiteUser.id=${Session["clientlogined"].id?if_exists}"
			    ;
    var parent_reload="&DM.Reload.SiteSpmp4=&DM.Object.SiteSpmp4=SiteSpmp4&DM.Instance.SiteSpmp4.id=";
    var reload_spmp4=common+parent_reload+${results["DM.Reload.SiteSpmp4.Result"].id}+"&OT.Forward.success.URL=/website/sitedm/";

   	var reload="siteoperationControl.action?DM.Reload.SiteSpmp4=&DM.Object.SiteSpmp4=SiteSpmp4&OT.Forward.success.Type=freemarker";  
    var detailAction=reload+"&OT.Forward.success.URL=/website/sitedm/site_spmp4_detail.ftl"; 	
   	var updatespmp4itemAction=detailAction+"&DM.Update.SiteSpmp4Item=&DM.Object.SiteSpmp4Item=SiteSpmp4Item&DM.Reload.SiteSpmp4.__Depends=DM.Update.SiteSpmp4Item";
	var productdetailAction="siteoperationControl.action?DM.Reload.SiteSpmp4Item=&DM.Object.SiteSpmp4Item=SiteSpmp4Item&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/site_spmp4item_product_admin.ftl"; 	
	    
  	function modifychild_SiteSpmp4Item(id_parent,id_child,editflag){
	   	var modifychild_SiteSpmp4Item_Action=reload_spmp4
             +"site_spmp4item_addupdate.ftl"
             +"&DM.Reload.SiteSpmp4Item="
             +"&DM.Instance.SiteSpmp4Item.id="+id_child
             +"&DM.Object.SiteSpmp4Item=SiteSpmp4Item"
             +"&editflag="+editflag
             ;
	    document.getElementById('formlanmuadmin').action=modifychild_SiteSpmp4Item_Action;
		document.getElementById('formlanmuadmin').submit();
	}
  	    function modifychild_SiteSpmp4Item_title(id_parent,id_child,editflag){
	   	    var  modifychild_SiteSpmp4Item_Action=reload_spmp4
	                                         +"site_spmp4item_addupdate_title.ftl"
	                                         +"&DM.Reload.SiteSpmp4Item="
	                                         +"&DM.Instance.SiteSpmp4Item.id="+id_child
	                                         +"&DM.Object.SiteSpmp4Item=SiteSpmp4Item"
	                                         +"&editflag="+editflag
	                                         +"&lanmutitle=${tempvar["lanmutitle"]?if_exists}"
                                         ;
        document.getElementById('formlanmuadmin').action=modifychild_SiteSpmp4Item_Action;
	    document.getElementById('formlanmuadmin').submit();
	}		
    function addchild_SiteSpmp4Item(id_parent){
       var  addchild_SiteSpmp4Item_Action=reload_spmp4
                                         +"site_spmp4item_addupdate.ftl" 
                                                                 
                                         ;	   
     	document.getElementById('formlanmuadmin').action =addchild_SiteSpmp4Item_Action;
		document.getElementById('formlanmuadmin').submit();
	}
	function deletechild_SiteSpmp4Item(id_parent,id_child){
		if (confirm('确定要删除吗？')){ 
	       var  deletechild_SiteSpmp4Item_Action=reload_spmp4
	                                         +"site_spmp4_detail.ftl"    
	                                         +"&DM.business.DeleteSpmp4Item="
	                                         +"&jdpath="
	                                         +"&fileid="+id_child
	                                         +"&fileponame=SiteSpmp4Item"
	                                         +"&DM.Reload.SiteSpmp4.__Depends=DM.business.DeleteSpmp4Item"  
	                                        ;	   
         	document.getElementById('formlanmuadmin').action =deletechild_SiteSpmp4Item_Action;
			document.getElementById('formlanmuadmin').submit();
		 }else{} 	
	}		
	 
    function uploadmodifychild_SiteSpmp4Item(id_parent,id_child){
   	    var  modifychild_SiteSpmp4Item_Action=reload_spmp4
                                         +"site_spmp4item_uploadfile.ftl"
                                         +"&DM.Reload.SiteSpmp4Item="
                                         +"&DM.Instance.SiteSpmp4Item.id="+id_child
                                         +"&DM.Object.SiteSpmp4Item=SiteSpmp4Item"
                                         ;
        document.getElementById('formlanmuadmin').action=modifychild_SiteSpmp4Item_Action;
	    document.getElementById('formlanmuadmin').submit();
    }  
	
	function spmpdetail(id,pagename,language,local){
	    document.getElementById('formlanmuadmin').action="siteoperationControl.action?local="+local+"&language="+language+"&DM.Instance.SiteSpmp4.id="+id+"&DM.Object.SiteSpmp4=SiteSpmp4&DM.Reload.SiteSpmp4=&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/"+"site_spmp4_detail.ftl"+"&OT.Forward.error.URL=/website/error/operr_admin_tree.ftl&OT.Forward.error.Type=freemarker";  
	  	document.getElementById('formlanmuadmin').submit();
	}
	function update_rank(id,rank){
		var  update_rank_Action=reload_spmp4
             +"site_spmp4_detail.ftl"
             +"&DM.Instance.SiteSpmp4Item.id="+id
             +"&DM.Object.SiteSpmp4Item=SiteSpmp4Item"
             +"&DM.Update.SiteSpmp4Item="
             +"&DM.Instance.SiteSpmp4Item.sortstr="+rank;
	        document.getElementById('formlanmuadmin').action=update_rank_Action;
		    document.getElementById('formlanmuadmin').submit();	    	          	   	  
    }		
  	function update_member(id,value){
  		var  update_member_Action=reload_spmp4
             +"site_spmp4_detail.ftl"
             +"&DM.Instance.SiteSpmp4Item.id="+id
             +"&DM.Object.SiteSpmp4Item=SiteSpmp4Item"
             +"&DM.Update.SiteSpmp4Item="
             +"&DM.Instance.SiteSpmp4Item.member="+value
             ;
	       document.getElementById('formlanmuadmin').action=update_member_Action;
		   document.getElementById('formlanmuadmin').submit();	    	          	   	  
    }					  	
	    
	     
	function uploadspmp4item_video(id_parent,id_child){
   	    var  uploadspmp4item_action=reload_spmp4
                                         +"site_spmp4item_uploadvideofile.ftl"
                                         +"&DM.Reload.SiteSpmp4Item="
                                         +"&DM.Instance.SiteSpmp4Item.id="+id_child
                                         +"&DM.Object.SiteSpmp4Item=SiteSpmp4Item"
                                         ;
        document.getElementById('formlanmuadmin').action=uploadspmp4item_action;
	    document.getElementById('formlanmuadmin').submit();
	}	  
        
    function lookup(ids){
		document.getElementById('formlanmuadmin').action  =productdetailAction  +"&DM.Instance.SiteSpmp4Item.id=" + ids +"&spmp4id="+${results["DM.Reload.SiteSpmp4.Result"].id};
			document.getElementById('formlanmuadmin').submit();
			return true;
		}	
		function change_rank(id_from,id_to ){
		 	  var  action=reload_spmp4
	                     +"site_spmp4_detail.ftl"
	                      +"&DM.Reload.SiteUser.__Depends=DM.business.ChangeRank"  
	                      +"&DM.business.ChangeRank="
	                      +"&id_from="+id_from
	                      +"&id_to="+id_to
	                      +"&beanname=SiteSpmp4Item"
	                      ;
	               document.getElementById('formlanmuadmin').action=action;
				   document.getElementById('formlanmuadmin').submit();	    	          
		}
  		function preview(id){
	        var url="/site!siteSpmp4ItemDetail.actionid="+id;
        $('#iframe_preview').attr('src',url);
    }		
</script>
<form name="formlanmuadmin"  id="formlanmuadmin" method="post"  target="mainFrame"></form>

<div class="area-edit">
	<table width=600>
		<tr>
			<td>
			    <div  class="title"><span class=bold>${lanmutitle}> ${results["DM.Reload.SiteSpmp4.Result"].name?if_exists}</span></div>
				<div class="content">
					<#--
					<#include "/website/include/uploadfile_js.ftl">
					<form  name="uploadPicForm" action="siteoperationControl.action" onsubmit="document.getElementById('p-img').style.display='';" method="post"  enctype="multipart/form-data">
						 <div class=content>
							     添加新产品图片
							 <table>
							  	  <tr>
								  	  <td valign=top>
							               <input   class=input type="File" name="fileLocation" size=20 onChange="checkimgfile();myphoto.src=this.value;">
								           &nbsp;&nbsp;&nbsp;
								           <input id=bt-sure class=bt type="button"  disabled=true  onclick="javascript:uploadPicForm.submit();"     value="确定"> 
									       <input   class=bt type="button"  value="返回" onclick="javaScript:lanmupageadmin(${Session["clientlogined"].id},'site_spmp4_admin.ftl','','');">
										   <br><input    type="CheckBox" name="DM.Instance.upld.compress" value="yes" >在线压缩
								  	   	        
								  	  </td>
								  	  <td valign=top>
									      <p align=center>
											  <img name='myphoto' id="myphoto" src="/website/images/img_preview.png" width="130" height="110" alt ="图片预览" >
								          </p>	  	  
								  	  </td>
						          </tr>
						      </table>
					      </div>
							<input id=oursite_input type="hidden" size="50" value="@{upld.fileName}"   name="DM.Instance.SiteSpmp4Item.title">
							<input id=oursite_input type="hidden" size="50" value="@{upld.fileName}"   name="DM.Instance.SiteSpmp4Item.title2">
							<input id=oursite_input type="hidden" size="50" value="@{upld.fileName}"   name="DM.Instance.SiteSpmp4Item.title3">
							<input type="hidden" name="DM.Object.upld" value="uploadPicFile">
							<input type="hidden" name="DM.Upload.upld" value="">			
							<input type="hidden" name="DM.Instance.upld.uploadFileName" value="fileLocation">	
							<input type="hidden" name="DM.Instance.upld.subdir" value="/${results["DM.Reload.SiteSpmp4.Result"].siteUser.username}/">
							<input type="hidden" name="DM.Instance.upld.docroot" value="path_userhome">
							<input type="hidden" name="DM.Instance.upld.smallpic" value="yes">
							<input type="hidden" name="DM.Instance.SiteSpmp4Item.filepath" value="@{upld.filepath}">
							<input type="hidden" name="DM.Instance.SiteSpmp4Item.filename" value="@{upld.fileName}">
							<input type="hidden" name="DM.Instance.SiteSpmp4Item.width" value="@{upld.width}">
							<input type="hidden" name="DM.Instance.SiteSpmp4Item.height" value="@{upld.height}">
							<input type="hidden" name="DM.Create.SiteSpmp4Item.__Depends" value="DM.Upload.upld">
							<input type="hidden" name="DM.Object.SiteSpmp4" value="SiteSpmp4">
							<input type="hidden" name="DM.Reload.SiteSpmp4" value="">
							<input type="hidden" name="DM.Reload.SiteSpmp4.__Depends" value="DM.Create.SiteSpmp4Item">
							<input type="hidden" name="DM.Create.SiteSpmp4Item" value="">
							<input type="hidden" name="DM.Instance.SiteSpmp4Item.SiteSpmp4" value="@{SiteSpmp4}">
								 
							<input type="hidden" name="DM.Reload.SiteUser" value="">
							<input type="hidden" name="DM.Object.SiteUser" value="SiteUser">
							<input type="hidden" name="DM.Instance.SiteUser.id" value="${Session["clientlogined"].id?if_exists}">
					 
							<input type="hidden" name="DM.Object.SiteSpmp4Item" value="SiteSpmp4Item">
							<input type="hidden" name="DM.Reload.SiteSpmp4" value="SiteSpmp4">	
							  	  
							   										
							<input type="hidden" name="DM.Instance.SiteSpmp4.id" value="${results["DM.Reload.SiteSpmp4.Result"].id}">
							<input type="hidden" name="DM.Object.SiteSpmp4" value="SiteSpmp4">
							<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
							<input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/site_spmp4_detail.ftl">
						 </form>
						 -->
						 <a class="iframestyle" id="iframe"  href=""></a>
						
						 <br>
					 	 <table id=area-data class="area-data"  cellSpacing="1"  style="width:600px" >
					 	 <#assign listx = []>
						 <#list results["DM.Reload.SiteSpmp4.Result"].siteSpmp4Items as P0><#assign listx = listx + [P0]></#list>			 
						 <#list listx as x>
				         	 <tr>
								 <td class=td-data>
								   	 <table>
								   	     <tr>
								   	   	     <td>
												
	    		   	   	     	        	   	<a href="../../site/${SiteUser.username}/${x.filepath}" class="highslide" onclick="return hs.expand(this)">
												<img   src="../../site/${SiteUser.username}/<#if x.filepath?exists>${x.filepath?replace(".", "_sm.")}</#if>" alt="Highslide JS"
												title="预览" />
												</a>
												<p>预览</p>
					    		   	   	     
												<div class="highslide-caption">
													${x.title}
													<p>
													<@strbylanguage v1=x.getSiteSpmp4().getCommon() v2=x.getSiteSpmp4().getCommon2()?if_exists v3=x.getSiteSpmp4().getCommon3()?if_exists />
													</p>						
													<p>
													${x.getSiteSpmp4().getSiteUser().getSpmp4common()?if_exists}
													</p>
													<#if x.siteProducts?exists>
													<@SiteSingleData classes=x.siteProducts/>
													</#if>
												</div>					    		   	   	     
					    		   	   	     </td>
								   	   	     <td valign=top>
								   	 			 <form name="form_${x.id}" action="siteoperationControl.action?OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/site_spmp4_detail.ftl&DM.Object.SiteSpmp4Item=SiteSpmp4Item&DM.Update.SiteSpmp4Item=&DM.Instance.SiteSpmp4Item.id=${x.id}&DM.Reload.SiteSpmp4=&DM.Object.SiteSpmp4=SiteSpmp4&DM.Instance.SiteSpmp4.id=${results["DM.Reload.SiteSpmp4.Result"].id}&DM.Reload.SiteUser=&DM.Object.SiteUser=SiteUser&DM.Instance.SiteUser.id=${Session["clientlogined"].id?if_exists}" method="post" >
										 	     <a class=bt href="javascript:uploadmodifychild_SiteSpmp4Item(${results["DM.Reload.SiteSpmp4.Result"].id},${x.id});"> 
							       					 替换产品缩略图 </a>  
							       				 <br> <br>
										 	  	 <span class=info>标题</span>
										 	  	 <br>
										 	     <span class=info>${language_name[Session["clientlogined"].local]}</span>:
										 	     <input class=input  onchange="javascript:form_${x.id}.submit();"   type="text" size="25" value="${x.title?if_exists}"   name="DM.Instance.SiteSpmp4Item.title">
												 <br>
												 <#if Session["clientlogined"].language2="" >
											     <#else>
												 <span class=info>${language_name[Session["clientlogined"].local2]}</span>
												 <input class=input  onchange="javascript:form_${x.id}.submit();"  type="text" size="25" value="${x.title2?if_exists}"  name="DM.Instance.SiteSpmp4Item.title2">
												 </#if>			   
									     	     <br>
									     	     <#if Session["clientlogined"].language3="">
											     <#else>
												 <span class=info>${language_name[Session["clientlogined"].local3]}</span>
												 <input class=input  onchange="javascript:form_${x.id}.submit();"   type="text" size="25" value="${x.title3?if_exists}"  name="DM.Instance.SiteSpmp4Item.title3">
												 </#if>
											 	 </form>						   	 
								   	   	     </td>
								   	    </tr>
								     </table>
					    		</td>
								<td class=td-op style="width:150px">
								    <a  title="该图片的详细内容" class=bt href="javascript:lookup('${x.id}');">
								 		编辑
								    </a>
								    <a  class=bt href="javascript:deletechild_SiteSpmp4Item(${results["DM.Reload.SiteSpmp4.Result"].id},${x.id});"> 删除</a>
							 	
						 					
								    <br>  <br>
							 	    <#include "/website/include/rank.ftl"> 			    
							    </td> 				
							</tr>
					     </#list>
					  </table>	
			     </div>
			</td>
		</tr>
	</table>
</div>

