package com.generation.travel.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;

public class FormLogin extends WebCommand {

	@Override
	protected void handle() throws IOException, ServletException
	{
		req.setAttribute("controllerjs", "js/formlogincontroller.js");
		render("formlogin.jsp");		
	}

	@Override
	public int getLevel() 
	{
		return 0;
	}

}
