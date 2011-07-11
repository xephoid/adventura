package com.ionmarkgames.aventura.model.engine.cityactions;

import com.ionmarkgames.aventura.model.engine.ICityAction;
import com.ionmarkgames.aventura.model.engine.WorldResourceAquireAction;
import com.ionmarkgames.aventura.model.engine.physical.City;

public class CityActionFactory {
	
	public static ICityAction getCityAction(WorldResourceAquireAction aquireAction, City city) {
		BaseCityAction result = null;
		try {
			result = aquireAction.getActionClass().newInstance();
			result.setCity(city);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
