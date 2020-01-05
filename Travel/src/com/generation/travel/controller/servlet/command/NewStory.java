package com.generation.travel.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;

import com.generation.travel.model.bl.BLException;
import com.generation.travel.model.entities.Story;
import com.generation.travel.model.entities.User;

public class NewStory extends WebCommand
{

	@Override
	protected void handle() throws IOException, ServletException 
	{
				
		
		// creo la storia
		user = bl.loadUser(user.getId());
		
		Story story = new Story();
		story.fromMap(requestParametersToMap());
		story.setSincedate(stringToDate(param("sincedate")));
		story.setTodate(stringToDate(param("todate")));
		
		//e viceversa, anche se in realtà non è sempre necessario..
		user.addStory(story);

		try 
		{
			//salvo user nel db
			user = bl.save(user);
			//aggiorno lo user con la nuova storia...
			//il mio user è sempre in sessione, lo ho salvato e devo metterlo in sessione con la sua nuova storia
			session.setAttribute("user", user);
			//torno alla home page
			forward("myhome");
		} 
		catch (BLException e) 
		{
			e.printStackTrace();
			req.setAttribute("err", language.translate(e.getErrCode()));
			forward("formnewstory");
		}
		
	}

	@Override
	public int getLevel() 
	{
		return 0;
	}

}
