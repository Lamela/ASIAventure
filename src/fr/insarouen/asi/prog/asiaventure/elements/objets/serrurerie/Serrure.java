package fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie;

import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;

/**
  *A lock.
  *
  *@author Lu Chenxin.
  @serial
  */
public class Serrure extends Objet implements Activable{
	private Clef clef;
	private Etat etat;
	
	/**
	  *Generates a name of this lock with the specified world;
	  *
	  *@param <code>monde</code> - the world where this lock exists.
	  *@return the String of the name.
	  */
	private static String genererNom(Monde monde){
		StringBuilder sb = new StringBuilder();
		int nb = 1;
		sb.append("Serrure");
		sb.append(nb);
		while(monde.getEntite(sb.toString()) != null){
			nb++;
			sb = new StringBuilder();
			sb.append("Serrure");
			sb.append(nb);
		}
		return sb.toString();
	}

	/**
	  *Constructs a lock with specified world.
	  *
	  *@param <code>monde</code> - the world where this lock exists.
	  */
	public Serrure(Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
		this(Serrure.genererNom(monde),monde);
		this.etat = Etat.DEVERROUILLE;
	}

	/**
	  *Constructs a lock with specified name and world.
	  *
	  *@param <code>nom</code> - the name of this lock.
	  *@param <code>monde</code> - the world where this lock exists.
	  */
	public Serrure(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom, monde);
		this.etat = Etat.DEVERROUILLE;
	}

	/**
	  *Creates a key.
	  *
	  *@return the key.
	  */
	public final Clef creerClef(){
		try{
			return clef = new Clef("Clef"+this.getNom(),this.getMonde());
		}
		catch(NomDEntiteDejaUtiliseDansLeMondeException e){
			return null;
		}
	}

	/**
	  *Activates a lock with an another object.
	  *
	  *@param <code>obj</code>abstract - an object to activate a lock.
	  */
	public void activerAvec(Objet obj) throws ActivationImpossibleAvecObjetException{
		if(this.activableAvec(obj) == false)
			throw new ActivationImpossibleAvecObjetException("La serrure est impossible d'activer avec un objet qui n'est pas clef.");
		else
			this.etat = Etat.VERROUILLE;
	}

	/**
	  *Checks the mobility of this lock.
	  *
	  *@return the mobility.
	  */
	public boolean estDeplacable(){
		return true;
	}

	/**
	  *Activates a lock.
	  */
	public void activer() throws ActivationImpossibleException{
		if(this.getEtat() == Etat.VERROUILLE)
			throw new ActivationImpossibleException("La serrure ne peut pas etre active quand elle est verrouille.");
		if(this.getEtat() == Etat.DEVERROUILLE)
			this.etat = Etat.DEVERROUILLE;
	}

	/**
	  *Gets the state of this lock.
	  *
	  *@return the state.
	  */
	public Etat getEtat(){
		return this.etat;
	}

	/**
	  *Checks whether we can activate a lock with an another object.
	  *
	  *@param <code>obj</code> - an object to activate a lock.
	  @return the result of judgement.
	  */
	public boolean activableAvec(Objet obj){
		if(obj instanceof Clef)
			return true;
		else
			return false;
	}
}
