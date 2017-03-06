package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurelException;

public class PorteFermeException extends ElementStructurelException{
	/**
	  *Constructs a PorteFermeException with null as its specified detail message.
	  *
	  *@author Lu Chenxin
	  */
	public PorteFermeException(){
	}

	/**
	  *Constructs a PorteFermeException with the specified detail message.
	  */
	public PorteFermeException(String msg){
		super(msg);
	}
}
