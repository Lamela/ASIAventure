package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import java.util.*;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteInexistanteDansLaPieceException;

/**
  *A player.
  *
  *@author Lu Chenxin
  @serial
  */
public class JoueurHumain extends Vivant{
	String ordre;

	/**
	  *Constructs a player with the specified detail name, world, <code>pointVie</code>, <code>pointForce</code>, piece and the list of objects.
	  *
	  *@param <code>nom</code> - name of the player.
	  *@param <code>monde</code> - the world of the player.
	  *@param <code>pointVie</code>.
	  *@param <code>pointForce</code>.
	  *@param <code>piece</code> - the piece where the player is.
	  *@param <code>objets</code> - the list of the objects.
	  *@exception NomDEntiteDejaUtiliseDansLeMondeException if the name of the player already exists in the world.
	  */
	public JoueurHumain(String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet... objets) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom,monde,pointVie,pointForce,piece,objets);
	}

	/**
	  *Sets an order.
	  *
	  *@param <code>ordre</code> - the order to set.
	  */
	public void setOrdre(String ordre){
		this.ordre = ordre;
	}

	/**
	  *Passes a command to take the object.
	  *
	  *@param <code>nomObjet</code> - the name of the object.
	  */
	private void commandPrendre(String nomObjet) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
		this.prendre(nomObjet);
	}

	/**
	  *Passes a command to put the object.
	  *
	  *@param <code>nomObjet</code> - the name of the object.
	  */
	private void commandPoser(String nomObjet) throws ObjetNonPossedeParLeVivantException{
		this.deposer(nomObjet);
	}

	/**
	  *Passes a command to cross a door.
	  *
	  *@param <code>nomPorte</code> - the name of the door.
	  */
	private void commandFranchir(String nomPorte) throws PorteFermeException, PorteInexistanteDansLaPieceException{
		this.franchir(nomPorte);
	}

	/**
	  *Passes a command to open a door.
	  *
	  *@param <code>nomPorte</code> - the name of the door.
	  */
	private void commandOuvrirPorte(String nomPorte) throws ActivationException, PorteInexistanteDansLaPieceException{
		this.activerActivable((Porte)this.getMonde().getEntite(nomPorte));
	}

	/**
	  *Passes a command to cross a door with a specified object.
	  *
	  *@param <code>nomPorte</code> - the name of the door.
	  *@param <code>nomObjet</code> - the name of the object.
	  */
	private void commandOuvrirPorte(String nomPorte, String nomObjet) throws ActivationException, PorteInexistanteDansLaPieceException, ObjetNonPossedeParLeVivantException{
		this.activerActivableAvecObjet((Porte)this.getMonde().getEntite(nomPorte), (Objet)this.getMonde().getEntite(nomObjet));
	}

	/**
	  *Executes the commands.
	  */
	public void executer() throws Throwable{
		try{
			System.out.println("Entrer un commande, svp.");
			Scanner sc = new Scanner(System.in);
			this.setOrdre(sc.nextLine());
			String[] tableauDesCommandes = this.ordre.split(" ");
			Class[] tableauDesParametresFormels = new Class[tableauDesCommandes.length-1];
			for(int i=0;i<tableauDesCommandes.length-1;i++)
				tableauDesParametresFormels[i] = String.class;
			int nbParametre = tableauDesParametresFormels.length;
			String[] tableauDesParams = new String[nbParametre];
			for(int i=0;i<nbParametre;i++)
				tableauDesParams[i] = tableauDesCommandes[i+1];
			String s = "command" + tableauDesCommandes[0];
			Method method = this.getClass().getDeclaredMethod(s, tableauDesParametresFormels);
			method.invoke(this, (Object[])tableauDesParams);		
		}catch(InvocationTargetException e){
			throw e.getCause();
		}catch(Exception e){
			throw new CommandeImpossiblePourLeVivantException("commande impossible"+this.ordre);
		}
	}
}
