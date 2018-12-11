<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html>
<head>
<title>Boot Heuristic F&amp;O Equity Analysis Platform - The Trading and Investing Engine that simplify Trades-JSR101-1.8.5.RELEASE</title>
<meta charset="utf-8">
<meta name="viewport"	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<!-- begins google chart js -->
<script src="js/logic.js"></script>
<!-- end google chart js -->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<!-- begins google chart js -->
<script src="js/google_pie.js"></script>
<!-- end google chart js -->
<jsp:include page="js_css_include.jsp" />
<style type="text/css">
#chart_wrap {
    position: relative;
    padding-bottom: 25%;
    height: 0;
    overflow:visible;
}

#chart_div {
    position: absolute;
    top: 0;
    left: 0;
    width:100%;
    height:100%;
}

</style>
<!-- high level configuration don't change from here -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>  <!-- jquery lib -->
<script src="js/service_caller_logic_script.js"></script>
<script src="js/additional_service_caller_logic_script.js"></script>
<script src="js/wd.js"></script>
<script src="js/zerodha.js"></script>
<%-- <jsp:include page="script_support_js.jsp" /> --%>
<!-- high level configuration don't change till here -->

<style type="text/css">
.time-frame {
 
    width: 300px;
    font-family: Arial;
}

.time-frame > div {
    width: 100%;
    text-align: center;
}

#date-part {
    font-size: 1.2em;
}
#time-part {
    font-size: 2em;
}

</style>


<!-- <script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script> -->
</head>
<body>

<% response.addHeader("Refresh","300"); %>
<jsp:include page="menu.jsp" />
<fieldset style="margin-left:28px;margin-right:28px;">
<legend>
  
 <span style="color: #6c757d; font-size: 16px;">Welcome [ <span style="color:#007E33;"><strong> <sec:authentication property="principal.username" /></strong></span> ] Logged as a <span style="color:#4a148c;"> <sec:authentication property="principal.authorities"/> </span> #The I<span style="color: orange; font-size: 16px;">&amp;</span>T Engine Powered By</span> <span style="color:#6db33f;">Boot-Heuristic</span><span class="glyphicon glyphicon-leaf" style="color:#6db33f;"></span>&nbsp;<sup><small><span class="label label-success">JSR101-1.8.5.RELEASE</span></small></sup><br>
<sup><span style="color: #17a2b8; font-weight: bold; font-size: 12px;"> #Last sync : <span id="txt"></span></span>  
		&nbsp;<span style="color: #17a2b8; font-weight: bold; font-size: 12px;">#AutoSync : </span><span class="pink" style="color: #ff4444; font-weight: bold; font-size: 12px;"><span id="timer"></span></span>&nbsp;<span class="glyphicon glyphicon-time" style="font-size: 12px; color: green;"></span> <small><span style="color: #6c757d; font-weight: bold; font-size: 12px;" id="date_time"></span></small></sup>
		<sup><i><span id="mktStatus"></span></i></sup>
		<sup><i><span id="nextTradingDate"></span></i></sup><br>
		<sub>
		<span style="color: #9c27b0; font-weight: bold; font-size: 15px;">
     NIFTY50 [ <span id="niftyPrice"></span> <sup><span id="niftyPriceChangePercentage"></span>&nbsp;&nbsp;<span id="niftyPriceChange"></span>) </sup>] &nbsp;
     BANK NIFTY [ <span id="bankNiftyPrice"></span><sup><span id="bankNiftyPriceChangePercentage"></span>&nbsp;&nbsp;<span id="bankNiftyPriceChange"></span></sup> ]&nbsp;
    
     <span id="Dow30Name"></span> [ <span id="Dow30Price"></span><sup><span id="Dow30ChangePercentage"></span>&nbsp;&nbsp;<span id="Dow30PriceChange"></span></sup> ]&nbsp;
     <span id="USDINRName"></span> [ <span id="USDINR"></span><sup><span id="USDINRchangePercentage"></span>&nbsp;&nbsp;<span id="USDINRChange"></span></sup> ]&nbsp;
     <span id="BrentOilName"></span> [ <span id="BrentOilPrice"></span><sup><span id="BrentOilChangePercentage"></span>&nbsp;&nbsp;<span id="BrentOilPriceChange"></span></sup> ]
      
     </span>
     </sub>
