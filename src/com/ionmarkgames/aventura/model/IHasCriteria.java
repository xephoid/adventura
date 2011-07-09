package com.ionmarkgames.aventura.model;

import java.util.List;

public interface IHasCriteria {
	public List<StoryCriteria> getCriteria();
	public Boolean isCriteriaMet();
}
