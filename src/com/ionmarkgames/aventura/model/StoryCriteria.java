package com.ionmarkgames.aventura.model;

import com.ionmarkgames.aventura.model.actions.BaseAction;

/**
 * Criteria mostly used for whether a StorySubject is visible to the player yet.
 * 
 * @author xephoid
 *
 */
public class StoryCriteria extends BaseStorySubject {

	private BaseAction requiredAction;
	private Boolean criteriaMet = false;

	public void setRequiredAction(BaseAction requiredAction) {
		this.requiredAction = requiredAction;
	}

	public BaseAction getRequiredAction() {
		return requiredAction;
	}

	public void setCriteriaMet(Boolean criteriaMet) {
		this.criteriaMet = criteriaMet;
	}

	public Boolean isCriteriaMet() {
		return criteriaMet;
	}
}
