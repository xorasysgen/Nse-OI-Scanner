<!doctype html>
<html>
  <head>
    <title>Gann geometric angles predicting price movements# There are four cardinal crosses 90, 180, 270, 360</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<jsp:include page="js_css_include.jsp"/>

 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>  <!-- jquery lib -->
<!-- begins get nifty and bank nifty data -->
<script>
        $.ajax({
        	type:'Get',
        	url: 'http://192.168.0.100:8080/appfeeds/nifty',
        	success: function(result){
        		var json = JSON.parse(result);
        		console.log(json);
        		var nifty=json.indices.lastprice;
        		console.log(nifty);
        		
        		
            $("#niftyPrice").html(nifty);
            
        	
        }
        })

</script>
<!-- end get nifty and bank nifty data -->



 <script type="text/javascript">
 $(document).ready(function () {
	    $("#text1").focus();
	});
 </script>
 
  <script type="text/javascript">
    function IsNumeric(e, id) {
		var specialKeys = new Array();
		specialKeys.push(8); //Backspace
		var keyCode = e.which ? e.which : e.keyCode;
		var ret = ((keyCode >= 48 && keyCode <= 57) || (keyCode >= 96 && keyCode <= 105)  
				|| specialKeys.indexOf(keyCode) != -1 || keyCode == 9 || keyCode == 13 || keyCode == 46);
		document.getElementById(id).style.display = ret ? "none" : "block";
		return ret;
		}	
 
    function resetAll(){
    	$(document).ready(function(){
    			$("#sharesQuantityPriceResult").hide();
    		 	$("#text1").val('');
            	$("#text2").val('');
            	$("#text3").val('');
            	$("#text4").val('');
	    });
    } 
    
