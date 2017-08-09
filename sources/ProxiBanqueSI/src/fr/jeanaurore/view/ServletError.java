package fr.jeanaurore.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Ce Servlet redirige vers une page d'erreur affichant un message transmis par la requête entrante.
 */
@WebServlet("/ServletError")
public class ServletError extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletError() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		showErrorMessage(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		showErrorMessage(request, response);
	}
	
	public void showErrorMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		HttpSession session = request.getSession();
		
		String errorText = (String) session.getAttribute("msgErreur");
		
		session.setAttribute("messageErreur", errorText);

		
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/erreur.jsp");
		
		
		disp.forward(request, response);
	}

}
