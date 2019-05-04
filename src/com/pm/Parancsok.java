package com.pm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface Parancsok {
    void execute(String[] cmd);
}

class Exit implements Parancsok {
    public void execute(String[] cmd) {
        System.exit(0);
    }
}

class Mentes implements Parancsok {
    public void execute(String[] cmd) {
        try {
            FileOutputStream fileOut = new FileOutputStream("mentes.sav");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(Main.T);
            objectOut.close();
            fileOut.close();
            System.out.println("Mentés sikeres.");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}

class Betolt implements Parancsok {
    public void execute(String[] cmd) {
        try {
            FileInputStream fileIn = new FileInputStream("mentes.sav");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Tabla tmp = (Tabla)objectIn.readObject();
            objectIn.close();
            fileIn.close();
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 9; j++) {
                    Main.T.setBabu(j, i, tmp.getBabu(j, i));
                }
            }
            System.out.println("Betöltés sikeres.");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}

class Delay implements Parancsok {
    public void execute(String[] cmd) {
        int param = Integer.parseInt(cmd[1]);
        if ((param <= 10) && (param >= 1)) { Main.delay = param * 100; }
        else { Main.delay = 100; }
    }
}

class Play implements Parancsok {
    public void execute(String[] cmd) {
    }
}


