package com.ionmarkgames.aventura.model.engine.cityactions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ionmarkgames.aventura.model.engine.ICityAction;
import com.ionmarkgames.aventura.model.engine.WorldResource;
import com.ionmarkgames.aventura.model.engine.physical.City;

public class TradeAction extends BaseCityAction implements ICityAction {
	
	private City tradingCity;
	private WorldResource tradeResource;

	public TradeAction(WorldResource resourceType) {
		super(resourceType);
	}

	@Override
	public boolean canDoAction(City city) {
		tradingCity = null;
		List<WorldResource> tradableResources = new ArrayList<WorldResource>();
		for (Entry<WorldResource, Float> entry : city.getResources().entrySet()) {
			if (entry.getValue() * entry.getKey().getValue() >= resourceType.getValue()) {
				tradableResources.add(entry.getKey());
			}
		}
		if (tradableResources.size() < 1) {
			return false;
		}
		
		List<City> potentialTraders = new ArrayList<City>();
		for (City neighbor : city.getNeightbors()) {
			if (neighbor.getResourceCount(resourceType) > 1) {
				potentialTraders.add(neighbor);
			}
		}
		if (potentialTraders.size() < 1) {
			return false;
		}
		
		for (City potential : potentialTraders) {
			for (WorldResource r : tradableResources) {
				if (potential.getNeededResources().contains(r)) {
					tradingCity = potential;
					tradeResource = r;
				}
			}
		}
		
		if (tradingCity != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public void doAction(City city) {
		Map<WorldResource, Float> cityResources = city.getResources();
		Map<WorldResource, Float> cityGrossIncome = city.getGrossResourceIncome();
		Map<WorldResource, Float> tradingResources = tradingCity.getResources();
		Map<WorldResource, Float> tradingGrossIncome = tradingCity.getGrossResourceIncome();
		float convertedValue = (tradeResource.getValue() / resourceType.getValue()) * tradeResource.getValue();
		
		cityResources.put(resourceType, cityResources.get(resourceType) + 1);
		cityResources.put(tradeResource, cityResources.get(tradeResource) - convertedValue);
		cityGrossIncome.put(resourceType, cityGrossIncome.get(resourceType) + 1);
		
		tradingResources.put(tradeResource, tradingResources.get(tradeResource) + convertedValue);
		tradingResources.put(resourceType, tradingResources.get(resourceType) - 1);
		tradingGrossIncome.put(tradeResource, tradingGrossIncome.get(tradeResource) + convertedValue);
		isDone = true;
	}
}