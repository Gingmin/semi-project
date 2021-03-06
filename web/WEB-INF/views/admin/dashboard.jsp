<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

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
	
	<!-- 그래프  -->
	<!-- jQuery -->
    <script src="https://code.jquery.com/jquery.min.js"></script>
    <!-- google charts -->
     <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	
</head>
<body>
	  <!-- ============================================================== -->
    <!-- Preloader - style you can find in spinners.css -->
    <!-- ============================================================== -->
    <div class="preloader">
        <div class="lds-ripple">
            <div class="lds-pos"></div>
            <div class="lds-pos"></div>
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- Main wrapper - style you can find in pages.scss -->
    <!-- ============================================================== -->
    <div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5" data-sidebartype="full"
        data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full">
        <!-- ============================================================== -->
        <!-- Topbar header - style you can find in pages.scss -->
        <!-- ============================================================== -->
        <header class="topbar" data-navbarbg="skin5">
            <nav class="navbar top-navbar navbar-expand-md navbar-dark">
                <div class="navbar-header" data-logobg="skin6">
                    <!-- ============================================================== -->
                    <!-- Logo -->
                    <!-- ============================================================== -->
                    <a class="navbar-brand" href="${ pageContext.servletContext.contextPath }/admin/dashboard">
                        <span class="logo-text">
                            <img src="/semi/resources/admin/plugins/images/logo.png" alt="homepage" />
                        </span>
                    </a>
                    <!-- ============================================================== -->
                    <!-- End Logo -->
                    <!-- ============================================================== -->
                    <!-- ============================================================== -->
                    <!-- toggle and nav items -->
                    <!-- ============================================================== -->
                    <a class="nav-toggler waves-effect waves-light text-dark d-block d-md-none"
                        href="javascript:void(0)"><i class="ti-menu ti-close"></i></a>
                </div>
                <!-- ============================================================== -->
                <!-- End Logo -->
                <!-- ============================================================== -->
                <div class="navbar-collapse collapse" id="navbarSupportedContent" data-navbarbg="skin5">
                    <ul class="navbar-nav d-none d-md-block d-lg-none">
                        <li class="nav-item">
                            <a class="nav-toggler nav-link waves-effect waves-light text-white"
                                href="javascript:void(0)"><i class="ti-menu ti-close"></i></a>
                        </li>
                    </ul>
                    <!-- ============================================================== -->
                    <!-- Right side toggle and nav items -->
                    <!-- ============================================================== -->
                    <ul class="navbar-nav ml-auto d-flex align-items-center">

                        <!-- ============================================================== -->
                        <!-- Search -->
                        <!-- ============================================================== -->
                        <li class=" in">
                            <form role="search" class="app-search d-none d-md-block mr-3">
                                <input type="text" placeholder="Search..." class="form-control mt-0">
                                <a href="" class="active">
                                    <i class="fa fa-search"></i>
                                </a>
                            </form>
                        </li>
                        <!-- ============================================================== -->
                        <!-- User profile and search -->
                        <!-- ============================================================== -->
                        <li class="temp"><div class="profile-pic" href=""> <img
								src="/semi/resources/admin/plugins/images/close.png"
								alt="closeAdmin" width="36" class="close" id="closeAdmin"></div></li>
                        <!-- ============================================================== -->
                        <!-- User profile and search -->
                        <!-- ============================================================== -->
                    </ul>
                </div>
            </nav>
        </header>
        <!-- ============================================================== -->
        <!-- End Topbar header -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <jsp:include page="common/sidebar.jsp"/>
        <!-- ============================================================== -->
        <!-- End Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        <div class="page-wrapper">
            <!-- ============================================================== -->
            <!-- Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <div class="page-breadcrumb bg-white">
                <div class="row align-items-center">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title text-uppercase font-medium font-14">종합통계</h4><br>
                    </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                        <div class="d-md-flex">
                            <ol class="breadcrumb ml-auto">
                                <!-- <li><a href="#">Dashboard</a></li> -->
                            </ol>
                            <!-- ============================================================== -->
                            <!-- 검색 폼 시작 -->
                           
                            
                        </div>
                    </div>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- ============================================================== -->
            <!-- End Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid">
                <!-- ============================================================== -->
                <!-- Three charts -->
                <!-- ============================================================== -->
                 <form action="" method="">
	                <div class="row">
	                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
	                        <div class="white-box">
		                        <div class="box_detail1">
		                            <div class="box-title1">
		                            	기간
		                            	<input class="input_detail" type="date" id="searchDate1" name="searchDate1" value="">
										<input class="input_detail" type="date" id="searchDate2" name="searchDate2" value="">    
		                       		</div>
		                            <button type="submit"
		                                class="btn btn-danger  d-none d-md-block pull-right m-l-20 hidden-xs hidden-sm waves-effect waves-light type">
		                            	조회</button>
		                        </div>
	                        </div>
	                    </div>
	                </div>
	                
	                
	                <div id="Line_Controls_Chart">
	                  <!-- 라인 차트 생성할 영역 -->
				      <div id="lineChartArea" style="padding:0px 20px 0px 0px;"></div>
				      <!-- 컨트롤바를 생성할 영역 -->
				      <div id="controlsArea" style="padding:0px 20px 0px 0px;"></div>
				    </div>
	                
	                
	                <div class="row justify-content-center">
	                    <div class="col-lg-4 col-sm-6 col-xs-12">
	                        <div class="white-box analytics-info">
	                            <h3 class="box-title">회원</h3>
	                            <ul class="list-inline two-part d-flex align-items-center mb-0">
	                                <li>
	                                    <div id="sparklinedash"><canvas width="67" height="30"
	                                            style="display: inline-block; width: 67px; height: 30px; vertical-align: top;"></canvas>
	                                    </div>
	                                </li>
	                                <li class="ml-auto"><span class="counter text-success" ><c:out value="${ requestScope.members }"/>명</span></li>
	                            </ul>
	                        </div>
	                    </div>
	                    <div class="col-lg-4 col-sm-6 col-xs-12">
	                        <div class="white-box analytics-info">
	                            <h3 class="box-title">트레이너</h3>
	                            <ul class="list-inline two-part d-flex align-items-center mb-0">
	                                <li>
	                                    <div id="sparklinedash2"><canvas width="67" height="30"
	                                            style="display: inline-block; width: 67px; height: 30px; vertical-align: top;"></canvas>
	                                    </div>
	                                </li>
	                                <li class="ml-auto"><span class="counter text-purple"><c:out value="${ requestScope.trainers }"/> 명</span></li>
	                            </ul>
	                        </div>
	                    </div>
	                    <div class="col-lg-4 col-sm-6 col-xs-12">
	                        <div class="white-box analytics-info">
	                            <h3 class="box-title">블랙 리스트</h3>
	                            <ul class="list-inline two-part d-flex align-items-center mb-0">
	                                <li>
	                                    <div id="sparklinedash3"><canvas width="67" height="30"
	                                            style="display: inline-block; width: 67px; height: 30px; vertical-align: top;"></canvas>
	                                    </div>
	                                </li>
	                                <li class="ml-auto"><span class="counter text-info"><c:out value="${ requestScope.blackLists }"/> 명</span>
	                                </li>
	                            </ul>
	                        </div>
	                    </div>
	                </div>
	                <div class="row justify-content-center">
	                    <div class="col-lg-4 col-sm-6 col-xs-12">
	                        <div class="white-box analytics-info">
	                            <h3 class="box-title">그룹 PT</h3>
	                            <ul class="list-inline two-part d-flex align-items-center mb-0">
	                                <li>
	                                    <div id="sparklinedash4"><canvas width="67" height="30"
	                                            style="display: inline-block; width: 67px; height: 30px; vertical-align: top;"></canvas>
	                                    </div>
	                                </li>
	                                <li class="ml-auto"><span class="counter text-success"><c:out value="${ requestScope.groupPT }"/> 개</span></li>
	                            </ul>
	                        </div>
	                    </div>
	                    <div class="col-lg-4 col-sm-6 col-xs-12">
	                        <div class="white-box analytics-info">
	                            <h3 class="box-title">1:1 PT</h3>
	                            <ul class="list-inline two-part d-flex align-items-center mb-0">
	                                <li>
	                                    <div id="sparklinedash5"><canvas width="67" height="30"
	                                            style="display: inline-block; width: 67px; height: 30px; vertical-align: top;"></canvas>
	                                    </div>
	                                </li>
	                                <li class="ml-auto"><span class="counter text-purple"><c:out value="${ requestScope.oneToOnePT }"/> 개</span></li>
	                            </ul>
	                        </div>
	                    </div>
	                    <div class="col-lg-4 col-sm-6 col-xs-12">
	                        <div class="white-box analytics-info">
	                            <h3 class="box-title">총 수업</h3>
	                            <ul class="list-inline two-part d-flex align-items-center mb-0">
	                                <li>
	                                    <div id="sparklinedash6"><canvas width="67" height="30"
	                                            style="display: inline-block; width: 67px; height: 30px; vertical-align: top;"></canvas>
	                                    </div>
	                                </li>
	                                <li class="ml-auto"><span class="counter text-info"><c:out value="${ requestScope.groupPT + requestScope.oneToOnePT }"/> 개</span>
	                                </li>
	                            </ul>
	                        </div>
	                    </div>
	                </div>
	                <div class="row justify-content-center">
	                    <div class="col-lg-4 col-sm-6 col-xs-12">
	                        <div class="white-box analytics-info">
	                            <h3 class="box-title">월이용권 구매 금액</h3>
	                            <ul class="list-inline two-part d-flex align-items-center mb-0">
	                                <li>
	                                    <div id="sparklinedash7"><canvas width="67" height="30"
	                                            style="display: inline-block; width: 67px; height: 30px; vertical-align: top;"></canvas>
	                                    </div>
	                                </li>
	                                <li class="ml-auto"><span class="counter text-success"><c:out value="${ requestScope.membershipGroup }"/> 원</span></li>
	                            </ul>
	                        </div>
	                    </div>
	                    <div class="col-lg-4 col-sm-6 col-xs-12">
	                        <div class="white-box analytics-info">
	                            <h3 class="box-title">1:1 PT권 구매 금액</h3>
	                            <ul class="list-inline two-part d-flex align-items-center mb-0">
	                                <li>
	                                    <div id="sparklinedash8"><canvas width="67" height="30"
	                                            style="display: inline-block; width: 67px; height: 30px; vertical-align: top;"></canvas>
	                                    </div>
	                                </li>
	                                <li class="ml-auto"><span class="counter text-purple"><c:out value="${ requestScope.membershipOneToOne }"/> 원</span></li>
	                            </ul>
	                        </div>
	                    </div>
	                    <div class="col-lg-4 col-sm-6 col-xs-12">
	                        <div class="white-box analytics-info">
	                            <h3 class="box-title">맴버십 총 결제 금액</h3>
	                            <ul class="list-inline two-part d-flex align-items-center mb-0">
	                                <li>
	                                    <div id="sparklinedash9"><canvas width="67" height="30"
	                                            style="display: inline-block; width: 67px; height: 30px; vertical-align: top;"></canvas>
	                                    </div>
	                                </li>
	                                <li class="ml-auto"><span class="counter text-info"><c:out value="${ requestScope.membershipGroup + requestScope.membershipOneToOne }"/> 원</span>
	                                </li>
	                            </ul>
	                        </div>
	                    </div>
	                </div>
	                
                </form>
                <!-- ============================================================== -->
                <!-- PRODUCTS YEARLY SALES -->
                <!-- ============================================================== -->
                <!-- <div class="row">
                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                        <div class="white-box">
                            <h3 class="box-title">Products Yearly Sales</h3>
                            
                        </div>
                    </div>
                </div> -->
                <!-- ============================================================== -->
                <!-- RECENT SALES -->
                <!-- ============================================================== -->
                <!-- <div class="row">
                    <div class="col-md-12 col-lg-12 col-sm-12">
                        <div class="white-box">
                            <div class="d-md-flex mb-3">
                                <h3 class="box-title mb-0">Recent sales</h3>
                                <div class="col-md-3 col-sm-4 col-xs-6 ml-auto">
                                    <select class="form-control row border-top">
                                        <option>March 2017</option>
                                        <option>April 2017</option>
                                        <option>May 2017</option>
                                        <option>June 2017</option>
                                        <option>July 2017</option>
                                    </select>
                                </div>
                            </div>
                            <div class="table-responsive">
                                <table class="table no-wrap">
                                    <thead>
                                        <tr>
                                            <th class="border-top-0">#</th>
                                            <th class="border-top-0">NAME</th>
                                            <th class="border-top-0">STATUS</th>
                                            <th class="border-top-0">DATE</th>
                                            <th class="border-top-0">PRICE</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td class="txt-oflo">Elite admin</td>
                                            <td>SALE</td>
                                            <td class="txt-oflo">April 18, 2017</td>
                                            <td><span class="text-success">$24</span></td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td class="txt-oflo">Real Homes WP Theme</td>
                                            <td>EXTENDED</td>
                                            <td class="txt-oflo">April 19, 2017</td>
                                            <td><span class="text-info">$1250</span></td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td class="txt-oflo">Ample Admin</td>
                                            <td>EXTENDED</td>
                                            <td class="txt-oflo">April 19, 2017</td>
                                            <td><span class="text-info">$1250</span></td>
                                        </tr>
                                        <tr>
                                            <td>4</td>
                                            <td class="txt-oflo">Medical Pro WP Theme</td>
                                            <td>TAX</td>
                                            <td class="txt-oflo">April 20, 2017</td>
                                            <td><span class="text-danger">-$24</span></td>
                                        </tr>
                                        <tr>
                                            <td>5</td>
                                            <td class="txt-oflo">Hosting press html</td>
                                            <td>SALE</td>
                                            <td class="txt-oflo">April 21, 2017</td>
                                            <td><span class="text-success">$24</span></td>
                                        </tr>
                                        <tr>
                                            <td>6</td>
                                            <td class="txt-oflo">Digital Agency PSD</td>
                                            <td>SALE</td>
                                            <td class="txt-oflo">April 23, 2017</td>
                                            <td><span class="text-danger">-$14</span></td>
                                        </tr>
                                        <tr>
                                            <td>7</td>
                                            <td class="txt-oflo">Helping Hands WP Theme</td>
                                            <td>MEMBER</td>
                                            <td class="txt-oflo">April 22, 2017</td>
                                            <td><span class="text-success">$64</span></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div> -->
                <!-- ============================================================== -->
                <!-- Recent Comments -->
                <!-- ============================================================== -->
                <!-- <div class="row">
                    .col
                    <div class="col-md-12 col-lg-8 col-sm-12">
                        <div class="white-box">
                            <h3 class="box-title mb-0">Recent Comments</h3>
                            <div class="comment-center">
                                <div class="comment-body d-flex">
                                    <div class="user-img"> <img src="/semi/resources/admin/plugins/images/users/pawandeep.jpg" alt="user"
                                            class="img-circle">
                                    </div>
                                    <div class="mail-contnet">
                                        <h5>Pavan kumar</h5><span class="time">10:20 AM 20 may 2016</span>
                                        <br>
                                        <div class="mb-3 mt-3">
                                            <span class="mail-desc">Donec ac condimentum massa. Etiam pellentesque
                                                pretium lacus. Phasellus ultricies dictum suscipit. Aenean commodo dui
                                                pellentesque molestie feugiat. Aenean commodo dui </span>
                                        </div>
                                        <a href="javacript:void(0)"
                                            class="btn btn btn-rounded btn-default btn-outline mb-2 mb-md-0 m-r-5"><i
                                                class="ti-check text-success m-r-5"></i>Approve</a><a
                                            href="javacript:void(0)" class="btn-rounded btn btn-default btn-outline"><i
                                                class="ti-close text-danger m-r-5"></i>
                                            Reject</a>
                                    </div>
                                </div>
                                <div class="comment-body d-flex">
                                    <div class="user-img"> <img src="/semi/resources/admin/plugins/images/users/sonu.jpg" alt="user"
                                            class="img-circle">
                                    </div>
                                    <div class="mail-contnet">
                                        <h5>Sonu Nigam</h5><span class="time">10:20 AM 20 may 2016</span>
                                        <br>
                                        <div class="mb-3 mt-3">
                                            <span class="mail-desc">Donec ac condimentum massa. Etiam pellentesque
                                                pretium lacus. Phasellus ultricies dictum suscipit. Aenean commodo dui
                                                pellentesque molestie feugiat. Aenean commodo dui </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="comment-body d-flex border-0">
                                    <div class="user-img"> <img src="/semi/resources/admin/plugins/images/users/arijit.jpg" alt="user"
                                            class="img-circle">
                                    </div>
                                    <div class="mail-contnet">
                                        <h5>Arijit singh</h5><span class="time">10:20 AM 20 may 2016</span>
                                        <br>
                                        <div class="mb-3 mt-3">
                                            <span class="mail-desc">Donec ac condimentum massa. Etiam pellentesque
                                                pretium lacus. Phasellus ultricies dictum suscipit. Aenean commodo dui
                                                pellentesque molestie feugiat. Aenean commodo dui </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-12 col-sm-12">
                        <div class="card">
                            <div class="card-heading">
                                CHAT LISTING
                            </div>
                            <div class="card-body">
                                <ul class="chatonline">
                                    <li>
                                        <div class="call-chat">
                                            <button class="btn btn-success text-white btn-circle btn" type="button">
                                                <i class="fas fa-phone"></i>
                                            </button>
                                            <button class="btn btn-info btn-circle btn" type="button">
                                                <i class="far fa-comments"></i>
                                            </button>
                                        </div>
                                        <a href="javascript:void(0)" class="d-flex align-items-center"><img
                                                src="/semi/resources/admin/plugins/images/users/varun.jpg" alt="user-img" class="img-circle">
                                            <div class="ml-2">
                                                <span class="text-dark text-muted">Varun Dhavan <small
                                                        class="d-block text-success d-block">online</small></span>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <div class="call-chat">
                                            <button class="btn btn-success text-white btn-circle btn" type="button">
                                                <i class="fas fa-phone"></i>
                                            </button>
                                            <button class="btn btn-info btn-circle btn" type="button">
                                                <i class="far fa-comments"></i>
                                            </button>
                                        </div>
                                        <a href="javascript:void(0)" class="d-flex align-items-center"><img
                                                src="/semi/resources/admin/plugins/images/users/genu.jpg" alt="user-img" class="img-circle">
                                            <div class="ml-2">
                                                <span class="text-dark text-muted">Genelia
                                                    Deshmukh <small class="d-block text-warning">Away</small></span>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <div class="call-chat">
                                            <button class="btn btn-success text-white btn-circle btn" type="button">
                                                <i class="fas fa-phone"></i>
                                            </button>
                                            <button class="btn btn-info btn-circle btn" type="button">
                                                <i class="far fa-comments"></i>
                                            </button>
                                        </div>
                                        <a href="javascript:void(0)" class="d-flex align-items-center"><img
                                                src="/semi/resources/admin/plugins/images/users/ritesh.jpg" alt="user-img" class="img-circle">
                                            <div class="ml-2">
                                                <span class="text-dark text-muted">Ritesh
                                                    Deshmukh <small class="d-block text-danger">Busy</small></span>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <div class="call-chat">
                                            <button class="btn btn-success text-white btn-circle btn" type="button">
                                                <i class="fas fa-phone"></i>
                                            </button>
                                            <button class="btn btn-info btn-circle btn" type="button">
                                                <i class="far fa-comments"></i>
                                            </button>
                                        </div>
                                        <a href="javascript:void(0)" class="d-flex align-items-center"><img
                                                src="/semi/resources/admin/plugins/images/users/arijit.jpg" alt="user-img" class="img-circle">
                                            <div class="ml-2">
                                                <span class="text-dark text-muted">Arijit
                                                    Sinh <small class="d-block text-muted">Offline</small></span>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <div class="call-chat">
                                            <button class="btn btn-success text-white btn-circle btn" type="button">
                                                <i class="fas fa-phone"></i>
                                            </button>
                                            <button class="btn btn-info btn-circle btn" type="button">
                                                <i class="far fa-comments"></i>
                                            </button>
                                        </div>
                                        <a href="javascript:void(0)" class="d-flex align-items-center"><img
                                                src="/semi/resources/admin/plugins/images/users/govinda.jpg" alt="user-img"
                                                class="img-circle">
                                            <div class="ml-2">
                                                <span class="text-dark text-muted">Govinda
                                                    Star <small class="d-block text-success">online</small></span>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <div class="call-chat">
                                            <button class="btn btn-success text-white btn-circle btn" type="button">
                                                <i class="fas fa-phone"></i>
                                            </button>
                                            <button class="btn btn-info btn-circle btn" type="button">
                                                <i class="far fa-comments"></i>
                                            </button>
                                        </div>
                                        <a href="javascript:void(0)" class="d-flex align-items-center"><img
                                                src="/semi/resources/admin/plugins/images/users/hritik.jpg" alt="user-img" class="img-circle">
                                            <div class="ml-2">
                                                <span class="text-dark text-muted">John
                                                    Abraham<small class="d-block text-success">online</small></span>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <div class="call-chat">
                                            <button class="btn btn-success text-white btn-circle btn" type="button">
                                                <i class="fas fa-phone"></i>
                                            </button>
                                            <button class="btn btn-info btn-circle btn" type="button">
                                                <i class="far fa-comments"></i>
                                            </button>
                                        </div>
                                        <a href="javascript:void(0)" class="d-flex align-items-center"><img
                                                src="/semi/resources/admin/plugins/images/users/varun.jpg" alt="user-img" class="img-circle">
                                            <div class="ml-2">
                                                <span class="text-dark text-muted">Varun
                                                    Dhavan <small class="d-block text-success">online</small></span>
                                            </div>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    /.col
                </div> -->
            </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- footer -->
            <!-- ============================================================== -->
            <footer class="footer text-center"> 2020 © HelloPT Admin brought to you by <a
                    href="#">www.HelloPT.com</a>
            </footer>
            <!-- ============================================================== -->
            <!-- End footer -->
            <!-- ============================================================== -->
        </div>
        <!-- ============================================================== -->
        <!-- End Page wrapper  -->
        <!-- ============================================================== -->
    </div>
    <!-- ============================================================== -->
    <!-- End Wrapper -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
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


