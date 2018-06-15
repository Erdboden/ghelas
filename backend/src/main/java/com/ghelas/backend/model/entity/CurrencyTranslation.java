package com.ghelas.backend.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "currency_translations")
public class CurrencyTranslation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Language language;

    @ManyToOne
    private Currency currency;

    private String title;

    public CurrencyTranslation() {
    }

    public CurrencyTranslation(Language language, String title) {
        this.language = language;
        this.title = title;
    }

    public CurrencyTranslation(Language language, Currency currency, String title) {
        this.language = language;
        this.currency = currency;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
