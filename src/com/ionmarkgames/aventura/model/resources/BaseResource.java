package com.ionmarkgames.aventura.model.resources;

/**
 * Base type for any resources in the realm.
 * 
 * @author xephoid
 *
 * @param <ResourceClass>
 */
public abstract class BaseResource<ResourceClass> implements IStoryResource<ResourceClass> {

	protected ResourceClass resource;
	
	public BaseResource(ResourceClass resource) {
		this.resource = resource;
	}
	
	public BaseResource() {
	}
	
	public void setResource(ResourceClass resource) {
		this.resource = resource;
	}
	
	public ResourceClass getResource() {
		return resource;
	}
	
	public abstract Class<ResourceClass> getResourceType();
	
	public abstract Object getStorageFormat();
	
	public abstract void loadFromStorageFormat(Object obj);
}