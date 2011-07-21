package com.ionmarkgames.aventura.controller;

import com.ionmarkgames.aventura.model.event.StoryEvent;

public abstract class BaseController {

	private StoryEventHandler eventHandler;
	
	public BaseController(StoryEventHandler eventHandler) {
		this.eventHandler = eventHandler;
	}
	
	protected void fireEvent(StoryEvent event) {
		eventHandler.handleEvent(event);
	}
}