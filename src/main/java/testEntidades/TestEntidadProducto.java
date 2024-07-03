package testEntidades;
import dao.ClassProdImp;
import model.TblProductocl3;
public class TestEntidadProducto {

	public static void main(String[] args) {
	//instanciamos
		TblProductocl3 producto=new TblProductocl3();
		ClassProdImp crud=new ClassProdImp();
		
		producto.setNombrecl3("Televisor");
		producto.setPrecioVentcl3(100);
		producto.setPrecioCompcl3(1000);
		producto.setEstadocl3("Nuevo");
		producto.setDescripcl3("Made in China");
		
		crud.RegistrarProducto(producto);

	}

}
