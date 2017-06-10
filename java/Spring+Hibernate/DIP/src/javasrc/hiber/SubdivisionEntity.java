package javasrc.hiber;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by artem on 23.05.2017.
 */
@Entity
@Table(name = "subdivision", schema = "public", catalog = "DbFD")
public class SubdivisionEntity {
    private int id;
    private String name;
    private String designation;
    private Integer idSubdivPartOf;
    private Collection<PersonEoEntity> personEosById;
    private Collection<SubdivisionEntity> subdivisionsById;

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

    @Basic
    @Column(name = "id_subdiv_part_of", nullable = true)
    public Integer getIdSubdivPartOf() {
        return idSubdivPartOf;
    }

    public void setIdSubdivPartOf(Integer idSubdivPartOf) {
        this.idSubdivPartOf = idSubdivPartOf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubdivisionEntity that = (SubdivisionEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (designation != null ? !designation.equals(that.designation) : that.designation != null) return false;
        if (idSubdivPartOf != null ? !idSubdivPartOf.equals(that.idSubdivPartOf) : that.idSubdivPartOf != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (designation != null ? designation.hashCode() : 0);
        result = 31 * result + (idSubdivPartOf != null ? idSubdivPartOf.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "subdivisionByIdSubdivision")
    public Collection<PersonEoEntity> getPersonEosById() {
        return personEosById;
    }

    public void setPersonEosById(Collection<PersonEoEntity> personEosById) {
        this.personEosById = personEosById;
    }


    @OneToMany(mappedBy = "subdivisionByIdSubdivPartOf")
    public Collection<SubdivisionEntity> getSubdivisionsById() {
        return subdivisionsById;
    }

    public void setSubdivisionsById(Collection<SubdivisionEntity> subdivisionsById) {
        this.subdivisionsById = subdivisionsById;
    }
}
