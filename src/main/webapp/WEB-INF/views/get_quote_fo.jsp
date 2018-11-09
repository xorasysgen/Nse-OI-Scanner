<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!doctype html>
<html>
  <head>
    <title>NSE Future Search</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
<jsp:include page="menu.jsp"/>
  
<script type="text/javascript">
$(document).ready(function() {
$("#loadContent").change(function() {
	console.log("input value=" + this.value);
	  var data=this.value;
	$.ajax({
		type:'Get',
		url: 'derivative/nse/coc/'+data,
		success: function(result){
			//console.log("result value=" + result);
			
			var companyName = result.companyName;
			companyName ="<span class='vwapRedBlinker' style='font-weight: bold; font-size: 14px;'>" + companyName +"</span>"
			var lastUpdateTime = result.lastUpdateTime;
			var annualisedVolatility = result.data[0].annualisedVolatility;
			var vwap=result.data[0].vwap;
			var underlyingValue=result.data[0].underlyingValue;
			var highPrice=result.data[0].highPrice;
			var dailyVolatility=result.data[0].dailyVolatility;
			var bestBuyCoC=result.data[0].bestBuy;
			var bestSellCoC=result.data[0].bestSell;
			var ltpCoc=result.data[0].ltp;
			var marketLot=result.data[0].marketLot;
			var marketWidePositionLimits=result.data[0].marketWidePositionLimits;
			var clientWisePositionLimits=result.data[0].clientWisePositionLimits;
			var underlying=result.data[0].underlying;
			var change=result.data[0].change;
			var pChange=result.data[0].pChange;
			var changeinOpenInterest=result.data[0].changeinOpenInterest.replace(/,/g, "");
			var pchangeinOpenInterest=result.data[0].pchangeinOpenInterest;
			var openInterest=result.data[0].openInterest.replace(/,/g, "");
			var numberOfContractsTraded=result.data[0].numberOfContractsTraded;
			var closePrice=result.data[0].closePrice;
			var lastPrice=result.data[0].lastPrice;
			
			if(openInterest>=0){
				openInterest= "<span style='color: green; font-weight: bold; font-size: 14px;'>" + openInterest+"</span>"
			+ "<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
			}
			else{
				openInterest= "<span style='color: red; font-weight: bold; font-size: 14px;'>" + openInterest+"</span>"
				+ "<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
			}
			
			if(changeinOpenInterest>=0){
				changeinOpenInterest= "<span style='color: green; font-weight: bold; font-size: 14px;'>" + changeinOpenInterest+"</span>"
			+ "<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
			}
			else{
				changeinOpenInterest= "<span style='color: red; font-weight: bold; font-size: 14px;'>" + changeinOpenInterest+"</span>"
				+ "<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
			}
			
			
			
			if(pchangeinOpenInterest>=0){
				pchangeinOpenInterest= "<span style='color: green; font-weight: bold; font-size: 14px;'>" + pchangeinOpenInterest+"%</span>"
			+ "<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
			}
			else{
				pchangeinOpenInterest= "<span style='color: red; font-weight: bold; font-size: 14px;'>" + pchangeinOpenInterest+"%</span>"
				+ "<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
			}
			
			
			
			
			if(change>=0.0){
				change= "<span style='color: green; font-weight: bold; font-size: 14px;'>" + change+"</span>"
			+ "<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
			}
			else{
				change= "<span style='color: red; font-weight: bold; font-size: 14px;'>" + change+"</span>"
				+ "<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
			}
			
			
			
			if(pChange>=0.0){
				pChange= "<span style='color: green; font-weight: bold; font-size: 14px;'>" + pChange+"%</span>"
			+ "<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span>";
			}
			else{
				pChange= "<span style='color: red; font-weight: bold; font-size: 14px;'>" + pChange+"%</span>"
				+ "<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span>";
			}
			
			
			
			if(lastPrice>=vwap){
				vwap= "<span style='color: green; font-weight: bold; font-size: 14px;'>" + vwap+"</span>"
			+ "<span style='color: #00c853;font-size: 14px;' class='glyphicon glyphicon-triangle-top'></span> <span style='color: #00c853;font-size: 14px;'>Buy</span>"
			
			}
			else{
				vwap= "<span style='color: red; font-weight: bold; font-size: 14px;'>" + vwap+"</span>"
				+ "<span style='color: #ff4444;font-size: 14px;' class='glyphicon glyphicon-triangle-bottom'></span> <span style='color: #ff4444;font-size: 14px;'>Sell</span>"
			}
			
			lastPrice= "<span class='navyBlinker' style='font-weight: bold; font-size: 14px;'>" + lastPrice +"</span>"
			
			if(bestBuyCoC>=0){
				bestBuyCoC= "<span style='color: green; font-weight: bold; font-size: 14px;'>" + bestBuyCoC+"</span>";
			}
			else{
				bestBuyCoC= "<span style='color: red; font-weight: bold; font-size: 14px;'>" + bestBuyCoC+"</span>";
			}
			
			
			if(bestSellCoC>=0){
				bestSellCoC= "<span style='color: green; font-weight: bold; font-size: 14px;'>" + bestSellCoC+"</span>";
			}
			else{
				bestSellCoC= "<span style='color: red; font-weight: bold; font-size: 14px;'>" + bestSellCoC+"</span>";
			}
			
			if(ltpCoc>=0){
				ltpCoc= "<span style='color: green; font-weight: bold; font-size: 14px;'>" + ltpCoc+"</span>";
			}
			else{
				ltpCoc= "<span style='color: red; font-weight: bold; font-size: 14px;'>" + ltpCoc+"</span>";
			}
			
	  		$("#companyName").html(companyName);
	  		$("#lastUpdateTime").html(lastUpdateTime);
	  		$("#annualisedVolatility").html(annualisedVolatility);
	  		$("#vwap").html(vwap);
	  		$("#underlyingVal").html(underlyingValue);
	  		$("#bestBuyCoC").html(bestBuyCoC);
	  		$("#bestSellCoC").html(bestSellCoC);
	  		$("#ltpCoc").html(ltpCoc);
	  		$("#marketLot").html(marketLot);
	  		$("#dailyVolatility").html(dailyVolatility);
	  		$("#marketWidePositionLimits").html(marketWidePositionLimits);
	  		$("#clientWisePositionLimits").html(clientWisePositionLimits);
	  		$("#underlying").html(underlying);
	  		$("#change").html(change);
	  		$("#pChange").html(pChange);
	  		$("#openInterest").html(openInterest);
	  		$("#changeinOpenInterest").html(changeinOpenInterest);
	  		$("#pchangeinOpenInterest").html(pchangeinOpenInterest);
	  		$("#numberOfContractsTraded").html(numberOfContractsTraded);
	  		$("#closePrice").html(closePrice);
	  		$("#lastPrice").html(lastPrice);
	  		
	  		
	  		
		
	}	
	})
});
});

