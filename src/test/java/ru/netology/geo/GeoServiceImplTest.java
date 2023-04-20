package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {
GeoService geoService = new GeoServiceImpl();
    @Test
    void test_byIp_geoServiceMoscow() {
        String expected = "Moscow";
        String result = geoService.byIp("172.0.32.11").getCity();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test_byIp_geoServiceNewYork() {
        String expected = "New York";
        String result = geoService.byIp("96.44.183.149").getCity();
        Assertions.assertEquals(expected, result);
    }
}