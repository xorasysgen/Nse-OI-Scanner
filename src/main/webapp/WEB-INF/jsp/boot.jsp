<!doctype html>
<html>
<head>
<title>Boot F&amp;O Equity Analysis Platform - The Trading and Investing Engine that simplify Trades-JSR101 - v.1.46.5.3</title>
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
<jsp:include page="js_css_include.jsp" />

<!-- <script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script> -->

<body>
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>
F&amp;O equity analysis platform - The Trading &amp; Investing Engine that simplify trades.<span style="color:#6db33f;">Boot</span><span class="glyphicon glyphicon-leaf" style="color:#6db33f;"></span>&nbsp;<sup><small><span class="label label-success">JSR101 - v.1.46.5.3</span></small></sup>
</legend>

<jsp:include page="menu.jsp" />
	<div ng-app="myApp" ng-controller="GreetingController">
	<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
		<legend>Market Trend - Overall Advances / Declines Ratio</legend>


<div class="container">
    <div class="row">
        <div class="col-md-4">
TOTAL STOCKS &nbsp;&nbsp;&nbsp;
<span style="color: blue; font-weight: bold; font-size: 18px; display:inline-block; width:TWO-TAB-WIDTH;">  {{getTotal()}} </span>  <br>
           
POSITIVE(+)  <span class="glyphicon glyphicon-thumbs-up" style="font-size: 18px; color: green;"></span>&nbsp;&nbsp;&nbsp;&nbsp;
<span style="color: green; font-weight: bold; font-size: 18px; "> {{ getAdvanced() }} </span> <br>

NEGATIVE(-)   <span class="glyphicon glyphicon-thumbs-down" style="font-size: 18px; color: red;"></span>&nbsp;&nbsp;&nbsp;&nbsp;
<span  style="color: red; font-weight: bold; font-size: 18px; "> {{getDeclines()}} </span><br>

UNCHANGED <span class="glyphicon glyphicon-hand-right" style="font-size: 18px; color: orange;"></span>
<span style="color: orange; font-weight: bold; font-size: 18px;">&nbsp; {{getUnchange()}} </span> <br>

OVERALL TREND <span style="color: #117a8b; font-weight: bold; font-size: 18px; ">  {{ getTrend() }}  </span> 
        </div>
        
        
        
        <div class="col-md-4">
            <div ng-app="myApp" ng-controller="NiftyController">
            
TOTAL STOCKS &nbsp;&nbsp;&nbsp;
<span style="color: blue; font-weight: bold; font-size: 18px; display:inline-block; width:TWO-TAB-WIDTH;">  50 </span>  <br>

POSITIVE(+)  <span class="glyphicon glyphicon-thumbs-up" style="font-size: 18px; color: green;"></span>&nbsp;&nbsp;&nbsp;&nbsp;
<span style="color: green; font-weight: bold; font-size: 18px; "> {{ getNiftyAdvanced() }} </span> <br>

NEGATIVE(-)   <span class="glyphicon glyphicon-thumbs-down" style="font-size: 18px; color: red;"></span>&nbsp;&nbsp;&nbsp;&nbsp;
<span  style="color: red; font-weight: bold; font-size: 18px; "> {{ getNiftyDeclines() }} </span><br>

UNCHANGED <span class="glyphicon glyphicon-hand-right" style="font-size: 18px; color: orange;"></span>
<span style="color: orange; font-weight: bold; font-size: 18px;">&nbsp; {{ getNiftyUnchange() }} </span> <br>

NIFTY TREND <span style="color: #117a8b; font-weight: bold; font-size: 18px; ">  {{ getNiftyTrend() }}  </span> 
</div>
        </div>
        
       
        
        <div class="col-md-4" >
        <span class="border-top border-dark">
            <div ng-app="myApp" ng-controller="BankNiftyController">
            
TOTAL STOCKS &nbsp;&nbsp;&nbsp;
<span style="color: blue; font-weight: bold; font-size: 18px; display:inline-block; width:TWO-TAB-WIDTH;">  12 </span>  <br>

POSITIVE(+)  <span class="glyphicon glyphicon-thumbs-up" style="font-size: 18px; color: green;"></span>&nbsp;&nbsp;&nbsp;&nbsp;
<span style="color: green; font-weight: bold; font-size: 18px; "> {{ getBankNiftyAdvanced() }} </span> <br>

NEGATIVE(-)   <span class="glyphicon glyphicon-thumbs-down" style="font-size: 18px; color: red;"></span>&nbsp;&nbsp;&nbsp;&nbsp;
<span  style="color: red; font-weight: bold; font-size: 18px; "> {{ getBankNiftyDeclines() }} </span><br>

UNCHANGED <span class="glyphicon glyphicon-hand-right" style="font-size: 18px; color: orange;"></span>
<span style="color: orange; font-weight: bold; font-size: 18px;">&nbsp; {{ getBankNiftyUnchange() }} </span> <br>

BANKNIFTY TREND <span style="color: #117a8b; font-weight: bold; font-size: 18px; ">  {{ getBankNiftyTrend() }}  </span> 
</div>
</span>
        </div>
    </div>
</div>




<!-- begins Google chart -->
<div id="chart_wrap">
	<div id="piechart_3d" style="width: 900px; height: 500px;"></div>
</div>
<!-- end Google chart -->


</fieldset>
		
	</div>

</fieldset>
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