<#include "/website/include/head_js_css.ftl">

<#assign SiteUser=results["DM.Reload.SiteSpmp4Item.Result"].getSiteSpmp4().getSiteUser() />
<#assign LanmuObject=Session["lanmuobject"]/>	  


<script language="javascript">

    var  ftlpath="/website/sitedm/";
	var  common="siteoperationControl.action?OT.Forward.success.Type=freemarker&spmp4id=${tempvar["spmp4id"]}";
    var  parent_reload="&DM.Reload.SiteSpmp4=&DM.Object.SiteSpmp4=SiteSpmp4&DM.Instance.SiteSpmp4.id=";
    var  token="&OT.Token.name=about&OT.Token.type=get"
    var  spmp4item_reload="&DM.Reload.SiteSpmp4Item=&DM.Object.SiteSpmp4Item=SiteSpmp4Item&DM.Instance.SiteSpmp4Item.id=";
    var  parent_reload="&DM.Reload.SiteSpmp4=SiteSpmp4&DM.Object.SiteSpmp4=SiteSpmp4&DM.Instance.SiteSpmp4.id=";
	var  common_updata_para=common
		                        +"&OT.Forward.success.URL="
		                        +ftlpath
		                        +"site_spmp4item_product_admin.ftl"
		                        +"&DM.Object.SiteProduct=SiteProduct"
		                        +"&DM.Update.SiteProduct="
		                        +spmp4item_reload+${results["DM.Reload.SiteSpmp4Item.Result"].id}
		                        ;  
     
   
	   function lookup(ids){
			document.getElementById('formlanmuadmin').action  =parent_action  +"&DM.Instance.SiteSpmp4.id=" + ids ;
			document.getElementById('formlanmuadmin').submit();
			return true;
		}
     
	   function lookupparentspmp4(ids){
			document.getElementById('formlanmuadmin').action  =common+
			                  parent_reload
			                  + ids 
			                  +"&DM.Reload.SiteUser=&DM.Object.SiteUser=SiteUser"
				              +"&DM.Instance.SiteUser.id=${Session["clientlogined"].id?if_exists}"
			                  +"&OT.Forward.success.URL="+ftlpath+"site_spmp4_detail.ftl";		
			
			document.getElementById('formlanmuadmin').submit();
			return true;
		}

     /*添加产品描述*/
	function add_SiteProduct(id_spmp4item){
   	    var  add_SiteProduct_Action=common+spmp4item_reload+id_spmp4item
                                         +"&OT.Forward.success.URL="
                                         +ftlpath
                                         +"site_spmp4item_product_addupdate.ftl"
                                         +token;
        document.getElementById('formlanmuadmin').action=add_SiteProduct_Action;
       
        document.getElementById('formlanmuadmin').submit();
	}
 

     /*修改产品描述*/
      function modify_SiteProduct(id_parent,id_child){
            
            	var  modifychild_SiteProduct_Action=common+spmp4item_reload+id_parent
	                                         +"&OT.Forward.success.URL="
	                                         +ftlpath
	                                         +"site_spmp4item_product_addupdate.ftl"  
	                                         +"&DM.Reload.SiteProduct="
	                                         +"&DM.Instance.SiteProduct.id="+id_child
			                                 +"&DM.Object.SiteProduct=SiteProduct"
			                                  +token
	                                        ;	  
         		document.getElementById('formlanmuadmin').action =modifychild_SiteProduct_Action;
				document.getElementById('formlanmuadmin').submit();
		
	  }	  
	  
	  function update_width(id,width){
	  var  update_rank_Action=common_updata_para +"&DM.Instance.SiteProduct.id="+id
		                                         +"&DM.Instance.SiteProduct.width="+width;
	       document.getElementById('formlanmuadmin').action=update_rank_Action;
		   document.getElementById('formlanmuadmin').submit();	    	          
		   	  
	    }	 
	  function update_height(id,height){
	  var  update_rank_Action=common_updata_para +"&DM.Instance.SiteProduct.id="+id
		                                         +"&DM.Instance.SiteProduct.height="+height;
	       document.getElementById('formlanmuadmin').action=update_rank_Action;
		   document.getElementById('formlanmuadmin').submit();	    	          
		   	  
	    }
	  function update_imagealign(id,imagealign){
	  var  update_rank_Action=common_updata_para +"&DM.Instance.SiteProduct.id="+id
		                                         +"&DM.Instance.SiteProduct.imagealign="+imagealign;
	       document.getElementById('formlanmuadmin').action=update_rank_Action;
		   document.getElementById('formlanmuadmin').submit();	    	          		   	  
	    }	    


	
	  function update_rank(id,rank){
	      var  update_rank_Action=common_updata_para
	                               +"&DM.Instance.SiteProduct.id="+id
		                           +"&DM.Instance.SiteProduct.sortstr="+rank;
	      document.getElementById('formlanmuadmin').action=update_rank_Action;
	      document.getElementById('formlanmuadmin').submit();	    	          
	  }		
	
		function change_rank(id_from,id_to ){
		 	  var  action=common
		                        +"&OT.Forward.success.URL="
		                        +ftlpath
		                        +"site_spmp4item_product_admin.ftl"
		                  +spmp4item_reload+${results["DM.Reload.SiteSpmp4Item.Result"].id}
	                      +"&DM.Reload.SiteUser.__Depends=DM.business.ChangeRank"  
	                      +"&DM.business.ChangeRank="
	                      +"&id_from="+id_from
	                      +"&id_to="+id_to
	                      +"&beanname=SiteProduct"
	                      ;
	               document.getElementById('formlanmuadmin').action=action;
				   document.getElementById('formlanmuadmin').submit();	    	          
		}	  
		
			function insert(id_parent,id_child,page){
		   	  var  Action=common+spmp4item_reload+id_parent
		                                         +"&OT.Forward.success.URL="
		                                         +ftlpath
		                                         +page
		                                         +"&DM.Reload.SiteProduct="
		                                         +"&DM.Instance.SiteProduct.id="+id_child
		                                         +"&DM.Object.SiteProduct=SiteProduct"
		                                         ;
		       document.getElementById('formlanmuadmin').action=Action;
		        document.getElementById('formlanmuadmin').submit();	
   	}   	
	     /*删除产品描述*/
      function delete_X(id_parent,id_child){
            if (confirm('确定要删除吗？')){ 
            	var  deletechild_SiteProduct_Action=common+spmp4item_reload+id_parent
	                                         +"&OT.Forward.success.URL="
	                                         +ftlpath
	                                         +"site_spmp4item_product_admin.ftl"  
	                                         +"&DM.Delete.SiteProduct="
	                                         +"&DM.Instance.SiteProduct.id="+id_child
			                                 +"&DM.Object.SiteProduct=SiteProduct"
			                                 +"&DM.Reload.SiteSpmp4Item.__Depends=DM.Delete.SiteProduct"  
	                                        ;	  
         		document.getElementById('formlanmuadmin').action =deletechild_SiteProduct_Action;
				document.getElementById('formlanmuadmin').submit();
			}else{} 
	  }	  
		function set_value(id,fieldname,value){
		  var  action=common_updata_para
	                               +"&DM.Instance.SiteProduct.id="+id
		                           +"&DM.Instance.SiteProduct."+fieldname+"="+value

		    document.getElementById('formlanmuadmin').action=action;
			document.getElementById('formlanmuadmin').submit();	    	          		   	  
		}		  
		
		
     /*添加产品描述*/
	function add_new(id_spmp4item){
   	    var  add_SiteProduct_Action=common+spmp4item_reload+id_spmp4item
                                         +"&OT.Forward.success.URL="
                                         +ftlpath
                                         +"site_spmp4item_product_admin.ftl"
                                          +"&DM.Instance.SiteProduct.detail="+document.getElementById('realse_new').value
                                
                                         +"&DM.Object.SiteProduct=SiteProduct&DM.Instance.SiteProduct.SiteSpmp4Item=@{SiteSpmp4Item}&DM.Create.SiteProduct=&DM.Reload.SiteSpmp4Item.__Depends=DM.Create.SiteProduct"

        document.getElementById('formlanmuadmin').action=add_SiteProduct_Action;
       
        document.getElementById('formlanmuadmin').submit();
	}		
  	      					
