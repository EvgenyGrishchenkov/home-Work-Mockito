package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {
LocalizationService localizationService = new LocalizationServiceImpl();
    @Test
    void test_locale_localizationService() {
        Country param = Country.RUSSIA;
        String expected = "Добро пожаловать";
        Assertions.assertEquals(expected, localizationService.locale(param));

        Country param2 = Country.BRAZIL;
        String expected2 = "Welcome";
        Assertions.assertEquals(expected2, localizationService.locale(param2));
    }
}