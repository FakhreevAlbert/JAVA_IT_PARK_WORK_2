package ru.itpark.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Connector {
  @Value("${connector.login}")
  private String login;
  @Value("${connector.password}")
  private String password;

  public Connector() {
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    System.out.println("setter");
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
