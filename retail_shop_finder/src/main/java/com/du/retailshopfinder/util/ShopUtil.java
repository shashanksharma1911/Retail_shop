package com.du.retailshopfinder.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ShopUtil {

	/*
	 * This method will return map of latitude and longitude on the basis of
	 * post code.
	 */
	public static Map<String, Double> getLattitudeLongitude(int postCode) {
		Map<String, Double> lattitudeLongitude = null;
		String url = "http://maps.googleapis.com/maps/api/geocode/json?components=postal_code:" + postCode;
		ObjectMapper objectMapper = new ObjectMapper();
		try {

			JsonNode node = objectMapper.readValue(new BufferedReader(new InputStreamReader(new URL(url).openStream())),
					JsonNode.class);
			JsonNode resultNode = node.get("results");
			if (resultNode.size() != 0) {
				JsonNode addressComponentNode = resultNode.get(0);
				JsonNode geometryNode = addressComponentNode.get("geometry");
				JsonNode locationNode = geometryNode.get("location");
				lattitudeLongitude = new HashMap<String, Double>();
				JsonNode latNode = locationNode.get("lat");
				lattitudeLongitude.put("lati", Double.parseDouble(latNode.asText()));
				JsonNode lngNode = locationNode.get("lng");
				lattitudeLongitude.put("longi", Double.parseDouble(lngNode.asText()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lattitudeLongitude;
	}

	/*
	 * This method will return the distance between two latitude and longitude.
	 */

	public static double distance(double lat1, double lon1, double lat2, double lon2) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515 * 1.609344;
		return (dist);
	}

	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
}
