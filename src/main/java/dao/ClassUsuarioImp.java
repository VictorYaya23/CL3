package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import interfaces.Iusuario;
import model.TblUsuariocl3;

public class ClassUsuarioImp implements Iusuario {

	@Override
	public boolean ValidarUsuario(String usuario, String contraseña) {
		 EntityManagerFactory emFactory = null;
	        EntityManager em = null;
	        try {
	            // Crear la conexión con la unidad de persistencia
	            emFactory = Persistence.createEntityManagerFactory("ExamenFinalCL3");
	            em = emFactory.createEntityManager();
	            
	            // Iniciar Transacción
	            em.getTransaction().begin();
	            
	            // Realizar la consulta para verificar si existe el usuario con la contraseña dada
	            String query = "SELECT u FROM TblUsuariocl3 u WHERE u.usuariocl3 = :usuario AND u.passwordcl3 = :contraseña";
	            TblUsuariocl3 result = em.createQuery(query, TblUsuariocl3.class)
	                                .setParameter("usuario", usuario)
	                                .setParameter("contraseña", contraseña)
	                                .getSingleResult();
	            
	            // Confirmar transacción
	            em.getTransaction().commit();
	            
	            // Si la consulta no lanza una excepción, el usuario existe
	            return result != null;
	        } catch (NoResultException e) {
	            // Si no se encuentra el usuario, se lanza una excepción que atrapamos aquí
	            return false;
	        } catch (Exception e) {
	            // Si ocurre cualquier otro error, se revierte la transacción
	            if (em != null && em.getTransaction().isActive()) {
	                em.getTransaction().rollback();
	            }
	            e.printStackTrace();
	            return false;
	        } finally {
	            // Cerrar el EntityManager y EntityManagerFactory
	            if (em != null) {
	                em.close();
	            }
	            if (emFactory != null) {
	                emFactory.close();
	            }
	        }
	    }
	}


