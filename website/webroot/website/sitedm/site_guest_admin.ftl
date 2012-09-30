<#include "/website/include/head_js_css.ftl">
<script language="javascript">

    var  ftlpath="/website/sitedm/";
    var  common="siteoperationControl.action?OT.Forward.success.Type=freemarker";
    var parent_reload="&DM.Reload.SiteUser=&DM.Object.SiteUser=SiteUser&DM.Instance.SiteUser.id=";
    function modify(id_parent,id_child){
	   	  var  modify_Action=common+parent_reload+id_parent
                             +"&OT.Forward.success.URL="
                             +ftlpath
                             +"site_guest_addupdate.ftl"
                             +"&DM.Reload.SiteGuest="
                             +"&DM.Instance.SiteGuest.id="+id_child
                             +"&DM.Object.SiteGuest=SiteGuest"
                             ;
	       document.getElementById('formlanmuadmin').action=modify_Action;
		   document.getElementById('formlanmuadmin').submit();
		}
    function add(id_parent){
       var  add_Action=common+parent_reload+id_parent
                             +"&OT.Forward.success.URL="
                             +ftlpath
                             +"site_guest_addupdate.ftl" 
                                                     
                             ;	   
     	document.getElementById('formlanmuadmin').action =add_Action;
		document.getElementById('formlanmuadmin').submit();
	 }
	
	function uploadmodify(id_parent,id_child){
	   	  var  modify_Action=common+parent_reload+id_parent
	                                         +"&OT.Forward.success.URL="
	                                         +ftlpath
	                                         +"site_guest_uploadfile.ftl"
	                                         +"&DM.Reload.SiteGuest="
	                                         +"&DM.Instance.SiteGuest.id="+id_child
	                                         +"&DM.Object.SiteGuest=SiteGuest"
	                                         ;
	       document.getElementById('formlanmuadmin').action=modify_Action;
		   document.getElementById('formlanmuadmin').submit();
	}  
	function set_null(id_parent,field){
   	  	  var  upload_siteuserpic_Action=common+parent_reload+id_parent
                                         +"&OT.Forward.success.URL="
                                         +ftlpath
                                         +"site_guest_admin.ftl"
                                         +"&DM.Instance.SiteUser."+field+"=@{System:null}"
                                         +"&DM.Update.SiteUser="
                                         +"&DM.Reload.SiteUser.__Depends=DM.Update.SiteUser"
                                         ;
          document.getElementById('formlanmuadmin').action=upload_siteuserpic_Action;
	      document.getElementById('formlanmuadmin').submit();
	} 	
		
    var  common_updata_para=common+parent_reload+ '${Session["clientlogined"].id?if_exists}'
                                         +"&OT.Forward.success.URL="
                                         +ftlpath
                                         +"site_guest_admin.ftl"
                                         +"&DM.Reload.SiteGuest="
                                         +"&DM.Object.SiteGuest=SiteGuest"
                                         +"&DM.Update.SiteGuest=";
	function update_rank(id,rank){
	 	  var  update_rank_Action=common_updata_para 
	   						  +"&DM.Instance.SiteGuest.id="+id
		                      +"&DM.Instance.SiteGuest.sortstr="+rank;
	      document.getElementById('formlanmuadmin').action=update_rank_Action;
		  document.getElementById('formlanmuadmin').submit();	    	          
		   	  
	}							 	 

	function update_publicize(id,publicize){
	  	  var  update_publicize_Action=common_updata_para
	  	   							 +"&DM.Instance.SiteGuest.id="+id
		                             +"&DM.Instance.SiteGuest.publicize="+publicize;
	      document.getElementById('formlanmuadmin').action=update_publicize_Action;
		   document.getElementById('formlanmuadmin').submit();	    	          
	}	
	function change_rank(id_from,id_to ){
	 	  var  action=common+parent_reload+'${results["DM.Reload.SiteUser.Result"].id}'
                      +"&OT.Forward.success.URL="
                      +ftlpath
                      +"site_guest_admin.ftl"
                      +"&DM.Reload.SiteUser.__Depends=DM.business.ChangeRank"  
                      +"&DM.business.ChangeRank="
                      +"&id_from="+id_from
                      +"&id_to="+id_to
                      +"&beanname=SiteGuest"
                      ;
               document.getElementById('formlanmuadmin').action=action;
			   document.getElementById('formlanmuadmin').submit();	    	          
	}	


	function delete_x(id_parent,id_child){
	       var  delete_Action=common+parent_reload
	                             +id_parent
	                            +"&OT.Forward.success.URL="
	                            +ftlpath
	                            +"site_guest_admin.ftl"    
	                            +"&DM.business.DeleteFileOnServer="
	                            +"&fileid="+id_child
	                            +"&fileponame=SiteGuest"
	                            +"&DM.Reload.SiteUser.__Depends=DM.business.DeleteFileOnServer"  
	                              ;	   
         	document.getElementById('formlanmuadmin').action =delete_Action;
			document.getElementById('formlanmuadmin').submit();
	}
	function add_new(){
	       var action=common+parent_reload+"${results["DM.Reload.SiteUser.Result"].id}"
	                            +"&OT.Forward.success.URL="
	                            +ftlpath
	                            +"site_guest_admin.ftl"  
	                            +"&DM.Create.SiteGuest="
                                 +"&DM.Instance.SiteGuest.SiteUser=@{SiteUser}"
                                 +"&DM.Instance.SiteGuest.publicize=YES"
                                 +"&DM.Reload.SiteUser.__Depends=DM.Create.SiteGuest"
                                 +"&DM.Object.SiteGuest=SiteGuest"		                              
	                            ;	
	        document.getElementById('formlanmuadmin').action =action;
			document.getElementById('formlanmuadmin').submit();                    	
	}
	
	function update_user_value(name,value ){
	 	   var  action=common+parent_reload+'${results["DM.Reload.SiteUser.Result"].id}'
	                  +"&OT.Forward.success.URL="
	                  +ftlpath
	                  +"site_guest_admin.ftl"
                      +"&DM.Reload.SiteUser.__Depends=DM.Update.SiteUser"  
                      +"&DM.Update.SiteUser="
                      +"&DM.Instance.SiteUser."+name+"="+value
                      +"&showsetting=display";
                      ;
               document.getElementById('formlanmuadmin').action=action;
			   document.getElementById('formlanmuadmin').submit();	    	          
	}			
