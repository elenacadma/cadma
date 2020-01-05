package com.generation.travel.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;

public class MyHome extends WebCommand {

	@Override
	protected void handle() throws IOException, ServletException 
	{
		req.setAttribute("stories", user.getStories());
		render("myhome.jsp");
	}

	@Override
	public int getLevel() 
	{
		return 1;
	}

}
