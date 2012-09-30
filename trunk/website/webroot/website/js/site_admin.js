<!--本脚本文件主要是管理后台使用-->	

function singlanmutitleeidt(siteuserid,pagename,language,local,ftlname){
    formlanmuadmin.action="siteoperationControl.action?ftlfilename="+ftlname+"&local="+local+"&language="+language+"&DM.Instance.SiteUser.id="+siteuserid+"&DM.Object.SiteUser=SiteUser&DM.Reload.SiteUser=&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/"+pagename+"&OT.Forward.error.URL=/website/error/operr_admin_tree.ftl&OT.Forward.error.Type=freemarker";  
  	formlanmuadmin.submit();
}
//搞一个业务类


<!--栏目位置和细节的显示是一个界面，只是靠参数隐藏,flag标志 位置place ,参数para-->
function sitesettingadmin(siteuserid,pagename,language,local){
    formlanmuadmin.action="siteoperationControl.action?local="+local+"&language="+language+"&DM.Instance.SiteUser.id="+siteuserid+"&DM.Object.SiteUser=SiteUser&DM.Reload.SiteUser=&OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/"+pagename+"&OT.Forward.error.URL=/website/error/operr_admin_tree.ftl&OT.Forward.error.Type=freemarker";  
	formlanmuadmin.submit();
}


function  set_panle(){
   if(document.getElementById('panle_setting').style.display=='none')
	   document.getElementById('panle_setting').style.display='';
	else
		document.getElementById('panle_setting').style.display='none';
}
   function  set_display(id){
       if(document.getElementById(id).style.display=='none')
	    document.getElementById(id).style.display='';
	else
	   document.getElementById('panle_setting').style.display='none';
   }   
     function get_spmp(userid){
     $.ajax({
			  url: "siteadmin!getspmp.action?id="+userid,
		  cache: false,
		  success: function(html){
		    $("#div_quick_edit").replaceWith(html);
			  }
			}); 
	}
   function get_null(){
     
     document.getElementById('div_quick_edit').style.display='none';
    
	}

   function del(beanname,id){
     $.ajax({
			  url: "siteadmin!del.action?"+'beanname='+beanname+'&id='+id,
		  cache: false,
		  success: function(html){
		    $("#div_quick_edit").replaceWith(html);
		  }
		}); 
}

  function modifychild_SiteSpmpItem(userid,id_parent,id_child,spmp,lanmutitle,local){
   	    formlanmuadmin.action="siteoperationControl.action?local="+local+"&language=1&OT.Forward.success.Type=freemarker"
                               +"&DM.Reload.SiteS"+spmp+"=&DM.Object.SiteS"+spmp+"=SiteS"+spmp+"&DM.Instance.SiteS"+spmp+".id="
                               +id_parent
                               +"&OT.Forward.success.URL=/website/sitedm/site_s"+spmp+"item_addupdate.ftl"
                               +"&DM.Reload.SiteS"+spmp+"Item="
                               +"&DM.Instance.SiteS"+spmp+"Item.id="+id_child
                               +"&DM.Object.SiteS"+spmp+"Item=SiteS"+spmp+"Item"
                               +"&op=modify"
                               +"&lanmutitle="+lanmutitle
                                     ;
                              
       formlanmuadmin.submit();
	}

function modify_parent(userid,id_child,spmp,lanmutitle,local){
    formlanmuadmin.action="siteoperationControl.action?local="+local+"&language=1&OT.Forward.success.Type=freemarker"
               +"&DM.Reload.SiteUser=&DM.Object.SiteUser=SiteUser"
                +"&DM.Instance.SiteUser.id="+userid+"&OT.Forward.success.URL=/website/sitedm/"
               +"site_s"+spmp+"_addupdate.ftl"
               +"&DM.Reload.SiteS"+spmp+"="
               +"&DM.Instance.SiteS"+spmp+".id="+id_child
               +"&DM.Object.SiteS"+spmp+"=SiteS"+spmp+""
               +"&OT.Token.name=createnew"
               +"&OT.Token.type=get"
                +"&op=modify"
                +"&lanmutitle="+lanmutitle
              ;
     formlanmuadmin.submit();
}		 
	
	
function deletechild_SiteSpmpItem(id_parent,id_child,spmp,lanmutitle,local){
    formlanmuadmin.action ="siteoperationControl.action?local="+local+"&language=1&OT.Forward.success.Type=freemarker"
                       +"&DM.Reload.SiteS"+spmp+"=&DM.Object.SiteS"+spmp+"=SiteS"+spmp+"&DM.Instance.SiteS"+spmp+".id="
                       +id_parent 
                       +"&OT.Forward.success.URL=/website/sitedm/site_s"+spmp+"_detail.ftl"
                       +"&lanmutitle="+lanmutitle
                       +"&DM.business.DeleteFileOnServer="
                       +"&fileid="+id_child
                       +"&fileponame=SiteS"+spmp+"Item"
                       +"&DM.Reload.SiteS"+spmp+".__Depends=DM.business.DeleteFileOnServer"  
                                ;	   
     formlanmuadmin.submit();
}		
   
  
function ajax_user(paraname,value){
	 $.ajax({
	         type:"POST",
	     url: "siteadmin!ajax_user.action",
		 data:"paraname="+paraname+"&value="+value,
		 cache: false,
		 success: function(html){
		  }
	});   
}
function ajax_lanmusetting(paraname,value){
	$.ajax({
         type:"POST",
         url: "siteadmin!ajax_lanmusetting.action",
		 data:"paraname="+paraname+"&value="+value,
		 cache: false,
		 success: function(html){
		  document.getElementById('div_result_mail').innerHTML=html;
		  setTimeout( "document.getElementById('div_result_mail').innerHTML=''", 2000);
		  }
		});   
}
