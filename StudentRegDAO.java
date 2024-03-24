package DAO;

import DAO.HibernateUtil;

import Model.Student;
import Model.StudentReg;
import org.hibernate.Session;

public class StudentRegDAO {
    public Student save(Student obj)
    {
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(obj);
            ss.beginTransaction().commit();
            ss.close();
            return obj;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
