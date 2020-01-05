package com.generation.travel.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;

public class FormNewStory extends WebCommand {

	@Override
	protected void handle() throws IOException, ServletException 
	{
		req.setAttribute("controllerjs", "js/formnewstorycontroller.js");
		render("formnewstory.jsp");
	}

	@Override
	public int getLevel() 
	{
		return 1;
	}

}
