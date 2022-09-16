/**
 * Access the previously created module 'coffeeapp'
 * and create a controller associated with our module
 */

(function() {
var coffeeApp = angular.module("coffeeapp");

coffeeApp.controller("updateController", function($scope, $http, $routeParams, $location) {
	
	$scope.process = ['Natural','Washed','Honey'];
	$scope.flavor = ['Bright','Floral','Fruity','Nutty', 'Sweet'];
	
	$scope.getCoffeesById = function() {
		$http.get("/coffeestore/webapi/coffee/" + $routeParams.coffeeId)
		.then(function(response) {
			var coffees = response.data;
			if (coffees.length == 1) {
				$scope.coffee = coffees[0];
			} else {
				//TODO error message
			}				
		}, function(response) {
			console.log('error http GET coffees by id: ' + response.status);
		});
	}

	$scope.getCoffeesById();
	
	$scope.updateCoffee = function() {
		$http.put("/coffeestore/webapi/coffee", $scope.coffee)
		.then(function(response) {				
			$scope.updateStatus = 'update successful';			
		}, function(response) {
			$scope.updateStatus = 'error trying to update coffee';	
			console.log('error http PUT coffees: ' + response.status);
		});
	}

	$scope.deleteCoffee = function() {
		$http.delete("/coffeestore/webapi/coffee/" + $scope.coffee.id)
		.then(function(response) {				
			$scope.updateStatus = 'delete successful';	
			$scope.disableUpdate = true;
		}, function(response) {
			$scope.updateStatus = 'error trying to delete coffee';	
			console.log('error http DELETE coffees: ' + response.status);
		});
	}
	
	$scope.goToSearchView = function() {
		$location.path("/search");
	}


	
});

})();
