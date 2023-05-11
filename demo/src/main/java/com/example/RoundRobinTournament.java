// package com.example;

// public class RoundRobinTournament {
  

// package com.example;

// import javafx.beans.property.ReadOnlyObjectWrapper;
// import javafx.beans.property.ReadOnlyStringWrapper;
// import javafx.beans.property.SimpleStringProperty;
// import javafx.beans.value.ObservableValue;
// import javafx.collections.FXCollections;
// import javafx.collections.ObservableList;
// import javafx.event.ActionEvent;
// import javafx.fxml.FXML;
// import javafx.fxml.Initializable;
// import javafx.scene.control.*;
// import javafx.scene.control.TableColumn.CellDataFeatures;
// import javafx.scene.control.cell.PropertyValueFactory;
// import javafx.scene.control.cell.TextFieldTableCell;
// import javafx.scene.layout.AnchorPane;
// import javafx.util.Callback;
// import javafx.util.converter.IntegerStringConverter;

// import java.io.IOException;
// import java.net.URL;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Comparator;
// import java.util.List;
// import java.util.ResourceBundle;

// public class RoundR implements Initializable {

//     private List<Team> teams;
//     private List<Match> matches;
//     private int currentRound;


//     @FXML
//     private TableView<Team> mainRoundRobin;

//     @FXML
//     private TableColumn<Team, String> team;

//     @FXML
//     private TableColumn<Team, Integer> wins;

//     @FXML
//     private TableColumn<Team, Integer> losses;

//     @FXML
//     private TableColumn<Team, Integer> points;

//     @FXML
//     private TableView<Match> round;

//     @FXML
//     private TableColumn<Match, String> match;

//     @FXML
//     private TableColumn<Match, String> score;

//     @FXML
//     private TableColumn<Team, String> team1;

//     @FXML
//     private TableColumn<Team, String> team2;

//     @FXML
//     private Button playG;

//     @FXML
//     private TextField field1;

//     @FXML
//     private TextField field2;

//     @FXML
//     private Label labelScore1;

//     @FXML
//     private Label labelScore2;

//     @FXML
//     private Button done;

//     @FXML
//     private AnchorPane header;

//     @FXML
//     private Button homeButton;
    
//     // ObservableList<Team> teams3 = FXCollections.observableArrayList(
//     //     new Team("Team 1"),
//     //     new Team("Team 2"),
//     //     new Team("Team 3"),
//     //     new Team("Team 4"),
//     //     new Team("Team 1")
//     // );
//     @FXML
//     public void initialize(URL arg0, ResourceBundle arg1) {
//         team.setCellValueFactory(new PropertyValueFactory<Team, String>("name"));
//         wins.setCellValueFactory(new PropertyValueFactory<Team, Integer>("wins"));
//         losses.setCellValueFactory(new PropertyValueFactory<Team, Integer>("losses"));
//         points.setCellValueFactory(new PropertyValueFactory<Team, Integer>("points"));
        
//         // mainRoundRobin.setItems(teams3);
//         // Initialize teams and matches
//         teams = new ArrayList<>();
//         matches = new ArrayList<>();
//         currentRound = 1;
        
//         // Add teams to list
//         teams.add(new Team("Team 1"));
//         teams.add(new Team("Team 2"));
//         teams.add(new Team("Team 3"));
//         teams.add(new Team("Team 4"));
//         teams.add(new Team("Team 4"));
//         teams.add(new Team("Team 5"));
//         teams.add(new Team("Team 6"));
//         teams.add(new Team("Team 7"));
//         teams.add(new Team("Team 8"));
//         // Add more teams as needed
//         matches.add(currentRound, getCurrentMatch());
//         // Generate initial matches
//         generateMatches();
    
//         // Set up mainRoundRobin table view
    
//         mainRoundRobin.setItems(FXCollections.observableArrayList(teams));
    
//         match.setCellValueFactory(cellData -> {
//             Match match = cellData.getValue();
//             Team team1 = match.getTeam1();
//             Team team2 = match.getTeam2();
//             String matchString = team1.getName() + " vs. " + team2.getName();
//             return new SimpleStringProperty(matchString);
//         });
    
//         score.setCellValueFactory(cellData -> {
//             Match match = cellData.getValue();
//             int team1Score = match.getTeam1Score();
//             int team2Score = match.getTeam2Score();
//             String scoreString = team1Score + " - " + team2Score;
//             return new SimpleStringProperty(scoreString);
//         });
    
//         round.setItems(FXCollections.observableArrayList(matches));
//         }
    
//         // Update UI with current standings
//         @FXML
//         public void updateTableViews() {
//             // Update mainRoundRobin table view
//             mainRoundRobin.setItems(FXCollections.observableArrayList(teams));
        
//             // Update round table view
//             round.setItems(FXCollections.observableArrayList(matches));
//         }
   
//         @FXML
//         public void pointCalc(Match match, int team1Score, int team2Score) {

//             match.setTeam1Score(team1Score); 
//             match.setTeam2Score(team2Score);
            
//             // Update team records
//             if (team1Score > team2Score) {
//                 match.getTeam1().addWin();
//                 match.getTeam2().addLoss();
 
