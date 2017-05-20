package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import java.util.*;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.ObjetNonPossedeParLeVivantException;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteInexistanteDansLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.Executable;


/**
  *A living thing.
  *
  *@author Lu Chenxin
  @serial
  */
public abstract class Vivant extends Entite implements Executable{
	private int pointVie;
	private int pointForce;
	private HashMap<String,Objet> objets = new HashMap<>();
	//private Objet[] objets = new Objet[0];
	private Piece piece;

	/**
	  *Constructs a living thing with the specified detail name, world, <code>pointVie</code>, <code>pointForce</code>, piece and the list of objects.
	  *
	  *@param <code>nom</code> - name of the living thing.
	  *@param <code>monde</code> - the world of the living thing.
	  *@param <code>pointVie</code>.
	  *@param <code>pointForce</code>.
	  *@param <code>piece</code> - the piece where the living thing is.
	  *@param <code>objets</code> - the list of the objects.
	  *@exception NomDEntiteDejaUtiliseDansLeMondeException if the name of the living thing already exists in the world.
	  */
	public Vivant(String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet... objets) throws NomDEntiteDejaUtiliseDansLeMondeException{
	super(nom,monde);
	this.pointVie = pointVie;
	this.pointForce = pointForce;
	this.piece = piece;
	for(Objet o: objets){
		this.objets.put(o.getNom(), o);
	}
	piece.entrer(this);
	}

	/**
	  *Puts the object from the living thing into the piece.
	  *
	  *@param <code>obj</code> - the object to put into the piece.
	  *@exception ObjetNonPossedeParLeVivantException if the object is not removable.
	  */
	public void deposer(Objet obj) throws ObjetNonPossedeParLeVivantException{
		if(!(this.possede(obj)))
			throw new ObjetNonPossedeParLeVivantException("L'objet non deplacable.");
		if(this.possede(obj)){
			/*
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
			*/
			this.objets.remove(obj.getNom());
			this.getPiece().deposer(obj);
		}
	}
	
	/**
	  *Puts the object with the specified name from the living thing into the piece.
	  *
	  *@param <code>nomObj</code> - the name of the object to put into the piece.
	  *@exception ObjetNonPossedeParLeVivantException if the object is not removable.
	  */
	public void deposer(String nomObj) throws ObjetNonPossedeParLeVivantException{
		deposer((Objet)this.getMonde().getEntite(nomObj));
	}

	/**
	  *Checks whether the living thing is alive.
	  *
	  *@return false.
	  */
	public boolean estMort(){
		return false;
	}

	/**
	  *Gets the object with the specified detail name.
	  *
	  *@param <code>nomObjet</code> - the name of the object.
	  *@return the object.
	  */
	public Objet getObjet(String nomObjet){
		return (Objet)this.getMonde().getEntite(nomObjet);
	}

	/**
	  *Gets the list of objects.
	  *
	  *@return the list of objects.
	  */
	public HashMap<String,Objet> getObjets(){
		return this.objets;
	}

	/**
	  *Gets the piece.
	  *
	  *@return the piece.
	  */
	public Piece getPiece(){
		return this.piece;
	}

	/**
	  *Gets the <code>pointVie</code>.
	  *
	  *@return the <code>pointVie</code>.
	  */
	public int getPointVie(){
		return pointVie;
	}

	/**
	  *Gets the <code>pointForce</code>.
	  *
	  *@return the <code>pointForce</code>.
	  */
	public int getPointForce(){
		return pointForce;
	}

	/**
	  *Checks whether the living thing possesses the object.
	  *
	  *@param <code>obj</code> - the object.
	  *@return true if the living thing possesses the object, false otherwise.
	  */
	public boolean possede(Objet obj){
		/*
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
		*/
		return objets.containsKey(obj.getNom());
	}

