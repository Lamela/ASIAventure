package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

/**
  *A piece.
  *
  *@author Lu Chenxin
  */
public class Piece extends ElementStructurel {
	
	private Objet[] objets;
	private Vivant[] vivants;

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
		int longueur = this.objets.length;	
		int i=0;
		boolean trouve = false;
		if(this.objets != null){
			while(i<longueur && !trouve){
				if(this.objets[i].getNom().equals(nomObj)){
					trouve = true;
				}
				i++;
			}
		}
		return trouve;
	}

	/**
	  *Checks if the specified object exists in the piece.
	  *
	  *@param <code>obj</code> - the object.
	  *@return true if it exists, false otherwise.
	  */
	public boolean contientObjet(Objet obj){
		return contientObjet(obj.getNom());
	}

	/**
	  *Checks if the specified living thing exists in the piece.
	  *
	  *@param <code>vivant</code> - the living thing.
	  *@return true if it exists, false otherwise.
	  */
	public boolean contientVivant(Vivant vivant){
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
	}

	/**
	  *Checks if the living thing with the specified name exists in the piece.
	  *
	  *@param <code>nomVivant</code> - the name of the living thing.
	  *@return true if it exists, false otherwise.
	  */
	public boolean contientVivant(String nomVivant){
		return contientVivant((Vivant)this.getMonde().getEntite(nomVivant));
	}

	/**
	  *Puts the object in the piece.
	  *
	  *@param <code>obj</code> - the object to put.
	  */
	public void deposer(Objet obj){
		if(this.objets == null){
			this.objets  = new Objet[1];
			this.objets[0] = obj;
		}
		else{
			if(!(this.contientObjet(obj))){
				int longueur = this.objets.length;
				Objet[] tmp = new Objet[longueur+1];
				for(int i=0;i<longueur;i++){
					tmp[i] = this.objets[i];
				}
				tmp[longueur] = obj;
				this.objets = tmp;
			}
		}
	}

	/**
	  *Puts the living thing in the piece.
	  *
	  *@param <code>vivant</code> - the living thing to put.
	  */
	public void entrer(Vivant vivant){
		if(this.vivants == null){
			this.vivants  = new Vivant[1];
			this.vivants[0] = vivant;
		}
		else{
			if(!(this.contientVivant(vivant))){
				int longueur = this.vivants.length;
				Vivant[] tmp = new Vivant[longueur+1];
				for(int i=0;i<longueur;i++){
					tmp[i] = this.vivants[i];
				}
				tmp[longueur] = vivant;
				this.vivants = tmp;
			}
		}
	}

	/**
	  *Gets all the objects in the piece.
	  *
	  *@return <code>Objet[]</code>.
	  */
	public Objet[] getObjets(){
		return this.objets;
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
		return retirer((Objet)this.getMonde().getEntite(nomObj));
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
			int longueur = this.objets.length;
			int i=0;
			Objet[] tmp = new Objet[longueur-1];
			while(i<longueur && !this.objets[i].equals(obj)){
				tmp[i] = this.objets[i];
				i++;
			}
			for(int j=i;j<longueur-1;j++){
				tmp[j] = this.objets[j+1];
			}
			this.objets = tmp;
			return obj;
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
			int longueur = this.vivants.length;
			int i=0;
			Vivant[] tmp = new Vivant[longueur-1];
			while(i<longueur && !this.vivants[i].equals(vivant)){
				tmp[i] = this.vivants[i];
				i++;
			}
			for(int j=i;j<longueur-1;j++){
				tmp[j] = this.vivants[j+1];
			}
			this.vivants = tmp;
			return vivant;
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
	  *Returns the string which describes this piece.
	  *
	  *@return the string which describes this piece.
	  */
	public String toString(){
		StringBuilder s = new StringBuilder();
		s.append(super.toString());
		s.append("\n");
		int longueur = this.objets.length;
		for(int i=0;i<longueur;i++){
			s.append("Nom de l'objet: ");
			s.append(this.objets[i].getNom());
			s.append(".\n");
		}
		return s.toString();
	}
}
