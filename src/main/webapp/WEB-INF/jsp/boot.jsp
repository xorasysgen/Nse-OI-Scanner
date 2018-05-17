<!doctype html>
<html>
<head>
<title>Boot Project</title>
<meta charset="utf-8">
<meta name="viewport"	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>


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

<script type="text/javascript">
	var myApp = angular.module('myApp', []);

	myApp.controller('GreetingController', [ '$scope', '$http',
			function($scope, $http) {
				$scope.greeting = 'Hola!';

				$http({
					method : 'GET',
					url : 'https://jsr101.herokuapp.com/advances_declines'
				}).then(function successCallback(response) {
					console.log(response.data);
					$scope.posts = response.data.rows
					$scope.getTrend = function(){
					    var trend = "None";
					    for(var i = 0; i < $scope.posts.length; i++){
					        var row = $scope.posts[i];
					        var bull_per=(row.advances/row.total)*100;
					        var bear_per=(row.declines/row.total)*100;
					        var unchanged_per=(row.unchanged/row.total)*100;
					        var adr=row.advances/row.declines;
					        console.log("bull_per# " + bull_per);
				        	console.log("bear_per# " + bear_per);
					        console.log(unchanged_per);
					        console.log(adr);
				        	console.log("adr# " + adr);
 	   		        	    console.log("adr>1.25# " + adr);
 	   		        	    
					        if(bull_per >= 50){
					        	trend= "Extremely Bullish(+)";
					        }
					        else if(bear_per>=50){
					        	trend= "Extremely Bearish(-)";
					        }
					        else if(bull_per>=40 && bull_per<=45 && adr <1.25){
					        	trend= "Little Bearish(-) and SideWays Market";
					        }
					        else  if(adr>=1.25){
					        	trend= "Bullish";
					        }
					        else
					        	trend="No Clear Trend";
					        
					    }
					    return trend;
					    
					}
					
					$scope.getAdvanced = function(){
					    var result = "None";
					    for(var i = 0; i < $scope.posts.length; i++){
					        var row = $scope.posts[i];
					        result =  row.advances;
					    }
					    return result;
					    
					}
					
					$scope.getDeclines = function(){
					    var result = "None";
					    for(var i = 0; i < $scope.posts.length; i++){
					        var row = $scope.posts[i];
					        result =  row.declines;
					    }
					    return result;
					    
					}
					
					$scope.getUnchange = function(){
					    var result = "None";
					    for(var i = 0; i < $scope.posts.length; i++){
					        var row = $scope.posts[i];
					        result =  row.unchanged;
					    }
					    return result;
					    
					}
					$scope.getTotal = function(){
					    var result = "None";
					    for(var i = 0; i < $scope.posts.length; i++){
					        var row = $scope.posts[i];
					        result =  row.total;
					    }
					    return result;
					    
					}
					
					
					// this callback will be called asynchronously
					// when the response is available
				}, function errorCallback(response) {
					// called asynchronously if an error occurs
					// or server returns response with an error status.
				});

			} ]);
</script>

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    
    var advances,declines,unchanged,total;

      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
    	   $.ajax( {
    	  	  type:'Get',
    	  	  url:'https://jsr101.herokuapp.com/advances_declines',
    	  	  success:function(data) {
    	  	   console.log(data);
    	  	   abc(data);
    	  	
    	  	  }

    	  	  })
    	   function abc(data){
    	    	 advances = data.rows[0].advances;
    	    	 declines=data.rows[0].declines ;
    	    	 unchanged=data.rows[0].unchanged;
    	    	 total=data.rows[0].total;
    	    	  var data = google.visualization.arrayToDataTable(
    	    			  [ ['Task', 'task' ],
    	    				['unused',0],  
    	    	            ['Declines',  declines],
    	    	            ['Unchanged',  unchanged],
    	    			    ['Advances',   advances]
    	    			    
    	    	           ]);
    	    	                                                  
    	    	          var options = {
    	    	          title: 'Overall Advances & Declines Ratio Chart',
    	    	          is3D: true,
    	    	          chartArea: {
    	                      left: "10%",
    	                      top: "10%",
    	                      height: "50%",
    	                      width: "50%"
    	                  }
    	    	          };
                   var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
                   chart.draw(data, options);
    	      }
        
      }
      
    </script>

    


<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
<body>
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>Welcome from BOOT!, F&O Equity Stock Watch Research Portal</legend>

	<jsp:include page="menu.jsp" />
	<div ng-app="myApp" ng-controller="GreetingController">
	<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>Market Trend - Overall Advances / Declines Ratio</legend>


POSITIVE(+)  <span class="glyphicon glyphicon-thumbs-up" style="font-size: 18px; color: green;"></span>&nbsp;&nbsp;&nbsp;&nbsp;
<span style="color: green; font-weight: bold; font-size: 18px; "> {{ getAdvanced() }} </span> <br>

NEGATIVE(-)   <span class="glyphicon glyphicon-thumbs-down" style="font-size: 18px; color: red;"></span>&nbsp;&nbsp;&nbsp;&nbsp;
<span  style="color: red; font-weight: bold; font-size: 18px; "> {{getDeclines()}} </span><br>

UNCHANGED <span class="glyphicon glyphicon-hand-right" style="font-size: 18px; color: orange;"></span>
<span style="color: orange; font-weight: bold; font-size: 21px;">&nbsp; {{getUnchange()}} </span> <br>

TOTAL STOCKS &nbsp;&nbsp;&nbsp;
<span style="color: blue; font-weight: bold; font-size: 18px; display:inline-block; width:TWO-TAB-WIDTH;">  {{getTotal()}} </span>  <br>
OVER ALL MARKET TREND <span style="color: blue; font-weight: bold; font-size: 18px; ">  {{getTrend()}}  </span> 


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