	/**
	  *Takes the object from the piece and gives it to the living thing.
	  *
	  *@param <code>obj</code> - the object.
	  *@exception ObjetNonDeplacableException if the object is not removable.
	  *@exception ObjetAbsentDeLaPieceException if the object doesn't exists in the piece.
	  */
	public void prendre(Objet obj) throws ObjetNonDeplacableException, ObjetAbsentDeLaPieceException{
		if(!obj.estDeplacable())
			throw new ObjetNonDeplacableException("L'objet non deplacable.");
		if(!this.piece.contientObjet(obj))
			throw new ObjetAbsentDeLaPieceException("L'objet est absent de la piece.");
		/*
		int longueur = this.objets.length;
		Objet[] tmp = new Objet[longueur+1];
		System.arraycopy(objets,0,tmp,0,longueur);
		tmp[longueur] = this.getPiece().retirer(obj);
		this.objets = tmp;
		*/
		objets.put(obj.getNom(),obj);
	}

	/**
	  *Takes the object with the specified detail name from the piece and gives it to the living thing.
	  *
	  *@param <code>nomObj</code> - the name of the object.
	  *@exception ObjetNonDeplacableException if the object is not removable.
	  *@exception ObjetAbsentDeLaPieceException if the object doesn't exists in the piece.
	  */
	public void prendre(String nomObj)throws ObjetNonDeplacableException, ObjetAbsentDeLaPieceException{
		prendre((Objet)this.getMonde().getEntite(nomObj));
	}

	/**
	  *Activates the activable thing.
	  *
	  *@param <code>activable</code> - the activable thing.
	  */
	public void activerActivable(Activable activable) throws ActivationException{
		activable.activer();
	}

	/**
	  *Activates the activable thing with the specified object.
	  *
	  *@param <code>activable</code> - the activable thing.
	  *@param <code>objet</code> - the specified object.
	  */
	public void activerActivableAvecObjet(Activable activable, Objet objet) throws ActivationException{
		activable.activerAvec(objet);
	}

	/**
	  *Passes the specified door.
	  *
	  *@param <code>porte</code> - the door.
	  *@exception PorteFermeException if the door is closed.
	  *@exception PorteInexistanteDansLaPieceException if the door does not exists in the piece.
	  */
	public void franchir(Porte porte) throws PorteFermeException, PorteInexistanteDansLaPieceException{
		if(porte.getEtat() == Etat.FERME)
			throw new PorteFermeException("La porte est ferme.");
		if(this.getPiece().aLaPorte(porte) == false)
			throw new PorteInexistanteDansLaPieceException("La porte n'est pas dans la piece.");
		this.piece = porte.getPieceAutreCote(this.getPiece());
	}

	/**
	  *Passes the door with the specified name.
	  *
	  *@param <code>nomPorte</code> - the name of the door.
	  *@exception PorteFermeException if the door is closed.
	  *@exception PorteInexistanteDansLaPieceException if the door does not exists in the piece.
	  */
	public void franchir(String nomPorte) throws PorteFermeException, PorteInexistanteDansLaPieceException{
		franchir((Porte)this.getMonde().getEntite(nomPorte));
	}

	/**
	  *Sets the HP.
	  *
	  *@param <code>pointVie</code> - the HP of the living thing.
	  */
	public void setPointVie(int pointVie){
		this.pointVie = pointVie;
	}

    /**
	  *Sets the objects.
	  *
	  *@param <code>mapObjets</code> - the objects to replace the objects existing.
	  */
	protected void setObjets(HashMap<String,Objet> mapObjets){
		this.objets = mapObjets;
	}

	/**
	  *Returns the string which describes this living thing.
	  *
	  *@return the string which describes this living thing.
	  */
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
		/*
		int longueur = this.objets.length;
		for(int i=0;i<longueur;i++){
			s.append("Nom de l'objet: ");
			s.append(this.objets[i].getNom());
			s.append(".\n");
		}
		*/
		objets.forEach((string,objet) -> {
			s.append("Nom de l'objet: ");
			s.append(string);
			s.append(".\n");
		});
		return s.toString();
	}
}
