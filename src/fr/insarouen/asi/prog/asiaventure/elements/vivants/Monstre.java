package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import java.util.*;
import fr.insarouen.asi.prog.asiaventure.elements.Executable;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;

public class Monstre extends Vivant implements Executable{
	public Monstre(String nom, Monde monde, int pointVie, int pointForce, Piece piece, HashMap<String,Objet> objets) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom,monde,pointVie,pointForce,piece,objets);
	}

	public void executer() throws Throwable{
		this.getObjetsFromPiece();
		this.franchir(this.tiragePorte());
		this.setPointVie(this.getPointVie()-1);
		this.echangerObjetsEntrePieceEtMonstre();
	}

	private Porte tiragePorte(){
		Collection<Porte> portesAChoisir = new ArrayList<Porte>();
		portesAChoisir = this.getPiece().getPortes();
		boolean tirage = false;
		Random rand = new Random();
		while(tirage == false){
			for(Porte p : portesAChoisir){ 
				int value = rand.nextInt(50);
				if(value%2 == 0){
					tirage = true;
					return p;
				}
			}
		}
		return null;
	}

	private void getObjetsFromPiece() throws ObjetNonDeplacableException, ObjetAbsentDeLaPieceException{
		Collection<Objet> tmpDePiece = new ArrayList<Objet>();
		tmpDePiece = this.getPiece().getObjets();
		for(Objet o : tmpDePiece){
			if(o.estDeplacable() == false)
				throw new ObjetNonDeplacableException("L'objet n'est pas deplacable.");
			this.prendre(this.getPiece().retirer(o));
		}
	}

	private void echangerObjetsEntrePieceEtMonstre() throws ObjetNonDeplacableException, ObjetAbsentDeLaPieceException{
		HashMap<String,Objet> tmpDeMonstre = new HashMap<>();
		tmpDeMonstre = this.getObjets();
		HashMap<String,Objet> mapVide= new HashMap<>();
		this.setObjets(mapVide);
		this.getPiece().setObjets(tmpDeMonstre);
		this.getObjetsFromPiece();
	}
}




	
