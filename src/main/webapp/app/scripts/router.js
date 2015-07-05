/**
 * @ngdoc here we are configuring the module exposed through the FirstApp
 *        variable. The method receives an array that has a function as a last
 *        argument. Here, the angular inject the dependencies defined as strings
 *        in the array to the corresponding elements in the function. <br/> The
 *        $routeProvider is used to configure the routes. It maps templateUrl
 *        and optionally a controller to a given path. This is used by the
 *        ng-view directive. It replaces the content of the defining element
 *        with the content of the templateUrl, and connects it to the controller
 *        through the $scope.
 * @see https://docs.angularjs.org/guide/di
 */

FirstApp.config([ '$routeProvider', '$translateProvider',
		function($routeProvider, $translateProvider) {

			// Initialize angular-translate
			$translateProvider.useStaticFilesLoader({
				prefix : 'i18n/',
				suffix : '.json'
			});

			$translateProvider.preferredLanguage("en");

			$routeProvider.when('/', {
				templateUrl : 'views/main.html'
			});

			$routeProvider.when('/import', {
				templateUrl : 'views/import/import.html',
				controller : 'ImportController',
				publicAccess : true
			});
			
			$routeProvider.when('/visualisation', {
				templateUrl : 'views/visualisation.html'
			});

			for (var i = 0; i < menuData.length; i++) {
				var items = menuData[i]["items"];
				for (var j = 0; j < items.length; j++) {
					var temp = items[j];
					var path = temp['path'];
					if (Object.keys(temp).length == 3) {
						$routeProvider.when(path, {
							"templateUrl" : temp['templateUrl']
						});
					} else if (Object.keys(temp).length == 4) {
						$routeProvider.when(path, {
							templateUrl : temp['templateUrl'],
							controller : temp['controller']
						});
					} else
						alert("ERROR in router.js");
				}
			}
			
			$routeProvider.when('/upload', {
				templateUrl : 'views/upload/upload.html',
				controller : 'UploadController',
			});
			
			$routeProvider.when('/404', {
				templateUrl : '404.html'
			});
			$routeProvider.otherwise({
				redirectTo : '/'
			});

		} ]);
