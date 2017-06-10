package javasrc.hiber;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by artem on 23.05.2017.
 */
@Entity
@Table(name = "var_of_muitiplicity", schema = "public", catalog = "DbFD")
public class VarOfMuitiplicityEntity {
    private int id;
    private String name;
    private String designation;
    private Collection<CharactEntity> charactsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "designation", nullable = true, length = -1)
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VarOfMuitiplicityEntity that = (VarOfMuitiplicityEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (designation != null ? !designation.equals(that.designation) : that.designation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (designation != null ? designation.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "varOfMuitiplicityByIdMuitiplicity")
    public Collection<CharactEntity> getCharactsById() {
        return charactsById;
    }

    public void setCharactsById(Collection<CharactEntity> charactsById) {
        this.charactsById = charactsById;
    }
}
