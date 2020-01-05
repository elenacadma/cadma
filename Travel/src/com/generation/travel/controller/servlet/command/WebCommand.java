package com.generation.travel.controller.servlet.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.generation.common.view.language.Language;
import com.generation.travel.controller.context.Context;
import com.generation.travel.model.bl.TravelBL;
import com.generation.travel.model.entities.User;



/**
 * Un comando che verrà eseguito e che dovrà produrre una response
 * @author Ferdinando
 *
 */
public abstract class WebCommand 
{
	protected final static User GUEST = (User) Context.getInstance().get("guest");
	
	/**
	 * Inizializzazione - prendo le dipendenze
	 */
	
	
	//mantengo un riferimento alla request
	HttpServletRequest req;
	HttpServletResponse res;
	HttpSession session;
	User user;
	TravelBL bl;
	Language language;
	
	
	private void init(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		//in questo modo handle lavorerà su req, res e session. Sono solo alias
		req = request;
		res = response;
		session = request.getSession();
		
		//leggo lo user da session
		user = (User) session.getAttribute("user");
		if(user==null) 
			user = GUEST;
		//controllo di accesso
		if(user.getLevel()<this.getLevel())
		{
			forward("forbidden");
			return;
			
		}
		
		//La business logic. E' unica per tutto il progetto
		bl = (TravelBL) Context.getInstance().get("bl");
		
		//la lingua va nella session. Ogni utente ha la sua lingua
		language = (Language) session.getAttribute("language");
		//se non c'è, parte da inglese
		if(language==null)
			language = Context.getInstance().changeLanguage("eng");
		
		//Li mando alla request. SEMPRE
		request.setAttribute("user", user);
		request.setAttribute("language", language);
		
	}
	
	protected Map<String,String> requestParametersToMap()
	{
		Map<String,String> res = new HashMap<String,String>();
		for(String key:req.getParameterMap().keySet())
			res.put(key, req.getParameter(key));
		return res;		
	}
	
	protected java.util.Date stringToDate(String date)
	{
		
		try
		{
			// mi aspetto una data nel formato gg/mm/aaaa
			// se così non fosse eccezione!
			java.util.Date res = new java.util.Date();
			int year = Integer.parseInt(date.split("/")[2]);
			res.setYear(year-1900);
			int month = Integer.parseInt(date.split("/")[1])-1;
			res.setMonth(month);
			int day = Integer.parseInt(date.split("/")[0]);
			res.setDate(day);
			return res;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	
	protected String param(String paramName)
	{
		return req.getParameter(paramName);
	}
	
	protected void forward(String cmd) throws IOException, ServletException
	{
		Behaviour.getInstance().get(cmd).run(req,res);		
	}
	
	protected void render(String view) throws IOException, ServletException
	{
		req.getRequestDispatcher(view).forward(req, res);
	}
	
	protected abstract void handle()  throws IOException, ServletException;
	
	public void run(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException
	{
		init(request, response);
		handle();
	}
	
	public abstract int getLevel();
	
	
}
