<#include "top.ftl">
<#include "left.ftl">
<!-------------------------内容变化区----------------------------->
<script language="javascript" type="text/javascript">
    function ajax(){	
        if (document.getElementById('guest_name_lanmu').value.length == 0){
			document.getElementById('info_input_name').innerHTML='* 姓名不能为空';
			return ;
	    }		   
	   	if (document.getElementById('guest_leaveword_lanmu').value.length == 0){
			document.getElementById('info_txt_leaveword').innerHTML='* 内容不能为空';
			return ;
	    }
	    $.ajax({
            type:"POST",
         	url: "site!siteGuestSubmit.action",
		 	data:"siteuserid=${SiteUser.id?if_exists}"+"&leaveword_lanmu="+document.getElementById('leaveword_lanmu').value+"&name_lanmu="+document.getElementById('guest_name_lanmu').value,
		 	cache: false,
		 	success: function(html){
		    	document.getElementById('div_result').innerHTML=html;
		 
		 		document.getElementById('bt_sure').disabled =true;
		 		
		 	 }
		});   
	}  
	function change_leaveword(){
	    if (document.getElementById('guest_leaveword_lanmu').value.length != 0){
			document.getElementById('info_txt_leaveword').innerHTML='';
		}	
	}
	function change_name(){
	    if (document.getElementById('guest_name_lanmu').value.length != 0){
			document.getElementById('info_input_name').innerHTML='';
		}	
	}			
</script> 
<td valign=top  width=100%>
   	<div id=div-mid>
			<table  style="table-layout:fixed" >
		        <tr>
			        <td  id=snp-detail >
                    <#assign i=0/>               
                    <#assign listx = SiteUser.siteGuests >
				    <#list listx as x> 
				        <p id=snp-tb-title >${x.name?if_exists}&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp;&nbsp;${x.wordtime?if_exists}&nbsp;&nbsp</p>
			   			<div id=snp-tb-content>
			   			    ${x.leaveword?if_exists}
							
							<div style='border-bottom: #CCCCCC 1px dotted;'> </div>
							<#if (x.reply?exists)&&(x.reply!="")>
							<b>${infomap.getStringbyfile(local,"administraor")?if_exists}</b>&nbsp;&nbsp;&nbsp<span style="color:#f00">${x.reply?html}</span>
							</#if>
						</div>
						<#assign i=i+1/>
						<#if i<6>
						<#else>
						    <br><p style="float:right"><a id=oursite_a   href="javascript:set_show();" > more...</a></p><br>
						<#break>
						</#if>
				    </#list>	
				    	<div id=div_hide style="display:none;">
                    <#assign j=0/>  
				    <#list SiteUser.siteGuests as x> 
			       	     <#assign j=j+1/>
						 <#if j<6>
						 <#else>
				   		 <p id=snp-tb-title >${x.name?if_exists}&nbsp;&nbsp&nbsp;&nbsp(&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${x.wordtime?if_exists}&nbsp;&nbsp)</p>
				   		 <div id=snp-tb-content >
				   			    ${x.leaveword?if_exists}
								
								<div style='border-bottom: #CCCCCC 1px dotted;'> </div>
								<#if (x.reply?exists)&&(x.reply!="")>
								<b>${infomap.getStringbyfile(local,"administraor")?if_exists}</b>&nbsp;&nbsp;&nbsp<span style="color:#f00">${x.reply?html}</span>
								</#if>
						 </div>	
						 </#if>					       	
				    </#list>
				    </div>	
		         
			        	<br> <b><#-- ${infomap.getStringbyfile(local,"yoursuggestion")?if_exists}-->
						 ${infomap.getStringbyfile(local,"yoursuggestion")?if_exists}
			        	</b><br>
			        	<TEXTAREA  id=guest_leaveword_lanmu  name=leaveword_lanmu class="input-snp"  onChange="change_leaveword(this.value);" onblur="this.className='input-snp'" onfocus="this.className='input-snp-onfocus'"   rows=6 cols=78><#if (results?exists)&&(results["submitinfo"]?exists)><#if results["submitinfo"]=="pic_error">${guest.leaveword}</#if></#if></TEXTAREA> 
			        	<span id=info_txt_leaveword style="color: #f00;"></span>
			           	<br>
			           	${infomap.getStringbyfile(local,"yourname")?if_exists}
 			           	<input id=guest_name_lanmu  onChange="change_name(this.value);"    class="input-blur"  onfocus="this.className='input-focus'"   size=4  name=name_lanmu value=""><span id=guest_name_check style="color: #f00;"></span>
					   	<span id=info_input_name style="color: #f00;"></span>
                        &nbsp;&nbsp;
                        <input class=bt  type="submit"  id="bt_sure"  onclick="javascript:ajax()"   value="${infomap.getStringbyfile(local,"submit")?if_exists}">
                        <div id=div_result style="color: #f00;"></span>
			       </td>
		       </tr>	    
    		   <tr>
			       <td id=snp-detail>
			      		<#if (results?exists)&&(results["submitinfo"]?exists)&&results["submitinfo"]=="pic_error">
				        <font color="red">${infomap.getStringbyfile(local,"verificationerror")?if_exists}</font>
						</#if>
		  		    </td>
		        </tr>
			</table>
		       
    </div> 
</td>
<!-------------------------内容变化区----------------------------->			
<#include "bottom.ftl">			
			      
