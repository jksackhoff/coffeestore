/**
 * Access the previously created module 'coffeeapp'
 * and create a controller associated with our module
 */



(function() {
	var coffeeapp = angular.module('coffeeapp');

	coffeeapp.controller('createController', function($scope, $http) {			
		
		$scope.process = ['Natural','Washed','Honey'];
		$scope.flavor = ['Bright','Floral','Fruity','Nutty', 'Sweet'];
		
		$scope.createCoffee = function() {
			$http.post("/coffeestore/webapi/coffee", $scope.coffee)
			.then(function(response) {				
				$scope.createStatus = 'create successful';
				$scope.disableCreate = true;
			}, function(response) {
				$scope.createStatus = 'error trying to create movie';	
				console.log('error http POST coffee: ' + response.status);
			});
		}
		
		$scope.clear = function() {
			$scope.coffee.id = '';
			$scope.coffee.name = '';
			$scope.coffee.origin = '';
			$scope.coffee.process = '';
			$scope.coffee.elevation = '';
			$scope.coffee.price = '';
			$scope.coffee.flavor = '';
			$scope.disableCreate = false;
		}
		
	});
	
})()

