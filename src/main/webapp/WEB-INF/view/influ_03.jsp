<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>

<div class="influ_wrap">

	<div class="gray_box">
		<div class="creator">크리에이터를 위한 No.1 광고 매칭 솔루션</div>

		<div class="tab_a">
			<ul>
				<li><a href="/recommendInfluencer">
						<div class="img">
							<img src="static/images/ico_01_off.png" alt="">
						</div> 인플루언서 추천
				</a></li>
				<li><a href="/searchInfluencer">
						<div class="img">
							<img src="static/images/ico_02_off.png" alt="">
						</div> 인플루언서 검색
				</a></li>
				<li><a class="active" href="/employInfluencer">
						<div class="img">
							<img src="static/images/ico_03_off.png" alt="">
						</div> 인플루언서 구인
				</a></li>
			</ul>
		</div>
	</div>



	<div class="influ_list">
		<div class="ititle">
			해당 광고에 관심이 있다면? <strong>사진을 클릭해 주세요!</strong>
		</div>

		<dl>
			<c:forEach var="noticeBoard" items="${noticeBoards }">
				<dd>
					<div class="info">
						<div class="thumb">
							<a href="/shop?shopId=${noticeBoard.shopId}">
							<img width="300" height="220" src="${noticeBoard.shop.profileImage }" alt="">
							</a>
						</div>
						<div class="desc">
							<ul>
								${noticeBoard.description }
							</ul>
						</div>
					</div>
				</dd>
				</c:forEach>
		</dl>

		<div class="pagination">
			<a href="#none" class="prev"><i class="xi xi-angle-left"></i>이전</a> <a
				href="#none" class="next">다음<i class="xi xi-angle-right"></i></a>
		</div>
	</div>
	<!-- .influ_list-->


</div>
<!-- .influ_wrap -->



</div>
<!-- .site_wrap -->

</body>
</html>