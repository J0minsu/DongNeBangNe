<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/reportForm.js"></script>
<script>
	var ch_gender = [${gender1},${gender2}];
	var ch_age = [${age1},${age2},${age3},${age4},${age5},${age6}];
	var ch_grow = [100,120,200,300];
	var shop_category = ${category};
	var category_cnt =[${cnt1}, ${cnt2}];
	var ch_rating = [${rating1}, ${rating1}];
	var ch_view= [${view1},${view2},${view3}];
	var ch_chat= [${chat1},${chat2},${chat3}];
	var ch_buy = [${buy1},${buy2},${buy3}];
	var ch_er = [${er1},${er2},${er3}];
</script>
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
		<div class ='follower_report' style="border:1px solid lightgray; width:800px">
	<h2>&nbsp;&nbsp;&nbsp;팔로워 분석</h2><br>
	<div style='float:left; width:260px; height:200px;'>
		<canvas id="gender" ></canvas>
	</div>
	<div style='float:left; width:260px; height:200px;'>
		<canvas id="age" ></canvas>
	</div>
	<div style='float:left; width:250px; height:200px;'>
		<canvas id="grow" ></canvas>
	</div>
	<div style='clear:both;'><h2>&nbsp;&nbsp;&nbsp;성과분석</h2> </div>
	<div style='float:left; width:200px; height:80px'>
		<canvas id="cate" ></canvas>
	</div>
	<div style='float:left;width:50px; height:80px'></div>
	<div style='float:left;width:200px; height:80px'>
		<canvas id="rating" ></canvas>
	</div>
	<div style="clear: both"></div>
	<div style='float:left;width:150px; height:150px'>
		<canvas id="view" ></canvas>
	</div>
	<div style='float:left;width:30px; height:80px'></div>
	<div style='float:left;width:150px; height:150px'>
		<canvas id="chat" ></canvas>
	</div>
	<div style='float:left;width:30px; height:80px'></div>
	<div style='float:left;width:150px; height:150px'>
		<canvas id="buy" ></canvas>
	</div>
	<div style='float:left;width:30px; height:80px'></div>
	<div style='float:left;width:150px; height:150px'>
		<canvas id="ER" ></canvas>
	</div>
	<div style="clear: both"></div>
	
	<script>
		var ctx = document.getElementById("cate").getContext('2d');
		var cate = new Chart(ctx,{type:'horizontalBar', data:categoryCntData, options: options});
		cate.options.title.text ='광고이력';
		cate.data.datasets[0].data =[category_cnt[0]];
		cate.data.datasets[1].data =[category_cnt[1]];
		cate.options.scales.xAxes[0].ticks.display = false;
		cate.options.scales.xAxes[0].stacked= true;
		cate.options.scales.yAxes[0].stacked= true;
		cate.update();

		var ctx5 = document.getElementById("rating").getContext('2d');
		var rating = new Chart(ctx5,{type:'horizontalBar', data:ratingData, options: options});
		rating.options.title.text ='평점';
		rating.data.datasets[0].data= [ch_rating[0]];
		rating.data.datasets[1].data= [ch_rating[1]];
		rating.options.scales.xAxes[0].ticks.display = false;
		rating.options.scales.xAxes[0].stacked= true;
		rating.options.scales.yAxes[0].stacked= true;
		rating.update();
		//rating.update();
		
		var ctx1 = document.getElementById("view").getContext('2d');
		var view = new Chart(ctx1,{type:'bar', data:viewData, options: options});
		view.options.title.text = '조회';
		view.data.labels[2] = shop_category;
		
		var ctx2 = document.getElementById("chat").getContext('2d');
		var chat = new Chart(ctx2,{type:'bar', data:chatData, options: options});
		chat.options.title.text = '채팅';
		chat.data.labels[2] = shop_category;
		
		var ctx3 = document.getElementById("buy").getContext('2d');
		var buy = new Chart(ctx3,{type:'bar', data:buyData, options: options});
		buy.options.title.text = '구매';
		buy.data.labels[2] = shop_category;
		
		var ctx4 = document.getElementById("ER").getContext('2d');
		var er = new Chart(ctx4,{type:'bar', data:ERData, options: options});
		er.options.title.text = '반응률(ER)';	
		er.data.labels[2] = shop_category;	
		
		var ctx6 = document.getElementById("gender").getContext('2d');
		var gender = new Chart(ctx6,{type:'doughnut', data:genderData, options: options});
		gender.options.title.text = '성별';
		gender.options.scales.xAxes[0].ticks.display = false;
		gender.options.legend.display=true;
		gender.update();
		
		var ctx7 = document.getElementById("age").getContext('2d');
		var age = new Chart(ctx7,{type:'doughnut', data:ageData, options: options});
		age.options.title.text = '연령';
		age.options.scales.xAxes[0].ticks.display = false;
		age.options.legend.display=true;
		//age.update();
		
		var ctx8 = document.getElementById("grow").getContext('2d');
		var grow = new Chart(ctx8,{type:'line', data:growData, options: options});
		grow.options.title.text = '채널 성장률'
		grow.options.scales.yAxes[0].ticks.display = true;
		//grow.update();
		
		gender.data.datasets[0].data= ch_gender;
		gender.update();
		age.data.datasets[0].data= ch_age;
		age.update();
		grow.data.datasets[0].data= ch_grow;
		grow.update();
		
		
		
		view.data.datasets[0].data= ch_view;
		view.update();
		chat.data.datasets[0].data= ch_chat;
		chat.update();
		buy.data.datasets[0].data= ch_buy;
		buy.update();
		er.data.datasets[0].data= ch_er;
		er.update();
	</script>
	</div>
	<div style="clear: both;"></div>
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
