package fr.insarouen.asi.prog.asiaventure.elements.structure;

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

public class TestElementStructurel{
	public Monde monde;
	public ElementStructurel es;

	@Before
	public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
		monde = new Monde("monde");
		es = new ElementStructurel("test",monde){
			public boolean estDeplacable(){
				return true;
			}
		};
	}

	@Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
	public void testConstructeurs() throws NomDEntiteDejaUtiliseDansLeMondeException{
		assertThat(es.getNom(), IsEqual.equalTo("test"));
		assertThat(es.getMonde().getNom(), IsEqual.equalTo("monde"));
		ElementStructurel es1 = new ElementStructurel("test",monde){
			public boolean estDeplacable(){
				return true;
			}
		};
	}
}
