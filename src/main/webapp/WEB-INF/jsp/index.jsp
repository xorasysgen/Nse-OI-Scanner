<!doctype html>
<html>
  <head>
    <title>My AngularJS App</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.2.1/js/dataTables.responsive.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.2.1/js/responsive.bootstrap.min.js"></script>

 <link rel="stylesheet"   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 
 <link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css">
 <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.2.1/css/responsive.bootstrap.min.css">
 
 
 
 
    <script type="text/javascript">
    
    var myApp = angular.module('myApp',[]);

    myApp.controller('GreetingController', ['$scope', '$http', function($scope,$http) {
      $scope.greeting = 'Hola!';
      
      
      $http({
    	  method: 'GET',
    	  url: 'https://jsr101.herokuapp.com/top_gainer/'
    	}).then(function successCallback(response) {
    		console.log(response.data);
    		$scope.posts=response.data.data
    	    // this callback will be called asynchronously
    	    // when the response is available
    	  }, function errorCallback(response) {
    	    // called asynchronously if an error occurs
    	    // or server returns response with an error status.
    	  });
      
      
    }]);
    
    </script>
    
    <script type="text/javascript">
    $(document).ready(function() {
        $('#example').DataTable();
    } );
    </script>
    
    
    
  </head>
  <body>
  
    <div  ng-app="myApp" ng-controller="GreetingController" >
    
    
    <table id="example" class="table table-striped table-bordered dt-responsive nowrap" style="width:100%">
    <thead>
     <th>Symbol</th>
					  <th>Open Price</th>
					  <th>High Price</th>
					  <th>Low Price</th>
					  <th>Last traded Price</th>
					  <th>Previous Price</th>
					  <th>Net Price</th>
					  <th>Traded Quantity</th>
					  <th>turnoverInLakhs</th>
					  <th>Last CorpAnnouncement Date</th>
					  <th>Last Corp Announcement</th>
					  </thead>
					   <tbody>
  <tr ng-repeat="post in posts">
		<td>{{post.symbol}}</td>
		<td>{{post.openPrice}}</td>
		<td>{{post.highPrice}}</td>
		<td>{{post.lowPrice}}</td>
		<td>{{post.ltp}}</td>
		<td>{{post.previousPrice}}</td>
		<td>{{post.netPrice}}</td>
		<td>{{post.tradedQuantity}}</td>
		<td>{{post.turnoverInLakhs}}</td>
		<td>{{post.lastCorpAnnouncementDate}}</td>
		<td>{{post.lastCorpAnnouncement}}</td>
  </tr>
   <tbody>
</table>
    </div>
  


  </body>
</html>