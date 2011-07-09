package com.ionmarkgames.aventura.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Groups of characters.  Like races, families, teams etc...
 * 
 * @author xephoid
 *
 */
public class Affiliation extends BaseStorySubject {

	private List<Character> memebers = new ArrayList<Character>();
	private List<Knowledge> knowledge = new ArrayList<Knowledge>();

	public void setMemebers(List<Character> memebers) {
		this.memebers = memebers;
	}

	public List<Character> getMemebers() {
		return memebers;
	}
	
	public void addMember(Character member) {
		memebers.add(member);
	}

	public void setKnowledge(List<Knowledge> knowledge) {
		this.knowledge = knowledge;
	}

	public List<Knowledge> getKnowledge() {
		return knowledge;
	}
}
