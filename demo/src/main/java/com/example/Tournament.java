package com.example;

import java.io.Serializable;
import java.util.ArrayList;

public class Tournament implements Serializable {
  //-----------------
  private String name;
  private String sport;
  private String startDate;
  private String endDate;
  private String tournamentType;
  private boolean teamBased;
  private boolean status; // true for open, False for close.
  private int teamCapacity;
  private ArrayList<Object> acceptedMembers;
  private ArrayList<Round> rounds;
  private Enrollment enrollment;
  private TournamentProgress progress;
  private boolean archived;
  //-----------------
  public Tournament(String name, String startDate, String endDate, String tournamntType, boolean status, boolean archived, boolean teamBased, int teamCapacity, Enrollment enrollment, TournamentProgress progress){
    this.name = name;
    this.startDate = startDate;
    this.endDate = endDate;
    this.tournamentType = tournamntType;
    this.teamBased = teamBased;
    this.teamCapacity = teamCapacity;
    this.enrollment = enrollment;
    this.progress = progress;
    this.sport = null;
    this.status = status;
    this.acceptedMembers = new ArrayList<>();
    this.rounds = new ArrayList<>();
    this.archived = archived;
  }

  public Tournament(String name, String sport, String startDate, String endDate, String tournamentType, boolean status, boolean archived, boolean teamBased, int teamCapacity, Enrollment enrollment, TournamentProgress progress){
    this.name = name;
    this.startDate = startDate;
    this.endDate = endDate;
    this.tournamentType = tournamentType;
    this.teamBased = teamBased;
    this.teamCapacity = teamCapacity;
    this.enrollment = enrollment;
    this.progress = progress;
    this.sport = sport;
    this.status = status;
    this.acceptedMembers = new ArrayList<>();
    this.rounds = new ArrayList<>();
    this.archived = archived;
  }
  //-----------------
  public void request(Object a){}

  public void drop(Object a){}

  public void generateTable(){}

  public void addToArchive(){}

  public String getName() {
    return name;
  }

  public String getType(){
    return tournamentType;
  }

  public String getSport() {
    return sport;
  }

  public boolean isArchived(){
    return archived;
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

  public Enrollment getEnrollment(){
    return enrollment;
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

  @Override
  public String toString() {
    return "Tournament [name=" + name + ", sport=" + sport + ", startDate=" + startDate + ", endDate=" + endDate
        + ", teamBased=" + teamBased + ", status=" + status + ", teamCapacity=" + teamCapacity + ", acceptedMembers="
        + acceptedMembers + ", rounds=" + rounds + ", enrollment=" + enrollment + ", progress=" + progress + "]";
  }  
}
