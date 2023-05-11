package com.example;

public class MatchR {
    public final Team team1;
    public final Team team2;
    int team1Score;
    int team2Score;
    int round;

    public MatchR(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
       
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }
    
    public int getRound() {
        return round;
    }

    public int getTeam1Score() {
        return team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    public void setTeam1Score(int score) {
        team1Score = score;
    }

    public void setTeam2Score(int score) {
        team2Score = score;
    }

    public boolean isPlayed() {
        return team1Score != -1 && team2Score != -1;
    }

}
        // other methods
    
       
    
    
    // public class RoundR {
    //     private List<Team> teams;
    //     private List<Match> matches;
    //     private int currentRound;
    //     // other attributes and methods
    
    //     private void generateMatches() {
    //         matches.clear();
    //         int numTeams = team.size();
    //         int numMatchesPerRound = numTeams / 2;
    //         int numRounds = numTeams - 1;
    
    //         for (int round = 1; round <= numRounds; round++) {
    //             for (int i = 0; i < numMatchesPerRound; i++) {
    //                 int j = (numTeams - 1) - i;
    //                 Team team1 = teams.get(i);
    //                 Team team2 = teams.get(j);
    //                 matches.add(new Match(team1, team2, round));
    //             }
    //             // Rotate teams
    //             Team temp = teams.get(1);
    //             for (int i = 1; i < numTeams - 1; i++) {
    //                 teams.set(i, teams.get(i + 1));
    //             }
    //             teams.set(numTeams - 1, temp);
    //         }
    //     }
    
    //     // other methods
    // }
    
