package com.ionmarkgames.aventura.model.engine;

import com.ionmarkgames.aventura.model.engine.physical.City;

public interface ICityAction {
	public boolean canDoAction(City city);
	public void doAction(City city);
	public boolean isDone();
}
