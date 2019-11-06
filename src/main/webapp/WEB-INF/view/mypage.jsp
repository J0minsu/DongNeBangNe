<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>

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
	</div>


</div>
<!-- .mypage_wrap -->



</div>
<!-- .site_wrap -->

</body>
</html>
