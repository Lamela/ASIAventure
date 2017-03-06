package fr.insarouen.asi.prog.asiaventure.elements;

import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

public class ActivationException extends ASIAventureException{
	/**
	  *Constructs an ActivationException with null as its detail message.
	  *
	  *@author Lu Chenxin
	  */
	public ActivationException(){
	}

	/**
	  *Constructs an ActivationException with the specified detail message.
	  */
	public ActivationException(String msg){
		super(msg);
	}
}
