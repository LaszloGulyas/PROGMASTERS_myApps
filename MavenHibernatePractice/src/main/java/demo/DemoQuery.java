package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DemoQuery {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        System.out.println("Connecting to DB");
        TableObj tableObj = new TableObj();
        tableObj.setName("laca");


        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(tableObj);
            session.getTransaction().commit();
        }

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            int n = 0;
            while (session.get(tableObj.getClass(), ++n) != null) {
                System.out.println(session.get(tableObj.getClass(), n).getName());
            }
        }
    }
}
