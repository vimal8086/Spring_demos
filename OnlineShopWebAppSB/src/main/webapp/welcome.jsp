<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body bgcolor="pink">
<h3>Dear ${uname}<%@ include file="header.html" %></h3>

<h3><mark>Shop according to you want</mark></h3>

<p>Session Timeout : </p>
<% session.setMaxInactiveInterval(10); %>
<%= session.getMaxInactiveInterval() %>

<% 
String encodeURL= response.encodeURL("/products");
%>


<p style="color:red;">To enjoy Shopping<a href="<%= encodeURL%>">Click here</a></p>
<%@ include file="footer.html" %>
</body>
</html>