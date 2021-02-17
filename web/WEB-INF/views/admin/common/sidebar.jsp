<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sidebar</title>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords"
        content="wrappixel, admin dashboard, html css dashboard, web dashboard, bootstrap 4 admin, bootstrap 4, css3 dashboard, bootstrap 4 dashboard, Ample lite admin bootstrap 4 dashboard, frontend, responsive bootstrap 4 admin template, Ample admin lite dashboard bootstrap 4 dashboard template">
    <meta name="description"
        content="Ample Admin Lite is powerful and clean admin dashboard template, inpired from Bootstrap Framework">
    <meta name="robots" content="noindex,nofollow">
    <title>HelloPT System administrator</title>
    <link rel="canonical" href="https://www.wrappixel.com/templates/ample-admin-lite/" />
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="plugins/images/favicon.png">
    <!-- Custom CSS -->
  <!--  <link href="/semi/views/admin/css/style.min.css" rel="stylesheet">
   <link href="/semi/views/admin/css/style.css" rel="stylesheet"> -->
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

<!-- Custom CSS -->
    <link href="plugins/bower_components/chartist/dist/chartist.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/semi/resources/admin/plugins/bower_components/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.css">

	<link rel="stylesheet" href="/semi/resources/admin/css/style.min.css">
	<link rel="stylesheet" href="/semi/resources/admin/css/style.css">
	<link rel="stylesheet" href="/semi/resources/admin/css/admin.css">
	<script src="/semi/resources/js/event.js"></script>
</head>
<body>

	<aside class="left-sidebar" data-sidebarbg="skin6">
            <!-- Sidebar scroll-->
            <div class="scroll-sidebar">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav">
                    <ul id="sidebarnav">
                        <!-- User Profile-->
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link"
                                 aria-expanded="false">
                                <span class="hide-menu">---------- 회원관리 ----------</span></a>
                        </li>
                        <li class="sidebar-item"> <p class="sidebar-link waves-effect waves-dark sidebar-link"
                                id="adminMember" aria-expanded="false"><i class="fa fa-users"
                                    aria-hidden="true"></i><span class="hide-menu">일반회원관리</span></p></li>
                        <li class="sidebar-item"> <p class="sidebar-link waves-effect waves-dark sidebar-link"
                                id="adminTrainer" aria-expanded="false">
                                <i class="fa fa-id-card" aria-hidden="true"></i><span class="hide-menu">트레이너관리</span></p>
                        </li>
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link"
                                href="report.html" aria-expanded="false">
                                <i class="fa fa-bullhorn" aria-hidden="true"></i><span class="hide-menu">신고관리</span></a>
                        </li>
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link"
                                href="blackList.html" aria-expanded="false">
                                <i class="fa fa-ban" aria-hidden="true"></i><span class="hide-menu">블랙리스트</span></a>
                        </li>
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link"
                                 aria-expanded="false">
                                <span class="hide-menu">---------- 결제관리 ----------</span></a>
                        </li>
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link"
                                href="memberPayment.html" aria-expanded="false"><i class="fa fa-won-sign"
                                    aria-hidden="true"></i><span class="hide-menu">회원 결제관리</span></a></li>
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link"
                                href="ptPage.html" aria-expanded="false"><i class="fa fa-hands-helping"
                                    aria-hidden="true"></i><span class="hide-menu">PT관리</span></a></li>
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link"
                                href="map-google.html" aria-expanded="false"><i class="fa fa-th-list"
                                    aria-hidden="true"></i><span class="hide-menu">멤버쉽 관리</span></a></li>
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link"
                                href="blank.html" aria-expanded="false"><i class="fa fa-hourglass"
                                    aria-hidden="true"></i><span class="hide-menu">기간 정산 관리</span></a></li>
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link"
                                href="404.html" aria-expanded="false"><i class="fa fa-chart-bar"
                                    aria-hidden="true"></i><span class="hide-menu">종합 통계</span></a></li>
                                    <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link"
                                href="404.html" aria-expanded="false"><i class="fa fa-redo"
                                    aria-hidden="true"></i><span class="hide-menu">환불</span></a></li>
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link"
                                 aria-expanded="false">
                                <span class="hide-menu">---------- 수업관리 ----------</span></a>
                        </li>
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link"
                                href="404.html" aria-expanded="false"><i class="fa fa-plus"
                                    aria-hidden="true"></i><span class="hide-menu">수업 등록 관리</span></a></li>
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link"
                                href="404.html" aria-expanded="false"><i class="fa fa-comments"
                                    aria-hidden="true"></i><span class="hide-menu">리뷰</span></a></li>
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link"
                                href="404.html" aria-expanded="false"><i class="fa fa-play"
                                    aria-hidden="true"></i><span class="hide-menu">영상관리</span></a></li>
                             
                    </ul>

                </nav>
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->
        </aside>

	<!-- All Jquery -->
    <!-- ============================================================== -->
    <script src="/semi/resources/admin/plugins/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src="/semi/resources/admin/plugins/bower_components/popper.js/dist/umd/popper.min.js"></script>
    <script src="/semi/resources/admin/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="/semi/resources/admin/js/app-style-switcher.js"></script>
    <script src="/semi/resources/admin/plugins/bower_components/jquery-sparkline/jquery.sparkline.min.js"></script>
    <!--Wave Effects -->
    <script src="/semi/resources/admin/js/waves.js"></script>
    <!--Menu sidebar -->
    <script src="/semi/resources/admin/js/sidebarmenu.js"></script>
    <!--Custom JavaScript -->
    <script src="/semi/resources/admin/js/custom.js"></script>
    <!--This page JavaScript -->
    <!--chartis chart-->
    <script src="/semi/resources/admin/plugins/bower_components/chartist/dist/chartist.min.js"></script>
    <script src="/semi/resources/admin/plugins/bower_components/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.min.js"></script>
    <script src="/semi/resources/admin/js/pages/dashboards/dashboard1.js"></script>
	
</body>
</html>