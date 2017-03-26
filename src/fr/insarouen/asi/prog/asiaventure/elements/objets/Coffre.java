package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;

public class Coffre extends Objet implements Activable{
	private Etat etat;

	public Coffre(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom,monde);
		this.etat = Etat.FERME;
	}

	public boolean estDeplacable(){
		return false;
	}

	public void activer() throws ActivationException{
		if(this.getEtat() == Etat.CASSE)
			throw new ActivationException("Le coffre casse ne peut pas etre active.");
		if(this.getEtat() == Etat.FERME)
			this.etat = Etat.OUVERT;
		if(this.getEtat() == Etat.OUVERT)
			this.etat = Etat.FERME;
	}

	public boolean activableAvec(Objet obj){
		return (obj instanceof PiedDeBiche);
	}

	public void activerAvec(Objet obj) throws ActivationException{
		if(this.activableAvec(obj) == false)
			throw new ActivationException("Le coffre ne peut pas activer avec un objet qui n'est pas PiedDeBiche.");
		else
			this.etat = Etat.CASSE;
	}

	public Etat getEtat(){
		return this.etat;
	}

	public String toString(){
		return String.format("Nom: %s, Monde: %s, Etat: %s",this.getNom(),this.getMonde(), this.getEtat());
	}
}
