package com.ionmarkgames.aventura.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gwt.dev.util.collect.HashMap;
import com.ionmarkgames.aventura.model.engine.WorldMap;
import com.ionmarkgames.aventura.model.engine.WorldResource;
import com.ionmarkgames.aventura.model.engine.physical.City;
import com.ionmarkgames.aventura.model.engine.physical.IPhysicalObject;
import com.ionmarkgames.aventura.model.engine.physical.ResourceAcquirer;
import com.ionmarkgames.aventura.model.engine.physical.WorldResourceLocation;
import com.ionmarkgames.aventura.model.engine.physical.City.Temperment;

public class WorldController {

	private static final int DEFAULT_CITY_SIZE = 4;
	private static final int WORLD_RESOURCE_PERCENTAGE = 30;
	private static final int FURTHEST_RESOURCE_DISTANCE = 20;
	private static final float MAX_RESOURCE_CACHE = Float.MAX_VALUE;
	
	private WorldMap world = new WorldMap();
	
	public void generateWorld() {
		// TODO: set up resources
		
		world.setWidth(500);
		world.setHeight(500);
		
		for(int i = 0; i < 10; i++) {
			world.addCity(createRandomCity());
		}
		
		float percentage = WORLD_RESOURCE_PERCENTAGE / 100;
		float maxResources = ((world.getWidth() * world.getHeight()) / 4) * percentage;
		int resourceCount = world.getResourceTypes().size();
		for (WorldResource r : world.getResourceTypes()) {
			if (WorldResource.AquireType.COLLECTABLE.equals(r.getAquireType())) {
				for (int i = 0; i < maxResources / resourceCount ; i++) {
					world.addResourceLocation(createRandomResourceLocation(r));
				}
			}
		}
	}
	
	public void calculateEconomy() {
		Map<String, Float> aquiredResources = new HashMap<String, Float>();
		float grossTotalIncome = 0f;
		
		for (City city : world.getCities()) {
			for (WorldResource r : world.getResourceTypes()) {
				if (!aquiredResources.containsKey(r.getName())) { 
					aquiredResources.put(r.getName(), 0f);
				}
				Float grossResourceIncome = city.getGrossResourceIncome(r);
				aquiredResources.put(r.getName(), aquiredResources.get(r) + grossResourceIncome);
				grossTotalIncome += grossResourceIncome;
			}
		}
		
		for (WorldResource r : world.getResourceTypes()) {
			r.setValue((aquiredResources.get(r.getName()) / grossTotalIncome) * r.getAquireType().getValueMultiplier());
		}
		
		for (City city : world.getCities()) {
			float cityValue = 0f;
			for (WorldResource r : world.getResourceTypes()) {
				cityValue += (r.getValue() * city.getResourceCount(r));
			}
			city.setValue(cityValue);
		}
	}
	
	private boolean overlapAnything(Area area) {
		for (IPhysicalObject obj : world.getObjects()) {
			if (area.overlap(new Area(obj.getX(), obj.getY(), obj.getWidth(), obj.getHeight()))) {
				return true;
			}
		}
		return false;
	}
	
	public WorldResourceLocation getClosestResourceLocation(WorldResource resourceType, IPhysicalObject obj) {
		int closest = FURTHEST_RESOURCE_DISTANCE;
		WorldResourceLocation result = null;
		for (WorldResourceLocation l : world.getResourceLocations()) {
			if (l.getResourceType().equals(resourceType)) {
				double part1 = Math.pow(( obj.getX() - l.getX() ), 2);
				double part2 = Math.pow(( obj.getX() - l.getY() ), 2);
				double underRadical = part1 + part2;
				int distance = (int) Math.sqrt(underRadical);
				if (distance < closest) {
					result = l;
					closest = distance;
				}
			}
		}
		return result;
	}
	
	public WorldResource getMostValueableResource() {
		float valueable = 0f;
		WorldResource mostValueable = null;
		
		for (WorldResource r :  world.getResourceTypes()) {
			if (r.getValue() > valueable) {
				mostValueable = r;
				valueable = r.getValue();
			}
		}
		return mostValueable;
	}
	
	private City createRandomCity() {
		City city = new City();
		int x = 0;
		int y = 0;
		do {
			x = (int) (Math.random() * world.getWidth());
			y = (int) (Math.random() * world.getHeight());
		} while (overlapAnything(new Area(x, y, DEFAULT_CITY_SIZE, DEFAULT_CITY_SIZE)));
		city.setX(x);
		city.setY(y);
		
		city.setSize(DEFAULT_CITY_SIZE);
		
		Map<WorldResource, Float> cityResourceMap = new HashMap<WorldResource, Float>();
		Map<WorldResource, Float> cityResourceGrowthMap = new HashMap<WorldResource, Float>();
		Map<WorldResource, Float> cityResourceGrossIncomeMap = new HashMap<WorldResource, Float>();
		Map<WorldResource, List<ResourceAcquirer>> cityAquirers = new HashMap<WorldResource, List<ResourceAcquirer>>();
		for (WorldResource r : world.getResourceTypes()) {
			cityResourceMap.put(r, 0f);
			cityResourceGrowthMap.put(r, 0f);
			cityResourceGrossIncomeMap.put(r, 0f);
			cityAquirers.put(r, new ArrayList<ResourceAcquirer>());
			if (WorldResource.AquireType.COLLECTABLE.equals(r.getAquireType())) {
				city.addResourceCollectionLocation(getClosestResourceLocation(r, city));
			}
		}
		city.setResources(cityResourceMap);
		city.setResourceGrowthRates(cityResourceGrowthMap);
		city.setGrossResourceIncome(cityResourceGrossIncomeMap);
		city.setTemperment(Temperment.PASSIVE); // TODO: generate random temperament
		city.setResourceAquirers(cityAquirers);
		
		return city;
	}
	
	private WorldResourceLocation createRandomResourceLocation(WorldResource resource) {
		WorldResourceLocation location = new WorldResourceLocation();
		int x = 0;
		int y = 0;
		do {
			x = (int) (Math.random() * world.getWidth());
			y = (int) (Math.random() * world.getHeight());
		} while (overlapAnything(new Area(x, y, 2, 2)));
		
		location.setX(x);
		location.setY(y);
		
		location.setResourceType(resource);
		location.setQuantity(MAX_RESOURCE_CACHE);
		
		return location;
	}
	
	class Area {
		public int x;
		public int y;
		public int width;
		public int height;
		
		public Area(int x, int y, int width, int height) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}
		
		public boolean overlap(Area other) {
			if (overlap(other.x, other.y) 
					|| overlap(other.x + other.width, other.y + other.height)
					|| overlap(other.x + other.width, other.y)
					|| overlap(other.x, other.y + other.height)) {
				return true;
			}
			return false;
		}
		
		public boolean overlap(int x, int y) {
			if (x >= this.x && x < this.x + this.width
					&& y >= this.y && y < this.y + this.height) {
				return true;
			}
			return false;
		}
	}
	
}
