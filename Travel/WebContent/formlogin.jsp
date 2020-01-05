<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.generation.common.view.language.Language" %>
<%
	Language l = (Language) request.getAttribute("language");
	String err = (String) request.getAttribute("err");
	if(err==null) err = "";
	
%>    
	<style>
		#loginform
		{
			width:50%;			
			padding:auto;
			margin:auto;
		}
	</style>
		<jsp:include page="menu.jsp" />
		<body ng-app="app" ng-controller="controller">
		<div style="height:100px"> &nbsp;</div>
		<form id="loginform" name="form1" action="Index" method="post">
			<%=l.translate("EMAIL") %>
			<input type="text" class="w3-input" name="email" ng-model="user.email" />
			<%=l.translate("PASSWORD") %>
			<input type="password" class="w3-input" name="password" ng-model="user.password" />
			<input type="hidden" name="cmd" value="login" />
			<%=err %>
			<input type="submit" value="<%=l.translate("LOGIN") %>" name="login" ng-disabled="!user.valid()" class="w3-input w3-btn ourblue ourbutton "/>
		</form>
	</body>
</html>