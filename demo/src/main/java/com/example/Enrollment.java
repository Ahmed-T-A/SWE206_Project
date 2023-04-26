package com.example;

import java.io.Serializable;
import java.util.ArrayList;

public class Enrollment implements Serializable {
  //-----------------
  private int seats;
  private int registeredSeats;
  private int availableSeats;
  private ArrayList<Object> requests;
  //-----------------
  public Enrollment(int seats, int registeredSeats){
    this.seats = seats;
    this.registeredSeats = registeredSeats;
    this.availableSeats = seats - registeredSeats;
    this.requests = new ArrayList<>();
  }
  //-----------------
  public void request(Object a){
    requests.add(a);
  }

  public void cancelRequest(Object a){
    requests.remove(a);
  }
  public int getSeats() {
    return seats;
  }
  public int getRegisteredSeats() {
    return registeredSeats;
  }
  public int getAvailableSeats() {
    return availableSeats;
  }
  public ArrayList<Object> getRequests() {
    return requests;
  }
  public void incrementRegisteredSeats() {
    this.registeredSeats++;
    availableSeats = seats - registeredSeats;
  }

  public void decrementRegisteredSeats() {
    this.registeredSeats--;
    availableSeats = seats - registeredSeats;
  }

  public String toString(){
    return "Total Seats is: " + seats + "\n Registered Seats is: " + registeredSeats + "\n Availble Seats is: " + availableSeats;
  }
}
