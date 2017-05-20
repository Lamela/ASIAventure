package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;

/**
  *A interface of activable objects.
  */
public interface Activable {
	
	/**
	  *Judges whether we can activate an object with an another object.
	  *
	  *@param <code>obj</code> - an object to activate an another object.
	  @return the result of judgement.
	  */
	abstract public boolean activableAvec(Objet obj);

	/**
	  *Activates an object.
	  */
	abstract public void activer() throws ActivationException;

	/**
	  *Activates an object with an another object.
	  *
	  *@param <code>obj</code>abstract - an object to activate an another object.
	  */
	public void activerAvec(Objet obj) throws ActivationException;
}
