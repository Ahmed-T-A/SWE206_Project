package com.example;


public class Match {
  //-----------------
  private int matchID;
  private String date;
  private String team1;
  private String team2;
  private int pointsForTeam1;
  private int pointsForTeam2;
  private String winner;
  //-----------------
  public Match(int matchID, String date, String team1, String team2){
    this.matchID = matchID;
    this.date = date;
    this.team1 = team1;
    this.team2 = team2;
    pointsForTeam1 = 0;
    pointsForTeam2 = 0;
    winner = null;
  }
  //-----------------
  public int getMatchID(){
    return matchID;
  }

  public String getMatchDate(){
    return date;
  }

  public String getTeam1(){
    return team1;
  }

  public String getTeam2(){
    return team2;
  }

  public int getpoints1(){
    return pointsForTeam1;
  }

  public int getpoints2(){
    return pointsForTeam2;
  }

  public String getWinner(){
    return winner;
  }

  public void setPoint1(int num){
    pointsForTeam1 = num;
  }

  public void setPoint2(int num){
    pointsForTeam2 = num;
  }

  public void setWinner(String winner){
    this.winner = winner;
  }
}
