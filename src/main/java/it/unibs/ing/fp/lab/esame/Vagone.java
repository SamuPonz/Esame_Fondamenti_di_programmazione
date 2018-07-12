package it.unibs.ing.fp.lab.esame;

import it.unibs.ing.fp.mylib.EstrazioniCasuali;

public class Vagone {

	private final static int MIN_ID = 0;
	private final static int MAX_ID = 1000;
	private String id;
	private double lunghezza;
	private double peso;
	
	public Vagone(boolean motrice, double lunghezza, double peso) {
		StringBuffer str = new StringBuffer();
		this.lunghezza = lunghezza;
		this.peso  = peso;
		if(motrice)
			str.append('M');
		else
			str.append('V');
		str.append(EstrazioniCasuali.estraiIntero(MIN_ID, MAX_ID));
		this.id = str.toString();
	}
	
	//////////////////////////////////////////////////////
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getLunghezza() {
		return lunghezza;
	}
	public void setLunghezza(double lunghezza) {
		this.lunghezza = lunghezza;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
}
