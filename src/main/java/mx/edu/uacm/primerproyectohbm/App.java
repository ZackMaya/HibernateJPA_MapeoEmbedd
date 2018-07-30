package mx.edu.uacm.primerproyectohbm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    		//JPA proporciona dentro de la clase Persistence
		//un metodo createEntityManagerFactory
		//que nos permite cargar el archivo de configuracion
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJPA_MapeoEmbedd");
		
		//Creamos un entitymanager
		//similar al session de hibernate
		EntityManager em = emf.createEntityManager();
		
		User user = new User();
		user.setId(1);
		user.setUserName("sergio");
		user.setUserMessage("bienvenido a jpa");
		
		User user2 = new User();
		user2.setId(2);
		user2.setUserName("juan");
		user2.setUserMessage("esto es jpa si funciona");
		
		//Inicio de transaccion a traves de entitymanager
		em.getTransaction().begin();
		
		//nombre del metodo para almacenar se llama persist
		
		em.persist(user);
		em.persist(user2);
		
		em.getTransaction().commit();
		
		//Metodos de cierre
		em.close();
		emf.close();
    }
}
