<#if listx?size?string=="1" > 
<#else>
	<#assign index =x_index>
 	<#if index?string=="0">
 	    <a href="javascript:change_rank('${x.id?if_exists}','${listx[x_index+ 1].id}')">
 
 	    	<span title="下" class="ui-state-default ui-corner-all" ><span  class="snp-icon ui-icon-arrowthick-1-s"></span></span>
  	    </a>
 	<#else>
 	    <#if x_has_next>
 	    <a href="javascript:change_rank('${x.id?if_exists}','${listx[x_index- 1].id}')">
			<span title="上" class="ui-state-default ui-corner-all" ><span  class="snp-icon ui-icon-arrowthick-1-n"></span></span>
		</a>
		<a href="javascript:change_rank('${x.id?if_exists}','${listx[x_index+ 1].id}')">
		  	<span title="下" class="ui-state-default ui-corner-all" ><span  class="snp-icon ui-icon-arrowthick-1-s"></span></span>
		</a>
		<#else>
		<a href="javascript:change_rank('${x.id?if_exists}','${listx[x_index -1].id}')">
			<span title="上" class="ui-state-default ui-corner-all" ><span  class="snp-icon ui-icon-arrowthick-1-n"></span></span>
		</a>
		 </#if>
 	</#if>
</#if>			