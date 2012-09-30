<#macro spmpadmin nob lanmutemplete  adminftl title spmp >
<#include "/website/include/head_js_css.ftl">	
	<script type="text/javascript">
		hs.graphicsDir = '/other/highslide/graphics/';
		hs.outlineType = 'rounded-white';
		hs.wrapperClassName = 'draggable-header';
		hs.minWidth=700;
		hs.minHeight=800;
	</script> 		
	
	
	<#assign beaname='SiteSpmp'+nob/>
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
			
	  
	
	    
	    
	     var  add_new_action=common_user_reload
                                     +"site_spmp${nob}_admin.ftl"
                                     +"&DM.Create.SiteSpmp${nob}="
                                     +"&DM.Instance.SiteSpmp${nob}.SiteUser=@{SiteUser}"
                                     +"&DM.Reload.SiteUser.__Depends=DM.Create.SiteSpmp${nob}"
                                     +"&DM.Object.SiteSpmp${nob}=SiteSpmp${nob}"
                                     +"&DM.Instance.SiteSpmp${nob}.imagealign=menu_top"
                                    ;
		
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
			  function update_imagealign(id,imagealign){
	  var  update_rank_Action=common_updata_para +"&DM.Instance.SiteSpmp${nob}.id="+id
		                                         +"&DM.Instance.SiteSpmp${nob}.imagealign="+imagealign;
	       document.getElementById('formlanmuadmin').action=update_rank_Action;
		   document.getElementById('formlanmuadmin').submit();	    	          		   	  
	    }	 
	    
	   			  		 
	</script>
