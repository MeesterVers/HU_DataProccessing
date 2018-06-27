package nl.hu.dp;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    private static String orclcfg = "nl.hu.ict.jpa.oracle";
    private static EntityManagerFactory entityManagerFactory;

    public static void main(String[] args) {
        // get the Hibernate - JPA entityManager
        EntityManager em = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(orclcfg);
            em = entityManagerFactory.createEntityManager();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        /*
         * Aanmaken van de domein objecten
         */
        OVChipkaart kaart = new OVChipkaart();
        kaart.setKaartopdruk("mijn eerste kaart");

        /*
         * Opslaan van de data in de domein objecten
         */
        em.getTransaction().begin();
        em.persist(kaart);
        em.getTransaction().commit();

        em.close();
        System.out.println("-- einde --");
    }
}
