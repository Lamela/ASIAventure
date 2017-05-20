package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import java.io.Serializable;
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

/**
  *A monster.
  *
  *@author Lu Chenxin
  @serial
  */
public class Monstre extends Vivant implements Executable{
	/**
	  *Constructs a monster with the specified name, world, HP, AttackDamage, piece and objects.
	  *
	  *@param <code>nom</code> - the name of this monster.
	  *@param <code>monde</code> - the world of this monster.
	  *@param <code>pointVie</code> - the HP of this monster.
	  *@param <code>pointForce</code> - the Attack Damage of this monster.
	  *@param <code>piece</code> - the piece where this monster is.
	  *@param <code>objets</code> - the objects that this monster possedes.
	  */
	public Monstre(String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet... objets) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom,monde,pointVie,pointForce,piece,objets);
	}

	/**
	  *Executes the action to cross the door.
	  *
	  *@exception Throwble if there is an exception.
	  */
	public void executer() throws Throwable{
		this.getObjetsFromPiece();
		this.franchir(this.tiragePorte());
		this.setPointVie(this.getPointVie()-1);
		this.echangerObjetsEntrePieceEtMonstre();
	}
	
	/**
	  *Draws a door randomly.
	  *
	  *@return the door chosen.
	  */
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
	
	/**
	  *Moves the objects of the piece to the monster.
	  *
	  *@exception ObjetNonDeplacableException if the object is not removable.
	  *@exception ObjetAbsentDeLaPieceException if the object doesn't exist in the piece.
	  */
	private void getObjetsFromPiece() throws ObjetNonDeplacableException, ObjetAbsentDeLaPieceException{
		Collection<Objet> tmpDePiece = new ArrayList<Objet>();
		tmpDePiece = this.getPiece().getObjets();
		for(Objet o : tmpDePiece){
			if(o.estDeplacable() == false)
				throw new ObjetNonDeplacableException("L'objet n'est pas deplacable.");
			this.prendre(this.getPiece().retirer(o));
		}
	}
	
	/**
	  *Exchanges the objects between the piece and the monster.
	  *
	  *@exception ObjetNonDeplacableException if the object is not removable.
	  *@exception ObjetAbsentDeLaPieceException if the object doesn't exist in the piece.
	  */
	private void echangerObjetsEntrePieceEtMonstre() throws ObjetNonDeplacableException, ObjetAbsentDeLaPieceException{
		HashMap<String,Objet> tmpDeMonstre = new HashMap<>();
		tmpDeMonstre = this.getObjets();
		HashMap<String,Objet> mapVide= new HashMap<>();
		this.setObjets(mapVide);
		this.getPiece().setObjets(tmpDeMonstre);
		this.getObjetsFromPiece();
	}
}




	
