package com.generation.travel.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;

import com.generation.travel.controller.context.Context;

public class ChangeLanguage extends WebCommand {

	@Override
	protected void handle() throws IOException, ServletException
	{
		session.setAttribute("language", Context.getInstance().changeLanguage(param("lang")));
		forward("");
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

}
