package fr.insarouen.asi.prog.asiaventure;

import java.util.*;
import java.io.*;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Clef;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Serrure;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.JoueurHumain;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Monstre;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.Executable;

/**
  *A simulator to play this game.
  *
  *@author Lu Chenxin.
  *@serial
  */
public class Simulateur implements java.io.Serializable{
	private Monde monde;
	private EtatDuJeu etatDuJeu;
	private List<ConditionDeFinVivantDansPiece> cdf = new ArrayList<ConditionDeFinVivantDansPiece>();

	/**
	  *Constructs a simulator with an objectInputStream.
	  *
	  *@param <code>ois</code> - the objectInputStream.
	  */
	public Simulateur(ObjectInputStream ois) throws IOException, ClassNotFoundException{
		this.monde = (Monde)ois.readObject();
	}

	/**
	  *Constructs a simulator with a file.
	  *
	  *@param <code>reader</code> - the reader of file.
	  */
	public Simulateur(Reader reader) throws NomDEntiteDejaUtiliseDansLeMondeException{
		Scanner sc = new Scanner(reader);
		while(sc.hasNext()){
			switch(sc.next()){
				case "Monde":
					construitMonde(sc);
					break;
				case "Piece": 
					construitPiece(sc);
					break;
				case "PorteSerrure": 
					construitPorteSerrure(sc);
					break;
				case "Porte":
					construitPorte(sc);
					break;
				case "Clef": 
					construitClef(sc);
					break;
				case "JoueurHumain":
					construitJoueurHumain(sc);
					break;
				case "ConditionDeFinVivantDansPiece":
					construitConditionDeFin(sc);
					break;
				default:
					break;
			}
		}
	}

	/**
	  *Gets the world where the simulator in.
	  *
	  *@return the world.
	  */
	public Monde getMonde(){
		return this.monde;
	}

	/**
	  *Gets the collection of the conditions to finish this game when a living thing in a piece.
	  *
	  *@return the collection of the conditions to finish this game when a living thing in a piece..
	  */
	private Collection<ConditionDeFinVivantDansPiece> getConditionsDeFin(){
		return this.cdf;
	}

	/**
	  *Constructs a world with the input of user.
	  *
	  *@param <code>sc</code> - the Scanner.
	  */
	private void construitMonde(Scanner sc) throws NomDEntiteDejaUtiliseDansLeMondeException{
		this.monde = new Monde(sc.next());
	}

	/**
	  *Constructs a piece with the input of user.
	  *
	  *@param <code>sc</code> - the Scanner.
	  */
	private void construitPiece(Scanner sc) throws NomDEntiteDejaUtiliseDansLeMondeException{
		new Piece(sc.next(), this.monde);
	}

	/**
	  *Constructs a door with the lock with the input of user.
	  *
	  *@param <code>sc</code> - the Scanner.
	  */
	private void construitPorteSerrure(Scanner sc) throws NomDEntiteDejaUtiliseDansLeMondeException{
		Serrure serrure = new Serrure(this.monde);
		new Porte(sc.next(), this.monde, serrure, (Piece)this.monde.getEntite(sc.next()), (Piece)this.monde.getEntite(sc.next()));
	}

	/**
	  *Constructs a door with the input of user.
	  *
	  *@param <code>sc</code> - the Scanner.
	  */
    private void construitPorte(Scanner sc) throws NomDEntiteDejaUtiliseDansLeMondeException{
		new Porte(sc.next(), this.monde, (Piece)this.monde.getEntite(sc.next()), (Piece)this.monde.getEntite(sc.next()));
	}

	/**
	  *Constructs a key with the input of user.
	  *
	  *@param <code>sc</code> - the Scanner.
	  */
	private void construitClef(Scanner sc) throws NomDEntiteDejaUtiliseDansLeMondeException{
		Clef clef = ((Porte)this.monde.getEntite(sc.next())).getSerrure().creerClef();
		((Piece)this.monde.getEntite(sc.next())).deposer(clef);
	}
	
	/**
	  *Constructs a player with the input of user.
	  *
	  *@param <code>sc</code> - the Scanner.
	  */
	private void construitJoueurHumain(Scanner sc) throws NomDEntiteDejaUtiliseDansLeMondeException{
		new JoueurHumain(sc.next(), this.monde, sc.nextInt(), sc.nextInt(), (Piece)this.monde.getEntite(sc.next()));
	}

	/**
	  *Constructs a condition to finish the game with the input of user.
	  *
	  *@param <code>sc</code> - the Scanner.
	  */
	private void construitConditionDeFin(Scanner sc){
		EtatDuJeu etat=EtatDuJeu.ENCOURS;
		String tmp = sc.next();
		if(tmp=="SUCCES")
			etat = EtatDuJeu.SUCCES;
		else if(tmp == "ECHEC")
			etat = EtatDuJeu.ECHEC;
		ajouterConditionDeFin(new ConditionDeFinVivantDansPiece(etat,(Vivant)this.monde.getEntite(sc.next()),(Piece)this.monde.getEntite(sc.next())));
	}

	/**
	  *Adds a condition to finish the game.
	  *
	  *@param <code>condition</code> - the condition to finish the game to add.
	  */
	public void ajouterConditionDeFin(ConditionDeFinVivantDansPiece condition){
		this.cdf.add(condition);
	}

	/**
	  *Saves the file to objectOutputStream after playing the game.
	  *
	  *@param <code>oos</code> - the objectOutputStream.
	  */
	public void enregistrer(ObjectOutputStream oos) throws IOException{
		oos.writeObject(this.getMonde());
		for (ConditionDeFinVivantDansPiece conditionDeFinVivantDansPiece: getConditionsDeFin()) {
            oos.writeObject(conditionDeFinVivantDansPiece);
		}
        oos.flush();
	}

	/**
	  *Executes the game for a tour.
	  */
	public EtatDuJeu executerUnTour() throws Throwable{
		Collection<Executable> executable = this.monde.getExecutable();
		for(Executable ex: executable){
			if(ex instanceof JoueurHumain){
				System.out.println(((JoueurHumain)ex).toString());
				try{
					((JoueurHumain)ex).executer();
				}catch(ASIAventureException e){
					System.out.println(e.getMessage());
				}
			}
			else if(ex instanceof Monstre){
				((Monstre)ex).executer();
			}
			else if(ex instanceof ConditionDeFinVivantDansPiece){
				((ConditionDeFinVivantDansPiece)ex).verifierCondition();
			}
		}
		return null;
	}
	
	/**
	  *Executes the game until the end.
	  */
	public EtatDuJeu executerJusquALaFin() throws Throwable{
		while(this.etatDuJeu != EtatDuJeu.SUCCES && this.etatDuJeu != EtatDuJeu.ECHEC){
			this.etatDuJeu = this.executerUnTour();
		}
		return this.etatDuJeu;
	}
}	
