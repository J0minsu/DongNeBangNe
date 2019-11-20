<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>

<div class="top_ban"><img src="static/images/top_ban_01.jpg" alt=""></div>

<div class="influ_wrap">

	<div class="gray_box">
		<div class="creator">크리에이터를 위한 No.1 광고 매칭 솔루션</div>

		<div class="tab_a">
			<ul>
				<li><a class="active" href="/recommendInfluencer">
						<div class="img">
							<img src="static/images/ico_01_off.png" alt="">
						</div> 인플루언서 추천
				</a></li>
				<li><a href="/searchInfluencer">
						<div class="img">
							<img src="static/images/ico_02_off.png" alt="">
						</div> 인플루언서 검색
				</a></li>
				<li><a href="/employInfluencer">
						<div class="img">
							<img src="static/images/ico_03_off.png" alt="">
						</div> 인플루언서 구인
				</a></li>
			</ul>
		</div>
	</div>

	<div class="influ_list">
		<div class="ititle">
			인플루언서를 자세히 알고 싶다면? <strong>사진을 클릭해 주세요!</strong>
		</div>

		<dl>
			<c:forEach var="channel" items="${channels }">
				<dd>
					<div class="info">
						<div class="thumb">
							<a href="/channel?influencerId=${channel.id}" class ="gtm" onclick="dataLayer.push({'category': 'Search List', 'action': 'DetailView Click', 'label' :'${channel.id}'});"><img
								src="${channel.userProfileImg}" alt=""></a>
								<!-- src 에 크기 조절 width="300" height="220" -->
						</div>
						<div class="desc">
								<div class="iname">${channel.city} ${channel.gu} ${channel.dong}</div>
								<div class="iname2">${channel.name }</div>
								<ul>
									<li><span>팔로워</span>${channel.followerNumber}</li>
									<c:if test="${channel.totalContractNumber ne 0}">
									<li><span>평균계약금</span>${channel.averageContractFee}</li>
								</c:if>
								<c:if test="${channel.totalContractNumber eq 0}">
								<li><span>추천계약금</span>${channel.cost}</li>
								</c:if>	
								</ul>
								<div class="conts">
								<span>컨텐츠</span>${channel.broadcastType}						
								</div>
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