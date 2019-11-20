<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>

	<div class="top_ban"><img src="${pageContext.request.contextPath}/static/images/top_ban_03.jpg" alt=""></div>

<div class="matching_wrap">
	<div class="gray_box">
		<div class="creator">크리에이터를 위한 No.1 광고 매칭 솔루션</div>

		<div class="tab_a">
			<ul>
				<li><a href="/contracting?providerId=3">
						<div class="img">
							<img src="static/images/ico_11_off.png" alt="">
						</div> 계약 체결중
				</a></li>
				<li><a href="/successContract?providerId=3">
						<div class="img">
							<img src="static/images/ico_12_off.png" alt="">
						</div> 계약 완료
				</a></li>
				<li><a class="active" href="/endContract?providerId=3">
						<div class="img">
							<img src="static/images/ico_13_off.png" alt="">
						</div> 계약 종료
				</a></li>
			</ul>
		</div>
	</div>


		<div class="influ_list">
			<div class="ititle">
			계약건에 대해 알려 드립니다.
			</div>
			
			
			<dl>
				<c:forEach var="contract" items="${contracts }">
					<dd>
						<div class="info">
							<div class="thumb">
								<a href="/channel?influencerId=${contract.influencerId}"><img
									src="${contract.channel.userProfileImg}" alt=""></a>
									<a href="/contractDocument/?contractId=${contract.id }&state=end" class="note"><img src="static/images/ico_note.png" alt=""></a>
							</div>
							<div class="desc">
								<div class="iname">${contract.channel.city} ${contract.channel.gu} ${contract.channel.dong}</div>
								<div class="iname2">${contract.channel.name }</div>
								<ul>
									<li><span>팔로워</span>${contract.channel.followerNumber}</li>
									
									<li><span>계약 금액</span>${contract.price}</li>
								
								</ul>
								<div class="conts">
								<span>컨텐츠</span>${contract.channel.broadcastType}
							</div>
						</div>
					</dd>
				</c:forEach>
			</dl>
		</div>
	</div>
</div>
<!-- .matching_wrap -->

</div>
<!-- .site_wrap -->

</body>
</html>