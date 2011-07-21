package com.ionmarkgames.aventura.stuff;

public class Weapon extends Equipment {

	public enum WeaponType {
		RANGED,
		MELEE
	}
	
	private WeaponType weaponType;
	
	@Override
	public EquipmentType getType() {
		return EquipmentType.HAND;
	}

	public void setWeaponType(WeaponType weaponType) {
		this.weaponType = weaponType;
	}
	public WeaponType getWeaponType() {
		return weaponType;
	}
}
