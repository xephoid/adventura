package com.ionmarkgames.aventura.controller;

import java.util.HashMap;
import java.util.Map;

import com.ionmarkgames.aventura.model.dialog.DialogTree;
import com.ionmarkgames.aventura.model.dialog.DialogVector;
import com.ionmarkgames.aventura.model.event.StoryEvent;
import com.ionmarkgames.aventura.model.resources.IStoryResource;

public class DialogController<ResourceType> {
	
	private DialogTree<ResourceType> dialogTree; 

	public void setDialogTree(DialogTree<ResourceType> dialogTree) {
		this.dialogTree = dialogTree;
	}
	
	public IStoryResource<ResourceType> startConversation() {
		dialogTree.setCurrentNode(dialogTree.getRoot());
		return dialogTree.getCurrentNode().getDialog();
	}

	public Map<Long, IStoryResource<ResourceType>> getDialogOptions() {
		Map<Long, IStoryResource<ResourceType>> options = new HashMap<Long, IStoryResource<ResourceType>>();
		for (DialogVector<ResourceType> vector : dialogTree.getCurrentNode().getVectors()) {
			if (vector.isCriteriaMet()) {
				options.put(vector.getPlayerDialog().getId(), vector.getPlayerDialog().getDialog());
			}
		}
		return options;
	}
	
	public IStoryResource<ResourceType> chooseOption(Long id) {
		for (DialogVector<ResourceType> vector : dialogTree.getCurrentNode().getVectors()) {
			if (id.equals(vector.getPlayerDialog().getId())) {
				dialogTree.setCurrentNode(vector.getResponseDialog());
				StoryEvent action = vector.getResponseDialog().getAction();
				if (action != null) {
					// TODO: fire action
				}
				return vector.getResponseDialog().getDialog();
			}
		}
		// Conversation is over?
		return null;
	}
}