var CustomerCard = function(){  
      
    this.init = function(){  
         // 用于导出excel  
        $("#deviceExport").click(function() {  
            var url =  '/CustomerCard/sys/customerCardList';  
            location.href = url;  
        });  
    };  
      
    //获取查询条件  
    this.acquireInquireData = function(){  
        var inquireCondition = {  
                name:$('#name').val(),
                tele: $('#tele').val(),  
                qq: $('#qq').val(), 
                email: $('#email').val(), 
        };  
        return inquireCondition;  
    };  
}  
      
var customerCard;  
$(function(){  
	customerCard = new CustomerCard();  
	customerCard.init();  
}); 





	
