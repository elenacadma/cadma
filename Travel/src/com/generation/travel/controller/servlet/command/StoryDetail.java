package com.generation.travel.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;

import com.generation.travel.model.entities.Story;

public class StoryDetail extends WebCommand {

	@Override
	protected void handle() throws IOException, ServletException
	{
		Story story = bl.load(Integer.parseInt(param("id")));
		System.out.println(story);
		req.setAttribute("story", story);
		render("story.jsp");
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

}
