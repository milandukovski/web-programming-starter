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
		'$q',
		function($scope, $http,$q) {
//			$scope.datetimepicker = $("#datetimepicker").datetimepicker();
			
			$scope.entities = [];
			$scope.cases=[];
			$scope.entity = {};
			$scope.mode=true;
			$scope.count=0;
			$scope.casesTotal={};
			$scope.selected = null;
			$scope.selectedCity=null;
			$scope.eventsByCase=null;
			$scope.click=true;
			$scope.Date = {
			         from: new Date(86400000).toISOString().split("T")[0],
			         to: new Date().toISOString().split("T")[0]
			       };
			$scope.pathClick = function(entity) {
				var el = $("#path-" + entity.id);
				console.log(el);
			};			
			
			$scope.select = function(p) {
				$scope.selectedCity=p;
				$scope.click=true;
				$scope.eventsByCase=null;
				
				if($scope.mode){
					$http.get('/data/rest/Event/count/'+p[0]+'/'+$scope.Date.from+'/'+$scope.Date.to).success(
							function(data, status, headers, config) {	
								$scope.selected=data;
							});	
				}
				else{
					$scope.displayCase($scope.myCase['id'],false);
				}
			}

			$scope.textX = function(entity) {
				if (!entity)
					0;
				if (!$scope.svg)
					return 0;
				var el = $("#path-" + entity[0]);
				if(!el[0]) return 0;
				return el[0].getBoundingClientRect().left
						- $scope.svg[0].getBoundingClientRect().left
						+ el[0].getBoundingClientRect().width/4;
			}

			$scope.textY = function(entity) {
				if (!entity)
					0;
				if (!$scope.svg)
					return 0;
				var el = $("#path-" + entity[0]);
				if(!el[0]) return 0;
				return el[0].getBoundingClientRect().top
						- $scope.svg[0].getBoundingClientRect().top
						+ el[0].getBoundingClientRect().height/2;
			}
			
			$scope.color = function(num){
				if(!num){
					return "green"
				}
				if(!$scope.svg)
					return 0;
				var count=0;
				if($scope.mode)
					count=$scope.count;
				else{
					for(var v in $scope.casesTotal){
						if($scope.casesTotal[v][0]==$scope.myCase["id"])
							count=$scope.casesTotal[v][2];
					}				
				}
				var max=count*(1/2);
				var size=max/4;
				if(num>=0 && num<size)
					return "green";
				else if(num>=size && num<(2*size))
					return "yellow";
				else if(num>=(2*size) && num<(3*size))
					return "orange";
				else
					return "red";
			}
			
			$scope.reload = function(){
				$scope.selected=null;
				$scope.selectedCity=null;
				$scope.eventsByCase=null;
				if($scope.myCase["id"]==0){
					$scope.mode=true;
					$scope.entity=$scope.entities[0];
				}
				else{
					$scope.mode=false;
					var flag=true;
					var temp={};
					for(var m in $scope.entities){
						if($scope.entities[m][0][4]==$scope.myCase["id"]){
							$scope.entity=$scope.entities[m];
							flag=false;							
							break;
						}
						if($scope.entities[m][0][4]===null)
							temp=$scope.entities[m];
						
					}
					if(flag)
						$scope.entity=temp;
				}			
			}
			
			$scope.displayCase = function(id,flag){
				if(flag){
					$scope.click=false;					
				}
				$http.get('/data/rest/Event/events/'+id+'/'+$scope.selectedCity[0]+'/'+$scope.Date.from+'/'+$scope.Date.to).success(
						function(data, status, headers, config) {	
							$scope.eventsByCase=data;
						});					
			}
			
			var serverAPI = function(){
				$http.get('/data/rest/EventCase').success(
						function(data, status, headers, config) {	
							$scope.cases.push({'id':0,'name':'all'});
							$scope.myCase=$scope.cases[0];
							
//							for(var i in data)
//							{
//								var deferred = $q.defer();
//							   $http.get('/data/rest/Municipality/total1/'+data[i].id+'/'+$scope.Date.from+'/'+$scope.Date.to).success(
//										function(data, status, headers, config) {
//											 deferred.resolve(data);							
//											$scope.entities.push(data);
//											 
//										}).
//										error(function(data, status, headers, config) {
//										     deferred.reject(status);
//										});
//															  
//							}
							for(var i in data){
								$scope.cases.push(data[i]);
							}
							
						});
				$http.get('/data/rest/Event/count/'+$scope.Date.from+'/'+$scope.Date.to).success(
						function(data, status, headers, config) {	
							$scope.casesTotal=data;
							var c=0;
							for(var i in data)
							{							
							     c+=data[i][2];									  
							}
							$scope.count=c;
//							$http.get('/data/rest/Municipality/total/'+$scope.Date.from+'/'+$scope.Date.to).success(
//									function(data, status, headers, config) {
//										$scope.svg = $("svg");
//										$scope.entities.push( data);
//										$scope.entity=$scope.entities[0];
										
										
										
									});
							
							
//						});		
				$http.get('/data/rest/Event/all/'+$scope.Date.from+'/'+$scope.Date.to).success(
						function(data, status, headers, config) {	
							$scope.svg = $("svg");
							$scope.entities = data;
							$scope.entity=$scope.entities[0];
						});
			}		
			
			$scope.changeDate=function(){
				$scope.entities = [];
				$scope.cases=[];
				$scope.entity = {};
				$scope.mode=true;
				$scope.count=0;
				$scope.casesTotal={};
				$scope.selected = null;
				$scope.selectedCity=null;
				$scope.eventsByCase=null;
				$scope.click=true;
				serverAPI();				
			}
			
			serverAPI();
			
} ]);
		

FirstApp.controller('ImportController', [ '$scope', 'crudService',

function($scope, crudService) {
	$scope.save = function() {
		var regex = /"id":[^,]*,/gi;
		var content = $scope.entities.replace(regex, "");
		crudService($scope.service).import(content);
	};
} ]);
