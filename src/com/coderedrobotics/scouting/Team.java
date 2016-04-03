package com.coderedrobotics.scouting;

import java.io.Serializable;

public class Team implements Serializable {

    private final int number;

    // CONTROL
    private int disposition = 2; // scale from 1-3;
    private boolean broken;
    private boolean doesntFollowRules;
    private int rankingFudge;
    private int manualRankOverride;

    // DEFENSES
    private boolean chivalDeFrise;
    private boolean portcullis;
    private boolean sallyPort;
    private boolean drawBridge;
    private boolean roughTerrain;
    private boolean rockWall;
    private boolean moat;
    private boolean ramparts;
    private boolean lowBar;

    // TOWER
    private int climbingScore;
    private int climbingSpeed;
    private int highGoalScore;
    private boolean lowGoal;
    private boolean challenge;

    // AUTO
    private boolean autoChivalDeFrise;
    private boolean autoPortcullis;
    private boolean autoSallyPort;
    private boolean autoDrawbridge;
    private boolean autoRoughTerrain;
    private boolean autoRockWall;
    private boolean autoMoat;
    private boolean autoRamparts;
    private boolean autoLowbar;
    private boolean autoReach;
    private boolean autoLowGoal;
    private boolean autoHighGoal;

    private String notes;

    public Team(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    //get defenses it can pass (this can a whole array for comparison)
    public boolean[] canPass() {
        boolean[] defensesCanPass = {chivalDeFrise, portcullis, sallyPort, drawBridge,
            roughTerrain, rockWall, moat, ramparts, lowBar};
        return defensesCanPass;
    }

    public boolean canChivalDeFrise() {
        return chivalDeFrise;
    }

    public void setChivalDeFrise(boolean chivalDeFrise) {
        this.chivalDeFrise = chivalDeFrise;
    }

    public boolean canPortcullis() {
        return portcullis;
    }

    public void setPortcullis(boolean portcullis) {
        this.portcullis = portcullis;
    }

    public boolean canSallyPort() {
        return sallyPort;
    }

    public void setSallyPort(boolean sallyPort) {
        this.sallyPort = sallyPort;
    }

    public boolean canDrawBridge() {
        return drawBridge;
    }

    public void setDrawBridge(boolean drawBridge) {
        this.drawBridge = drawBridge;
    }

    public boolean canRoughTerrain() {
        return roughTerrain;
    }

    public void setRoughTerrain(boolean roughTerrain) {
        this.roughTerrain = roughTerrain;
    }

    public boolean canRockWall() {
        return rockWall;
    }

    public void setRockWall(boolean rockWall) {
        this.rockWall = rockWall;
    }

    public boolean canMoat() {
        return moat;
    }

    public void setMoat(boolean moat) {
        this.moat = moat;
    }

    public boolean canRamparts() {
        return ramparts;
    }

    public void setRamparts(boolean ramparts) {
        this.ramparts = ramparts;
    }

    public boolean canLowBar() {
        return lowBar;
    }

    public void setLowBar(boolean lowBar) {
        this.lowBar = lowBar;
    }

    public int getClimbingScore() {
        return climbingScore;
    }

    public void setClimbingScore(int climbingScore) {
        this.climbingScore = climbingScore;
    }

    public int getClimbingSpeed() {
        return climbingSpeed;
    }

    public void setClimbingSpeed(int climbingSpeed) {
        this.climbingSpeed = climbingSpeed;
    }

    public int getHighGoalScore() {
        return highGoalScore;
    }

    public void setHighGoalScore(int highGoalScore) {
        this.highGoalScore = highGoalScore;
    }

    public boolean canLowGoal() {
        return lowGoal;
    }

    public void setLowGoal(boolean lowGoal) {
        this.lowGoal = lowGoal;
    }

    public boolean canChallenge() {
        return challenge;
    }

    public void setChallenge(boolean challenge) {
        this.challenge = challenge;
    }

    public boolean canAutoChivalDeFrise() {
        return autoChivalDeFrise;
    }

    public void setAutoChivalDeFrise(boolean autoChivalDeFrise) {
        this.autoChivalDeFrise = autoChivalDeFrise;
    }

    public boolean canAutoPortcullis() {
        return autoPortcullis;
    }

    public void setAutoPortcullis(boolean autoPortcullis) {
        this.autoPortcullis = autoPortcullis;
    }

    public boolean canAutoSallyPort() {
        return autoSallyPort;
    }

    public void setAutoSallyPort(boolean autoSallyPort) {
        this.autoSallyPort = autoSallyPort;
    }

    public boolean canAutoDrawbridge() {
        return autoDrawbridge;
    }

    public void setAutoDrawbridge(boolean autoDrawbridge) {
        this.autoDrawbridge = autoDrawbridge;
    }

    public boolean canAutoRoughTerrain() {
        return autoRoughTerrain;
    }

    public void setAutoRoughTerrain(boolean autoRoughTerrain) {
        this.autoRoughTerrain = autoRoughTerrain;
    }

    public boolean canAutoRockWall() {
        return autoRockWall;
    }

    public void setAutoRockWall(boolean autoRockWall) {
        this.autoRockWall = autoRockWall;
    }

    public boolean canAutoMoat() {
        return autoMoat;
    }

    public void setAutoMoat(boolean autoMoat) {
        this.autoMoat = autoMoat;
    }

    public boolean canAutoRamparts() {
        return autoRamparts;
    }

    public void setAutoRamparts(boolean autoRamparts) {
        this.autoRamparts = autoRamparts;
    }

    public boolean canAutoLowbar() {
        return autoLowbar;
    }

    public void setAutoLowbar(boolean autoLowbar) {
        this.autoLowbar = autoLowbar;
    }

    public boolean canAutoReach() {
        return autoReach;
    }

    public void setAutoReach(boolean autoReach) {
        this.autoReach = autoReach;
    }

    public boolean canAutoLowGoal() {
        return autoLowGoal;
    }

    public void setAutoLowGoal(boolean autoLowGoal) {
        this.autoLowGoal = autoLowGoal;
    }

    public boolean canAutoHighGoal() {
        return autoHighGoal;
    }

    public void setAutoHighGoal(boolean autoHighGoal) {
        this.autoHighGoal = autoHighGoal;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getDisposition() {
        return disposition;
    }

    public void setDisposition(int disposition) {
        this.disposition = disposition;
    }

    public boolean isBroken() {
        return broken;
    }

    public void setBroken(boolean broken) {
        this.broken = broken;
    }

    public boolean doesntFollowRules() {
        return doesntFollowRules;
    }

    public void setDoesntFollowRules(boolean doesntFollowRules) {
        this.doesntFollowRules = doesntFollowRules;
    }

    public int getRankingFudge() {
        return rankingFudge;
    }

    public void setRankingFudge(int rankingFudge) {
        this.rankingFudge = rankingFudge;
    }

    public int getManualRankOverride() {
        return manualRankOverride;
    }

    public void setManualRankOverride(int manualRankOverride) {
        this.manualRankOverride = manualRankOverride;
    }

    //autonomous should give only 3 different values
    //if it has reached a defense, value can -1
    //if it has breached a defenese, value can 1
    //if has done neither, value can 0
    public void check(int value) {
        int v = value;
        switch (v) {
            case 1:
                System.out.println("This team can breach the defense: ");
                //someway or other this will tell you which defense
                break;
            case -1:
                System.out.println("This team reaches the defense: ");
                //somewahy or other... well ytou get the idea
                break;
            case 0:
                break;
            default:
                System.out.println("ERROR: DOES NOT COMPUTE");
                System.out.println("PLEASE ENTER A VALUE BETWEEN -1 and 1");
                break;
        }
    }

    //autonomous hasReached, or hasPassed, returns boolean values, which otherwise inserts 0
}
