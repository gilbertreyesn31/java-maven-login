package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.PrintWriter;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private java.sql.Connection conexion = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter mensajes = response.getWriter();
		mensajes.println("Yo voy a recibir la información<br>");
		mensajes.println("El nombre que has enviado es:"+request.getParameter("nombre")+"<br>");
		mensajes.println("El e-mail que has enviado es:"+request.getParameter("email")+"<br>");
		
		try{
			
			Class.forName("org.gjt.mm.mysql.Driver");
			conexion = java.sql.DriverManager.getConnection("jdbc:mysql://sql3.freesqldatabase.com:3306/sql3226493", "sql3226493", "LbVGhVereQ");
			Statement s = conexion.createStatement();
			s.executeUpdate("INSERT INTO entradas VALUES(NULL, '"+request.getParameter("nombre")+"'  , '"+request.getParameter("email")+"' )");
			mensajes.println("Tu registro se ha guardado correctamente");
			conexion.close();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
