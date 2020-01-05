package com.generation.travel.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;

import com.generation.travel.model.bl.BLException;
import com.generation.travel.model.entities.User;

public class Register extends WebCommand 
{

	@Override
	protected void handle() throws IOException, ServletException
	{
		User user = new User();
		user.fromMap(requestParametersToMap());
		//mi aspetto la data in formato gg/mm/aaaa

		try
		{
			bl.register(user);
			res.getWriter().append("Ti sei registrato ma per ora non ci sono altre pagine. Ti faremo sapere, tipo gugol plas");
		}
		catch(BLException e)
		{
			req.setAttribute("err", language.translate(e.getErrCode()));
			forward("formregister");
		}
				
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

}
