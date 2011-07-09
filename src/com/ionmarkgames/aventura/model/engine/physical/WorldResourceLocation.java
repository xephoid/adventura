package com.ionmarkgames.aventura.model.engine.physical;

import java.util.ArrayList;
import java.util.List;

import com.ionmarkgames.aventura.model.engine.IResourceCollector;
import com.ionmarkgames.aventura.model.engine.WorldResource;

// TODO: associate with base story subject
public class WorldResourceLocation implements IPhysicalObject {

	private WorldResource resourceType;
	private List<IResourceCollector> collectors = new ArrayList<IResourceCollector>();
	private Float quantity = Float.MAX_VALUE;
	private int x;
	private int y;
	
	public void setResourceType(WorldResource resourceType) {
		this.resourceType = resourceType;
	}
	public WorldResource getResourceType() {
		return resourceType;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return y;
	}
	
	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}
	public Float getQuantity() {
		return quantity;
	}
	
	public int getWidth() {
		return 1;
	}
	public int getHeight() {
		return 1;
	}
	public void setCollectors(List<IResourceCollector> collectors) {
		this.collectors = collectors;
	}
	
	public List<IResourceCollector> getCollectors() {
		return collectors;
	}
	public void addCollector(IResourceCollector collector) {
		this.collectors.add(collector);
	}
}