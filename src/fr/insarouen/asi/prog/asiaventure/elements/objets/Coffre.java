package fr.insarouen.asi.prog.asiaventure.elements.objets;

import java.io.Serialiazable;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;

/**
  *A box.
  *
  *@author Lu Chenxin.
  @serial
  */
public class Coffre extends Objet implements Activable{
	private Etat etat;

	/**
	  *Constructs a box with specified name and world.
	  *
	  *@param <code>nom</code> - the name of this box.
	  *@param <code>monde</code> - the world where this box exists.
	  */
	public Coffre(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom,monde);
		this.etat = Etat.FERME;
	}

	/**
	  *Checks the mobility of this box.
	  *
	  *@return the mobility.
	  */
	public boolean estDeplacable(){
		return false;
	}

	/**
	  *Activates a box.
	  */
	public void activer() throws ActivationException{
		if(this.getEtat() == Etat.CASSE)
			throw new ActivationException("Le coffre casse ne peut pas etre active.");
		if(this.getEtat() == Etat.FERME)
			this.etat = Etat.OUVERT;
		if(this.getEtat() == Etat.OUVERT)
			this.etat = Etat.FERME;
	}

	/**
	  *Judges whether we can activate a box with an another object.
	  *
	  *@param <code>obj</code> - an object to activate a box.
	  @return the result of judgement.
	  */
	public boolean activableAvec(Objet obj){
		return (obj instanceof PiedDeBiche);
	}

	/**
	  *Activates a box with an another object.
	  *
	  *@param <code>obj</code>abstract - an object to activate a box.
	  */
	public void activerAvec(Objet obj) throws ActivationException{
		if(this.activableAvec(obj) == false)
			throw new ActivationException("Le coffre ne peut pas activer avec un objet qui n'est pas PiedDeBiche.");
		else
			this.etat = Etat.CASSE;
	}

	/**
	  *Gets the state of this box.
	  *
	  *@return the state.
	  */
	public Etat getEtat(){
		return this.etat;
	}

	/**
	  *Returns the string which describes this box.
	  *
	  *@return the string which describes this box.
	  */
	public String toString(){
		return String.format("Nom: %s, Monde: %s, Etat: %s",this.getNom(),this.getMonde(), this.getEtat());
	}
}
