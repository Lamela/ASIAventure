package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

public class VivantException extends ASIAventureException{
	/**
	  *Constructs a VivantException with null as its specified detail message.
	  *
	  *@author Lu Chenxin
	  */
	public VivantException(){
	}

	/**
	  *Constructs a VivantException with the specified detail message.
	  */
	public VivantException(String msg){
		super(msg);
	}
}
