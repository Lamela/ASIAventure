package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
/**
  *The condition to finish this game when a living thing in a piece.
  *
  *@author Lu Chenxin
  */
public class ConditionDeFinVivantDansPiece extends ConditionDeFin{
	private Vivant vivant;
	private Piece piece;

	/**
	  *Constructs a condition to finish the game.
	  *
	  *@param <code>etatDuJeuVerifiee</code> - the state of the game.
	  *@param <code>vivant</code> - the living thing.
	  *@param <code>piece</code> - the piece.
	  */
	public ConditionDeFinVivantDansPiece(EtatDuJeu etatConditionVerifiee, Vivant vivant, Piece piece){
		super(etatConditionVerifiee);
		this.vivant = vivant;
		this.piece = piece;
		this.piece.entrer(this.vivant);
	}

	/**
	  *Verifies the condition, returns the state of the game if the living things is in the piece, returns the state "ENCOURS" if not.
	  *
	  *@return the state of the game.
	  */
	@Override
	public EtatDuJeu verifierCondition(){
		if(this.piece.contientVivant(this.vivant))
			return this.getEtatConditionVerifiee();
		else
			return EtatDuJeu.ENCOURS;
	}
}
