package scouting;

import java.util.HashMap;
import java.io.IOException;
public class Competition {

    private HashMap<Integer, Team> teams;
    private static Competition singleton = new Competition();
    //this is just to make a list of what teams exist
    private Competition() {
        teams = new HashMap<>();
    }
    public static Competition getInstance(){
        return singleton;
    }
    public void setInstance(Competition teams){
        singleton = teams;
    }
    
    private boolean checkTeams(String team) {
        int toCheck = convert(team);
        return teams.containsValue(toCheck);
    }

    public void addTeams(String name, Team team) {
        if (checkTeams(name) == false) {
            teams.put(convert(name), team);
        }
    }

    public Team getTeam(String name) {
        //containsKey--why aren't we using this????
        if (!checkTeams(name)) {
            teams.put(convert(name), new Team(name));
        }
        return teams.get(convert(name));
    }

    //convert string to int
    private int convert(String id) {
        return Integer.parseInt(id);
    }
//
//    public void serializeCompetition() throws IOException{
//        Serialization ser = new Serialization();
//        Competition comp = getInstance();
//        comp.writeMemory();
//    }
//     public void deSerializeCompetition() throws IOException{
//         Serialization ser = new Serialization();
//         ser.
//     } --looks like I don't need this
    
    
}
