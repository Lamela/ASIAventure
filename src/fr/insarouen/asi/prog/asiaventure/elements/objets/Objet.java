package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

/**
  *An object.
  *
  *@author Lu Chenxin
  */
public abstract class Objet extends Entite{

	/**
	  *Constructs an object with specified name and world.
	  *
	  *@param <code>nom</code> - the name of this object.
	  *@param <code>monde</code> - the world where this object exists.
	  */
	public Objet(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom,monde);
	}

	/**
	  *Checks the mobility of this object.
	  */
	public abstract boolean estDeplacable();

	/**
	  *Returns the string which describes this object.
	  */
	public String toString(){
		return String.format("%s estDeplacable: %s",super.toString(), estDeplacable());
	}
}
