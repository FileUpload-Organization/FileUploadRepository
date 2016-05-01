package org.fileupload.util;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * JPA Util
 * 
 * @author Ugur Cankaya
 */
public class JpaUtil {

    private static EntityManagerFactory emf = null;

    public JpaUtil() {
    }

    /**
     * Create entity manager factory.
     *
     * @return entity manager factory from persistence unit
     */
    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("FileUpload");
        }
        return emf;
    }

    /**
     * Close the entity manager factory.
     */
    public static void closeEntityManagerFactory() {
        if (emf != null) {
            emf.close();
        }
    }

    /**
     * Gets new entity manager instance.
     *
     * @return new entity manager instance
     */
    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

}
