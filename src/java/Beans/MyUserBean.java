/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import FactoryDao.DaoFactory;
import Idao.Idao;
import Models.MyUser;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author elDantru99
 */
@ManagedBean(name ="myUserBean")
@RequestScoped
public class MyUserBean {
    
    private MyUser myUser;
    private long id;
    private Idao dao;
    private List<MyUser> records;
    private boolean update = false;
    
    public MyUserBean() {
        myUser = new MyUser();
        dao = DaoFactory.getDao(DaoFactory.Type.MYUSER);
        records = dao.readAllRecords();
    }

    public MyUser getMyUser() {
        return myUser;
    }

    public void setMyUser(MyUser myUser) {
        this.myUser = myUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Idao getDao() {
        return dao;
    }

    public void setDao(Idao dao) {
        this.dao = dao;
    }

    public List<MyUser> getRecords() {
        return records;
    }

    public void setRecords(List<MyUser> records) {
        this.records = records;
    }
    
    public void saveUser(){
        if(!update){
            dao.inserOne(myUser);
        }else{
            dao.updateOne(myUser);
            update = false;
        }   
        
        records = dao.readAllRecords();
    }
    
    public void deleteUser(){
        
    }
    
    public void deleteTeam() {
        dao.deleteOne(id);
        records = dao.readAllRecords();
    }

    public void updateTeam() {
        update = true;
        //dao.updateOne(myUser);
        //records = dao.readAllRecords();
    }
    
    public void showMessage(String text) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, text, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    
    
    
    
    
}
