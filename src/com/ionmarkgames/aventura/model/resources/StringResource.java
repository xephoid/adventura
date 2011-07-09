package com.ionmarkgames.aventura.model.resources;

public class StringResource extends BaseResource<String> {

	@Override
	public Object getStorageFormat() {
		return resource;
	}

	@Override
	public void loadFromStorageFormat(Object obj) {
		resource = obj.toString();
	}

	@Override
	public Class<String> getResourceType() {
		return String.class;
	}
	
	@Override
	public String toString() {
		return resource;
	}
}