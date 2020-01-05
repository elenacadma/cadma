<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.generation.travel.model.entities.User" %>
    <%
    	String controllerjs = (String) request.getAttribute("controllerjs");
    	User user =  (User) request.getAttribute("user");
    %>
    <!DOCTYPE html>
    <html>
		<head>
			<meta charset="ISO-8859-1">
			<title> Travel Stories - Registration </title>
			<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" />
			<link rel="stylesheet" href="css/main.css" />
			<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
			<% 
			if(controllerjs!=null) 
			{
			%>
			<script src="<%=controllerjs%>"></script>
			<%
			}
			%>
		</head>
	<div id="title" class="w3-card">
		<h1> 
			<a href="Index">Travel Stories</a> 
			<div id="languages">
				<%= user.getNickname() %>
				<% if(user.getLevel()==0){ %>
					<a href="Index?cmd=formlogin">
						<img title="login" src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/User_icon_2.svg/1024px-User_icon_2.svg.png" style="width:30px;height:30px"/>
					</a>
				
				<%} %>
				<% if(user.getLevel()>0) {%>
					<a href="Index?cmd=myhome">
						<img title="my stories" src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7c/Go-home.svg/1024px-Go-home.svg.png" style="width:30px;height:30px"/>
					</a>
					<a href="Index?cmd=formnewstory">
						<img title="new story" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/dc/Blue_pen_icon.svg/1024px-Blue_pen_icon.svg.png" style="width:30px;height:30px"/>
					</a>
					<a href="Index?cmd=logout">
						<img title="logout" src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/IEC5009_Standby_Symbol.svg/897px-IEC5009_Standby_Symbol.svg.png
						" style="width:30px;height:30px"/>

					</a>
				<%} %>
				<a href="Index?cmd=changelanguage&lang=ita">
					<img src="https://upload.wikimedia.org/wikipedia/en/0/03/Flag_of_Italy.svg" />
				</a>
				<a href="Index?cmd=changelanguage&lang=eng">
					<img src="https://upload.wikimedia.org/wikipedia/en/thumb/a/ae/Flag_of_the_United_Kingdom.svg/1280px-Flag_of_the_United_Kingdom.svg.png" />
				</a>
			</div>
		</h1>
	</div>
