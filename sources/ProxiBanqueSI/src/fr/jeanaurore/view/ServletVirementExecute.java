package fr.jeanaurore.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.jeanaurore.model.Compte;
import fr.jeanaurore.service.IService;
import fr.jeanaurore.service.ServiceImpl;

/**
 * Ce Servlet execute le virement transmis par la requête puis redirige vers la liste des clients.
 */
@WebServlet("/ServletVirementExecute")
public class ServletVirementExecute extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final IService service = new ServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletVirementExecute() {
		super();

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		Compte compteSource = (Compte) session.getAttribute("compte");

		String idDest = request.getParameter("idCompteDest");
		int idCompteDest = Integer.parseInt(idDest);

		String montantStr = request.getParameter("montant");
		double montant = Double.parseDouble(montantStr);

		Compte compteDest = service.getCompteById(idCompteDest);

		service.faireVirement(compteSource, compteDest, montant);

		session.setAttribute("idClient", compteSource.getClient().getId());

		RequestDispatcher disp = request.getRequestDispatcher("/ServletCompte");
		disp.forward(request, response);

	}
	

}
