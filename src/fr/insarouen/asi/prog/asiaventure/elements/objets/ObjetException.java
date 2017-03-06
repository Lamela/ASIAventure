package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

public class ObjetException extends ASIAventureException{
	/**
	  *Constructs an ObjetException with null as its specified detail message.
	  *
	  *@author Lu Chenxin
	  */
	public ObjetException(){
	}

	/**
	  *Constructs an ObjetException with the specified detail message.
	  */
	public ObjetException(String msg){
		super(msg);
	}
}
