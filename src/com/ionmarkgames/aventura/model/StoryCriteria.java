package com.ionmarkgames.aventura.model;

import com.ionmarkgames.aventura.model.event.StoryEvent;

/**
 * Criteria mostly used for whether a StorySubject is visible to the player yet.
 * 
 * @author xephoid
 *
 */
public class StoryCriteria extends BaseStorySubject {

	private StoryEvent requiredEvent;
	private Boolean criteriaMet = false;

	public void setRequiredAction(StoryEvent requiredAction) {
		this.requiredEvent = requiredAction;
	}

	public StoryEvent getRequiredAction() {
		return requiredEvent;
	}

	public void setCriteriaMet(Boolean criteriaMet) {
		this.criteriaMet = criteriaMet;
	}

	public Boolean isCriteriaMet() {
		return criteriaMet;
	}
}
