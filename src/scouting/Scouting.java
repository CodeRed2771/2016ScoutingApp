package scouting;

import java.io.IOException;
import java.io.Serializable;
public class Scouting  implements Serializable{
    private static Competition teams;
    private static Serialization ser;
    private static Team team;
    public static void main(String[] args) throws IOException, ClassNotFoundException{
    //this is just here for calling methods from other classes. 
    
    
    //de-serialize the singleton
    //if it's first time running (instance is null), either use an if statement
    //or just make it something not null, and then reset it. meh.
    try{
        teams.setInstance(ser.readMemoryIn());
    }
    catch(NullPointerException e){
        System.out.println("There's nothing in the file!");
        System.out.println("Add something to the file");
    }
    
    
    team = new Team("2771");
    //do stuff
    
    try{
        team.addToScore(245);//if you keep running this program, if it works right this score should add by 245 every time
        
        System.out.println(team.getScore());
        
        teams.addTeams("2771",team);
    }
    catch(NullPointerException e){
        System.out.println("No Score to add to...");
        System.out.println("Setting score to 0");
        team.setScore(0);
    }
    //somehow this is managing to do both. is it because the vairable is private? --nope
    
    
    
    
    
    
    //re-serialize
    ser.writeMemory(teams);
    }
}
