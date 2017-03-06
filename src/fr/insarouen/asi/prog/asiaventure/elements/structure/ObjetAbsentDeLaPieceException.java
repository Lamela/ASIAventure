package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.elements.structure.PieceException;

public class ObjetAbsentDeLaPieceException extends PieceException{
	/**
	  *Constructs an ObjetAbsentDeLaPieceException with null as its specified detail message.
	  *
	  *@author Lu Chenxin
	  */
	public ObjetAbsentDeLaPieceException(){
	}

	/**
	  *Constructs a ObjetAbsentDeLaPieceException with the specified detail message.
	  */
	public ObjetAbsentDeLaPieceException(String msg){
		super(msg);
	}
}
