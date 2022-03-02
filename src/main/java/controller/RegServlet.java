package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserDAO;

@WebServlet("/reg")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String userName = request.getParameter("username");
	String password = request.getParameter("password");
if (userName.isBlank()||password.isBlank()) {
	String error = "Wrong input. Try again";
	request.setAttribute("error", error);
	request.getRequestDispatcher("/RegPage.jsp").forward(request, response);
} else {
	UserDAO uDAO = new UserDAO();
	uDAO.save(new User(userName, password));
	System.out.println("new user added");
	HttpSession session = request.getSession();
	session.setAttribute("username", userName);
	response.sendRedirect("WelcomePage.jsp");
}
	
	}

}
