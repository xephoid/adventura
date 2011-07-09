package com.ionmarkgames.aventura.model.resources;

public interface IStoryResource<ResourceClass> {

	public ResourceClass getResource();
	
	public Object getStorageFormat();
	
	public void loadFromStorageFormat(Object obj);
	
	public Class<ResourceClass> getResourceType();
}
