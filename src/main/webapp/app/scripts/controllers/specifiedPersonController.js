FirstApp.controller('specifiedPersonController', [ '$scope', function($scope) {
    $scope.entity={};
    $scope.entity.age=-1;
	
    $scope.age = function() { // birthday is a date
		var birthday=$scope.entity.birthDate;
	    var ageDifMs = Date.now() - birthday.getTime();
	    var ageDate = new Date(ageDifMs); // miliseconds from epoch
	    $scope.entity.age= Math.abs(ageDate.getUTCFullYear() - 1970);
	    alert($scope.entity.age);
	};
} ]);
