package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.hamcrest.core.IsEqual;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestObjet {
	public Monde monde;
	public Objet objet;

	@Before
	public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
		monde = new Monde("monde");
		objet = new Objet("test",monde){
			public boolean estDeplacable(){
				return true;
			}
		};
	}

	@Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
	public void testConstructeurs() throws NomDEntiteDejaUtiliseDansLeMondeException{
		assertThat(objet.getNom(), IsEqual.equalTo("test"));
		assertThat(objet.getMonde().getNom(), IsEqual.equalTo("monde"));
		Objet objet1 = new Objet("test",monde){
			public boolean estDeplacable(){
				return true;
			}
		};
	}
}
