<!doctype html>
<html class="no-js">

<head>
    <meta charset="utf-8">
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

<body ng-app="avAngularStartupApp">
    <!--[if lt IE 7]>
	<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade
	    your browser</a> to improve your experience.</p>
	<![endif]-->

    <!-- Add your site or application content here -->
    <div class="container" role="main">
        <nav class="navbar navbar-default" ng-controller="MenuController">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->               
                <div class="navbar-header">           
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="logo" href="http://www.mvr.gov.mk/">
       					 <img src="images/police.png" src="macedonian police logo"/>
     				</a>               
                    <a class="navbar-brand" href="#">{{'menu.crime_Map' | translate}}</a>
                    
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="#/">{{'menu.home' | translate }} <span class="sr-only">(current)</span></a>
                        </li>

                        <li class="dropdown" ng-repeat="topMenu in menu">
                            <a class="dropdown-toggle" href="javascript: false" data-toggle="dropdown" role="button" aria-expanded="false">{{topMenu.name | translate}} <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li ng-repeat="item in topMenu.items">
                                    <a ng-href="{{ '#' + item.path}}">{{item.label | translate}}</a>
                                </li>
                            </ul>
                        </li>
                        
                    </ul>

                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->
        </nav>


        <div class="">
            <!-- 
	    		ng-view is directive that declares that the element will be 
	    		place holder for the partial files included through the router
	    	 -->
            <div ng-view></div>
        </div>

        <div class="footer">
            <p>
                All rigths reserved.  
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
    <!-- endbower -->
    <!-- endbuild -->

    <!-- These scripts hold the code of the application -->
    <!-- build:js({.tmp,app}) scripts/scripts.js -->
    <!-- The definition and the configuration of the application module -->

    <script src="scripts/app.js"></script>
    <!-- The route configuration -->
    <script src="scripts/menuData.js"></script>
    <script src="scripts/router.js"></script>
    <script src="scripts/config.js"></script>
    
    <script src="scripts/filter/filters.js"></script>

    <!-- controllers definition -->
    <script src="scripts/controllers/main.js"></script>
    <!--   <script src="scripts/controllers/city.js"></script>
    <script src="scripts/controllers/country.js"></script>
    <script src="scripts/controllers/category.js"></script>
    <script src="scripts/controllers/book.js"></script>
    <script src="scripts/controllers/login.js"></script> -->
    <script src="scripts/controllers/menuController.js"></script>
    <script src="scripts/controllers/specifiedPersonController.js"></script>
    <script src="scripts/controllers/unspecifiedPersonController.js"></script>
    <script src="scripts/controllers/eventController.js"></script>
    <script src="scripts/controllers/municipalityControler.js"></script>
    <script src="scripts/controllers/uploadController.js"></script>
    <!-- Services definition -->
    <script src="scripts/services/services.js"></script>
    <!--  <script src="scripts/services/category.js"></script> -->
    <script src="scripts/services/crud.js"></script>
    <!--    <script src="scripts/services/user.js"></script> -->

    <script src="scripts/directives/combo.js"></script>
    <script src="scripts/directives/combo2.js"></script>
    <script src="scripts/directives/crud-directive.js"></script>
    <script>
        $(document).ready(function() {
            $('.dropdown-toggle').click(function() {
                var location = $(this).attr('href');
                $(this).addClass("active");
                window.location.href = location;
                return false;
            });

            $('li').hover(function() {
                $(this).addClass("active");
            }, function() {
                $(this).removeClass("active");
            });
        })
    </script>
    <!-- endbuild -->
</body>

</html>