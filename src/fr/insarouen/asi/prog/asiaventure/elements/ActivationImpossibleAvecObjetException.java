package fr.insarouen.asi.prog.asiaventure.elements;

import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;

public class ActivationImpossibleAvecObjetException extends ActivationImpossibleException{
	/**
	  *Constructs an ActivationImpossibleAvecObjetException with null as its specified detail message.
	  *
	  *@author Lu Chenxin
	  */
	public ActivationImpossibleAvecObjetException(){
	}

	/**
	  *Constructs an ActivationImpossibleAvecObjetException with the specified detail message.
	  */
	public ActivationImpossibleAvecObjetException(String msg){
		super(msg);
	}
}
