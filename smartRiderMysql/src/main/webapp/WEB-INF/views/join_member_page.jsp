<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/join.css">
</head>

<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<script type="text/javascript">
	$(function() {
		$("#alert-success").hide();
		$("#alert-danger").hide();
		$("input").keyup(function() {
			var inputPassword = $("#inputPassword").val();
			var inputConfirmPassword = $("#inputConfirmPassword").val();
			if (inputPassword != "" || inputConfirmPassword != "") {
				if (inputPassword == inputConfirmPassword) {
					$("#alert-success").show();
					$("#alert-danger").hide();
					$("#submit").removeAttr("disabled");
				} else {
					$("#alert-success").hide();
					$("#alert-danger").show();
					$("#submit").attr("disabled", "disabled");
				}
			}
		});
	});
</script>

<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-10 col-xl-5 mx-auto">
				<div class="card card-signin flex-row my-5">
					<div class="card-body">
						<h5 class="card-title text-center">회원가입</h5>
						<form action="./join_member_process.do" method="post"
							class="form-signin">
							<hr>

							<div class="form-label-group">
								<input type="text" id="input_id" name="member_id"
									class="form-control" placeholder="input_id" required autofocus>
								<label for="input_id">아이디</label>
							</div>
							<div class="form-label-group">
								<input type="password" id="inputPassword" name="member_pw"
									class="form-control" placeholder="Password" required> <label
									for="inputPassword">비밀번호</label>
							</div>
							<div class="form-label-group">
								<input type="password" id="inputConfirmPassword"
									class="form-control" placeholder="Password" required> <label
									for="inputConfirmPassword">비밀번호 확인</label>
							</div>
							<div class="alert alert-success" id="alert-success">비밀번호가
								일치합니다.</div>
							<div class="alert alert-danger" id="alert-danger">비밀번호가
								일치하지 않습니다.</div>
							<div class="form-label-group">
								<input type="text" id="inputUserame" name="member_nick"
									class="form-control" placeholder="Username" required autofocus>
								<label for="inputUserame">닉네임</label>
							</div>
							<div class="form-label-group">
								<input type="email" id="inputEmail" name="member_email"
									class="form-control" placeholder="Email address" required>
								<label for="inputEmail">Email address</label>
							</div>

							<div class="form-label-group">
								<div label for="input_gender">
									성별 : <input type="radio" name="member_genger" value="남자"
										style="text-align: right;" checked> 남자 <input
										type="radio" name="member_genger" value="여자"
										style="text-align: right;"> 여자
								</div>
							</div>

							<div class="form-label-group">
								사는 지역 : <select name="member_area">
									<option value="s" selected>지역 선택</option>
									<option value="서울특별시">서울특별시</option>
									<option value="경기도">경기도</option>
									<option value="인천광역시">인천광역시</option>
									<option value="부산광역시">부산광역시</option>
									<option value="대구광역시">대구광역시</option>
									<option value="광주광역시">광주광역시</option>
									<option value="대전광역시">대전광역시</option>
									<option value="울산광역시">울산광역시</option>
									<option value="세종특별자치시">세종특별자치시</option>
									<option value="강원도">강원도</option>
									<option value="충청북도">충청북도</option>
									<option value="충청남도">충청남도</option>
									<option value="전라남도">전라남도</option>
									<option value="경상북도">경상북도</option>
									<option value="경상남도">경상남도</option>
									<option value="제주특별자치도">제주특별자치도</option>
								</select>
							</div>

							<hr class="my-4">
							<button class="btn btn-lg btn-primary btn-block text-uppercase"
								type="submit" id="signUpBtn">Register</button>
							<a class="d-block text-center mt-2 small" href="./login_page.do">Sign
								In</a> <a class="d-block text-center mt-5 small"
								href="./main_page.do">뒤로 가기</a>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
</body>
</html>