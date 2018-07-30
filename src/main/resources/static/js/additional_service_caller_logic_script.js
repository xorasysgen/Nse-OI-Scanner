
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
        		var previousClose=json.data[0].prevClose;
        		var vwap=json.data[0].vwap;
        		var dailyVolatility=json.data[0].dailyVolatility;
        		
        		var prevClose=json.data[0].prevClose;
        		prevClose=prevClose.replace(/,/g , "")
        		
        		var openPrice=json.data[0].openPrice;
        		openPrice=openPrice.replace(/,/g , "")
        		
        		var highPrice=json.data[0].highPrice;
        		highPrice=highPrice.replace(/,/g , "")
        		
        		var lowPrice=json.data[0].lowPrice;
        		lowPrice=lowPrice.replace(/,/g , "")
        		
        		var lastPrice=json.data[0].lastPrice;
        		lastPrice=lastPrice.replace(/,/g , "")
        		
        		var pChange=json.data[0].pChange;
        		var change=json.data[0].change;
        		var booleanValue=false;
        		
       			if(vwap.replace(/,/g , "") <= lastPrice.replace(/,/g , "")){
       				var vwapText="<span class='vwapGreenBlinker'>" + vwap + "</span>" +
       				"<span style='color: green; font-weight: bold; font-size: 14px;'> BUY</span>" + 
       				"<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
       				booleanValue=true;
       				
       			}
       			else{
       				var vwapText="<span class='vwapRedBlinker'>" + vwap + "</span>" +
       				"<span style='color: red; font-weight: bold; font-size: 14px;'> SELL</span>" + 
       				"<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
       				booleanValue=false;
       			}
        		
        		var buyResult=Math.abs(openPrice.replace(/,/g , "")-lowPrice.replace(/,/g , ""));
        		var sellResult=Math.abs(openPrice.replace(/,/g , "")-highPrice.replace(/,/g , ""));
        		var diffNiftyOpenPrevOpen=Math.abs(openPrice.replace(/,/g , "")-prevClose.replace(/,/g , ""));
        		var diffNiftyOpenPrevOpenResult=false;
        		if(diffNiftyOpenPrevOpen>=1 && diffNiftyOpenPrevOpen<=3){
        			diffNiftyOpenPrevOpenResult=true
        		}
        		
        		
        		var textOpen="<span style='color: black; font-weight: bold; font-size: 14px;'>" + openPrice + "</span>";
        		var textLow="<span style='color: red; font-weight: bold; font-size: 11px;'>" + lowPrice + "</span>";
        		var textHigh="<span style='color: green; font-weight: bold; font-size: 11px;'>" + highPrice + "</span>";
        		var textPreviousClose="<span style='color: green; font-weight: bold; font-size: 11px;'>" + previousClose + "</span>";
        		
        		if(buyResult >=0 && buyResult <=11 && booleanValue==true) {
        			var trend="Strong BUY";
        			text0="<span class='blinking1' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + trend + "</span>" +
   				 "<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
        		}else if(sellResult >=0 && sellResult <=9 && booleanValue==false){
        			
        			var trend="Strong SELL";
        			text0="<span class='blinking1' style='color: #ff4444; font-weight: bold; font-size: 14px;'>" + trend + "</span>" + 
    				"<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
        			
        		}else if(openPrice>prevClose && lastPrice>openPrice && booleanValue==true){
        			var trend="BUY";
    				text0="<span class='blinking1' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + trend + "</span>" +
    				 "<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
    			}else if(diffNiftyOpenPrevOpenResult==true && booleanValue==true && lastPrice>openPrice){
    				var trend="BUY On Decline";
    				text0="<span class='blinking1' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + trend + "</span>" +
   				 "<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
    			}
    			else{
    				var trend="SELL";
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
        		
            			
            		 $("#niftyPreviousClose").html(textPreviousClose); 	
          			  $("#niftyOpen").html(textOpen);
          			  $("#niftyLow").html(textLow);
          			  $("#niftyHigh").html(textHigh); 	
          			  
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
        		var previousClose=json.data[0].prevClose.replace(/,/g , "");
        		var dailyVolatility=json.data[0].dailyVolatility;
        		
        		var prevClose=json.data[0].prevClose;
        		prevClose=prevClose.replace(/,/g , "")
        		
        		var openPrice=json.data[0].openPrice;
        		openPrice=openPrice.replace(/,/g , "")
        		
        		var highPrice=json.data[0].highPrice;
        		highPrice=highPrice.replace(/,/g , "")
        		
        		var lowPrice=json.data[0].lowPrice;
        		lowPrice=lowPrice.replace(/,/g , "")
        		
        		var lastPrice=json.data[0].lastPrice;
        		lastPrice=lastPrice.replace(/,/g , "")
        		
        		
        		var pChange=json.data[0].pChange;
        		var change=json.data[0].change;
        		
        		var shortCovringOrLongUnwinding=false;
        		
        		var price;
        		var oi;
        		
        		var buyResult=Math.abs(openPrice.replace(/,/g , "")-lowPrice.replace(/,/g , ""));
        		var sellResult=Math.abs(openPrice.replace(/,/g , "")-highPrice.replace(/,/g , ""));
        		
        		var booleanValue=false;
        		
       			if(vwap.replace(/,/g , "") <= lastPrice.replace(/,/g , "")){
       				var vwapText="<span class='vwapGreenBlinker'>" + vwap + "</span>" +
       				"<span style='color: green; font-weight: bold; font-size: 14px;'> Buy</span>" +
       				"<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
       				booleanValue=true;
       				
       			}
       			else{
       				var vwapText="<span class='vwapRedBlinker'>" + vwap + "</span>" +
       				"<span style='color: red; font-weight: bold; font-size: 14px;'> SELL</span>" + 
       				"<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
       				booleanValue=false;
       				
       			}
        		
        		var textOpen="<span style='color: black; font-weight: bold; font-size: 14px;'>" + openPrice + "</span>";
        		var textLow="<span style='color: red; font-weight: bold; font-size: 11px;'>" + lowPrice + "</span>";
        		var textHigh="<span style='color: green; font-weight: bold; font-size: 11px;'>" + highPrice + "</span>";
        		var textPreviousClose="<span style='color: green; font-weight: bold; font-size: 11px;'>" + previousClose + "</span>";
        	
        		
        		if(buyResult >=0 && buyResult <=30) {
        			var trend="Strong BUY";
        			text0="<span class='blinking1' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + trend + "</span>" +
        			"<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
        			
        		}else if(sellResult >=0 && sellResult <=30) {
        			var trend="Strong SELL";
        			text0="<span class='blinking1' style='color: #ff4444; font-weight: bold; font-size: 14px;'>" + trend + "</span>" + 
    				"<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
        			
        		}else if(openPrice>prevClose && lastPrice>=openPrice && booleanValue==true){
        			var trend="BUY";
    				text0="<span class='blinking1' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + trend + "</span>" +
    				 "<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
    			}else if(booleanValue==true && lastPrice>openPrice){
    				var trend="BUY On Decline";
				text0="<span class='blinking1' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + trend + "</span>" +
				 "<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
			}
			else{
				var trend="SELL";
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
            		
            		
            		
            		var pChangeEvo1=pChange.replace("%" , "");
            		console.log("pChangeEvo1" + pChangeEvo1);
            		
            		var changeEvo1=change;
            		console.log("changeEvo1" + changeEvo1);
            		
            		
            		var pChangeEvo=pchangeinOpenInterest.replace("%" , "");
            		console.log("pChangeEvo" + pChangeEvo);
            		
            		var changeEvo=changeinOpenInterest;
            		console.log("changeEvo" + changeinOpenInterest);

            		
            			if(changeinOpenInterest>0){
            				text3="<span class='blinking1' style='color: #00c853; font-weight: bold; font-size: 14px;'>" + openInterest + "</span>" + 
            				"<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
            				text4="<span  style='color: #00c853; font-weight: bold; font-size: 14px;'>" + changeinOpenInterest + "</span>";
            				oi="+";
            			}
            			else{
            				text3="<span class='blinking1' style='color: #ff4444; font-weight: bold; font-size: 14px;'>" + openInterest + "</span>" + 
            				"<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
            				text4="<span style='color: #CC0000; font-weight: bold; font-size: 14px;'>" + changeinOpenInterest + "</span>";
            				oi="-";
            			}
            			
            			if(pchangeinOpenInterest>0){
            				text5="<span style='color: #00c853; font-weight: bold; font-size: 14px;'>" + pchangeinOpenInterest + "%</span>";
            			}
            			else{
            				text5="<span style='color: #CC0000; font-weight: bold; font-size: 14px;'>" + pchangeinOpenInterest + "%</span>";
            			}
        		
            			
            			
            			if(changeEvo1>50 && booleanValue==true){
                			price="+";
                		}
                		else{
                			price="-";
                		}
                		
                		if(changeEvo<0 && pChangeEvo<-5){
                			shortCovringOrLongUnwinding=true;
                		}
                		else{
                			shortCovringOrLongUnwinding=false;
                		}
            			console.log("price" + price);
            			console.log("oi" + oi);
            			console.log("shortCovringOrLongUnwinding" + shortCovringOrLongUnwinding);
                		
            			var text11="No clear trend in future";
            			var display="+";
                		if(price=="+" && oi=="+"){
            				text11="<span class='greenBlinker' style='color: #00c853; font-weight: bold; font-size: 16px;'>LONG</span>";
            				display="+";
                		}
            			else if (price=="-" && oi=="+"){
            				text11="<span class='superolive' style='color: #CC0000; font-weight: bold; font-size: 16px;'>SHORT</span>";
            				display="-";
            			}else if(price=="+" && oi=="-" && shortCovringOrLongUnwinding){
            				text11="<span class='greenBlinker' style='color: #00c853; font-weight: bold; font-size: 16px;'>SHORT COVERING</span>";
            				display="+";
                		}
            			else if(price=="-" && oi=="-" && shortCovringOrLongUnwinding){
            				text11="<span class='superolive' style='color: #CC0000; font-weight: bold; font-size: 16px;'>LONG UNWINDING</span>";
            				display="-";
            			}
            			
                		var bullImage="<img src='images/bull-head.png' style='height:25px; width:32px;'>";
                		var bearImage="<img src='images/bear.png' style='height:25px; width:32px;'>";
                		
                		if(display=="+"){
                			$("#bankNiftyShortsOrLongFUTNamePlus").html("BANK NIFTY-OI");
                			$("#bankNiftyShortsOrLongFUTOpenInterestPlus").html(text3);
                            $("#bankNiftyShortsOrLongChangeinOpenInterestPlus").html(text4);
                            $("#bankNiftyShortsOrLongPerchangeinOpenInterestPlus").html(text5);
                            $("#ShortsOrLongRemarkPlus").html(text11);
                            $("#bull").html(bullImage)
                		}
                		else{
                			$("#mark0").html("Not Recommended");
                			$("#bankNiftyShortsOrLongFUTNamePlus").html("");
                			$("#bankNiftyShortsOrLongFUTOpenInterestPlus").html("");
                            $("#bankNiftyShortsOrLongChangeinOpenInterestPlus").html("");
                            $("#bankNiftyShortsOrLongPerchangeinOpenInterestPlus").html("");
                            $("#ShortsOrLongRemarkPlus").html("");
                            $("#bull").html("")
                		}
                		
                		
                		
                		if(display=="-"){
                			$("#bankNiftyShortsOrLongFUTNameMinus").html("BANK NIFTY-OI");
                			$("#bankNiftyShortsOrLongFUTOpenInterestMinus").html(text3);
                            $("#bankNiftyShortsOrLongChangeinOpenInterestMinus").html(text4);
                            $("#bankNiftyShortsOrLongPerchangeinOpenInterestMinus").html(text5);
                            $("#ShortsOrLongRemarkMinus").html(text11);
                            $("#bear").html(bearImage)
                		}
                		else{
                			$("#mark1").html("Not Recommended");
                			$("#bankNiftyShortsOrLongFUTNameMinus").html("");
                			$("#bankNiftyShortsOrLongFUTOpenInterestMinus").html("");
                            $("#bankNiftyShortsOrLongChangeinOpenInterestMinus").html("");
                            $("#bankNiftyShortsOrLongPerchangeinOpenInterestMinus").html("");
                            $("#bear").html("");
                		}
                		
            $("#bankNiftyPreviousClose").html(textPreviousClose); 	 			
            $("#bankNiftyOpen").html(textOpen);
            $("#bankNiftyLow").html(textLow);
            $("#bankNiftyHigh").html(textHigh);
                    		
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
        		
    				text0="<span class='superolive'>" + first + "</span>";
    				
    				text1="<span class='superolive'>" + second + "</span>"; 
    				
    				text2="<span class='navyBlinker' style='font-weight: bold; font-size: 14px;'>" + third + "</span>"; 
    				
    				text3="<span class='navyBlinker' style='font-weight: bold; font-size: 14px;'>" + four + "</span>";
        	
        		
            $("#Predictionfirst").html(text0);
            $("#Predictionsecond").html(text1);
            $("#Predictionthird").html(text2);
            $("#Predictionfour").html(text3);
        	
        }
        })

        
        
        /*---------------------------------------------------------------------------------*/
        $.ajax({
        	type:'Get',
        	url: 'suggestions/bank_nifty_expiry_day_option_suggestion/non_expiry_day',
        	success: function(result){
        		var json = result;
        		
        		var first=json.data[0].optionTypeStrikePrice;
        		var second=json.data[1].optionTypeStrikePrice;
        		var third=json.data[2].optionTypeStrikePrice;
        		var four=json.data[3].optionTypeStrikePrice;
        		
        		
        		var quick1=json.data[4].optionTypeStrikePrice;
        		var quick2=json.data[5].optionTypeStrikePrice;
        		var quick3=json.data[6].optionTypeStrikePrice;
        		var quick4=json.data[7].optionTypeStrikePrice;
        		
        		
        		text000="<span class='greenBlinker'>" + quick1 + "</span>";
				
				text111="<span class='greenBlinker'>" + quick2 + "</span>"; 
				
				text222="<span class='greenBlinker'>"  + quick3 + "</span>"; 
				
				text333="<span class='greenBlinker'>"  + quick4 + "</span>";
        		
        		
    				text0="<span class='greenBlinker'>" + first + "</span>";
    				
    				text1="<span class='greenBlinker'>" + second + "</span>"; 
    				
    				text2="<span class='navyBlinker' style='font-weight: bold; font-size: 14px;'>" + third + "</span>"; 
    				
    				text3="<span class='navyBlinker' style='font-weight: bold; font-size: 14px;'>" + four + "</span>";
        	
        		
            $("#quick1").html(text000);
            $("#quick2").html(text111);
            $("#quick3").html(text222);
            $("#quick4").html(text333);
            
            
            $("#nonExpiry1").html(text0);
            $("#nonExpiry2").html(text1);
            $("#nonExpiry3").html(text2);
            $("#nonExpiry4").html(text3);
        	
        }
        })
        
        
