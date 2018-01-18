package ru.itpark.bean;

public class Connector {
  private String login;
  private String password;

  public Connector() {
  }

  public Connector(String value) {
    System.out.println(value);
  }

  public void init() {
    System.out.println("init");
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
