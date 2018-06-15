package com.ghelas.backend.convertor;

import com.ghelas.backend.model.entity.Currency;
import com.ghelas.backend.model.response.CurrencyResponse;
import org.springframework.core.convert.converter.Converter;

public class CurrencyToCurrencyResponseConverter implements Converter<Currency, CurrencyResponse> {

    @Override
    public CurrencyResponse convert(Currency source) {
        CurrencyResponse currencyResponse = new CurrencyResponse();
        currencyResponse.setTitle(source.getCurrencyTranslation(1).getTitle());
        currencyResponse.setSymbol(source.getSymbol());

        return currencyResponse;
    }
}
