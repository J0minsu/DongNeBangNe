<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/reportForm.js"></script>
<div class="mypage_wrap">

	<div class="myinfo">
		<div class="conts">
			<div class="photo">
				<img src="${channel.userProfileImg }" alt="">
			</div>
			<div class="info_name">${channel.name}</div>
			<div class="info_id">${influencer.email}
				<img src="static/images/ico_memo.png" alt="">
			</div>

			<div class="desc">${channel.description}</div>

		</div>
		<div class="influ_wrap">
			<div class="search_submit">
				<a
					href="/createDocument?influencerId=${influencer.id }&providerId=3"
					class="gtm"
					onclick="dataLayer.push({'category': 'Channel Detail', 'action': 'Contract icon Click', 'label' :'${channel.id}'});">매칭
					신청</a>
			</div>
			<div class="search_submit">
				<a href="#none" class="gtm"
					onclick="dataLayer.push({'category': 'Channel Detail', 'action': 'Contact icon Click', 'label' :'${channel.id}'})">문의하기</a>
			</div>
		</div>
	</div>

	<div class="my_desc">
		<div class="banner">
			<img src="${channel.bannerImage }" alt="">
		</div>
		<div class="txt1">대표 영상</div>

		<div class="txt2">${video.name}</div>

		<div class="video_wrap">
			<script src="https://cdn.jsdelivr.net/npm/hls.js@latest"></script>
			<video id="video"></video>
			<script>
				if (Hls.isSupported()) {
					var video = document.getElementById('video');
					var hls = new Hls();
					hls.loadSource('${video.url}');
					hls.attachMedia(video);
					hls.on(Hls.Events.MANIFEST_PARSED, function() {
						video.play();
					});
				}
			</script>
			<!--<iframe width="" height="" src="${video.url}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>-->
		</div>
		<br> <br> <br> <br>


		<div style='float:left;width:150px; height:150px'>
		<canvas id="myChart" ></canvas>
	</div>
	<div style='float:left;width:150px; height:150px'>
		<canvas id="myChart1" ></canvas>
	</div>
	<div style="clear: both"></div>
		<script>
			var ctx = document.getElementById("myChart").getContext('2d');
			var myChart = new Chart(ctx, {
				type : 'bar',
				data : data,
				options : options
			})
			myChart.data.datasets[0].data = [ 400, 500, 100 ];
			myChart.update();
			var ctx1 = document.getElementById("myChart1").getContext('2d');
			var myChart1 = new Chart(ctx1, {
				type : 'bar',
				data : data2,
				options : options
			})
		</script>


		<div class="txt1">이 인플루언서와 비슷한 인플루언서가 궁금하시다면?!</div>

		<div class="txt2">사진을 클릭하시면 해당 인플루언서의 채널로 이동할 수 있습니다!</div>

		<div class="my_prd_list">
			<ul>

				<c:forEach var="reco" items="${recos }">
					<li><a href="/channel?influencerId=${reco.id }"><img
							src="${reco.imgUrl }" width="180" height="300" alt=""></a></li>

				</c:forEach>
			</ul>
		</div>
	</div>


</div>
<!-- .mypage_wrap -->



</div>
<!-- .site_wrap -->

</body>
</html>
