<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>동호회 목록</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/a.css">
<!-- Bootstrap core CSS -->
<link href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<link href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/text-overflow.css" rel="stylesheet">

<link rel="stylesheet" href="resources/css/a.css">

<!-- Custom fonts for this template -->
<link href="<%=request.getContextPath()%>/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/resources/css/clean-blog.min.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/test.css">
</head>

<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="./main_page.do">Smart Rider</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="./main_page.do">Home</a>
					</li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" data-toggle="dropdown"
						href="./main_page_about.do" role="button" aria-haspopup="true"
						aria-expanded="false">커뮤니티</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="./main_page_about.do">자유 게시판</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" data-toggle="dropdown"
						href="./main_page_about.do" role="button" aria-haspopup="true"
						aria-expanded="false">동호회소개</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="./club_list.do">동호회 목록</a> <a
								class="dropdown-item" href="./club_create.do">동호회 등록</a>
						</div></li>
					<li class="nav-item"><a class="nav-link" href="#">라이딩 추천
							경로</a></li>
					<li class="nav-item"><c:choose>
							<c:when test="${!empty sessionUserData }">
								<a class="nav-link" href="./logout_process.do">로그아웃</a>
							</c:when>
							<c:otherwise>
								<a class="nav-link" href="./login_page.do">로그인</a>
							</c:otherwise>
						</c:choose></li>
					<li class="nav-item"><c:choose>
							<c:when test="${!empty sessionUserData }">
								<a class="nav-link" href="./track_page.do">주행 기록</a>
							</c:when>
							<c:otherwise>
								<a class="nav-link" href="./join_member_page.do">회원가입</a>
							</c:otherwise>
						</c:choose></li>
				</ul>
			</div>
		</div>
	</nav>

	<header>
		<div class="overlay"></div>
		<video playsinline="playsinline" autoplay="autoplay" muted="muted" loop="loop">
			<source src="<%=request.getContextPath()%>/resources/videos/aaa.mp4" type="video/mp4">
		</video>
		<div class="container h-100">
			<div class="d-flex h-100 text-center align-items-center">
				<div class="w-100 text-white">
					<h1 class="display-4">동호회 목록</h1>
					<span class="subheading">자신의 원하는 동호회를 찾아보세요</span>
				</div>
			</div>
		</div>
	</header>

	<!-- Main Content -->
	<div class="container mt-5">
		<div class="col" align="right">
			<form action="./club_list.do" method="post"
				class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="text" placeholder="지역 검색"
					aria-label="Search" name="search_word" id="search_word"
					value="${search_word }">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
			</form>
		</div>
		<div class="row mt-3">
			<div class="col">
				<div class="table-responsive" >
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">지역</th>
							<th scope="col">동호회명</th>
							<th scope="col">소개</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${xxx }" var="aaa">
							<tr>
								<th scope="row">${aaa.clubVo.club_no }</th>
								<td>${aaa.clubVo.club_area }</td>
								<td>
									<a href="./club_list_detail.do?club_no=${aaa.clubVo.club_no }">${aaa.clubVo.club_name }</a>
									
								</td>
								<td>
									<div class="text-over-cut">
										${aaa.clubVo.club_introduce }
									</div>
								</td>

							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
			</div>
		</div>
	</div>










	<hr>

	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<ul class="list-inline text-center">
						<li class="list-inline-item"><a href="#"> <span
								class="fa-stack fa-lg"> <i
									class="fas fa-circle fa-stack-2x"></i> <i
									class="fab fa-twitter fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
						<li class="list-inline-item"><a href="#"> <span
								class="fa-stack fa-lg"> <i
									class="fas fa-circle fa-stack-2x"></i> <i
									class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
						<li class="list-inline-item"><a href="#"> <span
								class="fa-stack fa-lg"> <i
									class="fas fa-circle fa-stack-2x"></i> <i
									class="fab fa-github fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
					</ul>
					<p class="copyright text-muted">Copyright &copy; 안양대학교 김도윤
						2020</p>
				</div>
			</div>
		</div>
	</footer>
	
	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Custom scripts for this template -->
	<script src="js/clean-blog.min.js"></script>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

</body>
</html>