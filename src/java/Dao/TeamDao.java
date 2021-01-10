package Dao;

import Connection.HibernateUtil;
import Idao.Idao;
import Models.Team;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author elDantru99
 */
public class TeamDao implements Idao<Team,Long>{
    
    private SessionFactory sessionFactory;
    private Session session;

    public TeamDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean inserOne(Team model) {
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
        session.delete(new Team(idModel));
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean updateOne(Team model) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(model);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Team readOne(Long idModel) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Team data = (Team) session.get(Team.class, idModel);
        session.getTransaction().commit();
        session.close();
        return data;
    }

    @Override
    public List<Team> readAllRecords() {
        session = sessionFactory.openSession();
        Query query = session.createQuery("from Team");
        List data = query.list();
        session.close();
        return data;
    }
    
    
    
    
    
}
