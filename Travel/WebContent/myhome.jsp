<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.generation.travel.model.entities.*,java.util.List,com.generation.common.view.language.Language" %>
<%
	User user = (User) request.getAttribute("user");
	List<Story> stories = user.getStories();
	Language l = (Language) request.getAttribute("language");
%>
<jsp:include page="menu.jsp" />
<link rel="stylesheet" href="css/recipes.css" />
<div id="storylist">
	<h1 style="padding-left:10px"><%=l.translate("STORIESOF") %> <%=user.getNickname() %></h1>
	<% for(Story story:stories) {%>
		<div class="story w3-third">
			<a href="Index?cmd=story&id=<%=story.getId() %>">
				<h2><%=story.getTitle() %></h2>
				<b><%=story.getPlace() %></b> - <%=story.getSincedate()%> - <%=story.getCost() %> &euro;
				<img src="<%=story.getImage() %>" />
			</a> <br />
			<a href="Index?cmd=deletestory&storyid=<%=story.getId() %>" class="w3-btn ourblue ourbutton"> <%=l.translate("DELETE") %></a>			
		</div>	
	<%} %>
</div>