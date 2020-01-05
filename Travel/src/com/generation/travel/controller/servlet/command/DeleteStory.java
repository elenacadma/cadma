package com.generation.travel.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;

import com.generation.travel.model.bl.BLException;
import com.generation.travel.model.entities.Story;

public class DeleteStory extends WebCommand 
{

	@Override
	protected void handle() throws IOException, ServletException 
	{
		int storyID = Integer.parseInt(param("storyid"));
				
		//carico la storia a partire dal suo storyID
		Story story = bl.load(storyID);
		user = story.getUser();
		
		//disassocio la storia
		user.removeStory(story);
		
		try 
		{
			//cancello la storia
			bl.delete(storyID);
			//salvo lo user
			user = bl.save(user);
			//aggiorno la session
			session.setAttribute("user", user);
			//torno alla mia home page
			forward("myhome");
		} 
		catch (BLException e) 
		{
			forward("forbidden");
			e.printStackTrace();
			return;
		}
		
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

}
