package com.generation.travel.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User extends com.generation.common.model.entities.Entity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String email;

	private int level;

	private String nickname;

	private String password;

	//bi-directional many-to-one association to Story
	@OneToMany(mappedBy="user", cascade=CascadeType.PERSIST)
	private List<Story> stories;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Story> getStories() {
		return this.stories;
	}

	public void setStories(List<Story> stories) {
		this.stories = stories;
	}

	public Story addStory(Story story) {
		getStories().add(story);
		story.setUser(this);

		return story;
	}

	public Story removeStory(Story story) {
		getStories().remove(story);
		story.setUser(null);

		return story;
	}

	@Override
	public boolean valid()
	{
		return notVoid(email) && notVoid(password) && notVoid(nickname);
	}
	
	public static User guest()
	{
		User res = new User();
		res.setNickname("GUEST");
		res.setEmail("");
		return res;	}

}