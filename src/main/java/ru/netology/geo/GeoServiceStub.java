package ru.netology.geo;

import ru.netology.entity.Location;

public class GeoServiceStub implements GeoService{
    @Override
    public Location byIp(String ip) {
        return null;
    }

    @Override
    public Location byCoordinates(double latitude, double longitude) {
        return null;
    }
}
