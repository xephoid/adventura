package com.ionmarkgames.aventura.model.engine;

import java.util.List;

import com.ionmarkgames.aventura.model.engine.physical.WorldResourceLocation;

public interface IResourceCollector {
	public List<WorldResourceLocation> getResourceCollectionLocations();
}
