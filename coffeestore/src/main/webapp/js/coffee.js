/**
* Create a new module named 'coffeeapp'
*/

let coffeeapp = angular.module("coffeeapp", ["ngRoute"]);

coffeeapp.config(function($routeProvider) {
	  $routeProvider
	  .when("/about", {
		    templateUrl : "about.html",
		  })
	  .when("/search", {
	    templateUrl : "search.html",
	    controller : "searchController"
	  })
	  .when("/quiz", {
	    templateUrl : "quiz.html",
	    controller : "quizController"
	  })
	  .when("/shop", {
	    templateUrl : "shop.html",
	    controller : "shopController"
	  })
	  .when("/create", {
	    templateUrl : "create.html",
	    controller : "createController"
	  })
	  .when("/stack", {
	    templateUrl : "stack.html",
	  })
	  .when("/resume", {
	    templateUrl : "resume.html",
	  })
  	  .when("/update/:coffeeId", {
	    templateUrl : "update.html",
	    controller: "updateController"
	  })
	  .when("/create", {
	    templateUrl : "create.html",
	    controller: "createController"
	  })
	  .when("/main", {
	    templateUrl : "main.html"
	  })
	  .otherwise({
	    templateUrl : "main.html"
	  });
	});