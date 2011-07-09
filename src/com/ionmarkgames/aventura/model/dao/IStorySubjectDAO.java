package com.ionmarkgames.aventura.model.dao;

import java.util.List;

import com.ionmarkgames.aventura.model.BaseStorySubject;

public interface IStorySubjectDAO<StorySubject extends BaseStorySubject> {
	public StorySubject read(Long id);
	public Boolean update(StorySubject subject);
	public List<StorySubject> getAll();
}