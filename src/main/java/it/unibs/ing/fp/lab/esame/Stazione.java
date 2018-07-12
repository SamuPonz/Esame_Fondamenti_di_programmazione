 package it.unibs.ing.fp.lab.esame;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 
 * prototipo di stazione
 * 
 * @author Samuele
 *
 */

public class Stazione {

	private static final String LISTA_VUOTA= "La lista è vuota, inserisci almeno un elemento!";
	
	private LinkedList<Vagone> vagoni = new LinkedList<>();
	private LinkedList<Vagone> motrici = new LinkedList<>();
	private LinkedList<Treno> treni = new LinkedList<>();
	private Set<Vagone> occupati = new HashSet<>();
	
	public Stazione() {}
	
	
	/**
	 * metodo che permette di mostrare i vagoni NON OCCUPATI presenti nella stazione
	 * @return stringa da stampare
	 */
	
	public String mostraVagoni() {
		if(vagoni.size() > 0) {
			StringBuffer str = new StringBuffer();
			for(Vagone vagone : vagoni) {
				if(!occupati.contains(vagone)) {
					str.append("- Vagone " + vagone.getId());
					str.append('\n');
					str.append(" --- Lunghezza: " + vagone.getLunghezza());
					str.append('\n');
					str.append(" --- Peso: " + vagone.getLunghezza());
					str.append('\n');
					if(vagone instanceof VagonePasseggeri) {
						str.append(" --- Posti in piedi: " + ((VagonePasseggeri)vagone).getPostiInPiedi());
						str.append('\n');
						str.append(" --- Posti a sedere: " + ((VagonePasseggeri)vagone).getSedili());
						str.append('\n');
					}
					else if(vagone instanceof VagoneMerci) {
						str.append(" --- Carico trasportabile: " + ((VagoneMerci)vagone).getCaricoTrasportabile());
						str.append('\n');
					}
				}
			}
			return str.toString();
		}
		else {
			return LISTA_VUOTA;
		}
	}
	
	/**
	 * metodo che permette di mostrare le motrici NON OCCUPATE presenti nella stazione
	 * @return stringa da stampare
	 */
	
	public String mostraMotrici() {
		if(motrici.size() > 0) {
			StringBuffer str = new StringBuffer();
			for(Vagone motrice : motrici) {
				if(!occupati.contains(motrice)) {
					str.append("- Motrice " + motrice.getId());
					str.append('\n');
					str.append(" --- Lunghezza: " + motrice.getLunghezza());
					str.append('\n');
					str.append(" --- Peso: " + motrice.getLunghezza());
					str.append('\n');
				}
			}
			return str.toString();
		}
		else {
			return LISTA_VUOTA;
		}
	}
	
	/**
	 * Metodo che permette di selezionare un vagone tramite l'id
	 * @param id id del vagone
	 * @return vagone cercato, se presente nella lista
	 */
	
	public Vagone scegliVagone(String id) {
		for(Vagone vagone : vagoni) {
			if(vagone.getId().equals(id))
				return vagone;
			}
		throw new NonPresenteNellaListaException();
	}
	
	/**
	 * Metodo che permette di selezionare una motrice tramite l'id
	 * @param id id della motrice
	 * @return motrice cercata, se presente nella lista
	 */
	
	public Vagone scegliMotrice(String id) {
		for(Vagone motrice : motrici) {
			if(motrice.getId().equals(id))
				return motrice;
			}
		throw new NonPresenteNellaListaException();
	}
	
	public String mostraTreni() {
		if(treni.size() > 0) {
			StringBuffer str = new StringBuffer();
			for(Treno treno : treni) {
				str.append(" - Treno " + treno.getId());
				str.append('\n');
				str.append(" - - Lunghezza: " + treno.getLunghezzaTotale());
				str.append('\n');
				str.append(" - - Peso: " + treno.getPesoTotale());
				str.append('\n');
				str.append(" - - Capacità massima passeggeri: " + treno.getPasseggeriMax());
				str.append('\n');
				str.append(" - - Carico massimo trasportabile: " + treno.getCaricoMax());
			}
			return str.toString();
		}
		else {
			return LISTA_VUOTA;
		}
	}
	
	public void aggiungiAllaListaOccupati(Vagone vagone) {
		occupati.add(vagone);
	}
	
	public void aggiungiTreno(Treno daAggiungere) {
		treni.add(daAggiungere);
	}
	
	public void aggiungiVagone(Vagone daAggiungere) {
		vagoni.add(daAggiungere);
	}
	
	public void aggiungiMotrice(Vagone daAggiungere) {
		motrici.add(daAggiungere);
	}
	
	//////////////////////////////////////////////////////////////////////
	
	public LinkedList<Vagone> getVagoni() {
		return vagoni;
	}
	public void setVagoni(LinkedList<Vagone> vagoni) {
		this.vagoni = vagoni;
	}
	public LinkedList<Vagone> getMotrici() {
		return motrici;
	}
	public void setMotrici(LinkedList<Vagone> motrici) {
		this.motrici = motrici;
	}
	public LinkedList<Treno> getTreni() {
		return treni;
	}
	public void setTreni(LinkedList<Treno> treni) {
		this.treni = treni;
	}

	public Set<Vagone> getOccupati() {
		return occupati;
	}

	public void setOccupati(Set<Vagone> occupati) {
		this.occupati = occupati;
	}
}
