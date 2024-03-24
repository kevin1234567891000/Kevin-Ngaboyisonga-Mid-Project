package DAO;

import DAO.HibernateUtil;
import Model.StudentCourse;
import org.hibernate.Session;

public class StudentCourseDAO {
    public StudentCourse registerStudent(StudentCourse stdobj)
    {
        try
        {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(stdobj);
            ss.beginTransaction().commit();
            ss.close();
            return stdobj;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
