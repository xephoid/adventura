package com.ionmarkgames.aventura.model.event;

import java.util.ArrayList;
import java.util.List;

import com.ionmarkgames.aventura.model.BaseStorySubject;
import com.ionmarkgames.aventura.model.StoryCriteria;

/**
 * Something the player does.
 * 
 * @author xephoid
 *
 */
public class StoryEvent extends BaseStorySubject {

	private EventType type;
	private BaseStorySubject target;
	private List<StoryCriteria> dependantCriteria = new ArrayList<StoryCriteria>();

	public void setTarget(BaseStorySubject target) {
		this.target = target;
	}
	public BaseStorySubject getTarget() {
		return target;
	}

	public void setType(EventType type) {
		this.type = type;
	}
	public EventType getType() {
		return type;
	}

	public void setDependantCriteria(List<StoryCriteria> dependantCriteria) {
		this.dependantCriteria = dependantCriteria;
	}
	public List<StoryCriteria> getDependantCriteria() {
		return dependantCriteria;
	}
}