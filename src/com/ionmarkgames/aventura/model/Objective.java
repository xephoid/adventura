package com.ionmarkgames.aventura.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A list of tasks the player must perform.
 * 
 * @author xephoid
 *
 */
public class Objective extends BaseStorySubject {
	private Boolean completed = false;
	private Character requestor;
	private List<StoryCriteria> tasks = new ArrayList<StoryCriteria>();
	private List<Knowledge> knowledge = new ArrayList<Knowledge>();

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setTasks(List<StoryCriteria> tasks) {
		this.tasks = tasks;
	}

	public List<StoryCriteria> getTasks() {
		return tasks;
	}
	
	public void addTask(StoryCriteria task) {
		tasks.add(task);
	}
	
	public Boolean tasksCompleted() {
		if (tasks == null || tasks.isEmpty()) {
			return true;
		}
		for (StoryCriteria c : tasks) {
			if (!c.isCriteriaMet()) {
				return false;
			}
		}
		return true;
	}

	public void setRequestor(Character requestor) {
		this.requestor = requestor;
	}

	public Character getRequestor() {
		return requestor;
	}

	public void setKnowledge(List<Knowledge> knowledge) {
		this.knowledge = knowledge;
	}

	public List<Knowledge> getKnowledge() {
		return knowledge;
	}
}
