package com.ionmarkgames.aventura.controller;

import com.ionmarkgames.aventura.model.engine.ICityAction;
import com.ionmarkgames.aventura.model.engine.WorldResource;
import com.ionmarkgames.aventura.model.engine.WorldResourceRequirement;
import com.ionmarkgames.aventura.model.engine.physical.City;

public class CityController {

	private City city;
	
	public void setCity(City city) {
		this.city = city;
	}
	
	public void findNextAction(WorldController wc) {
		WorldResource neededResource = wc.getMostValueableResource();
		
		ICityAction action = neededResource.getAquireAction();
		if (action.canDoAction(city)) {
			city.setCurrentAction(action);
		} else {
			switch (neededResource.getAquireType()) {
				case AUTOMATIC:
				case ASSIGNABLE:
				case BUILDABLE:
					action = getRequiredAction(neededResource);
					break;
				case COLLECTABLE:
					/ TODO: make collectors 
				case TRADEABLE:
					// TODO: Build armies to attack
				default:
					// ????
			}
		}
	}
	
	private ICityAction getRequiredAction(WorldResource needed) {
		for (WorldResourceRequirement req : needed.getRequirements()) {
			if (city.getResourceCount(req.getRequired()) < req.getRequiredAmount()) {
				if (req.getRequired().getAquireAction().canDoAction(city)) {
					return req.getRequired().getAquireAction();
				} else {
					return getRequiredAction(req.getRequired());
				}
			}
		}
		return null;
	}
}
