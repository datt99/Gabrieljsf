/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author alsorc
 */
@Entity
@Table(name = "team")
public class Team {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer championships;

    public Team(String name, Integer championships) {
        this.name = name;
        this.championships = championships;
    }

    public Team(Long idModel) {
       this.id = idModel;
    }

    public Team() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getChampionships() {
        return championships;
    }

    public void setChampionships(Integer championships) {
        this.championships = championships;
    }
    
    

    
}
