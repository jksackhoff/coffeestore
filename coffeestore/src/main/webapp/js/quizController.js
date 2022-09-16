/**
 * Access the previously created module 'coffeeapp'
 */

(function() {
	var coffeeapp = angular.module('coffeeapp');

	coffeeapp.controller('quizController', function($scope, $http) {	
					
		$scope.getQuiz = function() {			
			
			var config = { params : $scope.quiz }
			
			$http.get("/coffeestore/webapi/coffee/quizsearch", config)
			.then(
				function(response) {
					var data = response.data.filter(function(coffee) {
						var keepCoffee = false;
						var flavorMatches = false;
						var noFlavorsSelected = true;
						var processMatches = false;
						var noProcessSelected = true;
						
						for(var flavor in $scope.quiz.flavor) {
							if ($scope.quiz.flavor[flavor]) {
								noFlavorsSelected = false;
								if (coffee.flavor.toLowerCase() == flavor.toLowerCase()) {
									flavorMatches = true;								
								} 
							}
							if (flavorMatches) {
								break;
							}
						}
						
						for(var process in $scope.quiz.process) {
							if ($scope.quiz.process[process]) {
								noProcessSelected = false;
								if (coffee.process.toLowerCase() == process.toLowerCase()) {
									processMatches = true;								
								} 
							}
							if (processMatches) {
								break;
							}
						}
						
						if (noFlavorsSelected && processMatches) {
							keepCoffee = true;							
						}
						if (noProcessSelected && flavorMatches) {
							keepCoffee = true;
						}
						if (flavorMatches && processMatches) {
							keepCoffee = true;
						}
						
						return keepCoffee;
					})
					$scope.searchResults = data;
					console.log($scope.searchResults);
					console.log($scope.quiz.flavor);
				},
				function error(response) {
					//TODO error message
				});
		};	
		
		$scope.clearQuiz = function() {
			$scope.quiz.flavor.bright = false;
			$scope.quiz.flavor.floral = false;
			$scope.quiz.flavor.fruity = false;
			$scope.quiz.flavor.nutty = false;
			$scope.quiz.flavor.sweet = false;
			$scope.quiz.process.natural = false;
			$scope.quiz.process.washed = false;
			$scope.quiz.process.honey = false;
			
			
			
			
			$scope.searchResults = '';
		}
		
		
	});
	
})()
