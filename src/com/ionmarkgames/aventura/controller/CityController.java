package com.ionmarkgames.aventura.controller;

import com.ionmarkgames.aventura.model.engine.ICityAction;
import com.ionmarkgames.aventura.model.engine.WorldResource;
import com.ionmarkgames.aventura.model.engine.WorldResourceRequirement;
import com.ionmarkgames.aventura.model.engine.cityactions.CityActionFactory;
import com.ionmarkgames.aventura.model.engine.physical.City;

public class CityController extends BaseController {

	private City city;
	
	public CityController(StoryEventHandler handler) {
		super(handler);
	}
	
	public void setCity(City city) {
		this.city = city;
	}
	
	public void findNextAction(WorldController wc) {
		WorldResource neededResource = wc.getMostValueableResource();
		
		ICityAction action = CityActionFactory.getCityAction(neededResource.getAquireAction(), city);
		
		if (action.canDoAction()) {
			city.setCurrentAction(action);
		} else {
			action = getRequiredAction(neededResource);
		}
	}
	
	private ICityAction getRequiredAction(WorldResource needed) {
		for (WorldResourceRequirement req : needed.getRequirements()) {
			if (city.getResourceCount(req.getRequired()) < req.getRequiredAmount()) {
				ICityAction action = CityActionFactory.getCityAction(req.getRequired().getAquireAction(), city); 
				if (action.canDoAction()) {
					return action;
				} else {
					return getRequiredAction(req.getRequired());
				}
			}
		}
		return null;
	}
}