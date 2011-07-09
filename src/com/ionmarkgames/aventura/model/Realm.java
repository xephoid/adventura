package com.ionmarkgames.aventura.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Top level object for a world.  Defines the rules of the world and how the player can
 * interact with the world.
 *  
 * @author xephoid
 *
 */
public class Realm extends BaseStorySubject {
	private List<Character> characters = new ArrayList<Character>();
	private List<Location> locations = new ArrayList<Location>();
	private List<Artifact> artifacts = new ArrayList<Artifact>();
	private List<Knowledge> knowledge = new ArrayList<Knowledge>();
	private List<Affiliation> affialiations = new ArrayList<Affiliation>();
	
	@Override
	public Realm getRealm() {
		return null;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}

	public List<Character> getCharacters() {
		return characters;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setArtifacts(List<Artifact> artifacts) {
		this.artifacts = artifacts;
	}

	public List<Artifact> getArtifacts() {
		return artifacts;
	}

	public void setKnowledge(List<Knowledge> knowledge) {
		this.knowledge = knowledge;
	}

	public List<Knowledge> getKnowledge() {
		return knowledge;
	}

	public void setAffialiations(List<Affiliation> affialiations) {
		this.affialiations = affialiations;
	}

	public List<Affiliation> getAffialiations() {
		return affialiations;
	}
}