package com.example;

public class Student {
  String name;
  String ID;
  String username;
  String password;
  String email;

  public Student(String name, String ID, String username, String password){
    this.name = name;
    this.ID = ID;
    this.username = username;
    this.password = password;
    this.email = null;
  }

  public Student(String name, String ID, String username, String password, String email){
    this.name = name;
    this.ID = ID;
    this.username = username;
    this.password = password;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public String getID() {
    return ID;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  
}
