<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>

<div class="matching_wrap">
	<div class="gray_box">
		<div class="creator">소상공인을 위한 No.1 광고 매칭 솔루션</div>

		<div class="tab_a">
			<ul>
				<li><a class="active" href="/contracting?providerId=3">
						<div class="img">
							<img src="static/images/ico_11_off.png" alt="">
						</div> 계약 체결중
				</a></li>
				<li><a href="/successContract?providerId=3">
						<div class="img">
							<img src="static/images/ico_12_off.png" alt="">
						</div> 계약 완료
				</a></li>
				<li><a href="endContract?providerId=3">
						<div class="img">
							<img src="static/images/ico_13_off.png" alt="">
						</div> 계약 종료
				</a></li>
			</ul>
		</div>
	</div>


	<!-- <div class="matching_list">
			<div class="mtitle">계약 완료된 건에 대해 알려드립니다.</div>

			<div class="desc">
				<ul>
					<li>계약 완료된 건에 대해 알려드립니다.</li>
					<li>계약 완료된 건에 대해 알려드립니다.</li>
					<li>계약 완료된 건에 대해 알려드립니다.</li>
					<li>계약 완료된 건에 대해 알려드립니다.</li>
				</ul>						
			</div>
			<div class="desc">
				<ul>
					<li>계약 완료된 건에 대해 알려드립니다.</li>
					<li>계약 완료된 건에 대해 알려드립니다.</li>
					<li>계약 완료된 건에 대해 알려드립니다.</li>
					<li>계약 완료된 건에 대해 알려드립니다.</li>
				</ul>						
			</div>
		</div>.matching_list -->
	<div class="biz_wrap">
		<div class="biz_list">
			<dl>
				<c:forEach var="contract" items="${contracts }">
					<dd>
						<div class="info">
							<div class="thumb">
								<a href="/channel?influencerId=${contract.influencerId}"><img
									src="${contract.channel.userProfileImg}" alt="" width="300"
									height="220"></a>
							</div>
							<div class="desc">
								<ul>

									<p align="center" style="color:#7f75c2">
										<a href="/contractDocument/?contractId=${contract.id }&state=contracting">계약서 바로가기</a>
									</p>
									<li>인플루언서 : ${contract.channel.name}</li>
									<li>팔로우 수 : ${contract.channel.followerNumber }</li>
									<li>계약 금액 : ${contract.price }</li>

								</ul>
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