package com.ionmarkgames.aventura.stuff;

import java.util.ArrayList;
import java.util.List;

import com.ionmarkgames.aventura.system.SystemStatRequirement;

public class BaseStuff {

	private String name;
	private float weight;
	private float value;
	private List<SystemStatRequirement> useRequirements = new ArrayList<SystemStatRequirement>();
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getWeight() {
		return weight;
	}
	
	public void setValue(float value) {
		this.value = value;
	}
	public float getValue() {
		return value;
	}
	public void setUseRequirements(List<SystemStatRequirement> useRequirements) {
		this.useRequirements = useRequirements;
	}
	public List<SystemStatRequirement> getUseRequirements() {
		return useRequirements;
	}
	
}
