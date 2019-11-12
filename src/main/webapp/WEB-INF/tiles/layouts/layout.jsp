<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html lang="ko">
<head>
<script>
	var userId =3;
	dataLayer=[{'userId': userId}];
</script>
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-MRWWSG4');</script>
<!-- End Google Tag Manager -->
<meta charset="utf-8">
<meta http-equiv="imagetoolbar" content="no">
<meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
<meta name="viewport" content="width=1120">


<link rel="stylesheet"
	href="https://fonts.googleapis.com/earlyaccess/notosanskr.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xeicon.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/common.js"></script>
</head>


<div class="site_wrap">
	<div>
		<div class="header_wrap">
			<div class="header">
				<ul class="nav">
					<li><a href="/recommendInfluencer">인플루언서</a></li>
					<li><a href="/searchProvider">소상공인</a></li>
					<li class="logo"><a href="/"><img
							src="${pageContext.request.contextPath}/static/images/logo.png" alt=""></a></li>
					<li><a href="/contracting?providerId=3">매칭</a></li>
					<li><a href="/">내정보</a></li>
				</ul>
			</div>
		</div>
		<!-- Google Tag Manager (noscript) -->
		<noscript>
			<iframe src="https://www.googletagmanager.com/ns.html?id=GTM-MRWWSG4"
				height="0" width="0" style="display: none; visibility: hidden"></iframe>
		</noscript>
		<!-- End Google Tag Manager (noscript) -->
		<tiles:insertAttribute name="body" />
		
	</div>