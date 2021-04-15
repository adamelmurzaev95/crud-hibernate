package dao;

import model.Programmer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class ProgrammerDAO {

    public Programmer findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Programmer programmer = session.get(Programmer.class, id);
        session.close();
        return programmer;
    }

    public void save(Programmer programmer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(programmer);
        transaction.commit();
        session.close();
    }

    public void update(Programmer programmer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(programmer);
        transaction.commit();
        session.close();
    }

    public void delete(Programmer programmer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(programmer);
        transaction.commit();
        session.close();
    }

    public List<Programmer> findAllProgrammers() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Programmer> programmers = (List<Programmer>) (session.createQuery("From Programmer").list());
        session.close();
        return programmers;
    }
}
