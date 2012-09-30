<#macro strbylanguage v1=""  v2=""  v3="">
	<#switch language>
		  <#case "1">${v1?if_exists?trim}<#break>
		  <#case "2">${v2?if_exists?trim}<#break>
		  <#case "3">${v3?if_exists?trim}<#break>
		  <#default>
	</#switch>				
</#macro>

<#macro qqdisplay qqstr  layout="">
	    <#if qqstr?exists&&qqstr!="">
		    <#list qqstr?split(",") as x>      
		        <#assign qq=x?split(":")>
		           <#if layout="col"><br> </#if>&nbsp<a target=blank href=tencent://message/?uin=${qq[0]}&Site=www.snpsoft.net&Menu=yes><img align=absmiddle border=0  src=../../other/qq_online.gif ><#if qq?size==2>&nbsp;${qq[1]}<#else></#if></a>
		    </#list>
	    </#if>			
</#macro>



<#macro richmedia x>
 	<#if x.filepath?exists&& x.filepath!="">
 	 	<img   border =0  <#if x.width?exists&&x.width!="">width=${x.width?if_exists}</#if>  <#if x.height?exists&&x.height!="">height=${x.height?if_exists}</#if>  src="../../site/${SiteUser.username}/${x.filepath?if_exists}">  			
	</#if>               
	<#if x.filepathvideo?exists&& x.filepathvideo!=""&&x.checkVideofile(SiteUser.username+'/'+x.filepathvideo)>                                         
			<object classid=clsid:D27CDB6E-AE6D-11cf-96B8-444553540000 codebase=http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0 width=${x.widthvideo?default("250")} height=${x.heightvideo?default("150")}>
				<param name=movie value=../../other/video/vcastr22.swf>
				<param name=quality value=high>
				<param name=allowFullScreen value=true />                                
				<param name=FlashVars value='LogoText=${LanmuObject.videologtxt?if_exists}&IsAutoPlay=<#if LanmuObject.videoautoplay=="">1<#else>0</#if>&IsContinue=1&vcastr_file=../../site/${SiteUser.username}/${x.get_video_path(x.filepathvideo)}.flv' />
			</object>	
	</#if>               
</#macro>
<#macro singlepage   data ht="">
	<script language="javascript" type="text/javascript">
		document.getElementById('hengtiao').innerHTML = '${ht?if_exists}';
	</script>
	<td valign=top  width=100%>
		<div id=div-mid>
			<table style="table-layout: fixed" >
				   <tr><td><@SiteSingleData classes=data />
				   </td></tr>
			</table>
	    </div>
	</td>	   
</#macro> 

<#macro SiteSingleData   classes>
    <#list classes as x>
        <#if x.filepath?exists||x.filepathvideo?exists||x.imagealign?exists>
            <#if x.imagealign?exists><#assign imagealign=x.imagealign/>
            <#else><#assign imagealign="down"/>    
            </#if>
        <#else>
            <#assign imagealign=""/>    
        </#if>
        <#if x.title?exists>
        <p><a id=snp-item-title name="${x.id?if_exists}"><@strbylanguage v1=x.title?if_exists v2=x.title2?if_exists v3=x.title3?if_exists />	</a><p>
        </#if>
		<table>
        <#switch imagealign>
            <#case "left">
                <tr>
                    <td id=snp-detail valign=top> <@richmedia x/></td>
                    <td id=snp-detail valign=top style="padding-left:20px"><@strbylanguage v1=x.detail v2=x.detail2?if_exists v3=x.detail3?if_exists /></td>
                </tr>                                      
             <#break>
             <#case "right">
                 <tr>
                     <td id=snp-detail valign=top style="padding-right:20px"><@strbylanguage v1=x.detail v2=x.detail2?if_exists v3=x.detail3?if_exists /></td>
                     <td id=snp-detail valign=top><@richmedia x/></td>
                 </tr>                                      
             <#break>
             <#case "down">
                 <tr>
                     <td id=snp-detail valign=top><@strbylanguage v1=x.detail v2=x.detail2?if_exists v3=x.detail3?if_exists /></td>
                 </tr>
                 <tr>
                     <td id=snp-detail align=middle><@richmedia x/></td>
                 </tr>                                                                       
             <#break>
             <#case "up">
                 <tr>
                      <td id=snp-detail align=middle colspan=2><@richmedia x/></td>
                 </tr>
                 <tr>
                     <td id=snp-detail valign=top><@strbylanguage v1=x.detail v2=x.detail2?if_exists v3=x.detail3?if_exists /></td>
                 </tr>                                      
             <#break>
             <#default>
                 <tr>
                     <td id=snp-detail align=left valign=top>
                      <@strbylanguage v1=x.detail v2=x.detail2?if_exists v3=x.detail3?if_exists />                      
                     </td>
                 </tr>                                   
        </#switch>                  
		</table>
    </#list>