<script>

  var chartDrowFun = {

    chartDrow : function(){
        var chartData = '';

        //날짜형식 변경하고 싶으시면 이 부분 수정하세요.
        var chartDateformat   = 'yyyy년MM월dd일';
        //라인차트의 라인 수
        var chartLineCount    = 10;
        //컨트롤러 바 차트의 라인 수
        var controlLineCount  = 10;


        function drawDashboard() {

          var data = new google.visualization.DataTable();
          //그래프에 표시할 컬럼 추가
          data.addColumn('datetime' , '날짜');
          data.addColumn('number'   , '남자');
          data.addColumn('number'   , '여자');
          data.addColumn('number'   , '전체');

          //그래프에 표시할 데이터
          var dataRow = [];

          for(var i = 0; i <= 29; i++){ //랜덤 데이터 생성
            var total   = Math.floor(Math.random() * 300) + 1;
            var man     = Math.floor(Math.random() * total) + 1;
            var woman   = total - man;

            dataRow = [new Date( '2021', '02', i , '28' ), man, woman , total];
            data.addRow(dataRow);
          }


            var chart = new google.visualization.ChartWrapper({
              chartType   : 'LineChart',
              containerId : 'lineChartArea', //라인 차트 생성할 영역
              options     : {
                              isStacked   : 'percent',
                              focusTarget : 'category',
                              height      : 500,
                              width       : '100%',
                              legend      : { position: "top", textStyle: {fontSize: 13}},
                              pointSize   : 5,
                              tooltip     : {textStyle : {fontSize:12}, showColorCode : true,trigger: 'both'},
                              hAxis       : {format: chartDateformat, gridlines:{count:chartLineCount,units: {
                                                                  years : {format: ['yyyy년']},
                                                                  months: {format: ['MM월']},
                                                                  days  : {format: ['dd일']},
                                                                  hours : {format: ['HH시']}}
                                                                },textStyle: {fontSize:12}},
                vAxis       : {minValue: 100,viewWindow:{min:0},gridlines:{count:-1},textStyle:{fontSize:12}},
                animation   : {startup: true,duration: 1000,easing: 'in' },
                annotations : {pattern: chartDateformat,
                                textStyle: {
                                fontSize: 15,
                                bold: true,
                                italic: true,
                                color: '#871b47',
                                auraColor: '#d799ae',
                                opacity: 0.8,
                                pattern: chartDateformat
                              }
                            }
              }
            });

            var control = new google.visualization.ControlWrapper({
              controlType: 'ChartRangeFilter',
              containerId: 'controlsArea',  //control bar를 생성할 영역
              options: {
                  ui:{
                        chartType: 'LineChart',
                        chartOptions: {
                        chartArea: {'width': '60%','height' : 80},
                          hAxis: {'baselineColor': 'none', format: chartDateformat, textStyle: {fontSize:12},
                            gridlines:{count:controlLineCount,units: {
                                  years : {format: ['yyyy년']},
                                  months: {format: ['MM월']},
                                  days  : {format: ['dd일']},
                                  hours : {format: ['HH시']}}
                            }}
                        }
                  },
                    filterColumnIndex: 0
                }
            });

            var date_formatter = new google.visualization.DateFormat({ pattern: chartDateformat});
            date_formatter.format(data, 0);

            var dashboard = new google.visualization.Dashboard(document.getElementById('Line_Controls_Chart'));
            window.addEventListener('resize', function() { dashboard.draw(data); }, false); //화면 크기에 따라 그래프 크기 변경
            dashboard.bind([control], [chart]);
            dashboard.draw(data);

        }
          google.charts.setOnLoadCallback(drawDashboard);

      }
    }

$(document).ready(function(){
  google.charts.load('current', {'packages':['line','controls']});
  chartDrowFun.chartDrow(); //chartDrow() 실행
});
  </script>
</html>