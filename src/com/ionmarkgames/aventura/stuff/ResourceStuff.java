package com.ionmarkgames.aventura.stuff;

import com.ionmarkgames.aventura.model.engine.WorldResource;

public class ResourceStuff extends BaseStuff {

	private WorldResource resource;
	private float amount;
	
	public void setResource(WorldResource resource) {
		this.resource = resource;
	}
	public WorldResource getResource() {
		return resource;
	}
	
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getAmount() {
		return amount;
	}
}
