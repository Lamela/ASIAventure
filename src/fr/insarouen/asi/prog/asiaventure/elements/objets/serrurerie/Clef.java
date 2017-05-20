package fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie;

import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

/**
  *A key.
  *
  *@author Lu Chenxin
  *@serial
  */
public final class Clef extends Objet{

	/**
	  *Constructs a key with specified name and world.
	  *
	  *@param <code>nom</code> - the name of this key.
	  *@param <code>monde</code> - the world where this key exists.
	  */
	protected Clef(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom,monde);
	}

	/**
	  *Checks the mobility of this key.
	  *
	  *@return the mobility.
	  */
	public boolean estDeplacable(){
		return true;
	}
}
