package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.elements.vivants.VivantException;

public class CommandeImpossiblePourLeVivantException extends VivantException{
	/**
	  *Constructs a CommandeImpossiblePourLeVivantException with null as its specified detail message.
	  *
	  *@author Lu Chenxin
	  */
	public CommandeImpossiblePourLeVivantException(){
	}

	/**
	  *Constructs a CommandeImpossiblePourLeVivantException with the specified detail message.
	  */
	public CommandeImpossiblePourLeVivantException(String msg){
		super(msg);
	}
}
