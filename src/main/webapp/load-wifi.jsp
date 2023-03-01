<%@ page import="com.example.project_wifi.LoadWiFi" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>와이파이 정보 구하기</title>
		<style>
			body {
				text-align: center;
			}
		</style>
	</head>
	<body>
		<% int count = LoadWiFi.listTotalCount; %>
		<h1><%=count%>개의 WIFI정보를 정상적으로 저장하였습니다.</h1>
		<a href = "${pageContext.request.contextPath}/">홈 으로 가기</a>
	</body>
</html>