package fr.jeanaurore.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.jeanaurore.model.Client;
import fr.jeanaurore.model.Compte;
import fr.jeanaurore.service.IService;
import fr.jeanaurore.service.ServiceImpl;

/**
 * Ce Servlet gère l'affichage de tous les comptes d'un client.
 */
@WebServlet("/ServletCompte")
public class ServletCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final IService service = new ServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCompte() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		afficherListeCompte(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			afficherListeCompte(request, response);
	}
	
	private void afficherListeCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		int idClient;

		if (request.getParameter("id") == null) {
			idClient = (int) session.getAttribute("idClient");
		} else {
			String idClientStr = request.getParameter("id");
			// Conversion string /int
			idClient = Integer.parseInt(idClientStr);
			session = request.getSession();
			session.setAttribute("idClient", idClient);
		}
		
		

		ArrayList<Compte> liste = service.getAllCompteByIdClient(idClient);

		if (liste.isEmpty()) {

			Client client = service.getClientById(idClient);

			session.setAttribute("msgErreur", "Le client " + client.getNom() + " n'as pas de compte ouvert.");

			session.setAttribute("retour", "ServletAuthentif");

			RequestDispatcher disp = request.getRequestDispatcher("/ServletError");
			disp.forward(request, response);
		} else {

			session.setAttribute("liste", liste);

			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/show-compte-by-client.jsp");
			disp.forward(request, response);
		}
	}

}
