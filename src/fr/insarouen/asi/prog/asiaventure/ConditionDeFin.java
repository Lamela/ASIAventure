package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;

/**
  *Interface class for the condition to finish this game.
  *
  *@author Lu Chenxin
  */
public abstract class ConditionDeFin implements java.io.Serializable{
	private EtatDuJeu etatDuJeu;

	/**
	  *Constructs a condition to finish the game.
	  *
	  *@param <code>etatDuJeu</code> - the state of the game.
	  */
	public ConditionDeFin(EtatDuJeu etatDuJeu){
		this.etatDuJeu = etatDuJeu;
	}

	/**
	  *Gets the state of the game.
	  *
	  *@return the state of the game.
	  */
	public EtatDuJeu getEtatConditionVerifiee(){
		return this.etatDuJeu;
	}

	/**
	  *Method abstract, verifies the condition.
	  *
	  *@return the state of the game.
	  */
	public abstract EtatDuJeu verifierCondition();
}
