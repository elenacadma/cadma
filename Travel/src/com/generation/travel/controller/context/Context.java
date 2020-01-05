package com.generation.travel.controller.context;

import java.util.HashMap;
import java.util.Map;

import com.generation.common.view.language.Language;
import com.generation.common.view.language.LanguageFactory;
import com.generation.travel.model.bl.TravelBLJPA;
import com.generation.travel.model.entities.User;

public class Context extends com.generation.common.controller.context.Context
{
	private static Context instance = new Context();
	
	private Map<String,Language> languages = new HashMap<String,Language>();
	
	public static Context getInstance()
	{
		return instance;
	}
	
	private Context()
	{
		languages.put("eng",LanguageFactory.make("C:\\Users\\FreePC\\eclipse-workspace\\Travel\\english.lang"));
		languages.put("ita",LanguageFactory.make("C:\\Users\\FreePC\\eclipse-workspace\\Travel\\italian.lang"));
		
		
		put("bl", new TravelBLJPA("Travel") );
		
		put("guest", User.guest());
	}
	
	public Language changeLanguage(String languageCode)
	{
		return languages.containsKey(languageCode) ? languages.get(languageCode) : languages.get("eng");		
	}
	
	
}
