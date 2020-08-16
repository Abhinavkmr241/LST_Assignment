package com.logicsquaretech.searchcafe.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.logicsquaretech.searchcafe.bean.Cafe;
import com.logicsquaretech.searchcafe.bean.Place;

public class Controller {

	static final List<Cafe> CAFES = new ArrayList<Cafe>();
	static final List<Place> PLACES = new ArrayList<Place>();

	static {
		CAFES.add(new Cafe("Bazaar Cafe", "kjk234g4gcvfx8usg1l33pi"));
		CAFES.add(new Cafe("Ashley's Cafe", "12hydbdf76sljfts87sbfis"));
		CAFES.add(new Cafe("Avenue Cafe", "skjd86svvfdrsv55svbvf3f"));
		CAFES.add(new Cafe("Hi-Lo Cafe", "mjdhgetr4pojfyts22fzfsh"));
		CAFES.add(new Cafe("California Chicken Cafe", "12hydbdf76sljfts87sbfis"));
		CAFES.add(new Cafe("Avenue Bakery Cafe", "jahgde7wgdiau8ewsahgosd"));
		CAFES.add(new Cafe("Philz Coffee", "urhw3837ehalod7w02b7835"));

		PLACES.add(
				new Place("jahgde7wgdiau8ewsahgosd", "60H", "Solomos Island Road", 20688, "36.7783 N", "119.4179 W"));
		PLACES.add(new Place("12hydbdf76sljfts87sbfis", "1B", "Macarthur Blvd", 20619, "38.1781 N", "118.4171 W"));
		PLACES.add(new Place("kjk234g4gcvfx8usg1l33pi", "45250", "Worth Avenue, Unit A", 20619, "36.1152", "117.521"));
		PLACES.add(new Place("saswe3s6yydtdr52hsd72yst", "1X", "Macarthur Blvd", 20687, "36.7783", "119.4179"));
		PLACES.add(new Place("skjd86svvfdrsv55svbvf3f", "7S", "Three Notch Road", 20619, "36.83", "119.6"));
		PLACES.add(new Place("mjdhgetr4pojfyts22fzfsh", "22803", "Gunston Dr Lexington Park", 20688, "35.7788",
				"119.979"));
		PLACES.add(new Place("urhw3837ehalod7w02b7835", "225", "Macarthur Blvd", 20687, "35.77813", "119.41791"));
	}

	List<Place> findCaliforniaCafes(String cafeName) {
		List<Place> list = new ArrayList<Place>();
		for (Cafe cafe : CAFES) {
			String str = cafe.name;
			int len = str.length();
			for (int i = 0; i < len; i++) {
				for (int j = i + 1; j <= len; j++) {
					if (cafeName.equalsIgnoreCase(str.substring(i, j))) {
						for (Place place : PLACES) {
							if (cafe.place_id.equals(place.id)) {
								place.id = cafe.name;
								list.add(place);
							}
						}
					}
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("====================================");
		System.out.println("     CALIFORNIA CAFE DIRECTORY      ");
		System.out.println("====================================");

		System.out.println("Enter your cafe's name :- ");
		String name = sc.nextLine();
		sc.close();
		Controller obj = new Controller();
		List<Place> lists = obj.findCaliforniaCafes(name);
		if (lists.isEmpty()) {
			System.out.println("-------------------------------");
			System.err.println("No Cafe found !!!");
			System.out.println("-------------------------------");
		} else {
			for (Place place : lists) {
				System.out.println("-------------------------------");
				System.out.println("name : " + place.id);
				System.out.println("street_no : " + place.street_no);
				System.out.println("locality : " + place.locality);
				System.out.println("postal_code : " + place.postal_code);
				System.out.println("lat : " + place.latitude);
				System.out.println("long : " + place.longitude);
			}
		}
	}
}
