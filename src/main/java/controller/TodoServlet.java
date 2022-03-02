package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Todo;
import model.TodoDAO;

@WebServlet("/todo")
public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public TodoServlet() {
        super();
        System.out.println("servlet works");
        // TODO Auto-generated constructor stub
    }
//   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/plain");
	     response.setCharacterEncoding("utf-8");
		  String todoDesc = request.getParameter("addTodoField");
		  System.out.println(todoDesc);
		  if(!todoDesc.isBlank()) {
			TodoDAO todos = new TodoDAO ();
			Todo todo = new Todo();
			todo.setTodoDesc(todoDesc);
			todos.insert(todo);
			System.out.println();
			
		  }
		

	}

}
