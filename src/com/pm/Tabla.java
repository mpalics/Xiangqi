package com.pm;

import java.util.Scanner;
import java.util.*;
import java.io.Serializable;

class Tabla implements Serializable {
	private Babu[][] tabla = new Babu[10][9];
	public Tabla(int err) {}
	public Tabla() {
		for (int i = 0; i<10; i++) {
			for (int j = 0; j<9; j++) {
				tabla[i][j] = new Babu();
			}
		}
	}
	public void setBabu(int x, int y, Tipus t, boolean p) {
		tabla[y][x] = new Babu(t,p);
	}
	
	public void setBabu(int x, int y, Babu b) {
		tabla[y][x] = b;
	}
	
	public void setBabu(Mezo m, Babu b) {
		tabla[m.y][m.x] = b;
	}
	
	public Babu getBabu(int x, int y) {
		return tabla[y][x];
	}
	
	public Babu getBabu(Mezo m) {
			return tabla[m.x][m.y];
		}

	public Babu[][] getTabla() { return this.tabla; }
	
	public void init()
	{
		setBabu(4,0, new Generalis(), false);
		setBabu(5,0, new Testor(), false);
		setBabu(3,0, new Testor(), false);
		setBabu(2,0, new Elefant(), false);
		setBabu(6,0, new Elefant(), false);
		setBabu(7,0, new Huszar(), false);
		setBabu(1,0, new Huszar(), false);
		setBabu(0,0, new Bastya(), false);
		setBabu(8,0, new Bastya(), false);
		setBabu(1,2, new Agyu(), false);
		setBabu(7,2, new Agyu(), false);
		setBabu(0,3, new Gyalog(), false);
		setBabu(2,3, new Gyalog(), false);
		setBabu(4,3, new Gyalog(), false);
		setBabu(6,3, new Gyalog(), false);
		setBabu(8,3, new Gyalog(), false);
		
		setBabu(4,9, new Generalis(), true);
		setBabu(5,9, new Testor(), true);
		setBabu(3,9, new Testor(), true);
		setBabu(2,9, new Elefant(), true);
		setBabu(6,9, new Elefant(), true);
		setBabu(7,9, new Huszar(), true);
		setBabu(1,9, new Huszar(), true);
		setBabu(0,9, new Bastya(), true);
		setBabu(8,9, new Bastya(), true);
		setBabu(1,7, new Agyu(), true);
		setBabu(7,7, new Agyu(), true);
		setBabu(0,6, new Gyalog(), true);
		setBabu(2,6, new Gyalog(), true);
		setBabu(4,6, new Gyalog(), true);
		setBabu(6,6, new Gyalog(), true);
		setBabu(8,6, new Gyalog(), true);
	}
	
	public void kiir() {
		System.out.println(Szinek.BLUE + "   A B C D E F G H I" + Szinek.RESET);
		int n = 0;
		for (Babu[] i : tabla) {
			if (n == 5) {System.out.print(Szinek.BLUE + "\n--------------------");}
			System.out.print(Szinek.BLUE+"\n"+n+"  ");
			n++;
			for (Babu j : i) {
				System.out.print(Szinek.szinvalaszt(j)+j+" ");
			}
		}
	System.out.print("\n\n");
	}

	public void debug() {

	}
}