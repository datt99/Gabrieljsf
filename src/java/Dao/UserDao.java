package Dao;

import Connection.HibernateUtil;
import Idao.Idao;
import Models.User;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author alsorc
 */
public class UserDao implements Idao<User, Integer>{

    private SessionFactory sessionFactory;
    private Session session;
    
    public UserDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    @Override
    public boolean inserOne(User model) {
        Serializable save = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            save  = session.save(model);
            session.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e);
            return false;
        }finally{
         session.close();   
        }
        return true;
    }

    @Override
    public boolean deleteOne(Integer idModel) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(new User(idModel));
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean updateOne(User model) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(model);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public User readOne(Integer idModel) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        User data = (User) session.get(User.class, idModel);
        session.getTransaction().commit();
        session.close();
        return data;
    }

    @Override
    public List<User> readAllRecords() {
        session = sessionFactory.openSession();
        Query query = session.createQuery("from User");
        List data = query.list();
        session.close();
        return data;
    }
    
}
