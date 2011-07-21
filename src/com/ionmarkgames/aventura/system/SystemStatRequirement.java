package com.ionmarkgames.aventura.system;

public class SystemStatRequirement {

	private BaseSystemStat stat;
	private float value;
	
	public void setStat(BaseSystemStat stat) {
		this.stat = stat;
	}
	public BaseSystemStat getStat() {
		return stat;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public float getValue() {
		return value;
	}
}
