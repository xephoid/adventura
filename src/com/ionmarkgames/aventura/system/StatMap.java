package com.ionmarkgames.aventura.system;

import java.util.Map;

public class StatMap {

	private Map<BaseSystemStat, Float> stats;

	public void setStats(Map<BaseSystemStat, Float> stats) {
		this.stats = stats;
	}
	public Map<BaseSystemStat, Float> getStats() {
		return stats;
	}
}