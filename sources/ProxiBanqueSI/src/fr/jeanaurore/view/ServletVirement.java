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
 * Ce Servlet conduit à un formulaire permettant de faire un virement compte à compte.
 */
@WebServlet("/ServletVirement")
public class ServletVirement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final IService service = new ServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVirement() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		afficherFormVirement(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		afficherFormVirement(request, response);
	}

	private void afficherFormVirement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int idCompte=Integer.parseInt(id);
		Compte cpt= service.getCompteById(idCompte);
		
		HttpSession session = request.getSession();
		session.setAttribute("compte", cpt);
		
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/virement.jsp");
		disp.forward(request, response);
		
	}
}
