package com.ionmarkgames.aventura.model;

import java.util.ArrayList;
import java.util.List;

public class Association extends BaseStorySubject {

	private BaseStorySubject primarySubject;
	private BaseStorySubject secondarySubject;
	private List<Knowledge> knowledge = new ArrayList<Knowledge>();

	public void setPrimarySubject(BaseStorySubject primarySubject) {
		this.primarySubject = primarySubject;
	}
	public BaseStorySubject getPrimarySubject() {
		return primarySubject;
	}

	public void setSecondarySubject(BaseStorySubject secondarySubject) {
		this.secondarySubject = secondarySubject;
	}
	public BaseStorySubject getSecondarySubject() {
		return secondarySubject;
	}
	
	public BaseStorySubject getOppositeSubject(BaseStorySubject subject) {
		if (primarySubject.getId().equals(subject.getId())) {
			return secondarySubject;
		}
		if (secondarySubject.getId().equals(subject.getId())) {
			return primarySubject;
		}
		return null;
	}
	public void setKnowledge(List<Knowledge> knowledge) {
		this.knowledge = knowledge;
	}
	public List<Knowledge> getKnowledge() {
		return knowledge;
	}
}
