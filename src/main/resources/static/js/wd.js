 /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   start appfeeds/nifty <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/  
  $.ajax({
  	type:'Get',
  	url: 'appfeeds/nifty',
  	success: function(result){
  		//console.log(result);
  		var json = JSON.parse(result);
		var prevclose=json.indices.prevclose;
		prevclose=prevclose.replace(/,/g , "");
		
		var lastprice=json.indices.lastprice;
		var open=json.indices.open;
		var low=json.indices.low;
		var high=json.indices.high;
		var percentchange=json.indices.change;
		
		var yearlyhigh=json.indices.yearlyhigh;
		var yearlylow=json.indices.yearlylow;
		
		var direction=json.indices.direction;
		
	
		if(direction==1){
			var trend="Day-Positive";
			text0="<span class='blinking1' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + trend + "</span>" +
			"<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
			lastprice="<span class='blinking1' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + lastprice + "</span>" +
			 "<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
			
			text2="<span style='color: #00c853; font-weight: bold; font-size: 14px;'>+" + percentchange + "</span>";
		}
		else{
			var trend="Day-Negative";
			text0="<span class='blinking1' style='color: #ff4444; font-weight: bold; font-size: 14px;'>" + trend + "</span>" + 
			"<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
			
			var lastprice=text="<span class='blinking1' style='color: #ff4444; font-weight: bold; font-size: 14px;'>" + lastprice + "</span>" + 
			"<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
			text2="<span style='color: #CC0000; font-weight: bold; font-size: 14px;'>" + percentchange + "</span>";
		}
		
		//console.log(prevclose);
    		var ltp = prevclose;
            var squareRoot = Math.floor(Math.sqrt(ltp));
            var startNumber = 1;
            if (squareRoot > 1) {
                startNumber = squareRoot - 1
            }
            
            var sup1Factor = (Math.floor(Math.sqrt(ltp) * 1000) - Math.floor(Math.sqrt(ltp) * 1000) % 125) / 1000;
            var sup1 = (Math.floor(Math.pow(sup1Factor - 0.125, 2) * 100) / 100);
            var sup2 = (Math.floor(Math.pow(sup1Factor - 0.25, 2) * 100) / 100);
            var sup3 = (Math.floor(Math.pow(sup1Factor - 0.375, 2) * 100) / 100);
            var sup4 = (Math.floor(Math.pow(sup1Factor - 0.5, 2) * 100) / 100);
            var sup5 = (Math.floor(Math.pow(sup1Factor - 0.625, 2) * 100) / 100);
            var res1 = (Math.floor(Math.pow(sup1Factor + 0.25, 2) * 100) / 100);
            var res2 = (Math.floor(Math.pow(sup1Factor + 0.375, 2) * 100) / 100);
            var res3 = (Math.floor(Math.pow(sup1Factor + 0.5, 2) * 100) / 100);
            var res4 = (Math.floor(Math.pow(sup1Factor + 0.625, 2) * 100) / 100);
            var res5 = (Math.floor(Math.pow(sup1Factor + 0.75, 2) * 100) / 100);
            var buyAt = (Math.floor(Math.pow(sup1Factor + 0.125, 2) * 100) / 100);
            var buyStoploss = (Math.floor(Math.pow(sup1Factor, 2) * 100) / 100);
            var sellAt = (Math.floor(Math.pow(sup1Factor, 2) * 100) / 100);
            var sellStoploss = (Math.floor(Math.pow(sup1Factor + 0.125, 2) * 100) / 100);
            var buy = (Math.floor(Math.pow(sup1Factor + 0.25, 2) * 99.95) / 100 + " <span class='glyphicon glyphicon-arrow-right' style='font-size: 14px; color: green;'></span> " + Math.floor(Math.pow(sup1Factor + 0.375, 2) * 99.95) / 100 + " <span class='glyphicon glyphicon-arrow-right' style='font-size: 14px; color: green;'></span> " + Math.floor(Math.pow(sup1Factor + 0.5, 2) * 99.95) / 100 + " <span class='glyphicon glyphicon-arrow-right' style='font-size: 14px; color: green;'></span> " + Math.floor(Math.pow(sup1Factor + 0.625, 2) * 99.95) / 100);
            var sell = (Math.floor(Math.pow(sup1Factor - 0.125, 2) * 100.05) / 100 + " <span class='glyphicon glyphicon-arrow-right' style='font-size: 14px; color: red;'></span> " + Math.floor(Math.pow(sup1Factor - 0.25, 2) * 100.05) / 100 + " <span class='glyphicon glyphicon-arrow-right' style='font-size: 14px; color: red;'></span> " + Math.floor(Math.pow(sup1Factor - 0.375, 2) * 100.05) / 100 + " <span class='glyphicon glyphicon-arrow-right' style='font-size: 14px; color: red;'></span> " + Math.floor(Math.pow(sup1Factor - 0.5, 2) * 100.05) / 100);
            
            var extendedBuy =  (Math.floor(Math.pow(sup1Factor + 0.75, 2) * 99.95) / 100 + " <span class='glyphicon glyphicon-arrow-right' style='font-size: 14px; color: green;'></span> " + Math.floor(Math.pow(sup1Factor + 0.875, 2) * 99.95) / 100);
  			var extendedSell = (Math.floor(Math.pow(sup1Factor - 0.625, 2) * 100.05) / 100 + " <span class='glyphicon glyphicon-arrow-right' style='font-size: 14px; color: red;'></span> " + Math.floor(Math.pow(sup1Factor - 0.75, 2) * 100.05) / 100);
           
	    
	 
	    
            $("#sup1").html(sup1);
            $("#sup2").html(sup2);
            $("#sup3").html(sup3);
            $("#sup4").html(sup4);
            $("#sup5").html(sup5);
            
            $("#res1").html(res1);
            $("#res2").html(res2);
            $("#res3").html(res3);
            $("#res4").html(res4);
            $("#res5").html(res5);
            
            $("#buyAt").html(buyAt);
            $("#buy").html(buy);
            $("#buyStoploss").html(buyStoploss);
            
            $("#extendedBuy").html(extendedBuy);
            $("#extendedSell").html(extendedSell);
            
            $("#sellAt").html(sellAt);
            $("#sell").html(sell);
            $("#sellStoploss").html(sellStoploss);
            
            
            $("#Nopen").html(open);
            $("#Nhigh").html(high);
            $("#Nlow").html(low);
            $("#Nlastprice").html(lastprice);
            $("#Npercentchange").html(text2);
            
            $("#Nyearlyhigh").html(yearlyhigh);
            $("#Nyearlylow").html(yearlylow);
            $("#NTrend").html(text0);
            
            
  	 }
  })	
    

 /*))))))))))))))))))))))))))))))))   END appfeeds/nifty ((((((((((((((((((((((((((((((((((((*/  
    
    
    

 /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  start appfeeds/banknifty <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/      
    $.ajax({
    	type:'Get',
    	url: 'appfeeds/banknifty',
    	success: function(result){
      		var json = JSON.parse(result);
    		var prevclose=json.indices.prevclose;
    		prevclose=prevclose.replace(/,/g , "");

    		var lastprice=json.indices.lastprice;
    		var open=json.indices.open;
    		var low=json.indices.low;
    		var high=json.indices.high;
    		var percentchange=json.indices.change;
    		
    		var yearlyhigh=json.indices.yearlyhigh;
    		var yearlylow=json.indices.yearlylow;
    		var direction=json.indices.direction;
    		
    		if(direction==1){
    			var trend="Day-Positive";
    			text0="<span class='blinking1' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + trend + "</span>" +
    			"<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
    			lastprice="<span class='blinking1' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + lastprice + "</span>" +
   			 	"<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
    			text2="<span style='color: #00c853; font-weight: bold; font-size: 14px;'>+" + percentchange + "</span>";
    		}
    		else{
    			var trend="Day-Negative";
    			text0="<span class='blinking1' style='color: #ff4444; font-weight: bold; font-size: 14px;'>" + trend + "</span>" + 
				"<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
    			var lastprice=text="<span class='blinking1' style='color: #ff4444; font-weight: bold; font-size: 14px;'>" + lastprice + "</span>" + 
    			"<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
    			text2="<span style='color: #CC0000; font-weight: bold; font-size: 14px;'>" + percentchange + "</span>";
    		}
    		
    		var ltp = prevclose;
              var squareRoot = Math.floor(Math.sqrt(ltp));
              var startNumber = 1;
              if (squareRoot > 1) {
                  startNumber = squareRoot - 1
              }
              
              var sup1Factor = (Math.floor(Math.sqrt(ltp) * 1000) - Math.floor(Math.sqrt(ltp) * 1000) % 125) / 1000;
              var sup1 = (Math.floor(Math.pow(sup1Factor - 0.125, 2) * 100) / 100);
              var sup2 = (Math.floor(Math.pow(sup1Factor - 0.25, 2) * 100) / 100);
              var sup3 = (Math.floor(Math.pow(sup1Factor - 0.375, 2) * 100) / 100);
              var sup4 = (Math.floor(Math.pow(sup1Factor - 0.5, 2) * 100) / 100);
              var sup5 = (Math.floor(Math.pow(sup1Factor - 0.625, 2) * 100) / 100);
              var res1 = (Math.floor(Math.pow(sup1Factor + 0.25, 2) * 100) / 100);
              var res2 = (Math.floor(Math.pow(sup1Factor + 0.375, 2) * 100) / 100);
              var res3 = (Math.floor(Math.pow(sup1Factor + 0.5, 2) * 100) / 100);
              var res4 = (Math.floor(Math.pow(sup1Factor + 0.625, 2) * 100) / 100);
              var res5 = (Math.floor(Math.pow(sup1Factor + 0.75, 2) * 100) / 100);
              var buyAt = (Math.floor(Math.pow(sup1Factor + 0.125, 2) * 100) / 100);
              var buyStoploss = (Math.floor(Math.pow(sup1Factor, 2) * 100) / 100);
              var sellAt = (Math.floor(Math.pow(sup1Factor, 2) * 100) / 100);
              var sellStoploss = (Math.floor(Math.pow(sup1Factor + 0.125, 2) * 100) / 100);
              var buy = (Math.floor(Math.pow(sup1Factor + 0.25, 2) * 99.95) / 100 + " <span class='glyphicon glyphicon-arrow-right' style='font-size: 14px; color: green;'></span> " + Math.floor(Math.pow(sup1Factor + 0.375, 2) * 99.95) / 100 + " <span class='glyphicon glyphicon-arrow-right' style='font-size: 14px; color: green;'></span> " + Math.floor(Math.pow(sup1Factor + 0.5, 2) * 99.95) / 100 + " <span class='glyphicon glyphicon-arrow-right' style='font-size: 14px; color: green;'></span> " + Math.floor(Math.pow(sup1Factor + 0.625, 2) * 99.95) / 100);
              var sell = (Math.floor(Math.pow(sup1Factor - 0.125, 2) * 100.05) / 100 + " <span class='glyphicon glyphicon-arrow-right' style='font-size: 14px; color: red;'></span> " + Math.floor(Math.pow(sup1Factor - 0.25, 2) * 100.05) / 100 + " <span class='glyphicon glyphicon-arrow-right' style='font-size: 14px; color: red;'></span> " + Math.floor(Math.pow(sup1Factor - 0.375, 2) * 100.05) / 100 + " <span class='glyphicon glyphicon-arrow-right' style='font-size: 14px; color: red;'></span> " + Math.floor(Math.pow(sup1Factor - 0.5, 2) * 100.05) / 100);
             
              var extendedBuy =  (Math.floor(Math.pow(sup1Factor + 0.75, 2) * 99.95) / 100 + " <span class='glyphicon glyphicon-arrow-right' style='font-size: 14px; color: green;'></span> " + Math.floor(Math.pow(sup1Factor + 0.875, 2) * 99.95) / 100);
    		  var extendedSell = (Math.floor(Math.pow(sup1Factor - 0.625, 2) * 100.05) / 100 + " <span class='glyphicon glyphicon-arrow-right' style='font-size: 14px; color: red;'></span> " + Math.floor(Math.pow(sup1Factor - 0.75, 2) * 100.05) / 100);
             
  	    
  	 
  	    
              $("#sup11").html(sup1);
              $("#sup22").html(sup2);
              $("#sup33").html(sup3);
              $("#sup44").html(sup4);
              $("#sup55").html(sup5);
              
              $("#res11").html(res1);
              $("#res22").html(res2);
              $("#res33").html(res3);
              $("#res44").html(res4);
              $("#res55").html(res5);
              
              $("#buyAt0").html(buyAt);
              $("#buy0").html(buy);
              $("#buyStoploss0").html(buyStoploss);
              
              $("#extendedBuy0").html(extendedBuy);
              $("#extendedSell0").html(extendedSell);
              
              $("#sellAt0").html(sellAt);
              $("#sell0").html(sell);
              $("#sellStoploss0").html(sellStoploss);
              
              
              $("#BNopen").html(open);
              $("#BNhigh").html(high);
              $("#BNlow").html(low);
              $("#BNlastprice").html(lastprice);
              $("#BNpercentchange").html(text2);
              
              $("#BNyearlyhigh").html(yearlyhigh);
              $("#BNyearlylow").html(yearlylow);
              $("#BNTrend").html(text0);
              
              
    	 }
    })	
    
    
    
    
     /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  start appfeeds/banknifty <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/      
    $.ajax({
    	type:'Get',
    	url: 'appfeeds/banknifty/future',
    	success: function(result){
      		var json = JSON.parse(result);
    		var ltp=json[0]["lastprice"];
    		var expiry_date_d=json[0]["expiry_date_d"];    		
    		var last_update_ent_date=json[0]["ent_date"]; 
    		var change=json[0]["change"]; 
    		var percentchange=json[0]["percentchange"]; 
    		var volume_data=json[0]["volume_data"]; 
    		var volume=json[0]["volume"]; 
    		
    		/*if(direction==1){
    			var trend="Day-Positive";
    			text0="<span class='blinking1' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + trend + "</span>" +
    			"<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
    			lastprice="<span class='blinking1' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + lastprice + "</span>" +
   			 	"<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
    			text2="<span style='color: #00c853; font-weight: bold; font-size: 14px;'>+" + percentchange + "</span>";
    		}
    		else{
    			var trend="Day-Negative";
    			text0="<span class='blinking1' style='color: #ff4444; font-weight: bold; font-size: 14px;'>" + trend + "</span>" + 
				"<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
    			var lastprice=text="<span class='blinking1' style='color: #ff4444; font-weight: bold; font-size: 14px;'>" + lastprice + "</span>" + 
    			"<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
    			text2="<span style='color: #CC0000; font-weight: bold; font-size: 14px;'>" + percentchange + "</span>";
    		}*/
    		
    		var volume_text="<span class='blinking1' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + volume_data + "</span>" ;
    		var volume_million="<span class='blinking1' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + volume + "</span>" ;
    		
    		if(change>=0){
    			var lastprice="<span style='color: #00c853; font-weight: bold; font-size: 15px;'>" + ltp + "</span>" 
    			+ "<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";	
    			var changeVal="<span style='color: #00c853; font-weight: bold; font-size: 15px;'>" + change + "</span>" 
    			+ "<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
        		var changePer="<span style='color: #00c853; font-weight: bold; font-size: 15px;'>" + percentchange + "% </span>" 
        		+ "<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
    		}
    		else{
    			var lastprice="<span style='color: #ffa250; font-weight: bold; font-size: 15px;'>" + ltp + "</span>" 
    			+ "<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
    			var changeVal="<span style='color: #ffa250; font-weight: bold; font-size: 15px;'>" + change + "</span>" 
    			+ "<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
        		var changePer="<span style='color: #ffa250; font-weight: bold; font-size: 15px;'>" + percentchange + "% </span>" 
        		+ "<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
    		}
    		
    		
    		
    		 $("#BNFutureltp").html(lastprice);
             $("#BNFutureExpiryDate").html(expiry_date_d);
             $("#BNFutureLastUpdate").html(last_update_ent_date);
             $("#BNFutureChangeValue").html(changeVal);
             $("#BNFuturePercentChange").html(changePer);
             
             $("#BNFutureVolumeData").html(volume_text);
             $("#BNFutureVolume").html(volume_million);
    		
              
              
    	 }
    })	
    
      
 /*))))))))))))))))))))))))))))))))   END appfeeds/banknifty ((((((((((((((((((((((((((((((((((((*/  
      

      
    