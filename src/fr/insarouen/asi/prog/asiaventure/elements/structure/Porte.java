package fr.insarouen.asi.prog.asiaventure.elements.structure;

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

public class Porte extends ElementStructurel implements Activable{
	private Piece pieceA;
	private Piece pieceB;
	//private Serrure serrure;
	private Etat etat;

	public Porte(String nom, Monde monde, Piece pieceA, Piece pieceB) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom,monde);
		this.pieceA = pieceA;
		this.pieceB = pieceB;
		this.etat = Etat.FERME;
		pieceA.addPorte(this);
		pieceB.addPorte(this);
	}

	/*
	  public Porte(String nom, Monde monde, Serrure serrure, Piece pieceA, Piece pieceB) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom,monde);
		this.pieceA = pieceA;
		this.pieceB = pieceB;
		this.etat = Etat.FERME;
		this.serrure = serrure;
	}
	*/

	public void activer() throws ActivationImpossibleException{
		if(this.getEtat() == Etat.FERME)
			this.etat = Etat.OUVERT;
		if(this.getEtat() == Etat.OUVERT)
			this.etat = Etat.FERME;
	}

	public void activerAvec(Objet obj) throws ActivationImpossibleAvecObjetException, ActivationImpossibleException{
		if(this.activableAvec(obj) == false)
			throw new ActivationImpossibleAvecObjetException("La porte ne peut pas activer avev cet objet");
		if(this.activableAvec(obj) == true)
			this.etat = Etat.CASSE;
	}

	public boolean activableAvec(Objet obj) {
		if(obj instanceof PiedDeBiche)
			return true;
		else
			return false;
	}
	
	public Etat getEtat(){
		return this.etat;
	}

	/*
	public Serrure getSerrure(){
		return this.serrure;
	}
	*/

	public Piece getPieceAutreCote(){
		return this.pieceB;
	}

	public String toString(){
		return String.format("Nom: %s, Monde: %s, PieceAutreCote: %s, Etat: %s", this.getNom(), this.getMonde(), this.getPieceAutreCote(), this.getEtat());
	}
}
