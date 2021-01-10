package FactoryDao;

import Dao.CredentialsDao;
import Dao.DepartmentsDao;
import Dao.MyUserDao;
import Dao.TeamDao;
import Dao.UserDao;
import Idao.Idao;
import com.sun.istack.internal.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author elDantru99
 */
public class DaoFactory {
    
    public enum Type{ 
        USERDAO, CREDENTIALS, DEPARTMENT, TEAM, MYUSER
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
            case TEAM:
                dao = new TeamDao();
                break;
            case MYUSER:
                dao = new MyUserDao();
            default:
                Logger.getLogger(DaoFactory.class).setLevel(Level.SEVERE);
        }
        return dao;
    }
    
}
