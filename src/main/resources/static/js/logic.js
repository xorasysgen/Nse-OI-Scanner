	var myApp = angular.module('myApp', []);

	myApp.controller('GreetingController', [ '$scope', '$http',
			function($scope, $http) {
				$scope.greeting = 'Hola!';

				$http({
					method : 'GET',
					url : 'https://jsr101.herokuapp.com/advances_declines'
				}).then(function successCallback(response) {
					//console.log(response.data);
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
 	   		        	    
					        if(bull_per >= 50 && adr>=1.50){
					        	trend= "Extremely Bullish(+)";
					        }
					        else if(bear_per>=50){
					        	trend= "Extremely Bearish(-)";
					        }
					        else if(bull_per>=40 && bull_per<=45 && adr <1.25){
					        	trend= "Little Bearish(-) and Bearish to Choppy Market";
					        }
					        else  if(bull_per>45 && bull_per<=49 && adr>=1.30){
					        	trend= "little Bullish(+) with SideWays Market";
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
	
	
	
	
	myApp.controller('GreetingController', [ '$scope', '$http',
	                             			function($scope, $http) {
	                             				$scope.greeting = 'Hola!';

	                             				$http({
	                             					method : 'GET',
	                             					url : 'https://jsr101.herokuapp.com/advances_declines'
	                             				}).then(function successCallback(response) {
	                             					//console.log(response.data);
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
	                              	   		        	    
	                             					        if(bull_per >= 50 && adr>=1.50){
	                             					        	trend= "Extremely Bullish(+)";
	                             					        }
	                             					        else if(bear_per>=50){
	                             					        	trend= "Extremely Bearish(-)";
	                             					        }
	                             					        else if(bull_per>=40 && bull_per<=45 && adr <1.25){
	                             					        	trend= "Little Bearish(-) and Bearish to Choppy Market";
	                             					        }
	                             					        else  if(bull_per>45 && bull_per<=49 && adr>=1.30){
	                             					        	trend= "little Bullish(+) with SideWays Market";
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
	
	
	
	myApp.controller('NiftyController', [ '$scope', '$http',
	                             			function($scope, $http) {
	                             				$scope.greeting = 'Hola!';

	                             				$http({
	                             					method : 'GET',
	                             					url : 'https://jsr101.herokuapp.com/advances_declines_nifty/'
	                             				}).then(function successCallback(response) {
	                             					//console.log(response.data);
	                             					console.log(response.data.advances);
	                             					console.log(response.data.declines);
	                             					console.log(response.data.unchanged);
	                             					$scope.posts = response.data.rows
	                             					$scope.getNiftyTrend = function(){
	                             					    var trend = "None";
	                             					        
	                             					        var bull_per=(response.data.advances/50)*100;
	                             					        var bear_per=(response.data.declines/50)*100;
	                             					        var unchanged_per=(response.data.unchanged/50)*100;
	                             					        var adr=response.data.advances/response.data.declines;
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
	                             					        	trend= "Little Bearish(-) and Bearish to Choppy Market";
	                             					        }
	                             					        else  if(bull_per>45 && bull_per<=49 && adr>=1.30){
	                             					        	trend= "little Bullish(+) with SideWays Market";
	                             					        }
	                             					        else
	                             					        	trend="No Clear Trend";
	                             					        
	                             					  
	                             					    return trend;
	                             					    
	                             					}
	                             					
	                             					$scope.getNiftyAdvanced = function(){
	                             					    var result = response.data.advances;
	                             					    return result;
	                             					    
	                             					}
	                             					
	                             					$scope.getNiftyDeclines = function(){
	                             					    var result = response.data.declines;
	                             					    return result;
	                             					    
	                             					}
	                             					
	                             					$scope.getNiftyUnchange = function(){
	                             					    var result = response.data.unchanged;
	                             					    return result;
	                             					    
	                             					}
	                             					
	                             					// this callback will be called asynchronously
	                             					// when the response is available
	                             				}, function errorCallback(response) {
	                             					// called asynchronously if an error occurs
	                             					// or server returns response with an error status.
	                             				});

	                             			} ]);
	
	myApp.controller('BankNiftyController', [ '$scope', '$http',
	                             			function($scope, $http) {
	                             				$scope.greeting = 'Hola!';

	                             				$http({
	                             					method : 'GET',
	                             					url : 'https://jsr101.herokuapp.com/advances_declines_bank_nifty/'
	                             				}).then(function successCallback(response) {
	                             					//console.log(response.data);
	                             					console.log(response.data.advances);
	                             					console.log(response.data.declines);
	                             					console.log(response.data.unchanged);
	                             					$scope.posts = response.data.rows
	                             					$scope.getBankNiftyTrend = function(){
	                             					    var trend = "None";
	                             					        
	                             					        var bull_per=(response.data.advances/12)*100;
	                             					        var bear_per=(response.data.declines/12)*100;
	                             					        var unchanged_per=(response.data.unchanged/12)*100;
	                             					        var adr=response.data.advances/response.data.declines;
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
	                             					        	trend= "Little Bearish(-) and Bearish to Choppy Market";
	                             					        }
	                             					        else  if(bull_per>45 && bull_per<=49 && adr>=1.30){
	                             					        	trend= "little Bullish(+) with SideWays Market";
	                             					        }
	                             					        else
	                             					        	trend="No Clear Trend";
	                             					        
	                             					  
	                             					    return trend;
	                             					    
	                             					}
	                             					
	                             					$scope.getBankNiftyAdvanced = function(){
	                             					    var result = response.data.advances;
	                             					    return result;
	                             					    
	                             					}
	                             					
	                             					$scope.getBankNiftyDeclines = function(){
	                             					    var result = response.data.declines;
	                             					    return result;
	                             					    
	                             					}
	                             					
	                             					$scope.getBankNiftyUnchange = function(){
	                             					    var result = response.data.unchanged;
	                             					    return result;
	                             					    
	                             					}
	                             					
	                             					// this callback will be called asynchronously
	                             					// when the response is available
	                             				}, function errorCallback(response) {
	                             					// called asynchronously if an error occurs
	                             					// or server returns response with an error status.
	                             				});

	                             			} ]);
	