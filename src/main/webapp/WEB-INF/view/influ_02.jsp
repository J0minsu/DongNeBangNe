<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>


	<div class="influ_wrap">

		<div class="gray_box">
			<div class="creator">
			크리에이터를 위한 No.1 광고 매칭 솔루션
			</div>

			<div class="tab_a">
				<ul>
					<li>
						<a href="/recommendInfluencer">
							<div class="img"><img src="static/images/ico_01_off.png" alt=""></div>
							인플루언서 추천
						</a>
					</li>
					<li>
						<a class="active" href="/searchInfluencer">
							<div class="img"><img src="static/images/ico_02_off.png" alt=""></div>
							인플루언서 검색
						</a>
					</li>
					<li>
						<a href="/employInfluencer">
							<div class="img"><img src="static/images/ico_03_off.png" alt=""></div>
							인플루언서 구인
						</a>
					</li>
				</ul>		
			</div>
		</div>


		<div class="influ_search">
			<div class="item">
				<div class="is_title">인플루언서 기본정보</div>

				<div class="search_form">
					<span>거주지역</span>
					<select name="" id="">
						<option value="">무관</option>
						<option value="">서울</option>
						<option value="">경기</option>
						<option value="">부산</option>
					</select>
				</div>

				<div class="search_form">
					<span>성별</span>
					<select name="" id="">
						<option value="">무관</option>
						<option value="">남자</option>
						<option value="">여자</option>
					</select>
				</div>


				<div class="search_age">
					<div>연령대</div>
				</div>

				<div id="age_bar"></div>

				<!-- http://ionden.com/a/plugins/ion.rangeSlider/index.jsp -->
				<link rel="stylesheet" href="static/css/ion.rangeSlider.css">
				<script type="text/javascript" src="static/js/ion.rangeSlider.min.js"></script>

				<script type="text/javascript">
				   $("#age_bar").ionRangeSlider({
						type: "double",
						grid: true,
						min: 0,
						max: 100,
						from: 0,
						to: 60
					});
				</script>
			</div>

			<div class="item">
				<div class="is_title">인플루언서 기본정보</div>

				<div class="category">
					<div class="st">주 포스팅 카테고리</div>

					<a href="#none" class="cate"><img src="static/images/icoc_01_off.png"  alt="">육아</a>
					<a href="#none" class="cate"><img src="static/images/icoc_02_off.png"  alt="">뷰티</a>
					<a href="#none" class="cate"><img src="static/images/icoc_03_off.png"  alt="">일상</a>
					<a href="#none" class="cate"><img src="static/images/icoc_04_off.png"  alt="">패션</a>
					<a href="#none" class="cate"><img src="static/images/icoc_05_off.png"  alt="">음식</a>
					<a href="#none" class="cate"><img src="static/images/icoc_06_off.png"  alt="">펫</a>
					<a href="#none" class="cate"><img src="static/images/icoc_07_off.png"  alt="">셀카</a>
					<a href="#none" class="cate"><img src="static/images/icoc_08_off.png"  alt="">여행</a>
				</div>

			</div>

			<div class="item">
				<div class="is_title">광고비 범위 설정</div>

				<div class="range">
					<input type="text" placeholder="만원"> ~ <input type="text" placeholder="만원"> <a href="#none" class="btn">적용</a>
				</div> 

			</div>


		</div><!-- .influ_search -->

		<div class="search_submit">
			<a href="#none">검색</a>
		</div>




	</div><!-- .influ_wrap -->



</div><!-- .site_wrap -->

</body>
</html>
