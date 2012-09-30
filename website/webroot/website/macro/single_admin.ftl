<#macro singleadmin beaname lanmutemplete  qianzhui title spmp >
<#include "/website/include/head_js_css.ftl">
<script language="javascript">
	var common_updata_para=common_user_reload
                           +"${qianzhui}_admin.ftl"  
                           +"&DM.Object.${beaname}=${beaname}"
                           +"&DM.Update.${beaname}=";
    var add_new_action=common_user_reload   
                       +"${qianzhui}_admin.ftl"
                       +"&DM.Create.${beaname}="
                       +"&DM.Instance.${beaname}.SiteUser=@{SiteUser}"
                       +"&DM.Reload.SiteUser.__Depends=DM.Create.${beaname}"
                       +"&DM.Object.${beaname}=${beaname}";       
	
	function modify(id_child){
   	    var  action=common_user_reload
                    +"${qianzhui}_addupdate.ftl"
                 	+"&OT.Token.name=createnew&OT.Token.type=get"
                    +"&DM.Reload.${beaname}="
                    +"&DM.Instance.${beaname}.id="+id_child
                    +"&DM.Object.${beaname}=${beaname}"
                     ;
        document.getElementById('formlanmuadmin').action=action;
	    document.getElementById('formlanmuadmin').submit();
	}
	
    function del(id){
        if(confirm("确定要是删除吗")){ }
            var  action=common_user_reload
	                  +"${qianzhui}_admin.ftl"  
	                  +"&DM.business.DeleteFileOnServer="
	                  +"&fileid="+id
	                  +"&fileponame=${beaname}"
	                  +"&DM.Reload.SiteUser._Depends=DM.business.DeleteFileOnServer" ;	  
         	document.getElementById('formlanmuadmin').action =action;
			document.getElementById('formlanmuadmin').submit();
		
	}	                       

	
	function insert(id,page){
		var  action=common_user_reload
                     +page
                     +"&DM.Reload.${beaname}="
                     +"&DM.Instance.${beaname}.id="+id
                     +"&DM.Object.${beaname}=${beaname}"
                     ;
        document.getElementById('formlanmuadmin').action=action;
	    document.getElementById('formlanmuadmin').submit();
	}   		   
	   		    
	function change_rank(id_from,id_to ){
	 	var  action=common_user_reload
                     +"${qianzhui}_admin.ftl"  
                      +"&DM.Reload.SiteUser.__Depends=DM.business.ChangeRank"  
                      +"&DM.business.ChangeRank="
                      +"&id_from="+id_from
                      +"&id_to="+id_to
                      +"&beanname=${beaname}"
                      ;
       document.getElementById('formlanmuadmin').action=action;
	   document.getElementById('formlanmuadmin').submit();	    	          
	}

		
	function	move_content(id_bean,from_beanname,to_beanname){
       var  action=common_user_reload
                     +"${qianzhui}_admin.ftl"  
                     +"&DM.business.MoveContent="
                     +"&DM.Reload.SiteUser.__Depends=DM.business.MoveContent"  
                     +"&id_bean="+id_bean
                     +"&to_beanname="+to_beanname
                     +"&from_beanname="+from_beanname
       document.getElementById('formlanmuadmin').action=action;
	   document.getElementById('formlanmuadmin').submit();	    		
	}
	function set_value(id,fieldname,value){
    var action=common_updata_para 
               +"&DM.Instance.${beaname}.id="+id
               +"&DM.Instance.${beaname}."+fieldname+"="+value;
    document.getElementById('formlanmuadmin').action=action;
	document.getElementById('formlanmuadmin').submit();	    	          		   	  
	}
	$(document).ready(function(){
		document.getElementById('add_form').action=add_new_action;
	document.getElementById('realse_new').focus(); 
	});
</script>	
<body>
<form name="formlanmuadmin" id=formlanmuadmin method="post"  target="mainFrame"></form>
	<#assign listx = []>
	<#list spmp as P0><#assign listx = listx + [P0]></#list>				
