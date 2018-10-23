 /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   start appfeeds/nifty <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/  
  $.ajax({
        	type:'Get',
        	url: 'zerodha',
        	success: function(result){
            $("#zerodha").html(result);
        	
        }
        })
      
 /*))))))))))))))))))))))))))))))))   END appfeeds/banknifty ((((((((((((((((((((((((((((((((((((*/  
      

      
    