</legend>
<!-- <fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
		<legend><span style="color: #17a2b8;">Market Trend - Overall Advances/Declines Ratio</span></legend> -->
		
            <script type="text/javascript">window.onload = date_time('date_time');</script>
            <script type="text/javascript">window.onload = startTime();</script>
			<script type="text/javascript">window.onload = date_time_auto_sync();</script>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Market Breadth &amp; Trend
        <span class="glyphicon glyphicon-resize-small" style="font-size: 16px; color: #ffbb33;"></span> &nbsp; IndiaVix LTP# [&nbsp;<span style="color: #00e676;" id="IndiaVix"></span>&nbsp;] IndiaVix Change#[&nbsp;<span style="color: #00e676;" id="IndiaVixPerChange"></span>&nbsp;] <span class="glyphicon glyphicon-resize-small" style="font-size: 16px; color: #ffbb33;"></span>
        Nifty Put-Call-Ratio (PCR)# [&nbsp;<span style="color: #00e676;" id="OptionsNiftyPCR"></span>&nbsp;<span class="nobr">]
      <span class="supsub"><span style="color: #00e676;"><strong>0.83</strong></span><br /><span style="color: #ffc107;"><strong>1.85&nbsp; exp#2.18-2.37</strong></span></span></span>
      &nbsp; <span class="glyphicon glyphicon-resize-small" style="font-size: 16px; color: #ffbb33;"></span> &nbsp; 
      Premium<span class="nobr">
      <span class="supsub"><span style="color: white;">N# </span><strong><span id="niftyPreDis"></span></strong><br />
      <span style="color: white;">BN# </span><strong><span id="bankniftyPreDis"></strong></span></span>
      
        </h3>
    </div>
