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
    '$filter',
    "ngTableParams",
    function($scope, $http, $filter, ngTableParams) {
        $scope.entities = []; // se koristi
        $scope.cases = []; // se koristi
        $scope.entity = {}; // se koristi
        $scope.mode = true;
        $scope.casesTotal = {};
        $scope.selected = null;
        $scope.selectedCity = null;
        $scope.selectedCase = null;
        $scope.eventsByCase = false;
        $scope.click = true;
        //only for public
        $scope.map = true; // se koristi
        $scope.Date = {
            from: moment("01.01.2000","dd.MM.YYYY").toDate(),
            to: moment().format()
        };
        
        console.log(moment.unix(1318781876).toDate());
        //new variables
        $scope.municipalities = {};
        $scope.displayed = [];
        $scope.dataCount = null;
        
        $scope.numberOfCases = function(mid) {
            for (var v in $scope.entity)
                if ($scope.entity[v][0] == mid.toString())
                    return $scope.entity[v][3];
            return 0;
        }

        $scope.pathClick = function(entity) {
            var el = $("#path-" + entity.id);
            console.log(el);
        };

        //work only in public
        $scope.returnToMap = function() {
            $scope.map = true;
            $scope.dataCount = null;
        }

        $scope.select = function(p) {
            $scope.map = false;
            $scope.selectedCity = p;
            $scope.click = true;
            $scope.eventsByCase = false;
//            $scope.displayed = [];
            $scope.eventsByCase = false;

            if ($scope.mode) {
                var from = $filter('date')($scope.Date.from, 'yyyy-MM-dd');
                var to = $filter('date')($scope.Date.to, 'yyyy-MM-dd');
                $http.get('/data/rest/Event/count/' + p["id"] + '/' + from + '/' + to).success(
                    function(data, status, headers, config) {
                        $scope.selected = data;
                    });
            } else {
                $scope.displayCase($scope.myCase['id'], false);
            }
        }

        $scope.textX = function(entity) {
            if (!entity)
                0;
            if (!$scope.svg)
                return 0;
            var el = $("#path-" + entity['id']);
            if (!el[0]) return 0;
            return el[0].getBoundingClientRect().left - $scope.svg[0].getBoundingClientRect().left + el[0].getBoundingClientRect().width / 4;
        }

        $scope.textY = function(entity) {
            if (!entity)
                0;
            if (!$scope.svg)
                return 0;
            var el = $("#path-" + entity['id']);
            if (!el[0]) return 0;
            return el[0].getBoundingClientRect().top - $scope.svg[0].getBoundingClientRect().top + el[0].getBoundingClientRect().height / 2;
        }
        
        $scope.prosek = function(mid, residents) {
        	 var caseCount = 0;
             for (var v in $scope.entity) {
                 if ($scope.entity[v][0] == mid.toString()) {
                     caseCount = $scope.entity[v][3];
                     break;
                 }
             }
             var value = caseCount * residents / 100000;
             value = Math.round(value);
             return value;
        }

        $scope.color = function(mid, residents) {
            if (!mid || !residents) {
                return "green"
            }
            if (!$scope.svg)
                return 0;
            var caseCount = 0;
            for (var v in $scope.entity) {
                if ($scope.entity[v][0] == mid.toString()) {
                    caseCount = $scope.entity[v][3];
                    break;
                }
            }
            var value = caseCount * residents / 100000;
            value = Math.floor(value);
            
            var red = value + 70;
            var green = (255 - value);
            red = red > 255 ? 255 : red;
            green = green < 0 ? 0 : green;

            if(value > 120)
            	return "rgb(255,"+ green+", 0)";
            else
            	return "rgb("+red+", 200, 0)";
        }

        $scope.reload = function() {
            $scope.selected = null;
            $scope.selectedCity = null;
            $scope.selectedCase = null;
            $scope.eventsByCase = false;
            $scope.dataCount = null;
            $scope.map = true;
            if ($scope.myCase["id"] == 0) {
                $scope.mode = true;
                $scope.entity = $scope.entities[0];
            } else {
                $scope.mode = false;
                var flag = true;
                var temp = {};
                for (var m in $scope.entities) {
                    if ($scope.entities[m][0][4] == $scope.myCase["id"]) {
                        $scope.entity = $scope.entities[m];
                        flag = false;
                        break;
                    }
                    if ($scope.entities[m][0][4] === null)
                        temp = $scope.entities[m];

                }
                if (flag)
                    $scope.entity = temp;
            }
           
        }

        $scope.displayCase = function(id, flag) {
            if (flag) {
                $scope.click = false;
            }
            var from = $filter('date')($scope.Date.from, 'yyyy-MM-dd');
            var to = $filter('date')($scope.Date.to, 'yyyy-MM-dd');

            $scope.eventsByCase = true;
            $scope.selectedCase = id;
            if($scope.tableState != null){
            	$scope.tableState.pagination.start = 1;
                $scope.callServer($scope.tableState);
            }
        }

        var serverAPI = function() {
            var from = $filter('date')($scope.Date.from, 'yyyy-MM-dd');
            var to = $filter('date')($scope.Date.to, 'yyyy-MM-dd');

            //Get all EventCases
            $http.get('/data/rest/EventCase/all').success(
                function(data, status, headers, config) {
                    $scope.cases.push({
                        'id': 0,
                        'name': 'all events'
                    });
                    $scope.myCase = $scope.cases[0];
                    for (var i in data) {
                        $scope.cases.push(data[i]);
                    }
                });

            //Get all Municipalities
            $http.get('/data/rest/Municipality/all').success(
                function(data, status, headers, config) {
                    $scope.municipalities = data;

                });

            //Get all Events by Case and Municipality
            $http.get('/data/rest/Event/all/' + from + '/' + to).success(
                function(data, status, headers, config) {
                    $scope.svg = $("svg");
                    $scope.entities = data;
                    $scope.entity = $scope.entities[0];
                });
        }

        $scope.changeDate = function() {
            $scope.entities = [];
            $scope.cases = [];
            $scope.entity = {};
            $scope.mode = true;
            $scope.count = 0;
            $scope.casesTotal = {};
            $scope.selected = null;
            $scope.selectedCity = null;
            $scope.selectedCase = null;
            $scope.eventsByCase = false;
            $scope.click = true;
            $scope.dataCount = null;
            serverAPI();
        }

        serverAPI();

        $scope.getPage = function(start, number,tableState) {
            var from = $filter('date')($scope.Date.from, 'yyyy-MM-dd');
            var to = $filter('date')($scope.Date.to, 'yyyy-MM-dd');
            var page;
            if(start <= 1)
            	page = 1;
            else 
            	page=  Math.ceil(start/number) + 1;
            
            $http.get('/data/rest/Event/paged?count=' + number + '&filter[caseByMunicipality]={"caseId":' + $scope.selectedCase + ',"mid":' + $scope.selectedCity["id"] + ',"from":"' + from + '","to":"' + to + '"}&page=' + page).success(
            	function(data, status, headers, config) {
                	 $scope.displayed = data.content;
                     tableState.pagination.numberOfPages = Math.ceil(data.totalElements / number); //set the number of pages so the pagination can update
                     $scope.isLoading = false;
                     $scope.dataCount = data.totalElements;
                });
        }

        $scope.callServer = function callServer(tableState) {
        	$scope.tableState = tableState;
            $scope.isLoading = true;

            var pagination = tableState.pagination;

            var start = pagination.start || 1; // This is NOT the page number, but the index of item in the list that you want to use to display the table.
            var number = pagination.number || 10; // Number of entries showed per page.
    
            $scope.getPage(start, number,tableState);
        };
    }
]);


FirstApp.controller('ImportController', ['$scope', 'crudService',

    function($scope, crudService) {
        $scope.save = function() {
            var regex = /"id":[^,]*,/gi;
            var content = $scope.entities.replace(regex, "");
            crudService($scope.service).import(content);
        };
    }
]);