package ru.itpark.domain;

public class Keyword {
    private int id;
    private String keywords;

    public Keyword(int id, String keywords) {
        this.id = id;
        this.keywords = keywords;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeyword(String keywords) {
        this.keywords = keywords;
    }
}
