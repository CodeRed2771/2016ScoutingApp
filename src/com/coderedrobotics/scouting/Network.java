package com.coderedrobotics.scouting;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 */
public class Network {

    ServerSocket server1, server2, server3, server4, server5, server6;
    ConnectionThread connection1, connection2, connection3, connection4, connection5, connection6;

    public Network() {
        try {
            server1 = new ServerSocket(1180);
            server2 = new ServerSocket(1181);
            server3 = new ServerSocket(1182);
            server4 = new ServerSocket(1183);
            server5 = new ServerSocket(1184);
            server6 = new ServerSocket(1185);
            connection1 = new ConnectionThread(server1, 1);
            connection2 = new ConnectionThread(server2, 2);
            connection3 = new ConnectionThread(server3, 3);
            connection4 = new ConnectionThread(server4, 4);
            connection5 = new ConnectionThread(server5, 5);
            connection6 = new ConnectionThread(server6, 6);
            System.out.println("Network Ready");
        } catch (IOException ex) {
            Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void close() {
        connection1.close();
        connection2.close();
        connection3.close();
        connection4.close();
        connection5.close();
        connection6.close();
    }

    private class ConnectionThread implements Runnable {

        private ServerSocket server;
        private BufferedInputStream input;
        private BufferedOutputStream output;
        private Socket tcpConnection;
        private int tick = 0;

        public ConnectionThread(ServerSocket server, int number) {
            this.server = server;
            Thread t = new Thread(this);
            t.setName("Connection Thread " + number);
            t.setDaemon(true);
            t.start();
        }
        
        public void close() {
            try {
                input.close();
                output.close();
                tcpConnection.close();
                server.close();
            } catch (IOException ex) {
                Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        private void reconnect() {
            boolean retry = true;
            while (retry) {
                retry = false;
                try {
                    if (input != null) {//close if open
                        input.close();
                    }
                    if (output != null) {//close if open
                        output.close();
                    }
                    if (tcpConnection != null) {//close if open
                        tcpConnection.close();
                    }
                } catch (IOException ex) {
                }
                tcpConnection = null;
                while (tcpConnection == null) { //keeps trying to connect
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ConnectionThread.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                    try {
                        tcpConnection = server.accept();
                        System.out.println("Accepted");
                    } catch (IOException ex) {
                        tcpConnection = null;
                    }
                }
                //setup the reader and writer objects
                try {
                    output = new BufferedOutputStream(tcpConnection.getOutputStream());
                    input = new BufferedInputStream(tcpConnection.getInputStream());
                    tick = 0;
                } catch (IOException ex) {
                    retry = true;
                }
            }
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                }

                try {
                    output.flush();

                    if (tick == 6000) { // every minute, 1 tick = 10 millis
                        tick = 0;
                        output.write(0);
                    }
                    tick++;

                    while (input.available() > 0 || tcpConnection.getInputStream().available() > 0) {
                        byte[] buffer = new byte[4];
                        input.read(buffer, 0, 4);
                        int team = PrimitiveSerializer.bytesToInt(buffer);
                        boolean autoReach = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        boolean autoLowGoal = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        boolean autoHighGoal = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        boolean autoPortcullis = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        boolean autoChivalDeFrise = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        boolean autoMoat = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        boolean autoRamparts = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        boolean autoDrawBridge = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        boolean autoSallyPort = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        boolean autoRockWall = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        boolean autoRoughTerrain = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        boolean autoLowBar = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        boolean lowGoal = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        buffer = new byte[4];
                        input.read(buffer, 0, 4);
                        int made = PrimitiveSerializer.bytesToInt(buffer);
                        buffer = new byte[4];
                        input.read(buffer, 0, 4);
                        int missed = PrimitiveSerializer.bytesToInt(buffer);
                        boolean portcullis = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        boolean chivalDeFrise = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        boolean moat = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        boolean ramparts = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        boolean drawBridge = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        boolean sallyPort = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        boolean rockWall = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        boolean roughTerrain = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        boolean lowBar = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        boolean challenge = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        boolean attemptedScale = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        boolean successfullyScaledTower = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        buffer = new byte[4];
                        input.read(buffer, 0, 4);
                        int speed = PrimitiveSerializer.bytesToInt(buffer);
                        boolean broken = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        boolean gameRules = PrimitiveSerializer.bytesToBoolean(new byte[]{(byte) input.read()});
                        buffer = new byte[2];
                        input.read(buffer, 0, 2);
                        short length = PrimitiveSerializer.bytesToShort(buffer);
                        buffer = new byte[length];
                        input.read(buffer, 0, length);
                        String notes = PrimitiveSerializer.bytesToString(buffer);
                        Team t = Competition.getInstance().getTeam(team);
                        t.setAutoReach(t.canAutoReach() | autoReach);
                        t.setAutoLowGoal(t.canAutoLowGoal() | autoLowGoal);
                        t.setAutoHighGoal(t.canAutoHighGoal() | autoHighGoal);
                        t.setAutoPortcullis(t.canAutoPortcullis() | autoPortcullis);
                        t.setAutoChivalDeFrise(t.canAutoChivalDeFrise() | autoChivalDeFrise);
                        t.setAutoMoat(t.canAutoMoat() | autoMoat);
                        t.setAutoRamparts(t.canAutoRamparts() | autoRamparts);
                        t.setAutoDrawbridge(t.canAutoDrawbridge() | autoDrawBridge);
                        t.setAutoSallyPort(t.canAutoSallyPort() | autoSallyPort);
                        t.setAutoRockWall(t.canAutoRockWall() | autoRockWall);
                        t.setAutoRoughTerrain(t.canAutoRoughTerrain() | autoRoughTerrain);
                        t.setAutoLowbar(t.canAutoLowbar() | autoLowBar);
                        t.setLowGoal(t.canLowGoal() | lowGoal);
                        t.recalculateHighGoal(missed, made);
                        t.setPortcullis(t.canPortcullis() | portcullis);
                        t.setChivalDeFrise(t.canChivalDeFrise() | chivalDeFrise);
                        t.setMoat(t.canMoat() | moat);
                        t.setRamparts(t.canRamparts() | ramparts);
                        t.setDrawBridge(t.canDrawBridge() | drawBridge);
                        t.setSallyPort(t.canSallyPort() | sallyPort);
                        t.setRockWall(t.canRockWall() | rockWall);
                        t.setRoughTerrain(t.canRoughTerrain() | roughTerrain);
                        t.setLowBar(t.canLowBar() | lowBar);
                        t.setChallenge(t.canChallenge() | challenge);
                        t.recalculateScale(attemptedScale, successfullyScaledTower);
                        t.reaverageScaleSpeed(speed);
                        t.setBroken(t.isBroken() | broken);
                        t.setDoesntFollowRules(t.doesntFollowRules() | gameRules);
                        t.setNotes(t.getNotes() + "\n" + notes);
                    }
                } catch (IOException | NullPointerException ex) {
                    Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
                    reconnect();
                }
            }
        }
    }
}
