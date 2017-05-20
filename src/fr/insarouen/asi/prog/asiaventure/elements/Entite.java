package fr.insarouen.asi.prog.asiaventure.elements;

import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;

/**
  *An entity. 
  *
  *@author Lu Chenxin
  *@serial
  */
public abstract class Entite implements java.io.Serializable{
	private String nom;
	private Monde monde;

	/**
	  *Constructs an entity with the specified name and world.
	  *
	  *@param <code>nom</code> - the name of this entity.
	  *@param <code>monde</code> - the world where this entity exists.
	  *@exception NomDEntiteDejaUtiliseDansLeMondeException if the name of the entity exists already in the world.
	  */
	public Entite(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
		this.nom = nom;
		this.monde = monde;
		try{
			monde.ajouter(this);
		}
		catch(EntiteDejaDansUnAutreMondeException e){
			e.printStackTrace();
			//System.err.println("Ne doit pas arriver!!");
			//System.exit(1);
			throw new Error("Ne doit pas arriver!!");
		}
	}

	/**
	  *Gets the name of this entity.
	  *
	  *@return the name of this entity.
	  */
	public String getNom(){
		return this.nom;
	}

	/**
	  *Gets the world where this entity exists.
	  *
	  *@return the world where this entity exists.
	  */
	public Monde getMonde(){
		return this.monde;
	}

	/**
	  public String toString(){
		StringBuilder s =new StringBuilder();
		s.append("Nom: ");
		s.append(this.getNom());
		s.append(", Monde: ");
		s.append(this.getMonde().getNom());
		s.append(".");
		return s.toString();
	}
	*/

	/**
	  *Returns the string which describes this entity.
	  *
	  *@return the string which describes this entity.
	  */
	public String toString(){
		return String.format("Nom : %s, Monde : %s.",this.getNom(), this.getMonde().getNom());
	}

	/**
	  *Checks the contents of an object and this entity for equality.
	  *
	  *@param <code>o</code> - the object
	  *@return true if the content of object o equals to this entity, false otherwise.
	  */
	public boolean equals(Object o){
		Entite tmp = (Entite) o;
		if(this == o){
			return true;
		}
		else{
			if(this.getClass() != tmp.getClass()){
				return false;
			}
			else{
				return this.getNom().equals(tmp.getNom()) && this.getMonde().equals(tmp.getMonde());
			}
		}
	}
	
	/**
	  *Gets the sum of the hashcode of name and world
	  *
	  *@return the sum of the hashcode of this entity's name and world.
	  */
	public int hashCode(){
		return nom.hashCode()+monde.hashCode();
	}
}
