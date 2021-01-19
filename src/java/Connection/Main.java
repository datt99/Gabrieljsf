package Connection;

import FactoryDao.DaoFactory;
import Idao.Idao;
import Models.MyUser;

/**
 *
 * @author DaniTru
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Idao dao = DaoFactory.getDao(DaoFactory.Type.MYUSER);
        dao.readAllRecords().stream().forEach((record) -> {
            System.out.println(((MyUser) record).getEmail());
        });
    }
}