/* begins support and resistance bank nifty future data*/
        /*---------------------------------------------------------------------------------*/
        $.ajax({
        	type:'Get',
        	url: 'suggestions/banknifty_and_nifty_support_resistance',
        	success: function(result){
        		var json = result;
        		var ltpDataPointcordinateNifty=json.data[0].ltpDataPointcordinate;
        		var niftyltp=json.data[0].ltp;
        		var symbol=json.data[0].symbol;
        		var name=json.data[0].name;
        		var s3=json.data[0].s3;
        		var s2=json.data[0].s2
        		var s1=json.data[0].s1;
        		var pivotPoints=json.data[0].pivotPoints;
        		var r1=json.data[0].r1;
        		var r2=json.data[0].r2;
        		var r3=json.data[0].r3;
        		  
        		var symbolNifty="<span class='nifty' style='font-weight: bold; font-size: 16px;'>" + symbol + "</span>";
        		
        		if(ltpDataPointcordinateNifty=="s3"){
        			var nifty1="<span class='navyBlinker' style='font-weight: bold; font-size: 16px;'>" + s3 + "</span>";
        		} 
        		else {
        			var nifty1="<span style='color: black; font-weight: bold; font-size: 14px;'>" + s3 + "</span>";
        		}
        		
        		if(ltpDataPointcordinateNifty=="s2"){
        			var nifty2="<span class='navyBlinker' style='font-weight: bold; font-size: 16px;'>" + s2 + "</span>";
        		} 
        		else {
        			var nifty2="<span style='color: black; font-weight: bold; font-size: 14px;'>" + s2 + "</span>";
        		}
        		
        		if(ltpDataPointcordinateNifty=="s1"){
        			var nifty3="<span class='navyBlinker' style='font-weight: bold; font-size: 16px;'>" + s1 + "</span>";
        		}
        		else{
        			var nifty3="<span style='color: black; font-weight: bold; font-size: 14px;'>" + s1 + "</span>";
        		}
        		
        		
        		if(ltpDataPointcordinateNifty=="pivotPoints"){
        			var nifty4="<span class='navyBlinker' style='font-weight: bold; font-size: 16px;'>" + pivotPoints + "</span>";
        		} 
        		else{
        			var nifty4="<span style='color: black; font-weight: bold; font-size: 14px;'>" + pivotPoints + "</span>";
        		}
        		
        		
        		if(ltpDataPointcordinateNifty=="r1"){
        			var nifty5="<span class='navyBlinker' style='font-weight: bold; font-size: 16px;'>" + r1 + "</span>";
        		} else{
        			var nifty5="<span style='color: black; font-weight: bold; font-size: 14px;'>" + r1 + "</span>";
        		}
        		
        		if(ltpDataPointcordinateNifty=="r2"){
        			var nifty6="<span class='navyBlinker' style='font-weight: bold; font-size: 16px;'>" + r2 + "</span>";
        		}
        		else{
        			var nifty6="<span style='color: black; font-weight: bold; font-size: 14px;'>" + r2 + "</span>";
        		}
        		if(ltpDataPointcordinateNifty=="r3"){
        			var nifty7="<span class='navyBlinker' style='font-weight: bold; font-size: 16px;'>" + r3 + "</span>";
        		}
        		else{
        			var nifty7="<span style='color: black; font-weight: bold; font-size: 14px;'>" + r3 + "</span>";
        		}
                $("#niftySymbolName").html(symbolNifty);
                $("#niftyS3").html(nifty1);
                $("#niftyS2").html(nifty2);
                $("#niftyS1").html(nifty3);
                $("#niftyP1").html(nifty4);
                $("#niftyR1").html(nifty5);
                $("#niftyR2").html(nifty6);
                $("#niftyR3").html(nifty7);
                
                var ltpDataPointcordinateBankNifty=json.data[1].ltpDataPointcordinate;
                var bankNiftyltp=json.data[1].ltp;
        		var symbolbankNifty=json.data[1].symbol;
        		var name=json.data[1].name;
        		var s33=json.data[1].s3;
        		var s22=json.data[1].s2
        		var s11=json.data[1].s1;
        		var pivotPoints11=json.data[1].pivotPoints;
        		var r11=json.data[1].r1;
        		var r22=json.data[1].r2;
        		var r33=json.data[1].r3;
        		
        		var symbolBank="<span class='bankNifty' style='font-weight: bold; font-size: 16px;'>" + symbolbankNifty + "</span>";
        		
        		if(ltpDataPointcordinateBankNifty=="s3"){
        			var bankNifty1="<span class='navyBlinker' style='font-weight: bold; font-size: 16px;'>" + s33 + "</span>";
        		} 
        		else {
        			var bankNifty1="<span style='color: black; font-weight: bold; font-size: 14px;'>" + s33 + "</span>";
        		}
        		
        		if(ltpDataPointcordinateBankNifty=="s2"){
        			var bankNifty2="<span class='navyBlinker' style='font-weight: bold; font-size: 16px;'>" + s22 + "</span>";
        		} 
        		else {
        			var bankNifty2="<span style='color: black; font-weight: bold; font-size: 14px;'>" + s22 + "</span>";
        		}
        		
        		if(ltpDataPointcordinateBankNifty=="s1"){
        			var bankNifty3="<span class='navyBlinker' style='font-weight: bold; font-size: 16px;'>" + s11 + "</span>";
        		}
        		else{
        			var bankNifty3="<span style='color: black; font-weight: bold; font-size: 14px;'>" + s11 + "</span>";
        		}
        		
        		
        		if(ltpDataPointcordinateBankNifty=="pivotPoints"){
        			var bankNifty4="<span class='navyBlinker' style='font-weight: bold; font-size: 16px;'>" + pivotPoints11 + "</span>";
        		} 
        		else{
        			var bankNifty4="<span style='color: black; font-weight: bold; font-size: 14px;'>" + pivotPoints11 + "</span>";
        		}
        		
        		
        		if(ltpDataPointcordinateBankNifty=="r1"){
        			var bankNifty5="<span class='navyBlinker' style='font-weight: bold; font-size: 16px;'>" + r11 + "</span>";
        		} else{
        			var bankNifty5="<span style='color: black; font-weight: bold; font-size: 14px;'>" + r11 + "</span>";
        		}
        		
        		if(ltpDataPointcordinateBankNifty=="r2"){
        			var bankNifty6="<span class='navyBlinker' style='font-weight: bold; font-size: 16px;'>" + r22 + "</span>";
        		}
        		else{
        			var bankNifty6="<span style='color: black; font-weight: bold; font-size: 14px;'>" + r22 + "</span>";
        		}
        		if(ltpDataPointcordinateBankNifty=="r3"){
        			var bankNifty7="<span class='navyBlinker' style='font-weight: bold; font-size: 16px;'>" + r33 + "</span>";
        		}
        		else{
        			var bankNifty7="<span style='color: black; font-weight: bold; font-size: 14px;'>" + r33 + "</span>";
        		}
        		
        		
        		
        		$("#BankNiftySymbolName").html(symbolBank);
        		$("#BankNiftyS3").html(bankNifty1);
        		$("#BankNiftyS2").html(bankNifty2);
        		$("#BankNiftyS1").html(bankNifty3);
        		$("#BankNiftyP1").html(bankNifty4);
        		$("#BankNiftyR1").html(bankNifty5);
        		$("#BankNiftyR2").html(bankNifty6);
        		$("#BankNiftyR3").html(bankNifty7);
        	
        }
        })

 