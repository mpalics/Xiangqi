package com.pm;

import java.util.Scanner;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.*;

public class Mentes {
	public static void kiment(Object serObj) {
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
	
	public static Tabla betolt() {
		try {
			FileInputStream fileIn = new FileInputStream("mentes.sav");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			Tabla T = (Tabla)objectIn.readObject();
			objectIn.close();
			System.out.println("Betöltés sikeres.");
			return T;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return new Tabla(0);
	}
}