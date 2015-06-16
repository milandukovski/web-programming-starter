'use strict';

/**
 * @ngdoc Definition of the application module. The first argument is the name
 *        of the module. It is used in the ng-app directive to expose the
 *        angular components that can be used. The second argument is an array
 *        that defines the dependencies (modules) that are used by the
 *        application. In this case we are only use the ngRoute module as a
 *        dependency in order to provide partial content inclusion through the
 *        routes
 * @see router.js for more information
 * @name avAngularStartupApp - the name of the module used in the ng-app
 *       directive
 * @description # avAngularStartupApp Main module of the application.
 */
var FirstApp = angular.module('avAngularStartupApp', ['ngResource', 'ngRoute',
  'ngAnimate', 'ngTable', 'ngTableExport', 'ngCookies', 'ngQuickDate',
  'chieffancypants.loadingBar', 'ui.bootstrap', 'ui.select2',
  'mgcrea.ngStrap', 'toaster', 'angularFileUpload',
  'pascalprecht.translate']);

FirstApp.config(['$translateProvider', '$httpProvider', 'ngQuickDateDefaultsProvider', 'settings',
  function($translateProvider, $httpProvider, ngQuickDateDefaultsProvider, settings) {


    $httpProvider.interceptors.push('HRHttpInterceptors');
    Date.prototype.toJSON = function() {
      return moment(this).format('YYYY-MM-DD HH:mm');
    };

    Date.prototype.toISOString = function() {
      return moment(this).format('YYYY-MM-DD HH:mm');
    };
  }]);
