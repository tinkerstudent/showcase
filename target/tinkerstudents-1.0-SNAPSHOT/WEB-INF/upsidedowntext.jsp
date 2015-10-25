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
<%
    String user = (String) request.getAttribute("user");
    String input = (String) request.getAttribute("input");
    if (input == null) {
    	input = "";
	}
	String output = (String) request.getAttribute("output");
    if (output == null) {
    	output = "";
	}
    pageContext.setAttribute("user", user);
    pageContext.setAttribute("input", input);
    pageContext.setAttribute("output", output);
%>
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.5";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
<div>
<img src="/images/TinkerAcademy.png" >
<p>Developer: ${fn:escapeXml(user)}</p>
</div>
<div class="container">
<form id="inputfrm" method="post">
	<p>Type text, words, letters, or symbols below</p>
    <div><textarea class="styledta" form="inputfrm" name="inputtext">${fn:escapeXml(input)}</textarea></div>
    <div><input class="styledbutton" type="submit" value="Get Upside Down Text!"/></div>
</form>
</div>
<div class="outputdiv">
	<div><textarea readonly class="styledta upsidedownta" name="outputtext">${fn:escapeXml(output)}</textarea></div>
</div>
<div class="fb-like" data-href="http://www.facebook.com/tinkeracademy" data-layout="standard" data-action="like" data-show-faces="true" data-share="true"></div>
</body>
</html>