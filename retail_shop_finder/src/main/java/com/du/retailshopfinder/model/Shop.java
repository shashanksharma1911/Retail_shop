/**
 * 
 */
package com.du.retailshopfinder.model;

/**
 * @author shashank
 *
 */
public class Shop {

	private String shopName;

	private ShopAddress shopAddress;

	private Double shopLongitude;

	private Double shopLatitude;

	/**
	 * @return the shopName
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * @param shopName
	 *            the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * @return the shopAddress
	 */
	public ShopAddress getShopAddress() {
		return shopAddress;
	}

	/**
	 * @param shopAddress
	 *            the shopAddress to set
	 */
	public void setShopAddress(ShopAddress shopAddress) {
		this.shopAddress = shopAddress;
	}

	/**
	 * @return the shopLongitude
	 */
	public Double getShopLongitude() {
		return shopLongitude;
	}

	/**
	 * @param shopLongitude
	 *            the shopLongitude to set
	 */
	public void setShopLongitude(Double shopLongitude) {
		this.shopLongitude = shopLongitude;
	}

	/**
	 * @return the shopLatitude
	 */
	public Double getShopLatitude() {
		return shopLatitude;
	}

	/**
	 * @param shopLatitude
	 *            the shopLatitude to set
	 */
	public void setShopLatitude(Double shopLatitude) {
		this.shopLatitude = shopLatitude;
	}

}
