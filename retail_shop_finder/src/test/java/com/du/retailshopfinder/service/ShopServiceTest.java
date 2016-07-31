/**
 * 
 */
package com.du.retailshopfinder.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.du.retailshopfinder.RetailShopFinderApplication;
import com.du.retailshopfinder.model.Shop;
import com.du.retailshopfinder.model.ShopAddress;

/**
 * @author shashank
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RetailShopFinderApplication.class)
@WebAppConfiguration
public class ShopServiceTest {
	
	@Autowired
	private ShopService shopService;
	
	private Shop shop;
	private ShopAddress shopAddress;
	
	@Before
	public void setup(){

	}
	
	@After
	public void tearDown(){
		
	}
	
	@Test
	public void testStoreShopDetails(){
		shop = new Shop();
		shopAddress = new ShopAddress();
		shopAddress.setPostCode(411057);
		shopAddress.setShopNumber("B50");
		shop.setShopAddress(shopAddress);
		shop.setShopName("B50_shop");
		shop.setShopLatitude(18.0);
		shop.setShopLongitude(73.0);
		
		boolean isStored = shopService.storeShopDetails(shop);
		Assert.assertTrue(isStored);
	}
	
	/*
	 *  This test case to test the negative scenario of API with wrong post code
	 */
	@Test
	public void testStoreShopDetailsNegative(){
		shop = new Shop();
		shopAddress = new ShopAddress();
		shopAddress.setPostCode(123456);//wrong post code
		shopAddress.setShopNumber("B50");
		shop.setShopAddress(shopAddress);
		shop.setShopName("B50_shop");
		shop.setShopLatitude(18.0);
		shop.setShopLongitude(73.0);
		
		boolean isStored = shopService.storeShopDetails(shop);
		Assert.assertFalse(isStored);
	}
	
	@Test
	public void testGetNearestShopDetails(){
		Double lat = 18.0;
		Double lng = 73.0;
		
		Shop shop1 = new Shop();
		ShopAddress shopAddress1 = new ShopAddress();
		shopAddress1.setPostCode(411057);
		shopAddress1.setShopNumber("B50");
		shop1.setShopAddress(shopAddress1);
		shop1.setShopName("B50_shop");
		shop1.setShopLatitude(18.0);
		shop1.setShopLongitude(73.0);
		
		Shop shop2 = new Shop();
		ShopAddress shopAddress2 = new ShopAddress();
		shopAddress2.setPostCode(452018);
		shopAddress2.setShopNumber("B51");
		shop2.setShopAddress(shopAddress2);
		shop2.setShopName("B51_shop");
		shop2.setShopLatitude(22.0);
		shop2.setShopLongitude(79.0);
		
		shopService.storeShopDetails(shop1);
		shopService.storeShopDetails(shop2);
		
		Shop shop = shopService.getNearestShopDetails(lat, lng);
		Assert.assertNotNull(shop);
	}

}
