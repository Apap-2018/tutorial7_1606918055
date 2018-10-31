package com.apap.tutorial7.rest;

public class Setting {

    public static final String pilotUrl = "https://b5f3a7f1-752e-4217-85a5-5951e6a5b14f.mock.pstmn.io";

    private static final String AMADUES_API_KEY = "uiaunKvF5vSajCeGkAPvEJkNggsgR4A8";

    public static final String AMADUES_API_URL = "https://api.sandbox.amadeus.com/v1.2";

    public static final String AMADEUS_API_AIRPORT = AMADUES_API_URL + "/airports/autocomplete?apikey="+AMADUES_API_KEY;

    public static final String getAirportIDUrlByCity(String city) {
        return AMADEUS_API_AIRPORT + "&all_airports=true&country=ID&term=" + city;
    }
}
