package com.ionmarkgames.aventura.stuff;

import java.util.HashMap;
import java.util.Map;

import com.ionmarkgames.aventura.system.BaseSystemStat;

public abstract class Equipment extends BaseStuff {
	
	public enum EquipmentType {
		HEAD,
		HAND,
		FEET,
		BODY
	}
	
	private Map<BaseSystemStat, Float> equipStats = new HashMap<BaseSystemStat, Float>();
	private EquipmentType type;

	public void setEquipStats(Map<BaseSystemStat, Float> equipStats) {
		this.equipStats = equipStats;
	}
	public Map<BaseSystemStat, Float> getEquipStats() {
		return equipStats;
	}

	public void setType(EquipmentType type) {
		this.type = type;
	}
	public EquipmentType getType() {
		return type;
	}
}
