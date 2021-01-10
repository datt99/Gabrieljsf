/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import FactoryDao.DaoFactory;
import Idao.Idao;
import Models.Team;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author elDantru99
 */
@ManagedBean(name ="teamBean")
@RequestScoped
public class TeamBean {
    
    private Team team;
    private long id;
    private Idao dao;
    private List<Team> records;
    
    public TeamBean() {
        team = new Team();
        dao = DaoFactory.getDao(DaoFactory.Type.TEAM);
        records = dao.readAllRecords();
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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

    public List<Team> getRecords() {
        return records;
    }

    public void setRecords(List<Team> records) {
        this.records = records;
    }
    
    public void saveTeam(){
        if(dao.inserOne(team)){
            records = dao.readAllRecords();
            showMessage("Registro agregado con éxito!!");
        } else {
            showMessage("Ocurrió un error inesperado");
        }    
    }
    
    public void deleteTeam() {
        dao.deleteOne(id);
        records = dao.readAllRecords();
    }

    public void updateDepartment() {
        dao.updateOne(team);
        records = dao.readAllRecords();
    }
    
    public void showMessage(String text) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, text, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
