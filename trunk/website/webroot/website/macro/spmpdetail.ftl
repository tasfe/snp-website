<#macro spmpdetail nob     spmp subitems  adminftl parenttitle="">
<#include "/website/include/head_js_css.ftl">
<#include "/website/macro/map_language_title.ftl">
<#include "/website/macro/admin_preview.ftl">
<#include "/website/macro/commonfun.ftl">

	
	<#assign beaname='SiteSpmp'+nob+'Item'/>
<script language="javascript">
    var ftlpath="/website/sitedm/";
    var common="siteoperationControl.action?OT.Forward.success.Type=freemarker";
    var parent_reload="&DM.Reload.SiteSpmp${nob}=&DM.Object.SiteSpmp${nob}=SiteSpmp${nob}&DM.Instance.SiteSpmp${nob}.id=";
	var add_new_action=common+parent_reload+${spmp.id}
                             +"&OT.Forward.success.URL="
                             +ftlpath
                             +"site_spmp${nob}_detail.ftl"
                             +"&DM.Create.SiteSpmp${nob}Item="
                      	     +"&DM.Reload.SiteUser.__Depends=DM.Create.SiteSpmp${nob}Item"
                             +"&DM.Object.SiteSpmp${nob}Item=SiteSpmp${nob}Item" 
                             +"&DM.Instance.SiteSpmp${nob}Item.SiteSpmp${nob}=@{SiteSpmp${nob}}"  ; 
 
      function modifychild_SiteSpmpItem(id_parent,id_child,editflag){
	   	    document.getElementById('formlanmuadmin').action=common+parent_reload+id_parent
	                                         +"&OT.Forward.success.URL="
	                                         +ftlpath
	                                         +"site_spmp${nob}item_addupdate.ftl"
	                                         +"&DM.Reload.SiteSpmp${nob}Item="
	                                         +"&DM.Instance.SiteSpmp${nob}Item.id="+id_child
	                                         +"&DM.Object.SiteSpmp${nob}Item=SiteSpmp${nob}Item"
	                                         +"&editflag="+editflag
	                                             +"&op=modify"
	                                         
	                                         ;
	       document.getElementById('formlanmuadmin').submit();
		}       

		 function deletechild_SiteSpmpItem(id_parent,id_child){
	         document.getElementById('formlanmuadmin').action =common+parent_reload+id_parent
	                                         +"&OT.Forward.success.URL="
	                                         +ftlpath
	                                         +"site_spmp${nob}_detail.ftl"    
	                                         +"&DM.business.DeleteFileOnServer="
	                                 
	                                         +"&fileid="+id_child
	                                         +"&fileponame=SiteSpmp${nob}Item"
	                                         +"&DM.Reload.SiteSpmp${nob}.__Depends=DM.business.DeleteFileOnServer"  
	                                        
	                                        ;	   
         	document.getElementById('formlanmuadmin').submit();
		}		



	
		  var  common_updata_para=common+parent_reload+ '${results["DM.Reload.SiteSpmp${nob}.Result"].id}'
		                                         +"&OT.Forward.success.URL="
		                                         +ftlpath
		                                         +"site_spmp${nob}_detail.ftl"
		                                        
		                                         +"&DM.Object.SiteSpmp${nob}Item=SiteSpmp${nob}Item"
		                                         +"&DM.Update.SiteSpmp${nob}Item=";
		  	
	  function update_rank(id,rank){
	  var  update_rank_Action=common_updata_para +"&DM.Instance.SiteSpmp${nob}Item.id="+id
		                                         +"&DM.Instance.SiteSpmp${nob}Item.sortstr="+rank;
		                                         
		       document.getElementById('formlanmuadmin').action=update_rank_Action;
			   document.getElementById('formlanmuadmin').submit();	    	          
		   	  
	    }		

	  function update_width(id,width){
	  	  var  update_rank_Action=common_updata_para +"&DM.Instance.SiteSpmp${nob}Item.id="+id
		                                         +"&DM.Instance.SiteSpmp${nob}Item.width="+width;
	 
	       document.getElementById('formlanmuadmin').action=update_rank_Action;
		   document.getElementById('formlanmuadmin').submit();	    	          
		   	  
	    }	 
	  function update_height(id,height){
	  	  	  var  update_rank_Action=common_updata_para +"&DM.Instance.SiteSpmp${nob}Item.id="+id
		                                         +"&DM.Instance.SiteSpmp${nob}Item.height="+height;
	            document.getElementById('formlanmuadmin').action=update_rank_Action;
		   document.getElementById('formlanmuadmin').submit();
		   	  
	    }
	  function update_imagealign(id,imagealign){
	  	  	  	  var  update_rank_Action=common_updata_para +"&DM.Instance.SiteSpmp${nob}Item.id="+id
		                                         +"&DM.Instance.SiteSpmp${nob}Item.imagealign="+imagealign;

	       document.getElementById('formlanmuadmin').action=update_rank_Action;
		   document.getElementById('formlanmuadmin').submit();	    	          		   	  
	    }	    			

		function change_rank(id_from,id_to ){
		 	  var  action=common+parent_reload+'${spmp.id}'
	                                         +"&OT.Forward.success.URL="
	                                         +ftlpath
	                     +"site_spmp${nob}_detail.ftl"  
	                      +"&DM.Reload.SiteUser.__Depends=DM.business.ChangeRank"  
	                      +"&DM.business.ChangeRank="
	                      +"&id_from="+id_from
	                      +"&id_to="+id_to
	                      +"&beanname=SiteSpmp${nob}Item"
	                      ;
	               document.getElementById('formlanmuadmin').action=action;
				   document.getElementById('formlanmuadmin').submit();	    	          
		}
	function uploadmodifychild_SiteSpmpItem(id_parent,id_child){
	   	    document.getElementById('formlanmuadmin').action=common+parent_reload+id_parent
	                                         +"&OT.Forward.success.URL="
	                                         +ftlpath
	                                         +"site_spmp${nob}item_uploadfile.ftl"
	                                         +"&DM.Reload.SiteSpmp${nob}Item="
	                                         +"&DM.Instance.SiteSpmp${nob}Item.id="+id_child
	                                         +"&DM.Object.SiteSpmp${nob}Item=SiteSpmp${nob}Item"
	                                         ;
	       document.getElementById('formlanmuadmin').submit();
	}  
	
		function insert(id_parent,id_child,page){
			   	  var  action=common+parent_reload+id_parent
	                                         +"&OT.Forward.success.URL="
	                                         +ftlpath
	                         +page
                                 +"&DM.Reload.SiteSpmp${nob}Item="
                                 +"&DM.Instance.SiteSpmp${nob}Item.id="+id_child
                                 +"&DM.Object.SiteSpmp${nob}Item=SiteSpmp${nob}Item"
	                         ;
			       document.getElementById('formlanmuadmin').action=action;
				   document.getElementById('formlanmuadmin').submit();
		}   	
		
		function set_value(id,fieldname,value){
		    var  action=common_updata_para 
		               +"&DM.Instance.SiteSpmp${nob}Item.id="+id
		               +"&DM.Instance.SiteSpmp${nob}Item."+fieldname+"="+value
			          ;
		    document.getElementById('formlanmuadmin').action=action;
			document.getElementById('formlanmuadmin').submit();	    	          		   	  
		}		
		function	move_content(id_bean,from_beanname,to_beanname){
		       var  action=common+parent_reload+${spmp.id}
	                                         +"&OT.Forward.success.URL="
	                                         +ftlpath
	                                         +"site_spmp${nob}_detail.ftl"   
	                             +"&DM.business.MoveContent="
	                             +"&DM.Reload.SiteUser.__Depends=DM.business.MoveContent"  
	                             +"&id_bean="+id_bean
	                             +"&to_beanname="+to_beanname
	                                +"&from_beanname="+from_beanname
	           document.getElementById('formlanmuadmin').action=action;
			   document.getElementById('formlanmuadmin').submit();	    		
		
			}	
       function addchild_SiteSpmpItem(id_parent){
	        document.getElementById('formlanmuadmin').action =common+parent_reload+id_parent
	                                         +"&OT.Forward.success.URL="
	                                         +ftlpath
	                                         +"site_spmp${nob}item_addupdate.ftl" 
	                                             +"&op=add"
	                                         ;	   
         	document.getElementById('formlanmuadmin').submit();
		}
		
	
	
       function add_new(id_parent){
	        document.getElementById('formlanmuadmin').action =common+parent_reload+id_parent
	                                         +"&OT.Forward.success.URL="
	                                         +ftlpath
	                                         +"site_spmp${nob}_detail.ftl"
	                                     +"&DM.Create.SiteSpmp${nob}Item="
                                  	                                 
                                         +"&DM.Reload.SiteUser.__Depends=DM.Create.SiteSpmp${nob}Item"
                                         +"&DM.Object.SiteSpmp${nob}Item=SiteSpmp${nob}Item" 
                                         +"&DM.Instance.SiteSpmp${nob}Item.SiteSpmp${nob}=@{SiteSpmp${nob}}"  
                                                                              

	                                         ;	   
         	document.getElementById('formlanmuadmin').submit();
		}										 
