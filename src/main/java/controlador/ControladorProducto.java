package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClassProdImp;
import model.TblProductocl3;

/**
 * Servlet implementation class ControladorProducto
 */
public class ControladorProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProducto() {
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
		//recuperamos los valores del formulario
				String nombre=request.getParameter("nombre");
				double precio=Double.parseDouble(request.getParameter("precio"));
				double precioVen=Double.parseDouble( request.getParameter("precioVen"));
				String estado=request.getParameter("estado");
				String descrip=request.getParameter("descrip");
				
				
				//Instanciamos las entidades
				TblProductocl3 producto=new TblProductocl3();
				ClassProdImp crud=new ClassProdImp();
				//asignamos valores
				producto.setNombrecl3(nombre);
				producto.setPrecioCompcl3(precio);
				producto.setPrecioVentcl3(precioVen);
				producto.setEstadocl3(estado);
				producto.setDescripcl3(descrip);
				//invocamos al método registrar
				crud.RegistrarProducto(producto);
				//redireccionamos
				request.getRequestDispatcher("/RegistrarProducto.jsp").forward(request, response);
				
				
				doGet(request, response);
	}

}