$(document).ready(function(){
    	$('#submitId').click(function(){
    		if(!(validateFieldOne("text1","Please Type Shares Bought Quantity"))){
    			return false;
    		}
    		var ltp = document.getElementById("text1").value;
            var squareRoot = Math.floor(Math.sqrt(ltp));
            var startNumber = 1;
            if (squareRoot > 1) {
                startNumber = squareRoot - 1
            }
            for (i = 1; i <= 25; i++) {
                setValue("block" + i, Math.floor(Math.pow(startNumber + (i - 1) * 0.125, 2) * 100) / 100)
            }
            var sup1Factor = (Math.floor(Math.sqrt(ltp) * 1000) - Math.floor(Math.sqrt(ltp) * 1000) % 125) / 1000;
            setValue("sup1", Math.floor(Math.pow(sup1Factor - 0.125, 2) * 100) / 100);
            setValue("sup2", Math.floor(Math.pow(sup1Factor - 0.25, 2) * 100) / 100);
            setValue("sup3", Math.floor(Math.pow(sup1Factor - 0.375, 2) * 100) / 100);
            setValue("sup4", Math.floor(Math.pow(sup1Factor - 0.5, 2) * 100) / 100);
            setValue("sup5", Math.floor(Math.pow(sup1Factor - 0.625, 2) * 100) / 100);
            setValue("res1", Math.floor(Math.pow(sup1Factor + 0.25, 2) * 100) / 100);
            setValue("res2", Math.floor(Math.pow(sup1Factor + 0.375, 2) * 100) / 100);
            setValue("res3", Math.floor(Math.pow(sup1Factor + 0.5, 2) * 100) / 100);
            setValue("res4", Math.floor(Math.pow(sup1Factor + 0.625, 2) * 100) / 100);
            setValue("res5", Math.floor(Math.pow(sup1Factor + 0.75, 2) * 100) / 100);
            setValue("buyAt", Math.floor(Math.pow(sup1Factor + 0.125, 2) * 100) / 100);
            setValue("buyStoploss", Math.floor(Math.pow(sup1Factor, 2) * 100) / 100);
            setValue("sellAt", Math.floor(Math.pow(sup1Factor, 2) * 100) / 100);
            setValue("sellStoploss", Math.floor(Math.pow(sup1Factor + 0.125, 2) * 100) / 100);
            setValue("buy", Math.floor(Math.pow(sup1Factor + 0.25, 2) * 99.95) / 100 + " <span class='glyphicon glyphicon-arrow-right' style='font-size: 14px; color: green;'></span> " + Math.floor(Math.pow(sup1Factor + 0.375, 2) * 99.95) / 100 + " <span class='glyphicon glyphicon-arrow-right' style='font-size: 14px; color: green;'></span> " + Math.floor(Math.pow(sup1Factor + 0.5, 2) * 99.95) / 100 + " <span class='glyphicon glyphicon-arrow-right' style='font-size: 14px; color: green;'></span> " + Math.floor(Math.pow(sup1Factor + 0.625, 2) * 99.95) / 100);
            setValue("sell", Math.floor(Math.pow(sup1Factor - 0.125, 2) * 100.05) / 100 + " <span class='glyphicon glyphicon-arrow-right' style='font-size: 14px; color: red;'></span> " + Math.floor(Math.pow(sup1Factor - 0.25, 2) * 100.05) / 100 + " <span class='glyphicon glyphicon-arrow-right' style='font-size: 14px; color: red;'></span> " + Math.floor(Math.pow(sup1Factor - 0.375, 2) * 100.05) / 100 + " <span class='glyphicon glyphicon-arrow-right' style='font-size: 14px; color: red;'></span> " + Math.floor(Math.pow(sup1Factor - 0.5, 2) * 100.05) / 100);
            for (var i = 1; i <= 8; i++) {
                document.getElementById("blankBlock" + i).style.backgroundColor = "#ff4444";
                setValue("blankBlock" + i, "&nbsp;")
            }
            var inclinationNumber = Math.floor((Math.sqrt(ltp) - Math.floor(Math.sqrt(ltp))) / 0.125) + 1;
            document.getElementById("blankBlock" + inclinationNumber).style.backgroundColor = "#ffbb33";
            document.getElementById("blankBlock" + inclinationNumber).style.color = "#ff4444";
            setValue("blankBlock" + inclinationNumber, ltp + "<br/>LTP")
	    
	    $("#sharesQuantityPriceResult").show();
	    
	    
	    
	    function setValue(id, val) {
            document.getElementById(id).innerHTML = val
        }
	    
	    
    	});
    	
});
		
    
    
    function validateFieldOne(id,value) {
		if ($('#' + id).val() == null || $('#' + id).val().length == 0 || $('#' + id).val() == 0) {
			var div = $('#' + id).closest("div");
			div.addClass("has-error");
			$('#' + id).attr("placeholder", value).focus();
			return false;
			/* $('#error1').html("<font color='red'>" + "Please Enter Email ID" + "</font>"); */
			/* $('#' + id).attr("placeholder", "Type your email here").focus(); */
			}
		else{
			var div = $('#' + id).closest("div");
			div.removeClass("has-error has-feedback");
			return true;
			/* $('#error1').html(""); */
		}
	}
    
    

    
    </script>
    
    
    
  </head>
  <body>
  <jsp:include page="menu.jsp"/>
  niftyPrice # 
  <span id="niftyPrice"></span>
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend><span style="font-size: 16px;">WD Gann geometric angles depicting Time&amp;Price,it is ideal balance between time and price exists when prices move identically to time, which occurs when the Gann angle is at 45 degrees.</span></legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Gann geometric angles predicting price movements# There are four cardinal crosses 90, 180, 270, 360</h3>
    </div>
    <div class="panel-body">
	<form> 
      <div class="form-group">
        <label for="text1" class="control-label">Enter Closed/Opening Price</label> 
        <div class="input-group">
        <div class="input-group-addon">
        	<i class="fa fa-dollar"></i>
      	</div> 
          <div class="input-group-addon">Closed/Opening Price i,e 10986</div> 
          <input id="text1" name="text1" placeholder="Best Result would be Closed Price 10986" type="text" class="form-control" onkeyup="return IsNumeric(event,'text11')" autocomplete="off" >
          <div id="error1"></div>
          <span id="text11" style="color: Red; display: none">* Numbers only, no special character and not in decimals</span>
        </div>
      </div>
     
     
      <div class="form-group">
        <button id="submitId" name="submit" type="button" class="btn btn-primary">Show Gann Strategy</button>
          <input type="reset" class="btn btn-danger" name="Reset" value="Reset" onclick="resetAll()">
      </div>
    </form>
    
    <div class="panel panel-success">
		    <div class="panel-heading">
		        <h3 class="panel-title">GANN Calculation Result : Intraday Trading Using Gann's Square of 9</h3>
		    </div>
		    <div class="panel-body">
		  		<span id="sharesQuantityPriceResult" style="display:none">


   <div class="panel-body"> <!-- panel-body  start-->
   <fieldset>
		<legend><span class="navyBlinker" style="font-size: 18px;">Recommendations:</span><span class="glyphicon glyphicon-arrow-right" style="font-size: 14px; color: green;"></span>
	<span style="font-size: 14px; color: green;">&nbsp;&nbsp;BUY</span>|<span style="font-size: 14px; color: red;">SELL&nbsp;&nbsp;</span>
	<span class="glyphicon glyphicon-arrow-left" style="font-size: 14px; color: red;"></span></legend>
	<ul class="list-group">
 				 <li class="list-group-item">
					 	<span style="font-size: 16px; color: green; text-align:center;">Buy At/Above: [ <span id="buyAt"></span> ]</span> &nbsp;&nbsp;
					 	
					 	<span style="font-size: 16px; color: red; text-align:center;">Stop Loss: [ <span id="buyStoploss"></span> ] </span>&nbsp;&nbsp;
					 	
					 	<span style="font-size: 18px; text-align:center;" class ="vwapRedBlinker"> Targets: [ <span id="buy"></span> ] </span> &nbsp;&nbsp;
					 	
					 	
					 	
  				</li>
  				
  				<li class="list-group-item">
  				
  					<span style="font-size: 16px; color: green; text-align:center;">Sell At/Below: [ <span id="sellAt"></span> ]</span> &nbsp;&nbsp;
					 	
					<span style="font-size: 16px; color: red; text-align:center;">Stop Loss: [ <span id="sellStoploss"></span> ] </span>&nbsp;&nbsp;
						
					<span style="font-size: 18px; color: #880e4f; text-align:center;" class ="vwapGreenBlinker"> Targets: [ <span id="sell"></span> ] </span> &nbsp;&nbsp;
					 	
  			
  				</li>
  				
		 </ul>
	</fieldset>
	
	<fieldset>
		<legend><span class="navyBlinker">WD GANN Support &amp; Resistance:</span><span class="glyphicon glyphicon-arrow-right" style="font-size: 14px; color: green;"></span>
	<span style="font-size: 14px; color: green;"></span>\|/<span style="font-size: 14px; color: red;"></span>
	<span class="glyphicon glyphicon-arrow-left" style="font-size: 14px; color: red;"></span></legend>
	
			<div class="table-responsive-md">
							<table class="table table-hover">
								<thead>
									<tr>
										<th style="font-size:16px;font-weight:bold;text-align:center;">Gann Resistance</th>
										<th style="font-size:16px;font-weight:bold;text-align:center;">R1</th>
										<th style="font-size:16px;font-weight:bold;text-align:center;">R2</th>
										<th style="font-size:16px;font-weight:bold;text-align:center;">R3</th>
										<th style="font-size:16px;font-weight:bold;text-align:center;">R4</th>
										<th style="font-size:16px;font-weight:bold;text-align:center;">R5</th>
												
									</tr>
								</thead>
								<tbody>
									<tr>
										
										<th style="font-size: 18px; color: red;text-align:center;">RESISTANCE</th>
										<th class="danger" style="font-size: 16px; color: red; text-align:center;"><span id="res1"></span></th>
										<th class="danger" style="font-size: 16px; color: red; text-align:center;"><span id="res2"></span></th>
										<th class="danger" style="font-size: 16px; color: red; text-align:center;"><span id="res3"></span></th>
										<th class="danger" style="font-size: 16px; color: red; text-align:center;"><span id="res4"></span></th>
										<th class="danger" style="font-size: 16px; color: red; text-align:center;"><span id="res5"></span></th>
									</tr>
									
								</tbody>
								
								<thead>
									<tr>
										<th style="font-size:16px;font-weight:bold;text-align:center;">Gann Support</th>
										<th style="font-size:16px;font-weight:bold;text-align:center;">S1</th>
										<th style="font-size:16px;font-weight:bold;text-align:center;">S2</th>
										<th style="font-size:16px;font-weight:bold;text-align:center;">S3</th>
										<th style="font-size:16px;font-weight:bold;text-align:center;">S4</th>
										<th style="font-size:16px;font-weight:bold;text-align:center;">S5</th>
												
									</tr>
								</thead>
								<tbody>
									<tr>
										
										<th style="font-size: 18px; color: green; text-align:center;">SUPPORT</th>
										<th class="success" style="font-size: 16px; color: green; text-align:center;"><span id="sup1"></span></th>
										<th class="success" style="font-size: 16px; color: green; text-align:center;"><span id="sup2"></span></th>
										<th class="success" style="font-size: 16px; color: green; text-align:center;"><span id="sup3"></span></th>
										<th class="success" style="font-size: 16px; color: green; text-align:center;"><span id="sup4"></span></th>
										<th class="success" style="font-size: 16px; color: green; text-align:center;"><span id="sup5"></span></th>
									</tr>
									
								</tbody>
								
							</table>
			</div>
	
				</fieldset>





				<table class="table" border="1" cellspacing="0" cellpadding="5" bgcolor="#FFF9EE"  style="width:800px;table-layout:fixed">
				<tbody><tr>
					<td colspan="7" style="font-size:18px;color:white;text-align:center;" bgcolor="#4285F4 ">Gann Square of 9 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				 
				</tr>
				<tr bgcolor="#ff4444">
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#00C851;" id="block19">11077.56</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;">&nbsp;</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;">&nbsp;</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#4285F4 ;" id="block20">11103.89</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;">&nbsp;</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;">&nbsp;</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#00C851;" id="block21">11130.25</td>
				</tr>
				<tr bgcolor="#ff4444">
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;">&nbsp;</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#00C851;" id="block11">10868.06</td>
					<td style="width: 55px; height: 50px; text-align: center; vertical-align: middle; font-size: 16px; font-weight: bold; color: white; background-color: #ff4444;" id="blankBlock3">&nbsp;</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#4285F4;" id="block12">10894.14</td>
					<td style="width: 55px; height: 50px; text-align: center; vertical-align: middle; font-size: 16px; font-weight: bold; color: white; background-color: #ff4444;" id="blankBlock4">&nbsp;</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#00C851;" id="block13">10920.25</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;">&nbsp;</td>
				</tr>
				<tr bgcolor="#ff4444">
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;">&nbsp;</td>
					<td style="width: 55px; height: 50px; text-align: center; vertical-align: middle; font-size: 16px; font-weight: bold; color: white; background-color: #ff4444;" id="blankBlock2">&nbsp;</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#00C851;" id="block3">10660.56</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#4285F4 ;" id="block4">10686.39</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#00C851;" id="block5">10712.25</td>
					<td style="width: 55px; height: 50px; text-align: center; vertical-align: middle; font-size: 16px; font-weight: bold; color: white; background-color: #ff4444;" id="blankBlock5">&nbsp;</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;">&nbsp;</td>
				</tr>
				<tr bgcolor="#ff4444">
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#4285F4 ;" id="block18">11051.26</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#4285F4 ;" id="block10">10842.01</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#4285F4 ;" id="block2">10634.76</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#880e4f;" id="block1">10609</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#4285F4 ;" id="block6">10738.14</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#4285F4 ;" id="block14">10946.39</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#4285F4 ;" id="block22">11156.64</td>
				</tr>
				<tr bgcolor="#ff4444">
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;">&nbsp;</td>
					<td style="width: 55px; height: 50px; text-align: center; vertical-align: middle; font-size: 16px; font-weight: bold; color: white; background-color: #ff4444;" id="blankBlock1">&nbsp;</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#00C851;" id="block9">10816</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#4285F4 ;" id="block8">10790.01</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#00C851;" id="block7">10764.06</td>
					<td style="width: 55px; height: 50px; text-align: center; vertical-align: middle; font-size: 16px; font-weight: bold; color: #ff4444; background-color: #ffbb33;" id="blankBlock6">10956<br>LTP</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;">&nbsp;</td>
				</tr>
				<tr bgcolor="#ff4444">
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;">&nbsp;</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#00C851;" id="block17">11025</td>
					<td style="width: 55px; height: 50px; text-align: center; vertical-align: middle; font-size: 16px; font-weight: bold; color: white; background-color: #ff4444;" id="blankBlock8">&nbsp;</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#4285F4 ;" id="block16">10998.76</td>
					<td style="width: 55px; height: 50px; text-align: center; vertical-align: middle; font-size: 16px; font-weight: bold; color: white; background-color: #ff4444;" id="blankBlock7">&nbsp;</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#00C851;" id="block15">10972.56</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;">&nbsp;</td>
				</tr>
				<tr bgcolor="#ff4444">
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#00C851;" id="block25">11236</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;">&nbsp;</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;">&nbsp;</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#4285F4 ;" id="block24">11209.51</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;">&nbsp;</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;">&nbsp;</td>
					<td style="width:55px;height:50px;text-align:center;vertical-align:middle;font-size:16px;font-weight:bold;color:white;background-color:#00C851;" id="block23">11183.06</td>
				</tr>
				
			</tbody></table>
			
				 
			
		  		</span> 
		</div>
		  		
    </div>

	</div>
	</div>
	</fieldset>
</body>
</html>