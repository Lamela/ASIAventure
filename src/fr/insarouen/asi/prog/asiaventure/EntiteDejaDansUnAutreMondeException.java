package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.MondeException;

public class EntiteDejaDansUnAutreMondeException extends MondeException{
	/**
	  *Constructs an <code>EntiteDejaDansUnAutreMondeException</code> with null as its specified detail message.
	  *
	  *@author Lu Chenxin
	  */
	public EntiteDejaDansUnAutreMondeException(){
	}

	/**
	  *Constructs an <code>EntiteDejaDansUnAutreMondeException</code> with the specified detail message.
	  */
	public EntiteDejaDansUnAutreMondeException(String msg){
		super(msg);
	}
}
