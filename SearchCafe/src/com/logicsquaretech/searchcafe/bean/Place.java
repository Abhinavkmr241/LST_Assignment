package com.logicsquaretech.searchcafe.bean;

public class Place {

	public String id;
	public String street_no;
	public String locality;
	public int postal_code;
	public String latitude;
	public String longitude;

	public Place(String id, String street_no, String locality, int postal_code, String latitude, String longitude) {
		this.id = id;
		this.street_no = street_no;
		this.locality = locality;
		this.postal_code = postal_code;
		this.latitude = latitude;
		this.longitude = longitude;
	}

}
