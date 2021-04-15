package utils;

import model.Programmer;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil(){

    }

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            try {
                Configuration conf = new Configuration().configure();
                conf.addAnnotatedClass(Programmer.class);
                StandardServiceRegistryBuilder builder =
                        new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
                sessionFactory = conf.buildSessionFactory(builder.build());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
