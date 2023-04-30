package com.example;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class StudentProfile implements Serializable {
  String name;
  String email;
  String ID;
  HashMap<String , String> inProgressTournaments = new HashMap<String,String>();
  HashMap<String , String> pastTournaments = new HashMap<String,String>();

  public StudentProfile (String name, String ID, String email){
    this.name = name;
    this.ID = ID;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getID() {
    return ID;
  }

  public HashMap<String, String> getInProgressTournaments() {
    return inProgressTournaments;
  }

  public HashMap<String, String> getPastTournaments() {
    return pastTournaments;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void addToInProgressTournaments(Tournament tournament, String rank) {
    inProgressTournaments.put(tournament.getName(), rank);
  }

  public void addToPastTournaments(Tournament tournament, String place) {
    pastTournaments.put(tournament.getName(), place);
  }

  
}
