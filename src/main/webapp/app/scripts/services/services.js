FirstApp.factory('ExternalFunctionsResolver', [ 'ExternalFunctions',
		function(ExternalFunctions) {
			return {
				get : function(method) {
					if (typeof ExternalFunctions[method] === 'function') {
						return ExternalFunctions[method];
					} else {
						return method;
					}
				}
			};
		} ]);

FirstApp.factory('ExternalFunctions', [ '$resource', '$filter',
		function($resource, $filter) {
			return {
				groupByTypeName : function(item) {
					return item.type.name;
				}
			};
		} ]);