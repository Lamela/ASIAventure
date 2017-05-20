package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;

/**
  *The group of conditions to finish this game.
  *
  *@author Lu Chenxin
  */
public class ConditionDeFinConjonctionConditionDeFin extends ConditionDeFin{
	private ConditionDeFin[] cfs;
	
	/**
	  *Constructs the group of conditions to finish the game.
	  *
	  *@param <code>etatDuJeu</code> - the state of the game.
	  *@param <code>cfs</code> - the group of conditions.
	  */
	public ConditionDeFinConjonctionConditionDeFin(EtatDuJeu etatDuJeu, ConditionDeFin... cfs){
		super(etatDuJeu);
		this.cfs = cfs;
	}

	/**
	  *Verifies the condition, returns the state of the game if existing a condition with the state "ENCOURS",returns the method getEtatConditionVerifiee() if not.
	  *
	  *@return the method getEtatConditionVerifiee().
	  */
	@Override
	public EtatDuJeu verifierCondition(){
		for(ConditionDeFin cf: this.cfs){
			if(cf == EtatDuJeu.ENCOURS)
				return cf;
		}
		return this.getEtatConditionVerifiee();
	}
}