<div ng-app="myApp" ng-controller="GreetingController">
    <div class="panel-body">
			    
			<!-- <div class="container"> -->
			    <div class="row">
			        <div class="col-md-4">
							TOTAL STOCKS &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<span style="color: #1976d2; font-weight: bold; font-size: 18px; display:inline-block; width:TWO-TAB-WIDTH;">  {{getTotal()}} </span>  <br>
							           
							POSITIVE(+)  &nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-thumbs-up" style="font-size: 18px; color: #00e676;"></span>&nbsp;&nbsp;&nbsp;&nbsp;
							<span style="color: #00e676; font-weight: bold; font-size: 18px; ">{{ getAdvanced() }} </span> <br>
							
							NEGATIVE(-)   &nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-thumbs-down" style="font-size: 18px; color: #b71c1c;"></span>&nbsp;&nbsp;&nbsp;&nbsp;
							<span  style="color: #b71c1c; font-weight: bold; font-size: 18px; ">{{getDeclines()}} </span><br>
							
							UNCHANGED &nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-hand-right" style="font-size: 18px; color: orange;"></span>
							<span style="color: orange; font-weight: bold; font-size: 18px;">&nbsp;&nbsp;{{getUnchange()}} </span> <br>
							
							OVERALL ADR &nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-random" style="font-size: 16px; color: #4a148c;"></span>
							<span style="color: #4a148c; font-weight: bold; font-size: 18px;">&nbsp; {{getAdr() | limitTo : 4 : 0}} </span> <br>
							
							OVERALL BULLS
							<span class="glyphicon glyphicon-bullhorn" style="font-size: 18px; color: #00e676;"></span>
							<span style="color: #00e676; font-weight: bold; font-size: 18px;">&nbsp; {{getBulls() | limitTo : 4 : 0 }}% </span> <br>
							
							OVERALL BEARS 
							<span class="glyphicon glyphicon-bullhorn" style="font-size: 18px; color: #d50000;"></span>
							<span style="color: #d50000; font-weight: bold; font-size: 18px;">&nbsp; {{getBears() | limitTo : 4 : 0}}% </span> <br>
							
							OVERALL TREND # <span style="color: #00b8d4; font-weight: bold; font-size: 18px; ">  {{ getTrend() }}  </span> 
			      </div>
			        
        
        
		        <div class="col-md-4">
		            <div ng-app="myApp" ng-controller="NiftyController">
		            
					TOTAL STOCKS &nbsp;&nbsp;&nbsp;&nbsp;
					<span style="color: #1976d2; font-weight: bold; font-size: 18px; display:inline-block; width:TWO-TAB-WIDTH;">  &nbsp;50 </span>  <br>
					
					POSITIVE(+)  &nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-thumbs-up" style="font-size: 18px; color: #00e676;"></span>&nbsp;&nbsp;&nbsp;&nbsp;
					<span style="color: #00e676; font-weight: bold; font-size: 18px; "> {{ getNiftyAdvanced() }} </span> <br>
					
					NEGATIVE(-)  &nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-thumbs-down" style="font-size: 18px; color: red;"></span>&nbsp;&nbsp;&nbsp;&nbsp;
					<span  style="color: #b71c1c; font-weight: bold; font-size: 18px; "> {{ getNiftyDeclines() }} </span><br>
					
					UNCHANGED &nbsp;&nbsp;<span class="glyphicon glyphicon-hand-right" style="font-size: 18px; color: orange;"></span>
					<span style="color: orange; font-weight: bold; font-size: 18px;">&nbsp;&nbsp; {{ getNiftyUnchange() }} </span> <br>
					
					NIFTY ADR &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<span class="glyphicon glyphicon-random" style="font-size: 16px; color: #4a148c;"></span>
					<span style="color: #4a148c; font-weight: bold; font-size: 18px;">&nbsp; {{getNiftyAdr() | limitTo : 4 : 0 }} </span> <br>
					
					NIFTY BULLS &nbsp;&nbsp;
					<span class="glyphicon glyphicon-bullhorn" style="font-size: 18px; color: #00e676;"></span>
							<span style="color: #00e676; font-weight: bold; font-size: 18px;">&nbsp; {{getNiftybulls() | limitTo : 4 : 0 }}% </span> <br>
							
					NIFTY BEARS &nbsp;
					<span class="glyphicon glyphicon-bullhorn" style="font-size: 18px; color: #d50000;"></span>
					<span style="color: #d50000; font-weight: bold; font-size: 18px;">&nbsp; {{getNiftyBear() | limitTo : 4 : 0}}% </span> <br>
					
					NIFTY TREND #<span style="color: #00b8d4; font-weight: bold; font-size: 18px; ">  {{ getNiftyTrend() }}  </span>
					 
					</div>
					
		        </div>
        
       
        
			  <div class="col-md-4" >
			        <span class="border-top border-dark">
			            <div ng-app="myApp" ng-controller="BankNiftyController">
			            
						TOTAL STOCKS &nbsp;&nbsp;&nbsp;&nbsp;
						<span style="color: #1976d2; font-weight: bold; font-size: 18px; display:inline-block; width:TWO-TAB-WIDTH;">  12 </span>  <br>
						
						POSITIVE(+) &nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-thumbs-up" style="font-size: 18px; color: #00e676;"></span>&nbsp;&nbsp;&nbsp;&nbsp;
						<span style="color: #00e676; font-weight: bold; font-size: 18px; "> {{ getBankNiftyAdvanced() }} </span> <br>
						
						NEGATIVE(-)  &nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-thumbs-down" style="font-size: 18px; color: #b71c1c;"></span>&nbsp;&nbsp;&nbsp;&nbsp;
						<span  style="color: #b71c1c; font-weight: bold; font-size: 18px; "> {{ getBankNiftyDeclines() }} </span><br>
						
						UNCHANGED &nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-hand-right" style="font-size: 18px; color: orange;"></span>
						<span style="color: orange; font-weight: bold; font-size: 18px;">&nbsp;&nbsp; {{ getBankNiftyUnchange() }} </span> <br>
						
						BANKNIFTY ADR&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-random" style="font-size: 16px; color: #4a148c;"></span>
							<span style="color: #4a148c; font-weight: bold; font-size: 18px;">&nbsp;&nbsp;&nbsp; {{getBankNiftyAdr() | limitTo : 4 : 0 }} </span> <br>
							
						BANKNIFTY BULLS &nbsp;<span class="glyphicon glyphicon-bullhorn" style="font-size: 18px; color: #00e676;"></span>
							<span style="color: #00e676; font-weight: bold; font-size: 18px;">&nbsp; {{getBankNiftybulls() | limitTo : 4 : 0 }}% </span> <br>
							
						BANKNIFTY BEARS <span class="glyphicon glyphicon-bullhorn" style="font-size: 18px; color: #d50000;"></span>
							<span style="color: #d50000; font-weight: bold; font-size: 18px;">&nbsp; {{getBankNiftyBear() | limitTo : 4 : 0}}% </span> <br>
						
						
						BANKNIFTY TREND #<span style="color: #00b8d4; font-weight: bold; font-size: 18px; ">  {{ getBankNiftyTrend() }}  </span>
						 
						</div>
						</span>
			 </div>
			 
			 
