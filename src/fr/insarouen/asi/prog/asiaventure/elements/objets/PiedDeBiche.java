package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;

public class PiedDeBiche extends Objet{

	//Constructeurs
	public PiedDeBiche(String nom, Monde monde){
		super(nom,monde);
	}
	
	//methodes
	public boolean estDeplacable(){
		return true;
	}
}
