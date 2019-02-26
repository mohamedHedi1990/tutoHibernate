package com.exo.testHiberante.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "leoni_user")
public class User {
  @Id

  @GeneratedValue(strategy = GenerationType.AUTO)

  @Column(name = "id")

  private int id;

  @Column(name = "login")

  private String login;

  @Column(name = "password")

  private String password;

  @Column(name = "email")

  private String email;

  public User() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  
}
