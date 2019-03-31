package com.pm;

import java.util.Scanner;

class Main {
	public static void clearScreen() {System.out.print("\033[H\033[2J"); System.out.flush();}
	public static void main(String[] args) {
		char c;
		String[] cmd;
		Scanner sc = new Scanner(System.in);
		
		Tabla T = new Tabla();
		T.init();
		
		//FŐCIKLUS -----------------------
		while (true) {
			clearScreen();
			System.out.print(Szinek.PURPLE +"\tXiangqi\n\n");
			T.kiir();
			cmd = sc.nextLine().trim().split("\\s"); if (cmd[0].equals("exit")) {break;}
			try {
				Jatekmenet.parancs(cmd, T);
			} catch (Exception e) {
				System.out.println("Hiba:" + e.getMessage());
				sc.nextLine();
			}
			Mi.lep(T);
		}
	}
}