</#macro>     
<#macro lanmulink  lanmuname>
	<#assign firstId=SiteUser.getSpmpFirstIDByLanmuName(lanmuname)/>    
    <#if lanmuname==""||(!SiteUser.getValueByName(lanmuname+"Lanmu")?exists)||SiteUser.getValueByName(lanmuname+"Lanmu")=="">
    <#else>
        <#switch language>
 	        <#case "1"><li><a href="${lanmuname?if_exists}_1${firstId}.html"><span  >&nbsp;${SiteUser.getValueByName(lanmuname+"Lanmu")?if_exists}</span></a></li><#break>
	        <#case "2"><li><a href="${lanmuname?if_exists}_2${firstId}.html"><span  >&nbsp;${SiteUser.getValueByName(lanmuname+"Lanmu2")?if_exists}</span></a></li><#break>
	        <#case "3"><li><a href="${lanmuname?if_exists}_3${firstId}.html"> <span >&nbsp;${SiteUser.getValueByName(lanmuname+"Lanmu3")?if_exists}</span></a></li><#break>
         </#switch>         
    </#if>          
</#macro>
<#macro lanmudirleft  items  title='' title1=''  title2=''    lanmuname=""  cssStyle=0>
    <#if cssStyle<50>
	 	<table  class="snp-left-tb"  width=100%>	
	 	    <tr><td colspan=2 id=snp-left-lanmutitle align=left height=25 style=""><@strbylanguage v1=title v2=title1?if_exists v3=title2?if_exists/></td></tr>
	 	    <#list items as x> 
	 	        <#if x.name?exists&& x.name!="">
					<tr id="${lanmuname}_${x_index}" >
						<td width=10 valign=top>
							<img id=dir_${lanmuname}_${x_index} src="<#if x.getSubItems()?size==0||id?exists&&id?string==x.id?string>../../other/dir/minus.gif<#else>../../other/dir/plus.gif</#if>"  onclick="javascript:showHiddenNode(this,'${lanmuname}_${x_index}')" style="cursor:hand;" > 
		
						</td>
						<td  valign=top style="padding: 3px 0px 0px 0px;" align=left width=100%>
						    <a href="${lanmuname}_${language}_${x.id}.html" target=_self><@strbylanguage v1=x.name v2=x.name2?if_exists v3=x.name3?if_exists /></a>	
						</td>
					</tr>
				    <#if x.getSubItems()?exists>
				    	<#list x.getSubItems() as y>
				    	    <#if y.title?exists&&y.title!="">
								<tr height=10px id="${lanmuname}_${x_index}_${y_index}" pid="${lanmuname}_${x_index}"   style="<#if id?exists&&id?string==x.id?string><#else>display:none</#if>">
									<td width=10>
									</td>
									<td align=left>
							      		&nbsp;&nbsp;&nbsp;<a href="${lanmuname}_${language}_${x.id}.html#${y.id}" target=_self>
							      		<@strbylanguage v1=y.title v2=y.title2?if_exists v3=y.title3?if_exists/></a>
							      		         
								    </td>
								 </tr> 
							 </#if>
						</#list>	 
					 </#if>	 
					 <#if LanmuObject.dirlever=="">
						<script language="javascript"> 
							document.getElementById("dir_${lanmuname}_${x_index}").onclick();
						</script>
					</#if>	
				
				</#if> 			
			</#list>	
		</table>
	<#else>	
 		<h3><a href="#"><@strbylanguage v1=title v2=title1?if_exists v3=title2?if_exists/></a></h3>
 		<div style="line-height:22px;"> 
		<#list items as x>
	
		 <a href="${lanmuname}_${language}_${x.id}.html" target=_self ><span style="margin:210px 0px 13px 0px;"><@strbylanguage v1=x.name v2=x.name2?if_exists v3=x.name3?if_exists /></span></a>	
		&nbsp;&nbsp;<br>
		    <#if x.getSubItems()?exists>
		    	<#list x.getSubItems() as y>
		    	    <#if y.title?exists&&y.title!=""> 
		    	      
						<span class="ui-icon ui-icon-triangle-1-e" ></span><a href="${lanmuname}_${language}_${x.id}.html#${y.id}" target=_self>
					    		<@strbylanguage v1=y.title v2=y.title2?if_exists v3=y.title3?if_exists/></a> <br>
					  
					 </#if>
				</#list>	 
			 </#if>	 
	    </#list>			 
		</div>	
	</#if> 
