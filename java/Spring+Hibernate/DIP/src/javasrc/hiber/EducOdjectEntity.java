package javasrc.hiber;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by artem on 23.05.2017.
 */
@Entity
@Table(name = "educ_odject", schema = "public", catalog = "DbFD")
public class EducOdjectEntity {
    private int id;
    private String name;
    private String designation;
    private Integer idClassifier;
    private Collection<CharactValueEntity> charactValuesById;
    private Collection<PersonEoEntity> personEosById;
    private Collection<PositionEoEntity> positionEosById;
    private Collection<PositionEoEntity> positionEosById_0;

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
    @Column(name = "id_classifier", nullable = true)
    public Integer getIdClassifier() {
        return idClassifier;
    }

    public void setIdClassifier(Integer idClassifier) {
        this.idClassifier = idClassifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EducOdjectEntity that = (EducOdjectEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (designation != null ? !designation.equals(that.designation) : that.designation != null) return false;
        if (idClassifier != null ? !idClassifier.equals(that.idClassifier) : that.idClassifier != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (designation != null ? designation.hashCode() : 0);
        result = 31 * result + (idClassifier != null ? idClassifier.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "educOdjectByIdEo")
    public Collection<CharactValueEntity> getCharactValuesById() {
        return charactValuesById;
    }

    public void setCharactValuesById(Collection<CharactValueEntity> charactValuesById) {
        this.charactValuesById = charactValuesById;
    }

    @OneToMany(mappedBy = "educOdjectByIdEo")
    public Collection<PersonEoEntity> getPersonEosById() {
        return personEosById;
    }

    public void setPersonEosById(Collection<PersonEoEntity> personEosById) {
        this.personEosById = personEosById;
    }

    @OneToMany(mappedBy = "educOdjectByIdEo")
    public Collection<PositionEoEntity> getPositionEosById() {
        return positionEosById;
    }

    public void setPositionEosById(Collection<PositionEoEntity> positionEosById) {
        this.positionEosById = positionEosById;
    }

    @OneToMany(mappedBy = "educOdjectByIdInEo")
    public Collection<PositionEoEntity> getPositionEosById_0() {
        return positionEosById_0;
    }

    public void setPositionEosById_0(Collection<PositionEoEntity> positionEosById_0) {
        this.positionEosById_0 = positionEosById_0;
    }
}
