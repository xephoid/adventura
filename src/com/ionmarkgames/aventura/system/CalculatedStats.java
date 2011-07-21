package com.ionmarkgames.aventura.system;

import java.util.Map;

public class CalculatedStats extends BaseSystemStat {

	private Map<String, BaseSystemStat> derivedStats;

	public void setDerivedStats(Map<String, BaseSystemStat> derivedStats) {
		this.derivedStats = derivedStats;
	}

	public Map<String, BaseSystemStat> getDerivedStats() {
		return derivedStats;
	}
}