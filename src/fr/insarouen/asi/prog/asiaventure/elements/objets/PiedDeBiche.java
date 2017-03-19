package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

/**
  *A <code>PiedDeBiche</code>.
  *
  *@author Lu Chenxin
  */
public class PiedDeBiche extends Objet{

	/**
	  *Constructs a <code>PiedDeBiche</code> with the specified detail name and world.
	  *
	  *@param <code>nom</code> - the name of this <code>PiedDeBiche</code>.
	  *@param <code>monde</code> - the world where this <code>PiedDeBiche</code> exists.
	  */
	public PiedDeBiche(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom,monde);
	}
	
	/**
	  *Sets the mobility of the <code>PiedDeBiche</code>.
	  *
	  *@return true.
	  */
	public boolean estDeplacable(){
		return true;
	}
}
