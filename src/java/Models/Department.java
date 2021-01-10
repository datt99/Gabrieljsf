package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author alsorc
 */
@Entity
@Table(name = "departamentos")
public class Department {
    @Id
    @Column(name = "clave")
    private int id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "descripcion")
    private String description;

    public Department() {
    }

    public Department(int id) {
        this.id = id;
    }
        
    public Department(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
