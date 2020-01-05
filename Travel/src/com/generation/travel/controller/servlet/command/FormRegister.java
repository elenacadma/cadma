package com.generation.travel.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;

public class FormRegister extends WebCommand 
{

	@Override
	protected void handle() throws IOException, ServletException 
	{
		//Gli dico anche quale file caricare per controllare la pagina
		req.setAttribute("controllerjs", "js/formregistercontroller.js");
		render("formregister.jsp");
	}

	@Override
	public int getLevel() 
	{
		return 0;
	}

}
