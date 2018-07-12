package it.unibs.ing.fp.lab.esame;

public class VagonePasseggeri extends Vagone{

	private int postiInPiedi;
	private int sedili;
	
	public VagonePasseggeri(int postiInPiedi, int sedili, boolean motrice, double lunghezza, double peso) {
		super(motrice, lunghezza, peso);
		this.postiInPiedi = postiInPiedi;
		this.sedili = sedili;
	}
	
	/////////////////////////////////////////////////////////
	
	public int getPosti() {
		return postiInPiedi + sedili;
	}
	
	public int getPostiInPiedi() {
		return postiInPiedi;
	}
	public void setPostiInPiedi(int postiInPiedi) {
		this.postiInPiedi = postiInPiedi;
	}
	public int getSedili() {
		return sedili;
	}
	public void setSedili(int sedili) {
		this.sedili = sedili;
	}
}
