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


	<div class="biz_wrap">
		<div class="gray_box">
			<div class="creator">
			크리에이터를 위한 No.1 광고 매칭 솔루션
			</div>
			<div class="box">
			소상공인 검색
			</div>
		</div>


		<div class="biz_info">
			<div class="btitle">소상공인 기본 정보</div>


			<div class="biz_form">
				<span>지역</span>
				<select name="" id="">
					<option value="">도시무관</option>
					<option value="">서울</option>
				</select>
			</div>

					
					
			<div class="category">
				<div class="st">상품카테고리</div>
				<a href="#none" class="cate"><img src="static/images/icoc_01_off.png"  alt="">육아</a>
				<a href="#none" class="cate"><img src="static/images/icoc_02_off.png"  alt="">뷰티</a>
				<a href="#none" class="cate"><img src="static/images/icoc_03_off.png"  alt="">일상</a>
				<a href="#none" class="cate"><img src="static/images/icoc_04_off.png"  alt="">패션</a>
				<a href="#none" class="cate"><img src="static/images/icoc_05_off.png"  alt="">음식</a>
				<a href="#none" class="cate"><img src="static/images/icoc_06_off.png"  alt="">펫</a>
				<a href="#none" class="cate"><img src="static/images/icoc_07_off.png"  alt="">셀카</a>
				<a href="#none" class="cate"><img src="static/images/icoc_08_off.png"  alt="">여행</a>
			</div>

			<div class="biz_submit">
				<a href="#none">검색</a>
			</div>
		
		</div><!-- .biz_info -->




		<div class="biz_list">
			<dl>
				<dd>
					<div class="info">
						<div class="thumb"><img src="static/images/img_03.jpg" alt=""></div>
						<div class="desc">
							<ul>
								<li>안녕하세요.</li>
								<li>안녕하세요.</li>
								<li>안녕하세요.</li>
								<li>안녕하세요.</li>
							</ul>						
						</div>
					</div>
				</dd>
				<dd>
					<div class="info">
						<div class="thumb"><img src="static/images/img_03.jpg" alt=""></div>
						<div class="desc">
							<ul>
								<li>안녕하세요.</li>
								<li>안녕하세요.</li>
								<li>안녕하세요.</li>
								<li>안녕하세요.</li>
							</ul>						
						</div>
					</div>
				</dd>
			</dl>
		</div>

	</div><!-- .biz_wrap -->


</div><!-- .site_wrap -->

</body>
</html>