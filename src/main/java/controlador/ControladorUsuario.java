package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClassUsuarioImp;




/**
 * Servlet implementation class ControladorUsuario
 */
public class ControladorUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   // Recuperamos los valores del formulario
        String usuario = request.getParameter("nombre");
        String contraseña = request.getParameter("contraseña");

        // Instanciamos las entidades
        ClassUsuarioImp crud = new ClassUsuarioImp();
        
        // Validamos el usuario y contraseña
        boolean usuarioValido = crud.ValidarUsuario(usuario, contraseña);
        
        if (usuarioValido) {
            // Redireccionamos si el usuario es válido
            response.sendRedirect("index.jsp"); 
        } else {
            // Si el usuario no es válido, redirigimos a la misma pagina que valida el usuario
            request.getRequestDispatcher("/loginCL3.jsp").forward(request, response);
	}

}}
