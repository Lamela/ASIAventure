package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.elements.structure.PieceException;

public class VivantAbsentDeLaPieceException extends PieceException{
	/**
	  *Constructs a VivantAbsentDeLaPieceException with null as its specified detail message.
	  *
	  *@author Lu Chenxin
	  */
	public VivantAbsentDeLaPieceException(){
	}

	/**
	  *Constructs a VivantAbsentDeLaPieceException with the specified detail message.
	  */
	public VivantAbsentDeLaPieceException(String msg){
		super(msg);
	}
}
