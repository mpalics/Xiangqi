package com.pm;

class Jatekmenet {
	public static void parancs(String[] cmd, Tabla x) throws Exception {
		if (cmd[0].equals("save")) {Mentes.kiment(x);}
		if (cmd[0].equals("load")) {x = Mentes.betolt();}
		int x1 = Integer.parseInt(cmd[0]);
		int y1 = Integer.parseInt(cmd[1]);
		int x2 = Integer.parseInt(cmd[2]);
		int y2 = Integer.parseInt(cmd[3]);
		Mezo honnan = new Mezo(x1,y1);
		Mezo hova = new Mezo(x2,y2);
		Babu valasztott = x.getBabu(x1, y1);
		Babu cel = x.getBabu(x2, y2);
		if (!cel.getJatekos()) {throw new HibasLepesSajatException();}
		if (!valasztott.getJatekos()) {
			if (!valasztott.getTipus().lephet(honnan, hova, cel, x)) {throw new HibasLepesException(valasztott);}
			x.setBabu(x2, y2, valasztott);
			x.setBabu(x1, y1, new Babu());
		}
	}
}

class Mezo {
	public int x;
	public int y;
	public Mezo(int x, int y) {this.x = x; this.y = y;}
	public static int mezotav(Mezo m1, Mezo m2) {
		return Math.abs(m1.x - m2.x) + Math.abs(m1.y - m2.y);
	}
	public static boolean kastelyban(Mezo m) { if (m.x > 2 && m.x < 6 && m.y < 3) {return true;} return false;}
	public static boolean atloslepes(Mezo m1, Mezo m2) {if (Math.abs(m1.x - m2.x) == 1 && Math.abs(m1.y - m2.y) == 1) {return true;} return false;}
}