//             } else if (team2Score > team1Score) {
//                 match.getTeam2().addWin();
//                 match.getTeam1().addLoss();
         
//             } else {
//                 // Draw
           
//             }
            
//             // Update table views
//             updateTableViews();
//         }


//         public Match getNextMatch() {
//             for (Match match : matches) {
//                 if (match.getTeam1Score() == -1 && match.getTeam2Score() == -1) {
//                     return match;
//                 }
//             }
//             return null;
//         }
        
//         // public List<Match> getNextRound() {
//         //     List<Match> nextRoundMatches = new ArrayList<>();
//         //     List<Team> availableTeams = new ArrayList<>(teams);
            
//         //     // Get matches for the current round
//         //     for (Match match : matches) {
//         //         if (match.getRound() == currentRound) {
//         //             nextRoundMatches.add(match);
//         //             availableTeams.remove(match.getTeam1());
//         //             availableTeams.remove(match.getTeam2());
//         //         }
//         //     }
            
//         //     // Generate matches for the next round
//         //     int numTeams = availableTeams.size();
//         //     for (int i = 0; i < numTeams - 1; i++) {
//         //         for (int j = i + 1; j < numTeams; j++) {
//         //             Match match = new Match(availableTeams.get(i), availableTeams.get(j));
//         //             nextRoundMatches.add(match);
//         //             matches.add(match);
//         //         }
//         //     }
            
//         //     currentRound++;
//         //     return nextRoundMatches;
//         // }

//         // private void generateMatches() {
//         //     matches.clear();
//         //     int numTeams = teams.size();
//         //     int numMatchesPerRound = numTeams / 2;
//         //     int numRounds = numTeams - 1;
    
//         //     for (int round = 1; round <= numRounds; round++) {
//         //         for (int i = 0; i < numMatchesPerRound; i++) {
//         //             int j = (numTeams - 1) - i;
//         //             Team team1 = teams.get(i);
//         //             Team team2 = teams.get(j);
//         //             matches.add(new Match(team1, team2, round));
//         //         }
//         //         // Rotate teams
//         //         Team temp = teams.get(1);
//         //         for (int i = 1; i < numTeams - 1; i++) {
//         //             teams.set(i, teams.get(i + 1));
//         //         }
//         //         teams.set(numTeams - 1, temp);
//         //     }
//         // }

//         private void generateMatches() {
//             matches.clear();
        
//             // Create a copy of the teams list
//             ArrayList<Team> teamsCopy = new ArrayList<>(teams);
        
//             // Add a bye team if the number of teams is odd
//             if (teamsCopy.size() % 2 == 1) {
//                 teamsCopy.add(new Team("Bye"));
//             }
        
//             // Shuffle the teams
//             Collections.shuffle(teamsCopy);
        
//             // Split the teams into two halves
//             List<Team> teams1 = teamsCopy.subList(0, teamsCopy.size() / 2);
//             List<Team> teams2 = teamsCopy.subList(teamsCopy.size() / 2, teamsCopy.size());
        
//             // Generate matches for each round
//             for (int i = 0; i < teamsCopy.size() - 1; i++) {
//                 for (int j = 0; j < teams1.size(); j++) {
//                     Match match = new Match(teams1.get(j), teams2.get(j));
//                     matches.add(match);
//                 }
        
//                 // Rotate the teams in the second half
//                 Collections.rotate(teams2, 1);
//             }
//         }
        
//         public int getCurrentRound() {
//             return currentRound;
//         }

//         public Match getCurrentMatch() {
//             for (Match match : matches) {
//                 if (!match.isPlayed()) {
//                     return match;
//                 }
//             }
//             return null;
//         }
        
//         public List<Team> getCurrentTeams() {
//             List<Team> currentTeams = new ArrayList<>();
//             if (getCurrentMatch() != null) {
//                 currentTeams.add(getCurrentMatch().getTeam1());
//                 currentTeams.add(getCurrentMatch().getTeam2());
//             }
//             return currentTeams;
//         }
        
//         public List<Team> getSortedTeams() {
//             List<Team> sortedTeams = new ArrayList<>(teams);
//             sortedTeams.sort(Comparator.comparing(Team::getPoints).thenComparing(Team::getWins).reversed().thenComparing(Team::getLosses));
//             return sortedTeams;
//         }
        
//         public boolean isTournamentComplete() {
//             int totalMatches = (teams.size() * (teams.size() - 1)) / 2;
//             return matches.size() == totalMatches && isRoundComplete();
//         }
        
//         public boolean isRoundComplete() {
//             for (Match match : matches) {
//                 if (!match.isPlayed()) {
//                     return false;
//                 }
//             }
//             return true;
//         }

        
//         @FXML
// public void handleDoneButton(ActionEvent event) {
//     Match match = getNextMatch();
//     if (match == null) {
//         // All matches have been played, show final standings
//         // ...
//     } else {
//         int team1Score = Integer.parseInt(field1.getText());
//         int team2Score = Integer.parseInt(field2.getText());
//         pointCalc(match, team1Score, team2Score);
//         field1.setText("");
//         field2.setText("");
     
//     }
// }
//     }

// }
    
