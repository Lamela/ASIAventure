package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;

public class Vivant extends Entite{
	private int pointVie;
	private int pointForce;
	private Objet[] objets;
	private Piece piece;
	//Constructeurs
	public Vivant(String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet[] objets){
	super(nom,monde);
	this.pointVie = pointVie;
	this.pointForce = pointForce;
	this.piece = piece;
	this.objets = objets;
	}

	//Methodes
	public void deposer(Objet obj){
		if(!(this.possede(obj))){
			int longueur = this.objets.length;
			int i=0;
			Objet[] tmp = new Objet[longueur-1];
			while(i<longueur && !this.objets[i].equals(obj)){
				tmp[i] = this.objets[i];
				i++;
			}
			Objet res = new Objet(obj.getNom(),obj.getMonde()){
				public boolean estDeplacable(){
					return true;
				}
			};
			res = this.objets[i];
			for(int j=i;j<longueur-1;j++){
				tmp[j] = this.objets[j+1];
			}
			this.objets = tmp;
			this.getPiece().deposer(obj);
		}
	}
	
	public void deposer(String nomObj){
		deposer((Objet)this.getMonde().getEntite(nomObj));
	}

	public boolean estMort(){
		return false;
	}

	public Objet getObjet(String nomObjet){
		return (Objet)this.getMonde().getEntite(nomObjet);
	}

	public Objet[] getObjets(){
		return this.objets;
	}

	public Piece getPiece(){
		return this.piece;
	}

	public int getPointVie(){
		return pointVie;
	}

	public int getPointForce(){
		return pointForce;
	}

	public boolean possede(Objet obj){
		int longueur = this.objets.length;
		int i=0;
		boolean possede = false;
		if(this.objets != null){
			while(i<longueur && !possede){
				if(this.objets[i].equals(obj)){
					possede = true;
				}
				i++;
			}
		}
		return possede;
	}

	public void prendre(Objet obj){
		Objet res = new Objet(obj.getNom(),this.getMonde()){
			public boolean estDeplacable(){
				return true;
			}
		};
		res  = this.getPiece().retirer(obj);
		if(this.objets == null){
			this.objets  = new Objet[1];
			this.objets[0] = res;
		}
		else{
			if(!(this.possede(res)) && res.estDeplacable()){
				int longueur = this.objets.length;
				Objet[] tmp = new Objet[longueur+1];
				for(int i=0;i<longueur;i++){
					tmp[i] = this.objets[i];
				}
				tmp[longueur] = res;
				this.objets = tmp;
			}
		}
	}

	public void prendre(String nomObj){
		prendre((Objet)this.getMonde().getEntite(nomObj));
	}

	public String toString(){
		StringBuilder s = new StringBuilder();
		s.append(super.toString());
		s.append("PointVie: ");
		s.append(this.getPointVie());
		s.append("PointForce: ");
		s.append(this.getPointForce());
		s.append("Piece: ");
		s.append(this.getPiece());
		s.append(".\n");
		int longueur = this.objets.length;
		for(int i=0;i<longueur;i++){
			s.append("Nom de l'objet: ");
			s.append(this.objets[i].getNom());
			s.append(".\n");
		}
		return s.toString();
	}
}
