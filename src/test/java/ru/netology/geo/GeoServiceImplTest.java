package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {
GeoService geoService = new GeoServiceImpl();
    @Test
    void test_byIp_geoService() {
        String param = "172.0.32.11";
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        //Location result = geoService.byIp(param);
        Assertions.assertEquals(expected, geoService.byIp(param), "совпадение");

    }
}