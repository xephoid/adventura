package com.ionmarkgames.aventura.model.engine.cityactions;


import com.ionmarkgames.aventura.model.engine.ICityAction;
import com.ionmarkgames.aventura.model.engine.WorldResource;

public class AssignAction extends BaseCityAction implements ICityAction {

	public AssignAction(WorldResource resourceType) {
		super(resourceType);
	}

}