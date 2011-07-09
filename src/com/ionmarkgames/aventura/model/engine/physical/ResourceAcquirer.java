package com.ionmarkgames.aventura.model.engine.physical;

import com.ionmarkgames.aventura.model.engine.WorldResource;

public class ResourceAcquirer extends WorldResource implements IPhysicalObject {

	private int x;
	private int y;
	private WorldResource resourceType;
	private float carryQauntity;
	
	@Override
	public int getHeight() {
		return 1;
	}
	@Override
	public int getWidth() {
		return 1;
	}

	@Override
	public int getX() {
		return x;
	}
	@Override
	public int getY() {
		return y;
	}
	
	public void setResourceType(WorldResource resourceType) {
		this.resourceType = resourceType;
	}
	public WorldResource getResourceType() {
		return resourceType;
	}
	
	public void setCarryQauntity(float carryQauntity) {
		this.carryQauntity = carryQauntity;
	}
	public float getCarryQauntity() {
		return carryQauntity;
	}
}
