package com.generation.travel.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;

public class HomePage extends WebCommand 
{

	@Override
	protected void handle() throws IOException, ServletException 
	{
		req.setAttribute("stories", bl.stories(param("searchkey")));
		render("homepage.jsp");
	}

	@Override
	public int getLevel() 
	{
		return 0;
	}

}
