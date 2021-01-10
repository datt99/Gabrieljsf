package Dao;

import Connection.HibernateUtil;
import Idao.Idao;
import Models.MyUser;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author elDantru99
 */
public class MyUserDao implements Idao<MyUser, Long>{
    
    private SessionFactory sessionFactory;
    private Session session;

    public MyUserDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean inserOne(MyUser model) {
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
    public boolean deleteOne(Long idModel) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(new MyUser(idModel));
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean updateOne(MyUser model) {
         session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(model);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public MyUser readOne(Long idModel) {
         session = sessionFactory.openSession();
        session.beginTransaction();
        MyUser data = (MyUser) session.get(MyUser.class, idModel);
        session.getTransaction().commit();
        session.close();
        return data;
    }

    @Override
    public List<MyUser> readAllRecords() {
       session = sessionFactory.openSession();
        Query query = session.createQuery("from MyUser");
        List data = query.list();
        session.close();
        return data;
    }
    
    

    
    
}
