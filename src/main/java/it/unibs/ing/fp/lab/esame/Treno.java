package it.unibs.ing.fp.lab.esame;

import java.util.LinkedList;

import it.unibs.ing.fp.mylib.EstrazioniCasuali;

/**
 * 
 * prototipo di treno
 * 
 * @author Samuele
 *
 */

public class Treno {

	private final static int MIN_ID = 0;
	private final static int MAX_ID = 1000;
	private String id;
	private Vagone motrice;
	private LinkedList<Vagone> vagoni = new LinkedList<Vagone>();
	
	private double lunghezzaTotale;
	private double pesoTotale;
	private double caricoMax;
	private int passeggeriMax;
	
	public Treno(Vagone nuovo) {
		this.motrice = nuovo;
		StringBuffer str = new StringBuffer();
		str.append('T');
		str.append(EstrazioniCasuali.estraiIntero(MIN_ID, MAX_ID));
		this.id = str.toString();
	}
	
	/**
	 * Metodo che permette di aggiungere un vagone al treno
	 * @param nuovo vagone da aggiungere
	 */
	
	public void aggiungiVagone(Vagone nuovo) {
		vagoni.add(nuovo);
		aggiornaLunghezza(nuovo.getLunghezza());
		aggiornaPeso(nuovo.getPeso());	
		if(nuovo instanceof VagonePasseggeri)
			aggiornaPasseggeriMax(((VagonePasseggeri) nuovo).getPosti());
		else if(nuovo instanceof VagoneMerci)
			aggiornaCaricoMax(((VagoneMerci) nuovo).getCaricoTrasportabile());
		else
			return;
	}
	
	private void aggiornaPasseggeriMax(int passeggeriNuovoVagone) {
		passeggeriMax += passeggeriNuovoVagone;
	}
	
	private void aggiornaCaricoMax(double caricoNuovoVagone) {
		caricoMax += caricoNuovoVagone;
	}
	
	private void aggiornaPeso(double daAggiungere) {
		pesoTotale += daAggiungere;
	}
	
	private void aggiornaLunghezza(double daAggiungere) {
		lunghezzaTotale += daAggiungere;
    }
	
	///////////////////////////////////////////////////////////
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Vagone getMotrice() {
		return motrice;
	}
	public void setMotrice(Vagone motrice) {
		this.motrice = motrice;
	}
	public LinkedList<Vagone> getVagoni() {
		return vagoni;
	}
	public void setVagoni(LinkedList<Vagone> vagoni) {
		this.vagoni = vagoni;
	}
	public double getLunghezzaTotale() {
		return lunghezzaTotale;
	}
	public void setLunghezzaTotale(double lunghezzaTotale) {
		this.lunghezzaTotale = lunghezzaTotale;
	}
	public double getPesoTotale() {
		return pesoTotale;
	}
	public void setPesoTotale(double pesoTotale) {
		this.pesoTotale = pesoTotale;
	}
	public double getCaricoMax() {
		return caricoMax;
	}
	public void setCaricoMax(double caricoMax) {
		this.caricoMax = caricoMax;
	}
	public double getPasseggeriMax() {
		return passeggeriMax;
	}
	public void setPasseggeriMax(int passeggeriMax) {
		this.passeggeriMax = passeggeriMax;
	}
	
}
