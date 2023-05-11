package com.example;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Team {
    
       private String name;
    private int wins;
    private int losses;
    private int points;

    public Team(String name) {
        this.name = name;
        this.wins = 0;
        this.losses = 0;
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addWin() {
        this.wins++;
        this.points += 3;
    }

    public void addLoss() {
        this.losses++;
        this.points -= 3;
    }


    // public String getName() {
    //     return name.get();
    // }

    // public int getWins() {
    //     return wins.get();
    // }

    // public int getLosses() {
    //     return losses.get();
    // }

    // public int getPoints() {
    //     return points.get();
    // }

    // public void addWin() {
    //     wins.set(wins.get() + 1);
    //     points.set(points.get() + 3);
    // }

    // public void addLoss() {
    //     losses.set(losses.get() + 1);
    //     points.set(points.get() - 3);
    // }

    // public void addPoints(int points) {
    //     this.points.set(this.points.get() + points);
    // }

    // public void reset() {
    //     wins.set(0);
    //     losses.set(0);
    //     points.set(0);
    // }

    // public String toString() {
    //     return String.format("%-20s %-10s %-10s %-10s", name.get(), wins.get(), losses.get(), points.get());
    // }

    // public StringProperty nameProperty() {
    //     return name;
    // }

    // public IntegerProperty winsProperty() {
    //     return wins;
    // }

    // public IntegerProperty lossesProperty() {
    //     return losses;
    // }

    // public IntegerProperty pointsProperty() {
    //     return points;
    // }


// public class Team {
//     private String name;
//     private int wins;
//     private int losses;
//     private int points;

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public int getWins() {
//         return wins;
//     }

//     public void setWins(int wins) {
//         this.wins = wins;
//     }

//     public int getLosses() {
//         return losses;
//     }

//     public void setLosses(int losses) {
//         this.losses = losses;
//     }

//     public int getPoints() {
//         return points;
//     }

//     public void setPoints(int points) {
//         this.points = points;
//     }

//     public StringProperty nameProperty() {
//         return new SimpleStringProperty(this.name);
//     }

//     public IntegerProperty winsProperty() {
//         return new SimpleIntegerProperty(this.wins);
//     }

//     public IntegerProperty lossesProperty() {
//         return new SimpleIntegerProperty(this.losses);
//     }

//     public IntegerProperty pointsProperty() {
//         return new SimpleIntegerProperty(this.points);
//     }
}



