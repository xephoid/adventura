package com.ionmarkgames.aventura.model.dialog;

import com.ionmarkgames.aventura.model.IStorable;

public class DialogTree<ResourceType> implements IStorable {

	private Long id;
	private DialogNode<ResourceType> root;
	private DialogNode<ResourceType> currentNode;
	
	public void setRoot(DialogNode<ResourceType> root) {
		this.root = root;
	}
	public DialogNode<ResourceType> getRoot() {
		return root;
	}

	public void setCurrentNode(DialogNode<ResourceType> currentNode) {
		this.currentNode = currentNode;
	}
	public DialogNode<ResourceType> getCurrentNode() {
		return currentNode;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