</#macro>




﻿<#macro strbylanguage v1=""  v2=""  v3="">
	<#switch language>
		<#case "1">${v1?if_exists?trim}<#break>
		<#case "2">${v2?if_exists?trim}<#break>
		<#case "3">${v3?if_exists?trim}<#break>
		<#default>
	</#switch>				
</#macro>

<#macro SiteLanguage>
    	 <#if SiteUser.language2?default('')=""&&SiteUser.language3?default('')=""> 
         <#else>
             <a href="index_1.html"><img align="absmiddle"  width="20" height="13"    src="../../other/flag/${SiteUser.local?default('en')}.png"/>${language_name[SiteUser.local]?default('en')}</a>
         </#if>              
         <#if SiteUser.language2?default('')="">                                                                          
         <#else>
             <a href="index_2.html"><img  align="absmiddle"  width="20" height="13"   src="../../other/flag/${SiteUser.local2}.png"/>${language_name[SiteUser.local2]?default('en')}</a>
         </#if>     
         <#if SiteUser.language3?default('')="">
         <#else>
             <a href="index_3.html"><img  align="absmiddle"  width="20" height="13"  src="../../other/flag/${SiteUser.local3}.png"/>${language_name[SiteUser.local3]?default('en')}</a>
         </#if>                                
                          
</#macro>

<#macro extlink  palace >
    <#assign firstId=SiteUser.getSpmpFirstIDByLanmuName("spmp9")/>   
    
  	<#list SiteUser.siteSpmp9s as x>
    	<#if  x.imagealign?default('menu_top')==palace>
	    	<#--
	     		<a     href="site!siteSpmp9Detail.action?id=${x.id}"><span><@strbylanguage v1=x.name v2=x.name2?if_exists v3=x.name3?if_exists /></span></a>
	        -->
         <#switch language>
 	        <#case "1"><a href="spmp9_1${firstId}.html"><span>&nbsp;${x.name?if_exists}</span></a><#break>
	        <#case "2"><a href="spmp9_2${firstId}.html"><span >&nbsp;${x.name2?if_exists}</span></a><#break>
	        <#case "3"><a href="spmp9_3${firstId}.html"> <span>&nbsp;${x.name3?if_exists}</span></a><#break>
         </#switch> 
        </#if>
    </#list>	
</#macro>




<#macro filedownpage   data lanmuname=''>
	<td valign=top  width=100%>
		<div id=div-mid>
			<table style="table-layout: fixed" > 
			<#list data as x>
				<tr>
					<td id=snp-detail>
			   	 		<@strbylanguage v1=x.detail?if_exists v2=x.detail2?if_exists v3=x.detail3?if_exists />	
					</td> 
				</tr>
			    <#list x.getSubItems() as y>
					<#if y.filename?exists >
						<tr>
						    <td id=snp-detail align=left  style="padding-left: 16px;">
						        <#if y.detail?exists&&y.detail!=""><@strbylanguage v1=y.detail v2=y.detail2?if_exists v3=y.detail3?if_exists /><#else>${y.filename?if_exists}</#if>						      	
						      	<a id=snp-detail href="filedownload!filedown_lanmu.action?fileid=${y.id?if_exists}&userid=${x.siteUser.id?if_exists}" target=_blank>
							        &nbsp;&nbsp;&nbsp;[下载]
							    </a>	
						      	<a id=snp-detail href="/site/${x.siteUser.username?if_exists}/${y.filepath?if_exists}" target=_blank>
							        &nbsp;&nbsp;&nbsp;[浏览]
							    </a>							    
						    </td>
						</tr>                   
					<#else>
						<tr>
						    <td id=snp-detail align=left>
			                    <@strbylanguage v1=y.detail?if_exists v2=y.detail2?if_exists v3=y.detail3?if_exists />
							</td>
						</tr>										    
					</#if>				   
			    </#list>
			</#list>	
			</table>		
	    </div>
	</td>	   
</#macro> 



