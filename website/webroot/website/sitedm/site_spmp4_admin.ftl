<#macro spmpadmin nob lanmutemplete  adminftl title spmp >
	<#assign beaname='SiteSpmp'+nob/>

<#include "/website/include/head_js_css.ftl">

	<script type="text/javascript">
		hs.graphicsDir = '../../other/highslide/graphics/';
		hs.outlineType = 'rounded-white';
		hs.wrapperClassName = 'draggable-header';
		hs.minWidth=600;
		hs.height=300;
	</script>
		
<#assign SiteUser=results["DM.Reload.SiteUser.Result"] />
<form name="formlanmuadmin" method="post"  target="mainFrame">	</form>
<script language="javascript">
   
 	function modify(id_parent,id_child,editflag){
   	 	document.getElementById('formlanmuadmin').action=common_user_reload
                 +"site_spmp${nob}_addupdate.ftl"
                 +"&DM.Reload.SiteSpmp${nob}="
                 +"&DM.Instance.SiteSpmp${nob}.id="+id_child
                 +"&DM.Object.SiteSpmp${nob}=SiteSpmp${nob}"
                 +"&OT.Token.name=createnew"
                 +"&OT.Token.type=get"
                 +"&op=modify"
                 +"&editflag="+editflag
                  ;
      	document.getElementById('formlanmuadmin').submit();
	} 
    function move(ids){
        var  action=common_user_reload
                   +"site_spmp4_move.ftl"
                   +"&DM.Object.SiteSpmp4=SiteSpmp4"
                   +"&DM.Reload.SiteSpmp4="
		           +"&DM.Instance.SiteSpmp4.id=" + ids ;
		document.getElementById('formlanmuadmin').action=action;
		document.getElementById('formlanmuadmin').submit();
	}	
	function delXsub(spmp4id,spmp4subid){
	    var  del_Action=common_user_reload
                         +"site_spmp4_admin.ftl"
                         +"&DM.Reload.SiteSpmp4="
                         +"&DM.Instance.SiteSpmp4.id="+spmp4id
                         +"&DM.Object.SiteSpmp4=SiteSpmp4"
                         +"&DM.Object.SiteSpmp4Sub=SiteSpmp4Sub"
                         +"&DM.Instance.SiteSpmp4Sub.id="+spmp4subid	
                         +"&DM.Delete.SiteSpmp4Sub=";
        document.getElementById('formlanmuadmin').action=del_Action;
	    document.getElementById('formlanmuadmin').submit();	    		
	}					
    function modify_spmp4(id_child){
   	    var  action=common_user_reload
                 +"site_spmp4_addupdate.ftl"
                 +"&DM.Reload.SiteSpmp4="
                 +"&OT.Token.name=createnew"
                 +"&OT.Token.type=get"
                 +"&DM.Instance.SiteSpmp4.id="+id_child
                 +"&DM.Object.SiteSpmp4=SiteSpmp4";
        document.getElementById('formlanmuadmin').action=action;
	    document.getElementById('formlanmuadmin').submit();
	 }		
	 function	addXsubSpmp4(spmp4id){
	     var  addnull_Action=common_user_reload
                             +"site_spmp4_admin.ftl"
                             +"&DM.Instance.SiteSpmp4Sub.SiteSpmp4=@{SiteSpmp4}"
                             +"&DM.Reload.SiteSpmp4="
                             +"&DM.Instance.SiteSpmp4.id="+spmp4id
                             +"&DM.Object.SiteSpmp4=SiteSpmp4"
                             +"&DM.Object.SiteSpmp4Sub=SiteSpmp4Sub"
                             +"&DM.Create.SiteSpmp4Sub="
                             +"&op=addsub";
         document.getElementById('formlanmuadmin').action=addnull_Action;
	     document.getElementById('formlanmuadmin').submit();	    		
     }		
     function addlink(spmp4id){
         var  add_product_link=common_user_reload
                             +"site_spmp4_link.ftl" 
                             +"&spmp4id="+spmp4id
                               +"&DM.Reload.SiteSpmp4="
                             +"&DM.Instance.SiteSpmp4.id="+spmp4id
                             +"&DM.Object.SiteSpmp4=SiteSpmp4"
                                         ;	   
     	 document.getElementById('formlanmuadmin').action =add_product_link;       	
		 document.getElementById('formlanmuadmin').submit();
		 return true;
	}
    
    function addlink_onindex(){
        var  add_product_link=common_user_reload
                             +"site_spmp4_link_onindex.ftl" ;	   
     	document.getElementById('formlanmuadmin').action =add_product_link;       	
		document.getElementById('formlanmuadmin').submit();
		return true;
	 }
	
	 function bat_up_img(){
	     var  bat_up_img_action=common_user_reload
                         +"site_spmp4_admin.ftl"
                         +"&DM.business.BatUploadImg="
                         +"&DM.Reload.SiteUser.__Depends=DM.business.BatUploadImg"  
                         +"&userid=${results["DM.Reload.SiteUser.Result"].id?if_exists}"
                                     ;
     document.getElementById('formlanmuadmin').action=bat_up_img_action;
     document.getElementById('formlanmuadmin').submit();	    		
	}		

     function addsublink(spmp4subid){
         var  add_product_link=common_user_reload
                             +"site_spmp4_sub_link.ftl" 
                             +"&spmp4subid="+spmp4subid
                             +"&DM.Reload.SiteSpmp4Sub="
                             +"&DM.Instance.SiteSpmp4Sub.id="+spmp4subid
                             +"&DM.Object.SiteSpmp4Sub=SiteSpmp4Sub"
                             ;	   
     	document.getElementById('formlanmuadmin').action =add_product_link;       	
		document.getElementById('formlanmuadmin').submit();
		return true;
	 }		
	 var  add_new_action=common_user_reload
             +"site_spmp${nob}_admin.ftl"
             +"&DM.Create.SiteSpmp${nob}="
             +"&DM.Instance.SiteSpmp${nob}.SiteUser=@{SiteUser}"
             +"&DM.Reload.SiteUser.__Depends=DM.Create.SiteSpmp${nob}"
             +"&DM.Object.SiteSpmp${nob}=SiteSpmp${nob}"
             +"&DM.Instance.SiteSpmp${nob}.imagealign=menu_top" ;
	 function del(id_parent){
        if (confirm('确定要删除吗？')){ 			
   				document.getElementById('formlanmuadmin').action =common_user_reload
                                     +"site_spmp${nob}_admin.ftl"    
                                     +"&DM.business.DeleteFileOnServer="
                                     +"&jdpath="
                                     +"&fileid="+id_parent
                                     +"&fileponame=SiteSpmp${nob}"
                                     +"&DM.Reload.SiteUser.__Depends=DM.business.DeleteFileOnServer"  
                                    ;	   
 				document.getElementById('formlanmuadmin').submit();
 			}else{} 
	 }
    function detail(ids){
    	var action=common_user_reload 
             +"site_spmp${nob}_detail.ftl"
       
             +"&DM.Object.SiteSpmp${nob}=SiteSpmp${nob}&DM.Reload.SiteSpmp${nob}="
             +"&DM.Instance.SiteSpmp${nob}.id=" + ids 
             +"&lanmutitle="+'${title}';             
		
		document.getElementById('formlanmuadmin').action =action ;                    
		document.getElementById('formlanmuadmin').submit();
	 }
	
    function bat_upload(ids){
    	var action=common_user_reload 
             +"upload_spmp${nob}.ftl"
             +"&DM.Object.SiteSpmp${nob}=SiteSpmp${nob}&DM.Reload.SiteSpmp${nob}="
             +"&DM.Instance.SiteSpmp${nob}.id=" + ids ;
		alert(action); 
		document.getElementById('formlanmuadmin').action =action ;                    
		document.getElementById('formlanmuadmin').submit();
	 }	 
	 
	function uploadmodify(id_child){
		   	  document.getElementById('formlanmuadmin').action=common_user_reload
                 +"site_spmp${nob}_uploadfile.ftl"
                 +"&DM.Reload.SiteSpmp${nob}="
                 +"&DM.Instance.SiteSpmp${nob}.id="+id_child
                 +"&DM.Object.SiteSpmp${nob}=SiteSpmp${nob}" ;
		       document.getElementById('formlanmuadmin').submit();
			}
	var  common_updata_para=common_user_reload
                          	 +"site_spmp${nob}_admin.ftl"
                             +"&DM.Reload.SiteSpmp${nob}="
                             +"&DM.Object.SiteSpmp${nob}=SiteSpmp${nob}"
                             +"&DM.Update.SiteSpmp${nob}=";
	
	function set_value(id,fieldname,value){
	    var  action=common_updata_para 
	               +"&DM.Instance.SiteSpmp${nob}.id="+id
	               +"&DM.Instance.SiteSpmp${nob}."+fieldname+"="+value
		          ;
	    document.getElementById('formlanmuadmin').action=action;
		document.getElementById('formlanmuadmin').submit();	    	          		   	  
	}


    function update_width(id,width){
        var  update_rank_Action=common_updata_para +"&DM.Instance.SiteSpmp${nob}.id="+id
	                                         +"&DM.Instance.SiteSpmp${nob}.width="+width;
        document.getElementById('formlanmuadmin').action=update_rank_Action;
	    document.getElementById('formlanmuadmin').submit();	    	          
    }	 
    function update_height(id,height){
  		var  update_rank_Action=common_updata_para +"&DM.Instance.SiteSpmp${nob}.id="+id
	                            +"&DM.Instance.SiteSpmp${nob}.height="+height;
        document.getElementById('formlanmuadmin').action=update_rank_Action;
	    document.getElementById('formlanmuadmin').submit();	    	          
    }
    function update_imagealign(id,imagealign){
 	    var  update_rank_Action=common_updata_para 
  						+"&DM.Instance.SiteSpmp${nob}.id="+id
	                    +"&DM.Instance.SiteSpmp${nob}.imagealign="+imagealign;
        document.getElementById('formlanmuadmin').action=update_rank_Action;
	    document.getElementById('formlanmuadmin').submit();	    	          		   	  
    }	    				
    function change_rank(id_from,id_to ){
  	   var  update_rank_Action=common_user_reload+"site_spmp${nob}_admin.ftl"
                         +"&DM.Reload.SiteUser.__Depends=DM.business.ChangeRank"  
                         +"&DM.business.ChangeRank="
                         +"&id_from="+id_from
                         +"&id_to="+id_to
                         +"&beanname=SiteSpmp${nob}" ;
	   document.getElementById('formlanmuadmin').action=update_rank_Action;
	   document.getElementById('formlanmuadmin').submit();	    	             	  
    }
	function	move_content(id_bean,from_beanname,to_beanname){
	   var  action=common_user_reload
                 +"site_spmp${nob}_admin.ftl"  
                 +"&DM.business.MoveContent="
                 +"&DM.Reload.SiteUser.__Depends=DM.business.MoveContent"  
                 +"&id_bean="+id_bean
                 +"&to_beanname="+to_beanname
                 +"&from_beanname="+from_beanname
       document.getElementById('formlanmuadmin').action=action;
	   document.getElementById('formlanmuadmin').submit();	    
	}	
	
	function update_setting(name,value,page){
		var  action=common_user_reload
                 +"site_spmp4_admin.ftl"
                 +"&DM.business.LanmuSetting="
                 +"&DM.Reload.SiteUser.__Depends=DM.business.LanmuSetting"  
                 +"&paraname="+name
                 +"&"+name+"="+value
                 +"&userid=${Session["clientlogined"].id?if_exists}"
        document.getElementById('formlanmuadmin').action=action;
    	document.getElementById('formlanmuadmin').submit();	    		
	}		
	function preview(id){
	    var url="/site!siteSpmp4Detail.action?local=${results["DM.Reload.SiteUser.Result"].local?if_exists}&language=1&id="+id;
 	  $('#iframe_preview').attr('src',url);
 	    //  document.getElementById('iframe_preview').attr('src',url);
	}			
	
