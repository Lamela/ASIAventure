package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

/**
  *The condition to finish this game when a living thing possedes specified objects.
  *
  *@author Lu Chenxin
  */
public class ConditionDeFinVivantPossedeObjets extends ConditionDeFin{
	private Vivant vivant;
	private Objet[] objets;

	/**
	  *Constructs a condition to finish the game.
	  *
	  *@param <code>etatDuJeuVerifiee</code> - the state of the game.
	  *@param <code>vivant</code> - the living thing.
	  *@param <code>objets</code> - the table of objects.
	  */
	public ConditionDeFinVivantPossedeObjets(EtatDuJeu etatConditionVerifiee, Vivant vivant, Objet[] objets){
		super(etatConditionVerifiee);
		this.vivant = vivant;
		this.objets = objets;
		for(Objet o: objets){
			this.vivant.put(o.getNom(), o);
		}
	}

	/**
	  *Verifies the condition, returns the state of the game if the living things possedes the specified objects, returns the state "ENCOURS" if not.
	  *
	  *@return the state of the game.
	  */
	@Override
	public EtatDuJeu verifierCondition(){
		for(Objet o: this.objets){
			if(!this.vivant.possede(o))
				return EtatDuJeu.ENCOURS;
		}
		return this.getEtatConditionVerifiee();
	}
}
