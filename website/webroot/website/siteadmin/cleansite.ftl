<#include "/website/macro/commonfun.ftl">
<link href="/website/css/content.css" rel="stylesheet" type="text/css">

<body  style="background:black;padding:50;">
<div  style="font-size:16pt;color:#f4f4f4;align=center" id="info_tip">
				正在清除数据，请稍候...........
</div>

<div style="position:absolute;padding:50;width:322;height:14;border:1 #707888 solid;overflow:hidden">
	<div style="position:absolute;top:-1;left:0" id="pimg">
	</div>
</div>


<script>
	s=new Array();
	s[0]="#050626";
	s[1]="#0a0b44";
	s[2]="#0f1165";
	s[3]="#1a1d95";
	s[4]="#1c1fa7";
	s[5]="#1c20c8";
	s[6]="#060cff";
	s[7]="#2963f8";
	function ls(){
			document.getElementById('pimg').innerHTML="";
			for(i=0;i<9;i++){
			document.getElementById('pimg').innerHTML+="<input style=\"width:15;height:10;border:0;background:"+s[i]+";margin:1\">";
			}
		}
	function rs(){
			document.getElementById('pimg').innerHTML="";
			for(i=9;i>-1;i--){
			document.getElementById('pimg').innerHTML+="<input style=\"width:15;height:10;border:0;background:"+s[i]+";margin:1\">";
			}
		}
	ls();
	var g=0;sped=0;
	function str(){
		if(document.getElementById('pimg').style.pixelLeft<350&&g==0){
		if(sped==0){
			ls();
			sped=1;
			}
		document.getElementById('pimg').style.pixelLeft+=2;
		setTimeout("str()",1);
		return;
		}
		g=1;
		if(document.getElementById('pimg').style.pixelLeft>-200&&g==1){
		if(sped==1){
			rs();
			sped=0;
			}
		document.getElementById('pimg').style.pixelLeft-=2;
		setTimeout("str()",1);
		return;
		}
		g=0;
		str();
	}
	function flashs(){
		if(document.getElementById('info_tip').style.color=="#ffffff"){
			document.getElementById('info_tip').style.color="#707888";
			setTimeout('flashs()',500);
			}
		else{
			document.getElementById('info_tip').style.color="#ffffff";
			setTimeout('flashs()',500);
			}
	}
	flashs();
	str();
</script>
<form name="formadmin" 
	action="siteadmin!cleanSite.action?siteuserid=${Session["clientlogined"].id}" method="post" target="_self" >
</form>
<script>
 	function run(){
 		formadmin.submit();
 	}
	run();
</script>
</body>
</html>


