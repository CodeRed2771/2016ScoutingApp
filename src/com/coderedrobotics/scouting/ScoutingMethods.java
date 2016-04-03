package com.coderedrobotics.scouting;

public class ScoutingMethods {
    //compare teams with code red (requires the use of deserializing)
    //check with three teams (alliance) for common unpassable defenese (common falsehoods)
    boolean[] td1,td2,td3;
    String[] defenses;
    public void guageAlliance(Team team1, Team team2, Team team3) {
        for (int i = 0; i < 9; i++) {
            //get defense array for each team
            td1 = team1.canPass();
            td2 = team2.canPass();
            td3 = team3.canPass();
            if((td1[i] && td2[i])==true || (td1[i] && td3[i])==true|| (td2[i] && td3[i])==true){
                System.out.println("Teams can't pass: " + defenses[i]);
            }
//            if(t1CantPass && t2CantPass || t1CantPass && t3CantPass || t2CantPass && t3CantPass){
//                System.out.println("This team can't pass: " + defense<i>); //--references a string array that has the right order of defenses
//            } //**as apposed to wrong???
        }
    }
    public void compareAlliance(Team t1, Team t2, Team t3){
        td1 = t1.canPass();
        td2 = t2.canPass();
        td3 = t3.canPass();
        System.out.println(t1.getNumber() + "" + t2.getNumber() + "" + t3.getNumber());
        for(int i = 0; i < 9; i++){
            System.out.printf("%b      %b      %b",td1[i], td2[i], td3[i]);
        }
    }
    public void chemistryRank(Team toCompare){
//        Team 2771 = teams.getTeam(2771);
        //I'll fix this later
    }//at the moment this doesn't do anything
    public void objectiveRank(){
        
    }//neither does this
    public void teamRank(){
        
    }//this just adds the ranks (after using them). cuz why not.
}
