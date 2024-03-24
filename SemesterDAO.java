package DAO;

import Model.Semester;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SemesterDAO {
    public Semester register(Semester semester) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(semester);
            transaction.commit();
            return semester;
        } catch (Exception e) {
            // Handle exception (e.g., log error)
            e.printStackTrace();
            return null;
        }
    }

    public List<Semester> allsemesters() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Semester", Semester.class).list();
        } catch (Exception e) {
            // Handle exception (e.g., log error)
            e.printStackTrace();
            return null;
        }
    }
}
