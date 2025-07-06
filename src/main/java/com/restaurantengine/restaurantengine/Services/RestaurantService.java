package com.restaurantengine.restaurantengine.Services;
import com.restaurantengine.restaurantengine.Model.Restaurant;
import com.restaurantengine.restaurantengine.Model.RestaurantResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.lang.Math.*;

@Service
public class RestaurantService {

    private final RestTemplate restTemplate;

    public RestaurantService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public List<Restaurant> getRestaurantsNearLocation(double latitude, double longitude) {
        double[] boundingBox = getBoundingBox(latitude, longitude, 5);

        //PUBLIC API OK TO COMMIT (NO AUTH)
        String apiUrl = String.format("https://overpass-api.de/api/interpreter?data=[out:json];node[\"amenity\"=\"restaurant\"](%f,%f,%f,%f);out;",
                boundingBox[0], boundingBox[1], boundingBox[2], boundingBox[3]);
        return restTemplate.getForObject(apiUrl, RestaurantResponse.class).getElements();
    }

    private double[] getBoundingBox(double latitude, double longitude, int radius) {
        double long_formula = radius / (69.0 * cos(latitude * PI / 180));
        double lat_formula = radius / 69.0;
        double lat_min = latitude - lat_formula;
        double lat_max = latitude + lat_formula;
        double lng_min = longitude - long_formula;
        double lng_max  = longitude + long_formula;
        return new double[]{lat_min, lng_min, lat_max, lng_max};
    }


}
