package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

/**
  *A structual element.
  *
  *@author Lu Chenxin
  */
public abstract class ElementStructurel extends Entite{

	/**
	  *Constructs an structual element with the specified name an world.
	  *
	  *@exception NomDEntiteDejaUtiliseDansLeMondeException if the name of the element structual exists in the world.
	  */
	public ElementStructurel(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom, monde);
	}
}
