/**
 * 
 */
package com.du.retailshopfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.du.retailshopfinder.constants.ShopFinderConstants;
import com.du.retailshopfinder.model.Shop;
import com.du.retailshopfinder.service.ShopService;

/**
 * @author shashank
 *
 */

@RestController
@RequestMapping(value = "/shop", method = RequestMethod.GET)
public class ShopController {

	@Autowired
	private ShopService shopService;

	@RequestMapping(value = "/addShopInfo", method = RequestMethod.POST)
	public String addNewShopInfo(@RequestBody Shop shop) {

		if (shopService.storeShopDetails(shop))
			return ShopFinderConstants.SHOP_STORED_SUCCESS;
		else
			return ShopFinderConstants.SHOP_STORED_FAILED;
	}

	@RequestMapping(value = "/getNearestShopDetails", method = RequestMethod.GET)
	public Shop getNearestShopDetails(@RequestParam(value = "lat", required = true) Double lat,
			@RequestParam(value = "lng", required = true) Double lng) {

		return shopService.getNearestShopDetails(lat, lng);
	}

}
