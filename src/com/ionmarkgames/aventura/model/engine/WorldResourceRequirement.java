package com.ionmarkgames.aventura.model.engine;

public class WorldResourceRequirement {

	private WorldResource dependant;
	private WorldResource required;
	private float requiredAmount;
	
	public void setDependant(WorldResource dependant) {
		this.dependant = dependant;
	}
	public WorldResource getDependant() {
		return dependant;
	}
	
	public void setRequired(WorldResource required) {
		this.required = required;
	}
	public WorldResource getRequired() {
		return required;
	}
	
	public void setRequiredAmount(float requiredAmount) {
		this.requiredAmount = requiredAmount;
	}
	public float getRequiredAmount() {
		return requiredAmount;
	}
}
