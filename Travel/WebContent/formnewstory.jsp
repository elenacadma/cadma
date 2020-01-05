<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.generation.common.view.language.Language"%>
    <%
    	String err = (String) request.getAttribute("err");
	    if(err==null) err = "";
		Language l = (Language) request.getAttribute("language");

    %>
    
	<style>
		#insertform
		{
			width:50%;			
			padding:auto;
			margin:auto;
		}
	</style>
	<body ng-app="app" ng-controller="controller">
		<jsp:include page="menu.jsp" />
		<div style="height:40px"> &nbsp;</div>
		<form id="insertform" name="form1" action="Index" method="post">
			<h1> <%=l.translate("NEWTRAVELSTORY") %> </h1>
			<%=l.translate("TITLE") %>
			<input type="text" class="w3-input" name="title" ng-model="story.title" />
			<%=l.translate("PLACE") %>
			<input type="text" class="w3-input" name="place" ng-model="story.place" />
			<%=l.translate("SINCEDATE") %>
			<input type="text" class="w3-input" name="sincedate" ng-model="story.sincedate" />
			<%=l.translate("TODATE") %>
			<input type="text" class="w3-input" name="todate" ng-model="story.todate" />
			<%=l.translate("COST") %>
			<input type="text" class="w3-input" name="cost" ng-model="story.cost" />
			<%=l.translate("CONTENT") %>
			<textarea name="content" ng-model="story.content" class="w3-input" style="height:100px"></textarea>
			<%=l.translate("IMAGE") %>
			<input type="text" class="w3-input" name="image" ng-model="story.image" />
			<input type="hidden" name="cmd" value="newstory" />
			<%=err %>
			<input type="submit" value="save" name="send" ng-disabled="!story.valid()" class="w3-input w3-btn ourblue ourbutton "/>
		</form>
			
			
	</body>
</html>