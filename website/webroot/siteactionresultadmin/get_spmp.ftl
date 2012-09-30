<#include "/website/macro/commonfun.ftl">
<#macro spmplink nob x lanmutitle=''>
    <p class=bold> ${x.name?if_exists}
  	<a   href="javascript:modify_parent('${results["SiteUser"].id}','${x.id}','pmp${nob}','${lanmutitle}','${results["SiteUser"].local?if_exists}');"> <span title='修改' class="icon icon-edit"></span></a>
	<a  href="javascript:del('SiteSpmp${nob}','${x.id}','${lanmutitle}');"><span  class="icon icon-del"></span></a>
	</p>
  	<#list x.getSubItems() as y> 
  	     --
  		 ${y.title?if_exists}
  		 <a  href="javascript:modifychild_SiteSpmpItem('${results["SiteUser"].id}',${x.id},${y.id},'pmp${nob}','${lanmutitle}','${results["SiteUser"].local?if_exists}');");"><span title='修改' class="icon icon-edit"></span></a>        
  		 <a   href="javascript:del('SiteSpmp${nob}Item','${y.id}','${lanmutitle}','${results["SiteUser"].local?if_exists}');");"><span  class="icon icon-del"></span></a>
  		 <br>
	</#list>
</#macro>	
<div  id="div_quick_edit" class=div-f-qedit >
<p align=right ><a href="javascript:get_null();"> <span  class="icon icon-hide"></span></a></p>
<div class=content>
	<p class=bold style="padding: 3px 6px 3px 0px;">${results["SiteUser"].spmp1Lanmu?if_exists}</p>
	<#list results["SiteUser"].getSiteSpmp1s() as x> 
	   <@spmplink  nob="1" x=x  lanmutitle='${results["SiteUser"].spmp1Lanmu?if_exists}'/>  
    </#list>

    <p class=bold style="padding: 3px 6px 3px 0px;">${results["SiteUser"].spmp2Lanmu?if_exists}</p>
	<#list results["SiteUser"].getSiteSpmp2s() as x> 
	   <@spmplink  nob="2" x=x lanmutitle='${results["SiteUser"].spmp2Lanmu?if_exists}'/>  
    </#list>

   <p class=bold style="padding: 3px 6px 3px 0px;">${results["SiteUser"].spmp3Lanmu?if_exists}</p>
	<#list results["SiteUser"].getSiteSpmp3s() as x> 
	   <@spmplink  nob="3" x=x lanmutitle='${results["SiteUser"].spmp3Lanmu?if_exists}'/>  
    </#list>

    <p class=bold style="padding: 3px 6px 3px 0px;">${results["SiteUser"].spmp6Lanmu?if_exists}</p>
	<#list results["SiteUser"].getSiteSpmp6s() as x> 
	   <@spmplink  nob="6" x=x lanmutitle='${results["SiteUser"].spmp6Lanmu?if_exists}'/>  
    </#list>
</div>
</div>
