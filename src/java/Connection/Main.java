package Connection;


import FactoryDao.DaoFactory;
import Idao.Idao;
import Models.Department;
import Models.User;
import java.util.List;

/**
 *
 * @author alsorc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Idao dao = DaoFactory.getDao(DaoFactory.Type.DEPARTMENT);
//        System.out.println(dao.inserOne(new Department(1,"Cafe", "Comida cool")));
//        System.out.println(dao.inserOne(new Department(2,"Cafe", "Comida cool")));
//        System.out.println(dao.inserOne(new Department(3,"Cafe", "Comida cool")));
//        System.out.println(dao.inserOne(new Department(4,"Cafe", "Comida cool")));
        //System.out.println(dao.deleteOne(1));
        List<Department> lista = dao.readAllRecords();
        
        for (Department dep : lista) {
            System.out.println(dep.getId() + " " + dep.getName() + " " + dep.getDescription());
        }
        
        
    }
    
}
