package com.pm;

import java.util.Scanner;
import javax.swing.text.html.parser.*;
import java.io.*;

class Babu implements Serializable {
	public Tipus tipus;
	private int x, y;
	private boolean jatekos;
	public Babu(Tipus t, boolean p) {tipus = t; jatekos = p;}
	public Babu() {tipus = new Ures(); jatekos = true;}
	public boolean getJatekos() {return jatekos;}
	public void setJatekos(Boolean b) {jatekos = b;}
	public Tipus getTipus() {return tipus;}
	public String toString() {return tipus.getID();}
}

abstract class Tipus implements Serializable {
	private String name;
	private char id;
	public Tipus(String name, char id) {this.name = name; this.id = id;}
	//public Tipus() {id = 'G';}
	public String getName() {return name;}
	public String getID() {return String.valueOf(id);}
	abstract public boolean lephet(Mezo honnan, Mezo hova, Babu cel);
}

class Ures extends Tipus {
	public Ures() {super("üres",'O');}
	public boolean lephet(Mezo honnan, Mezo hova, Babu cel) {return false;}
	public boolean lephet() {return false;}
}

class Gyalog extends Tipus {
	public Gyalog() {super("gyalog",'G');}
	public boolean lephet(Mezo honnan, Mezo hova, Babu cel) {
		if (Mezo.mezotav(honnan,hova) == 1) {					//csak 1-et haladhat a táblán
			if (honnan.y >= 5 && hova.y >= honnan.y) {			//áthaladt a folyón
				return true;
			}
			else {
				if (hova.y > honnan.y) {return true;} 			//nem haladt át a folyón, csak előre mehet
			}
		}
		return false;
	}
}

class Generalis extends Tipus {
	public Generalis() {super("generális",'K');}
	public boolean lephet(Mezo honnan, Mezo hova, Babu cel) {return false;}
}

class Testor extends Tipus {
	public Testor() {super("testőr", 'T');}
	public boolean lephet(Mezo honnan, Mezo hova, Babu cel) {return false;}
}

class Elefant extends Tipus {
	public Elefant() {super("elefánt", 'E');}
	public boolean lephet(Mezo honnan, Mezo hova, Babu cel) {return false;}
}

class Huszar extends Tipus {
	public Huszar() {super("huszár", 'H');}
	public boolean lephet(Mezo honnan, Mezo hova, Babu cel) {return false;}
}

class Bastya extends Tipus {
	public Bastya() {super("bástya", 'B');}
	public boolean lephet(Mezo honnan, Mezo hova, Babu cel) {return false;}
}

class Agyu extends Tipus {
	public Agyu() {super("ágyú", 'A');}
	public boolean lephet(Mezo honnan, Mezo hova, Babu cel) {return false;}
}