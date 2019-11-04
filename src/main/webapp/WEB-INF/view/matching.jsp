<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="imagetoolbar" content="no">
<meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
<meta name="viewport" content="width=1120">

<link rel="stylesheet" href="https://fonts.googleapis.com/earlyaccess/notosanskr.css">
<link rel="stylesheet" href="static/css/xeicon.css">
<link rel="stylesheet" href="static/css/style.css">
<script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="static/js/common.js"></script>
</head>

<body>
<div class="site_wrap">

	<div class="header_wrap">
		<div class="header">
			<ul class="nav">
				<li><a href="influ_01.jsp">인플루언서</a></li>
				<li><a href="biz_01.jsp">소상공인</a></li>
				<li class="logo"><a href="index.jsp"><img src="static/images/logo.png" alt=""></a></li>
				<li><a href="matching.jsp">매칭</a></li>
				<li><a href="mypage.jsp">내정보</a></li>
			</ul>
		</div>
	</div><!-- .header_wrap -->


	<div class="matching_wrap">
		<div class="gray_box">
			<div class="creator">
			크리에이터를 위한 No.1 광고 매칭 솔루션
			</div>
		</div>

		<div class="matching_form">
			<div class="mtitle">계약서</div>

			<div class="match">
				<div class="influ_info">
					<div class="img"><img src="static/images/img_04.jpg" alt=""><span class="heart"><i class="xi-heart"></i></span></div>

					<ul>
						<li>지역: 서울</li>
						<li>성별: 여성</li>
						<li>나이: 29</li>
					</ul>

					<div class="desc">
						<div>컨텐츠 카테고리: 먹방</div>
						<div>팔로워 수 : 7,300</div>
					</div>
				</div>

				<div class="input_wrap">
					<ul>
						<li><span class="subj">계약자(소상공인)</span><input type="text"></li>
						<li><span class="subj">피계약자(인플루언서)</span><input type="text"></li>
						<li><span class="subj">방송횟수</span><input type="text"></li>
						<li><span class="subj">방송시간</span><input type="text"></li>
						<li><span class="subj">금액</span><input type="text"></li>
						<li><span class="subj">상세 계약조건</span><textarea name="" id="" ></textarea></li>
					</ul>

					<div class="submit_wrap">
						<a href="#none" class="btn_submit">체결</a>
						<a href="#none" class="btn_normal">반려</a>
					</div>
				</div>
			</div><!-- .match -->

		</div><!-- .matching_form -->

	</div><!-- .matching_wrap -->

</div><!-- .site_wrap -->

</body>
</html>