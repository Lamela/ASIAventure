package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

public class Piece extends ElementStructurel {
	
	private Objet[] objets;
	private Vivant[] vivants;

	//Constructeurs
	public Piece (String nom, Monde monde){
		super(nom,monde);
	}
	
	//Methodes
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

	public boolean contientObjet(Objet obj){
		return contientObjet(obj.getNom());
	}

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

	public boolean contientVivant(String nomVivant){
		return contientVivant((Vivant)this.getMonde().getEntite(nomVivant));
	}

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

	public Objet[] getObjets(){
		return this.objets;
	}

	public Objet retirer(String nomObj){
		if(this.contientObjet(nomObj)){
			int longueur = this.objets.length;
			int i=0;
			Objet[] tmp = new Objet[longueur-1];
			while(i<longueur && !this.objets[i].getNom().equals(nomObj)){
				tmp[i] = this.objets[i];
				i++;
			}
			Objet obj = new Objet(nomObj, this.getMonde()){
				public boolean estDeplacable(){
				return false;
				}
			};
			obj = this.objets[i];
			for(int j=i;j<longueur-1;j++){
				tmp[j] = this.objets[j+1];
			}
			this.objets = tmp;
			return obj;
		}
		return null;
	}

	public Objet retirer(Objet obj){
		return retirer(obj.getNom());
	}

	public Vivant sortir(Vivant vivant){
		if(this.contientVivant(vivant)){
			int longueur = this.vivants.length;
			int i=0;
			Vivant[] tmp = new Vivant[longueur-1];
			while(i<longueur && !this.vivants[i].equals(vivant)){
				tmp[i] = this.vivants[i];
				i++;
			}
			Vivant vivantNew = new Vivant(vivant.getNom(),vivant.getMonde(),vivant.getPointVie(),vivant.getPointForce(), vivant.getPiece(), vivant.getObjets());
			vivantNew = this.vivants[i];
			for(int j=i;j<longueur-1;j++){
				tmp[j] = this.vivants[j+1];
			}
			this.vivants = tmp;
			return vivantNew;
		}
		return null;
	}

	public Vivant sortir(String nomVivant){
		return ((Vivant)this.getMonde().getEntite(nomVivant));
	}

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
