package fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;

public class Serrure extends Objet implements Activable{
	private Clef clef;
	private Etat etat;
	
	private static String genererNom(Monde monde){
		StringBuilder sb = new StringBuilder();
		int nb = 1;
		sb.append("Serrure");
		sb.append(nb);
		while(monde.getEntite(sb.toString()) != null){
			nb++;
			sb = new StringBuilder();
			sb.append("Serrure");
			sb.append(nb);
		}
		return sb.toString();
	}

	public Serrure(Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
		this(Serrure.genererNom(monde),monde);
		this.etat = Etat.DEVERROUILLE;
	}

	public Serrure(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom, monde);
		this.etat = Etat.DEVERROUILLE;
	}

	public final Clef creerClef(){
		try{
			return clef = new Clef("Clef"+this.getNom(),this.getMonde());
		}
		catch(NomDEntiteDejaUtiliseDansLeMondeException e){
			return null;
		}
	}

	public void activerAvec(Objet obj) throws ActivationImpossibleAvecObjetException{
		if(this.activableAvec(obj) == false)
			throw new ActivationImpossibleAvecObjetException("La serrure est impossible d'activer avec un objet qui n'est pas clef.");
		else
			this.etat = Etat.VERROUILLE;
	}

	public boolean estDeplacable(){
		return true;
	}

	public void activer() throws ActivationImpossibleException{
		if(this.getEtat() == Etat.VERROUILLE)
			throw new ActivationImpossibleException("La serrure ne peut pas etre active quand elle est verrouille.");
		if(this.getEtat() == Etat.DEVERROUILLE)
			this.etat = Etat.DEVERROUILLE;
	}

	public Etat getEtat(){
		return this.etat;
	}

	public boolean activableAvec(Objet obj){
		if(obj instanceof Clef)
			return true;
		else
			return false;
	}
}
