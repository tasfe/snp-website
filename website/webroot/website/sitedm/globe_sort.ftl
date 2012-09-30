\	<#include "/website/include/head_js_css.ftl">	
<style>
    #play { }
    .drag {
        height: 18px;
        width: 100px;
        border: 1px solid black;
        background-color: #f00;
        padding:5px;
        margin:3px;
        
        color: white;
        cursor: move;
        z-index: 1222;
    }
   .drop {
        height:36px;
        width: 75px;
        display: block; 
        border:1px solid #c3d9ff;
        float: left;  list-style: none;
        background: #fff;
        margin:2px;
        padding: 2px ;
      
        background-color: #F6F7FB;
        z-index: -1;
    }
    #drop p strong {
        font-weight: bold;
    }
    #drop.yui3-dd-drop-over {
        background-color: #FFA928;
    }
</style>
<script type="text/javascript" class="example">
$(document).ready(function()
{
	$('td.lanmu').qtip({
		content: '拖动红色的栏目到 下面蓝色的位置',
		<#include "/website/include/qtip.ftl">
	});
});
</script>
<#include "/website/macro/admin_preview.ftl">
<script>
<#assign LanmuObject=Session["lanmuobject"]/>
<#assign SiteUser=results["DM.Reload.SiteUser.Result"]/>	

