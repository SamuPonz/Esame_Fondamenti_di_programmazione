package it.unibs.ing.fp.lab.esame;

import java.util.LinkedList;

import it.unibs.ing.fp.mylib.InputDati;
import it.unibs.ing.fp.mylib.MyMenu;

/**
 * classe con metodi utili
 * 
 * @author Samuele
 *
 */

public class Utility {
	
	private static final String RICHIESTA_LUNGHEZZA = "Inserisci la lunghezza %s: ";
	private static final String RICHIESTA_PESO = "Inserisci il peso %s: ";
	private static final String RICHIESTA_CARICO = "Inserisci il carico massimo del vagone merci: ";
	private static final String RICHIESTA_POSTI_A_SEDERE = "Inserisci il numero di posti a sedere del vagone: ";
	private static final String RICHIESTA_POSTI_IN_PIEDI = "Inserisci il numero di posti in piedi del vagone: ";
	private static final String RICHIESTA_ID = "Escludendo il paramentro iniziale %c identificativo del componente, inserisci l'id %s che vuoi aggingere al treno: ";
	private static final String MENU_CREAZIONE = "Seleziona che tipo di componente vuoi aggiungere alla stazione";
	private static final String[] VOCI_CREAZIONE = {"Aggiungi una motrice", "Aggiungi un vagone passeggeri", "Aggiungi un vagone merci"};
	private static final String FINITO = "Operazione effettuata correttamente";
	private static final String OCCUPATO = "%s non è disponibile, appartiene già alla composizione di un altro treno";
	private static final char M = 'M';
	private static final char V = 'V';
	private static final String RICHESTA_ULTERIORE_INSERIMENTO = "Desideri inserire un altro vagone?\n SI) premi y\n NO) premi n\n -> ";
	private static final String NON_PRESENTE_NELLA_LISTA= "Non presente nella lista, riprova con un altro id";
	private static final String MOTRICE = "della motrice";
	private static final String LA_MOTRICE = "la motrice";
	private static final String IL_VAGONE = "il vagone";
	private static final String VAGONE = "del vagone";
	private static final double LUNGHEZZA_MINIMA = 0;
	private static final int PESO_MINIMO = 0;
	private static final int POSTI_MINIMI = 0;
	private static final double CARICO_MINIMO = 0;
	
	
	/**
	 * metodo che permette di selezionare quale nuovo componente creare
	 * @param stazione
	 */
	
	public static void creaNuovoComponente(Stazione stazione) {
		MyMenu menuCreazione = new MyMenu(MENU_CREAZIONE, VOCI_CREAZIONE);
		int scelta = 0;
		do {
			scelta = menuCreazione.scegli();
			switch(scelta) {
			case 1: 
				stazione.aggiungiMotrice(creaMotrice());
				break;
			case 2: 
				stazione.aggiungiVagone(creaVagonePasseggeri());
				break;
			case 3: 
				stazione.aggiungiVagone(creaVagoneMerci());
				break;
			}
			System.out.println(FINITO);
		}while(scelta != 0);
	}
	
	/**
	 * metodo che permette di gestire un treno, creandolo da zero
	 * @param stazione
	 */
	
	public static void gestioneTreno(Stazione stazione) {
		
		Treno treno = creaTreno(stazione);
		Vagone scelto = null;
		String id = null;
		boolean finito = false;
		boolean primaProva = true;
		if(stazione.getVagoni().size()> 0) {
			do {
				try {
					do {
						if(!primaProva) {
							System.out.println(String.format(OCCUPATO, IL_VAGONE));
						}
						System.out.println(stazione.mostraVagoni());
						id = "V" + InputDati.leggiInteroNonNegativo(String.format(RICHIESTA_ID, V, VAGONE));
						scelto = stazione.scegliVagone(id);
						primaProva = false;
					}while(stazione.getOccupati().contains(scelto));
					stazione.aggiungiAllaListaOccupati(scelto);
					treno.aggiungiVagone(scelto);
					char c = InputDati.leggiUpperChar(RICHESTA_ULTERIORE_INSERIMENTO, "Y N y n");
					if(c == 'N') {
						finito = true;
					}
				}
				catch(NonPresenteNellaListaException ex) {
					System.out.println(NON_PRESENTE_NELLA_LISTA);
				}
			}while(!finito);
			stazione.aggiungiTreno(treno);
		} else {
			throw new NonPresenteNellaListaException();
		}
	}
			
	/**
	 * metodo che permette di creare un nuovo treno
	 * @param stazione
	 * @return nuovo treno
	 */
	
