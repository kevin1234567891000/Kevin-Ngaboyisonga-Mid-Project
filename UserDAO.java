package DAO;

import Model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserDAO {
    public User register(User userobj){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.save(userobj);
            session.beginTransaction().commit();
            session.close();
            return userobj;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public User login(User userobj)
    {
        try
        {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.beginTransaction();
            String qry="FROM user WHERE email = :email AND password = :password";
            Query query = ss.createQuery(qry);
            query.setParameter("email",userobj.getEmail());
            query.setParameter("password",userobj.getPassword());
            User users = (User) query.uniqueResult();
            ss.getTransaction().commit();
            ss.close();
            return users;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}