package it.unibs.ing.fp.lab.esame;

public class NonPresenteNellaListaException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NonPresenteNellaListaException() {}
	
	public NonPresenteNellaListaException(String messaggio) {
		super(messaggio);
	}
	
}
