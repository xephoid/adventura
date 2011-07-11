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
	protected City city;
	
	public BaseCityAction(WorldResource resourceType) {
		this.resourceType = resourceType;
	}
	
	@Override
	public boolean canDoAction() {
		for (WorldResourceRequirement req : resourceType.getRequirements()) {
			WorldResource required = req.getRequired();
			if (city.getResourceCount(required) < req.getRequiredAmount()) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean isDone() {
		return isDone;
	}

	protected void recieveResource(float quantity) {
		Map<WorldResource, Float> cityResources = city.getResources();
		Map<WorldResource, Float> cityGrossIncome = city.getGrossResourceIncome();
		cityResources.put(resourceType, cityResources.get(resourceType) + procureQuantity);
		cityGrossIncome.put(resourceType, cityResources.get(resourceType) + procureQuantity);
		
		if (resourceType instanceof ResourceAcquirer) {
			ResourceAcquirer aqcuirer = (ResourceAcquirer) resourceType;
			city.addResourceAqcuierer(aqcuirer);
		}
	}
	
	protected void spendResource(WorldResource resource, float quantity) {
		Map<WorldResource, Float> cityResources = city.getResources();
		switch (resource.getSpendType()) {
			case ALLOCATABLE :
				cityResources.put(resource, cityResources.get(resource) - quantity);
				Map<WorldResource, Float> allocated = city.getAttributedResources();
				allocated.put(resource, allocated.get(resource) + quantity);
				break;
			case CONSUMABLE :
				cityResources.put(resource, cityResources.get(resource) - quantity);
				break;
			case NONE :
			default :
				break;
		}
	}
	
	public City getCity() {
		return city;
	}
	
	public void setCity(City city) {
		this.city = city;
	}
}
