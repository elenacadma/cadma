package com.generation.travel.controller.servlet.command;

import java.util.HashMap;
import java.util.Map;

import com.generation.travel.model.entities.Story;

public class Behaviour
{
	private static Behaviour instance = new Behaviour();
	private final static WebCommand NOTFOUND = new NotFound();
	
	public static Behaviour getInstance()
	{
		return instance;
	}
	
	Map<String,WebCommand> commands = new HashMap<String,WebCommand>();
	
	private Behaviour()
	{
		commands.put("formregister",new FormRegister());
		commands.put("register", new Register());
		commands.put("", new HomePage());
		commands.put("formlogin", new FormLogin());
		commands.put("login", new Login());
		commands.put("myhome", new MyHome());
		commands.put("formnewstory", new FormNewStory());
		commands.put("newstory", new NewStory());
		commands.put("forbidden", commands.get("formlogin"));
		commands.put("story", new StoryDetail());
		commands.put("deletestory", new DeleteStory());
		commands.put("changelanguage", new ChangeLanguage());
		commands.put("logout", new Logout());
		
	}

	public WebCommand get(String cmd)
	{
		if(cmd==null) cmd = "";
		return commands.containsKey(cmd) ? commands.get(cmd)	: NOTFOUND;	
	}
	
	
}
