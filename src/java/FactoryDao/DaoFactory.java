package FactoryDao;

import Dao.CredentialsDao;
import Dao.DepartmentsDao;
import Dao.UserDao;
import Idao.Idao;
import com.sun.istack.internal.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author alsorc
 */
public class DaoFactory {
    
    public enum Type{ 
        USERDAO, CREDENTIALS, DEPARTMENT
    }
    
    public static Idao getDao(Type type){
        Idao dao= null;
        switch(type){
            case USERDAO:
                dao = new UserDao();
                break;
            case CREDENTIALS:
                dao = new CredentialsDao();
                break;
            case DEPARTMENT:
                dao = new DepartmentsDao();
                break;
            default:
                Logger.getLogger(DaoFactory.class).setLevel(Level.SEVERE);
        }
        return dao;
    }
    
}
