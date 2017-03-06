package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.elements.structure.PieceException;

public class PorteInexistanteDansLaPieceException extends PieceException{
	/**
	  *Constructs a PorteInexistanteDansLaPieceException with null as its specified detail message.
	  *
	  *@author Lu Chenxin
	  */
	public PorteInexistanteDansLaPieceException(){
	}

	/**
	  *Constructs a PorteInexistanteDansLaPieceException with the specified detail message.
	  */
	public PorteInexistanteDansLaPieceException(String msg){
		super(msg);
	}
}
