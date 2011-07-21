package com.ionmarkgames.aventura.stuff;

import java.util.HashMap;
import java.util.Map;

public class BagOfStuff {

	/* map of stuff to quantities. */
	private Map<BaseStuff, Float> bag = new HashMap<BaseStuff, Float>();

	public void setBag(Map<BaseStuff, Float> bag) {
		this.bag = bag;
	}

	public Map<BaseStuff, Float> getBag() {
		return bag;
	}
}
