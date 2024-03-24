package DAO;


import Model.CourseDefinition;
import org.hibernate.Hibernate;
import org.hibernate.Session;

public class CourseDefinDAO{
    public CourseDefinition register(CourseDefinition definition)
    {
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(definition);
            ss.beginTransaction().commit();
            ss.close();
            return definition;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