</script>	

<form name="formlanmuadmin" id="formlanmuadmin" method="post"  target="mainFrame"></form>

<div class="area-edit">
<table width=700>
<tr>
<td>

	<div  class="title"><span class=bold>  ${results["DM.Reload.SiteSpmp4Item.Result"].title}</span></div>
	<div class="content">
     <br>
		<table>
		    <tr>
				<td valign=bottom >
				    <span class=info>对该图片进行详细描述</span><br>
			    	<TEXTAREA  rows=4 cols=70 id=realse_new class="input-blur"   onfocus="this.className='input-focus'"></textarea>		
			    </td>
	    	    <td valign=bottom >
	    	    	&nbsp;&nbsp;<a  class="bt"  href="#" onclick="javascript:add_new(${results["DM.Reload.SiteSpmp4Item.Result"].id})">确定</a>	
	    	    	
	    	    	<a  class="bt"  href="#" onclick="javascript:lookupparentspmp4(${tempvar["spmp4id"]});">返回</a>	
	    	      		
				 </td>					
			 </tr>
		 </table>

		<br>				

		<table id=area-data class="area-data"  cellSpacing="1"  style="width:600px" >
					
							
				<#assign listx = []>
				<#list results["DM.Reload.SiteSpmp4Item.Result"].siteProducts as P0>
					<#assign listx = listx + [P0]>
				</#list>	   		 
				<#list listx as x>
		         	    <td class=td-data>
			        	${x.detail?if_exists}
			        	</td>
		 				
						<td class=td-op style="width:130px">
						  			
					 	 
			                <a class=bt  href="javascript:modify_SiteProduct(${results["DM.Reload.SiteSpmp4Item.Result"].id},${x.id},'true');" >编辑</a>
							 <a class=bt href="javascript:delete_X(${results["DM.Reload.SiteSpmp4Item.Result"].id},${x.id});"  >删除</a> 
			                 <br><br>
							<a href="javascript:insert(${results["DM.Reload.SiteSpmp4Item.Result"].id},${x.id},'site_spmp4item_product_uploadfile.ftl');"><span  class="snp-icon ui-icon-image"></span></a> 
					        <a href="javascript:insert(${results["DM.Reload.SiteSpmp4Item.Result"].id},${x.id},'site_spmp4item_product_uploadvideo.ftl');"><span  class="snp-icon ui-icon-video"></span></a> 
					 		<#include "/website/include/rank.ftl">	    
			                <#include "/website/include/insert.ftl">	
			                 
			                 
			                 
		                </td> 
		               
					 </tr>
			     </#list>
			     
		
		</table>	
     <p align=center></p>

     </div>


</td>
</tr>
</table>
</div>



<#---
	<hr>
	<span id=sa-title>预览区域</span>
	<br>

	<@SiteSingleData classes=results["DM.Reload.SiteSpmp4Item.Result"].siteProducts/>
-->