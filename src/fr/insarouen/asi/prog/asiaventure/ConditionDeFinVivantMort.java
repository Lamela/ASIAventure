package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

/**
  *The condition to finish this game when a living thing is dead.
  *
  *@author Lu Chenxin
  */public class ConditionDeFinVivantMort extends ConditionDeFin{
	private Vivant vivant;

	/**
	  *Constructs a condition to finish the game.
	  *
	  *@param <code>etatDuJeuVerifiee</code> - the state of the game.
	  *@param <code>vivant</code> - the living thing.
	  */
	public ConditionDeFinVivantMort(EtatDuJeu etatConditionVerifiee, Vivant vivant){
		super(etatConditionVerifiee);
		this.vivant = vivant;
	}

	/**
	  *Verifies the condition, returns the state of the game if the living things is dead, returns the state "ENCOURS" if not.
	  *
	  *@return the state of the game.
	  */@Override
	public EtatDuJeu verifierCondition(){
		if(this.vivant.estMort())
			return this.getEtatConditionVerifiee();
		else
			return EtatDuJeu.ENCOURS;
	}
}
