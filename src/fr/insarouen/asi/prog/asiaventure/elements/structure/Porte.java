package fr.insarouen.asi.prog.asiaventure.elements.structure;

import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Serrure;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Clef;

/**
  *A door.
  *
  *@author Lu Chenxin.
  *@serial
  */
public class Porte extends ElementStructurel implements Activable{
	private Piece pieceA;
	private Piece pieceB;
	private Serrure serrure;
	private Etat etat;

	/**
	  *Constructs a door with the specified name, world and 2 pieces.
	  *
	  *@exception NomDEntiteDejaUtiliseDansLeMondeException if the name of door exists in the world.
	  */
	public Porte(String nom, Monde monde, Piece pieceA, Piece pieceB) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom,monde);
		this.pieceA = pieceA;
		this.pieceB = pieceB;
		this.etat = Etat.FERME;
		pieceA.addPorte(this);
		pieceB.addPorte(this);
	}

	  /**
	  *Constructs a door with the specified name, world, lock and 2 pieces.
	  *
	  *@exception NomDEntiteDejaUtiliseDansLeMondeException if the name of door exists in the world.
	  */
	  public Porte(String nom, Monde monde, Serrure serrure, Piece pieceA, Piece pieceB) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom,monde);
		this.pieceA = pieceA;
		this.pieceB = pieceB;
		this.etat = Etat.FERME;
		this.serrure = serrure;
	}

	/**
	  *Activates a door.
	  */
	public void activer() throws ActivationImpossibleException{
		if(this.getEtat() == Etat.CASSE)
			throw new ActivationImpossibleException("La porte ne peut pas etre active quand elle est cassee.");
		if(this.getEtat() == Etat.FERME)
			this.etat = Etat.OUVERT;
		else if(this.getEtat() == Etat.OUVERT)
			this.etat = Etat.FERME;
	}

	/**
	  *Activates a door with an another object.
	  *
	  *@param <code>obj</code>abstract - an object to activate a door.
	  */
	public void activerAvec(Objet obj) throws ActivationImpossibleAvecObjetException, ActivationImpossibleException{
		if(this.activableAvec(obj) == false)
			throw new ActivationImpossibleAvecObjetException("La porte ne peut pas activer avev cet objet");
		if(this.activableAvec(obj) == true){
			if(obj instanceof PiedDeBiche)
				this.etat = Etat.CASSE;
			if(obj instanceof Clef){
				if(this.getEtat() == Etat.VERROUILLE)
					this.etat = Etat.OUVERT;
				if(this.getEtat() == Etat.OUVERT)
					this.etat = Etat.VERROUILLE;
			}
		}
	}

	/**
	  *Checks whether we can activate a door with an another object.
	  *
	  *@param <code>obj</code> - an object to activate a door.
	  @return the result of judgement.
	  */
	public boolean activableAvec(Objet obj) {
		return (obj instanceof PiedDeBiche) || (obj instanceof Clef);
	}

	/**
	  *Gets the state of this door.
	  *
	  *@return the state.
	  */
	public Etat getEtat(){
		return this.etat;
	}

	/**
	  *Gets the lock of this door.
	  *
	  *@return the lock.
	  */
	public Serrure getSerrure(){
		return this.serrure;
	}

	/**
	  *Gets the piece at the another side of this door with a specified side.
	  *
	  *@return the piece.
	  */
	public Piece getPieceAutreCote(Piece piece){
		if(piece == this.pieceA)
			return this.pieceB;
		else
			return this.pieceA;
	}

	/**
	  *Returns the string which describes this door.
	  *
	  *@return the string which describes this door.
	  */
	public String toString(){
		return String.format("Nom: %s, Monde: %s, Serrure: %s, Etat: %s", this.getNom(), this.getMonde(), this.getSerrure(), this.getEtat());
	}
}
