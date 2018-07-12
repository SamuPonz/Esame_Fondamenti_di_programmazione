package it.unibs.ing.fp.lab.esame;

public class VagoneMerci extends Vagone{

	private double caricoTrasportabile;

	public VagoneMerci(double caricoTrasportabile, boolean motrice, double lunghezza, double peso) {
		super(motrice, lunghezza, peso);
		this.caricoTrasportabile = caricoTrasportabile;
	}
	
	//////////////////////////////////////////////////////////////////
	
	public double getCaricoTrasportabile() {
		return caricoTrasportabile;
	}

	public void setCaricoTrasportabile(double caricoTrasportabile) {
		this.caricoTrasportabile = caricoTrasportabile;
	}
}
