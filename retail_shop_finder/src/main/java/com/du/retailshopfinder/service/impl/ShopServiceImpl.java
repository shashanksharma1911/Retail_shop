/**
 * 
 */
package com.du.retailshopfinder.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.du.retailshopfinder.model.Shop;
import com.du.retailshopfinder.util.ShopUtil;

/**
 * @author shashank
 *
 */
@Service
public class ShopServiceImpl implements com.du.retailshopfinder.service.ShopService {

	private List<Shop> shopStore = new ArrayList<Shop>();

	/*
	 * This method adds shop details to the array list
	 */
	@Override
	public boolean storeShopDetails(Shop shop) {
		Map<String, Double> latitudeLongitide = null;
		boolean isStored = false;
		// This will return map of latitude and longitude according to post code
		latitudeLongitide = ShopUtil.getLattitudeLongitude(shop.getShopAddress().getPostCode());
		if (null != latitudeLongitide) {
			shop.setShopLatitude(latitudeLongitide.get("lati"));
			shop.setShopLongitude(latitudeLongitide.get("longi"));
			shopStore.add(shop);
			isStored = true;
		}
		return isStored;
	}

	/*
	 * This method returns nearest shop from the given latitude and longitude.
	 */

	@Override
	public Shop getNearestShopDetails(Double lat, Double lng) {
		Double shortestDistance = null;
		Shop nearestShop = null;
		Double currentDistance = null;
		// This logic will iterate the shop store and check for nearest shop
		// from given latitude and longitude.
		for (int index = 0; index < shopStore.size(); index++) {
			currentDistance = ShopUtil.distance(lat, lng, shopStore.get(index).getShopLatitude(),
					shopStore.get(index).getShopLongitude());
			if (null == shortestDistance) {
				shortestDistance = currentDistance;
				nearestShop = shopStore.get(index);
			} else if (currentDistance < shortestDistance) {
				shortestDistance = currentDistance;
				nearestShop = shopStore.get(index);
			}
		}
		return nearestShop;
	}

}
