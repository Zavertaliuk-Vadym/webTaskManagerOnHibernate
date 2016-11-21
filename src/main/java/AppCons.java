import console.ConsoleRunner;

import org.hibernate.SessionFactory;
import util.HibernateUtil;

public class AppCons {
    public static void main(String[] args) {
        System.out.println("Hibernate one to many (Annotation)");
        SessionFactory session = HibernateUtil.getSessionFactory();
        new ConsoleRunner(session);
        System.out.println("Done");
    }
}
