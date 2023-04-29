package com.example;

import java.io.Serializable;

public class Student implements Serializable {
  String name;
  String ID;
  String username;
  String password;
  String email;
  StudentProfile profile;

  public Student(String name, String ID, String username, String password){
    this.name = name;
    this.ID = ID;
    this.username = username;
    this.password = password;
    this.email = null;
    profile = new StudentProfile(name, ID, email);
  }

  public Student(String name, String ID, String username, String password, String email){
    this.name = name;
    this.ID = ID;
    this.username = username;
    this.password = password;
    this.email = email;
    profile = new StudentProfile(name, ID, email);
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

  public StudentProfile gStudentProfile(){
    return profile;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Student other = (Student) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (ID == null) {
      if (other.ID != null)
        return false;
    } else if (!ID.equals(other.ID))
      return false;
    if (username == null) {
      if (other.username != null)
        return false;
    } else if (!username.equals(other.username))
      return false;
    if (password == null) {
      if (other.password != null)
        return false;
    } else if (!password.equals(other.password))
      return false;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    return true;
  }  
}
