package com.example;

import java.util.ArrayList;

public abstract class Tournament {
  //-----------------
  private String name;
  private String sport;
  private String startDate;
  private String endDate;
  private boolean teamBased;
  private boolean status; // true for open, False for close.
  private int teamCapacity;
  private ArrayList<Object> acceptedMembers;
  private ArrayList<Round> rounds;
  private Enrollment enrollment;
  private TournamentProgress progress;
  //-----------------
  public Tournament(String name, String startDate, String endDate, boolean teamBased, int teamCapacity, Enrollment enrollment, TournamentProgress progress){
    this.name = name;
    this.startDate = startDate;
    this.endDate = endDate;
    this.teamBased = teamBased;
    this.teamCapacity = teamCapacity;
    this.enrollment = enrollment;
    this.progress = progress;
    this.sport = null;
    this.status = true;
    this.acceptedMembers = new ArrayList<>();
    this.rounds = new ArrayList<>();
  }

  public Tournament(String name, String sport, String startDate, String endDate, boolean teamBased, int teamCapacity, Enrollment enrollment, TournamentProgress progress){
    this.name = name;
    this.startDate = startDate;
    this.endDate = endDate;
    this.teamBased = teamBased;
    this.teamCapacity = teamCapacity;
    this.enrollment = enrollment;
    this.progress = progress;
    this.sport = sport;
    this.status = true;
    this.acceptedMembers = new ArrayList<>();
    this.rounds = new ArrayList<>();
  }
  //-----------------
  public void request(Object a){}

  public void drop(Object a){}

  public abstract void generateTable();

  public void addToArchive(){}

  public String getName() {
    return name;
  }

  public String getSport() {
    return sport;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public boolean isTeamBased() {
    return teamBased;
  }

  public boolean getStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public int getTeamCapacity() {
    return teamCapacity;
  }

  public void setTeamCapacity(int teamCapacity) {
    this.teamCapacity = teamCapacity;
  }

  public ArrayList<Object> getAcceptedMembers() {
    return acceptedMembers;
  }

  public void addToAcceptedMembers(Object a) {
    this.acceptedMembers.add(a);
  }

  public ArrayList<Round> getRounds() {
    return rounds;
  }

  public void addToRounds(Round a) {
    this.rounds.add(a);;
  }

  public String getEnrollmentStatistics() {
    return enrollment.toString();
  }

  public void setEnrollment(Enrollment enrollment) {
    this.enrollment = enrollment;
  }

  public TournamentProgress getProgress() {
    return progress;
  }

  public void setProgress(TournamentProgress progress) {
    this.progress = progress;
  }
}
