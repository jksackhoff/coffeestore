/**
* Create a new module named 'coffeeapp'
*/

(function() {
	let coffeeapp = angular.module("coffeeapp");
	
	coffeeapp.controller("mainController", function($scope, $http, $location) {
		
		$scope.goToShopView = function () {
				$location.path("/shop");
		}
		
		$scope.goToQuizView = function () {
			$location.path("/quiz");
		}
		
			
			
	});
})()