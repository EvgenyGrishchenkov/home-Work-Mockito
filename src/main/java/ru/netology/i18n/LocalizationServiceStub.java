package ru.netology.i18n;

import ru.netology.entity.Country;

public class LocalizationServiceStub implements LocalizationService{
    @Override
    public String locale(Country country) {
        return null;
    }
}
