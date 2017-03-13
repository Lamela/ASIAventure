package fr.insarouen.asi.prog.asiaventure.elements.vivants;
			
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.hamcrest.core.IsEqual;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

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
	public Objet[] objets = new Objet[3];

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
		objet3 = new Objet("objetNotDeplacable",monde){
			public boolean estDeplacable(){
				return false;
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
		vivant = new Vivant("test",monde,pointVie,pointForce,piece,objet1,objet2,objet3);
		objets[0] = objet1;
		objets[1] = objet2;
		objets[2] = objet3;
	}

	@Test(expected = ObjetNonDeplacableException.class)
	public void testDeposer1() throws ObjetNonDeplacableException{
		vivant.deposer(objet1);
		assertFalse(vivant.possede(objet1));
		vivant.deposer(objet3);
	}

	@Test(expected = ObjetNonDeplacableException.class)
	public void testDeposer2() throws ObjetNonDeplacableException{
		vivant.deposer("objetDeplacable2");
		assertFalse(vivant.possede(objet2));
		vivant.deposer(objet3);
	}

	@Test
	public void testEstMort(){
		assertFalse(vivant.estMort());
	}

	@Test
	public void testGetObjet(){
		assertThat(vivant.getObjet("objetDeplacable1").getNom(), IsEqual.equalTo("objetDeplacable1"));
	}

	@Test
	public void testGetObjets(){
		assertThat(vivant.getObjets(), IsEqual.equalTo(objets));
	}

	@Test
	public void testGetPiece(){
		assertThat(vivant.getPiece().getNom(), IsEqual.equalTo("piece"));
	}

	@Test
	public void testGetPointVie(){
		assertTrue(vivant.getPointVie() == pointVie);
	}
		
	@Test
	public void testGetPointForce(){
		assertTrue(vivant.getPointForce() == pointForce);
	}

	@Test
	public void testPossede(){
		assertTrue(vivant.possede(objet1));
	}

	@Test(expected = ObjetNonDeplacableException.class)
	public void testPrendre1() throws ObjetNonDeplacableException, ObjetAbsentDeLaPieceException{
		vivant.prendre(objet4);
		assertTrue(vivant.possede(objet4));
		piece.deposer(objet4);
		vivant.prendre("objetNotInTest1");
		assertTrue(vivant.possede(objet4));
		vivant.prendre(objet5);
	}

	@Test(expected = ObjetAbsentDeLaPieceException.class)
	public void testPrendre2() throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
		vivant.prendre(objet6);
	}
}
