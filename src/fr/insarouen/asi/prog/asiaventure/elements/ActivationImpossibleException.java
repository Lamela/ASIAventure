package fr.insarouen.asi.prog.asiaventure.elements;

import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;

public class ActivationImpossibleException extends ActivationException{
	/**
	  *Contructs an ActivationImpossibleException with null as its detail message.
	  *
	  *@author Lu Chenxin
	  */
	public ActivationImpossibleException(){
	}

	/**
	  *Contructs an ActivationImpossibleException with the specified detail message.
	  */
	public ActivationImpossibleException(String msg){
		super(msg);
	}
}
