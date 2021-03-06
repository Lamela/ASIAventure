package fr.insarouen.asi.prog.asiaventure.elements.vivants;
			
import java.util.*;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.hamcrest.core.IsEqual;
import static org.junit.Assert.assertThat;

public class TestVivant{
	public Monde monde;
	public int pointVie;
	public int pointForce;
	public Piece piece;
	public Objet objet1;
	public Objet objet2;
	public Objet objet3;
	public Objet objet4;
	public Objet objet5;
	public Objet objet6;
	public Vivant vivant;
	public HashMap<String,Objet> objets1 = new HashMap<>();
	public Objet[] objets2 = new Objet[2];

	@Before
	public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
		monde = new Monde("monde");
		piece = new Piece("piece",monde){};
		pointVie = 500;
		pointForce = 200;
		objet1 = new Objet("objetDeplacable1",monde){
			public boolean estDeplacable(){
				return true;
				}
		};
		objet2 = new Objet("objetDeplacable2",monde){
			public boolean estDeplacable(){
				return true;
				}
		};
		objet4 = new Objet("objetNotInTest1",monde){
			public boolean estDeplacable(){
				return true;
			}
		};
		objet5 = new Objet("objetNotInTest2",monde){
			public boolean estDeplacable(){
				return false;
			}
		};
		objet6 = new Objet("objetNotInTest3",monde){
			public boolean estDeplacable(){
				return true;
			}
		};
		piece.deposer(objet4);
		piece.deposer(objet5);
		objets2[0] = objet1;
		objets2[1] = objet2;
		objets1.put(objet1.getNom(),objet1);
		objets1.put(objet2.getNom(),objet2);
		vivant = new Vivant("test",monde,pointVie,pointForce,piece,objets2);
	}

	@Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
	public void testConstructeurs() throws NomDEntiteDejaUtiliseDansLeMondeException{
		assertThat(vivant.getNom(), IsEqual.equalTo("test"));
		assertThat(vivant.getMonde().getNom(), IsEqual.equalTo("monde"));
		assertThat(vivant.getPointForce(), IsEqual.equalTo(pointForce));
		assertThat(vivant.getPointVie(), IsEqual.equalTo(pointVie));
		assertThat(vivant.getPiece(), IsEqual.equalTo(piece));
		assertThat(vivant.getObjets(), IsEqual.equalTo(objets1));
		Vivant vivant1 = new Vivant("test",monde,700,20,piece,objets2);
	}

	@Test(expected = ObjetNonPossedeParLeVivantException.class)
	public void testDeposer() throws ObjetNonPossedeParLeVivantException{
		vivant.deposer(objet1);
		assertThat(vivant.possede(objet1), IsEqual.equalTo(false));
		vivant.deposer("objetDeplacable2");
		assertThat(vivant.possede(objet2), IsEqual.equalTo(false));
		vivant.deposer(objet5);
	}

	@Test
	public void testEstMort(){
		assertThat(vivant.estMort(), IsEqual.equalTo(false));
	}

	@Test
	public void testGetObjet(){
		assertThat(vivant.getObjet("objetDeplacable1").getNom(), IsEqual.equalTo("objetDeplacable1"));
	}

	@Test
	public void testGetObjets(){
		assertThat(vivant.getObjets(), IsEqual.equalTo(objets1));
	}

	@Test
	public void testGetPiece(){
		assertThat(vivant.getPiece().getNom(), IsEqual.equalTo("piece"));
	}

	@Test
	public void testGetPointVie(){
		assertThat(vivant.getPointVie(), IsEqual.equalTo(pointVie));
	}
		
	@Test
	public void testGetPointForce(){
		assertThat(vivant.getPointForce(), IsEqual.equalTo(pointForce));
	}

	@Test
	public void testPossede(){
		assertThat(vivant.possede(objet1), IsEqual.equalTo(true));
	}

	@Test(expected = ObjetNonDeplacableException.class)
	public void testPrendre1() throws ObjetNonDeplacableException, ObjetAbsentDeLaPieceException{
		vivant.prendre(objet4);
		assertThat(vivant.possede(objet4), IsEqual.equalTo(true));
		vivant.prendre(objet5);
	}

	@Test(expected = ObjetAbsentDeLaPieceException.class)
	public void testPrendre2() throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
		vivant.prendre(objet6);
	}
}
