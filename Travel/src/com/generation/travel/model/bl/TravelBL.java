package com.generation.travel.model.bl;

import java.util.List;

import com.generation.travel.model.entities.Story;
import com.generation.travel.model.entities.User;

public interface TravelBL 
{

	User register(User user) throws BLException;
	
	User login(String email, String password);
	
	
	
	User save(User user) throws BLException;
	
	Story load(int id);
	
	void delete(int storyID) throws BLException;
	
	List<Story> stories(String key);
	
	default List<Story> stories()
	{
		return stories("");		
	}

	User loadUser(int id);

	
	
}
