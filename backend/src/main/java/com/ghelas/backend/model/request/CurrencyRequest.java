package com.ghelas.backend.model.request;

import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.Map;

public class CurrencyRequest {
    private Long id;
    private Map<Long, String> title;
    private String symbol;

    public CurrencyRequest() {
    }

    public CurrencyRequest(Map<Long, String> title, String symbol) {
        this.title = title;
        this.symbol = symbol;
    }

    public Long getId() {
        return id;
    }

    public Map<Long, String> getTitle() {
        return title;
    }

    public void setTitle(Map<Long, String> title) {
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
