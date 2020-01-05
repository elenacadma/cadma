<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.generation.common.view.language.Language" %>
<%
	Language l = (Language) request.getAttribute("language");
	String err = (String) request.getAttribute("err");
	if(err==null) err = "";
	
%>    
	<style>
		#registrationform
		{
			width:50%;			
			padding:auto;
			margin:auto;
		}
	</style>
	<body ng-app="app" ng-controller="controller">
		<jsp:include page="menu.jsp" />
		<div style="height:40px"> &nbsp;</div>
		<form id="registrationform" name="form1" action="Index" method="post">
			<%=l.translate("NICKNAME") %>
			<input type="text" class="w3-input" name="nickname" ng-model="user.nickname" />
			<%=l.translate("EMAIL") %>
			<input type="text" class="w3-input" name="email" ng-model="user.email" />
			<%=l.translate("PASSWORD") %>
			<input type="password" class="w3-input" name="password" ng-model="user.password" />
			<%=l.translate("REPEAT PASSWORD") %>
			<input type="password" class="w3-input" name="password2" ng-model="user.password2" />
			<br />
			<input type="hidden" name="cmd" value="register" />
			<%=err %>
			<input type="submit" value="register" name="send" ng-disabled="!user.valid()" class="w3-input w3-btn ourblue ourbutton "/>
				
		
		</form>
			
			
	</body>
</html>