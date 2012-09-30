<table border="0"  width="500" >
		<tr>
			
			<td >
					&nbsp;&nbsp;&nbsp;Sorry!System error, please send the error information to snp!
					We will do with it!
					<a href="http://www.snpsoft.net/">SnpSoft Office Site</a>
					 <a id=oursite_a href="javascript:history.go(-1);">Return Back</a>
	
			</td>
		</tr>
		<tr>
		<td colspan=2 >
			<p><b>Error Information :</b><br>
				<#if systemErrors?exists>  
				  <#list systemErrors as error>  
				   ${error.toString()}
				  </#list>
				</#if>
			</p>		
		</td>
		</tr>
	</tr>
</table>