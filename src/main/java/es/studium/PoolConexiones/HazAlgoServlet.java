package es.studium.PoolConexiones;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "HazAlgoServlet", urlPatterns = { "/hazalgo" })
public class HazAlgoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.println("<!DOCTYPE html>");
			out.println("<html lang=\"es\">");
			out.println("<head>");
			out.println("<title>Haciendo algo</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>Haciendo algo...</h2>");
// Recuperar el nombre de usuario
			String usuario;
			HttpSession session = request.getSession(false);
			if (session == null) {
				out.println("<h3>No has iniciado sesión</h3>");
			} else {
				synchronized (session) {
					usuario = (String) session.getAttribute("usuario");
				}
				out.println("<table>");
				out.println("<tr>");
				out.println("<td>Usuario:</td>");
				out.println("<td>" + usuario + "</td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("<p><a href='logout'>Salir</a></p>");
			}
			out.println("</body>");
			out.println("</html>");
		} finally {
// Cerramos objetos
			out.close();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}