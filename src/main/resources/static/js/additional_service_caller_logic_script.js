
/* begins get nifty data*/
/*---------------------------------------------------------------------------------*/
        $.ajax({
        	type:'Get',
        	url: 'nifty_future_oi',
        	success: function(result){
        		var json = result;
        		var lastUpdateTime=json.lastUpdateTime;
        		var tradedDate=json.tradedDate;
        		var expiryDate=json.data[0].expiryDate;
        		var vwap=json.data[0].vwap;
        		var dailyVolatility=json.data[0].dailyVolatility;
        		
        		var prevClose=json.data[0].prevClose;
        		var openPrice=json.data[0].openPrice;
        		var highPrice=json.data[0].highPrice;
        		var lowPrice=json.data[0].lowPrice;
        		var lastPrice=json.data[0].lastPrice;
        		
        		var pChange=json.data[0].pChange;
        		var change=json.data[0].change;
        		
        		var vwapText="<span  style='color: black; font-weight: bold; font-size: 14px;'>" + vwap + "</span>";
        		if(openPrice>prevClose && lastPrice>openPrice){
        			var trend="Positive";
    				text0="<span class='blinking1' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + trend + "</span>" +
    				 "<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
    			}
    			else{
    				var trend="Negative";
    				text0="<span class='blinking1' style='color: #ff4444; font-weight: bold; font-size: 14px;'>" + trend + "</span>" + 
    				"<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
    			}
        		
        		
        			if(change>0){
        				text="<span class='blinking1' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + lastPrice + "</span>" +
        				 "<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
        				text1="<span  style='color: #00c853; font-weight: bold; font-size: 14px;'>" + change + "</span>";
        			}
        			else{
        				text="<span class='blinking1' style='color: #ff4444; font-weight: bold; font-size: 14px;'>" + lastPrice + "</span>" + 
        				"<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
        				text1="<span style='color: #CC0000; font-weight: bold; font-size: 14px;'>" + change + "</span>";
        			}
        			
        			if(pChange>0){
        				text2="<span style='color: #00c853; font-weight: bold; font-size: 14px;'>" + pChange + "%</span>";
        			}
        			else{
        				text2="<span style='color: #CC0000; font-weight: bold; font-size: 14px;'>" + pChange + "%</span>";
        			}
        			
        			var openInterest=json.data[0].openInterest;
        			openInterest=openInterest.replace(/,/g , "");
            		var changeinOpenInterest=json.data[0].changeinOpenInterest;
            		changeinOpenInterest=changeinOpenInterest.replace(/,/g , "");
            		var pchangeinOpenInterest=json.data[0].pchangeinOpenInterest;
           			
            			
            			if(changeinOpenInterest>0){
            				text3="<span class='blinking1' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + openInterest + "</span>" + 
            				"<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
            				text4="<span  style='color: #00c853; font-weight: bold; font-size: 14px;'>" + changeinOpenInterest + "</span>";
            			}
            			else{
            				text3="<span class='blinking1' style='color: #ff4444; font-weight: bold; font-size: 14px;'>" + openInterest + "</span>" + 
            				"<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
            				text4="<span style='color: #CC0000; font-weight: bold; font-size: 14px;'>" + changeinOpenInterest + "</span>";
            			}
            			
            			if(pchangeinOpenInterest>0){
            				text5="<span style='color: #00c853; font-weight: bold; font-size: 14px;'>" + pchangeinOpenInterest + "%</span>";
            			}
            			else{
            				text5="<span style='color: #CC0000; font-weight: bold; font-size: 14px;'>" + pchangeinOpenInterest + "%</span>";
            			}
        		
            $("#niftyvwap").html(vwapText);
            $("#niftyFUTTrend").html(text0);
            $("#niftyFUTlastUpdateTime").html(lastUpdateTime);
            $("#niftyFUTLastPrice").html(text);
            $("#niftyFUTChange").html(text1);
            $("#niftyFUTPChange").html(text2);
            
            
            $("#NiftyFUTOpenInterest").html(text3);
            $("#NiftyFUTChangeinOpenInterest").html(text4);
            $("#NiftyFUTPchangeinOpenInterest").html(text5);
        	
        }
        })

      /*end get nifty future data */
