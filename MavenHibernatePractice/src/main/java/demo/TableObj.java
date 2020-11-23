package demo;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "test_table2")
public class TableObj {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int ID;

    @Column(name = "test_name")
    private String name;

    @Transient
    private String proba_transient;

    public TableObj() {
    }

    public TableObj(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProba_transient() {
        return proba_transient;
    }

    public void setProba_transient(String proba_transient) {
        this.proba_transient = proba_transient;
    }
}
