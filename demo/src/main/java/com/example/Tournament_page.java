package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Tournament_page {
  Tournament tournament;
  @FXML
  private Label teamCapacity;

  @FXML
  private Label tournamentEndDate;

  @FXML
  private Label tournamentName;

  @FXML
  private Label tournamentProgress;

  @FXML
  private Label tournamentSport;

  @FXML
  private Label tournamentStartDate;

  @FXML
  private Label tournamentStatus;

  @FXML
  private Label tournamentType;

  public Tournament_page(Tournament tournament){
    this.tournament = tournament;

    tournamentName.setText(tournament.getName());
    tournamentSport.setText(tournament.getSport());
    tournamentStartDate.setText(tournament.getStartDate());
    tournamentEndDate.setText(tournament.getEndDate());
    // tournamentType.setText(tournament.getType());
    tournamentType.setText("Elimination");
    teamCapacity.setText((Integer.toString(tournament.getTeamCapacity())));
    tournamentStatus.setText(Boolean.toString(tournament.getStatus()));
    tournamentProgress.setText("50%");
  }
  
}
