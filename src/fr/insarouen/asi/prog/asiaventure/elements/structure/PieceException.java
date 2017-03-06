package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurelException;

public class PieceException extends ElementStructurelException{
	/**
	  *Constructs a PieceException with null as its specified detail message.
	  *
	  *@author Lu Chenxin
	  */
	public PieceException(){
	}

	/**
	  *Constructs a PieceException with the specified detail message.
	  */
	public PieceException(String msg){
		super(msg);
	}
}
