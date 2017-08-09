package fr.jeanaurore.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fr.jeanaurore.service.ServiceImpl;

public class ServiceImplTest {

	ServiceImpl service = new ServiceImpl();

	@Test
	public void testGetClientById1() {

		Client client = service.getClientById(1);

		String nom = client.getNom();

		assertEquals("jägger", nom);
	}

	@Test
	public void testGetClientById0() {

		Client client = service.getClientById(0);

		assertEquals("", client.getNom());

	}

	@Test
	public void testGetAllCompteByIdClient() {
		
		Compte compte1 = service.getCompteById(1);
		compte1.setSolde(100.0);
		service.updateCompte(compte1);
		
		Compte compte3 = service.getCompteById(3);
		compte3.setSolde(222.0);
		service.updateCompte(compte3);

		ArrayList<Compte> liste = service.getAllCompteByIdClient(1);

		StringBuilder string = new StringBuilder();

		for (Compte compte : liste) {
			string.append(((Double) compte.getSolde()).toString());
			string.append(" ");
		}

		assertEquals("100.0 222.0 ", string.toString());
	}
	
	@Test
	public void testFaireVirement0() {
		Compte compteSource = service.getCompteById(6);
		compteSource.setSolde(200.0);
		service.updateCompte(compteSource);
		Compte compteDest = service.getCompteById(7);
		compteDest.setSolde(0);
		service.updateCompte(compteDest);
		service.faireVirement(compteSource, compteDest, 100);
		assertEquals("100.0", ((Double)compteSource.getSolde()).toString());
	}

}
