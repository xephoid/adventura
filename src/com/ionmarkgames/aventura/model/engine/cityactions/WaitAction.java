package com.ionmarkgames.aventura.model.engine.cityactions;

import com.ionmarkgames.aventura.model.engine.ICityAction;
import com.ionmarkgames.aventura.model.engine.WorldResource;
import com.ionmarkgames.aventura.model.engine.WorldResourceRequirement;

public class WaitAction extends BaseCityAction implements ICityAction {
	
	
	public WaitAction(WorldResource resourceType) {
		super(resourceType);
	}
	
	@Override
	public boolean canDoAction() {
		return true;
	}

	@Override
	public void doAction() {
		for (WorldResourceRequirement req : resourceType.getRequirements()) {
			spendResource(req.getRequired(), req.getRequiredAmount());
		}
		recieveResource(procureQuantity);
		isDone = true;
	}
}
