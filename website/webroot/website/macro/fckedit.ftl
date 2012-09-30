<#include "/website/macro/map_language_title.ftl">
<#include "/website/macro/commonfun.ftl">
<#macro editor user vartxt>
		<script type="text/javascript">
			window.onload = function()
			{
				var sBasePath ='/';
				var oFCKeditor = new FCKeditor( '${vartxt}' ) ;
				oFCKeditor.BasePath	= sBasePath ;
				oFCKeditor.ToolbarSet ='Basic';
				oFCKeditor.ReplaceTextarea() ;
				
				<#---->	   
				<#if user.language2="">
			    <#else>
				var oFCKeditor2 = new FCKeditor( '${vartxt}2' ) ;
				oFCKeditor2.BasePath	= sBasePath ;
				oFCKeditor2.ToolbarSet ='Basic';
				oFCKeditor2.ReplaceTextarea() ;	    
			    </#if>
		 	    <#if user.language3="">
			    <#else>
				var oFCKeditor3 = new FCKeditor( '${vartxt}3' ) ;
				oFCKeditor3.BasePath	= sBasePath ;
				oFCKeditor3.ToolbarSet ='Basic';
				oFCKeditor3.ReplaceTextarea() ;	    
			    </#if>
			     					
			}
		</script>	
</#macro>
	
<#macro fckeditadd user vartxt  title="" model="complex">
    <#if model="simple">
		 	 	<span class=info>${title}</span>
		 		<input id=oursite_input type="text" size="70" value="${user.name?if_exists}"  name="${vartxt}">&nbsp;<font color="red">*</font>
			<#---->   
			<#if user.language2="">
			<#else>
			 	<br>${title}<span class=info>${language_name[user.local2]}</span>
			 	<input id=oursite_input type="text" size="70" value="${user.name2?if_exists}"  name="${vartxt}2">&nbsp;<font color="red">*</font>
			</#if>
			<#if user.language3="">
			<#else>
	 			<br>${title}<span class=info>${language_name[user.local3]}]</span>
	 			<input id=oursite_input type="text" size="70" value="${user.name3?if_exists}"  name="${vartxt}3">&nbsp;<font color="red">*</font>
			</#if>
			      
    <#else>
	       <@editor user=user  vartxt=vartxt  />
	 			<span class=info>${title}</span>
				<br><textarea id="${vartxt}" name="${vartxt}" style="WIDTH: 100%; HEIGHT: 200px"></textarea>
			<#---->
			<#if user.language2="">
		    <#else>
			     <br> ${title}<span class=info>${language_name[user.local2]}]</span>
			     <br><textarea cols="70" rows="8"  name="${vartxt}2"></textarea> 
	     	</#if>
	 	    <#if user.language3="">
		    <#else>
			     <br>${title}<span class=info>${language_name[user.local3]}]</span>
			     <br><textarea cols="70" rows="8"  name="${vartxt}3"></textarea> 
	     	</#if>
	     	
    </#if>
		     					
</#macro>	



<#macro fckeditupdate user vartxt  title="" v1="" v2="" v3="" model="complex">
    <#if model="simple">
	 		<p class=info>${title}<p>
	 		
	 		<input class=input type="text" size="50" value="${v1}"  name="${vartxt}"><span class=info></span>
			<#---->
			<#if user.language2="">
			<#else>
		 	<br>
		 	<input class=input type="text" size="50" value="${v2}"  name="${vartxt}2"><span class=info>${language_name[user.local2]}</span>
			</#if>
			<#if user.language3="">
			<#else>
 			<br>
 			<input class=input type="text" size="50" value="${v3}"  name="${vartxt}3"><span class=info>${language_name[user.local3]}</span>
			</#if>
			
    <#else>    
         	<@editor user=user  vartxt=vartxt  />	
	        <tr>
	        <td id=oursite_tb_data>
				
				<p class=info>${title}<p>
				<textarea id="${vartxt}" name="${vartxt}" style="WIDTH: 100%; HEIGHT: 200px">${v1}</textarea>
			<#--	-->
			<#if user.language2="">
		    <#else>
			     <br><span class=info>${language_name[user.local2]}</span>
			     ${title}
				 <br><textarea cols="70" rows="8"  name="${vartxt}2">${v2}</textarea> 
	     	</#if>
     	    <#if user.language3="">
		    <#else>
			     <br><span class=info>${language_name[user.local3]}</span>
			     ${title}
				 <br><textarea cols="70" rows="8"  name="${vartxt}3">${v3}</textarea> 
	     	</#if>
	     
     	    </td>
     	    </tr>	
    </#if>     	    				
</#macro>	

