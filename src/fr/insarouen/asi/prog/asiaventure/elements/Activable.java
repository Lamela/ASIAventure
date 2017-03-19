package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;

  public interface Activable {
	abstract public boolean activableAvec(Objet obj);

	abstract public void activer() throws ActivationException;

	abstract public void activerAvec(Objet obj) throws ActivationException;
  }
