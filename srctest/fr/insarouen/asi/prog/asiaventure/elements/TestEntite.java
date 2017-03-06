package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.hamcrest.core.IsEqual;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class TestEntite {
	public Monde monde;
	public Monde monde1;
	public Entite entite1;
	public Entite entite2;
	public Entite entite3;
	public Entite entite4;

	@Before
	public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
		monde = new Monde("monde");
		monde1 = new Monde("monde1");
		entite1 = new Entite("test",monde){};
		entite2 = new Entite("test1",monde){};
		entite3 = new Entite("test",monde1){};
		entite4 = new Entite("test1",monde1){};
	}

	@Test
	public void testConstructeurs() throws NomDEntiteDejaUtiliseDansLeMondeException{
		assertThat(entite1.getNom(), IsEqual.equalTo("test"));
		assertThat(entite1.getMonde().getNom(), IsEqual.equalTo("monde"));
	}

	@Test
	public void testEquals() throws NomDEntiteDejaUtiliseDansLeMondeException{
		assertTrue(entite1.equals((Object)entite1));
		assertFalse(entite1.equals((Object)entite2));
		assertFalse(entite1.equals((Object)entite3));
		assertFalse(entite1.equals((Object)entite4));
	}
}
