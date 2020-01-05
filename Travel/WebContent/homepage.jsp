<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.generation.travel.model.entities.*,java.util.List,com.generation.common.view.language.Language" %>
<%
	User user = (User) request.getAttribute("user");
	List<Story> stories = (List<Story>) request.getAttribute("stories");
	Language language = (Language) request.getAttribute("language");
	
	System.out.println(language);
	
%>
<jsp:include page="menu.jsp" />
<link rel="stylesheet" href="css/stories.css" />
<div id="storylist">
	<h1 style="padding-left:10px"><%=language.translate("STORYLIST") %> 
		<form method="post" action="Index" style="float:right;margin-right:10px">
			<input type="hidden" name="cmd" value="" />
			<input type="text" name="searchkey" placeholder="<%=language.translate("SEARCHKEY")%>" 
			value="<%=request.getParameter("searchkey")!=null ? request.getParameter("searchkey") : "" %>" 
			onkeypress="if(event.keycode==13) this.form.submit()" />
		</form>
	
		
	</h1>
	<% for(Story story:stories) {%>
		<div class="story w3-third">
			<a href="Index?cmd=story&id=<%=story.getId() %>">
				<h2><%=story.getTitle() %></h2>
				<b><%=story.getPlace() %></b> - <%=story.getSincedate().toString()%> - <%=story.getCost() %> &euro;
				<img src="<%=story.getImage() %>" />
			</a>
		</div>	
	<%} %>
</div>