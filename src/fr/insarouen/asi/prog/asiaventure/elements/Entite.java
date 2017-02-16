package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.Monde;

/**
  *A 
  *
  *@author Lu Chenxin
  */
public abstract class Entite{
	private String nom;
	private Monde monde;

	/**
	  *Creates an entity.
	  *
	  *@author Lu Chenxin
	  */
	public Entite(){
	}

	/**
	  *Creates an entity with the specified name and world..
	  *
	  *@author Lu Chenxin
	  *@param <code>nom</code> - the name of this entity.
	  *@param <code>monde</code> - the world where this entity exists.
	  */
	public Entite(String nom, Monde monde){
		this.nom = nom;
		this.monde = monde;
		monde.ajouter(this);
	}

	/**
	  *Gets the name of this entity.
	  *
	  *@author Lu Chenxin
	  *@return the name of this entity.
	  */
	public String getNom(){
		return this.nom;
	}

	/**
	  *Gets the world where this entity exists.
	  *
	  *@author Lu Chenxin
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
	  *@author Lu Chenxin
	  *@return the string which describes this entity.
	  */
	public String toString(){
		return String.format("Nom : %s, Monde : %s.",this.getNom(), this.getMonde().getNom());
	}

	/**
	  *Checks the contents of an object and this entity for equality.
	  *
	  *@author Lu Chenxin
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
	  *@author Lu Chenxin
	  *@return the sum of the hashcode of this entity's name and world.
	  */
	public int hashCode(){
		return nom.hashCode()+monde.hashCode();
	}
}
