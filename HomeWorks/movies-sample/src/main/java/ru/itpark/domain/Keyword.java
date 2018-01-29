package ru.itpark.domain;

public class Keyword {
    private int id;
    private String keywords;

    public Keyword(int id, String keyword) {
        this.id = id;
        this.keywords = keyword;

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

    public void setKeyword(String keyword) {
        this.keywords = keyword;
    }
}
