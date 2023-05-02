package com.example;

import java.io.EOFException;
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
  String savedTournamentPath = "U:\\Term222\\SWE206\\SWE206_Project\\";
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

  public void makeRequest(Student student){
    enrollment.request(student);
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

  public void saveTour(File file){
    if(file.exists()){
      try{
        FileInputStream fileInput = new FileInputStream(file);
        ObjectInputStream input = new ObjectInputStream(fileInput);
        Tournaments tournaments = (Tournaments) input.readObject();
        ArrayList<Tournament> available = tournaments.getAvailableTournaments();
        ArrayList<Tournament> inProgress = tournaments.getInProgressTournaments();
        ArrayList<Tournament> previous = tournaments.getPreviousTournaments();
        boolean flag = true;
        if(status){
          for(int i = 0; i < available.size(); i++){
            if(name.equals(available.get(i).name)){
              available.remove(i);
              available.add(i, this);
              flag = false;
              break;
            }
          }
          if(flag)
            available.add(this);
          tournaments.setAvailableTournaments(available);
        }
        else if(archived){
          for(int i = 0; i < previous.size(); i++){
            if(name.equals(previous.get(i).name)){
              previous.remove(i);
              previous.add(i, this);
              flag = false;
              break;
            }
          }
          if(flag)
            previous.add(this);
          tournaments.setPreviousTournaments(previous);
        }
        else{
          for(int i = 0; i < inProgress.size(); i++){
            if(name.equals(inProgress.get(i).name)){
              inProgress.remove(i);
              inProgress.add(i, this);
              flag = false;
              break;
            }
          }
          if(flag)
            inProgress.add(this);
          tournaments.setInProgressTournaments(inProgress);
        }
        input.close();
        FileOutputStream fileOutput = new FileOutputStream(file);
        ObjectOutputStream writer = new ObjectOutputStream(fileOutput);
        writer.writeObject(tournaments);
        writer.close();
      }
      catch(Exception ex){
        System.out.println(ex);
      }
    }
    else{
      Tournaments tournaments = new Tournaments();
      if(status){
        tournaments.addToAvailavle(this);
      }
      else if(archived){
        tournaments.addToPrevious(this);
      }
      else{
        tournaments.addToinProgree(this);
      }
      try {
        FileOutputStream fileOutput = new FileOutputStream(file);
        ObjectOutputStream writer = new ObjectOutputStream(fileOutput);
        writer.writeObject(tournaments);
        writer.close();
      } 
      catch (Exception ex) {
        System.out.println(ex);
      }
    }
  }

  public void saveToFile(String fileName){
    try{
      File file = new File(savedTournamentPath + fileName + ".dat");
      FileOutputStream theBinaryFile = new FileOutputStream(file, true);
      ObjectOutputStream output = new ObjectOutputStream(theBinaryFile);
      output.writeObject(this);
      output.close();
    }
    catch(IOException e){
      System.out.println(e.getMessage());
    }
  }

  public boolean alreadyExists(String fileName){
    try {
      File file = new File(savedTournamentPath + fileName + ".dat");
      FileInputStream fileInputStream =new FileInputStream(file);
      ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
      Tournament tournament = (Tournament) objectInputStream.readObject();
      while(tournament != null){
        if(getName().equals(tournament.getName())){
          objectInputStream.close();
          System.out.println("exists");
          return true;
        }
        ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream);
        tournament = (Tournament) objectInputStream2.readObject();
      }
      objectInputStream.close();
      return false;
    }
    catch(ClassNotFoundException e){
      System.out.println("existance error 1");
      System.out.println(e.getMessage());
      return false;
    }
    catch(IOException e){
      System.out.println("existance error 1");
      System.out.println(e.getMessage());
      return false;
    }
  }

  // public void saveAndRemoveToFile(String fileName){
  //   SLL<Tournament> sll = new SLL<Tournament>();
  //   sll.addToHead(this);
  //   try {
  //     File file = new File(savedTournamentPath + fileName + ".dat");
  //     FileInputStream fileInputStream =new FileInputStream(file);
  //     ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
  //     Tournament tournament = (Tournament) objectInputStream.readObject();
  //     objectInputStream.close();
  //     while(tournament != null){
  //       if(!getName().equals(tournament.getName())){
  //         sll.addToHead(tournament);
  //         System.out.println("adding "+tournament.name);
  //       }
  //       else{
  //         System.out.println("ignored"+tournament.name);
  //       }
  //       ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream);
  //       tournament = (Tournament) objectInputStream2.readObject();
  //     }
  //   } catch (Exception e) {
  //     saveToFile(fileName, sll);
  //     System.out.println("saved");
  //     // TODO: handle exception
  //   }
  // }

  // public void saveToFile(String fileName, SLL<Tournament> sll){
  //   try {
  //     File file = new File(savedTournamentPath + fileName + ".dat");
  //     FileOutputStream fileOutputStream = new FileOutputStream(file);
  //     ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
  //     while(!sll.isEmpty()){
  //       System.out.println("xx"+sll.head.info.name);
  //       objectOutputStream.writeObject(sll.deleteFromHead());
  //     }
  //     System.out.println("realy done");
  //     objectOutputStream.close();
  //   } catch (Exception e) {
  //     // TODO: handle exception
  //   }
  // }

  // public void saveToFile(String fileName) throws IOException {
  //   File file = new File(fileName);
  //   boolean exists = file.exists();
  //   ObjectInputStream in = null;
  //   ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
  //   try {
  //       if (exists) {
  //           in = new ObjectInputStream(new FileInputStream(fileName));
  //           boolean replaced = false;
  //           while (true) {
  //               Tournament t = (Tournament) in.readObject();
  //               if (!replaced && t.getName().equals(this.getName())) {
  //                   out.writeObject(this);
  //                   replaced = true;
  //               } else {
  //                   out.writeObject(t);
  //               }
  //           }
  //       }
  //       else{
  //         out.writeObject(this);
  //       }

  //       out.close();
  //   } catch (EOFException e) {
  //       // Reached end of file
  //   } catch (ClassNotFoundException e) {
  //       e.printStackTrace();
  //   } finally {
  //       if (in != null) {
  //           in.close();
  //       }
  //       // out.writeObject(this);
  //       // out.close();
  //   }
  // }

  @Override
  public String toString() {
    return "Tournament [name=" + name + ", sport=" + sport + ", startDate=" + startDate + ", endDate=" + endDate
        + ", teamBased=" + teamBased + ", status=" + status + ", teamCapacity=" + teamCapacity + ", acceptedMembers="
        + acceptedMembers + ", rounds=" + rounds + ", enrollment=" + enrollment + ", progress=" + progress + "]";
  }  
}
