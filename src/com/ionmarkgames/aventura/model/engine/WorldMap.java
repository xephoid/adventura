package com.ionmarkgames.aventura.model.engine;

import java.util.ArrayList;
import java.util.List;

import com.ionmarkgames.aventura.model.engine.physical.City;
import com.ionmarkgames.aventura.model.engine.physical.IPhysicalObject;
import com.ionmarkgames.aventura.model.engine.physical.WorldResourceLocation;

public class WorldMap implements IPhysicalObject {

	private List<IPhysicalObject> objects = new ArrayList<IPhysicalObject>();
	private List<City> cities = new ArrayList<City>();
	private List<WorldResourceLocation> resourceLocations = new ArrayList<WorldResourceLocation>();
	private List<WorldResource> resourceTypes = new ArrayList<WorldResource>();
	
	private int width;
	private int height;

	public void setObjects(List<IPhysicalObject> objects) {
		this.objects = objects;
	}
	public List<IPhysicalObject> getObjects() {
		return objects;
	}
	
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	public List<City> getCities() {
		return cities;
	}
	public void addCity(City city) {
		cities.add(city);
	}
	
	public void setResourceLocations(List<WorldResourceLocation> resourceLocations) {
		this.resourceLocations = resourceLocations;
	}
	public List<WorldResourceLocation> getResourceLocations() {
		return resourceLocations;
	}
	public void addResourceLocation(WorldResourceLocation resourceLocation) {
		resourceLocations.add(resourceLocation);
	}
	
	public void setResourceTypes(List<WorldResource> resourceTypes) {
		this.resourceTypes = resourceTypes;
	}
	public List<WorldResource> getResourceTypes() {
		return resourceTypes;
	}
	public void addResourceType(WorldResource resource) {
		resourceTypes.add(resource);
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public int getHeight() {
		return height;
	}
	@Override
	public int getWidth() {
		return width;
	}
	@Override
	public int getX() {
		return 0;
	}
	@Override
	public int getY() {
		return 0;
	}
}