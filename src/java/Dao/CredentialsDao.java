/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.HibernateUtil;
import Idao.Idao;
import Models.UserCredentials;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author alsorc
 */
public class CredentialsDao implements Idao<UserCredentials, Integer> {

    private SessionFactory sessionFactory;
    private Session session;

    public CredentialsDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean inserOne(UserCredentials model) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Serializable save = session.save(model);
        session.getTransaction().commit();
        session.close();
        return save != null;
    }

    @Override
    public boolean deleteOne(Integer idModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateOne(UserCredentials model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserCredentials readOne(Integer idModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserCredentials> readAllRecords() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String validateUser(String username, String password) {
        session = sessionFactory.openSession();
        Query query = session.createQuery("from UserCredentials where username = ? and password = ?");
        query.setString(0, username);
        query.setString(1, password);
        UserCredentials data = (UserCredentials) query.uniqueResult();
        if (data != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", data);
            return "welcome.xhtml?faces-redirect=true";
        } else {
            return "login";
        }

    }

}
