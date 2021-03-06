package com.net.rmopenmenu;

public class Item implements Comparable<Item> {
	int item_id;
	String restaurant_name;
	int restaurant_lat;
	int restaurant_lon;
	String restaurant_distance;
	String item_name;
	String item_price;
	String item_description;
	int item_veg;
	
	private boolean sortPrice;
	
	public Item(int item_id, String restaurant_name, int restaurant_lat, int restaurant_lon, String restaurant_distance, String item_name, String item_price, String item_description, int item_veg, boolean sortPrice) {
		this.item_id = item_id;
		this.restaurant_name = restaurant_name;
		this.restaurant_lat = restaurant_lat;
		this.restaurant_lon = restaurant_lon;
		this.restaurant_distance = restaurant_distance;
		this.item_name = item_name;
		this.item_price = item_price;
		this.item_description = item_description;
		this.item_veg = item_veg;
		
		this.sortPrice = sortPrice;
	}

	@Override
	public int compareTo(Item other) {
		if (sortPrice) {
			if (this.item_price.equals("Unknown Price") || other.item_price.equals("Unknown Price")) {
				return this.item_price.compareTo(other.item_price);
			} else {
				double compare = (Double.valueOf(this.item_price) - Double.valueOf(other.item_price));
				if (compare < 0) {
					return -1;
				} else if (compare > 0) {
					return 1;
				} else {
					return 0;
				}
			}
		} else {
			double val = (Double.valueOf(this.restaurant_distance) - Double.valueOf(other.restaurant_distance));
			if (val < 0) {
				return -1;
			} else if (val > 0) {
				return 1;
			} else {
				return 0;
			}
		}
	}
}
