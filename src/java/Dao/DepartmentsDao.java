package Dao;

import Connection.HibernateUtil;
import Idao.Idao;
import Models.Department;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author alsorc
 */
public class DepartmentsDao implements Idao<Department, Integer>{

    private SessionFactory sessionFactory;
    private Session session;
    
    public DepartmentsDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    

    @Override
    public boolean inserOne(Department model) {
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
        session.delete(new Department(idModel));
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean updateOne(Department model) {
       session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(model);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Department readOne(Integer idModel) {
         session = sessionFactory.openSession();
        session.beginTransaction();
        Department data = (Department) session.get(Department.class, idModel);
        session.getTransaction().commit();
        session.close();
        return data;
    }

    @Override
    public List<Department> readAllRecords() {
        session = sessionFactory.openSession();
        Query query = session.createQuery("from Department");
        List data = query.list();
        session.close();
        return data;
    }
    
}
