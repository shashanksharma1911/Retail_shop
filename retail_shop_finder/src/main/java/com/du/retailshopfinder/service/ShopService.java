/**
 * 
 */
package com.du.retailshopfinder.service;

import com.du.retailshopfinder.model.Shop;

/**
 * @author shashank
 *
 */
public interface ShopService {

	public boolean storeShopDetails(Shop shop);

	public Shop getNearestShopDetails(Double lat, Double lng);

}
