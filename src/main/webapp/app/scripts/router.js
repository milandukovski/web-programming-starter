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

var menuData = [ {
	name : 'menu.event',
	items : [ {
		label : 'mvr.municipalities',
		path: "/views/view_municipalities",
		templateUrl : 'views/view_municipalities.html',
	} ]
}, {
	name : 'menu.vehicle',
	items : [ {
		label : 'mvr.vehicletype',
		path: "/views/view_vehicletype",
		templateUrl : 'views/view_vehicletypes.html',
	},
	{
		label : 'mvr.vehiclecolor',
		path: "/views/view_vehiclecolor",
		templateUrl : 'views/view_vehicletype.html',
	},
	{
		label : 'mvr.vehiclemodels',
		path: "/views/view_vehiclemodels",
		templateUrl : 'views/view_vehiclemodels.html',
	},
	{
		label : 'mvr.vehiclebrends',
		path: "/views/view_vehiclebrends",
		templateUrl : 'views/view_vehiclebrends.html',
	},
	{
		label : 'mvr.vehicleregcountries',
		path: "/views/view_vehicleregcountries",
		templateUrl : 'views/view_vehicleregcountries.html',
	}]

}, {
	name : 'menu.person',
	items : [ {
		label : 'mvr.ethnicity',
		path: "/views/view_ethnicity",
		templateUrl : 'views/view_ethnicity.html',
	},
	{
		label : 'mvr.age',
		path: "/views/view_age",
		templateUrl : 'views/view_age.html',
	},
	{
		label : 'mvr.skintypes',
		path: "/views/view_skintypes",
		templateUrl : 'views/view_skintypes.html',
	},
	{
		label : 'mvr.heights',
		path: "/views/view_heights",
		templateUrl : 'views/view_heights.html',
	},
	{
		label : 'mvr.weights',
		path: "/views/view_weights",
		templateUrl : 'views/view_weights.html',
	},
	{
		label : 'mvr.teethconditions',
		path: "/views/view_teethconditions",
		templateUrl : 'views/view_teethconditions.html',
	},
	{
		label : 'mvr.speachtroubles',
		path: "/views/view_speachtroubles",
		templateUrl : 'views/view_speachtroubles.html',
	},
	{
		label : 'mvr.physicalconditions',
		path: "/views/view_physicalconditions",
		templateUrl : 'views/view_physicalconditions.html',
	},
	{
		label : 'mvr.humancharacteristics',
		path: "/views/view_humancharacteristics",
		templateUrl : 'views/view_humancharacteristics.html',
	},
	{
		label : 'mvr.handtypes',
		path: "/views/view_handtypes",
		templateUrl : 'views/view_handtypes.html',
	},
	{
		label : 'mvr.haircolors',
		path: "/views/view_haircolors",
		templateUrl : 'views/view_haircolors.html',
	},
	{
		label : 'mvr.facialhairtypes',
		path: "/views/view_facialhairtypes",
		templateUrl : 'views/view_facialhairtypes.html',
	},
	{
		label : 'mvr.eyecolors',
		path: "/views/view_eyecolors",
		templateUrl : 'views/view_eyecolors.html',
	},
	{
		label : 'mvr.',
		path: "/views/view_",
		templateUrl : 'views/view_.html',
	},
	{
		label : 'mvr.',
		path: "/views/view_",
		templateUrl : 'views/view_.html',
	}]
} ];



/*
 * FirstApp.config([ '$routeProvider', function($routeProvider) {
 * $routeProvider.when('/', { templateUrl : 'views/main.html', controller :
 * 'MainCtrl' });
 * 
 * $routeProvider.when('/login', { templateUrl : 'views/login.html', controller :
 * 'LoginController' });
 * 
 * $routeProvider.when('/cities', { templateUrl : 'views/city.html', controller :
 * 'CityController' });
 * 
 * $routeProvider.when('/countries', { templateUrl : 'views/country.html',
 * controller : 'CountryController' });
 * 
 * $routeProvider.when('/categories', { templateUrl : 'views/category.html',
 * controller : 'CategoryController' });
 * 
 * $routeProvider.when('/books/:id?', { templateUrl : 'views/book.html',
 * controller : 'BookController' });
 * 
 * $routeProvider.when('/404', { templateUrl : '404.html' });
 * $routeProvider.otherwise({ redirectTo : '/' }); } ]);
 */
FirstApp.config([ '$routeProvider', '$translateProvider',
		function($routeProvider, $translateProvider) {

			// Initialize angular-translate
			$translateProvider.useStaticFilesLoader({
				prefix : 'i18n/',
				suffix : '.json'
			});

			$translateProvider.preferredLanguage("en");

//			$routeProvider.when('/', {
//				templateUrl : 'views/main.html',
//				controller : 'MainCtrl'
//			});
//
//			$routeProvider.when('/view/view_ethnicity', {
//				templateUrl : 'views/view_ethnicity.html'
//			});
			
			for(var i=0;i<menuData.length;i++){
				var items=menuData[i]["items"];
				for(var j=0;j<items.length;j++){
					var temp=items[j];
					var path=temp['path'];
					if(Object.keys(temp).length==3){
						$routeProvider.when(path, {
							"templateUrl":temp['templateUrl']
						});
					}
					else if(Object.keys(temp).length==4){
						$routeProvider.when(path, {
							templateUrl:temp['templateUrl'],
							controller:temp['controller']
						});
					}
					else
						alert("ERROR in router.js");
				}
			}

			$routeProvider.when('/404', {
				templateUrl : '404.html'
			});
//			$routeProvider.otherwise({
//				redirectTo : '/'
//			});

		} ]);
