package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;

/**
  *A world.
  *
  *@author Lu Chenxin
  */
public class Monde{
	private String nom;
	private Entite[] entites;

	/**
	  *Creates a world with a specified name.
	  *
	  *@author Lu Chenxin
	  *@param <code>nom</code> - the name of the world we are going to create.
	  */
	public Monde(String nom){
		this.nom = nom;
	}

	/**
	  *Gets the name of this world.
	  *
	  *@author Lu Chenxin
	  *@return the name of this world.
	  */
	public String getNom(){
		return this.nom;
	}

	/**
	  *Gets the entity with a name specified in this world.
	  *
	  *@author Lu Chenxin
	  *@param <code>nom</code> - the name of the entity we are looking for in this world.
	  *@return the entity with a name specified in this world.
	  */
	public Entite getEntite(String nom){
		int i=0;
		int longueur=this.entites.length;
		boolean trouve=false;
		Entite res = new Entite(){};
		if(this.entites != null){
			while(i<longueur && trouve == false){
				if(this.entites[i].getNom().equals(nom)){
					res = this.entites[i];
					trouve = true;
				}
				i += 1;
			}
		}
		return res;
	}

	/**
	  *Add an entity in this world.
	  *
	  *@author Lu Chenxin
	  *@param <code>entite</code> - the entity we are adding into this world.
	  */
	public void ajouter(Entite entite){
		if(this.entites == null){
			this.entites = new Entite[1];
			this.entites[0] = entite;
		}
		else{
			if(this.getEntite(entite.getNom()).getNom()==null){
				int longueur=this.entites.length;
				Entite[] temp = new Entite[longueur+1];
				for(int i=0;i<longueur;i++){
					temp[i] = this.entites[i];
				}
				temp[longueur] = entite;
				this.entites = temp;
			}
		}
	}

	/**
	  *Returns the string describes this world.
	  *
	  *@author Lu Chenxin
	  *@return the string describes this world.
	  */
	public String toString(){
		StringBuilder s = new StringBuilder();
		s.append("Nom du monde:");
		s.append(this.getNom());
		s.append("\n");
		for(int i=0;i<this.entites.length;i++){
			s.append("Nom de l'entite: ");
			s.append(this.entites[i].getNom());
			s.append("\n");
		}
		return s.toString();
	}
}




