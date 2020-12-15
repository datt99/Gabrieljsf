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
@Table(name = "usuarios")
public class User {
    @Id
    @Column(name = "clave")
    private int id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "telefono")
    private String cellPhone;

    public User() {
    }

    public User(int id, String name, String cellPhone) {
        this.id = id;
        this.name = name;
        this.cellPhone = cellPhone;
    }

    public User(int id) {
        this.id = id;
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

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
    
    
    
}
