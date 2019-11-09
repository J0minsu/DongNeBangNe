<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!doctype html>

<div class="matching_wrap">
	<div class="gray_box">
		<div class="creator">크리에이터를 위한 No.1 광고 매칭 솔루션</div>
	</div>

	<div class="matching_form">
		<div class="mtitle">계약서</div>

		<div class="match">
			<div class="influ_info">
				<div class="img">
					<a href="/channel?influencerId=${contract.channel.userId }"><img
						src="${contract.influencer.profileImage }" alt="" width="300"
						height="250"><span class="heart"><i class="xi-heart"></i></span></a>
				</div>

				<ul>
					<li>지역: ${contract.channel.city } ${contract.channel.city }
						${contract.channel.dong }</li>
					<c:if test="${contract.influencer.gender eq 1}">
						<li>성별 : 남자</li>
					</c:if>
					<c:if test="${contract.influencer.gender eq 2}">
						<li>성별 : 여자</li>
					</c:if>
					<li>나이: ${contract.influencer.age }</li>
				</ul>

				<div class="desc">
					<div>${contract.channel.broadcastType }</div>
					<div>팔로워 수 : ${contract.channel.followerNumber }</div>
				</div>
			</div>

			<div class="input_wrap">
				<sf:form action="/api/contracts" method="post" modelAttribute="contract">
					<ul>
						<sf:hidden path="influencerId" id="influencerId" value="${contract.influencerId }"/>
						<sf:hidden path="providerId" id="providerId" value="${contract.providerId }"/>
						<sf:hidden path="state" id="state" value="${contract.state + 1 }"/> 
						<li><span class="subj">계약자(소상공인)</span>${contract.provider.name }</li>
						<li><span class="subj">피계약자(인플루언서)</span>${contract.influencer.name }</li>
						<li><span class="subj">방송횟수(회)</span>
							<sf:input path="times" id="times" value="${contract.times }" style="width:380px; height:30px;"/></li>
						<li><span class="subj">방송시간(분)</span>
							<sf:input path="onePerTime" id="onePerTime" value="${contract.onePerTime }" style="width:380px; height:30px;"/></li>
						<li><span class="subj">금액(원)</span>
							<sf:input path="price" id="price" value="${contract.price }" style="width:380px; height:30px;"/></li>
						<li><span class="subj">상세 계약조건</span> 
							<sf:textarea path="requirement" id="requirement" value="${contract.requirement }" style="width:380px; height:200px;"/></li>
					</ul>

				<div class="submit_wrap" style="width:730px; height:30px;">
					<c:choose>
						<c:when test="${what eq 'create'}">
							<a href="/api/contracts" class="btn_normal">신청</a>
							<a href="#none" class="btn_submit">취소</a>
						</c:when>
						<c:when test="${what eq 'document'}">
							<a href="#none" class="btn_normal">수락</a>
							<a href="#none" class="btn_submit">거절</a>
						</c:when>
						<c:when test="${what eq 'contracting'}">
							<a href="#none" class="btn_normal">확인</a>
						</c:when>
						<c:when test="${what eq 'success'}">
							<a href="#none" class="btn_normal">신청</a>
							<a href="#none" class="btn_submit">취소</a>
						</c:when>
						<c:when test="${what eq 'end'}">
							<a href="#none" class="btn_normal">확인</a>
						</c:when>
					</c:choose>
					</sf:form>
				</div>
			</div>
		</div>
		<!-- .match -->

	</div>
	<!-- .matching_form -->

</div>
<!-- .matching_wrap -->

</div>
<!-- .site_wrap -->

</body>
</html>