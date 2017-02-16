package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;

/**
  *An object.
  *
  *@author Lu Chenxin
  */
public abstract class Objet extends Entite{

	/**
	  *Creates an object with specified name and world.
	  *
	  *@author Lu Chenxin
	  *@param <code>nom</code> - the name of this objet.
	  *@param <code>monde</code> - the world where this objet exists.
	  */
	public Objet(String nom, Monde monde){
		super(nom,monde);
	}

	/**
	  *Checks the mobility of this object.
	  *
	  *@author Lu Chenxin
	  */
	public abstract boolean estDeplacable();

	/**
	  *Returns the string which describes this object.
	  *
	  *@author Lu Chenxin
	  */
	public String toString(){
		return String.format("%s estDeplacable: %s",super.toString(), estDeplacable());
	}
}
