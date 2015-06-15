FirstApp.controller('EventController', [ '$scope', function($scope) {
	$scope.crudScope = {};
	
	$scope.afterCrudInit = function(crudScope) {
		$scope.crudScope = crudScope;
		crudScope.hide = function() {
			crudScope.entity = null;
		}
	};

	$scope.noPopUp = function() {

	}
} ]);
