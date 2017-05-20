package fr.insarouen.asi.prog.asiaventure;

import java.util.*;
import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.Executable;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

/**
  *A world.
  *
  *@author Lu Chenxin
  *@serial
  */
public class Monde implements java.io.Serializable{
	private String nom;
	private List<Entite> entites = new ArrayList<Entite>();
	//private Entite[] entites = new Entite[0];

	/**
	  *Constructs a world with a specified name.
	  *
	  *@param <code>nom</code> - the name of the world we are going to create.
	  */
	public Monde(String nom){
		this.nom = nom;
	}

	/**
	  *Gets the name of this world.
	  *
	  *@return the name of this world.
	  */
	public String getNom(){
		return this.nom;
	}

	/**
	  *Gets the entity with a name specified in this world.
	  *
	  *@param <code>nom</code> - the name of the entity we are looking for in this world.
	  *@return the entity with a name specified in this world.
	  */
	public Entite getEntite(String nom){
		/*
		int i=0;
		while(entites[i].getNom() != nom)
			i++;
		return entites[i];
		*/
		for(Entite e : entites){
			if(e.getNom().equals(nom))
				return e;
		}
		return null;
	}

	/**
	  *Add an entity in this world.
	  *
	  *@param <code>entite</code> - the entity we are adding into this world.
	  *@exception NomDEntiteDejaUtiliseDansLeMondeException if the name of the entity exists already in the world
	  *@exception EntiteDejaDansUnAutreMondeException if the entity exists in an another world
	  */
	public void ajouter(Entite entite) throws NomDEntiteDejaUtiliseDansLeMondeException, EntiteDejaDansUnAutreMondeException{
		//for(int i=0;i<entites.length;i++){
		for(Entite e : entites){
			if(e.getNom().equals(entite.getNom())){
				throw new NomDEntiteDejaUtiliseDansLeMondeException("Nom d'entite deja utilise dans le monde.");
			}
		}
		if(!entite.getMonde().equals(this))
			throw new EntiteDejaDansUnAutreMondeException("Entite deja dans un autre monde.");
		/*
		int longueur=this.entites.length;
		Entite[] temp = new Entite[longueur+1];
		System.arraycopy(entites,0,temp,0,longueur);
		temp[longueur] = entite;
		this.entites = temp;
		*/
		entites.add(entite);
	}

	/**
	  *Gets the collection of objects executable.
	  *
	  *@return the collection of objects executable.
	  */
	public Collection<Executable> getExecutable(){
		Collection<Executable> executable = new ArrayList<Executable>();
		for(Entite e: this.entites){
			if(e instanceof Vivant){
				executable.add((Executable)e);
			}
		}
		return executable;
	}

	/**
	  *Returns the string describes this world.
	  *
	  *@return the string describes this world.
	  */
	public String toString(){
		StringBuilder s = new StringBuilder();
		s.append("Nom du monde:");
		s.append(this.getNom());
		s.append("\n");
		/*
		for(int i=0;i<this.entites.length;i++){
			s.append("Nom de l'entite: ");
			s.append(this.entites[i].getNom());
			s.append("\n");
		}
		*/
		for(Entite e : entites){
			s.append("Nom de l'entite: ");
			s.append(e.getNom());
			s.append("\n");
		}
		return s.toString();
	}
}
