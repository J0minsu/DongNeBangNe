<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html lang="ko">
<head>
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
		
		<tiles:insertAttribute name="body" />
	</div>