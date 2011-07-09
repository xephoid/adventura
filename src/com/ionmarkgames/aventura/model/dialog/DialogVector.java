package com.ionmarkgames.aventura.model.dialog;

import java.util.ArrayList;
import java.util.List;

import com.ionmarkgames.aventura.model.IHasCriteria;
import com.ionmarkgames.aventura.model.IStorable;
import com.ionmarkgames.aventura.model.StoryCriteria;

public class DialogVector<ResourceClass> implements IHasCriteria, IStorable {

	private Long id;
	private DialogNode<ResourceClass> playerDialog;
	private DialogNode<ResourceClass> responseDialog;
	private List<StoryCriteria> criteria = new ArrayList<StoryCriteria>();
	
	public void setPlayerDialog(DialogNode<ResourceClass> playerDialog) {
		this.playerDialog = playerDialog;
	}
	public DialogNode<ResourceClass> getPlayerDialog() {
		return playerDialog;
	}
	
	public void setResponseDialog(DialogNode<ResourceClass> responseDialog) {
		this.responseDialog = responseDialog;
	}
	public DialogNode<ResourceClass> getResponseDialog() {
		return responseDialog;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	
	public void setCriteria(List<StoryCriteria> criteria) {
		this.criteria = criteria;
	}
	public List<StoryCriteria> getCriteria() {
		return criteria;
	}
	
	public Boolean isCriteriaMet() {
		if (criteria == null || criteria.isEmpty()) {
			return true;
		}
		
		for (StoryCriteria c : criteria) {
			if (!c.isCriteriaMet()) {
				return false;
			}
		}
		return true;
	}
}
