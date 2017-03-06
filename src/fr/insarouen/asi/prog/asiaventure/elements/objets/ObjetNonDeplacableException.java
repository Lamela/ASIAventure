package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetException;

public class ObjetNonDeplacableException extends ObjetException{
	/**
	  *Constructs an ObjetNonDeplacableException with null as its specified detail message.
	  *
	  *@author Lu Chenxin
	  */
	public ObjetNonDeplacableException(){
	}

	/**
	  *Constructs an ObjetNonDeplacableException with the specified detail message.
	  */
	public ObjetNonDeplacableException(String msg){
		super(msg);
	}
}
