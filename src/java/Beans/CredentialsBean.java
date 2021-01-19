package Beans;

import Dao.CredentialsDao;
import Models.MyUser;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Daniel
*/
@ManagedBean(name = "credentialsBean")
@RequestScoped
public class CredentialsBean {
    
    private String username;
    private String password;
    private CredentialsDao dao;

    public CredentialsBean() {
        dao = new CredentialsDao();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CredentialsDao getDao() {
        return dao;
    }

    public void setDao(CredentialsDao dao) {
        this.dao = dao;
    }
 
    
    public String login(){
        return dao.validateUser(username, password);
    }
    
    public void validateSession() throws IOException{
        MyUser user = (MyUser) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        if(user == null){
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        }
    }
    
    
    
}
