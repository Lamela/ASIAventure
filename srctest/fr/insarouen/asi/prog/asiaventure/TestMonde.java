package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import org.junit.After;
import org.junit.Before;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import static org.junit.Assert.assertThat;

public class TestMonde {
	public Monde monde;
	public Monde monde1;
	public Entite entite;
	public Entite entite1;
	
	@Before
	public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
		monde = new Monde("monde");
		entite = new Entite("test",monde){};
	}

	@Test
	public void testConstructeurs() {
		assertThat(monde.getNom(), IsEqual.equalTo("monde"));
	}

	@Test
	public void testGetEntite() {
		assertThat(monde.getEntite("test"), IsEqual.equalTo(entite));
	}

	@Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
	public void testAjouter1() throws NomDEntiteDejaUtiliseDansLeMondeException, EntiteDejaDansUnAutreMondeException{
		monde.ajouter(entite);
	}
	@Test(expected = EntiteDejaDansUnAutreMondeException.class)
	public void testAjouter2() throws EntiteDejaDansUnAutreMondeException, NomDEntiteDejaUtiliseDansLeMondeException{
		monde1 = new Monde("monde1");
		entite1 = new Entite("test1",monde1){};
		monde.ajouter(entite1);
	}
}

