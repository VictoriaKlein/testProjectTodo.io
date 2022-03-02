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

@WebServlet("/login")
public class LogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		UserDAO uDAO = new UserDAO();
		boolean valid = uDAO.get(new User(userName, password));
	if (userName.isBlank()||password.isBlank()||valid == false) {
		String error = "Wrong input. Try again";
		request.setAttribute("error", error);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	} else {
		System.out.println("validate");
		HttpSession session = request.getSession();
		session.setAttribute("username", userName);
		response.sendRedirect("todoList.jsp");
	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
