'use strict';

/**
 * @ngdoc Simple controller definition that have the $scope and firstService
 *        injected by angular. The $scope is the glue between the controller 
 *        and the view that displays the information. The controller is not 
 *        aware about the view that displays the information. 
 *        
 * @name avAngularStartupApp.controller:MainCtrl
 * @description # MainCtrl Controller of the avAngularStartupApp
 * MunicipalityResource
 */

FirstApp.controller('MainCtrl', [ '$scope', '$http',
            function($scope, $http) {
      
			$scope.entities = {};
			$scope.entity = {};
			
			$http.get('/data/rest/Municipality').
			  success(function(data, status, headers, config) {
				  $scope.entities=data;
				//  alert("yes");
			  }).
			  error(function(data, status, headers, config) {
			    // called asynchronously if an error occurs
			    // or server returns response with an error status.
			//	  alert("no");
			  });
	
    }]);