	public static Treno creaTreno(Stazione stazione) {
	
		Vagone motrice = null;
		boolean finito = false;
		boolean primaProva = true;
		String id = null;
		if(stazione.getMotrici().size() > 0) {
			do {
				try {
					do {
						if(!primaProva) {
							System.out.println(String.format(OCCUPATO, LA_MOTRICE));
						}
						System.out.println(stazione.mostraMotrici());
						id = "M" + InputDati.leggiInteroNonNegativo(String.format(RICHIESTA_ID, M, MOTRICE));
						motrice = stazione.scegliMotrice(id);
						primaProva = false;
					}while(stazione.getOccupati().contains(motrice));
					stazione.aggiungiAllaListaOccupati(motrice);
					finito = true;
					
				}
				catch(NonPresenteNellaListaException ex) {
					System.out.println(NON_PRESENTE_NELLA_LISTA);
				}
			}while(!finito);
			return new Treno(motrice);
		} else {
			throw new NonPresenteNellaListaException();
		}
	}
	
	/**
	 * metodo che permette di creare un nuovo vagone merci
	 * @return vagone creato
	 */
	
	public static Vagone creaVagoneMerci() {
		double lunghezza = 0;
		double peso = 0;
		double caricoMax = 0;
		lunghezza = InputDati.leggiDoubleConMinimo(String.format(RICHIESTA_LUNGHEZZA, VAGONE), LUNGHEZZA_MINIMA);
		peso = InputDati.leggiDoubleConMinimo(String.format(RICHIESTA_PESO, VAGONE), PESO_MINIMO);
		caricoMax = InputDati.leggiDoubleConMinimo(RICHIESTA_CARICO, CARICO_MINIMO);
		return new VagoneMerci(caricoMax, false, lunghezza, peso);
	}
	
	/**
	 * metodo che permette di creare un nuovo vagone passeggeri
	 * @return vagone creato
	 */
	
	public static Vagone creaVagonePasseggeri() {
		double lunghezza = 0;
		double peso = 0;
		int postiInPiedi = 0;
		int sedili = 0;
		lunghezza = InputDati.leggiDoubleConMinimo(String.format(RICHIESTA_LUNGHEZZA, VAGONE), LUNGHEZZA_MINIMA);
		peso = InputDati.leggiDoubleConMinimo(String.format(RICHIESTA_PESO, VAGONE), PESO_MINIMO);
		sedili = InputDati.leggiInteroConMinimo(RICHIESTA_POSTI_A_SEDERE, POSTI_MINIMI);
		postiInPiedi = InputDati.leggiInteroConMinimo(RICHIESTA_POSTI_IN_PIEDI, POSTI_MINIMI);
		return new VagonePasseggeri(postiInPiedi, sedili, false, lunghezza, peso);
	}
	
	/**
	 * metodo che permette di creare una nuova motrice
	 * @return motrice creata
	 */
	
	public static Vagone creaMotrice() {
		double lunghezza = 0;
		double peso = 0;
		lunghezza = InputDati.leggiDoubleConMinimo(String.format(RICHIESTA_LUNGHEZZA, MOTRICE), LUNGHEZZA_MINIMA);
		peso = InputDati.leggiDoubleConMinimo(String.format(RICHIESTA_PESO, MOTRICE), PESO_MINIMO);
		return new Vagone(true, lunghezza, peso);
	}
	
	public static LinkedList<Vagone> initVagoni() {
		LinkedList<Vagone> vagoniProva = new LinkedList<>();
		vagoniProva.add(new VagoneMerci(20, false, 100, 100));
		vagoniProva.add(new VagoneMerci(10, false, 400, 300));
		vagoniProva.add(new VagonePasseggeri(50, 500, false, 300, 400));
		vagoniProva.add(new VagoneMerci(30, false, 200, 500));
		vagoniProva.add(new VagoneMerci(80, false, 80, 300));
		vagoniProva.add(new VagonePasseggeri(50, 500, false, 100, 500));
		vagoniProva.add(new VagoneMerci(50, false, 70, 400));
		vagoniProva.add(new VagonePasseggeri(50, 500, false, 300, 500));
		return vagoniProva;
	}
	
	public static LinkedList<Vagone> initMotrici() {
		LinkedList<Vagone> motriciProva = new LinkedList<>();
		motriciProva.add(new Vagone(true, 300, 554));
		motriciProva.add(new Vagone(true, 400, 450));
		motriciProva.add(new Vagone(true, 500, 600));
		motriciProva.add(new Vagone(true, 200, 500));
		motriciProva.add(new Vagone(true, 100, 600));
		return motriciProva;
	}
}
