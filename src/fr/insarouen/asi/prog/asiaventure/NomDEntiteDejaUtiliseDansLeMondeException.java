package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.MondeException;

public class NomDEntiteDejaUtiliseDansLeMondeException extends MondeException{
	/**
	  *Constructs a NomDEntiteDejaUtiliseDansLeMondeException with null as its specified detail message.
	  *
	  *@author Lu Chenxin
	  */
	public NomDEntiteDejaUtiliseDansLeMondeException(){
	}

	/**
	  *Constructs a NomDEntiteDejaUtiliseDansLeMondeException with the specified detail message.
	  */
	public NomDEntiteDejaUtiliseDansLeMondeException(String msg){
		super(msg);
	}
}
