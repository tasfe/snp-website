<link href="/website/css/content.css" rel="stylesheet" type="text/css">

 
<#include "/website/macro/commonfun.ftl">
<@tt width="550"/>
<div class=title>${results["DM.Reload.SiteUser.Result"].guestLanmu}</div>
<div class=content>
	<form name="form1" action="siteoperationControl.action" method="post" >
		<table width=500  >				

			<tr>
				<td wdith=30>回复</td>
				<td>
					<textarea class="input-blur" cols="60" rows="6"  name="DM.Instance.SiteGuest.reply">${results["DM.Reload.SiteGuest.Result"].reply?if_exists}</textarea>
				</td>
			</tr>
		</table>
		<br><br>
		<table width=500  >				 
			<tr>
			    <td >姓名</td>
				<td>
					<input   class=input  type="text" size="50" value="${results["DM.Reload.SiteGuest.Result"].name?if_exists}"  name="DM.Instance.SiteGuest.name">
				</td>
			</tr>				


			

			<tr>
			    <td>客户留言</td>
				<td>
					<textarea class="input-blur" cols="70" rows="3"  name="DM.Instance.SiteGuest.leaveword">${results["DM.Reload.SiteGuest.Result"].leaveword?if_exists}</textarea>
				</td>
			</tr>				
			      

    	
</table>

    <p align=center>
	   <input  class=bt type="submit" value="确定"> 
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <input  class=bt type="button"  value="返回" onclick="javascript:history.go(-1);">

    </p>
</div>
<@bb/>
  	  
 		
<input type="hidden" name="DM.Object.SiteGuest" value="SiteGuest">
<input type="hidden" name="DM.Reload.SiteUser" value="SiteUser">
<input type="hidden" name="DM.Instance.SiteGuest.id" value="${results["DM.Reload.SiteGuest.Result"].id}">
<input type="hidden" name="DM.Update.SiteGuest" value="">					
<input type="hidden" name="DM.Instance.SiteUser.id" value="${results["DM.Reload.SiteUser.Result"].id}">
<input type="hidden" name="DM.Object.SiteUser" value="SiteUser">
<input type="hidden" name="OT.Forward.success.Type" value="freemarker">
<input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/site_guest_admin.ftl">

</form>

		
		
		
	

