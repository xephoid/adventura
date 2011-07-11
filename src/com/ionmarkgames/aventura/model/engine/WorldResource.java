package com.ionmarkgames.aventura.model.engine;

import java.util.ArrayList;
import java.util.List;

public class WorldResource {
	
	public enum AquireType {
		AUTOMATIC(0f),
		ASSIGNABLE(0f),
		COLLECTABLE(2f),
		BUILDABLE(4f),
		TRADEABLE(10f);
		
		private float valueMultiplier;
		private AquireType(float multiplier) {
			this.valueMultiplier = multiplier;
		}
		
		public float getValueMultiplier() {
			return valueMultiplier;
		}
	}
	
	public enum SpendType {
		CONSUMABLE,
		ALLOCATABLE,
		NONE
	}
	
	private String name;
	private float value;
	private WorldResourceAquireAction aquireAction;
	private List<WorldResourceRequirement> requirements = new ArrayList<WorldResourceRequirement>();
	private AquireType aquireType;
	private SpendType spendType;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setValue(float value) {
		this.value = value;
	}
	public float getValue() {
		return value;
	}
	
	public void setRequirements(List<WorldResourceRequirement> requirements) {
		this.requirements = requirements;
	}
	public List<WorldResourceRequirement> getRequirements() {
		return requirements;
	}
	public void addRequirement(WorldResourceRequirement requirement) {
		if (requirement != null) {
			requirement.setDependant(this);
			requirements.add(requirement);
		}
	}
	
	public void setAquireAction(WorldResourceAquireAction aquireAction) {
		this.aquireAction = aquireAction;
	}
	public WorldResourceAquireAction getAquireAction() {
		return aquireAction;
	}
	
	public void setAquireType(AquireType aquireType) {
		this.aquireType = aquireType;
	}
	public AquireType getAquireType() {
		return aquireType;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		if (other instanceof WorldResource) {
			WorldResource wr = (WorldResource) other;
			return name.equals(wr.name) && aquireType.equals(wr.aquireType);
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + aquireType.hashCode();
	}
	public void setSpendType(SpendType spendType) {
		this.spendType = spendType;
	}
	public SpendType getSpendType() {
		return spendType;
	}
}
