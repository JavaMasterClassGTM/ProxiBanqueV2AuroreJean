package fr.jeanaurore.model;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.jeanaurore.dao.DaoImplCompte;

public class DaoImplCompteTest {
	
	private static final DaoImplCompte dao = new DaoImplCompte();
	
	@Test
	public void updateCompteTest() {
		Compte compte = dao.selectCompteById(6);
		compte.setSolde(500.0);
		dao.updateCompte(compte);
		
		compte = dao.selectCompteById(6);
		
		assertEquals("500.0",((Double)compte.getSolde()).toString());
	}

}
