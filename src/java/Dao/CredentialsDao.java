/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.HibernateUtil;
import Idao.Idao;
import Models.MyUser;
import java.util.List;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Daniel
 */
public class CredentialsDao {

    private SessionFactory sessionFactory;
    private Session session;

    public CredentialsDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public String validateUser(String username, String password) {
        session = sessionFactory.openSession();
        Query query = session.createQuery("from MyUser where email = ? and password = ?");
        query.setString(0, username);
        query.setString(1, password);
        MyUser data = (MyUser) query.uniqueResult();
        if (data != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", data);
            return "welcome.xhtml?faces-redirect=true";
        } else {
            return "login";
        }

    }

}
