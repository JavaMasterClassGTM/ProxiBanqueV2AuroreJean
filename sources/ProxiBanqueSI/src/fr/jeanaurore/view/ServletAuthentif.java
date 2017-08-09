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
import fr.jeanaurore.service.IService;
import fr.jeanaurore.service.ServiceImpl;

/**
 * Ce servlet gère l'authentification des utilisateurs puis redirige vers la liste des clients. 
 * 
 * @author Aurore et Jean
 */
@WebServlet("/ServletAuthentif")
public class ServletAuthentif extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final IService service = new ServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAuthentif() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		afficherListeClient(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			afficherListeClient(request, response);
	}
	
	/**
	 * Méthode redirigeant vers show-clients.jsp
	 * 
	 *
	 */
	
	private void afficherListeClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Client> liste = service.getAllClient();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("liste",liste);
		
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/show-clients.jsp");
		disp.forward(request, response);
	}

}
