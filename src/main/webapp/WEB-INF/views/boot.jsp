<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:csrfInput /> 
<!doctype html>
<html>
<head>
<title>Boot F&amp;O Equity Analysis Platform - The Trading and Investing Engine that simplify Trades-JSR101-1.8.5.RELEASE</title>
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

<script type="text/javascript">
function date_time_auto_sync(){
document.getElementById('timer').innerHTML =
	  05 + ":" + 01;
	startTimer();

	function startTimer() {
	  var presentTime = document.getElementById('timer').innerHTML;
	  var timeArray = presentTime.split(/[:]+/);
	  var m = timeArray[0];
	  var s = checkSecond((timeArray[1] - 1));
	  if(s==59){m=m-1}
	  if(m<0)
	  {
		  m=4;//min clock reset
		  s=59;//sec clock reset
		  //console.log('5 mins timer completed')
		}
	  
	  document.getElementById('timer').innerHTML =
	    m + ":" + s;
	  setTimeout(startTimer, 1000);
	}

	function checkSecond(sec) {
	  if (sec < 10 && sec >= 0) {sec = "0" + sec}; // add zero in front of numbers < 10
	  if (sec < 0) {sec = "59"};
	  return sec;
	}
}
</script>


 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>  <!-- jquery lib -->
<script>
        $.ajax({
        	type:'Get',
        	url: 'mkt_open_status',
        	success: function(result){
        		var json = $.parseJSON(result);
        		if(json.NormalMktStatus=="open")
        			text="<span class='blinking1' style='color: #00c853; font-weight: bold; font-size: 14px;'>Normal Market is Open</span>";
        		else 
        			text = "<span class='blinking1' style='color: #CC0000; font-weight: bold; font-size: 14px;'>Normal Market has Closed</span>";
        		
            $("#mktStatus").html(text);
        	
        }
        })

</script>


<script>
        $.ajax({
        	type:'Get',
        	url: 'option_chain_reader',
        	success: function(result){
        		var json = result.pcrOI;
        		if(json>1)
        			text="<span class='blinking' style='color: #00c853; font-weight: bold; font-size: 18px;'>" +json+ "</span>";
        			else
        			text="<span class='blinking' style='color: #CC0000; font-weight: bold; font-size: 18px;'>" +json+ "</span>";
        			
          		 $("#OptionsNiftyPCR").html(text);
        	
        }
        })

</script>

<script>
        $.ajax({
        	type:'Get',
        	url: 'indices',
        	success: function(result){
        		var lastPrice = result.data[5].lastPrice;
        		var pChange=result.data[5].pChange;
        		if(pChange>=0.0){
        			plain="<span style='color: #FF8800; font-weight: bold; font-size: 16px;'>" +lastPrice+ "</span>";
       				text="<span  style='color: #FF8800; font-weight: bold; font-size: 16px;'>" +lastPrice+ "</span>";
           			text1="<span  style='color: #00e676; font-weight: bold; font-size: 16px;'>" + pChange + "%</span>";
        			}
        			else{
        			plain="<span style='color: #00e676; font-weight: bold; font-size: 16px;'>" +lastPrice+ "</span>";
        			text="<span  style='color: #00e676; font-weight: bold; font-size: 16px;'>" +lastPrice+ "</span>";
        			text1="<span style='color: #FF8800; font-weight: bold; font-size: 16px;'>" + pChange + "%</span>";
        			}

        			
          		 $("#IndiaVix").html(text);
          		 $("#IndiaVixInfo").html(plain); 
          		 $("#IndiaVixPerChange").html(text1);
        	
        }
        })

</script>

<script>
function date_time(id)
{
        date = new Date;
        year = date.getFullYear();
        month = date.getMonth();
        months = new Array('January', 'February', 'March', 'April', 'May', 'June', 'Jully', 'August', 'September', 'October', 'November', 'December');
        d = date.getDate();
        day = date.getDay();
        days = new Array('Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday');
        h = date.getHours();
        if(h<10)
        {
                h = "0"+h;
        }
        m = date.getMinutes();
        if(m<10)
        {
                m = "0"+m;
        }
        s = date.getSeconds();
        if(s<10)
        {
                s = "0"+s;
        }
        result = ''+days[day]+' '+months[month]+' '+d+' '+year+' '+h+':'+m+':'+s;
        document.getElementById(id).innerHTML = result;
        setTimeout('date_time("'+id+'");','1000');
        return true;
}

function startTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('txt').innerHTML =
    h + ":" + m + ":" + s;
    //var t = setTimeout(startTime, 500);
}
function checkTime(i) {
    if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
    return i;
}

function blinker() {
	$('.blinking').fadeOut(500);
	$('.blinking').fadeIn(500);
}
setInterval(blinker, 1000);

function blinker1() {
	$('.blinking1').fadeOut(700);
	$('.blinking1').fadeIn(700);
}
setInterval(blinker1, 900);

</script>
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

 <span style="color: #6c757d; font-size: 16px;">Welcome [ <span style="color:#007E33;"><strong> <sec:authentication property="principal.username" /></strong></span> ] Logged as a <span style="color:#4a148c;"> <sec:authentication property="principal.authorities"/> </span> #The I<span style="color: orange; font-size: 16px;">&amp;</span>T Engine Powered By</span> <span style="color:#6db33f;">Boot</span><span class="glyphicon glyphicon-leaf" style="color:#6db33f;"></span>&nbsp;<sup><small><span class="label label-success">JSR101-1.8.5.RELEASE</span></small></sup><br>
<sup><span style="color: #17a2b8; font-weight: bold; font-size: 12px;"> #Last sync : <span id="txt"></span></span>  
		&nbsp;<span style="color: #17a2b8; font-weight: bold; font-size: 12px;">#AutoSync : </span><span class="pink" style="color: #ff4444; font-weight: bold; font-size: 12px;"><span id="timer"></span></span>&nbsp;<span class="glyphicon glyphicon-time" style="font-size: 12px; color: green;"></span> <small><span style="color: #6c757d; font-weight: bold; font-size: 12px;" id="date_time"></span></small></sup>
		<sup><i><span id="mktStatus"></span></i></sup>
 
</legend>

<!-- <fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
		<legend><span style="color: #17a2b8;">Market Trend - Overall Advances/Declines Ratio</span></legend>
		 -->
            <script type="text/javascript">window.onload = date_time('date_time');</script>
            <script type="text/javascript">window.onload = startTime();</script>
			<script type="text/javascript">window.onload = date_time_auto_sync();</script>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Boot Dashboard <span class="glyphicon glyphicon-dashboard" style="font-size: 12px; color: #ffbb33;"></span>&nbsp;Market Breadth &amp; Trend
        <span class="glyphicon glyphicon-resize-small" style="font-size: 16px; color: #ffbb33;"></span> &nbsp; IndiaVix LTP# [&nbsp;<span style="color: #00e676;" id="IndiaVix"></span>&nbsp;] IndiaVix Change#[&nbsp;<span style="color: #00e676;" id="IndiaVixPerChange"></span>&nbsp;] <span class="glyphicon glyphicon-resize-small" style="font-size: 16px; color: #ffbb33;"></span>
        Nifty Put-Call-Ratio (PCR)# [&nbsp;<span style="color: #00e676;" id="OptionsNiftyPCR"></span>&nbsp;]</h3>
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
<!-- </div> --> <!-- container offline -->



<!-- begins Google chart -->
	<div id="piechart_3d" style="width: 900px; height: 400px;"></div>
</div>
<!-- end Google chart -->
		
</div> <!-- angular js controller -->

</div>

</fieldset>

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