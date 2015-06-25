<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html class="no-js">

<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <!-- build:css(.) styles/vendor.css -->
    <!-- bower:css -->
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.css" />
    <link rel="stylesheet" href="bower_components/AngularJS-Toaster/toaster.css" />
    <link rel="stylesheet" href="bower_components/angular-loading-bar/build/loading-bar.css" />
    <link rel="stylesheet" href="bower_components/angular-motion/dist/angular-motion.css" />
    <link rel="stylesheet" href="bower_components/fullcalendar/dist/fullcalendar.css" />
    <link rel="stylesheet" href="bower_components/select2/select2.css" />
    <link rel="stylesheet" href="bower_components/bootstrap-markdown/css/bootstrap-markdown.min.css" />
    <link rel="stylesheet" href="bower_components/datetimepicker/jquery.datetimepicker.css" />
    <link rel="stylesheet" href="bower_components/ng-table/ng-table.css" />
    <link rel="stylesheet" href="bower_components/ngQuickDate/dist/ng-quick-date.css" />
    <link rel="stylesheet" href="bower_components/ngQuickDate/dist/ng-quick-date-default-theme.css" />
    <!-- endbower -->
    <!-- endbuild -->
    <!-- build:css(.tmp) styles/main.css -->
    <link rel="stylesheet" href="styles/main.css">
    <!-- endbuild -->

    <script type="text/javascript">
        var _contextPath = "${pageContext.request.contextPath}";
    </script>
</head>
<!-- 
	ng-app is directive that declares that the element 
	and its children will be handled by angular.js 
-->

<body ng-app="avAngularStartupApp" class="main-body">
    <!--[if lt IE 7]>
	<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade
	    your browser</a> to improve your experience.</p>
	<![endif]-->
	<div class="background">
		<div class="header_bottom">
                <div class="mvr_mk">РЕПУБЛИКА МАКЕДОНИЈА <br> 
                МИНИСТЕРСТВО ЗА ВНАТРЕШНИ РАБОТИ
                <br/>
                Мапа на криминал</div>
                <div class="mvr_logo"></div>
                <div class="mvr_en">REPUBLIC OF MACEDONIA 
                <br> MINISTRY OF INTERNAL AFFAIRS
                <br/>
                Crime map</div>
        </div>
	</div>

    <!-- Add your site or application content here -->
    <div class="container" role="main">
        <div class="">
            <!-- 
	    		ng-view is directive that declares that the element will be 
	    		place holder for the partial files included through the router
	    	 -->
            <div ng-view></div>
        </div>
    </div>



    <!-- build:js(.) scripts/oldieshim.js -->
    <!--[if lt IE 9]>
			<script src="bower_components/es5-shim/es5-shim.js"></script>
			<script src="bower_components/json3/lib/json3.js"></script>
		<![endif]-->
    <!-- endbuild -->

    <!-- build:js(.) scripts/vendor.js -->
    <!-- bower:js -->
    <script src="bower_components/jquery/jquery.js"></script>
    <script src="bower_components/angular/angular.js"></script>
    <script src="bower_components/angular-route/angular-route.js"></script>
    <script src="bower_components/angular-resource/angular-resource.js"></script>
    <script src="bower_components/angular-cookies/angular-cookies.js"></script>
    <script src="bower_components/angular-animate/angular-animate.js"></script>
    <script src="bower_components/angular-sanitize/angular-sanitize.js"></script>
    <script src="bower_components/bootstrap/dist/js/bootstrap.js"></script>
    <script src="bower_components/jquery-cookie/jquery.cookie.js"></script>
    <script src="bower_components/jquery-ui/jquery-ui.js"></script>
    <script src="bower_components/angular-bootstrap/ui-bootstrap-tpls.js"></script>
    <script src="bower_components/angular-strap/dist/angular-strap.min.js"></script>
    <script src="bower_components/angular-strap/dist/angular-strap.tpl.min.js"></script>
    <script src="bower_components/AngularJS-Toaster/toaster.js"></script>
    <script src="bower_components/angular-loading-bar/build/loading-bar.js"></script>
    <script src="bower_components/angular-translate/angular-translate.js"></script>
    <script src="bower_components/angular-translate-loader-static-files/angular-translate-loader-static-files.js"></script>
    <script src="bower_components/angular-translate-storage-cookie/angular-translate-storage-cookie.js"></script>
    <script src="bower_components/moment/moment.js"></script>
    <script src="bower_components/fullcalendar/dist/fullcalendar.js"></script>
    <script src="bower_components/angular-ui-calendar/src/calendar.js"></script>
    <script src="bower_components/select2/select2.js"></script>
    <script src="bower_components/angular-ui-select2/src/select2.js"></script>
    <script src="bower_components/bootstrap-markdown/js/bootstrap-markdown.js"></script>
    <script src="bower_components/datetimepicker/jquery.datetimepicker.js"></script>
    <script src="bower_components/jquery-textcomplete/dist/jquery.textcomplete.min.js"></script>
    <script src="bower_components/momentjs/moment.js"></script>
    <script src="bower_components/ng-file-upload/angular-file-upload.js"></script>
    <script src="bower_components/ng-table/ng-table.js"></script>
    <script src="bower_components/ng-table-export/ng-table-export.js"></script>
    <script src="bower_components/ngQuickDate/dist/ng-quick-date.js"></script>
    <script src="bower_components/angular-smart-table/dist/smart-table.min.js"></script>
    <!-- endbower -->
    <!-- endbuild -->

    <!-- These scripts hold the code of the application -->
    <!-- build:js({.tmp,app}) scripts/scripts.js -->
    <!-- The definition and the configuration of the application module -->

    <script src="scripts/app.js"></script>
    <!-- The route configuration -->
<!--     <script src="scripts/menuData.js"></script> -->
    <script src="scripts/public_router.js"></script>
    <script src="scripts/config.js"></script>
    
    <script src="scripts/filter/filters.js"></script>

    <!-- controllers definition -->
    <script src="scripts/controllers/main.js"></script>
    <script src="scripts/controllers/menuController.js"></script>
    <script src="scripts/controllers/specifiedPersonController.js"></script>
    <script src="scripts/controllers/unspecifiedPersonController.js"></script>
    <script src="scripts/controllers/eventController.js"></script>
    <script src="scripts/controllers/municipalityControler.js"></script>
    <script src="scripts/controllers/uploadController.js"></script>
    <!-- Services definition -->
    <script src="scripts/services/services.js"></script>
    <script src="scripts/services/crud.js"></script>

    <script src="scripts/directives/combo.js"></script>
    <script src="scripts/directives/combo2.js"></script>
    <script src="scripts/directives/crud-directive.js"></script>
    <script src="scripts/directives/iv-simple-table.js"></script>
    <!-- endbuild -->
</body>

</html>