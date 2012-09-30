<#include "/website/include/head_js_css.ftl">
<script language="javascript">
	var  common="siteoperationControl.action?OT.Forward.success.Type=freemarker&OT.Forward.success.URL=/website/sitedm/globe_language.ftl"
                    +"&DM.Reload.SiteUser=SiteUser&DM.Update.SiteUser=SiteUser&DM.Reload.SiteUser.__Depends=DM.Update.SiteUser"
                    +"&DM.Instance.SiteUser.id=${Session["clientlogined"].id}&DM.Object.SiteUser=SiteUser"
                    +"&DM.business.PutClientUserToSession="
                    +"&userid=${Session["clientlogined"].id}"
                    +"&DM.business.PutClientUserToSession.__Depends=DM.Reload.SiteUser"  ;

	function update_user_property(name,value){
		document.getElementById('formlanmuadmin').action =common+"&DM.Instance.SiteUser."+name+"="+value;
		document.getElementById('formlanmuadmin').submit();
	}
 
	function upotherusername(value){
	    
	    document.getElementById('formlanmuadmin').action =common+"&DM.Instance.SiteUser.otherusername="+value;
	    document.getElementById('formlanmuadmin').submit();
	}		
</script>

<body>
<div class="area-edit">
<table width=500px>
	<tr><td>
	<div  class="title">多国语言</div>
	<div class="content">
	<form name="formlanmuadmin" id="formlanmuadmin" action="siteoperationControl.action" method="post" ></form>
			    
		<#assign keys = language_name?keys>
        <table>
          	<tr>
                <td>默认语言</td>
                <td>
               
				    <select class=input name="DM.Instance.SiteUser.local" size="1" onchange="javascript:update_user_property('local',this.value);" value="${Session["clientlogined"].local?if_exists}">
					    <option value="${Session["clientlogined"].local?default('en')}">${language_name[Session["clientlogined"].local]}</option>
					    <#list keys as key>
						   <option value="${key}">${language_name[key]}</option>
						</#list> 
					</select> 			                
                </td>
                <td></td>			                
             </tr>
          	<tr>
                <td>多国语言2</td>
                <td>
	                     <select   class=input   name="DM.Instance.SiteUser.local2"  onchange="javascript:update_user_property('local2',this.value);"   size="1">
					    	<option value="${Session["clientlogined"].local2?default('en')}">${language_name[Session["clientlogined"].local2?default('en')] }</option>
						    <#list keys as key>
							   <option value="${key}">${language_name[key]}</option>
							</#list> 
					    </select>	 
								                
                </td>
                <td>
					<input   type="radio" onclick="javascript:update_user_property('language2',this.value);" <#if Session["clientlogined"].language2?default('')=="">checked<#else></#if> name="radio_none2" value="">      	
				           关闭              
				    <input   type="radio" onclick="javascript:update_user_property('language2',this.value);" <#if Session["clientlogined"].language2?default('')==""><#else>checked</#if>   name="radio_display2" value="YES">
		                                开通    				                
                </td>
             </tr>				                
          
          	<tr>
                <td><span class=info>多国语言3</span> </td>
                
                <td>
					 <span id="select_local3" >
					<select   class=input   name="DM.Instance.SiteUser.local3"  onchange="javascript:update_user_property('local3',this.value);"   size="1">
				    	<option value="${Session["clientlogined"].local3?default('en')}">${language_name[Session["clientlogined"].local3?default('en')]}</option>
					    <#list keys as key>
						   <option value="${key}">${language_name[key]}</option>
						</#list> 
				    </select>	
				    
				    </span>			                
                </td>
                <td>
					<input   type="radio" onclick="javascript:update_user_property('language3',this.value);" <#if Session["clientlogined"].language3?default('')=="">checked<#else></#if> name="radio_none3" value="">      	
				           关闭  
				    <input   type="radio" onclick="javascript:update_user_property('language3',this.value);" <#if Session["clientlogined"].language3?default('')==""><#else>checked</#if>   name="radio_display3" value="YES">
		                                 开通		                  
                </td>
             </tr>
		</table>					 	
	  	
			
</div>
		</td>
	</tr>
</table>
</div>
<@preview_iframe "index.ftl" />

</HTML>
