<link href="/website/css/content.css" rel="stylesheet" type="text/css">
<#include "/website/macro/commonfun.ftl">
<script language="javaScript" src="/other/jquery151/jquery-1.5.1.min.js"></script>
<script language="javascript">
    function check(){
	 
    	if(document.getElementById("newpassword").value!=document.getElementById("newrepeatpassword").value){
    	 document.getElementById('div_result').innerHTML='新密码两次输入不一致';
    	  setTimeout( "document.getElementById('div_result').innerHTML=''", 2000);
  		 return false;
  		}
  		document.getElementById('div_result').innerHTML='';
  		return true;
	}	
    function ajax(){
     $.ajax({
             type:"POST",
             url: "siteadmin!ajax_password.action",
			 data:"oldpassword="+document.getElementById('oldpassword').value+"&newpassword="+document.getElementById('newpassword').value+"&userid=${Session["clientlogined"].id}",
			 cache: false,
			 success: function(html){
			   document.getElementById('div_result').innerHTML=html;
			 setTimeout( "document.getElementById('div_result').innerHTML=''", 2000);
			  }
			});   
     }
     
</SCRIPT>


<@tt  width="500"/> 
    <div class="title" ><span class=info-big>设置密码</span></div>
 	<div class="content">
	 	<table width=350px>
		 <#--
		 <#if Session["clientlogined"].password?exists&&Session["clientlogined"].password!=''>
		 <#else>
		    <input type="hidden" name="oldpassword" value="">         
		 </#if>
		 -->
 			<tr>
			    <td id=oursite_tb_data>当前密码</td>
			    <td id=oursite_tb_data><input id="oldpassword" class=input type="password"  name="oldpassword" size="20"></td>
			</tr>

		     
			<tr >
		    	<td  id=oursite_tb_data>新密码</td>
			    <td  id=oursite_tb_data> <input id="newpassword" class=input type="password" name="newpassword" size="20" ></td>
			</tr>
			<tr>
		    
		   	<td  id=oursite_tb_data>重新输入新密码</td>
			    <td  id=oursite_tb_data> <input id="newrepeatpassword" class=input type="password" name="newrepeatpassword" size="20" onchange="check()"></td>    
			</tr>
			<tr>
			    <td  align="center" colspan="2" >
			    <br><div id=div_result style="color:#f00"></div>
			     <input class=bt type="submit" onclick="javascript:ajax()" value="确定" name="B1" >
			     
				</td>
			</tr>
		</table>
    </div>
<@bb/> 
