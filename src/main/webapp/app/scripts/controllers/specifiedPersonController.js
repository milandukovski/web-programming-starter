FirstApp.controller('specifiedPersonController', [ '$scope', function($scope) {
	$scope.entity = {};
	$scope.entity.age = -1;

	$scope.afterCrudInit = function(crudScope) {		
		crudScope.hide = function() {
			crudScope.entity = null;
		}
		crudScope.$watch('entity.birthDate', function(n, o) {
			if (n === o || !n)
				return;
			$scope.age(crudScope.entity);
		});
	};
	
	$scope.noPopUp = function() {

	}

	$scope.age = function(entity) { // birthday is a date
		var birthday = entity.birthDate;
		if (birthday) {
			if(typeof birthday === 'string') {
				birthday = new Date(birthday);
			}
			var ageDifMs = Date.now() - birthday.getTime();
			var ageDate = new Date(ageDifMs); // miliseconds from epoch
			entity.age = Math.abs(ageDate.getUTCFullYear() - 1970);
		}
	};
} ]);
