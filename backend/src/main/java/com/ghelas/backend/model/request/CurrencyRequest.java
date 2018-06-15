package com.ghelas.backend.model.request;

import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.Map;

public class CurrencyRequest {
    private Long id;
    private Map<String, String> title;
    private String symbol;

    public CurrencyRequest() {
    }

    public CurrencyRequest(Map<String, String> title, String symbol) {
        this.title = title;
        this.symbol = symbol;
    }

    public Long getId() {
        return id;
    }

    public Map<String, String> getTitle() {
        return title;
    }

    public void setTitle(Map<String, String> title) {
        this.title = title;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "CurrencyRequest{" +
                "id=" + id +
                ", title=" + title +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
