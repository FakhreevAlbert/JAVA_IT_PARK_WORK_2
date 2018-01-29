package ru.itpark.domain;

public class Movie {
  private int id;
  private String title;
  private int budget;
  private String overview;

  public Movie(int id, String title, int budget, String overview) {
    this.id = id;
    this.title = title;
    this.budget = budget;
    this.overview = overview;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getBudget() {
    return budget;
  }

  public void setBudget(int budget) {
    this.budget = budget;
  }

  public String getOverview() {
    return overview;
  }

  public void setOverview(String overview) {
    this.overview = overview;
  }
}
