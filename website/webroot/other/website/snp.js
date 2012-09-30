	function check_email(value)
	{
	    var result = false;
	    var str = value;
	    if(str.indexOf('@')>0)
	    {
	        var a1 = str.split('@')[0];
	        var a2 = str.split('@')[1];
	        if(isW(a1) && a2.indexOf('.')>0)
	        {
	            if(isW(a2.split('.')[0]) && isW(a2.split('.')[1]))
	                result = true;
	        }
	    }
	    return result;
	}
	function isW(str)
	{   
	    if(str.length==0)
	        return false;
	    for(var i=0; i<str.length; i++)
	    {
	        var tmp = str.substring(i,i+1);
	        if(!(tmp>='a'&&tmp<='z') && !(tmp>='A'&&tmp<='Z') && !(tmp>='0'&&tmp<='9') && tmp!='_')
	            return false; 
	    }
	    return true;
	}


   function showHiddenNode(imgElem,ptrId){
	  //  var ptr = document.all(ptrId);
	    var ptr = document.getElementById(ptrId);
	    if(ptr.trStatus=="open"){ 
	       imgElem.src = "../../other/dir/plus.gif";   
	       var trs = jQuery("tr[pid=" + ptrId + "]");   
	       trs.css("display", "none");   
	       ptr.trStatus="close";
	       for(var i=0;i<trs.length;i++){   
	           hiddenSub(trs[i].id);   
	       }
	    }
	    else{ 
	       imgElem.src = "../../other/dir/minus.gif";   
	       var trs = jQuery("tr[pid=" + ptrId + "]");   
	       trs.css("display", "");   
	       ptr.trStatus="open";
	       for(var i=0;i<trs.length;i++){   
	           showSub(trs[i].id);   
	       }   
	    }     
   }

  
  function hiddenSub(ptrId){   
   var ptr = document.all(ptrId);
      //if(ptr == null) return;   
         var trs = jQuery("tr[pid=" + ptrId + "]");   
         trs.css("display", "none");   
         for(var i=0;i<trs.length;i++){   
             hiddenSub(trs[i].id);   
         }   
  }  
  function showSub(ptrId){   
   var ptr = document.all(ptrId);
      if(ptr.trStatus=="open"){
          var trs = jQuery("tr[pid=" + ptrId + "]");   
          trs.css("display", "");   
          for(var i=0;i<trs.length;i++){   
              showSub(trs[i].id);   
          }   
      }   
  } 
    function  set_show(){
       if(document.getElementById('div_hide').style.display=='none')
		    document.getElementById('div_hide').style.display='';
		else
		   document.getElementById('div_hide').style.display='none';
   } 
  
   function get_null(){
     document.getElementById('div_hide').style.display='none';
	}


   function get_guest_all(userid,local){
     $.ajax({
			  url: "site!siteguestall.action?"+'userid='+userid+'&local='+local,
			  cache: false,
			  success: function(html){
			    $("#div_hide").replaceWith(html);
			  }
			}); 
	}  
    
    
    function ajax_leaveword(userid){
     $.ajax({
             type:"POST",
             url: "site!guestLeaveword.action",
			 data:"guest_email="+document.getElementById('guest_email').value+"&guest_leaveword="+document.getElementById('guest_leaveword').value+"&userid="+userid,
			 cache: false,
			 success: function(html){
			    $("#div_email_result").replaceWith(html);
			  }
			});   
	 document.getElementById('div_email').style.display='none';			
    }
    
    function guest_leaveword(userid){
       ajax_leaveword(userid);
	   document.getElementById('div_email').style.display='none';		
	}   	


 
	
	
	