$(document).ready(function()
{

    $('input.input').qtip({
        content: '修改后,移动鼠标光标，自动保存',
		<#include "/website/include/qtip.ftl">
    });
	$('#realse_new_title').qtip({
		content: '输入要图片目录的标题,点确定后，就可以上传图片到该目录',
		<#include "/website/include/qtip.ftl">
	});	
	$('#common_all_detail').qtip({
		content: '所有的图片的文字描述都会出现 录入的内容，<br>例如：商品的图片，可以录入售后信息,<br>这样不用每个图片都写一段文字描述',
		<#include "/website/include/qtip.ftl">
	});	
	$('#common_dir_detail').qtip({
		content: '该目录所有的图片的文字描述都会出现 录入的内容，<br>例如：商品的图片，可以录入商品材质的共同信息,<br>这样就不用每个图片都写一段文字描述',
		<#include "/website/include/qtip.ftl">
	});			

});

				    				  		 
</script>
<body>
	<div class="area-edit">
	<@tt width="680"/>
		<div  class="title"><span class=bold> ${title}</span></div>
		<div class="content">
		<form name="formlanmuadmin" id="formlanmuadmin" action="siteoperationControl.action" method="post"></form> 
		<form id="add_form" action='' method="post">      
			<span class=info>新建相册目录:</span><input id=realse_new_title name=DM.Instance.SiteSpmp${nob}.name id=realse_new_title type="input" size=30 class="input-blur"   onfocus="this.className='input-focus'"    value="">         
	       &nbsp;&nbsp;<a  class="bt"  href="#" onclick="javascript:$('#add_form').submit();" >确定</a>	
	   		<p align=right style="padding-bottom:5px"> 
		 	 <a id=common_all_detail class=bt href="siteoperationControl.action?DM.Instance.SiteUser.id=${Session["clientlogined"].id}&DM.Object.SiteUser=SiteUser&DM.Reload.SiteUser=&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/site_spmp4_all_common_desc.ftl&OT.Forward.error.URL=/website/error/operr_admin_tree.ftl&OT.Forward.error.Type=freemarker" onclick="return hs.htmlExpand(this, { objectType: 'iframe' } )">
				图片公共描述
			</a>
			</p>
		</form> 
		<a class="iframestyle" id="iframe"  href=""></a>
				<table id=area-data class="area-data"  cellSpacing="1"  style="width:700px" >
				<#assign listx = []>
				<#list spmp as P0>
					<#assign listx = listx + [P0]>
				</#list>		
			    <#list listx as x>		
				        <tr>
			               <td class=td-data>
							     <form name="form_${x.id}" action="siteoperationControl.action?OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/site_spmp${nob}_admin.ftl&DM.Object.SiteSpmp${nob}=SiteSpmp${nob}&DM.Update.SiteSpmp${nob}=&DM.Instance.SiteSpmp${nob}.id=${x.id}&DM.Reload.SiteUser=&DM.Object.SiteUser=SiteUser&DM.Instance.SiteUser.id=${results["DM.Reload.SiteUser.Result"].id?if_exists}" method="post" >
							 	  	<span class=info>相册目录:</span> <br>
							 	    <input class=input  onchange="javascript:form_${x.id}.submit();"   type="text" size="20" value="${x.name?if_exists}"   name="DM.Instance.SiteSpmp${nob}.name">
									
									<#if results["DM.Reload.SiteUser.Result"].language2="" >
								    <#else>
									<span class=info>${language_name[results["DM.Reload.SiteUser.Result"].local2]}</span>
									<input class=input  onchange="javascript:form_${x.id}.submit();"  type="text" size="20" value="${x.name2?if_exists}"  name="DM.Instance.SiteSpmp${nob}.name2">
									</#if>			   
						     	    <#if results["DM.Reload.SiteUser.Result"].language3="">
								    <#else>
									 <span class=info>${language_name[results["DM.Reload.SiteUser.Result"].local3]}</span>
									<input class=input  onchange="javascript:form_${x.id}.submit();"   type="text" size="20" value="${x.name3?if_exists}"  name="DM.Instance.SiteSpmp${nob}.name3">
									</#if>
									
									<#--
							 	    <br>&nbsp;<a id=oursite_a  href="javascript:addXsubSpmp4('${x.id}')"> 添加子目录</a> 
							 	    -->
								    <br>
								 </form>		
						<#--		 		 		        
					 	<#assign LanmuObject=Session["lanmuobject"]/>
			          	<#if x.getSiteSpmp4Subs()?exists > 
			 			    <#list  x.getSiteSpmp4Subs() as x>
			 			        <form name="form_${x.id}_${x_index + 1}" action="siteoperationControl.action?DM.Reload.SiteUser=&DM.Object.SiteUser=SiteUser&DM.Instance.SiteUser.id=${results["DM.Reload.SiteUser.Result"].id?if_exists}&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/site_spmp4_admin.ftl&DM.Object.SiteSpmp4Sub=SiteSpmp4Sub&DM.Update.SiteSpmp4Sub=" method="post" >
							 	    <input type="hidden"  name="DM.Instance.SiteSpmp4Sub.id" value="${x.id}">
							 	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input title=添加子目录 class=input onchange="javascript:form_${x.id}_${x_index + 1}.submit();"   type="text" size="13" value="${x.title?if_exists}"   name="DM.Instance.SiteSpmp4Sub.title">
									<#if results["DM.Reload.SiteUser.Result"].language2="" >
								    <#else>
									<span class=info>${language_name[results["DM.Reload.SiteUser.Result"].local2]}</span>
									<input title=添加子目录  class=input  onchange="javascript:form_${x.id}_${x_index + 1}.submit();"  type="text" size="13" value="${x.title2?if_exists}"  name="DM.Instance.SiteSpmp4Sub.title2">
									</#if>			   
						     	    <#if results["DM.Reload.SiteUser.Result"].language3="">
								    <#else>
									 <span class=info>${language_name[results["DM.Reload.SiteUser.Result"].local3]}</span>
									<input title=添加子目录 class=input  onchange="javascript:form_${x.id}_${x_index + 1}.submit();"   type="text" size="12" value="${x.title3?if_exists}"  name="DM.Instance.SiteSpmp4Sub.title3">
									</#if>
								
									<a id=oursite_a title='<#if x.getProductlinkstring()?exists>${x.getProductlinkstring()?split(",")?size-1?if_exists}<#else>0</#if>张' href="javascript:addsublink('${x.id}')">
			 			           		 <span class="icon icon-import "></span>
			 			            </a> 
			 			            
			 			            <a id=oursite_a title="删除" href="javascript:delXsub('${x.id}','${x.id}')"><span  class="icon icon-del2"></span></a> 
			 			         </form> 
			 			    </#list>
			 			 </#if>
			 			  -->
							</td>				   
				            <td class=td-op style="width:150px">
					        	<a class=bt href="siteoperationControl.action?DM.Instance.SiteUser.id=${Session["clientlogined"].id}&DM.Object.SiteUser=SiteUser&DM.Reload.SiteUser=&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/upload_spmp4.ftl&DM.Reload.SiteSpmp4=&DM.Instance.SiteSpmp4.id=${x.id}&DM.Object.SiteSpmp4=SiteSpmp4" title="上传图片" onclick="return hs.htmlExpand(this, { objectType: 'iframe' } )">
								上传图片</a>	
								
											            
						 	 	<a  class=bt title='删除' href="javascript:del(${x.id});"> 删除</a>
						 	    <br> <br>
						 	     <a title="编辑该相册的图片信息" class=bt href="javascript:detail('${x.id}')">
						 	    	编辑图片描述信息 </a> &nbsp; <#--(${x.getSiteSpmp4Items()?size?defult()} 	张)-->
						 	    
 								
						 	    <br><br>
						 	    <a href="/site!siteSpmp4Detail.action?local=${results["DM.Reload.SiteUser.Result"].local?if_exists}&language=1&id=${x.id}" onclick="return hs.htmlExpand(this, { objectType: 'iframe' } )">
								<span  title="预览"  class="snp-icon ui-icon-search"></span>	
								</a>							 	    
						 	    	
								<#if (listx?size>1)>
					        	<a   href="javascript:addlink('${x.id}')"><span title="关联显示其它相册目录下的图片" class="ui-state-default ui-corner-all" ><span  class="snp-icon ui-icon-arrowreturnthick-1-w"></span></span></a>
						        <a  href="javascript:move('${x.id}')">  <span title="将图片转移到其它相册目录" class="ui-state-default ui-corner-all" ><span  class="snp-icon ui-icon-arrowreturnthick-1-n"></span></span> </a> 
						        </#if> 	
						        	 <#include "/website/include/rank.ftl">
						        	<a id=common_dir_detail href="siteoperationControl.action?DM.Instance.SiteUser.id=${Session["clientlogined"].id}&DM.Object.SiteUser=SiteUser&DM.Reload.SiteUser=&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/site_spmp4_dir_desc.ftl&DM.Reload.SiteSpmp4=&DM.Instance.SiteSpmp4.id=${x.id}&DM.Object.SiteSpmp4=SiteSpmp4&OT.Token.name=createnew&OT.Token.type=get&op=modify" onclick="return hs.htmlExpand(this, { objectType: 'iframe' } )">
									<span class="ui-state-default ui-corner-all" ><span  class="snp-icon ui-icon-clipboard"></span></span></a>	
							
						      						   
				            </td>  
						</tr>
				    </#list>		    
					</table>
			 </div>		
	</td>
	</tr>
	</table>
	</div>
	
	<script language="javascript">
		document.getElementById('realse_new_title').focus(); 		
		document.getElementById('add_form').action=add_new_action;
	</script>
	
	
  
</body>	
</#macro>		

<@spmpadmin nob=4 lanmutemplete="spmp4.ftl"  adminftl="site_spmp4_admin.ftl" title=results["DM.Reload.SiteUser.Result"].spmp4Lanmu  spmp=results["DM.Reload.SiteUser.Result"].siteSpmp4s/>