function	update_setting(name,value){
    var  action=common_user_reload
                     +'globe_sort.ftl'
                     +"&DM.business.LanmuSetting="
                     +"&DM.Reload.SiteUser.__Depends=DM.business.LanmuSetting"  
                     +"&paraname="+name
                     +"&"+name+"="+value
                     +"&userid=${Session["clientlogined"].id?if_exists}"
    document.getElementById('formlanmuadmin').action=action;
    document.getElementById('formlanmuadmin').submit();	    		
}	
YUI({ filter: 'raw' }).use('dd-drop', 'dd-constrain', function(Y) {
    var data = {
        'drag0': { name:'',value:''},
        'drag1': { name:'${Session["clientlogined"].spmp1Lanmu?if_exists}',  value:'spmp1'},
        'drag2': { name:'${Session["clientlogined"].spmp2Lanmu?if_exists}',  value:'spmp2'},
        'drag3': { name:'${Session["clientlogined"].spmp3Lanmu?if_exists}',  value:'spmp3'},
        'drag4': { name:'${Session["clientlogined"].spmp4Lanmu?if_exists}',  value:'spmp4' },
        'drag5': { name:'${Session["clientlogined"].spmp5Lanmu?if_exists}',  value:'spmp5' },
        'drag6': { name:'${Session["clientlogined"].spmp6Lanmu?if_exists}',  value:'spmp6'},
        'drag7': { name:'${Session["clientlogined"].spmp7Lanmu?if_exists}',  value:'spmp7' },	
        'drag8': { name:'${Session["clientlogined"].spmp8Lanmu?if_exists}',  value:'spmp8'},	                	        
        'drag9': { name:'${Session["clientlogined"].addressLanmu?if_exists}',value:'address'},
        'drag10':{ name:'${Session["clientlogined"].jobLanmu?if_exists}',    value:'job'},
        'drag11':{ name:'${Session["clientlogined"].s1Lanmu?if_exists}',     value:'s1'},
        'drag12':{ name:'${Session["clientlogined"].s2Lanmu?if_exists}',     value:'s1'},
        'drag13':{ name:'${Session["clientlogined"].guestLanmu?if_exists}',     value:'guest'}       
	};	    
    //设置拖动
    var drags = Y.Node.all('#play span.drag');
    drags.each(function(v, k) {
        var thisData = {};
        Y.mix(thisData, data[v.get('id')]);
        var dd = new Y.DD.Drag({
            node: v,
            dragMode: 'intersect',
            data: thisData
        }).plug(Y.Plugin.DDConstrained, {
            constrain2node: '#play'
        });
        dd.on('drag:end', function(e) {
            e.preventDefault();
        });
    });
   
   //设置被拖到的位置
   var drops = Y.Node.all('#play span.drop');
   drops.each(function(v, k) {
       var drop = new Y.DD.Drop({
       node: v
   });
	   
   //拖动事件处理函数
   drop.on('drop:hit', function(e) {
       var drag = e.drag;
       var data = drag.get('data');
   	   var  lanmu_id=this.get('node')._node.id;
   	   var  lanmu_value=data.value;
   	   //alert("栏目位置lanmu_id："+lanmu_id+"  新值："+lanmu_value);
   	   if(lanmu_id.indexOf("lanmudir")>=0){
	       if(lanmu_value=='spmp1'||lanmu_value=='spmp2'||lanmu_value=='spmp3'||lanmu_value=='spmp6'){
	       	   update_setting(lanmu_id,lanmu_value);
	          
	       }else{
	       	   alert("不能拖动到此位置，请拖动到 上面的'横向栏目位置'");
	       	  return;
	       }	   	   
   	   }
       
       update_setting(this.get('node')._node.id,data.value);
       this.get('node').set('innerHTML', data.name);
   });     
   });
});
</script>
<form name="formlanmuadmin" id="formlanmuadmin" method="post"  target="mainFrame"   ></form>
<div class="area-edit" >
	<table width=800px>
		<tr>
			<td>
				<div class="title">栏目位置设置&nbsp;&nbsp;&nbsp;[拖动红色栏目到显示位置]</div>
				<div style="border:1px solid #c3d9ff;background: #fff;padding-left:5px">
				<br>
					<div id="play">
					  <span class="snp-icon ui-icon-document" style="cursor: default "></span><span title="拖拽右边栏目到下面空白位置" style="cursor: default " class="snp-icon ui-icon-circle-arrow-s"></span> 
					    <#if Session["clientlogined"].addressLanmu?default('')!="" ><span id="drag9"  class="drag" >${Session["clientlogined"].addressLanmu?if_exists}</span></#if>
					    <#if Session["clientlogined"].jobLanmu?default('')!="" ><span id="drag10" class="drag" >${Session["clientlogined"].jobLanmu?if_exists}    </span></#if>
					    <#if Session["clientlogined"].s1Lanmu?default('')!="" ><span id="drag11" class="drag" >${Session["clientlogined"].s1Lanmu?if_exists}     </span></#if>
					    <#if Session["clientlogined"].s2Lanmu?default('')!="" ><span id="drag12" class="drag" >${Session["clientlogined"].s2Lanmu?if_exists}     </span></#if>
					    <#if Session["clientlogined"].guestLanmu?default('')!="" ><span id="drag13" class="drag" >${Session["clientlogined"].guestLanmu?if_exists}  </span></#if>
					    <#if Session["clientlogined"].spmp4Lanmu?default('')!="" ><span id="drag4"  class="drag" >${Session["clientlogined"].spmp4Lanmu?if_exists}  </span></#if>
					    <#if Session["clientlogined"].spmp5Lanmu?default('')!="" ><span id="drag5"  class="drag" >${Session["clientlogined"].spmp5Lanmu?if_exists}  </span></#if> 
					    <#if Session["clientlogined"].spmp8Lanmu?default('')!="" ><span id="drag8"  class="drag" >${Session["clientlogined"].spmp8Lanmu?if_exists}  </span></#if>
			     	   
			     	    <#--<span id="drag7" class="drag">${Session["clientlogined"].spmp7Lanmu?if_exists}</span> --> 
					   <br><br><br><span class="snp-icon ui-icon-folder-open" style="cursor: default "></span><span title="拖拽右边栏目到下面空白位置"  class="snp-icon ui-icon-circle-arrow-s" style="cursor: default "></span> 
					    <#if Session["clientlogined"].spmp1Lanmu?default('')!="" ><span id="drag1" class="drag" >${Session["clientlogined"].spmp1Lanmu?if_exists}</span></#if>
					    <#if Session["clientlogined"].spmp2Lanmu?default('')!="" ><span id="drag2" class="drag" >${Session["clientlogined"].spmp2Lanmu?if_exists}</span></#if>
					    <#if Session["clientlogined"].spmp3Lanmu?default('')!="" ><span id="drag3" class="drag" >${Session["clientlogined"].spmp3Lanmu?if_exists}</span></#if>
					    <#if Session["clientlogined"].spmp6Lanmu?default('')!="" ><span id="drag6" class="drag" >${Session["clientlogined"].spmp6Lanmu?if_exists}</span></#if>		
			
			            <br> <br> <br> 
		    		       <span class="snp-icon ui-icon-document" style="cursor: default "></span> 横向位置<br>
		    		       
					    <span  id=lanmu1  class="drop"> <#if LanmuObject.getLanmu1()?default('')!="" > ${SiteUser.getValueByName(LanmuObject.getLanmu1()+"Lanmu")}<br><a href="javascript:update_setting('lanmu1','');">隐藏</a></#if></span>
					    <span  id=lanmu2  class="drop"> <#if LanmuObject.getLanmu2()?default('')!="" > ${SiteUser.getValueByName(LanmuObject.getLanmu2()+"Lanmu")}<br><a href="javascript:update_setting('lanmu2','');">隐藏</a></#if></span>
					    <span  id=lanmu3  class="drop"> <#if LanmuObject.getLanmu3()?default('')!="" > ${SiteUser.getValueByName(LanmuObject.getLanmu3()+"Lanmu")}<br><a href="javascript:update_setting('lanmu3','');">隐藏</a></#if></span>
					    <span  id=lanmu4  class="drop"> <#if LanmuObject.getLanmu4()?default('')!="" > ${SiteUser.getValueByName(LanmuObject.getLanmu4()+"Lanmu")}<br><a href="javascript:update_setting('lanmu4','');">隐藏</a></#if></span>
					    <span  id=lanmu5  class="drop"> <#if LanmuObject.getLanmu5()?default('')!="" > ${SiteUser.getValueByName(LanmuObject.getLanmu5()+"Lanmu")}<br><a href="javascript:update_setting('lanmu5','');">隐藏</a></#if></span>
					    <span  id=lanmu6  class="drop"> <#if LanmuObject.getLanmu6()?default('')!="" > ${SiteUser.getValueByName(LanmuObject.getLanmu6()+"Lanmu")}<br><a href="javascript:update_setting('lanmu6','');">隐藏</a></#if></span>
					    <span  id=lanmu7  class="drop"> <#if LanmuObject.getLanmu7()?default('')!="" > ${SiteUser.getValueByName(LanmuObject.getLanmu7()+"Lanmu")}<br><a href="javascript:update_setting('lanmu7','');">隐藏</a></#if></span>
					    <span  id=lanmu8  class="drop"> <#if LanmuObject.getLanmu8()?default('')!="" > ${SiteUser.getValueByName(LanmuObject.getLanmu8()+"Lanmu")}<br><a href="javascript:update_setting('lanmu8','');">隐藏</a></#if></span>			      		
					    <span  id=lanmu9  class="drop"> <#if LanmuObject.getLanmu9()?default('')!="" > ${SiteUser.getValueByName(LanmuObject.getLanmu9()+"Lanmu")}<br><a href="javascript:update_setting('lanmu9','');">隐藏</a></#if></span>			    		
		    	
		    	         <br>  <br> <br> 
		    	                       竖向位置 <span class="snp-icon ui-icon-folder-open" style="cursor: default "></span>
		    	                       <br>  
			    	    <span id=lanmudir1 class="drop" style="width:90"> <#if LanmuObject.getLanmudir1()?default('')!="" >${SiteUser.getValueByName(LanmuObject.getLanmudir1()+"Lanmu")}<br><a href="javascript:update_setting('lanmudir1','');">隐藏</a></#if></span>
			    	    <span id=lanmudir2 class="drop" style="width:90"> <#if LanmuObject.getLanmudir2()?default('')!="" >${SiteUser.getValueByName(LanmuObject.getLanmudir2()+"Lanmu")}<br><a href="javascript:update_setting('lanmudir2','');">隐藏</a></#if></span>
			    	   	<span id=lanmudir3 class="drop" style="width:90"> <#if LanmuObject.getLanmudir3()?default('')!="" >${SiteUser.getValueByName(LanmuObject.getLanmudir3()+"Lanmu")}<br><a href="javascript:update_setting('lanmudir3','');">隐藏</a></#if></span>
			    	    <span id=lanmudir4 class="drop" style="width:90"> <#if LanmuObject.getLanmudir4()?default('')!="" >${SiteUser.getValueByName(LanmuObject.getLanmudir4()+"Lanmu")}<br><a href="javascript:update_setting('lanmudir4','');">隐藏</a></#if></span>
			  
					</div>
					<br>  <br>  <br>  <br>  
				</div>
			</td>
		</tr>
	</table>
</div>
<@preview_iframe "index.ftl" />
