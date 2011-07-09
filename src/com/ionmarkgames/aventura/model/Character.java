package com.ionmarkgames.aventura.model;

import java.util.ArrayList;
import java.util.List;

import com.ionmarkgames.aventura.model.dialog.DialogTree;

/**
 * NPCs in the realm.
 * 
 * @author xephoid
 *
 */
public class Character extends BaseStorySubject {

	private Location whereabouts;
	private List<Artifact> artifacts = new ArrayList<Artifact>();
	private List<Objective> requests = new ArrayList<Objective>();
	private List<Knowledge> knowledge = new ArrayList<Knowledge>();
	private DialogTree<?> baseDialog;

	public void setWhereabouts(Location whereabouts) {
		this.whereabouts = whereabouts;
	}

	public Location getWhereabouts() {
		return whereabouts;
	}

	public void setArtifacts(List<Artifact> artifacts) {
		this.artifacts = artifacts;
	}

	public List<Artifact> getArtifacts() {
		return artifacts;
	}

	public void setBaseDialog(DialogTree<?> baseDialog) {
		this.baseDialog = baseDialog;
	}

	public DialogTree<?> getBaseDialog() {
		return baseDialog;
	}

	public void setRequests(List<Objective> requests) {
		this.requests = requests;
	}

	public List<Objective> getRequests() {
		return requests;
	}

	public void setKnowledge(List<Knowledge> knowledge) {
		this.knowledge = knowledge;
	}

	public List<Knowledge> getKnowledge() {
		return knowledge;
	}
}
