package com.ionmarkgames.aventura.model.engine;

import com.ionmarkgames.aventura.model.engine.cityactions.BaseCityAction;

public class WorldResourceAquireAction {

	private Class<? extends BaseCityAction> actionClass;
	private WorldResource resource;

	public WorldResourceAquireAction(Class<? extends BaseCityAction> actionClass, WorldResource resource) {
		this.setActionClass(actionClass);
		this.setResource(resource);
	}

	public void setActionClass(Class<? extends BaseCityAction> actionClass) {
		this.actionClass = actionClass;
	}
	public Class<? extends BaseCityAction> getActionClass() {
		return actionClass;
	}

	public void setResource(WorldResource resource) {
		this.resource = resource;
	}
	public WorldResource getResource() {
		return resource;
	}
}
