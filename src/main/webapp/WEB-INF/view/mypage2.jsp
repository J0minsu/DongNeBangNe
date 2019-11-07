<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>

<div class="mypage_wrap">

	<div class="myinfo">
		<div class="conts">
			<div align="center">${follower.num }</div>
			<div class="photo">
				<img src="${shop.profileImage }" alt="">
			</div>
			<div class="info_name">${shop.name }</div>
			<div class="info_id">
				${shop.city } ${shop.gu } ${shop.dong } ${shop.detail }
				<!-- <img src="static/images/ico_memo.png" alt=""> -->
			</div>

			<div class="desc">${shop.description }</div>
		</div>
		<div class="influ_wrap">
			<div class="search_submit">
				<a
					href="/contractDocument?influencerId=${influencer.id }&providerId=3">매칭
					신청</a>
			</div>
			<div class="search_submit">
				<a href="#none">문의하기</a>
			</div>
		</div>
	</div>

	<div class="my_desc">

		<div class="banner">
			<img src="${shop.bannerImage }" alt="">
		</div>
		<div class="txt1">걸작떡볶이</div>

		<div class="txt2">사진을 클릭하시면 크게 보실 수 있습니다!</div>

		<div class="my_prd_list">
			<ul>
				<li><a href="#none"><img src="static/images/img_11.jpg"
						alt=""></a></li>
				<li><a href="#none"><img src="static/images/img_12.jpg"
						alt=""></a></li>
				<li><a href="#none"><img src="static/images/img_13.jpg"
						alt=""></a></li>
				<li><a href="#none"><img src="static/images/img_14.jpg"
						alt=""></a></li>
			</ul>
		</div>
		<div class="txt1">매장 위치</div>
		<div class="info_id">
			${shop.city } ${shop.gu } ${shop.dong } ${shop.detail }
			<!-- <img src="static/images/ico_memo.png" alt=""> -->
		</div>
		<br>
		<table cellpadding="0" cellspacing="0" width="462">
			<tr>
				<td style="border: 1px solid #cecece;"><a
					href="https://v4.map.naver.com/?searchCoord=66e5cae98e81dc576f01aaeafddff608131ba94cc80211b7237d2412898bfbfc&query=6rG47J6R65ah67O27J20IOyekeyghOygkA%3D%3D&tab=1&lng=823941ab20dcf4edb740871bff03684c&mapMode=0&mpx=fe5e25b62c2e29241f8b68938e35434a10bd9d2c47277c60e3e6a3e53f49c40ecd308531be1b8ef322e972ff817ba0160299a06eb5da5831338ea56ebaec2937&lat=2da15947bf875387c871044ab5ca1bc3&dlevel=12&enc=b64&menu=location"
					target="_blank"><img
						src="http://prt.map.naver.com/mashupmap/print?key=p1573100972039_-1276486071"
						width="460" height="340" alt="지도 크게 보기" title="지도 크게 보기"
						border="0" style="vertical-align: top;" /></a></td>
			</tr>
			<tr>
				<td>
					<table cellpadding="0" cellspacing="0" width="100%">
						<tr>
							<td height="30" bgcolor="#f9f9f9" align="left"
								style="padding-left: 9px; border-left: 1px solid #cecece; border-bottom: 1px solid #cecece;">
								<span style="font-family: tahoma; font-size: 11px; color: #666;">2019.11.7</span>&nbsp;<span
								style="font-size: 11px; color: #e5e5e5;">|</span>&nbsp;<a
								style="font-family: dotum, sans-serif; font-size: 11px; color: #666; text-decoration: none; letter-spacing: -1px;"
								href="https://v4.map.naver.com/?searchCoord=66e5cae98e81dc576f01aaeafddff608131ba94cc80211b7237d2412898bfbfc&query=6rG47J6R65ah67O27J20IOyekeyghOygkA%3D%3D&tab=1&lng=823941ab20dcf4edb740871bff03684c&mapMode=0&mpx=fe5e25b62c2e29241f8b68938e35434a10bd9d2c47277c60e3e6a3e53f49c40ecd308531be1b8ef322e972ff817ba0160299a06eb5da5831338ea56ebaec2937&lat=2da15947bf875387c871044ab5ca1bc3&dlevel=12&enc=b64&menu=location"
								target="_blank">지도 크게 보기</a>
							</td>
							<td width="98" bgcolor="#f9f9f9" align="right"
								style="text-align: right; padding-right: 9px; border-right: 1px solid #cecece; border-bottom: 1px solid #cecece;">
								<span style="float: right;"><span
									style="font-size: 9px; font-family: Verdana, sans-serif; color: #444;">&copy;&nbsp;</span>&nbsp;<a
									style="font-family: tahoma; font-size: 9px; font-weight: bold; color: #2db400; text-decoration: none;"
									href="https://www.navercorp.com" target="_blank">NAVER
										Corp.</a></span>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>

</div>
<!-- .mypage_wrap -->


</div>
<!-- .site_wrap -->

</body>
</html>
