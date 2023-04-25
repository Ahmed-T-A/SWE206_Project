package com.example;

import java.util.ArrayList;

public class Tournaments {
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
}
