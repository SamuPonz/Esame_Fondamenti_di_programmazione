package it.unibs.ing.fp.mylib;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
Questa classe rappresenta un menu testuale generico a piu' voci
Si suppone che la voce per uscire sia sempre associata alla scelta 0 
e sia presentata in fondo al menu

*/
public class MyMenu
{
  //final private static String CORNICE = "--------------------------------";
  final private static String VOCE_USCITA = "0\tEsci";
  final private static String RICHIESTA_INSERIMENTO = "Digita il numero dell'opzione desiderata > ";

  private String titolo;
  private String [] voci;

	
  public MyMenu (String titolo, String [] voci)
  {
	this.titolo = titolo;
	this.voci = voci;
  }
  
  public <T> MyMenu (String titolo, List<T> listaVoci)
  {
	this.titolo = titolo;
	
	String[] vociTemp = new String[listaVoci.size()];
	for(int i = 0; i < listaVoci.size(); i++)
		vociTemp[i] = listaVoci.get(i).toString();
	
	this.voci = vociTemp;
  }

  public <T> MyMenu (String titolo, Set<T> listaVoci)
  {
	this.titolo = titolo;
	
	String[] vociTemp = new String[listaVoci.size()];
	Iterator<T> iter = listaVoci.iterator();
	int i = 0;
	while(iter.hasNext()) {
		vociTemp[i] = iter.next().toString();
		i++;
	}
	this.voci = vociTemp;
  }
  
  public int scegli ()
  {
	stampaMenu();
	return InputDati.leggiIntero(RICHIESTA_INSERIMENTO, 0, voci.length);	 
  }
  
  public int scegliNoTitolo ()
  {
	stampaMenuNoCornice();
	return InputDati.leggiIntero(RICHIESTA_INSERIMENTO, 0, voci.length);	 
  }
  
  public int sceltaForzata ()
  {
	stampaMenuNoUscita();
	return InputDati.leggiIntero(RICHIESTA_INSERIMENTO, 0, voci.length);	 
  }
		
  public void stampaMenu ()
  {
	stampaCornice();
	System.out.println(titolo);
	stampaCornice();
    for (int i=0; i<voci.length; i++)
	 {
	  System.out.println( (i+1) + "\t" + voci[i]);
	 }
    System.out.println();
	System.out.println(VOCE_USCITA);
    System.out.println();
  }
		
  public void stampaMenuNoCornice ()
  {
	  System.out.println();
	  System.out.println(titolo);
	System.out.println();
    for (int i=0; i<voci.length; i++)
	 {
	  System.out.println( (i+1) + "\t" + voci[i]);
	 }
    System.out.println();
	System.out.println(VOCE_USCITA);
    System.out.println();
  }

  public void stampaCornice ()
  {
	  for(int i = 0; i < titolo.length(); i++)
		  System.out.print("-");
	  System.out.println();
  }
  
  public void stampaMenuNoUscita ()
  {
	System.out.println();
	System.out.println(titolo);
	System.out.println();
    for (int i=0; i<voci.length; i++)
	 {
	  System.out.println( (i+1) + "\t" + voci[i]);
	 }
    System.out.println();
  }
  
}