<body>
<a class="iframestyle" id="iframe"  href=""></a>
<div class="area-edit">
<table width=760>
<tr>
<td>

	<div  class="title"><span class=bold>添加 "顶部/底部" link </span></div>
	<div class="content">
	<form name="formlanmuadmin" id=formlanmuadmin action="siteoperationControl.action" method="post">
		
	</form> 
	<form id="add_form" action='' method="post">
		<input class=input id=realse_new_title type="input" size=30 name="DM.Instance.SiteSpmp${nob}.name"   onfocus="this.className='input-focus'"    value="">         
		&nbsp;&nbsp;<a  class="bt"  href="#" onclick="javascript:$('#add_form').submit();" >确定</a>	
	</form>
	<br>
	<#--
	   <p align=right><a  class="bt" title="预览区域" href="#" onblur="javaScript:document.getElementById('area-data').style.display='';" onfocus="javaScript:document.getElementById('area-data').style.display='none';"><img align="absmiddle" src="/imagesadmin/siteadmin/sh_open.gif" ></a>	</p>
	<br>
	-->
	<table id=area-data class="area-data"  cellSpacing="1"  style="width:700px" >
	   				
		<#assign listx = []>
		<#list spmp as P0>
			<#assign listx = listx + [P0]>
		</#list>		
	    <#list listx as x>		
				        <tr>
			           
		                   <td class=td-data>
								
				       		<form name="form_${x.id}" action="siteoperationControl.action?local=webinfo-en&language=1&OT.Forward.success.Type=freemarker&DM.Reload.SiteUser=&DM.Object.SiteUser=SiteUser&DM.Instance.SiteUser.id=${Session["clientlogined"].id?if_exists}&OT.Forward.success.URL=/website/sitedm/site_spmp9_admin.ftl&DM.Update.SiteSpmp9=&DM.Instance.SiteSpmp9.SiteUser=@{SiteUser}&DM.Reload.SiteUser.__Depends=DM.Update.SiteSpmp9&DM.Object.SiteSpmp9=SiteSpmp9" method="post" >
						 	  <input id=oursite_input type="hidden"  name="DM.Instance.SiteSpmp${nob}.id" value="${x.id}">
						 	    
						 	    <input class=input onchange="javascript:form_${x.id}.submit();"   type="text" size="18" value="${x.name?if_exists}"  name="DM.Instance.SiteSpmp${nob}.name" >
								<#if results["DM.Reload.SiteUser.Result"].language2="" >
							    <#else>
								<span classs=info>${language_name[results["DM.Reload.SiteUser.Result"].local2]}</span>
								<input class=input  onchange="javascript:form_${x.id}.submit();"  type="text" size="18" value="${x.name2?if_exists}"  name="DM.Instance.SiteSpmp${nob}.name2" >
								</#if>			   
					     	    <#if results["DM.Reload.SiteUser.Result"].language3="">
							    <#else>
								 <span classs=info>${language_name[results["DM.Reload.SiteUser.Result"].local3]}</span>
								<input class=input  onchange="javascript:form_${x.id}.submit();"   type="text" size="18" value="${x.name3?if_exists}"  name="DM.Instance.SiteSpmp${nob}.name3">
								</#if>			 		   
			 		       </form>				 		        
				 		    </td>				   
				                 
						 	<td class=td-op width=150px>
						       <#assign LanmuObject=Session["lanmuobject"]/>
						    	<a  class="bt" href="javascript:detail('${x.id}')"> 编辑</a>
 								 <a class="bt" href="site!siteSpmp9Detail.action?id=${x.id}&language=1&local=zh-cn" onclick="return hs.htmlExpand(this, { objectType: 'iframe' } )">
									预览
								</a>
							<br><br>
						    <span title="设置在顶部显示">
								<input id=tpl_input  type="radio"  onclick="javascript:update_imagealign('${x.id}',this.value);"   <#if x.imagealign=="menu_top">checked<#else></#if>    value="menu_top"> 						    
							   顶部
							</span>
							<span title="设置在底部显示"  >
								<input id=tpl_input   type="radio"  onclick="javascript:update_imagealign('${x.id}',this.value);"   <#if x.imagealign=="menu_bottom">checked<#else></#if>      value="menu_bottom"> 						    
							   底部
						    </span> 
						        
						         <p style="padding:5px 0px 0px 0px;"/>
						        
							    <#include "/website/include/rank.ftl">	
							    <a id=oursite_a  href="#" onclick="javascript:document.getElementById('div_move_${x.id}').style.display=''"> <span title='滚动信息'  class="icon icon-mov"></span></a>   
							    <a id=oursite_a href="javascript:del(${x.id});"><span  class="icon icon-del"></span></a>
							    
							     
							
							                    
							    
							    
							
						      
						        
						        <div  id="div_move_${x.id}" style="display:none; position:absolute; background:#F1F1F1; z-index:5; " cellspacing="0" cellpadding="0" oncontextmenu="return false">
		                            <table style="border:solid #000000 1px; width:150px" >
		                                <tr>
		                                    <td  align=left>
		                                       <b>滚动信息</b>
		                                        <#if beaname=="SiteSpmp1" >
		                                        <#else>
		                                        	<br><input type="radio" value="SiteSpmp1" onclick="javascript:move_content('${x.id}','${beaname}',this.value);" name="to_beanname">${results["DM.Reload.SiteUser.Result"].spmp1Lanmu?if_exists}
		                                        </#if>    
		                                        
		                                        <#if beaname=="SiteSpmp2" >
		                                        <#else>
		                                       	   <br><input type="radio" value="SiteSpmp2" onclick="javascript:move_content('${x.id}','${beaname}',this.value);" name="to_beanname">${results["DM.Reload.SiteUser.Result"].spmp2Lanmu?if_exists}
		  			                    		</#if>  
		
		                                        <#if beaname=="SiteSpmp3" >
		                                        <#else>
		                                            <br><input type="radio" value="SiteSpmp3" onclick="javascript:move_content('${x.id}','${beaname}',this.value);"  name="to_beanname">${results["DM.Reload.SiteUser.Result"].spmp3Lanmu?if_exists}
		  			                    		</#if> 
		
		                                        <#if beaname=="SiteSpmp6" >
		                                        <#else>
		                                            <br><input type="radio" value="SiteSpmp6" onclick="javascript:move_content('${x.id}','${beaname}',this.value);"  name="to_beanname">${results["DM.Reload.SiteUser.Result"].spmp6Lanmu?if_exists}
		  			                    		</#if> 
		  			                        </td>
		  			                    </tr>  	
		                                <tr>            
		                                	<td  align=center>
		  			                    		<a id=oursite_a  href="#" onclick="javascript:document.getElementById('div_move_${x.id}').style.display='none'">取消</a>
		  			                        </td>
		  			                    </tr>  			                    
							         </table>
							    </div> 							           
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
<@preview_iframe lanmutemplete />

</HTML>
   
</#macro>		
<@spmpadmin nob=9 lanmutemplete="index.ftl"  adminftl="site_spmp9_admin.ftl" title=""  spmp=results["DM.Reload.SiteUser.Result"].siteSpmp9s/>

