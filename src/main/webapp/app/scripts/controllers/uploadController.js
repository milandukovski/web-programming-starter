FirstApp.controller('UploadController', [ '$scope','$http', function($scope,$http) {
	$scope.uploadFile = function(){
        var file = $scope.file;
        var test = {
	    		description:"Test",
	    		status: "REJECTED"
	        };
        var fd = new FormData();
        fd.append('file', file);
        fd.append('data',angular.toJson(test))
        
        $http({
        	method: 'POST',
        	url: '/data/rest/Event/upload',
        	headers: {'Content-Type': undefined},
        	data: fd,
            transformRequest: angular.identity,
        })
        .success(function(){
        	alert("success");
        })
        .error(function(){
        	alert("error");
        });
        
        $scope.myFile = null
    };
} ]);