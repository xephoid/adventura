package com.ionmarkgames.aventura.model.engine.cityactions;

import com.ionmarkgames.aventura.model.engine.ICityAction;
import com.ionmarkgames.aventura.model.engine.WorldResource;
import com.ionmarkgames.aventura.model.engine.physical.City;
import com.ionmarkgames.aventura.model.engine.physical.ResourceAcquirer;
import com.ionmarkgames.aventura.model.engine.physical.WorldResourceLocation;

public class CollectAction extends BaseCityAction implements ICityAction {
	
	private WorldResourceLocation location;

	public CollectAction(WorldResource resourceType) {
		super(resourceType);
	}

	@Override
	public boolean canDoAction(City city) {
		if (!super.canDoAction(city)) {
			return false;
		}
		boolean hasResource = false;
		for (WorldResourceLocation location : city.getResourceCollectionLocations()) {
			if (location.getResourceType().equals(resourceType)) {
				hasResource = true;
				this.location = location;
			}
		}
		return hasResource;
	}

	@Override
	public void doAction(City city) {
		ResourceAcquirer acquirer = city.getResourceAquirers().get(resourceType.getName()).get(0);
		if (location != null && acquirer != null) {
			location.setQuantity(location.getQuantity() - acquirer.getCarryQauntity());
			procureQuantity = acquirer.getCarryQauntity();
			super.doAction(city);
		}
	}
}
