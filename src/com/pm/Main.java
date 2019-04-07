package com.pm;

import java.util.Scanner;
import java.io.*;
import java.util.*;

class Main {
	public static void clearScreen() {System.out.print("\033[H\033[2J"); System.out.flush();}
	private static ArrayList<String> readFile(String filename)
	{
		ArrayList<String> records = new ArrayList<String>();
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null)
			{
				records.add(line);
			}
			reader.close();
			return records;
		}
		catch (Exception e)
		{
			System.err.format("Exception occurred trying to read '%s'.", filename);
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) {
		char c;
		String[] cmd = new String[4];
		Scanner sc = new Scanner(System.in);

		String filepath = "";
		ArrayList<String> in = new ArrayList<String>();

		if (args.length == 1) {
			filepath = args[0];
			in = readFile(filepath);
		}

		ListIterator<String> iter = in.listIterator();

		Tabla T = new Tabla();
		T.init();
		
		//FŐCIKLUS -----------------------
		while (true) {
			clearScreen();
			System.out.print(Szinek.PURPLE +"\tXiangqi\n\n");
			T.kiir();
			if (filepath == "") { cmd = sc.nextLine().trim().split("\\s"); }
			else {if (iter.hasNext()) { cmd = iter.next().trim().split("\\s"); } }

			if (cmd[0].equals("exit")) {break;}
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