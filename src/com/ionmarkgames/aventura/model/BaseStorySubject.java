package com.ionmarkgames.aventura.model;

import java.util.ArrayList;
import java.util.List;

import com.ionmarkgames.aventura.model.resources.IStoryResource;

/**
 * Base object for all Story objects.
 * 
 * @author xephoid
 *
 */
public abstract class BaseStorySubject implements IHasCriteria, IStorySubject, IStorable {

	private Long id;
	private Boolean isGlobal;
	private Boolean isOpen;
	private Realm realm;
	private IStoryResource<?> nameResource;
	private List<IStoryResource<?>> descriptionResources = new ArrayList<IStoryResource<?>>();
	private List<StoryCriteria> criteria = new ArrayList<StoryCriteria>();
	private List<Association> associations = new ArrayList<Association>();

	public void setNameResource(IStoryResource<?> nameResource) {
		this.nameResource = nameResource;
	}
	public IStoryResource<?> getNameResource() {
		return nameResource;
	}
	
	public void setDescriptionResources(List<IStoryResource<?>> descriptionResources) {
		this.descriptionResources = descriptionResources;
	}
	public List<IStoryResource<?>> getDescriptionResources() {
		return descriptionResources;
	}
	
	public void setRealm(Realm realm) {
		this.realm = realm;
	}
	public Realm getRealm() {
		return realm;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	public void setIsGlobal(Boolean isGlobal) {
		this.isGlobal = isGlobal;
	}
	public Boolean getIsGlobal() {
		return isGlobal;
	}
	
	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}
	public Boolean getIsOpen() {
		return isOpen;
	}
	
	public void setAssociations(List<Association> associations) {
		this.associations = associations;
	}
	public List<Association> getAssociations() {
		return associations;
	}
	public void addAssociation(Association association) {
		associations.add(association);
	}
	
	@Override
	public String toString() {
		return nameResource.toString();
	}
}
