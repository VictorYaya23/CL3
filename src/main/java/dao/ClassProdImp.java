package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.Iproducto;
import model.TblProductocl3;

public class ClassProdImp implements Iproducto{

	@Override
	public void RegistrarProducto(TblProductocl3 producto) {
//		Establecer conexión con la unidad de persistencia
			EntityManagerFactory fabr=Persistence.createEntityManagerFactory("ExamenFinalCL3");
			// Permite gestionar entidades
			EntityManager em=fabr.createEntityManager();
			//Iniciar Transacción
			em.getTransaction().begin();
			//Registramos
			em.persist(producto);
			//Emitimos mensaje por consola
			System.out.println("Producto Registrado");
			//Confirmamos
			em.getTransaction().commit();
			//Cerramos la transacción
			em.close();
			//fin del método registrar....
		
	}

	@Override
	public List<TblProductocl3> ListadoProducto() {
		//Establecemos la conexión con la unidad de persistencia 
		EntityManagerFactory em=Persistence.createEntityManagerFactory("ExamenFinalCL3");
			//gestionamos entidades
		EntityManager emanager=em.createEntityManager();
			//iniciamos la transacción 
		emanager.getTransaction().begin();
			//recuperamos el codigo del listado de la bd producto
			//Aplicamos consultas JPQL,el metodo createquery(), sirve para hacer consultas dinamicas
		List<TblProductocl3> listado=emanager.createQuery("select c from tbl_productocl3 c",TblProductocl3.class).getResultList();
			//confirmamos
		emanager.getTransaction().commit();
			//cerramos
		emanager.close();
			//retornamos el listado producto en la base de datos
		return listado;
	}

	@Override
	public void ActualizarProducto(TblProductocl3 producto) {
		//Establecer conexión con la unidad de persistencia 	
				EntityManagerFactory em=Persistence.createEntityManagerFactory("ExamenFinalCL3");
				//Gestionar las entidades
				EntityManager emanager=em.createEntityManager();
				//Iniciamos la transacción
				emanager.getTransaction().begin();
				//Actualizar
				emanager.merge(producto);
				//emitimos el mensaje
				System.out.println("Producto Actualizado en BD");	
				//confirmamos 
				emanager.getTransaction().commit();
				//cerramos 
				emanager.close();
		
	}

	@Override
	public void EliminarProducto(TblProductocl3 producto) {
		//Establecemos la conexión con la unidad de persistencia 
		EntityManagerFactory em=Persistence.createEntityManagerFactory("ExamenFinalCL3");
		//Gestionar las entidades
		EntityManager emanager=em.createEntityManager();
		//iniciamos la transacción
		emanager.getTransaction().begin();
		//recuperamos el codigo a eliminar
		TblProductocl3 elim=emanager.merge(producto);
		//procedemos a eliminar
		emanager.remove(elim);
		//Emitimos mensaje por consola 
		System.out.println("Producto eliminado de la BD");
		//Confirmamos
		emanager.getTransaction().commit();
		//Cerramos
		emanager.close();
		
	}

}
