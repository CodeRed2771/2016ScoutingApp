package com.coderedrobotics.scouting;

import java.io.Serializable;
import java.util.HashMap;

public class Competition implements Serializable {

    private HashMap<Integer, Team> teams;
    private static Competition instance;

    //this is just to make a list of what teams exist
    private Competition() {
        teams = new HashMap<>();
    }

    public static Competition getInstance() {
        if (instance == null) {
            instance = new Competition();
        }
        return instance;
    }

    public static void setInstance(Competition instance) {
        Competition.instance = instance;
    }

    public boolean teamExists(int number) {
        return teams.containsKey(number);
    }

    public Team getTeam(int number) {
        if (!teams.containsKey(number)) {
            teams.put(number, new Team(number));
        }
        return teams.get(number);
    }
}