/*---------------------------------------------------------------------------------*/
        
        
        /* begins get bank nifty future data*/
        /*---------------------------------------------------------------------------------*/
        $.ajax({
        	type:'Get',
        	url: 'bank_nifty_future_oi',
        	success: function(result){
        		var json = result;
        		var lastUpdateTime=json.lastUpdateTime;
        		var tradedDate=json.tradedDate;
        		var expiryDate=json.data[0].expiryDate;
        		var vwap=json.data[0].vwap;
        		var dailyVolatility=json.data[0].dailyVolatility;
        		
        		var prevClose=json.data[0].prevClose;
        		var openPrice=json.data[0].openPrice;
        		var highPrice=json.data[0].highPrice;
        		var lowPrice=json.data[0].lowPrice;
        		var lastPrice=json.data[0].lastPrice;
        		
        		var pChange=json.data[0].pChange;
        		var change=json.data[0].change;
        		
        		if(openPrice>prevClose && lastPrice>=openPrice){
        			var trend="Positive";
    				text0="<span class='blinking1' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + trend + "</span>" +
    				 "<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
    			}
    			else{
    				var trend="Negative";
    				text0="<span class='blinking1' style='color: #ff4444; font-weight: bold; font-size: 14px;'>" + trend + "</span>" + 
    				"<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
    			}
        		
        		
        			if(change>0){
        				text="<span class='blinking1' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + lastPrice + "</span>" +
        				 "<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
        				text1="<span  style='color: #00c853; font-weight: bold; font-size: 14px;'>" + change + "</span>";
        			}
        			else{
        				text="<span class='blinking1' style='color: #ff4444; font-weight: bold; font-size: 14px;'>" + lastPrice + "</span>" + 
        				"<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
        				text1="<span style='color: #CC0000; font-weight: bold; font-size: 14px;'>" + change + "</span>";
        			}
        			
        			if(pChange>0){
        				text2="<span style='color: #00c853; font-weight: bold; font-size: 14px;'>" + pChange + "%</span>";
        			}
        			else{
        				text2="<span style='color: #CC0000; font-weight: bold; font-size: 14px;'>" + pChange + "%</span>";
        			}
        			
        			var openInterest=json.data[0].openInterest;
        			openInterest=openInterest.replace(/,/g , "");
            		var changeinOpenInterest=json.data[0].changeinOpenInterest;
            		changeinOpenInterest=changeinOpenInterest.replace(/,/g , "");
            		var pchangeinOpenInterest=json.data[0].pchangeinOpenInterest;
           			
           			
            			var vwapText="<span  style='color: black; font-weight: bold; font-size: 14px;'>" + vwap + "</span>";
            			if(changeinOpenInterest>0){
            				text3="<span class='blinking1' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + openInterest + "</span>" + 
            				"<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
            				text4="<span  style='color: #00c853; font-weight: bold; font-size: 14px;'>" + changeinOpenInterest + "</span>";
            			}
            			else{
            				text3="<span class='blinking1' style='color: #ff4444; font-weight: bold; font-size: 14px;'>" + openInterest + "</span>" + 
            				"<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
            				text4="<span style='color: #CC0000; font-weight: bold; font-size: 14px;'>" + changeinOpenInterest + "</span>";
            			}
            			
            			if(pchangeinOpenInterest>0){
            				text5="<span style='color: #00c853; font-weight: bold; font-size: 14px;'>" + pchangeinOpenInterest + "%</span>";
            			}
            			else{
            				text5="<span style='color: #CC0000; font-weight: bold; font-size: 14px;'>" + pchangeinOpenInterest + "%</span>";
            			}
        		
            $("#bankNiftyvwap").html(vwapText);
            $("#bankNiftyFUTTrend").html(text0);
            $("#bankNiftyFUTlastUpdateTime").html(lastUpdateTime);
            $("#bankNiftyFUTLastPrice").html(text);
            $("#bankNiftyFUTChange").html(text1);
            $("#bankNiftyFUTPChange").html(text2);
            
            
            $("#bankNiftyFUTOpenInterest").html(text3);
            $("#bankNiftyFUTChangeinOpenInterest").html(text4);
            $("#bankNiftyFUTPchangeinOpenInterest").html(text5);
        	
        }
        })


        /*---------------------------------------------------------------------------------*/
        /*end get bank nifty future data*/ 
        
        /* begins get bank nifty suggestion data*/
/*---------------------------------------------------------------------------------*/
        $.ajax({
        	type:'Get',
        	url: 'suggestions/bank_nifty_expiry_day_option_suggestion',
        	success: function(result){
        		var json = result;
        		
        		var first=json.data[0].optionTypeStrikePrice;
        		var second=json.data[1].optionTypeStrikePrice;
        		var third=json.data[2].optionTypeStrikePrice;
        		var four=json.data[3].optionTypeStrikePrice;
        		
    				text0="<span class='superolive' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + first + "</span>";
    				
    				text1="<span class='superolive' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + second + "</span>"; 
    				
    				text2="<span class='superolive' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + third + "</span>"; 
    				
    				text3="<span class='superolive' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + four + "</span>";
        	
        		
            $("#Predictionfirst").html(text0);
            $("#Predictionsecond").html(text1);
            $("#Predictionthird").html(text2);
            $("#Predictionfour").html(text3);
        	
        }
        })

        
        
 