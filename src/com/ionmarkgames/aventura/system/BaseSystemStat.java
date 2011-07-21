package com.ionmarkgames.aventura.system;

public class BaseSystemStat {

	private String name;
	private String shortName;
	private String description;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getShortName() {
		return shortName;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other != null && other instanceof BaseSystemStat) {
			BaseSystemStat stat = (BaseSystemStat) other;
			return shortName.equals(stat.getShortName());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + shortName.hashCode();
	}
}