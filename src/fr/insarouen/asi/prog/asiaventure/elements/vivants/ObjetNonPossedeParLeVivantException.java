package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.elements.vivants.VivantException;

public class ObjetNonPossedeParLeVivantException extends VivantException{
	/**
	  *Constructs an ObjetNonPossedeParLeVivantException with null as its specified detail message.
	  *
	  *@author Lu Chenxin
	  */
	public ObjetNonPossedeParLeVivantException(){
	}

	/**
	  *Constructs an ObjetNonPossedeParLeVivantException with the specified detail message.
	  */
	public ObjetNonPossedeParLeVivantException(String msg){
		super(msg);
	}
}
