package com.ionmarkgames.aventura.controller;

import java.util.ArrayList;
import java.util.List;

import com.ionmarkgames.aventura.model.StoryCriteria;
import com.ionmarkgames.aventura.model.event.StoryEvent;

public class StoryEventHandler {

	List<StoryEvent> eventLog = new ArrayList<StoryEvent>();
	
	public void handleEvent(StoryEvent event) {
		for (StoryCriteria criteria : event.getCriteria()) {
			criteria.setCriteriaMet(true);
		}
		eventLog.add(event);
	}
}