<@tt  width="700"/> 
	<div class="title" ><span class=info-big>${title}</span></div>
 	<div class="content" >
 		<form id="add_form" action='' method="post">  	
 		   
		   	<TEXTAREA  rows=3 cols=60 id=realse_new class="input-blur" name="DM.Instance.${beaname}.detail"  onfocus="this.className='input-focus'"></textarea>		
		   		  &nbsp;&nbsp;<a class=bt   href="#" onclick="javascript:$('#add_form').submit();" ><span class="ui-state-default ui-corner-all" >插入内容</span></a>	
		
		 <#--
			 	<div class="out" style="width:90px" >
					<div class="in ltin tpin" style="cursor:hand;width:86px" onMouseOver="style.background='#f00'; " onclick="javascript:$('#add_form').submit();" onMouseOut="style.background='#0063dc';">
						<span  class=bt-update style="padding:5 0 5 0"  >插&nbsp;入&nbsp;内&nbsp;容</span>		
					</div>
				</div>	 
					 --> 	 
		</form>
	    <br>
		 <p align=right valgin=bottom>	   
		 	<#if beaname=="SiteLink" >	
            <#else>
	 			<#if beaname=="SiteAbout" >	
					<a class=bt title="滚动信息" href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_marquee.ftl','1','${Session["clientlogined"].local}');"><span class="ui-state-default ui-corner-all" >滚动信息</span></a>&nbsp;
		        </#if>  
	            <a class=bt href="javaScript:lanmupageadmin(${Session["clientlogined"].id},'globe_ht_${qianzhui}.ftl','1','${Session["clientlogined"].local}');"><span class="ui-state-default ui-corner-all" >横条</span></a>&nbsp;
            				
		 	</#if> 
 	     </p> 
	    
		 <br>
		<table id=area-data class="area-data"  cellSpacing="1" >
	    <#list listx as x>
		    <tr>
		       	<td class=td-data width=500> 
	                ${x.detail?if_exists}			        
			 	</td>
			 	<td class=td-op width=150px>
			 	  <a  class=bt  href="javascript:modify('${x.id}');">文字编辑</a>
			 	  <a  class=bt  href="javascript:del(${x.id});">删除</a>
			 	  
			 	  <br>  <br>
				 <a id=insert_img href="javascript:insert(${x.id},'${qianzhui}_uploadfile.ftl');"> <span title="插入图片" class="ui-state-default ui-corner-all" ><span  class="snp-icon ui-icon-image"></span></span></a> 
				 <a id=insert_video href="javascript:insert(${x.id},'${qianzhui}_uploadvideofile.ftl');"><span title="插入视频" class="ui-state-default ui-corner-all" ><span  class="snp-icon ui-icon-video"></span></span></a> 
						<#include "/website/include/rank.ftl">
				        <a   href="#" onclick="javascript:document.getElementById('div_move_${x.id}').style.display=''">
				        <span title="滚动信息" class="ui-state-default ui-corner-all" ><span  class="snp-icon ui-icon-arrowrefresh-1-s"></span></span>
				        </a>
				        <br> 
				        <p class=para-bg>
					   
			 		    <#include "/website/include/insert.ftl">	
						</p>
				      
				        
				        <div  id="div_move_${x.id}" style="display:none; position:absolute; z-index:5; "  >
				            <div class=title>滚动信息</div>
	                        <table class="div-f-mov" >
	                            <tr>
	                                <td  align=left>
	                                 
	                                    <#if beaname=="SiteAbout" >
	                                    <#else>
	                                    	<br><input type="radio" value="SiteAbout" onclick="javascript:move_content('${x.id}','${beaname}',this.value);" name="to_beanname">${results["DM.Reload.SiteUser.Result"].indexLanmu?if_exists}
	                                    </#if>    
	                                    
	                                    <#if beaname=="SiteAddress" >
	                                    <#else>
	                                   	   <br><input type="radio" value="SiteAddress" onclick="javascript:move_content('${x.id}','${beaname}',this.value);" name="to_beanname">${results["DM.Reload.SiteUser.Result"].addressLanmu?if_exists}
	  			                    		</#if>  
	
	                                    <#if beaname=="SiteJob" >
	                                    <#else>
	                                        <br><input type="radio" value="SiteJob" onclick="javascript:move_content('${x.id}','${beaname}',this.value);"  name="to_beanname">${results["DM.Reload.SiteUser.Result"].jobLanmu?if_exists}
	  			                    		</#if> 
	
	                                    <#if beaname=="SiteS1" >
	                                    <#else>
	  			                    			<br><input type="radio" value="SiteS1" onclick="javascript:move_content('${x.id}','${beaname}',this.value);" name="to_beanname">${results["DM.Reload.SiteUser.Result"].s1Lanmu?if_exists}
	  			                    		</#if> 		  			                    		          
	
	                                    <#if beaname=="SiteS2" >
	                                    <#else>
	  			                    			<br><input type="radio" value="SiteS2" onclick="javascript:move_content('${x.id}','${beaname}',this.value);" name="to_beanname">${results["DM.Reload.SiteUser.Result"].s2Lanmu?if_exists}
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
<@bb/>

<@preview_iframe "${lanmutemplete}" />		
</#macro>		