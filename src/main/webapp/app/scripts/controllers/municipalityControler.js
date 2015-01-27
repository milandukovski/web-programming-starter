/**
 * Controller for adding Municipalities
 */
FirstApp.controller('municipalityCtrl', [ '$scope', 'crudService',
		'$routeParams', function($scope, crudService, $routeParams) {
			
			var service = crudService('Municipality');
			
			$scope.entity={};
			$scope.entities = service.query();
			
			if ($routeParams.id) {
				$scope.entity = service.get({
					id : $routeParams.id
				});
			} else {
				$scope.entity = {};
			}
			
			$scope.setPath = function(path){
				$scope.entity.description=path; 
			};
			
			$scope.clear = function(){
				$scope.entity = {};
			}
			

			$scope.edit = function(id) {
				$scope.entity = service.get({
					id : id
				});
			};

			$scope.save = function() {
				service.save($scope.entity, function(data) {
					$scope.entity = {};
					$scope.entities = service.query();
				});
			};

			$scope.remove = function(id) {
				service.remove({
					id : id
				}, function() {
					$scope.entities = service.query();
				});
			};
			
			//Comunication with crud
			$scope.afterCrudInit = function(crudScope){
				crudScope.setPath = function(path){
					if(!crudScope.entity) {
						crudScope.entity = {};
					}
					crudScope.entity.description=jQuery("#"+path).attr('d'); 
				};
				
			};
			$scope.empty = function (crudScope) {
				crudScope.entity={};
			};
			
			$scope.setBase = function(crudScope, entity){
				//alert(crudScope.entity.name)
				$scope.entity=crudScope.entity;
			}
			
			
			

		} ]);