<link href="/website/css/content.css" rel="stylesheet" type="text/css">
<#include "/website/macro/commonfun.ftl">
<script language="javaScript" src="/other/jquery151/jquery-1.5.1.min.js"></script>
<script language="javascript">
    function ajax_search(){
	    $.ajax({
            type:"POST",
            url: "siteadmin!ajax_search.action",
			data:"searchTitle="+document.getElementById('searchTitle').value+"&searchKeys="+document.getElementById('searchKeys').value+"&searchDesc="+document.getElementById('searchDesc').value,
			cache: false,
			success: function(html){
			document.getElementById('div_result_search').innerHTML=html;
			setTimeout( "document.getElementById('div_result_search').innerHTML=''", 2000);}
		});   
    }   
</SCRIPT>


<@tt  width="700"/> 
    <div class="title" ><span class=info-big>设置网页搜索引擎收集的关键字</span></div>
 	<div class="content" >
		<table >
		   <tr>
		   	   <td>
				   请输入网页[title]内容<input size="120"  type="text" class=input id="searchTitle" value="${Session["clientlogined"].searchTitle?if_exists}">
				   <br><br>
				   请输入网页[keys]内容<input size="120"   type="text" class=input id="searchKeys" value="${Session["clientlogined"].searchKeys?if_exists}">
			       <br><br>
			           请输入网页[description]内容<input  size="120"  type="text" class=input id="searchDesc" value="${Session["clientlogined"].searchDesc?if_exists}">
			       	
			       <br>
			       <p align=center>
			       <input class=bt type="submit" onclick="javascript:ajax_search()" value="确定"  >
			       <div id=div_result_search style="color:#f00"></div>
			       </p>
	 			     
				</td>
			</tr>
		</table>           
    </div>
<@bb/> 
