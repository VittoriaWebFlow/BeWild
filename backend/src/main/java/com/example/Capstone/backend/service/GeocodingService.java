package com.example.Capstone.backend.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class GeocodingService {

    private final RestTemplate restTemplate = new RestTemplate();

    public double[] getCoordinates(String localita) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl("https://nominatim.openstreetmap.org/search")
                .queryParam("q", localita)
                .queryParam("format", "json")
                .queryParam("limit", 1)
                .build()
                .toUri();

        String response = restTemplate.getForObject(uri, String.class);
        JSONArray results = new JSONArray(response);

        if (results.length() > 0) {
            JSONObject location = results.getJSONObject(0);
            double lat = location.getDouble("lat");
            double lon = location.getDouble("lon");
            return new double[]{lat, lon};
        } else {
            throw new RuntimeException("Località non trovata: " + localita);
        }
    }
}
