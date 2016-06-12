package jpqltest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * @author heitor
 * @since 12/05/16.
 */
class SpringDataUtil {
    private static final ApplicationContext SPRING_CONTEXT =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    private static final EntityManagerFactory emf =
            (EntityManagerFactory) SPRING_CONTEXT.getBean("entityManagerFactory");

    static synchronized ApplicationContext getSpringContext() {
        return SPRING_CONTEXT;
    }

    static synchronized EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    static synchronized EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void main(String[] args) {
        EntityManager etmf = getEntityManager();
        emf.close();
    }
}
