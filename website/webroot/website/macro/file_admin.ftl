<#macro spmpadmin nob lanmutemplete  adminftl title spmp >
	<link href="/website/css/content.css" rel="stylesheet" type="text/css">
	<script language="javascript" src="/website/js/site_admin.js"></script>
	<script type="text/javascript" src="../../common/jqury142/jquery-1.4.2.min.js"></script>
	<#include "/website/macro/map_language_title.ftl">
	<#include "/website/macro/admin_preview.ftl">	
	<#include "/website/macro/commonfun.ftl">
	<#--<#include "/website/include/highslide_no_controll.ftl">		-->
	<script type="text/javascript" src="../../other/highslide/highslide-with-html.js"></script>
	<link rel="stylesheet" type="text/css" href="../../other/highslide/highslide.css"/>
	<script type="text/javascript">
		hs.graphicsDir = '../../other/highslide/graphics/';
		hs.outlineType = 'rounded-white';
		hs.wrapperClassName = 'draggable-header';
		hs.minWidth=600;
		hs.minHeight=700;
	</script>
		
	<#assign beaname='SiteSpmp'+nob/>

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
		function	bat_up_file(){
	 		   var  action=common_user_reload
	                             +"site_spmp${nob}_admin.ftl"
	                             +"&DM.business.BatUploadFile="
	                             +"&userid=${Session["clientlogined"].id?if_exists}"
	                             ;
		      
		       document.getElementById('formlanmuadmin').action=action;
			   document.getElementById('formlanmuadmin').submit();	    		
		
			}				
	    function add(id_parent){
		      document.getElementById('formlanmuadmin').action=common_user_reload
		                        +"site_spmp${nob}_addupdate.ftl" 
		                        +"&OT.Token.name=createnew&OT.Token.type=get"                 
		                        +"&op=add"
		                        ;	   
	         	document.getElementById('formlanmuadmin').submit();
		}
			
		var  add_new_action=common_user_reload
                                     +"site_spmp${nob}_admin.ftl"
                                     +"&DM.Create.SiteSpmp${nob}="
                                     +"&DM.Instance.SiteSpmp${nob}.SiteUser=@{SiteUser}"
                                     
                                     +"&DM.Reload.SiteUser.__Depends=DM.Create.SiteSpmp${nob}"
                                     +"&DM.Object.SiteSpmp${nob}=SiteSpmp${nob}"
                                    ;	
			
		function	addXsubnull(){
	 		   var  addnull_Action=common_user_reload
                                     +"site_spmp${nob}_admin.ftl"
                                     +"&DM.Create.SiteSpmp${nob}="
                                     +"&DM.Instance.SiteSpmp${nob}.SiteUser=@{SiteUser}"
                                     +"&DM.Instance.${beaname}.detail="+document.getElementById('realse_new').value
                                     +"&DM.Reload.SiteUser.__Depends=DM.Create.SiteSpmp${nob}"
                                     +"&DM.Object.SiteSpmp${nob}=SiteSpmp${nob}"
                                    ;
                                 
               document.getElementById('formlanmuadmin').action=addnull_Action;
			   document.getElementById('formlanmuadmin').submit();	    		
		
		}				
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
			             +"&lanmutitle="+'${title}'
			             ;             
			document.getElementById('formlanmuadmin').action =action ;                    
			document.getElementById('formlanmuadmin').submit();
		}
		function uploadmodify(id_child){
		   	  document.getElementById('formlanmuadmin').action=common_user_reload
	                         +"site_spmp${nob}_uploadfile.ftl"
	                         +"&DM.Reload.SiteSpmp${nob}="
	                         +"&DM.Instance.SiteSpmp${nob}.id="+id_child
	                         +"&DM.Object.SiteSpmp${nob}=SiteSpmp${nob}"
	                         ;
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
	       var  update_rank_Action=common_updata_para +"&DM.Instance.SiteSpmp${nob}.id="+id
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
		                                         +"&beanname=SiteSpmp${nob}"
		                                           ;
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
		function	update_setting(value){
	 		   var  action=common_user_reload
	                             +"site_spmp7_admin.ftl"
	                             +"&DM.business.LanmuSetting="
	                             +"&DM.Reload.SiteUser.__Depends=DM.business.LanmuSetting"  
	                             +"&paraname=memberconfirm"
	                             +"&memberconfirm="+value
	                             +"&userid=${Session["clientlogined"].id?if_exists}"
	      
	           document.getElementById('formlanmuadmin').action=action;
			   document.getElementById('formlanmuadmin').submit();	    		
		
			}	


		
		function preview(){
		
			 $('#iframe_preview').attr('src',$('#iframe_preview').attr('src'));
		}								    				  		 
	</script>
<body>

<@tt width="610"/>
<form name="formlanmuadmin" id="formlanmuadmin" method="post"  target="mainFrame">	</form>
<div  class="title"><span class=bold> ${title}</span></div>
<div class="content">
	<form id="add_form" action='' method="post">   		
	         文件类别描述<br>	
	   <TEXTAREA  rows=2 cols=50 id=realse_new class="input-blur" name="DM.Instance.SiteSpmp${nob}.detail"  onfocus="this.className='input-focus'"></textarea>		
	   &nbsp;&nbsp;<a  class="bt"  href="#" onclick="javascript:$('#add_form').submit();" >确定</a>	
	</form> 		    
	<br>
	<a class="iframestyle" id="iframe"  href=""></a>	
	<table id=area-data class="area-data"  cellSpacing="1"  style="width:600px" >
	<#assign listx = []>
	<#list spmp as P0>
		<#assign listx = listx + [P0]>
	</#list>		
    <#list listx as x>		
        <tr>
            <td class=td-data>
	        	<span class=info>文件类别描述内容:</span>
 				<br>${x.detail?if_exists}
			</td>				   
		 	<td class=td-op style="width:140px">
		       
		        <p style="padding:5px 0px 0px 0px;"/>

	        	<a href="siteoperationControl.action?DM.Instance.SiteUser.id=${Session["clientlogined"].id}&DM.Object.SiteUser=SiteUser&DM.Reload.SiteUser=&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/upload_spmp5.ftl&DM.Reload.SiteSpmp5=&DM.Instance.SiteSpmp5.id=${x.id}&DM.Object.SiteSpmp5=SiteSpmp5" title="1次上传多个文件" onclick="return hs.htmlExpand(this, { objectType: 'iframe' } )">
				<span class="bt-op">批量上传</span></a>						 	   
		
			    <#if x.siteSpmp5Items?exists&&(x.siteSpmp5Items?size!=0)>
			        <a id=oursite_a href="javascript:detail('${x.id}')"> 
			        <span title='管理文件（文件名称修改/单个文件描述修改/删除替换文件）'  class="bt-op">管理文件</span>
				    
				    </a>
				</#if>
				<br>
                <#--
			   &nbsp;
			    <a   href="/website/sitedm/upload_spmp${nob}.ftl?id=${x.id}"><img valign ="bottom" title=批量导入文件  src=/imagesadmin/bat.ico /></a>	
				&nbsp;
				-->
				<br>
		    	<a id=oursite_a href="javascript:modify(${results["DM.Reload.SiteUser.Result"].id},${x.id},'true');">
		            <span title='修改' class="icon icon-edit"></span>
			    </a>
		       
			    <#include "/website/include/rank.ftl">	
			    &nbsp;
			    <a id=oursite_a href="javascript:del(${x.id});">
			    <span  title='删除' class="icon icon-del"></span>
			    </a>
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
	document.getElementById('add_form').action=add_new_action;
	document.getElementById('realse_new').focus(); 		
    var preview_url='siteoperationControl.action?local=${Session["clientlogined"].local?if_exists}&language=1&DM.Instance.SiteUser.id=${Session["clientlogined"].id}&DM.Object.SiteUser=SiteUser&DM.Reload.SiteUser=&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/site_preview.ftl&lanmutemplete=${lanmutemplete}';
</script>	
<#--	 -->
<a id=oursite_a href="javascript:preview()">刷新</a>
<@preview_iframe "spmp${nob}.ftl" />  

</#macro>