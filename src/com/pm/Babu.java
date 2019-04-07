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
	public abstract boolean lephet(Mezo honnan, Mezo hova, Babu cel, Tabla T);
}

class Ures extends Tipus {
	public Ures() {super("üres",'O');}
	public boolean lephet(Mezo honnan, Mezo hova, Babu cel, Tabla T) {return false;}
	public boolean lephet() {return false;}
}

class Gyalog extends Tipus {
	public Gyalog() {super("gyalog",'G');}
	public boolean lephet(Mezo honnan, Mezo hova, Babu cel, Tabla T) {
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
	public boolean lephet(Mezo honnan, Mezo hova, Babu cel, Tabla T) {
		if (Mezo.mezotav(honnan, hova) == 1) {
			if (hova.y <= 2 && hova.x >= 3 && hova.x <= 5) {return true;}
		}
		return false;
	}
}

class Testor extends Tipus {
	public Testor() {super("testőr", 'T');}
	public boolean lephet(Mezo honnan, Mezo hova, Babu cel, Tabla T) {
		if (Mezo.mezotav(honnan, hova) == 2) {
			if (Math.abs(honnan.x - hova.x) == 1 && Math.abs(honnan.y - hova.y) == 1 && Mezo.kastelyban(hova)) {
				return true;
			}
		}
		return false;
	}
}

class Elefant extends Tipus {
	public Elefant() {super("elefánt", 'E');}
	public boolean lephet(Mezo honnan, Mezo hova, Babu cel, Tabla T) {
		if (hova.y < 5) {
			if (Math.abs(honnan.x - hova.x) == 2 && Math.abs(honnan.y - hova.y) == 2) {return true;}
		}
		return false;
	}
}

class Huszar extends Tipus {
	public Huszar() {super("huszár", 'H');}
	public boolean lephet(Mezo honnan, Mezo hova, Babu cel, Tabla T) {return false;}
}

class Bastya extends Tipus {
	public Bastya() {super("bástya", 'B');}
	public boolean lephet(Mezo honnan, Mezo hova, Babu cel, Tabla T) {
		if (Math.abs(honnan.x - hova.x) == 0) {
			if (honnan.y < hova.y) {
				for (int i = honnan.y + 1; i != hova.y; i++) {
					if (!T.getTabla()[i][hova.x].getTipus().getID().equals("O")) {
						return false;
					}
				}
			}
			else {
				for (int i = honnan.y - 1; i > hova.y; i--) {
					if (!T.getTabla()[i][hova.x].getTipus().getID().equals("O")) {
						return false;
					}
				}
			}
		}
		if (Math.abs(honnan.y - hova.y) == 0) {
			if (honnan.x < hova.x) {
				for (int i = honnan.x + 1; i < hova.x; i++) {
					if (!T.getTabla()[hova.y][i].getTipus().getID().equals("O")) {
						return false;
					}
				}
			}
			else {
				for (int i = honnan.x - 1; i > hova.x; i--) {
					if (!T.getTabla()[hova.y][i].getTipus().getID().equals("O")) {
						return false;
					}
				}
			}
		}
		if (Math.abs(honnan.x - hova.x) == 0 || Math.abs(honnan.y - hova.y) == 0) {return true;}
		return false;
	}
}

class Agyu extends Tipus {
	public Agyu() {super("ágyú", 'A');}
	public boolean lephet(Mezo honnan, Mezo hova, Babu cel, Tabla T) {
		if (!cel.getTipus().getID().equals("O")) {
			if (Math.abs(honnan.x - hova.x) == 0) {
				if (honnan.y < hova.y) {
					for (int i = honnan.y + 1; i < hova.y; i++) {
						if (!T.getTabla()[i][hova.x].getTipus().getID().equals("O")) {
							return true;
						}
					}
				}
				else {
					for (int i = honnan.y - 1; i > hova.y; i--) {
						if (!T.getTabla()[i][hova.x].getTipus().getID().equals("O")) {
							return true;
						}
					}
				}
			}
			if (Math.abs(honnan.y - hova.y) == 0) {
				if (honnan.x < hova.x) {
					for (int i = honnan.x + 1; i < hova.x; i++) {
						if (!T.getTabla()[hova.y][i].getTipus().getID().equals("O")) {
							return true;
						}
					}
				} else {
					for (int i = honnan.x - 1; i > hova.x; i--) {
						if (!T.getTabla()[hova.y][i].getTipus().getID().equals("O")) {
							return true;
						}
					}
				}
			}
		}
		else {if (Math.abs(honnan.x - hova.x) == 0 || Math.abs(honnan.y - hova.y) == 0) {return true;} }
		return false;
	}
}