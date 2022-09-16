/**
 * Access the previously created module 'coffeeapp'
 */

(function() {
	var coffeeapp = angular.module('coffeeapp');
	
	coffeeapp.controller('shopController', function($scope, $http) {	
		
		$scope.itemsForSale = [
			{image:"Pinnacle.png",title:"Pinnacle",price:11.00},
			{image:"Ouachita.png",title:"Ouachita",price:12.00},
			{image:"Brazil.jpg",title:"Brazil",price:11.00},
			{image:"Decaf.jpg",title:"Decaf",price:12.00},
			{image:"Ethiopia.jpg",title:"Ethiopia",price:18.00},
			{image:"Guatemala.jpg",title:"Guatemala",price:14.00},
			{image:"Honduras.jpg",title:"Honduras",price:13.00}];
		
		
			
		$scope.addToCart = function(item) {
			if (localStorage.getItem('cart') != null) {
				$scope.cart = JSON.parse(localStorage.getItem('cart'));
				$scope.cart.push(item);
				localStorage.setItem('cart', JSON.stringify($scope.cart));
			} else {
				// new cart
				$scope.cart = [item];
				localStorage.setItem('cart', JSON.stringify($scope.cart));
			}			
		}
		
		$scope.getCart = function() {
			if (localStorage.getItem('cart') != null) {
				$scope.cart = JSON.parse(localStorage.getItem('cart'));				
			} else {				
				$scope.cart = [];				
			}			
		}
		
		$scope.getCart();
		$scope.viewCart = false;
		
		$scope.viewMyCart = function() {			
			$scope.viewCart = true;
		}
		
		$scope.hideMyCart = function() {			
			$scope.viewCart = false;
		}
		
		$scope.emptyMyCart = function() {
			if (localStorage.getItem('cart') != null) {
				$scope.cart = [];
				localStorage.setItem('cart', JSON.stringify($scope.cart));			
			}			
		}
			
	});

})()
