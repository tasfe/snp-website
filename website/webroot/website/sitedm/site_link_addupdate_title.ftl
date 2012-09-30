<link href="/website/css/content.css" rel="stylesheet" type="text/css">

 
<script type="text/javascript" src="../edit/fckeditor.js"></script>
<#include "/website/macro/commonfun.ftl">
<#include "/website/macro/fckedit.ftl">
<script language="javascript">
        function verifyValue(){	
			return true;
		}		
</script>
<form name="form1" action="siteoperationControl.action" method="post" onsubmit="return verifyValue();" enctype="multipart/form-data">
       <table id=sa-tb-content   cellSpacing="0" cellPadding="0">
       <#if (results?exists && results["DM.Reload.SiteLink.Result"]?exists )>
			<input id=oursite_input class=admin type="hidden" name="DM.Instance.SiteLink.id" value="${results["DM.Reload.SiteLink.Result"].id}">
			
            <tr>
		    <td id=oursite_tb_data>
		    
			    <@fckeditupdate user=results["DM.Reload.SiteLink.Result"].siteUser   
				                vartxt="DM.Instance.SiteLink.title"  
				                title="标题"
				                v1=results["DM.Reload.SiteLink.Result"].title?if_exists
				                v2=results["DM.Reload.SiteLink.Result"].title2?if_exists
				                v3=results["DM.Reload.SiteLink.Result"].title3?if_exists
				/>	
	 	    </td>
		    </tr>			
		   	<input id=oursite_input type="hidden" name="DM.Update.SiteLink" value="">
<#else> 
            <tr>
		    <td id=oursite_tb_data>
		    	<br>
		    	<font color="#CC3300"><br><b>[&nbsp;"${results["DM.Reload.SiteUser.Result"].linkLanmu}"&nbsp;]</b></font>
		    	<hr>
		    </td>
		    </tr>
             <tr>
		    <td id=oursite_tb_data>        			
			<@fckeditadd user=results["DM.Reload.SiteUser.Result"]  
					  vartxt="DM.Instance.SiteLink.title"  
					  title="标题"
			/>			
		    </td>
		    </tr>
          	<input id=oursite_input type="hidden" name="DM.Instance.SiteLink.SiteUser" value="@{SiteUser}">			
			<input id=oursite_input type="hidden" name="DM.Reload.SiteUser.__Depends" value="DM.Create.SiteLink">
            <input id=oursite_input type="hidden" name="DM.Create.SiteLink" value="">	        
</#if>		        
	        <tr>
	        <td id=oursite_tb_data>
			    <input id=oursite_input type="hidden" name="local" value=${tempvar["local"]}>  	  
			    <input id=oursite_input type="hidden" name="language" value=${tempvar["language"]}>  
				<input id=oursite_input type="hidden" name="OT.Token.type" value="apply">
			    <input id=oursite_input type="hidden" name="OT.Token.name" value="link">
                <input id=oursite_input type="hidden" name="OT.Token.value" value="${results["OT.Token.Result"]}">
				<input id=oursite_input type="hidden" name="DM.Object.SiteLink" value="SiteLink">
				<input id=oursite_input type="hidden" name="DM.Reload.SiteUser" value="SiteUser">
				<input id=oursite_input type="hidden" name="DM.Instance.SiteUser.id" value="${results["DM.Reload.SiteUser.Result"].id}">
				<input id=oursite_input type="hidden" name="DM.Object.SiteUser" value="SiteUser">
				<input id=oursite_input type="hidden" name="OT.Forward.success.Type" value="freemarker">
				<input id=oursite_input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/site_link_admin.ftl">
				<p align=center>
					
		           <input  id=oursite_input type="submit"  value="确定"> 
	           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	           <input  id=oursite_input type="button"  value="返回" onclick="javascript:history.go(-1);">
					
					
				</p>  
			</td>
	        </tr>
	</table>
</form>



