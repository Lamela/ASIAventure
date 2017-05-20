package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;

/**
  *The condition to finish this game when a living thing in a piece and possedes specified objects.
  *
  *@author Lu Chenxin
  */
public class ConditionDeFinVivantDansPieceEtPossedeObjets extends ConditionDeFinConjonctionsConditionDeFin{
	private Vivant vivant;
	private Piece piece;
	private Objet[] objets;

	/**
	  *Constructs a condition to finish the game.
	  *
	  *@param <code>etatDuJeuVerifiee</code> - the state of the game.
	  *@param <code>vivant</code> - the living thing.
	  *@param <code>piece</code> - the piece.
	  *@param <code>objets</code> - the table of objects.
	  */
	public ConditionDeFinVivantDansPieceEtPossedeObjets(EtatDuJeu etatConditionVerifiee, Vivant vivant, Piece piece, Objet... objets){
		super(etatConditionVerifiee, new ConditionDeFinDansPiece(etatConditionVerifiee, vivant, piece), new ConditionDeFinPossedeObjet(etatConditionVerifiee, vivant, objets));
	}
}
