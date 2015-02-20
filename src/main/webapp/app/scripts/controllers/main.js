'use strict';

/**
 * @ngdoc Simple controller definition that have the $scope and firstService
 *        injected by angular. The $scope is the glue between the controller and
 *        the view that displays the information. The controller is not aware
 *        about the view that displays the information.
 * 
 * @name avAngularStartupApp.controller:MainCtrl
 * @description # MainCtrl Controller of the avAngularStartupApp
 *              MunicipalityResource
 */

FirstApp.controller('MainCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {

			$scope.entities = {};
			$scope.entity = {};
			$scope.pathClick = function(entity) {
				var el = $("#path-" + entity.id);
				console.log(el);
			};
			
			$scope.selected = {};
			
			$scope.select = function(p) {
				$scope.selected=p;
			}

			$scope.textX = function(entity) {
				if (!entity)
					0;
				if (!$scope.svg)
					return 0;
				var el = $("#path-" + entity.id);
				if(!el[0]) return 0;
				return el[0].getBoundingClientRect().left
						- $scope.svg[0].getBoundingClientRect().left
						+ el[0].getBoundingClientRect().width / 4;
			}

			$scope.textY = function(entity) {
				if (!entity)
					0;
				if (!$scope.svg)
					return 0;
				var el = $("#path-" + entity.id);
				if(!el[0]) return 0;
				return el[0].getBoundingClientRect().top
						- $scope.svg[0].getBoundingClientRect().top
						+ el[0].getBoundingClientRect().height / 2;
			}

			$http.get('/data/rest/Municipality').success(
					function(data, status, headers, config) {
						$scope.svg = $("svg");
						$scope.entities = data;
					});

		} ]);

FirstApp.controller('ImportController', [ '$scope', 'crudService',

function($scope, crudService) {
	$scope.save = function() {
		var regex = /"id":[^,]*,/gi;
		var content = $scope.entities.replace(regex, "");
		crudService($scope.service).import(content);
	};
} ]);
