/**
 * Created by ristes on 21.6.15.
 * Wrapper of the smart table for simpler usage that provides server paging by default
 *
 */

FirstApp.directive('ivSimpleTable', ['crudService', function(crudService) {

  return {
    restrict: 'E',
    transclude: true,
    templateUrl: 'directives/iv-simple-table.html',
    scope: {
      /**
       * The path that will be used by the crud service to load the data
       */
      path: '@',
      /**
       * An array with the fields of the columns.
       * Example:
       * [ 'firstName', 'lastName', 'organization.name' ]
       *
       * for the field 'organization.name' the label will be transformed in organization_name,
       * and in each row the organization field is evaluated, and if it exists, then its name is displayed.
       * If no organization field is present in the row, nothing is displayed
       */
      columns: '=',
      /**
       * If set to true, displays one input field for global search
       */
      globalFilter: '=',
      /**
       * If set to true, displays one input field filter for each column
       */
      columnFilter: '=',
      /**
       * If set to true, transcludes the content of the columns. If not, the columns are automatically generated
       */
      customColumns: '=',
      /**
       * State transition expression that will be used on edit button click
       */
      edit: '@',
      pageSize: '='
    },
    controller: function($scope) {
      var service = crudService($scope.path);

      $scope.itemsPerPage = $scope.pageSize || 10;

      /**
       * The function used by 'st-pipe'. Loads the page data from the server.
       * @param tableState
       */
      $scope.load = function(tableState) {
        $scope.isLoading = true;
        console.log(tableState);

        var pagination = tableState.pagination;

        var start = pagination.start || 1;     // This is NOT the page number, but the index of item in the list that you want to use to display the table.
        var number = pagination.number || 10;  // Number of entries showed per page.

        service.paged({
          page: start,
          count: number,
          filter: tableState.search.predicateObject
        }, function(result) {
          $scope.displayed = result.content;
          tableState.pagination.numberOfPages = result.totalElements / number;//set the number of pages so the pagination can update
          $scope.isLoading = false;
        });
      }
    }
  };
}]);