package com.ionmarkgames.aventura.util;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import com.ionmarkgames.aventura.model.Location;
import com.ionmarkgames.aventura.model.StoryDirection;

public class RandomMapGenerator {
	private Location startingLocation;
	private Location[][] map;
	private List<Location> places = new ArrayList<Location>();
	
	public RandomMapGenerator(List<Location> places) {
		this.places.addAll(places);
		map = new Location[places.size()][places.size()];
	}
	
	public Location[][] generate() {
		int x = (int) (Math.random() * map.length);
		int y = (int) (Math.random() * map.length);
		
		step(x, y);
		
		return map;
	}
	
	private void step(int x, int y) {
		if (places.size() < 1) {
			return;
		}
		Location l = places.remove(0);
		
		if (startingLocation == null) {
			startingLocation = l;
		}
		
		map[x][y] = l;
		int newX = x;
		int newY = y;
		
		EnumSet<StoryDirection> enumSet = EnumSet.of(StoryDirection.N, StoryDirection.S, StoryDirection.E, StoryDirection.W);
		List<StoryDirection> dirs = new ArrayList<StoryDirection>();
		dirs.addAll(enumSet);
		java.util.Collections.shuffle(dirs);
		
		for (StoryDirection dir : dirs) {
			switch(dir) {
				case N:
					newY = y - 1;
				break;
				case S:
					newY = y + 1;
				break;
				case E:
					newX = x + 1;
				break;
				case W:
					newX = x - 1;
				break;
				case NE:
					newX = x + 1;
					newY = y - 1;
				break;
				case NW:
					newX = x - 1;
					newY = y - 1;
				break;
				case SW:
					newX = x - 1;
					newY = y + 1;
				break;
				case SE:
					newX = x + 1;
					newY = y + 1;
				break;
			}
			if (available(newX, newY)) {
				step(newX, newY);
			}
		}
	}
	
	private boolean available(int x, int y) {
		if (x < 0 || x >= map.length || y < 0 || y >= map.length) {
			return false;
		}
		return map[x][y] == null;
	}
	
	public Location getStartingLocation() {
		return startingLocation;
	}
}
