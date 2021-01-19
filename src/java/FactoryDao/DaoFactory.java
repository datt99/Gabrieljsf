package FactoryDao;

import Dao.MyUserDao;
import Dao.TeamDao;
import Idao.Idao;

/**
 *
 * @author elDantru99
 */
public class DaoFactory {

    public enum Type {

        TEAM, MYUSER
    }

    public static Idao getDao(Type type) {
        Idao dao = null;
        switch (type) {
            case TEAM:
                dao = new TeamDao();
                break;
            case MYUSER:
                dao = new MyUserDao();
                break;
            default:
                dao = null;
        }
        return dao;
    }

}
