package beginnersBookDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class KellyServlet
 */
@WebServlet("/welcome")
public class MyServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String mymsg;
	
	public void init() throws ServletException {
	mymsg = "Hello World!";
	}

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServletDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// Setting up the content type of webpage
		//response.setContentType("text/html");

		// Writing message to the web page
		//PrintWriter out = response.getWriter();
		//out.println("<h1>" + mymsg + "</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String u = "haseeb";
		String p = "123";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(u.equals(username) || p.equals(password))
		{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
		rd.forward(request, response);
		}
		else {
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		RequestDispatcher rd = request.getRequestDispatcher("/fail.jsp");
		rd.forward(request, response);
		}

	}
	
	public void destroy() {
		/* leaving empty for now this can be
		* used when we want to do something at the end
		* of Servlet life cycle
		*/
		}

}