</script>
<body >
<form name="formlanmuadmin" id=formlanmuadmin method="post"  target="mainFrame"></form>
<@tt width="690"/>
<div class=title>${results["DM.Reload.SiteUser.Result"].guestLanmu} 【网站留言栏目】</div>
<div class=content>
 	<form name="formlanmuadmin" action="siteoperationControl.action" method="post" ></form>
      	<p align=center>
      		<a  class=bt   href="javascript:add_new();">添加</a>
	    </p>
	<br>
	<table id=area-data class="area-data"  cellSpacing="1" width=700>
		<tr class=title height=22>
			<td width=150>客户信息</td>
			<td>客户留言</td>
			<td width=150>回复</td>
			<td width=100></td>
		</tr>	
		<#assign listx = []>					
		<#list results["DM.Reload.SiteUser.Result"].siteGuests  as P0><#assign listx = listx + [P0]></#list>	
 		<#list listx as x >
     	<tr class=td-data> 
 			<td>姓名：${x.name?if_exists}<br>${x.wordtime?if_exists}</td>
			<td>${x.leaveword?if_exists?html}</td>
			<td>${x.reply?if_exists}</td>
			<td width=100>
			    <br>
			    <a class=bt href="javascript:modify(${results["DM.Reload.SiteUser.Result"].id},${x.id});">
                                            编辑
                </a> 
			     <br><br>
			     <#include "/website/include/rank.ftl">
			     <span title='删除该文件目录' onclick= "javascript:delete_x(${results["DM.Reload.SiteUser.Result"].id},${x.id});" class="snp-icon ui-icon-trash"></span> 
			    <br><br>
		    </td>         	 					  
		 </tr>
		</#list>
	</table>
</div>	
<@bb/>		
<@preview_iframe "guest.ftl" />
	   

