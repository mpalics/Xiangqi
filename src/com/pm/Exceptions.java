package com.pm;

class HibasLepesException extends Exception {
	private Babu b;
	public HibasLepesException(Babu b) {this.b = b;}
	public String getMessage() {return b.getTipus().getName()+ ": Hibás lépés!";}
}

class HibasLepesSajatException extends Exception {
	public HibasLepesSajatException() {}
	public String getMessage() {return "Saját figurát nem lehet kiütni!";}
}