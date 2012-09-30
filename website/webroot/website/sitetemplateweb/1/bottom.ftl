		</tr>
	</table>
</div>
<div class="ui-state-default "></div>
<#if SiteUser.bottom?exists&&SiteUser.bottom!=''>
<div id="bottom" >
    <#---
	<div class="wrapper" >
	    <div class="sharp color4">
	        <b class="b1"></b><b class="b2"></b><b class="b3"></b><b class="b4"></b> 
	        <div class="content" style="padding:16px;">
	      	    ${SiteUser.bottom?if_exists}	       
	        </div>
	        <b class="b5"></b><b class="b6"></b><b class="b7"></b><b class="b8"></b>    
	    </div>
	</div>
	-->
	<div class="ui-widget">
		<div class="ui-state-highlight ui-corner-all" style="margin-top: 5px; padding:16px;"> 
			<p>
			${SiteUser.bottom?if_exists}</p>
		</div>
	</div>		
	
</#if>

	<div id="bottom-extlink" >
	
		<@extlink  palace='menu_bottom'/>
		<@qqdisplay  qqstr=LanmuObject.qqbottom  layout=""/>
	</div>  
	   
</div> 
<div class="bottom_background">
	<div class="snp-bottom-new"></div>
</div>

</div><!--end page-->
<#--<#if LanmuObject.musicfilename==""> <#else><bgsound src="/site${LanmuObject.musicfilename}" loop=-1></#if>  -->      
</body>
		   