package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

public class MondeException extends ASIAventureException{
	/**
	  *Constructs a MondeException with null as its specified detail message.
	  *
	  *@author Lu Chenxin
	  */
	public MondeException(){
	}

	/**
	  *Constructs a MondeException with the specified detail message.
	  */
	public MondeException(String msg){
		super(msg);
	}
}
