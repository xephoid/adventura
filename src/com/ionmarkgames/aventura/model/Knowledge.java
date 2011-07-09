package com.ionmarkgames.aventura.model;

import com.ionmarkgames.aventura.model.dialog.DialogTree;

/**
 * Important information about anything in the realm.
 * 
 * @author xephoid
 *
 */
public class Knowledge extends BaseStorySubject {
	
	private BaseStorySubject subject;
	private DialogTree<?> dialogTree;

	public void setSubject(BaseStorySubject subject) {
		this.subject = subject;
	}

	public BaseStorySubject getSubject() {
		return subject;
	}

	public void setDialogTree(DialogTree<?> dialogTree) {
		this.dialogTree = dialogTree;
	}

	public DialogTree<?> getDialogTree() {
		return dialogTree;
	}
}
