package it.unibs.ing.fp.lab.esame;

import it.unibs.ing.fp.mylib.InputDati;
import it.unibs.ing.fp.mylib.MyMenu;

public class ComposizioneTreniMain {

	private static final String TITOLO = "Gestore stazione ferroviaria";
	private static final String[] VOCI = {"Aggiungi un nuovo componente","Mostra i vagoni","Mostra le motrici","Crea un nuovo treno","Mostra i treni"};
	private static final String SALUTO_INIZILE = "Benvenuto nel gestore della stazione ferroviaria";
	private static final String SALUTO_FINALE = "Arrivederci";
	private static final String ERRORE_NESSUNA_MOTRICE = "Non puoi creare un treno senza avere nessuna motrice nella stazione";
	private static final String INIT = "Avviare l'inizializzazione?\n SI) premi y\n NO) premi n\n -> ";
	
	public static void main(String[] args) {
		Stazione stazione = new Stazione();
		System.out.println(SALUTO_INIZILE);
		char c = InputDati.leggiUpperChar(INIT, "Y N y n");
		if(c == 'Y') {
			stazione.setVagoni(Utility.initVagoni());
			stazione.setMotrici(Utility.initMotrici());
		}
		
		MyMenu menuPrincipale = new MyMenu(TITOLO,VOCI);
		
		int scelta = 0;
		do {
			scelta=menuPrincipale.scegli();
			switch(scelta) {
			case 1: 
				Utility.creaNuovoComponente(stazione);
				break;
			case 2:
				System.out.println(stazione.mostraVagoni());
				break;
			case 3: 
				System.out.println(stazione.mostraMotrici());
				break;
			case 4: 
				boolean finito = false;
				do {
					try {
						Utility.gestioneTreno(stazione);
					}
					catch(NonPresenteNellaListaException ex) {
						System.out.println(ERRORE_NESSUNA_MOTRICE);
						break;
					}
				}while(!finito);
				break;
			case 5: 
				System.out.println(stazione.mostraTreni());
				break;
			}
		}while(scelta != 0);
		System.out.println(SALUTO_FINALE);
	}

}
