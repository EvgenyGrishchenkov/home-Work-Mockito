package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;

class MessageSenderImplTest {
    private MessageSender messageSender;
    private GeoService geoService;
    private LocalizationService localizationService;
    private Map<String, String> headers;

    @BeforeEach
    void init() {
        geoService = Mockito.mock(GeoService.class);
        localizationService = Mockito.mock(LocalizationService.class);
        messageSender = new MessageSenderImpl(geoService, localizationService);
        headers = new HashMap<>();
        //testSender.put("Заграница","96.44.183.149");
        //testSender.put("Москва","172.0.32.11" );
    }

    @Test
    void test_messageSenderRus() {
        Mockito.when(geoService.byIp("172.0.32.11"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");
        String result = messageSender.send(headers);
        String expected = "Добро пожаловать";

        Mockito.verify(geoService, Mockito.times(1)).byIp("172.0.32.11");
        Mockito.verify(localizationService, Mockito.never()).locale(Country.USA);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test_messageSenderZabugor() {
        Mockito.when(geoService.byIp("96.44.183.149"))
                .thenReturn(new Location("New York", Country.USA, null, 0));
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        String result = messageSender.send(headers);
        String expected = "Welcome";

        Mockito.verify(geoService, Mockito.never()).byIp("172.0.32.11");
        Mockito.verify(localizationService, Mockito.times(2)).locale(Country.USA);
        Assertions.assertEquals(expected, result);
    }
}