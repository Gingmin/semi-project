<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<link rel="stylesheet" href="/semi/resources/admin/css/style.min.css">
<link rel="stylesheet" href="/semi/resources/admin/css/style.css">
<link rel="stylesheet" href="/semi/resources/admin/css/admin.css">
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
                    <a class="navbar-brand" href="dashboard.html">
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
                        <li class="temp">
                           <a class="profile-pic" href="">
                                <img src="/semi/resources/admin/plugins/images/close.png" alt="close-img" width="36"
                                    class="close"></a>
                          </li>
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
                        <h4 class="page-title text-uppercase font-medium font-14">회원 정보</h4>
                    </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                        <div class="d-md-flex">
                            <ol class="breadcrumb ml-auto">
                                <!-- <li><a href="#">Dashboard</a></li> -->
                            </ol>
                            <!-- ============================================================== -->
                            <!-- 검색 폼 시작 -->
                            <form action="" method="post">
                            <button type="submit"
                                class="btn btn-danger  d-none d-md-block pull-right m-l-20 hidden-xs hidden-sm waves-effect waves-light">
                            	조회</button>
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
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                        	<div class="search_box">
                        		<table>
	                            	<tr>
	                            		<td class="box-title">회원명</td>
	                            		<td>
			    							<input type="text" class="search" name="name">
		    							</td>
		    							<td></td>
		    							<td class="box-title">회원번호</td>
		    							<td>                     	
			    							<input type="text" class="search" name="member_no">
		    							</td>
	    							</tr>
	    							<tr><td></td></tr>
	    							<tr>
		    							<td></td>
		    							<td class="box-title">PT여부</td>
		    							<td>
			    							<select class="search selec" name="pt_yn">
			    								<option>전체</option>
			    								<option>Y</option>
			    								<option>N</option>
			    							</select>
		    							</td>
	    							</tr>
	    							<tr><td></td></tr>
	    							<tr>   	
		    							<td class="box-title">전화번호</td>                     	
		    							<td><input type="tel" class="search" name="phone"><td>
	    							</tr>
    							</table>
    						</div>
                         	</form><br>
                            <!-- form 태그 끝 -->
                            <!-- ============================================================== -->
                            <!-- <p class="text-muted">Add class <code>.table</code></p> -->
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th class="border-top-0">#</th>
                                            <th class="border-top-0">이름</th>
                                            <th class="border-top-0">전화번호</th>
                                            <th class="border-top-0">성별</th>
                                            <th class="border-top-0">이메일</th>
                                            <th class="border-top-0">멤버쉽</th>
                                            <th class="border-top-0">PT</th>
                                            <th class="border-top-0">회원번호</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>
                                            	<!-- <div class="popup" onclick="myFunction()">
		                                            <input type="button" class="memberPopup" value="김민기">
		                                            <span class="popup_info" id="myPopup">팝업</span>
                                          		</div> -->
                                          		<a class="nameDetails" target="_blank" href="memberDetails.html">김민기</a>
                                          	</td>
                                            <td>01071832721</td>
                                            <td>남</td>
                                            <td>mk@greedy.com</td>
                                            <td>28</td>
                                            <td>Y</td>
                                            <td>H1234</td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td><a class="nameDetails" target="_blank" href="memberDetails.html">임완규</a></td>
                                            <td>01012345678</td>
                                            <td>남</td>
                                            <td>kku@greedy.com</td>
                                            <td>15</td>
                                            <td>Y</td>
                                            <td>H1235</td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td><a class="nameDetails" target="_blank" href="memberDetails.html">정민서</a></td>
                                            <td>01012345678</td>
                                            <td>남</td>
                                            <td>ms@greedy.com</td>
                                            <td>5</td>
                                            <td>Y</td>
                                            <td>H1236</td>
                                        </tr>
                                        <tr>
                                            <td>4</td>
                                            <td><a class="nameDetails" target="_blank" href="memberDetails.html">최희상</a></td>
                                            <td>01012345678</td>
                                            <td>남</td>
                                            <td>hee@greedy.com</td>
                                            <td>20</td>
                                            <td>Y</td>
                                            <td>H1237</td>
                                        </tr>
                                        <tr>
                                            <td>5</td>
                                            <td><a class="nameDetails" target="_blank" href="memberDetails.html">Nigam</a></td>
                                            <td>01012344321</td>
                                            <td>여</td>
                                            <td>ng@greedy.com</td>
                                            <td>32</td>
                                            <td>Y</td>
                                            <td>H1238</td>
                                        </tr>
                                        
                                    </tbody>
                                </table>
                                <!-- 팝업만들기  -->
                                <!-- <script>
                                    function myFunction() {
                                        var popup = document.getElementById('myPopup');
                                        popup.classList.toggle('show');
                                    }
                                </script> -->
                            </div>
                        </div>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- End PAge Content -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Right sidebar -->
                <!-- ============================================================== -->
                <!-- .right-sidebar -->
                <!-- ============================================================== -->
                <!-- End Right sidebar -->
                <!-- ============================================================== -->
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
    <!--Wave Effects -->
    <script src="/semi/resources/admin/js/waves.js"></script>
    <!--Menu sidebar -->
    <script src="/semi/resources/admin/js/sidebarmenu.js"></script>
    <!--Custom JavaScript -->
    <script src="/semi/resources/admin/js/custom.js"></script>
</body>
</html>