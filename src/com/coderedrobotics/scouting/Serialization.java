package com.coderedrobotics.scouting;

import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.io.File;

public class Serialization implements Serializable {

    public static void writeMemory(Competition teams) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("teams");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

        objectOut.writeObject(teams);
    }

    public static Competition readMemoryIn() throws IOException, ClassNotFoundException {
        int count = 0;
        do {
            try {
                FileInputStream fileIn = new FileInputStream("teams");
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                Competition teams = (Competition) objectIn.readObject();
                return teams;
            } catch (FileNotFoundException e) {
                System.out.println("Could not find file...");
                System.out.println("Creating File...");
                File file = new File("teams");
                System.out.println("Attepting again...");
//            readMemoryIn(); Ethan this will recurse infinitely... no.
            }
            count++;
        } while (count < 5);
        return null;
    }
}