</script>
<form name="formlanmuadmin" id="formlanmuadmin" method="post"  target="mainFrame">

</form>

		<#assign listx = []>
		<#list subitems as P0>
			<#assign listx = listx + [P0]>
		</#list>
<div class="area-edit">
    <table>
    <tr>
    <td width=800>
	<#--${Session["clientlogined"].getValueByName("spmp2Lanmu")?if_exists}-->
	<div class="title" ><span class=info-big>${parenttitle} >  ${spmp.name?if_exists}</span><@quickedit/></div>
 	<div class="content" >
 	<form id="add_form"  action='' method="post">
		<table>
		    <tr>
		   
				<td valign=bottom  >
				     
				     <br>
			    	<TEXTAREA  name="DM.Instance.SiteSpmp${nob}Item.detail" rows=3 cols=60 id=realse_new class="input-blur"   onfocus="this.className='input-focus'"></textarea>		
			    </td>
	    	    <td valign=bottom >
	    	   
	    	    	&nbsp;&nbsp;<a  class="bt"  href="#" onclick="javascript:$('#add_form').submit();" >插入内容</a>	
	        	     &nbsp;&nbsp;
	        	     
 					<a  class="bt"  href="#"   onclick="javaScript:lanmupageadmin(${spmp.siteUser.id},'site_spmp${nob}_admin.ftl','','');">返回</a>
	   	    	    <#--
	   	    	    <a href="/website/sitedm/upload_spmppage_word.ftl?beaname=SiteSpmp${nob}&property=siteSpmp${nob}&subbeanname=SiteSpmp${nob}Item&userid=${Session["clientlogined"].id?if_exists}&qianzhui=${nob}&spmpid=${spmp.id}"><img valign ="bottom" title=导入word文件内容  src=/website/images/word.gif /></a>	
	                  -->
		              <#--
		              &nbsp;&nbsp;
		                 <a  class="bt"  href="#" onblur="javaScript:document.getElementById('area-data').style.display='';" onfocus="javaScript:document.getElementById('area-data').style.display='none';"><img align="absmiddle" src="/imagesadmin/website/siteadmin/sh_open.gif" >
		                 </a>	
		                -->		    	              		
				 </td>					
			 </tr>
		 </table> 	
 	</form>
	<br>	
	      <table id=area-data class="area-data"  cellSpacing="1" style="width:770px" >
									
	
	    <#list listx as x>
	         	<tr>
		        	<td class=td-data > 
		        	<#if nob==7|| nob==9  >
		        	<#else>
					        <form name="form_${x.id}" action="siteoperationControl.action?OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/site_spmp${nob}_detail.ftl&DM.Object.SiteSpmp${nob}Item=SiteSpmp${nob}Item&DM.Update.SiteSpmp${nob}Item=&DM.Instance.SiteSpmp${nob}Item.id=${x.id}&DM.Reload.SiteSpmp${nob}=&DM.Object.SiteSpmp${nob}=SiteSpmp${nob}&DM.Instance.SiteSpmp${nob}.id=${spmp.id}" method="post" >
						 	  	<span class=info>章节标题:</span>
						 	 
						 	    <input class=input  onchange="javascript:form_${x.id}.submit();"   type="text" size="20" value="${x.title?if_exists}"   name="DM.Instance.SiteSpmp${nob}Item.title">
								
								<#if Session["clientlogined"].language2="" >
							    <#else>
								<span class=info>${language_name[Session["clientlogined"].local2]}</span>
								<input class=input  onchange="javascript:form_${x.id}.submit();"  type="text" size="20" value="${x.title2?if_exists}"  name="DM.Instance.SiteSpmp${nob}Item.title2">
								</#if>			   
					     	    
					     	    <#if Session["clientlogined"].language3="">
							    <#else>
								 <span class=info>${language_name[Session["clientlogined"].local3]}</span>
								<input class=input  onchange="javascript:form_${x.id}.submit();"   type="text" size="20" value="${x.title3?if_exists}"  name="DM.Instance.SiteSpmp${nob}Item.title3">
								</#if>
								
		 			         </form>	        	     
		        	</#if>				
						<span class=info>内容:</span><br>${x.detail?if_exists?if_exists}
					</td>     
					<td class=td-op style="width:150px">
	                     <a class=bt  href="javascript:modifychild_SiteSpmpItem(${spmp.id},${x.id},'true');"> 编辑</a>
	                     <a class=bt  href="javascript:deletechild_SiteSpmpItem(${spmp.id},${x.id});">删除</a>
						<br><br>
					<a  href="javascript:insert(${spmp.id},${x.id},'site_spmp${nob}item_uploadfile.ftl');"><span title="插入图片" class="ui-state-default ui-corner-all" ><span  class="snp-icon ui-icon-image"></span></span></a> 
				    <a  href="javascript:insert(${spmp.id},${x.id},'site_spmp${nob}item_uploadvideo.ftl');"><span title="插入视频" class="ui-state-default ui-corner-all" ><span  class="snp-icon ui-icon-video"></span></span></a> 

										
						 
						<#include "/website/include/rank.ftl">
		                <a id=oursite_a  href="#" onclick="javascript:document.getElementById('div_move_${x.id}').style.display=''"><span title="滚动信息" class="ui-state-default ui-corner-all" ><span  class="snp-icon ui-icon-arrowrefresh-1-s"></span></span></a>
					    <p class=para-bg>
			 		    <#include "/website/include/insert.ftl">	
						</p>
							        <div  id="div_move_${x.id}" style="display:none; position:absolute; background:#F1F1F1; z-index:5; " cellspacing="0" cellpadding="0" oncontextmenu="return false">
			                            <table style="border:solid #000000 1px; width:150px" >
			                                <tr>
			                                    <td  align=left>
			                                       <b>滚动信息</b>
	                                                <#if beaname=="SiteAbout" >
	                                                <#else>
	                                                	<br><input type="radio" value="SiteAbout" onclick="javascript:move_content('${x.id}','${beaname}',this.value);" name="to_beanname">${Session["clientlogined"].indexLanmu?if_exists}
	                                                </#if>    
	                                                
	                                                <#if beaname=="SiteAddress" >
	                                                <#else>
	                                               	   <br><input type="radio" value="SiteAddress" onclick="javascript:move_content('${x.id}','${beaname}',this.value);" name="to_beanname">${Session["clientlogined"].addressLanmu?if_exists}
			  			                    		</#if>  
	
	                                                <#if beaname=="SiteJob" >
	                                                <#else>
	                                                    <br><input type="radio" value="SiteJob" onclick="javascript:move_content('${x.id}','${beaname}',this.value);"  name="to_beanname">${Session["clientlogined"].jobLanmu?if_exists}
			  			                    		</#if> 
	
	                                                <#if beaname=="SiteS1" >
	                                                <#else>
			  			                    			<br><input type="radio" value="SiteS1" onclick="javascript:move_content('${x.id}','${beaname}',this.value);" name="to_beanname">${Session["clientlogined"].s1Lanmu?if_exists}
			  			                    		</#if> 		  			                    		          
	
	                                                <#if beaname=="SiteS2" >
	                                                <#else>
			  			                    			<br><input type="radio" value="SiteS2" onclick="javascript:move_content('${x.id}','${beaname}',this.value);" name="to_beanname">${Session["clientlogined"].s2Lanmu?if_exists}
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
						&nbsp;&nbsp;
									
	                </td> 		
				 </tr>
		     </#list>					
			</TBODY>
			</table>	
		  
			 
		
	</div>
		</td>
		</tr>
	</table>									
