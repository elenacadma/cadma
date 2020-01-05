<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.generation.travel.model.entities.*,java.util.List,com.generation.common.view.language.Language" %>
<%
	User user = (User) request.getAttribute("user");
	Story story = (Story) request.getAttribute("story");
	Language l = (Language) request.getAttribute("language");
%>
<jsp:include page="menu.jsp" />
<style>
	#story
	{
		padding-left:40px;
		padding-top:20px;
	}
	
	.story IMG
	{
		height:400px;width:auto;padding:auto;margin:auto;
	}
	
	#story .cost
	{
		margin-top:20px;
		font-weight:bold;
		font-size:24px;
	}
</style>
<div id="story">
	<h1> <%=story.getTitle() %></h1>
	
	<div class="w3-half">
		<%=l.translate("FROM") %> <%=story.getSincedate() %> <%=l.translate("TO") %> <%=story.getTodate() %> <br /><br />
		<img src="<%=story.getImage() %>" style="" />
		<div class="cost">
			<%=l.translate("COST") %> <%=story.getCost() %> &euro;
		</div>
	</div>
	<div style="text-align:justify" class="w3-half">
		<%=story.getContent().replace("\n", "<br><br>") %>
	</div>
	

</div>