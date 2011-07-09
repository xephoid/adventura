package com.ionmarkgames.aventura.model.engine.cityactions;

import java.util.Map;

import com.ionmarkgames.aventura.model.engine.ICityAction;
import com.ionmarkgames.aventura.model.engine.WorldResource;
import com.ionmarkgames.aventura.model.engine.physical.City;
import com.ionmarkgames.aventura.model.engine.physical.ResourceAcquirer;

public class WaitAction extends BaseCityAction implements ICityAction {
	
	
	public WaitAction(WorldResource resourceType) {
		super(resourceType);
	}
	
	@Override
	public boolean canDoAction(City city) {
		return true;
	}

	@Override
	public void doAction(City city) {
		Map<WorldResource, Float> cityResources = city.getResources();
		Map<WorldResource, Float> cityGrossIncome = city.getGrossResourceIncome();
		cityResources.put(resourceType, cityResources.get(resourceType) + 1);
		cityGrossIncome.put(resourceType, cityGrossIncome.get(resourceType) + 1);
		
		if (resourceType instanceof ResourceAcquirer) {
			ResourceAcquirer aqcuirer = (ResourceAcquirer) resourceType;
			city.addResourceAqcuierer(aqcuirer);
		}
		
		isDone = true;
	}
}
