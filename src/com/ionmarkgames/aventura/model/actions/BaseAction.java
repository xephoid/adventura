package com.ionmarkgames.aventura.model.actions;

import com.ionmarkgames.aventura.model.BaseStorySubject;

/**
 * Something the player does.
 * 
 * @author xephoid
 *
 */
public class BaseAction extends BaseStorySubject {

	private ActionType type;
	private BaseStorySubject target;

	public void setTarget(BaseStorySubject target) {
		this.target = target;
	}
	
	public BaseStorySubject getTarget() {
		return target;
	}

	public void setType(ActionType type) {
		this.type = type;
	}

	public ActionType getType() {
		return type;
	}
}
