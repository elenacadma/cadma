package com.generation.travel.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NotFound extends WebCommand
{

	@Override
	protected void handle()
			throws IOException, ServletException
	{
		res.getWriter().append("NOT FOUND");
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

}