</div>
 <br>   
 <span class="glyphicon glyphicon-info-sign" style="color: #40c4ff;"></span>&nbsp;Advance/Decline Ratio ADR #if ADR>=1.25 then <span style="color: #004d40; font-weight: bold;">+ve(Bullish)</span>	Otherwise <span style="color: #ff3d00; font-weight: bold;">-ve(Bearish)</span><br>
 <span class="glyphicon glyphicon-info-sign" style="color: #40c4ff;"></span>&nbsp;Low IndiaVIX <span style="color: #00e676;" id="IndiaVixInfo"></span> indicates <span style="color: #004d40; font-weight: bold;">stability</span> in the market while higher value indicated <span style="color: #ff3d00; font-weight: bold;">stress, fear and anxiety.</span>

      
      <div class="panel panel-info">
		    <div class="panel-heading">
		        <h3 class="panel-title">Nifty and Bank Nifty Future <span class='blinking'><span class="glyphicon glyphicon-eye-open" style="font-size: 16px; color: #0d47a1;"></span></span></h3>
		    </div>
		    <div class="panel-body"> <!-- panel-body  start-->
				<span style="color: #9c27b0; font-weight: bold; font-size: 14px;">
			<ul class="list-group">
 				 <li class="list-group-item">
					 	NIFTY50-FUT [ <span id="niftyFUTLastPrice"></span><sup><span id="niftyFUTPChange"></span>&nbsp;&nbsp;<span id="niftyFUTChange"></span></sup> ]
					 	&nbsp;&nbsp;  VWAP [ <span id="niftyvwap"></span> ] &nbsp;&nbsp;
						&nbsp; Signal [ <span id="niftyFUTTrend"></span> ] &nbsp;&nbsp;&nbsp;
					 	[ <span id="niftyOpen"></span><span class="nobr"> ] <span class="supsub"><span style="color: #00e676; font-size: 10px;"><strong><span id="niftyHigh"></span></strong></span><br /><span style="color: #ffc107; font-size: 10px;"><strong><span id="niftyLow"></span></strong></span></span></span>
					 	Prev Close[ <span id="niftyPreviousClose"></span> ] &nbsp;&nbsp;&nbsp;
						NIFTY50-OI [ <span id="NiftyFUTOpenInterest"></span><sup><span id="NiftyFUTPchangeinOpenInterest"></span>&nbsp;&nbsp;<span id="NiftyFUTChangeinOpenInterest"></span></sup> ]
						 
  				</li>
  				
  				<li class="list-group-item">
  						BANK NIFTY-FUT [ <span id="bankNiftyFUTLastPrice"></span><sup><span id="bankNiftyFUTPChange"></span>&nbsp;&nbsp;<span id="bankNiftyFUTChange"></span></sup> ]
  						&nbsp;&nbsp; VWAP [ <span id="bankNiftyvwap"></span> ]
						&nbsp;&nbsp; Signal [ <span id="bankNiftyFUTTrend"></span> ] &nbsp;&nbsp;&nbsp;
						[ <span id="bankNiftyOpen"></span><span class="nobr"> ] <span class="supsub"><span style="color: #00e676; font-size: 10px;"><strong><span id="bankNiftyHigh"></span></strong></span><br /><span style="color: #ffc107; font-size: 10px;" ><strong><span id="bankNiftyLow"></span></strong></span></span></span>
						Prev Close[ <span id="bankNiftyPreviousClose"></span> ]&nbsp;&nbsp;&nbsp;
						BANK NIFTY-OI [ <span id="bankNiftyFUTOpenInterest"></span><sup><span id="bankNiftyFUTPchangeinOpenInterest"></span>&nbsp;&nbsp;<span id="bankNiftyFUTChangeinOpenInterest"></span></sup> ]
  				</li>
  				
  				<li class="list-group-item">
  					USDINR&nbsp;&nbsp;
		     		Expiry [ <span id="currencyExpiryDate"></span> ]&nbsp;
		     		USDINR-FUT [ <span id="currencyLtp"></span><sup><span id="currencyChangePercentage"></span>&nbsp;&nbsp;<span id="currencyChangeValue"></span></sup> ]&nbsp; 
		     		Currency Trend# [ <span id="currencyTrend"></span> ] 
		     		<a href="https://in.finance.yahoo.com/chart/%5ENSEI#eyJpbnRlcnZhbCI6ImRheSIsInBlcmlvZGljaXR5IjoxLCJjYW5kbGVXaWR0aCI6MTkuNDc3NjExOTQwMjk4NTEsInZvbHVtZVVuZGVybGF5Ijp0cnVlLCJjcm9zc2hhaXIiOnRydWUsImNoYXJ0VHlwZSI6ImxpbmUiLCJleHRlbmRlZCI6ZmFsc2UsIm1hcmtldFNlc3Npb25zIjp7fSwiYWdncmVnYXRpb25UeXBlIjoib2hsYyIsImNoYXJ0U2NhbGUiOiJsb2ciLCJwYW5lbHMiOnsiY2hhcnQiOnsicGVyY2VudCI6MSwiZGlzcGxheSI6Il5OU0VJIiwiY2hhcnROYW1lIjoiY2hhcnQiLCJ0b3AiOjB9fSwic2V0U3BhbiI6eyJtdWx0aXBsaWVyIjozLCJiYXNlIjoibW9udGgiLCJwZXJpb2RpY2l0eSI6eyJwZXJpb2QiOjEsImludGVydmFsIjoiZGF5In19LCJsaW5lV2lkdGgiOjIsInN0cmlwZWRCYWNrZ3JvdWQiOmZhbHNlLCJldmVudHMiOmZhbHNlLCJjb2xvciI6IiMyYmJjZmYiLCJzeW1ib2xzIjpbeyJzeW1ib2wiOiJeTlNFSSIsInN5bWJvbE9iamVjdCI6eyJzeW1ib2wiOiJeTlNFSSJ9LCJwZXJpb2RpY2l0eSI6MSwiaW50ZXJ2YWwiOiJkYXkiLCJzZXRTcGFuIjp7Im11bHRpcGxpZXIiOjMsImJhc2UiOiJtb250aCIsInBlcmlvZGljaXR5Ijp7InBlcmlvZCI6MSwiaW50ZXJ2YWwiOiJkYXkifX19LHsic3ltYm9sIjoiSU5SPVgiLCJzeW1ib2xPYmplY3QiOnsic3ltYm9sIjoiSU5SPVgifSwicGVyaW9kaWNpdHkiOjEsImludGVydmFsIjoiZGF5Iiwic2V0U3BhbiI6eyJtdWx0aXBsaWVyIjozLCJiYXNlIjoibW9udGgiLCJwZXJpb2RpY2l0eSI6eyJwZXJpb2QiOjEsImludGVydmFsIjoiZGF5In19LCJpZCI6IklOUj1YIiwicGFyYW1ldGVycyI6eyJpc0NvbXBhcmlzb24iOnRydWUsImNvbG9yIjoiI2ZmMzMzYSIsIndpZHRoIjoyLCJjaGFydE5hbWUiOiJjaGFydCIsInN5bWJvbE9iamVjdCI6eyJzeW1ib2wiOiJJTlI9WCJ9LCJwYW5lbCI6ImNoYXJ0IiwiYWN0aW9uIjpudWxsLCJzaGFyZVlBeGlzIjp0cnVlLCJzeW1ib2wiOiJJTlI9WCIsImdhcERpc3BsYXlTdHlsZSI6InRyYW5zcGFyZW50IiwibmFtZSI6IkpJUkM0SjczRlYiLCJvdmVyQ2hhcnQiOnRydWUsInVzZUNoYXJ0TGVnZW5kIjp0cnVlLCJoZWlnaHRQZXJjZW50YWdlIjowLjcsIm9wYWNpdHkiOjEsImhpZ2hsaWdodGFibGUiOnRydWUsInR5cGUiOiJsaW5lIiwic3R5bGUiOiJzdHhfbGluZV9jaGFydCJ9fV0sIndpZHRoIjoyLCJjdXN0b21SYW5nZSI6bnVsbCwic3R1ZGllcyI6eyJ2b2wgdW5kciI6eyJ0eXBlIjoidm9sIHVuZHIiLCJpbnB1dHMiOnsiaWQiOiJ2b2wgdW5kciIsImRpc3BsYXkiOiJ2b2wgdW5kciJ9LCJvdXRwdXRzIjp7IlVwIFZvbHVtZSI6IiMwMGIwNjEiLCJEb3duIFZvbHVtZSI6IiNGRjMzM0EifSwicGFuZWwiOiJjaGFydCIsInBhcmFtZXRlcnMiOnsid2lkdGhGYWN0b3IiOjAuNDUsImNoYXJ0TmFtZSI6ImNoYXJ0In19fX0%3D"
		     		target="_blank">View Chart</a> &nbsp; 
			     <a href="https://in.investing.com/indices/indices-futures" target="_blank">World Market</a>
  				</li>
  				
		 </ul>
			
		     
	     </span>
		     <span class="glyphicon glyphicon-info-sign" style="color: #40c4ff;"></span>&nbsp;if nifty future is trading above <strong>VWAP</strong> and <strong>Open Interest</strong> shows addition of shares then, nifty future has added net long position.<span style="color: #004d40; font-weight: bold;">+ve(Bullish) Trend</span> 
		     Similarly if nifty future is below <strong>VWAP</strong> and <strong>Open Interest</strong> shows addition then Traders conclusion is nifty future added short positions.<span style="color: #ff3d00; font-weight: bold;">-ve(Bearish) Trend</span>
		    </div> <!-- panel-body  end-->
    </div>
    
    
    
     <div class="panel panel-success">
		    <div class="panel-heading">
		         <h3 class="panel-title">Artificial Intelligence Prediction <span class="glyphicon glyphicon-equalizer" style="font-size: 14px; color: #ffbb33;"></span></h3>
		    </div>
		    <div class="panel-body"> <!-- panel-body  start-->
	<!-- <h4 align="center">Fibonacci Pivot Point Hourly Support &amp; Resistance <span style="font-size: 14px; color: red;">SELL&nbsp;&nbsp;</span> -->
	<!-- <span class="glyphicon glyphicon-arrow-left" style="font-size: 14px; color: red;"></span>
	&nbsp;&nbsp;PivotPoint&nbsp;&nbsp;
	<span class="glyphicon glyphicon-arrow-right" style="font-size: 14px; color: green;"></span>
	<span style="font-size: 14px; color: green;">&nbsp;&nbsp;BUY</span></h4>
			<div class="table-responsive-md">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>Indices</th>
										<th>S1-38.2%</th>
										<th>S2-61.8%</th>
										<th>S3-100%</th>
										<th>PivotPoint</th>
										<th>R1-38.2%</th>
										<th>R2-61.8%</th>
										<th>R3-100%</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><span id="niftySymbolName"></span></td>
										<td class="success"><span id="niftyS3"></span></td>
										<td class="success"><span id="niftyS2"></span></td>
										<td class="success"><span id="niftyS1"></span></td>
										<td class="warning" style="font-weight: bold;"><span id="niftyP1"></span></td>
										<td class="danger"><span id="niftyR1"></span></td>
										<td class="danger"><span id="niftyR2"></span></td>
										<td class="danger"><span id="niftyR3"></span></td>
									</tr>
									<tr>
										<td><span id="BankNiftySymbolName"></span></td>
										<td class="success"><span id="BankNiftyS3"></span></td>
										<td class="success"><span id="BankNiftyS2"></span></td>
										<td class="success"><span id="BankNiftyS1"></span></td>
										<td class="warning" class="warning" style="font-weight: bold;"><span id="BankNiftyP1"></span></td>
										<td class="danger"><span id="BankNiftyR1"></span></td>
										<td class="danger"><span id=BankNiftyR2></span></td>
										<td class="danger"><span id="BankNiftyR3"></span></td>
									</tr>
								</tbody>
							</table>
			</div> -->
			
			
			<jsp:include page="road_map.jsp" />
