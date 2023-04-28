package com.example;

import java.util.HashMap;
import java.util.Map;

public class StudentProfile {
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

  public void addToInProgressTournaments(String tourName, String rank) {
    inProgressTournaments.put(tourName, rank);
  }

  public void addToPastTournaments(String tourName, String place) {
    pastTournaments.put(tourName, place);
  }

  
}
