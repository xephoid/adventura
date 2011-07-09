package com.ionmarkgames.aventura.model.dialog;

import java.util.ArrayList;
import java.util.List;

import com.ionmarkgames.aventura.model.IStorable;
import com.ionmarkgames.aventura.model.actions.BaseAction;
import com.ionmarkgames.aventura.model.resources.IStoryResource;

public class DialogNode<ResourceType> implements IStorable {

	private Long id;
	private IStoryResource<ResourceType> dialog;
	private List<DialogVector<ResourceType>> vectors = new ArrayList<DialogVector<ResourceType>>();
	private BaseAction action;
	
	public void setDialog(IStoryResource<ResourceType> dialog) {
		this.dialog = dialog;
	}
	public IStoryResource<ResourceType> getDialog() {
		return dialog;
	}

	public void setVectors(List<DialogVector<ResourceType>> vectors) {
		this.vectors = vectors;
	}
	public List<DialogVector<ResourceType>> getVectors() {
		return vectors;
	}
	
	public void addVector(DialogVector<ResourceType> vector) {
		vectors.add(vector);
	}
	
	public boolean isEnd() {
		return vectors.isEmpty();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setAction(BaseAction action) {
		this.action = action;
	}
	public BaseAction getAction() {
		return action;
	}
}