package com.ionmarkgames.aventura.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A location in the realm.
 * 
 * @author xephoid
 *
 */
public class Location extends BaseStorySubject {

	private Boolean populated = true;
	private List<Character> inhabitants = new ArrayList<Character>();
	private List<Artifact> artifacts = new ArrayList<Artifact>();
	private List<Knowledge> knowledge = new ArrayList<Knowledge>();

	public void setInhabitants(List<Character> inhabitants) {
		this.inhabitants = inhabitants;
	}

	public List<Character> getInhabitants() {
		return inhabitants;
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

	public void setPopulated(Boolean populated) {
		this.populated = populated;
	}

	public Boolean isPopulated() {
		return populated;
	}
}
