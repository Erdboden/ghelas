package com.ghelas.backend.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String iso6391;
    private String locale;
    private String title;
    private Boolean active;
    private Boolean isDefault;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "language_id")
    private List<CurrencyTranslation> currencyTranslations;

    public Language() {
    }

    public Language(String iso6391, String locale, String title, Boolean active, Boolean isDefault) {
        this.iso6391 = iso6391;
        this.locale = locale;
        this.title = title;
        this.active = active;
        this.isDefault = isDefault;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIso6391() {
        return iso6391;
    }

    public void setIso6391(String iso6391) {
        this.iso6391 = iso6391;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", iso6391='" + iso6391 + '\'' +
                ", locale='" + locale + '\'' +
                ", title='" + title + '\'' +
                ", active=" + active +
                ", isDefault=" + isDefault +
                ", currencyTranslations=" + currencyTranslations +
                '}';
    }
}
