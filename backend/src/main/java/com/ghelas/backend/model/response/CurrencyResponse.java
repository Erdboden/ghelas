package com.ghelas.backend.model.response;

public class CurrencyResponse {
    private Long id;
    private String title;
    private String symbol;

    public CurrencyResponse() {
    }

    public CurrencyResponse(String title, String symbol) {
        this.title = title;
        this.symbol = symbol;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