</div>




<!-- <ul class="list-group">
 				 <li class="list-group-item">
					 	Best Time to Buy Options MORNING <strong class="navy">[ 10:04Am to 10:07Am ]</strong> NEXT <strong class="navy">[ 11:01Am - 11:04Am</strong> (Max 11:10Am)] 
  				</li>
  				
  				<li class="list-group-item">
					 	Best Time to Buy Options AFTER-NOON <strong class="negative">[ 12:16Pm - 12:18Pm, 01:21Pm, 01:42Pm, 02:10Pm, 02:40Pm ]</strong> LAST <strong class="negative">[ 02:55Pm - 03:10Pm (Max 03:12Pm) ]</strong> 
  				</li>
 </ul> -->


<jsp:include page="_auto_addon_gann_target_finder.jsp" />


						<div class="panel-body"> <!-- panel-body  start-->
						<span id="zerodha"></span><br>
						Zerodha Says - You will be allowed to take fresh short option positions. The restriction is only for long options positions.<br>
						
						Future Buy# [ <strong class="navy12"><span id="BuyVolume"></span></strong> ] &nbsp;&nbsp;&nbsp;&nbsp; 
					 	Future Sell# [ <strong class="navy12"><span id="SellVolume"></span></strong> ] &nbsp;&nbsp;&nbsp;
					 	Future BSR# [ <strong class="navy12"><span id="BuySellRatio"></span></strong> ]
					 	
				<span style="color: #9c27b0; font-weight: bold; font-size: 13px;">
			<div class="row">
			
        <div class="col-xs-6">
          <ul class="list-group">
			<li class="list-group-item">
			<span id="mark1"></span>
			<span id="bear"></span><span id="ShortsOrLongRemarkMinus"></span>&nbsp;
			<span id="bankNiftyShortsOrLongFUTNameMinus"></span> <span id="bankNiftyShortsOrLongFUTOpenInterestMinus"></span><sup><span id="bankNiftyShortsOrLongPerchangeinOpenInterestMinus"></span>&nbsp;&nbsp;<span id="bankNiftyShortsOrLongChangeinOpenInterestMinus"></span></sup> 
			</li>
			 <li class="list-group-item">
					 	<span class='superolive'><span id="mark11"></span></span>
			 </li>
			
 				 <li class="list-group-item">
					 	<strong>Strong Prediction 1 </strong>[ <span id="Predictionfirst"></span> ] &nbsp;&nbsp;&nbsp;&nbsp;
					 
  				</li>
  				
  				<li class="list-group-item">
  						<strong>Strong Prediction 2 </strong>[ <span id="Predictionsecond"></span> ] &nbsp;&nbsp;&nbsp;&nbsp;
  						
  				</li>
  				
  				<li class="list-group-item">
	  					Prediction 3 [ <span id="Predictionthird"></span> ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  					
  				</li>
  				
  					<li class="list-group-item">
	  					Prediction 4 [ <span id="Predictionfour"></span> ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  					
  				</li>
  				
  				<li class="list-group-item">
					 	<strong class="navy12">Entry ( 11:20-25Pm And 11:40-45Pm ) <br>Exit ( 01:10-20-40Pm to 02:35 Pm)</strong> &nbsp;&nbsp;
					 
  				</li>
  				
		 </ul>
			
        </div>
        <div class="col-xs-6">
            <ul class="list-group">
			<li class="list-group-item">
			<span id="mark0"></span>
			<span id="bull"></span><span id="ShortsOrLongRemarkPlus"></span>&nbsp; &nbsp; &nbsp; &nbsp;
			<span id="bankNiftyShortsOrLongFUTNamePlus"></span> <span id="bankNiftyShortsOrLongFUTOpenInterestPlus"></span><sup><span id="bankNiftyShortsOrLongPerchangeinOpenInterestPlus"></span>&nbsp;&nbsp;<span id="bankNiftyShortsOrLongChangeinOpenInterestPlus"></span></sup> 
			</li>
			 <li class="list-group-item">
					 	<span class="greenBlinker"><span id="mark00"></span></span>
  				</li>
			
 				 <li class="list-group-item">
						Quick Money Strong Prediction 1 [ <span id="quick1"></span> ]  &nbsp;&nbsp;&nbsp;&nbsp;
					 	Winner [ <span id="nonExpiry1"></span> ]  
  				</li>
  				
  				<li class="list-group-item">
  						Quick Money Strong Prediction 2 [ <span id="quick2"></span> ] &nbsp;&nbsp;&nbsp;&nbsp;
  						Winner [ <span id="nonExpiry2"></span> ] 
  				</li>
  				
  				<li class="list-group-item">
	  					Quick Money Strong Prediction 3 [ <span id="quick3"></span> ] &nbsp;&nbsp;&nbsp;&nbsp;
	  					Safe Buy [ <span id="nonExpiry3"></span> ] 
  				</li>
  				
  					<li class="list-group-item">
	  					Quick Money Strong Prediction 4 [ <span id="quick4"></span> ] &nbsp;&nbsp;&nbsp;&nbsp;
	  					Safe Buy [ <span id="nonExpiry4"></span> ] 
  				</li>
  					<li class="list-group-item">
					 	<strong class="navy12">Entry ( 09:29Am And 01:10Pm ) Exit( 10:59Am to 11:05Am )</strong> <br>
					 	<strong class="navy12">Entry ( 02:55Pm ) Exit ( 03:15Pm )</strong>
  				</li>
  				
		 </ul>
			
        </div>
    </div>
		     
	     </span>
		    </div> <!-- panel-body  end-->
    </div>
    
<!-- </div> --> <!-- container offline -->



<!-- begins Google chart -->
	<div id="piechart_3d" style="width: 900px; height: 400px;"></div>
</div>
<!-- end Google chart -->
		
</div> <!-- angular js controller -->



<jsp:include page="disclaimer.jsp" />
</div>  <!-- root div -->

</fieldset>
<sec:csrfInput /> 
<!-- </fieldset> -->
<jsp:include page="footer.jsp" />

	
</body>

</html>

<!-- unused offline code -->
<!-- <table id="example"
			class="table table-striped table-bordered dt-responsive nowrap"
			style="width: 100%">
			<thead>
				<th>Advances</th>
				<th>Declines</th>
				<th>Unchanged</th>
				<th>Total</th>
			</thead>
			<tbody>
				<tr ng-repeat="post in posts">
					<td style="color: green; font-weight: bold; font-size: 21px; ">{{post.advances}}</td>
					<td style="color: red; font-weight: bold; font-size: 21px; ">{{post.declines}}</td>
					<td style="color: black; font-weight: bold; font-size: 21px; ">{{post.unchanged}}</td>
					<td style="color: blue; font-weight: bold; font-size: 21px; ">{{post.total}}</td>
				</tr>
			<tbody>
		</table> -->