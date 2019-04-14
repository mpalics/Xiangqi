package com.pm;

import java.util.Scanner;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.*;
public class Mentes {
	static void kiment(Object serObj) {
			try {
				FileOutputStream fileOut = new FileOutputStream("mentes.sav");
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
				objectOut.writeObject(serObj);
				objectOut.close();
				System.out.println("Mentés sikeres.");
	 
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}
	}
	
	static void betolt(Tabla x) {
		try {
			FileInputStream fileIn = new FileInputStream("mentes.sav");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			Tabla tmp = (Tabla)objectIn.readObject();
			objectIn.close();
			for (int i = 0; i<10; i++) {
				for (int j = 0; j<9; j++) {
					x.setBabu(j,i, tmp.getBabu(j,i));
				}
			}
			System.out.println("Betöltés sikeres.");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
}