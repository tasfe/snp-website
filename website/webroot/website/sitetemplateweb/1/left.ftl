<#if LanmuObject.lanmualldirdisplay=="onlyright"||LanmuObject.lanmualldirdisplay=="none">
<#else>
    <td  valign=top >
	    <div  id="div-dir" style="width:200px;">
	        <div id="navlist">
			    <#if LanmuObject.lanmudir1!=""&&SiteUser.getValueByName(LanmuObject.lanmudir1+"Lanmu")!="">
			      <@lanmudirleft  lanmuname=LanmuObject.lanmudir1 title=SiteUser.getValueByName(LanmuObject.lanmudir1+"Lanmu")   title1=SiteUser.getValueByName(LanmuObject.lanmudir1+"Lanmu2") title2=SiteUser.getValueByName(LanmuObject.lanmudir1+"Lanmu3")  items=SiteUser.getListByName(LanmuObject.lanmudir1)   cssStyle=SiteUser.cssStyle?number  />
			    </#if> 
			    <#if LanmuObject.lanmudir2!=""&&SiteUser.getValueByName(LanmuObject.lanmudir2+"Lanmu")!="">
			      <@lanmudirleft  lanmuname=LanmuObject.lanmudir2 title=SiteUser.getValueByName(LanmuObject.lanmudir2+"Lanmu")   title1=SiteUser.getValueByName(LanmuObject.lanmudir2+"Lanmu2") title2=SiteUser.getValueByName(LanmuObject.lanmudir2+"Lanmu3")  items=SiteUser.getListByName(LanmuObject.lanmudir2)   cssStyle=SiteUser.cssStyle?number    />
			    </#if> 
			    
			    <#if LanmuObject.lanmudir3!=""&&SiteUser.getValueByName(LanmuObject.lanmudir3+"Lanmu")!="">
			      <@lanmudirleft  lanmuname=LanmuObject.lanmudir3 title=SiteUser.getValueByName(LanmuObject.lanmudir3+"Lanmu")   title1=SiteUser.getValueByName(LanmuObject.lanmudir3+"Lanmu2") title2=SiteUser.getValueByName(LanmuObject.lanmudir3+"Lanmu3")  items=SiteUser.getListByName(LanmuObject.lanmudir3)   cssStyle=SiteUser.cssStyle?number    />
			    </#if> 
			    
			    <#if LanmuObject.lanmudir4!=""&&SiteUser.getValueByName(LanmuObject.lanmudir4+"Lanmu")!="">
			      <@lanmudirleft  lanmuname=LanmuObject.lanmudir4 title=SiteUser.getValueByName(LanmuObject.lanmudir4+"Lanmu")   title1=SiteUser.getValueByName(LanmuObject.lanmudir4+"Lanmu2") title2=SiteUser.getValueByName(LanmuObject.lanmudir4+"Lanmu3")  items=SiteUser.getListByName(LanmuObject.lanmudir4)   cssStyle=SiteUser.cssStyle?number    />
			    </#if> 
	        </div>
	    </div> 
        <div>
	         ${SiteUser.contentleft?if_exists} 
	        <br><@qqdisplay  qqstr=LanmuObject.qqleft  layout="col"/>  			        
        </div> 	
    </td>
</#if>