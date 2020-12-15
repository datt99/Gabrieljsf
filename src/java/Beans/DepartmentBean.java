package Beans;

import FactoryDao.DaoFactory;
import Idao.Idao;
import Models.Department;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author alsorc
 */
@ManagedBean(name ="departmentsBean")
@RequestScoped
public class DepartmentBean {

    private Department department;
    private int id;
    private Idao dao;
    private List<Department> records;
    
    public DepartmentBean() {
        department = new Department();
        dao = DaoFactory.getDao(DaoFactory.Type.DEPARTMENT);
        records = dao.readAllRecords();
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Idao getDao() {
        return dao;
    }

    public void setDao(Idao dao) {
        this.dao = dao;
    }

    public List<Department> getRecords() {
        return records;
    }

    public void setRecords(List<Department> records) {
        this.records = records;
    }
    
     public void saveData() {
        if (dao.inserOne(department)) {
            records = dao.readAllRecords();
            showMessage("Registro agregado con éxito!!");
        } else {
            showMessage("Ocurrió un error inesperado");
        }
    }

    public void deleteDepartment() {
        dao.deleteOne(id);
        records = dao.readAllRecords();
    }

    public void updateDepartment() {
        dao.updateOne(department);
        records = dao.readAllRecords();
    }
    
    public void showMessage(String text) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, text, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
        
}
