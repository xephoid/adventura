package com.ionmarkgames.aventura.model.engine.cityactions;

import java.util.Map;

import com.ionmarkgames.aventura.model.engine.ICityAction;
import com.ionmarkgames.aventura.model.engine.WorldResource;
import com.ionmarkgames.aventura.model.engine.WorldResourceRequirement;
import com.ionmarkgames.aventura.model.engine.physical.City;
import com.ionmarkgames.aventura.model.engine.physical.ResourceAcquirer;

public abstract class BaseCityAction implements ICityAction {

	protected WorldResource resourceType;
	protected boolean isDone = false;
	protected float procureQuantity = 1f;
	
	public BaseCityAction(WorldResource resourceType) {
		this.resourceType = resourceType;
	}
	
	@Override
	public boolean canDoAction(City city) {
		for (WorldResourceRequirement req : resourceType.getRequirements()) {
			WorldResource required = req.getRequired();
			if (city.getResourceCount(required) < req.getRequiredAmount()) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void doAction(City city) {
		Map<WorldResource, Float> cityResources = city.getResources();
		Map<WorldResource, Float> cityGrossIncome = city.getGrossResourceIncome();
		for (WorldResourceRequirement req : resourceType.getRequirements()) {
			WorldResource required = req.getRequired();
			cityResources.put(required, cityResources.get(required) - req.getRequiredAmount());
		}
		cityResources.put(resourceType, cityResources.get(resourceType) + procureQuantity);
		cityGrossIncome.put(resourceType, cityResources.get(resourceType) + procureQuantity);
		
		if (resourceType instanceof ResourceAcquirer) {
			ResourceAcquirer aqcuirer = (ResourceAcquirer) resourceType;
			city.addResourceAqcuierer(aqcuirer);
		}
		
		isDone = true;
	}
	
	@Override
	public boolean isDone() {
		return isDone;
	}

}
