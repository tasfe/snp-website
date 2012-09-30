<link href="/website/css/content.css" rel="stylesheet" type="text/css">
<#include "/website/macro/commonfun.ftl">

<div class="area-edit">
	<table width=500px>
		<tr>
			<td>
				<div  class="title">导入</div>
				<div class="content">
					<form name="form_upload" action="siteoperationControl.action" method="post" enctype="multipart/form-data"><br>
						上传网页数据包:<input class=input type="file" name="fileLocation" value="">
						<input  class=bt type="submit" value="确定">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<br><br>
					
						<input type="hidden" name="DM.Instance.upld.op" value="allsite"/>	
						<input type="hidden" name="DM.Object.upld" value="uploadSiteData"/>
						<input type="hidden" name="DM.Instance.upld.uploadFileName" value="fileLocation"/>
						<input type="hidden" name="DM.Instance.upld.timeprefix" value="no"/>
						<input type="hidden" name="DM.Instance.upld.subdir" value="/${Session["clientlogined"].username}/"/>
						<input type="hidden" name="DM.Instance.upld.docroot" value="path_userhome"/>
						<input type="hidden" name="DM.Upload.upld" value=""/>
						<input type="hidden" name="DM.Reload.SiteUser" value=""/>
						<input type="hidden" name="DM.Object.SiteUser" value="SiteUser"/>
						<input type="hidden" name="DM.Instance.SiteUser.id" value="${Session["clientlogined"].id?if_exists}"/>
						<input type="hidden" name="OT.Forward.success.URL" value="/website/sitedm/globe_userdataimport.ftl"/>
						<input type="hidden" name="OT.Forward.success.Type" value="freemarker"/>
						<input type="hidden" name="local" value="${Session["clientlogined"].local?if_exists}"/>
						<input type="hidden" name="language" value="${Session["clientlogined"].language?if_exists}"/>
						
				 	</form>	
				</div>
               	<br>
				<div  class="title">清除数据（一次性删除现有数据）</div>
				<div class="content">
				    <a id=oursite_a href="javascript:del();">清空数据</a>
				</div>
				
			</td>
		</tr>
	</table>	
</div>
<script language="javascript">
	function del(){
	    if (confirm("确定要清除数据吗,本操作将删除所有已发布的数据，建议'导出数据'备份后，再进行清空操作！")){ 			
			document.location="cleansite.ftl;";
		}
	}
</script>