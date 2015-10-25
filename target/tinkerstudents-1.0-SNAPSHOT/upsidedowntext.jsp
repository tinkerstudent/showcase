<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="/stylesheets/main.css"/>
</head>

<body>
<div class="container">
<h2>Type text, words, letters, or symbols below</h2>
<form id="inputfrm" action="/upsidedowntext.jsp" method="post">
    <div>
    <div><textarea class="styledta" form="inputfrm" name="inputtext"></textarea></div>
    <div><input class="styledbutton" type="submit" value="Get Upside Down Text!"/></div>
</form>
<div class="outputdiv">
<h2>Here is the reversed text</h2>
</div>
</div>
</body>
</html>