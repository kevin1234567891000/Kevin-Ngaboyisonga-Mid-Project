package DAO;

import Model.AcademicUnit;
import Model.CourseEnum;
import org.hibernate.Session;

import java.util.List;

public class AcademicUDAO {
    public AcademicUnit register(AcademicUnit academicUnit) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(academicUnit);
            session.getTransaction().commit();
            session.close();
            return academicUnit; // Return the saved AcademicUnit object
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Return null in case of an error
        }
    }

    public List<AcademicUnit> getFacultyAndPrograms() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            List<AcademicUnit> academicUnits = session.createQuery("select ad from AcademicUnit ad where programType = :faculty or programType = :program")
                    .setParameter("faculty", CourseEnum.FACULTY)
                    .setParameter("program", CourseEnum.PROGRAM)
                    .list();
            
            session.close();
            return academicUnits;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<AcademicUnit> getDepartments() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            List<AcademicUnit> academicUnits = session.createQuery("select ad from AcademicUnit ad where programType = :department")
                    .setParameter("department", CourseEnum.DEPARTMENT)
                    .list();
            
            session.close();
            return academicUnits;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<AcademicUnit> getAllAcademicUnits() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            List<AcademicUnit> academicUnits = session.createQuery("from AcademicUnit").list();

            session.getTransaction().commit();
            session.close();
            return academicUnits;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

