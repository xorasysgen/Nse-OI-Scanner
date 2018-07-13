<!doctype html>
<html>
  <head>
    <title>Average Cost Calculator</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<jsp:include page="js_css_include.jsp"/>

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
 
    
    function calcAvgPrice() {
    	$(document).ready(function(){
               	var share_quantity_bought=$("#text1").val();
            	var share_bought_price=$("#text2").val();
            	var laterBuyShares=$("#text3").val();
            	var laterBuySharePrice=$("#text4").val();
		var totalShares = (share_quantity_bought*1) + (laterBuyShares*1);
		var finalPrice = (((share_quantity_bought*1)*(share_bought_price*1))+((laterBuyShares*1)*(laterBuySharePrice*1))) / totalShares;
		var finalPrice=Math.round(finalPrice*100)/100;
		console.log("total shares Bought#" + totalShares);
	    console.log("shares Bought At Price#" + finalPrice);
	    var text0="You have "+ "<span class='blinking1' style='color: #00c853; font-weight: bold; font-size: 16px;'>[ " +  totalShares +
	    " ]</span>"+ " Shares at an average price of Rs " + 
	    "<span class='blinking1' style='color: #00c853; font-weight: bold; font-size: 14px;'>[ " + finalPrice + " ]</span>";
	    
	    $("#sharesQuantityPriceResult").html(text0);
        });
		
	} 
    
    </script>
    
  </head>
  <body>
  <jsp:include page="menu.jsp"/>
  
  
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>Average Cost Calculator - You can use an average cost calculator to determine the average share price you paid for a security with multiple buys. This can be handy when averaging in on a stock purchase or determining your cost basis</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Average Cost Calculator</h3>
    </div>
    <div class="panel-body">
	<form> 
      <div class="form-group">
        <label for="text1" class="control-label">No of Shares</label> 
        <div class="input-group">
          <div class="input-group-addon">Shares Bought Quantity</div> 
          <input id="text1" name="text1" placeholder="150" type="text" required="required" class="form-control" onkeyup="return IsNumeric(event,'text11')" autocomplete="off">
          <span id="text11" style="color: Red; display: none">* Numbers only, no special character and not in decimals</span>
        </div>
      </div>
      <div class="form-group">
        <label for="text2" class="control-label">Bought Price</label> 
        <div class="input-group">
          <div class="input-group-addon">Shares Bought Price</div> 
          <input id="text2" name="text2" placeholder="178.55" type="text" required="required" class="form-control" onkeyup="return IsNumeric(event,'text22')" autocomplete="off">
           <span id="text22" style="color: Red; display: none">* Numbers only, no special character and not in decimals</span>
        </div>
      </div>
      <div class="form-group">
        <label for="text3" class="control-label">Later You Buy</label> 
        <div class="input-group">
          <div class="input-group-addon">Shares Buy Quantity</div> 
          <input id="text3" name="text3" placeholder="100" type="text" required="required" class="form-control" onkeyup="return IsNumeric(event,'text33')" autocomplete="off">
          <span id="text33" style="color: Red; display: none">* Numbers only, no special character and not in decimals</span>
        </div>
      </div>
      <div class="form-group">
        <label for="text4" class="control-label">Later Buy Price</label> 
        <div class="input-group">
          <div class="input-group-addon">Shares Bought At Price</div> 
          <input id="text4" name="text4" placeholder="140.25" type="text" required="required" class="form-control" onkeyup="return IsNumeric(event,'text44')" autocomplete="off">
          <span id="text44" style="color: Red; display: none">* Numbers only, no special character and not in decimals</span>
        </div>
      </div> 
      <div class="form-group">
        <button name="submit" type="button" class="btn btn-primary" onclick="calcAvgPrice()">Calculate Shares Average Price</button>
          <input type="reset" class="btn btn-dangar" name="Reset" value="reset" onclick="resetAll()">
      </div>
    </form>
    
    <div class="panel panel-success">
    <div class="panel-heading">
        <h3 class="panel-title">Calculation Result</h3>
    </div>
    <div class="panel-body">
  <span id="sharesQuantityPriceResult"></span> 
    </div>
    </div>
    
  </body>

		</div>
	</div>
	</fieldset>
</body>
</html>