<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="canonical"
	href="https://www.wrappixel.com/templates/ample-admin-lite/" />
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="plugins/images/favicon.png">
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
<script src="/semi/resources/js/event.js"></script>
<style>
	.admBtn { border: 1px solid #e9ecef; color: black; background-color: white; }
</style>
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
	<div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5"
		data-sidebartype="full" data-sidebar-position="absolute"
		data-header-position="absolute" data-boxed-layout="full">
		<!-- ============================================================== -->
		<!-- Topbar header - style you can find in pages.scss -->
		<!-- ============================================================== -->
		<header class="topbar" data-navbarbg="skin5">
			<nav class="navbar top-navbar navbar-expand-md navbar-dark">
				<div class="navbar-header" data-logobg="skin6">
					<!-- ============================================================== -->
					<!-- Logo -->
					<!-- ============================================================== -->
					<a class="navbar-brand" href="dashboard.html"> <span
						class="logo-text"> <img
							src="/semi/resources/admin/plugins/images/logo.png"
							alt="homepage" />
					</span>
					</a>
					<!-- ============================================================== -->
					<!-- End Logo -->
					<!-- ============================================================== -->
					<!-- ============================================================== -->
					<!-- toggle and nav items -->
					<!-- ============================================================== -->
					<a
						class="nav-toggler waves-effect waves-light text-dark d-block d-md-none"
						href="javascript:void(0)"><i class="ti-menu ti-close"></i></a>
				</div>
				<!-- ============================================================== -->
				<!-- End Logo -->
				<!-- ============================================================== -->
				<div class="navbar-collapse collapse" id="navbarSupportedContent"
					data-navbarbg="skin5">
					<ul class="navbar-nav d-none d-md-block d-lg-none">
						<li class="nav-item"><a
							class="nav-toggler nav-link waves-effect waves-light text-white"
							href="javascript:void(0)"><i class="ti-menu ti-close"></i></a></li>
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
								<input type="text" placeholder="Search..."
									class="form-control mt-0"> <a href="" class="active">
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
		<jsp:include page="common/sidebar.jsp" />
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
						<h4 class="page-title text-uppercase font-medium font-14">회원
							정보</h4><br>
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
				<!-- Start Page Content -->
				<!-- ============================================================== -->
				<div class="row">
					<div class="col-sm-12">
						<div class="white-box">
							<form action="" method="get" id="searchForm">
								<div class="search_box">
									<table>
										<tr>
											<td class="box-title">회원명</td>
											<td><input type="text" class="search" name="name" id="name" value="${ requestScope.searchMember.name }">
											</td>
											<!-- <td></td> -->
											<td class="box-title">회원번호</td>
											<td><input type="text" class="search" name="memberNo" id="memberNo" value="${ requestScope.searchMember.no }">
											</td>
											<td class="box-title">전화번호</td>
											<td><input type="tel" class="search" name="phone" id="phone" value="${ requestScope.searchMember.phone }">
											<td>
											<td class="box-title">PT여부</td>
											<td><select class="search selec" name="ptYn" id="ptYn">
													<option value="전체" <c:if test="${ requestScope.ptYn eq '전체'}">selected</c:if>>전체</option>
													<option value="Y" <c:if test="${ requestScope.ptYn eq 'Y'}">selected</c:if>>Y</option>
													<option value="N" <c:if test="${ requestScope.ptYn eq 'N'}">selected</c:if>>N</option>
											</select></td>
											<td>
												<button type="button" id="searchButton" onclick="searchBtn();"
													class="btn btn-danger  d-none d-md-block pull-right m-l-20 hidden-xs hidden-sm waves-effect waves-light">조회</button>
											</td>		
										</tr>
										<!-- <tr><td></td></tr> -->
										<tr>

										</tr>

									</table>
							</form>
							<br>
						</div>
						<script>
							function searchBtn() {
								
								const $searchForm = document.getElementById("searchForm");
								
								const $memberNo = document.getElementById('memberNo');
								const memberNo = document.getElementById('memberNo').value;
								
								if(memberNo === "") {
									$memberNo.disabled = 'disabled';
								}
								
								$searchForm.action = "${ pageContext.servletContext.contextPath }/admin/member/search";
								$searchForm.submit();
							}
						</script>
						<!-- form 태그 끝 -->
						<!-- ============================================================== -->
						<!-- <p class="text-muted">Add class <code>.table</code></p> -->
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th class="border-top-0">회원번호</th>
										<th class="border-top-0">이메일</th>
										<th class="border-top-0">이름</th>
										<th class="border-top-0">전화번호</th>
										<th class="border-top-0">가입일자</th>
										<th class="border-top-0">수정일자</th>
										<th class="border-top-0">블랙여부</th>
										<th class="border-top-0">회원구분</th>
										<th class="border-top-0">회원상태</th>
										<th class="border-top-0">pt남은횟수</th>
										<th class="border-top-0">멤버쉽만료일자</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="member" items="${ requestScope.memberList }">
									<tr class="detail">
										<td><c:out value="${ member.no }"/></td>
										<td><c:out value="${ member.email }"/></td>
										<td><c:out value="${ member.name }"/></td>
										<td><c:out value="${ member.phone }"/></td>
										<td><c:out value="${ member.enrollDate }"/></td>
										<td><c:out value="${ member.modifiedDate }"/></td>
										<td><c:out value="${ member.blackStatus }"/></td>
										<td><c:out value="${ member.role }"/></td>
										<td><c:out value="${ member.status }"/></td>
										<td><c:out value="${ member.amountDTO.amount }"/></td>
										<td><c:out value="${ member.amountDTO.expDate }"/></td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
							
							<div class="pagingArea" align="center">
								<c:choose>
									<c:when test="${ empty requestScope.searchValue }">
										<button class="admBtn" id="startPage"><<</button>
										<c:if test="${ requestScope.pageInfo.pageNo <= 1 }">
											<button class="admBtn" disabled><</button>
										</c:if>
										<c:if test="${ requestScope.pageInfo.pageNo > 1 }">
											<button class="admBtn" id="prevPage"><</button>
										</c:if>
										
										<!-- 중간 번호  -->
										<c:forEach var="p" begin="${ requestScope.pageInfo.startPage }" end="${ requestScope.pageInfo.endPage }" step="1">
											<c:if test="${ requestScope.pageInfo.pageNo eq p }">
												<button class="admBtn" disabled><c:out value="${ p }"/></button>
											</c:if>
											<c:if test="${ requestScope.pageInfo.pageNo ne p }">
												<button class="admBtn" onclick="pageButtonAction(this.innerText);"><c:out value="${ p }"/></button>
											</c:if>
										</c:forEach>
										
										<c:if test="${ requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxPage }">
											<button class="admBtn" disabled>></button>
										</c:if>
										<c:if test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
											<button class="admBtn" id="nextPage">></button>
										</c:if>
										<button class="admBtn" id="maxPage">>></button>
									</c:when>
									
									<%-- 검색(조회)했을 때 --%>
									
									<c:otherwise>
										<button class="admBtn" id="searchStartPage"><<</button>
										
										<c:if test="${ requestScope.pageInfo.pageNo <= 1 }">
											<button class="admBtn" disabled><</button>
										</c:if>
										<c:if test="${ requestScope.pageInfo.pageNo > 1 }">
											<button class="admBtn" id="searchPrevPage"><</button>
										</c:if>
										
										<c:forEach var="p" begin="${ requestScope.pageInfo.startPage }" end="${ requestScope.pageInfo.maxPage }" step="1">
											<c:if test="${ requestScope.pageInfo.pageNo eq p }">
												<button class="admBtn" disabled><c:out value="${ p }"/></button>
											</c:if>
											<c:if test="${ requestScope.pageInfo.pageNo ne p}">
												<button class="admBtn" onclick="searchPageButtonAction(this.innerText);"><c:out value="${ p }"/></button>
											</c:if>
										</c:forEach>
										
										<c:if test="${ requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxPage }">
											<button class="admBtn" disabled>></button>
										</c:if>
										<c:if test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
											<button class="admBtn" id="searchNextPage">></button>
										</c:if> 
										<button class="admBtn" id="searchMaxPage">>></button>
									</c:otherwise>
									
								</c:choose>
								<script>
									const link = "${ pageContext.servletContext.contextPath }/admin/member";
									const searchLink = "${ pageContext.servletContext.contextPath }/admin/member/search";
								
									if(document.getElementById("startPage")) {
										const $startPage = document.getElementById("startPage");
										$startPage.onclick = function() {
											location.href = link + "?currentPage=1";
										}
									}
									
									if(document.getElementById("prevPage")) {
									    const $prevPage = document.getElementById("prevPage");
									    $prevPage.onclick = function() {
									        location.href = link + "?currentPage=${ requestScope.pageInfo.pageNo - 1}";
									    }
								    }
									    
								    if(document.getElementById("nextPage")) {
									    const $nextPage = document.getElementById("nextPage");
								        $nextPage.onclick = function() {
								            location.href = link + "?currentPage=${ requestScope.pageInfo.pageNo + 1}";
								        }
								    }
									    
								    if(document.getElementById("maxPage")) {
									      const $maxPage = document.getElementById("maxPage");
									      $maxPage.onclick = function() {
									          location.href = link + "?currentPage=${ requestScope.pageInfo.maxPage }";
									      }
								    }
									    
									function pageButtonAction(text) {
										  location.href = link + "?currentPage=" + text;
							        }
									
									/* 검색 */
									if(document.getElementById("searchStartPage")){
								        const $searchStartPage = document.getElementById("searchStartPage");
								        $searchStartPage.onclick = function() {
								           location.href = searchLink + "?currentPage=1&name=${ request.searchMember.name }&memberNo=${ request.searchMember.no }&phone=${ request.searchMember.phone }&ptYn=${ request.ptYn }";
								        }
								     }
								     
								    if(document.getElementById("searchPrevPage")){
								        const $searchPrevPage = document.getElementById("searchPrevPage");
								        $searchPrevPage.onclick = function() {
								           location.href = searchLink + "?currentPage=${ requestScope.pageInfo.pageNo - 1}&name=${ request.searchMember.name }&memberNo=${ request.searchMember.no }&phone=${ request.searchMember.phone }&ptYn=${ request.ptYn }";
								           
								        }
								        
								    }
								     
								    if(document.getElementById("searchNextPage")){
								        const $searchNextPage = document.getElementById("searchNextPage");
								        $searchNextPage.onclick = function() {
								           location.href = searchLink + "?currentPage=${ requestScope.pageInfo.pageNo + 1}&name=${ request.searchMember.name }&memberNo=${ request.searchMember.no }&phone=${ request.searchMember.phone }&ptYn=${ request.ptYn }";
								        }
								        
								    }
								     
								    if(document.getElementById("searchMaxPage")){
								        const $searchMaxPage = document.getElementById("searchMaxPage");
								        $searchMaxPage.onclick = function() {
								           location.href = searchLink + "?currentPage=${ requestScope.pageInfo.maxPage }&name=${ request.searchMember.name }&memberNo=${ request.searchMember.no }&phone=${ request.searchMember.phone }&ptYn=${ request.ptYn }";
								        }
								        
								    }
								     
								    function searchPageButtonAction(text) {
								        location.href = searchLink + "?currentPage=" + text + "&name=${ request.searchMember.name }&memberNo=${ request.searchMember.no }&phone=${ request.searchMember.phone }&ptYn=${ request.ptYn }";
								    }
								    
								    /*효과*/
								    
								    if(document.getElementsByTagName("td")) {
								 		const $tds = document.getElementsByTagName("td");
								 		
								 		for(let i = 0; i < $tds.length; i++ ) {
								 			
								 			$tds[i].onmouseenter = function() {
								 				this.parentNode.style.background = "#e9ecef";
								 				this.parentNode.style.cursor = "pointer";
								 			}
								 			
								 			$tds[i].onmouseout = function() {
								 				this.parentNode.style.background = "white";
								 			}
								 			
								 			
								 		}
								 	}
								    
								    if(document.getElementBy)
								    
								 		    $tds[i].onclick = function() {
								 				const no = this.parentNode.children[0].innerText;
								 				
								 				location.href = "${ pageContext.servletContext.contextPath }/admin/member/detail?no=" + no;
								 			} 
								    
								</script>
							</div>
							
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
		<footer class="footer text-center">
			2020 © HelloPT Admin brought to you by <a href="#">www.HelloPT.com</a>
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
	<script
		src="/semi/resources/admin/plugins/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap tether Core JavaScript -->
	<script
		src="/semi/resources/admin/plugins/bower_components/popper.js/dist/umd/popper.min.js"></script>
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