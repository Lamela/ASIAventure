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

public class TestPiedDeBiche{
	public Monde monde;
	public PiedDeBiche pdb;

	@Before
	public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
		monde = new Monde("monde");
		pdb = new PiedDeBiche("test",monde);
	}

	@Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
	public void testConstructeurs() throws NomDEntiteDejaUtiliseDansLeMondeException{
		assertThat(pdb.getNom(), IsEqual.equalTo("test"));
		assertThat(pdb.getMonde().getNom(), IsEqual.equalTo("monde"));
		PiedDeBiche pdb1 = new PiedDeBiche("test",monde);
	}
}
	

