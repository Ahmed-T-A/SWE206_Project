package com.example;

import java.io.Serializable;
import java.util.ArrayList;

public class Tournaments implements Serializable {
  //---------------
  private ArrayList<Tournament> availableTournaments;
  private ArrayList<Tournament> inProgressTournaments;
  private ArrayList<Tournament> previousTournaments;
  //---------------
  public Tournaments(){
    availableTournaments = new ArrayList<>();
    inProgressTournaments = new ArrayList<>();
    previousTournaments = new ArrayList<>();
  }
  //---------------
  public void changeTournamentPlace(Tournament a, ArrayList<Tournament> currentPlace, ArrayList<Tournament> destenation){
    currentPlace.remove(a);
    destenation.add(a);
  }

  public void addToAvailavle(Tournament a){
    availableTournaments.add(a);
  }
  
  public void addToinProgree(Tournament a){
    inProgressTournaments.add(a);
  }

  public void addToPrevious(Tournament a){
    previousTournaments.add(a);
  }

  public void removeFromAvailavle(Tournament a){
    availableTournaments.remove(a);
  }
  
  public void removeFrominProgree(Tournament a){
    inProgressTournaments.remove(a);
  }

  public void removeFromPrevious(Tournament a){
    previousTournaments.remove(a);
  }
  public ArrayList<Tournament> getAvailableTournaments() {
    return availableTournaments;
  }
  public ArrayList<Tournament> getInProgressTournaments() {
    return inProgressTournaments;
  }
  public ArrayList<Tournament> getPreviousTournaments() {
    return previousTournaments;
  }
  public void setAvailableTournaments(ArrayList<Tournament> availableTournaments) {
    this.availableTournaments = availableTournaments;
  }
  public void setInProgressTournaments(ArrayList<Tournament> inProgressTournaments) {
    this.inProgressTournaments = inProgressTournaments;
  }
  public void setPreviousTournaments(ArrayList<Tournament> previousTournaments) {
    this.previousTournaments = previousTournaments;
  }

  
}
