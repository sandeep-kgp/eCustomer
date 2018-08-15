<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="../include/taglib.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" type="text/css" />		
	<link href="${pageContext.request.contextPath}/resources/css/button.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/resources/css/general.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/resources/css/lightbox.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/resources/css/calendar.css" rel="stylesheet" type="text/css" />		
	<link href="${pageContext.request.contextPath}/resources/css/autocomplete.css" rel="stylesheet" type="text/css" />
	
	<title><tiles:insertAttribute name="title" ignore="true" /></title>

</head>
<body>
	<div id="wrap">
	<tiles:insertAttribute name ="topBar"></tiles:insertAttribute>
	<tiles:insertAttribute name= "header"></tiles:insertAttribute>
	<tiles:insertAttribute name= "menu"></tiles:insertAttribute>
	<tiles:insertAttribute name= "body"></tiles:insertAttribute>
	<tiles:insertAttribute name= "footer"></tiles:insertAttribute>
</div>

</body>
</html>