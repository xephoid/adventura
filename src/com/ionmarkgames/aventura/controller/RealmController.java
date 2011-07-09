package com.ionmarkgames.aventura.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

import com.ionmarkgames.aventura.model.IStorySubject;
import com.ionmarkgames.aventura.model.Location;
import com.ionmarkgames.aventura.model.Realm;
import com.ionmarkgames.aventura.model.StoryDirection;
import com.ionmarkgames.aventura.util.RandomMapGenerator;

public class RealmController extends BaseController<Realm> {
	
	public void generateMap() {
		RandomMapGenerator generator = new RandomMapGenerator(getDataSource().getLocationDAO().getAll());
		Location[][] map = generator.generate();
	}
	
	public void createPaths() {
		List<IStorySubject> subjects = new ArrayList<IStorySubject>();
		subjects.addAll(getDataSource().getCharacterDAO().getAll());
		subjects.addAll(getDataSource().getArtifactDAO().getAll());
		subjects.addAll(getDataSource().getAffiliationDAO().getAll());
		
		Collections.shuffle(subjects);
		
	}
}
