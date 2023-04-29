package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Tournament implements Serializable {
  private static final long serialVersionUID = -3376593017416497415L;
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

  public void saveToFile(String fileName){
    try{
      File file = new File("U:\\Term222\\SWE206\\SWE206_Project\\" + fileName + ".dat");
      FileOutputStream theBinaryFile = new FileOutputStream(file, true);
      ObjectOutputStream output = new ObjectOutputStream(theBinaryFile);
      output.writeObject(this);
      output.close();
    }
    catch(IOException e){
      System.out.println(e.getMessage());
    }
  }

//   public void saveToFile(String fileName){
//     ArrayList<Tournament> tournaments = new ArrayList<>();
//     File file = new File("U:\\Term222\\SWE206\\SWE206_Project\\" + fileName + ".dat");
      
//     // Read existing tournaments from file
//     try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
//         Object obj = in.readObject();
//         while (obj != null) {
//             if (obj instanceof Tournament) {
//                 Tournament t = (Tournament) obj;
//                 if (t.getName().equals(this.getName())) {
//                     // Replace existing tournament
//                     tournaments.add(this);
//                 } else {
//                     tournaments.add(t);
//                 }
//             }
//             obj = in.readObject();
//         }
//     } catch (FileNotFoundException e) {
//         System.out.println(e.getMessage());
//     } catch (IOException e) {
//         System.out.println(e.getMessage());
//     } catch (ClassNotFoundException e) {
//         System.out.println(e.getMessage());
//     }

//     // Append new tournament if it does not exist
//     if (!tournaments.contains(this)) {
//         tournaments.add(this);
//     }

//     // Write tournaments back to file
//     try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
//         for (Tournament t : tournaments) {
//             out.writeObject(t);
//         }
//     } catch (FileNotFoundException e) {
//         System.out.println(e.getMessage());
//     } catch (IOException e) {
//         System.out.println(e.getMessage());
//     }
// }


  @Override
  public String toString() {
    return "Tournament [name=" + name + ", sport=" + sport + ", startDate=" + startDate + ", endDate=" + endDate
        + ", teamBased=" + teamBased + ", status=" + status + ", teamCapacity=" + teamCapacity + ", acceptedMembers="
        + acceptedMembers + ", rounds=" + rounds + ", enrollment=" + enrollment + ", progress=" + progress + "]";
  }  
}
