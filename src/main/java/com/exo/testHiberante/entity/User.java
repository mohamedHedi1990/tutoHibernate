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

  //@GeneratedValue(strategy = GenerationType.AUTO)
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  @Column(name = "id")

  private Integer id;

  @Column(name = "login")

  private String login;

  @Column(name = "password")

  private String password;

  @Column(name = "email")

  private String email;
  
  @Column(name = "firstName")

  private String firstName;
  
  @Column(name = "lastName")

  private String lastName;
  
  @Column(name = "ipAddress")

  private String ipAddress;
  
  @Column(name = "phoneNumber")

  private String phoneNumber;
  
  @Column(name = "team")

  private String team;
  
  @Column(name = "teamLeader")

  private String teamLeader;

  public User() {}

  public User(Integer id,
              String login,
              String password,
              String email,
              String firstName,
              String lastName,
              String ipAddress,
              String phoneNumber,
              String team,
              String teamLeader) {
    super();
    this.id = id;
    this.login = login;
    this.password = password;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.ipAddress = ipAddress;
    this.phoneNumber = phoneNumber;
    this.team = team;
    this.teamLeader = teamLeader;
  }



  public String getFirstName() {
    return firstName;
  }


  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public String getLastName() {
    return lastName;
  }


  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public String getIpAddress() {
    return ipAddress;
  }


  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }


  public String getPhoneNumber() {
    return phoneNumber;
  }


  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }


  public String getTeam() {
    return team;
  }


  public void setTeam(String team) {
    this.team = team;
  }


  public String getTeamLeader() {
    return teamLeader;
  }


  public void setTeamLeader(String teamLeader) {
    this.teamLeader = teamLeader;
  }


  public void setId(Integer id) {
    this.id = id;
  }


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