</div>
<script language="javascript">
	document.getElementById('realse_new').focus(); 		
	document.getElementById('add_form').action=add_new_action;
  
</script>	
	<hr>
    <span class=info-big> 预览区域</span>
   	<#if Session["clientlogined"].language2?default('')!=''||Session["clientlogined"].language3?default('')!="">
		<a  onclick="javaScript:document.getElementById('iframe_preview').src='/site/${Session["clientlogined"].username?if_exists}/site!siteSpmp${nob}Detail.action?id=${spmp.id}&lanmuname=spmp${nob}&language=1'" href="#"/>
			${language_name[Session["clientlogined"].local]?default('english')}
		</a>
	</#if>
	<#if Session["clientlogined"].language2?default('')!="">
		<a  onclick="javaScript:document.getElementById('iframe_preview').src='/site/${Session["clientlogined"].username?if_exists}/site!siteSpmp${nob}Detail.action?id=${spmp.id}&lanmuname=spmp${nob}&language=2'" href="#"/>
			${language_name[Session["clientlogined"].local2]?default('english')}
		</a>
	</#if>
	<#if Session["clientlogined"].language3?default('')!="">
		<a  onclick="javaScript:document.getElementById('iframe_preview').src='/site/${Session["clientlogined"].username?if_exists}/site!siteSpmp${nob}Detail.action?id=${spmp.id}&lanmuname=spmp${nob}&language=3'" href="#"/>
			${language_name[Session["clientlogined"].local3]?default('english')}
		</a>
	</#if> 
 	<br><br>
	<iframe id=iframe_preview  style="border:#ccc 1px solid;"  
		src='/site/${Session["clientlogined"].username?if_exists}/site!siteSpmp${nob}Detail.action?id=${spmp.id}&lanmuname=spmp${nob}&language=1'
	 	frameborder="0" width="1000" scrolling="yes" height="830">
	</iframe>	



</#macro>	