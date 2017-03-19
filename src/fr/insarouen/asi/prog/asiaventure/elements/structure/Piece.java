package fr.insarouen.asi.prog.asiaventure.elements.structure;

import java.util.*;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;

/**
  *A piece.
  *
  *@author Lu Chenxin
  */
public class Piece extends ElementStructurel {
	
	private Map<String,Objet> objets = new HashMap<>();
	private Map<String,Vivant> vivants = new HashMap<>();
	private Map<String,Porte> portes = new HashMap<>();
	//private Objet[] objets = new Objet[0];
	//private Vivant[] vivants = new Vivant[0];

	/**
	  *Constructs a piece with the specified name and world.
	  *
	  *@exception NomDEntiteDejaUtiliseDansLeMondeException if the name of piece exists in the world.
	  */
	public Piece (String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom,monde);
	}
	
	/**
	  *Checks if the object with the specified name exists in the piece.
	  *
	  *@param <code>nomObj</code> - the name of the object.
	  *@return true if it exists, false otherwise.
	  */
	public boolean contientObjet(String nomObj){
		/*
		int longueur = this.objets.length;
		int i=0;
		if(this.objets != null){
			while(i<longueur && !trouve){
				if(this.objets[i].getNom().equals(nomObj)){
					trouve = true;
				}
				i++;
			}
			return trouve;
		}
		*/
		return this.objets.containsKey(nomObj);
	}

	/**
	  *Checks if the specified object exists in the piece.
	  *
	  *@param <code>obj</code> - the object.
	  *@return true if it exists, false otherwise.
	  */
	public boolean contientObjet(Objet obj){
		return this.contientObjet(obj.getNom());
	}

	/**
	  *Checks if the specified living thing exists in the piece.
	  *
	  *@param <code>vivant</code> - the living thing.
	  *@return true if it exists, false otherwise.
	  */
	public boolean contientVivant(Vivant vivant){
		/*
		int longueur = this.vivants.length;	
		int i=0;
		boolean trouve = false;
		if(this.vivants != null){
			while(i<longueur && !trouve){
				if(this.vivants[i].equals(vivant)){
					trouve = true;
				}
				i++;
			}
		}
		return trouve;
		*/
		return this.contientVivant(vivant.getNom()); 
	}

	/**
	  *Checks if the living thing with the specified name exists in the piece.
	  *
	  *@param <code>nomVivant</code> - the name of the living thing.
	  *@return true if it exists, false otherwise.
	  */
	public boolean contientVivant(String nomVivant){
		return this.vivants.containsKey(nomVivant); 
	}

	/**
	  *Puts the object in the piece.
	  *
	  *@param <code>obj</code> - the object to put.
	  */
	public void deposer(Objet obj){
		if(!(this.contientObjet(obj))){
			//int longueur = this.objets.length;
			//Objet[] tmp = new Objet[longueur+1];
			//System.arraycopy(objets,0,tmp,0,longueur);
			//tmp[longueur] = obj;
			//this.objets = tmp;
			this.objets.put(obj.getNom(),obj);
		}
	}

	/**
	  *Puts the living thing in the piece.
	  *
	  *@param <code>vivant</code> - the living thing to put.
	  */
	public void entrer(Vivant vivant){
		if(!(this.contientVivant(vivant))){
			//int longueur = this.vivants.length;
			//Vivant[] tmp = new Vivant[longueur+1];
			//System.arraycopy(vivants,0,tmp,0,longueur);
			//tmp[longueur] = vivant;
			//this.vivants = tmp;
			this.vivants.put(vivant.getNom(),vivant);
		}
	}

	/**
	  *Gets all the objects in the piece.
	  *
	  *@return <code>Objet[]</code>.
	  */
	public Collection<Objet> getObjets(){
		return this.objets.values();
	}

	/**
	  *Removes the object with the specified detail name of the object from the piece.
	  *
	  *@param <code>nomObj</code> - the name of the object to remove.
	  *@return the object which is removed from the piece.
	  *@exception ObjetAbsentDeLaPieceException if the object is not in the piece.
	  *@exception ObjetNonDeplacableException if it's impossible to remove the object from the piece.
	  */
	public Objet retirer(String nomObj) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
		return this.retirer((Objet)this.getMonde().getEntite(nomObj));
	}

	/**
	  *Removes the object from the piece.
	  *
	  *@param <code>obj</code> - the object to remove.
	  *@return the object which is removed from the piece.
	  *@exception ObjetAbsentDeLaPieceException if the object is not in the piece.
	  *@exception ObjetNonDeplacableException if it's impossible to remove the object from the piece.
	  */
	public Objet retirer(Objet obj) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
		if(!this.contientObjet(obj))
			throw new ObjetAbsentDeLaPieceException("L'objet absent de la piece.");
		if(!obj.estDeplacable())
			throw new ObjetNonDeplacableException("L'objet non deplacable.");
		if(this.contientObjet(obj)){
			/*
			int longueur = this.objets.length;
			int i=0;
			Objet[] tmp = new Objet[longueur-1];
			while(i<longueur && !this.objets[i].equals((Object)obj)){
				tmp[i] = this.objets[i];
				i++;
			}
			for(int j=i;j<longueur-1;j++){
				tmp[j] = this.objets[j+1];
			}
			this.objets = tmp;
			return obj;
			*/
			return this.objets.remove(obj.getNom());
		}
		return null;
	}

	/**
	  *Removes the living thing from the piece.
	  *
	  *@param <code>vivant</code> - the living thing to remove.
	  *@return the living thing which is removed from the piece.
	  *@exception VivantAbsentDeLaPieceException if the living thing is not in the piece.
	  */
	public Vivant sortir(Vivant vivant) throws VivantAbsentDeLaPieceException{
		if(!this.contientVivant(vivant))
			throw new VivantAbsentDeLaPieceException("Vivant absent de la piece.");
		if(this.contientVivant(vivant)){
			/*
			int longueur = this.vivants.length;
			int i=0;
			Vivant[] tmp = new Vivant[longueur-1];
			while(i<longueur && !this.vivants[i].equals((Object)vivant)){
				tmp[i] = this.vivants[i];
				i++;
			}
			for(int j=i;j<longueur-1;j++){
				tmp[j] = this.vivants[j+1];
			}
			this.vivants = tmp;
			return vivant;
			*/
			return this.vivants.remove(vivant.getNom());
		}
		return null;
	}

	/**
	  *Removes the living thing with the specified name from the piece.
	  *
	  *@param <code>nomVivant</code> - the name of the living thing to remove.
	  *@return the living thing which is removed from the piece.
	  *@exception VivantAbsentDeLaPieceException if the living thing is not in the piece.
	  */
	public Vivant sortir(String nomVivant) throws VivantAbsentDeLaPieceException{
		return ((Vivant)this.getMonde().getEntite(nomVivant));
	}
	
	/**
	  *Adds a door into the piece.
	  *
	  *@param <code>porte</code> - the door to add.
	  */
	protected void addPorte(Porte porte){
		this.portes.put(porte.getNom(),porte);
	}
	
	/**
	  *Checks if the door with the specified name exists in the piece.
	  *
	  *@param <code>nomPorte</code> - the name of the door.
	  *@return true if it exists, false otherwise.
	  */
	public boolean aLaPorte(String nomPorte){
		return this.portes.containsKey(nomPorte);
	}

	/**
	  *Checks if the specified door exists in the piece.
	  *
	  *@param <code>porte</code> - the door.
	  *@return true if it exists, false otherwise.
	  */
	public boolean aLaPorte(Porte porte){
		return this.aLaPorte(porte.getNom());
	}

	/**
	  *Gets the door with the specified name in the piece.
	  *
	  *@param <code>nomPorte</code> - the name of the door.
	  *@return the door.
	  */
	public Porte getPorte(String nomPorte){
		return this.portes.get(nomPorte);
	}

	/**
	  *Returns the string which describes this piece.
	  *
	  *@return the string which describes this piece.
	  */
	public String toString(){
		StringBuilder s = new StringBuilder();
		s.append(super.toString());
		s.append("\n");
		//int longueur = this.objets.length;
		//for(int i=0;i<longueur;i++){
		//	s.append("Nom de l'objet: ");
		//	s.append(this.objets[i].getNom());
		//	s.append(".\n");
		//}
		objets.forEach((String,Objet) -> {
			s.append("Nom de l'objet: ");
			s.append(String);
			s.append(".\n");
		});
		return s.toString();
	}
}
