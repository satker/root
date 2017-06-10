package javasrc.hiber;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by artem on 23.05.2017.
 */
@Entity
@Table(name = "charact", schema = "public", catalog = "DbFD")
public class CharactEntity {
    private int id;
    private String name;
    private String designation;
    private Integer idTypeCharact;
    private Integer idMuitiplicity;
    private Collection<CharactClassEntity> charactClassesById;
    private Collection<CharactValueEntity> charactValuesById;

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
    @Column(name = "id_type_charact", nullable = true)
    public Integer getIdTypeCharact() {
        return idTypeCharact;
    }

    public void setIdTypeCharact(Integer idTypeCharact) {
        this.idTypeCharact = idTypeCharact;
    }

    @Basic
    @Column(name = "id_muitiplicity", nullable = true)
    public Integer getIdMuitiplicity() {
        return idMuitiplicity;
    }

    public void setIdMuitiplicity(Integer idMuitiplicity) {
        this.idMuitiplicity = idMuitiplicity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharactEntity that = (CharactEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (designation != null ? !designation.equals(that.designation) : that.designation != null) return false;
        if (idTypeCharact != null ? !idTypeCharact.equals(that.idTypeCharact) : that.idTypeCharact != null)
            return false;
        if (idMuitiplicity != null ? !idMuitiplicity.equals(that.idMuitiplicity) : that.idMuitiplicity != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (designation != null ? designation.hashCode() : 0);
        result = 31 * result + (idTypeCharact != null ? idTypeCharact.hashCode() : 0);
        result = 31 * result + (idMuitiplicity != null ? idMuitiplicity.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "charactByIdCharact")
    public Collection<CharactClassEntity> getCharactClassesById() {
        return charactClassesById;
    }

    public void setCharactClassesById(Collection<CharactClassEntity> charactClassesById) {
        this.charactClassesById = charactClassesById;
    }

    @OneToMany(mappedBy = "charactByIdCharact")
    public Collection<CharactValueEntity> getCharactValuesById() {
        return charactValuesById;
    }

    public void setCharactValuesById(Collection<CharactValueEntity> charactValuesById) {
        this.charactValuesById = charactValuesById;
    }

}
