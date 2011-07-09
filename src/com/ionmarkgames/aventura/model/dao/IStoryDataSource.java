package com.ionmarkgames.aventura.model.dao;

import com.ionmarkgames.aventura.model.Affiliation;
import com.ionmarkgames.aventura.model.Artifact;
import com.ionmarkgames.aventura.model.Association;
import com.ionmarkgames.aventura.model.Character;
import com.ionmarkgames.aventura.model.Knowledge;
import com.ionmarkgames.aventura.model.Location;
import com.ionmarkgames.aventura.model.Objective;
import com.ionmarkgames.aventura.model.StoryCriteria;
import com.ionmarkgames.aventura.model.actions.BaseAction;

public interface IStoryDataSource {
	public IStorySubjectDAO<Character> getCharacterDAO();
	public IStorySubjectDAO<Affiliation> getAffiliationDAO();
	public IStorySubjectDAO<Knowledge> getKnowledgeDAO();
	public IStorySubjectDAO<Location> getLocationDAO();
	public IStorySubjectDAO<Artifact> getArtifactDAO();
	public IStorySubjectDAO<Objective> getObjectiveDAO();
	public IStorySubjectDAO<Association> getAssociationDAO();
	public IStorySubjectDAO<StoryCriteria> getCriteriaDAO();
	public IStorySubjectDAO<BaseAction> getActionDAO();
}
