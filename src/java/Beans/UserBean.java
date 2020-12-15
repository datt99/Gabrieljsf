package Beans;

import FactoryDao.DaoFactory;
import Idao.Idao;
import Models.User;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author alsorc
 */
@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean {

    private User user;
    private int id;
    private Idao dao;
    private List<User> records;
    
    public UserBean() {
        user = new User();
        dao = DaoFactory.getDao(DaoFactory.Type.USERDAO);
        records = dao.readAllRecords();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<User> getRecords() {
        return records;
    }

    public void setRecords(List<User> records) {
        this.records = records;
    }

    public void saveData() {
        if (dao.inserOne(user)) {
            records = dao.readAllRecords();
            showMessage("Registro agregado con éxito!!");
        } else {
            showMessage("Ocurrió un error inesperado");
        }
    }

    public void deleteUser() {
        dao.deleteOne(id);
        records = dao.readAllRecords();
    }

    public void updateUser() {
        dao.updateOne(user);
        records = dao.readAllRecords();
    }

    public void showMessage(String text) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, text, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }


}
