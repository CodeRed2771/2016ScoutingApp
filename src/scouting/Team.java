package scouting;
public class Team {
    private String name;
    private boolean chivalDeFris, portcullis, sallyPort, drawbridge, roughTerrain,
                    rockWall, moat, ramparts, lowbar, climbing;
    private boolean hasPassed, hasReached;
    private int autoChivalDeFris, autoPortcullis, autoSallyPort, autoDrawbridge, 
                    autoRoughTerrain, autoRockWall, autoMoat, autoRamparts, autoLowbar,
                    autoShooting;
    private int shootingScore, totalScore;          
    
    public Team(String n){
        this.name = n;
    }
    
    //get name
    public String getName(){return this.name;}
    
    //get defenses it can pass (this is a whole array for comparison)
    public boolean[] canPass(){
        boolean[] defensesCanPass = {chivalDeFris, portcullis, sallyPort, drawbridge, 
            roughTerrain, rockWall, moat, ramparts, lowbar};
        return defensesCanPass;
    }
    //get totalScore// this score aspect is changed everytime the team particpates in an event
    public void addToScore(int toAdd){
        this.totalScore+= toAdd;
    }
    public int getScore(){return this.totalScore;}
    //ask for name (overwrites the name if changed)
    public void setScore(int toSet){
        this.totalScore = toSet;
    }
    public void changeName(String n){
        this.name = n;
    }
    //ask for defense (does each seperately, also get
    public void canPassChivalDeFris(boolean answer){
        this.chivalDeFris = answer;
    }
    public boolean getChivalDeFRris(){
        return this.chivalDeFris;
    }
    public void canPassPortcullis(boolean answer){
        this.portcullis = answer;
    }
    public boolean getPortcullis(){
        return this.portcullis;
    }
    public void canPassSallyPort(boolean answer){
        this.sallyPort = answer;
    }
    public boolean getSallyPort(){
        return this.sallyPort;
    }
    public void canPassDrawbridge(boolean answer){
        this.drawbridge = answer;
    }
    public boolean getDrawbridge(){
        return this.drawbridge;
    }
    public void canPassRoughTerrain(boolean answer){
        this.roughTerrain = answer;
    }
    public boolean getRoughTerrain(){
        return this.roughTerrain;
    }
    public void canPassRockWall(boolean answer){
        this.rockWall = answer;
    }
    public boolean getRockWall(){
        return this.rockWall;
    }
    public void canPassMoat(boolean answer){
        this.moat = answer;
    }
    public boolean getMoat(){
        return this.moat;
    }
    public void canPassRamparts(boolean answer){
        this.ramparts = answer;
    }
    public boolean getRamparts(){
        return this.ramparts;
    }
    public void canPassLowBar(boolean answer){
        this.lowbar = answer;
    }
    public boolean getLowBar(){
        return this.lowbar;
    }
   
    //ask climbing
    public void canClimb(boolean answer){
        this.climbing = answer;
    }
    
    //ask shootingScore
    public void scoreShooting(int s){
        this.shootingScore = s;
    }
    
    //ask autonomous, and get
    public void canPassAutoChivalDeFris(int answer){
        this.autoChivalDeFris = answer;
    }
    public int getAutoChivalDeFris(){
        return this.autoChivalDeFris;
    }
    public void canPassAutoPortcullis(int answer){
        this.autoPortcullis = answer;
    }
    public int getAutoPortcullis(){
        return this.autoPortcullis;
    }
    public void canPassAutoSallyPort(int answer){
        this.autoSallyPort = answer;
    }
    public int getAutoSallyPort(){
       return this.autoSallyPort;
    }
    public void canPassAutoDrawbridge(int answer){
        this.autoDrawbridge = answer;
    }
    public int getAutoDrawbridge(){
        return this.autoDrawbridge;
    }
    public void canPassAutoRoughTerrain(int answer){
        this.autoRoughTerrain = answer;
    }
    public int getAutoRoughTerrain(){
        return this.autoRoughTerrain;
    }
    public void canPassAutoRockWall(int answer){
        this.autoRockWall = answer;
    }
    public int getAutoRockWall(){
        return this.autoRockWall;
    }
    public void canPassAutoMoat(int answer){
        this.autoMoat = answer;
    }
    public int getAutoMoat(){
        return this.autoMoat;
    }
    public void canPassAutoRamparts(int answer){
        this.autoRamparts = answer;
    }
    public int getAutoRamparts(){
        return this.autoRamparts;
    }
    public void canPassAutoLowBar(int answer){
        this.autoLowbar = answer;
    }
    public int getAutoLowBar(){
        return this.autoLowbar;
    }
    
    //autonomous should give only 3 different values
        //if it has reached a defense, value is -1
        //if it has breached a defenese, value is 1
        //if has done neither, value is 0
    public void check(int value){
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
