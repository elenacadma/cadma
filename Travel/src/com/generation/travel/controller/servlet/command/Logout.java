package com.generation.travel.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;

public class Logout extends WebCommand {

	@Override
	protected void handle() throws IOException, ServletException
	{
		session.setAttribute("user", GUEST);
		forward("");
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

}
