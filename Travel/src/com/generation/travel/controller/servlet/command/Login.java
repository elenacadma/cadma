package com.generation.travel.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;

import com.generation.travel.model.entities.User;

public class Login extends WebCommand {

	@Override
	protected void handle() throws IOException, ServletException 
	{
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User user = bl.login(email, password);
		if(user==null)
		{
			req.setAttribute("err", language.translate("LOGINERROR"));
			forward("formlogin");
		}
		else
		{		
			session.setAttribute("user", user);
			forward("");
		}
	}

	@Override
	public int getLevel() 
	{
		return 0;
	}

}
