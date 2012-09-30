<script type="text/javascript">
$(document).ready(function(){
	$(function() {
		$("#resizable").resizable({
			helper: 'ui-resizable-helper'
		});
	});

	$(function() {
		$("#draggable").draggable();
	});
	
	<#if (SiteUser.getSiteSpmp8s()?size>0)&&LanmuObject.vphonindex=="YES">
	createfirstflv("200","150");	
	</#if>
});
	
</script>
<script type="text/javascript">
	function pingpu(){
		width=$("#resizable").css("width");
		height=$("#resizable").css("height");
		createfirstflv(width ,height);
	}
	
   function createfirstflv(width ,height){
		swfobject.embedSWF(
			"../../other/video/vcastr22.swf", "flashcontent",width, height, "9.0.0", "expressInstall.swf",
			{FlashVars:"LogoText=&IsAutoPlay=<#if LanmuObject.videoautoplay=="">1<#else>0</#if>&IsContinue=1&vcastr_file=<#list SiteUser.getSiteSpmp8s() as x>../../site/${SiteUser.username}/${x.filepath?if_exists}.flv<#if x_has_next>|</#if></#list>",allowFullScreen:"true"}, 
			 {}, {}
		 );
	}    

</script>
	
<td id=snp-right-td  valign=top >
<#if LanmuObject.lanmualldirdisplay=="onlyleft"||LanmuObject.lanmualldirdisplay=="none">
<#else>
   	<div id=div-right style="width:200px;">      
   	    <#if (SiteUser.siteLinks?size>0)>  
 	    <div style="margin-bottom:10px" class="ui-widget ui-widget-content ui-corner-all">   
		    <table>
		    <#list SiteUser.siteLinks as x>
	            <tr>
	                <td align=left id=snp-detail >
	                <@strbylanguage v1=x.detail v2=x.detail2?if_exists v3=x.detail3?if_exists />
	                </td>
	            </tr>
	            <tr>
	                <td>
	          	    <#if x.imagealign?exists&&x.imagealign!='NO'  ><@richmedia x/> </#if>
	                </td>
	            </tr>
		    </#list>
		   	</table>
 		</div>
 		</#if>
	    <#if SiteUser.contentright?exists&&SiteUser.contentright!=''>
	    <div style="margin-bottom:10px" class="ui-widget ui-widget-content ui-corner-all">${SiteUser.contentright?if_exists}</div> 	
	    </#if>
		
	    <table>
		    <tr><td>
			    <#if (SiteUser.getSiteSpmp8s()?size>0&&LanmuObject.vphonindex=="YES")>
			   	<div id="draggable">
					<div id="resizable" class="ui-widget ui-widget-content ui-corner-all">
						<div id="flashcontent"></div>
						<p align=right style="display: inline;">
							<span class="ui-icon ui-icon-newwin"  onclick="createfirstflv('200','150');"></span>
							<span class="ui-icon ui-icon-arrow-4-diag"  onclick="pingpu();" ></span>
						</p>	
					</div>
				</div>      	    
			    </#if>
		    </td></tr>
	    </table>	
	    <div> <@qqdisplay  qqstr=LanmuObject.qq  layout="col"/></div>	
	</div>
</#if>
</td>