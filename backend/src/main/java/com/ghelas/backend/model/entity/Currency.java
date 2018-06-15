package com.ghelas.backend.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "currencies")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String symbol;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "currency_id")
    private List<CurrencyTranslation> currencyTranslations;

    public Currency() {
    }

    public Currency(String symbol, List<CurrencyTranslation> currencyTranslations) {
        this.symbol = symbol;
        this.currencyTranslations = currencyTranslations;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setCurrencyTranslations(List<CurrencyTranslation> currencyTranslations) {
        this.currencyTranslations = currencyTranslations;
    }

    public CurrencyTranslation getCurrencyTranslation(long languageId) {
        return currencyTranslations.stream().filter(t -> t.getLanguage().getId() == languageId).findFirst().get();
    }
}
