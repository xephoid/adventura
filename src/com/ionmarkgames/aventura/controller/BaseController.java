package com.ionmarkgames.aventura.controller;

import com.ionmarkgames.aventura.model.BaseStorySubject;
import com.ionmarkgames.aventura.model.dao.IStoryDataSource;
import com.ionmarkgames.aventura.model.dao.IStorySubjectDAO;

public abstract class BaseController<StorySubject extends BaseStorySubject> {

	private StorySubject subject;
	private IStorySubjectDAO<StorySubject> dao;
	private IStoryDataSource dataSource;
	
	public StorySubject getStorySubject() {
		return subject;
	}
	public void setStorySubject(StorySubject subject) {
		this.subject = subject;
	}
	
	public void setDao(IStorySubjectDAO<StorySubject> dao) {
		this.dao = dao;
	}
	public IStorySubjectDAO<StorySubject> getDao() {
		return dao;
	}
	
	public void setDataSource(IStoryDataSource dataSource) {
		this.dataSource = dataSource;
	}
	public IStoryDataSource getDataSource() {
		return dataSource;
	}
}