package com.coderedrobotics.scouting;

public class ScoutingMethods {
    //compare teams with code red (requires the use of deserializing)
    //check with three teams (alliance) for common unpassable defenese (common falsehoods)

    public void guageAlliance(Team team1, Team team2, Team team3) {
        for (int i = 0; i < 9; i++) {
            //requires each teams defense array

            //t1CantPass = getCantPass<defense[i]>
            //t2CantPass = getCantPass<defense[i]>
            //t3CantPass = getCantPass<defense[i]>
            //if(t1CantPass && t2CantPass || t1CantPass && t3CantPass || t2CantPass && t3CantPass){
            //System.out.println(this team can pass defense[i] --references a string array that has the right order of defenses
            //} **as apposed to wrong???
        }
    }

    public void gaugeAllianceAutonomous() {
        //this only checks if the team can breach the defense. 
        //why do worry about this? if they can breach it in autonomous
        //they can probably also breach it in tele-op

        //this is just stupid **why am I complaining? I'm writing the damn thing
    }

    //read in a team object
    //public Team readInTeam(String name){
    //    de-serialize Team after locating file.
    //        file should be the name + .ser
    //    return Team<name> 
    //}
    //save team Object
    //refers to Competitin for checking if the team already exists      
}