</script>

</head>
<body>
	<div class="container ">
		<form:form class="form-horizontal" method="post"	action="${pageContext.request.contextPath}${actionUri}"	modelAttribute="stockName">
			<h3 class="form-signin-heading form-group col-sm-8">Company Name#[ <span id="companyName"></span> ]<br></h3>
			

	<div class="form-group col-sm-8">
			  <label for="country">Stock Future Scrutiny</label> 
			 <form:select path="stockName" class="form-control" id="loadContent">
			  		<form:option value="-1" label="Please Select Future and Option Stock"  selected="selected"/>
					<form:options items="${stockList}" />
			</form:select>
			  
		</div><br>
		<div class="form-group col-sm-8">
		
			<pre>		
			Underlying---------------[ <span id="underlying"></span> ]
			LastUpdateTime-----------[ <span id="lastUpdateTime"></span> ]
			VWAP---------------------[ <span id="vwap"></span> ] 
			LTP Future---------------[ <span id="lastPrice"></span> ] 
			LTP Cash-----------------[ <span id="underlyingVal"></span> ] 
			Change-------------------[ <span id="change"></span> ] 
			%Change------------------[ <span id="pChange"></span> ] 
			BestBuyCoC---------------[ <span id="bestBuyCoC"></span> ] 
			BestSellCoC--------------[ <span id="bestSellCoC"></span> ] 
			LtpCoc-------------------[ <span id="ltpCoc"></span> ] 
			ClosePrice---------------[ <span id="closePrice"></span> ] 
			OpenInterest-------------[ <span id="openInterest"></span> ] 
			ChangeinOpenInterest-----[ <span id="changeinOpenInterest"></span> ] 
			%ChangeinOpenInterest----[ <span id="pchangeinOpenInterest"></span> ] 
			NumberOfContractsTraded--[ <span id="numberOfContractsTraded"></span> ] 
			MarketWidePositionLimits-[ <span id="marketWidePositionLimits"></span> ] 
			ClientWisePositionLimits-[ <span id="clientWisePositionLimits"></span> ] 
			AnnualisedVolatility-----[ <span id="annualisedVolatility"></span> ] 
			DailyVolatility----------[ <span id="dailyVolatility"></span> ]
			MarketLot----------------[ <span id="marketLot"></span> ] 
			</pre>
	</div>
	
	


		</form:form>
		

	</div>
	<!-- /container -->
<jsp:include page="footer.jsp" />	
</body>
</html>