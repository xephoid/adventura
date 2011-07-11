package com.ionmarkgames.aventura.model.engine;

public interface ICityAction {
	public boolean canDoAction();
	public void doAction();
	public boolean isDone();
}