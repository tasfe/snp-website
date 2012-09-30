
<#include "/website/include/head_js_css.ftl">

<script language="javascript">
    var  ftlpath="/website/sitedm/";
    var  common="siteoperationControl.action?DM.Object.SiteUser=SiteUser&OT.Forward.success.Type=freemarker";
    var  commonreload= common+"&DM.Reload.SiteUser=";
    var  commonqry= "&DM.Query.SiteUser.Pagination.Size=50&DM.Query.SiteUser=&DM.Query.SiteUser.Type=Results&OT.Forward.success.URL="+ftlpath+"all_user_list.ftl";
	
	var  common_updata_para=common+commonqry+"&DM.Query.SiteUser.__Depends=DM.Update.SiteUser" +"&DM.Update.SiteUser="
 	function exportdata(id,username){
		  var path=document.getElementById("userdata_export").value;
		  confirm("导出的用户备份文件位置："+path+username+".zip");
	   	  document.getElementById('formlanmuadmin').action=common +commonqry+"&DM.business.UserdataAdmin=&exportpath="+path+"&userid="+id;
		  document.getElementById('formlanmuadmin').submit();		          
	}  
    function importdata(id){
      confirm("导入的用户备份文件："+document.getElementById("userdata_import").value ); 
   	  document.getElementById('formlanmuadmin').action=common +commonqry+"&DM.business.UserdataAdmin=&importpath="+document.getElementById("userdata_import").value+"&userid="+id;
	  document.getElementById('formlanmuadmin').submit();		          
    }     
    function update_system_map(){
	  var  update_system_map=common +commonqry+"&DM.business.UpdateUrlMap=";
	  document.getElementById('formlanmuadmin').action=update_system_map;
	  document.getElementById('formlanmuadmin').submit();	    	          
    }                             
    function update_begindate(id,begindate){
	  var  update_begindate=common_updata_para +"&DM.Instance.SiteUser.id="+id+"&DM.Instance.SiteUser.begindate="+begindate
	  document.getElementById('formlanmuadmin').action=update_begindate;
	  document.getElementById('formlanmuadmin').submit();	    	          
    }
    function update_enddate(id,enddate){
 	   var  update_enddate=common_updata_para +"&DM.Instance.SiteUser.id="+id+"&DM.Instance.SiteUser.enddate="+enddate
	   document.getElementById('formlanmuadmin').action=update_enddate;
	   document.getElementById('formlanmuadmin').submit();	    	          
    }	  
    function update_urlkey(id,urlkey){
       var  update_urlkey=common_updata_para +"&DM.Instance.SiteUser.id="+id+"&DM.Instance.SiteUser.urlkey="+urlkey
	   document.getElementById('formlanmuadmin').action=update_urlkey;
	   document.getElementById('formlanmuadmin').submit();	    	          
    }	  

    function update_user(id,name,value){
       var  update_urlkey=common_updata_para +"&DM.Instance.SiteUser.id="+id+"&DM.Instance.SiteUser."+name+"="+value
	   document.getElementById('formlanmuadmin').action=update_urlkey;
	   document.getElementById('formlanmuadmin').submit();	    	          
    }	

	   
    var addAciton="site_user_add.ftl";			
    var deleteAction=common
                     +commonqry
                     +"&DM.Delete.SiteUser="
		             +"&DM.Query.SiteUser.Pagination.CurrentPage=0"
		             +"&DM.Query.SiteUser.__Depends=DM.Delete.SiteUser"
		             ;   
	     
	var modifyAction=commonreload+"&OT.Forward.success.URL="+ftlpath+"site_user_update.ftl";
	var uploadfileAction=commonreload+"&OT.Forward.success.URL="+ftlpath+"SiteUser_uploadfile.ftl";
	var searchAciton="./SiteUser_search.ftl";	
    var pageAciton=common
                   +commonqry
    	           +"&DM.Query.SiteUser.Pagination.CurrentPage="
		           ;     
	function deleteRow(ids){
		var ids = ids;
		var frmAction =deleteAction +"&DM.Instance.SiteUser.id=" + ids;
		document.getElementById('formlanmuadmin').action = frmAction;
		document.getElementById('formlanmuadmin').submit();
	}
	function modifyRow(ids){
		var ids = ids;
		document.getElementById('formlanmuadmin').action  =modifyAction  +"&DM.Instance.SiteUser.id=" + ids ;
		document.getElementById('formlanmuadmin').submit();
		return true;
	}
	
    function ftp(flag,username){
      document.getElementById('formlanmuadmin').action=common +commonqry+"&DM.business.FtpAdmin=&flag="+flag+"&username="+username;
	//  alert(document.getElementById('formlanmuadmin').action);
	  document.getElementById('formlanmuadmin').submit();		          
    } 	
