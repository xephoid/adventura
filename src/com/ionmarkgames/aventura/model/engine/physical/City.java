package com.ionmarkgames.aventura.model.engine.physical;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gwt.dev.util.collect.HashMap;
import com.ionmarkgames.aventura.model.Location;
import com.ionmarkgames.aventura.model.engine.ICityAction;
import com.ionmarkgames.aventura.model.engine.IResourceCollector;
import com.ionmarkgames.aventura.model.engine.WorldResource;

public class City extends Location implements IPhysicalObject, IResourceCollector {
	
	public enum Temperment {
		AGGRESSIVE,
		PASSIVE,
		DEMOCRATIC
	}

	/* Map of resource names to quantities. */
	private Map<WorldResource, Float> resources = new HashMap<WorldResource, Float>();
	private Map<WorldResource, Float> resourceGrowthRates = new HashMap<WorldResource, Float>();
	private Map<WorldResource, Float> grossResourceIncome = new HashMap<WorldResource, Float>();
	private Map<WorldResource, Float> attributedResources = new HashMap<WorldResource, Float>();
	private Map<WorldResource, List<ResourceAcquirer>> resourceAquirers = new HashMap<WorldResource, List<ResourceAcquirer>>();
	private List<WorldResourceLocation> resourceCollectionLocations = new ArrayList<WorldResourceLocation>();
	private List<City> neighbors = new ArrayList<City>();
	private List<WorldResource> neededResources = new ArrayList<WorldResource>();
	
	private float value = 0f;
	private int size;
	private Temperment temperment;
	private float defense;
	private ICityAction currentAction;
	
	private int x;
	private int y;
	
	public void setResources(Map<WorldResource, Float> resources) {
		this.resources = resources;
	}
	public Map<WorldResource, Float> getResources() {
		return resources;
	}
	public Float getResourceCount(WorldResource name) {
		if (resources.containsKey(name)) {
			return resources.get(name);
		}
		return 0f;
	}
	
	public void setResourceGrowthRates(Map<WorldResource, Float> resourceGrowthRates) {
		this.resourceGrowthRates = resourceGrowthRates;
	}
	public Map<WorldResource, Float> getResourceGrowthRates() {
		return resourceGrowthRates;
	}
	public Float getResourceGrowthRate(WorldResource name) {
		if (resourceGrowthRates.containsKey(name)) {
			return resourceGrowthRates.get(name);
		}
		return 0f;
	}
	
	public void setNeightbors(List<City> neightbors) {
		this.neighbors = neightbors;
	}
	public List<City> getNeightbors() {
		return neighbors;
	}
	public void addNeighbor(City neighbor) {
		neighbors.add(neighbor);
	}
	
	public void setValue(float value) {
		this.value = value;
	}
	public float getValue() {
		return value;
	}
	
	public void setTemperment(Temperment temperment) {
		this.temperment = temperment;
	}
	public Temperment getTemperment() {
		return temperment;
	}
	
	public void setDefense(float defense) {
		this.defense = defense;
	}
	public float getDefense() {
		return defense;
	}
	
	public void setCurrentAction(ICityAction currentAction) {
		this.currentAction = currentAction;
	}
	public ICityAction getCurrentAction() {
		return currentAction;
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

	public void setSize(int size) {
		this.size = size;
	}
	public int getWidth() {
		return size;
	}
	public int getHeight() {
		return size;
	}
	
	public void setResourceCollectionLocations(
			List<WorldResourceLocation> resourceCollectionLocations) {
		this.resourceCollectionLocations = resourceCollectionLocations;
	}
	public List<WorldResourceLocation> getResourceCollectionLocations() {
		return resourceCollectionLocations;
	}
	public void addResourceCollectionLocation(
			WorldResourceLocation resourceCollectionLocation) {
		resourceCollectionLocation.addCollector(this);
		this.resourceCollectionLocations.add(resourceCollectionLocation);
	}
	
	public void setResourceAquirers(Map<WorldResource, List<ResourceAcquirer>> resourceAquirers) {
		this.resourceAquirers = resourceAquirers;
	}
	public Map<WorldResource, List<ResourceAcquirer>> getResourceAquirers() {
		return resourceAquirers;
	}
	public void addResourceAqcuierer(ResourceAcquirer aqcuirer) {
		resourceAquirers.get(aqcuirer.getResourceType().getName()).add(aqcuirer);
	}
	
	public void setGrossResourceIncome(Map<WorldResource, Float> grossResourceIncome) {
		this.grossResourceIncome = grossResourceIncome;
	}
	public Map<WorldResource, Float> getGrossResourceIncome() {
		return grossResourceIncome;
	}
	public Float getGrossResourceIncome(WorldResource name) {
		return grossResourceIncome.get(name);
	}
	
	public void setNeededResources(List<WorldResource> neededResources) {
		this.neededResources = neededResources;
	}
	public List<WorldResource> getNeededResources() {
		return neededResources;
	}
	
	public void setAttributedResources(Map<WorldResource, Float> attributedResources) {
		this.attributedResources = attributedResources;
	}
	public Map<WorldResource, Float> getAttributedResources() {
		return attributedResources;
	}
	public Float getAttributedResourceCount(WorldResource key) {
		return this.attributedResources.get(key);
	}
}