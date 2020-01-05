package com.generation.travel.model.bl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.generation.travel.model.entities.Story;
import com.generation.travel.model.entities.User;

public class TravelBLJPA implements TravelBL
{
	EntityManager em;

	public TravelBLJPA(String persistanceUnitName)
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(persistanceUnitName);
	    em = emfactory.createEntityManager();
	}
		
	
	@Override
	public User register(User user) throws BLException 
	{
		if(!user.valid())
			throw new BLException("Invalid user", "BADUSER");
		
		user.setLevel(1);
	
		try
		{
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		}
		catch(Exception e)
		{
			throw new BLException(e.getMessage(), "USERALREADYPRESENT");
		}
		
		return user;
	}

	@Override
	public User login(String email, String password) 
	{
		List<User> res = em.createQuery("select u from User u where u.email='"+email+"' and u.password='"+password+"'").getResultList();
		return res.size()>0 ? res.get(0) : null;
	}

	@Override
	public User save(User user) throws BLException 
	{
		
		try
		{
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new BLException(e.getMessage(), "SQLERROR");
		}
		return user;
	}

	@Override
	public Story load(int id) 
	{
		return em.find(Story.class, id);
	}

	@Override
	public void delete(int storyID) throws BLException 
	{
		Story story = load(storyID);
		try
		{
			em.getTransaction().begin();
			em.remove(story);
			em.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new BLException(e.getMessage(), "SQLERROR");
		}
	}

	@Override
	public List<Story> stories(String key) 
	{
		if(key==null) key="";
		return em.createQuery("select s from Story s where s.title like '%"+key+"%' or s.place like '%"+key+"%'").getResultList();
	}


	@Override
	public User loadUser(int id)
	{
		return em.find(User.class, id);
	}

	
	
	
}
