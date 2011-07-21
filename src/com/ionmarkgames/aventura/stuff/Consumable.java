package com.ionmarkgames.aventura.stuff;

import com.ionmarkgames.aventura.system.BaseSystemStat;

public class Consumable extends BaseStuff {

	private BaseSystemStat effectedStat;
	private float amount;
	private boolean used = false;
	
	public void setEffectedStat(BaseSystemStat effectedStat) {
		this.effectedStat = effectedStat;
	}
	public BaseSystemStat getEffectedStat() {
		return effectedStat;
	}
	
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getAmount() {
		return amount;
	}
	public void setUsed(boolean used) {
		this.used = used;
	}
	public boolean isUsed() {
		return used;
	}
}
