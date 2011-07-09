package com.ionmarkgames.aventura.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Important items found in the realm.  They can be owned by a person or simply available.
 *  
 * @author xephoid
 *
 */
public class Artifact extends BaseStorySubject {

	private Character owner;
	private Location whereabouts;
	private Boolean playerHas;
	private List<Knowledge> knowledge = new ArrayList<Knowledge>();
	
	public void setOwner(Character owner) {
		this.owner = owner;
	}
	public Character getOwner() {
		return owner;
	}
	
	public void setWhereabouts(Location whereabouts) {
		this.whereabouts = whereabouts;
	}
	public Location getWhereabouts() {
		return whereabouts;
	}
	
	public void setPlayerHas(Boolean playerHas) {
		this.playerHas = playerHas;
	}
	public Boolean getPlayerHas() {
		return playerHas;
	}
	public void setKnowledge(List<Knowledge> knowledge) {
		this.knowledge = knowledge;
	}
	public List<Knowledge> getKnowledge() {
		return knowledge;
	}
}
