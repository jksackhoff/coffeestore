/**
* Create a new module named 'coffeeapp'
*/

(function() {
	let coffeeapp = angular.module("coffeeapp");
	
	coffeeapp.controller("searchController", function($scope, $http, $location) {
	
		$scope.getAllCoffees = function() {
			$http.get("/coffeestore/webapi/coffee")
			.then(function(response) {
				$scope.coffees = response.data;
				console.log('number of coffees: ' + $scope.coffees.length);
			}, function(response) {
				console.log('error http GET movies: ' + response.status);
			});
		}
		
		$scope.goToUpdateView = function (id) {
				console.log("go to update view: " + id);
				$location.path("/update/" + id);
		}
		
		$scope.getAllCoffees();
			
			
	});
})()