</script>
<#include "/website/macro/commonfun.ftl">
<@tt width="800"/>
<p align="center" >
   &nbsp;&nbsp;&nbsp;
    <a class=bt href="/website/sitedm/add_user.ftl" >添加用户</a> 
    <a class=bt href="javaScript:update_system_map();" >更新域名映射</a> 
  <#--
    <br>&nbsp;&nbsp;&nbsp;
    导入路径<input id=userdata_import  style="border: 1px solid #666666;" type="input" size=30 value="c:/acme.zip"></input>
    导出路径<input id=userdata_export style="border: 1px solid #666666;" type="input" size=30 value="c:/"></input>
  -->
</p>
<form name="formlanmuadmin" id="formlanmuadmin" method="post"></form>
<#assign SiteUserList=results["DM.Query.SiteUser.Result"]>
<#assign sum_test=0>
<#list SiteUserList as SiteUser>
    <#if SiteUser.state?exists&&SiteUser.state=="T">
		<#assign sum_test=sum_test+1>
    </#if>			
</#list>	 
测试用户数:${sum_test}	
 <table id=area-data class="area-data"  cellSpacing="1" >
	<tr >
		<td ></td>
		<td >F</td>
		<td>用户名</td>
		<td>密码</td>
		<td >开始</td>	
		<td>到期</td>	
		<td >域名KEY</td>										
	    <#--
	    <td>导入数据</td>
        -->
        
		<td >操作</td>
	 </tr>						
	 <#list SiteUserList?sort_by("state") as SiteUser>
		<tr >
			<td class=td-data>${SiteUser_index + 1}</td>
			<td  class=td-data>
			<select  size="1" onchange="javascript:update_user('${SiteUser.id}','state',this.value);" >
		           <option value="${SiteUser.state?if_exists}">${SiteUser.state?if_exists}</option>
			       <option value="T">T</option>
				   <option value="D">D</option>
				   <option value="C">C</option>
			</select> 			
			</td>
			<td  class=td-data>${SiteUser.username?if_exists}</td>
 			<td  class=td-data>${SiteUser.password?if_exists}</td>
 			<td  class=td-data><input class=input type="input" size=10 onchange="javascript:update_begindate('${SiteUser.id}',this.value);" value="<#if SiteUser.begindate?exists>${SiteUser.begindate?date}</#if>"></td>
		    <td  class=td-data><input class=input type="input" size=10 onchange="javascript:update_enddate('${SiteUser.id}',this.value);" value="<#if SiteUser.enddate?exists>${SiteUser.enddate?date}</#if>"></td>
		    <td  class=td-data><input class=input type="input" size=30 onchange="javascript:update_urlkey('${SiteUser.id}',this.value);" value="${SiteUser.urlkey?if_exists}"></td>
		    <td  class=td-op>
			    <a  href="javaScript:modifyRow('${SiteUser.id}');" >修改</a>
			    <a  href="javaScript:deleteRow('${SiteUser.id}');" > 删除</a> 
		    <br>
			    <a  href="javaScript:ftp('open','${SiteUser.username?if_exists}');" >开FTP</a>
			    <a  href="javaScript:ftp('close','${SiteUser.username?if_exists}');" > 关FTP</a> 		    
		    </td>

		    <#--
		    <td><a class=bt href="javaScript:importdata('${SiteUser.id}');" >导入</a>
                <a class=bt href="javaScript:exportdata('${SiteUser.id}','${SiteUser.username}');" >导出</a></td>
             -->   
	   </tr>    
      </#list>

</table>
<@bb/>							
	










