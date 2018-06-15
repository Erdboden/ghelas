package com.ghelas.backend.convertor;

import com.ghelas.backend.model.entity.Currency;
import com.ghelas.backend.model.entity.CurrencyTranslation;
import com.ghelas.backend.model.entity.Language;
import com.ghelas.backend.model.request.CurrencyRequest;
import com.ghelas.backend.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class CurrencyRequestToCurrencyConverter implements Converter<CurrencyRequest, Currency> {
    @Autowired
    LanguageRepository languageRepository;

    @Override
    public Currency convert(CurrencyRequest source) {
        List<CurrencyTranslation> currencyTranslations = new ArrayList<CurrencyTranslation>();
        Currency currency = new Currency();
        source.getTitle().forEach((key, value) -> {
            Language language = languageRepository.findById(Long.valueOf(key)).get();
            currencyTranslations.add(new CurrencyTranslation(language, value));
        });
        currency.setCurrencyTranslations(currencyTranslations);
        currency.setSymbol(source.getSymbol());

        if (null != source.getId()) {
            currency.setId(source.getId());
        }

        return currency;
    }
}
