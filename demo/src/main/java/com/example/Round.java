package com.example;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private final List<Team> teams;
    private final int numberOfRounds;
    private final List<MatchR> matches;

    public Round(List<Team> teams, int numberOfRounds) {
        this.teams = teams;
        this.numberOfRounds = numberOfRounds;
        this.matches = createMatches();
    }

    public List<MatchR> getMatches() {
        return matches;
    }

    private List<MatchR> createMatches() {
        int numberOfTeams = teams.size();
        int totalMatches = (numberOfTeams - 1) * 2;
        int matchesPerRound = (int) Math.ceil((double) totalMatches / numberOfRounds);

        List<MatchR> matches = new ArrayList<>();
        for (int round = 1; round <= numberOfRounds; round++) {
            for (int matchNumber = 1; matchNumber <= matchesPerRound; matchNumber++) {
                int team1Index = (round + matchNumber - 2) % (numberOfTeams - 1);
                int team2Index = (numberOfTeams - 1 - matchNumber + round) % (numberOfTeams - 1);
                if (matchNumber == matchesPerRound) {
                    int temp = team1Index;
                    team1Index = team2Index;
                    team2Index = temp + 1;
                }
                matches.add(new MatchR(teams.get(team1Index), teams.get(team2Index)));
            }
        }

        return matches;
    }
}