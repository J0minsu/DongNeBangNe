<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>



<div class="biz_wrap">
	<div class="gray_box">
		<div class="creator">크리에이터를 위한 No.1 광고 매칭 솔루션</div>
		<div class="box">소상공인 검색</div>
	</div>


	<div class="biz_info">
		<div class="btitle">소상공인 기본 정보</div>


		<div class="biz_form">
			<span>지역</span> <select name="" id="">
				<option value="">도시무관</option>
				<option value="">서울</option>
			</select>
		</div>



		<div class="category">
			<div class="st">상품카테고리</div>
			<a href="#none" class="cate"><img
				src="static/images/icoc_01_off.png" alt="">육아</a> <a href="#none"
				class="cate"><img src="static/images/icoc_02_off.png" alt="">뷰티</a>
			<a href="#none" class="cate"><img
				src="static/images/icoc_03_off.png" alt="">일상</a> <a href="#none"
				class="cate"><img src="static/images/icoc_04_off.png" alt="">패션</a>
			<a href="#none" class="cate"><img
				src="static/images/icoc_05_off.png" alt="">음식</a> <a href="#none"
				class="cate"><img src="static/images/icoc_06_off.png" alt="">펫</a>
			<a href="#none" class="cate"><img
				src="static/images/icoc_07_off.png" alt="">셀카</a> <a href="#none"
				class="cate"><img src="static/images/icoc_08_off.png" alt="">여행</a>
		</div>

		<div class="biz_submit">
			<a href="#none">검색</a>
		</div>

	</div>
	<!-- .biz_info -->




	<div class="biz_list">
		<dl>
			<c:forEach var="shop" items="${shops }">
				<dd>
					<div class="info">
						<div class="thumb">
							<a href="/shop?shopId=${shop.id}"><img
								src="${shop.profileImage}" alt="" width="300" height="220"></a>
						</div>
						<div class="desc">
							<ul>
								<li>상호명 : ${shop.name}</li>
								<li>위치 : ${shop.city } ${shop.gu } ${shop.dong } ${shop.detail }</li>
								<li>팔로우수: ${shop.followerNumber}</li>
								<li>${shop.description }</li>
							</ul>
						</div>
					</div>
				</dd>
			</c:forEach>
		</dl>
	</div>

</div>
<!-- .biz_wrap -->


</div>
<!-- .site_wrap -->

</body>
</html>