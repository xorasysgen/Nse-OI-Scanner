<!doctype html>
<html>
<head>
<title>Boot Project</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
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
					// this callback will be called asynchronously
					// when the response is available
				}, function errorCallback(response) {
					// called asynchronously if an error occurs
					// or server returns response with an error status.
				});

			} ]);
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


		<table id="example"
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
		</table>
	</div>

</fieldset>
</body>

</html>