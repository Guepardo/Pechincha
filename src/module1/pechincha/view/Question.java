package module1.pechincha.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module2.pechincha.manager.StorageLeilaoEnvironments;


public class Question extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
/*		Bora reduzir linhas n�
		ServletController sc = new ServletController(getServletContext().getRealPath("/"));
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(sc.process(request)); 
		out.close();
*/	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StorageLeilaoEnvironments.initialize();
		ServletController sc = new ServletController(getServletContext().getRealPath("/"));
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(sc.process(request)); 
		out.close();
	}

}
