<#macro spmpadmin nob lanmutemplete  adminftl title spmp >
<#include "/website/include/head_js_css.ftl">	
<script type="text/javascript">
	hs.graphicsDir = '/other/highslide/graphics/';
	hs.outlineType = 'rounded-white';
	hs.wrapperClassName = 'draggable-header';
	hs.minWidth=700;
	hs.minHeight=700;
</script> 	
	
<#include "/website/macro/map_language_title.ftl">
<#include "/website/macro/admin_preview.ftl">	
<#include "/website/macro/commonfun.ftl">	
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
                    // +"&DM.Reload.SiteUser.__Depends=DM.business.UpdateFirst"  
                    // +"&DM.business.UpdateFirst="	        
                     +"&DM.Object.SiteSpmp${nob}=SiteSpmp${nob}&DM.Reload.SiteSpmp${nob}="
		             +"&DM.Instance.SiteSpmp${nob}.id=" + ids 
		           
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
</script>

<script type="text/javascript" class="example">
$(document).ready(function()
{

    $('input.input').qtip({
        content: '修改后,移动鼠标光标，自动保存',
		<#include "/website/include/qtip.ftl">
    });
	
	$('#create-new-tip').qtip({
		content: '输入要发布的文章标题,点确定后，就可以编辑该文章内容',
		<#include "/website/include/qtip.ftl">
	});	

});
</script>
<a class="iframestyle" id="iframe"  href=""></a>
<form name="formlanmuadmin" id=formlanmuadmin method="post"  target="mainFrame"></form>

<div class="area-edit">
<table width=700>
	<tr>
		<td>
	<div  class="title"><span class=bold> ${title}</span>
	<#--<@quickedit/>-->
	</div>
	<div class="content">

	<form name="add_form" id="add_form" action='' method="post">      
	    <p id=create-new-tip>
		<span class=info>新建文章标题</span><input  name=DM.Instance.SiteSpmp${nob}.name id=realse_new_title type="input" size=30 class="input-blur"   onfocus="this.className='input-focus'"    value="">         
		&nbsp;&nbsp;<a  class="bt"  href="#" onclick="javascript:$('#add_form').submit();" >确定</a>
		</p>	
	</form>
	<br>
	<table id=dir-tip class="area-data"  cellSpacing="1"  style="width:680px" >
	<#assign listx = []>
	<#list spmp as P0>
		<#assign listx = listx + [P0]>
	</#list>		
    <#list listx as x>		
        <tr>
			<td class=td-data title="">
		       	<form name="form_${x.id}" action="siteoperationControl.action?OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/site_spmp${nob}_admin.ftl&DM.Object.SiteSpmp${nob}=SiteSpmp${nob}&DM.Update.SiteSpmp${nob}=&DM.Instance.SiteSpmp${nob}.id=${x.id}&DM.Reload.SiteUser=&DM.Object.SiteUser=SiteUser&DM.Instance.SiteUser.id=${results["DM.Reload.SiteUser.Result"].id?if_exists}" method="post" >
			 	  	<span class=info>文章标题:</span>
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
		        </form>				 		        
				<br>${x.detail?if_exists}
		 	</td>				   
				                
		 	<td class=td-op >
		        <#assign LanmuObject=Session["lanmuobject"]/>
               
                <a class=bt href="javascript:detail('${x.id}')">编辑</a>
			 	<a class=bt href="javascript:del(${x.id});"> 删除</a>
<br>
			    
				<br>
			    <p style="padding:5px 0px 0px 0px;"/>
			    <a href="site!siteSpmp${nob}Detail.action?id=${x.id}&language=1&local=zh-cn" onclick="return hs.htmlExpand(this, { objectType: 'iframe' })">
				<span title=预览 class="snp-icon ui-icon-search"></span>
				</a>
			    <#include "/website/include/rank.ftl">	
			     <a id=oursite_a  href="#" onclick="javascript:document.getElementById('div_move_${x.id}').style.display=''"><span title="滚动信息" class="ui-state-default ui-corner-all" ><span  class="snp-icon ui-icon-arrowrefresh-1-s"></span></span></a>   
	
			   
		        <div  id="div_move_${x.id}" style="display:none; position:absolute;  z-index:5; " >
                <div class=title>滚动信息</div>
                    <table class="div-f-mov" >
                        <tr>
                            <td  align=left>
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




    <#--
	<#assign number=listx?size/>
	<#if number!=0 >
    <br><br>
   <span class=info-big> 预览区域</span>
	<br>
	<table id=preview-tip> 
		<tr> 
			<td>                                                 
				<iframe marginwidth="0" marginheight="0"    onclick="return false;"
					src="/site/${results["DM.Reload.SiteUser.Result"].username?if_exists}/site!siteSpmp${nob}Detail.action?id=<#if tempvar["previewid"]?exists >${tempvar["previewid"]}<#else>${listx[0].id}</#if>&lanmuname=spmp${nob}" 
					frameborder="0" width="1000" scrolling="yes" height="830">
				</iframe>
			</td>
		</tr>
	</table>
    </#if>  
    --> 
</body>
</html>
   
</#macro>		