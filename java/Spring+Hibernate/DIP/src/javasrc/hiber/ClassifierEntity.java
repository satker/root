package javasrc.hiber;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by artem on 23.05.2017.
 */
@Entity
@Table(name = "classifier", schema = "public", catalog = "DbFD")
public class ClassifierEntity {
    private int id;
    private Integer idParent;
    private String name;
    private String designation;
    private Collection<CharactClassEntity> charactClassesById;
    private Collection<ClassifierEntity> classifiersById;
    private Collection<EducOdjectEntity> educOdjectsById;
    private Collection<ValidClassEntity> validClassesById;
    private Collection<ValidClassEntity> validClassesById_0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_parent", nullable = true)
    public Integer getIdParent() {
        return idParent;
    }

    public void setIdParent(Integer idParent) {
        this.idParent = idParent;
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

        ClassifierEntity that = (ClassifierEntity) o;

        if (id != that.id) return false;
        if (idParent != null ? !idParent.equals(that.idParent) : that.idParent != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (designation != null ? !designation.equals(that.designation) : that.designation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idParent != null ? idParent.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (designation != null ? designation.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "classifierByIdClassifier")
    public Collection<CharactClassEntity> getCharactClassesById() {
        return charactClassesById;
    }

    public void setCharactClassesById(Collection<CharactClassEntity> charactClassesById) {
        this.charactClassesById = charactClassesById;
    }

    @OneToMany(mappedBy = "classifierByIdParent")
    public Collection<ClassifierEntity> getClassifiersById() {
        return classifiersById;
    }

    public void setClassifiersById(Collection<ClassifierEntity> classifiersById) {
        this.classifiersById = classifiersById;
    }

    @OneToMany(mappedBy = "classifierByIdClassifier")
    public Collection<EducOdjectEntity> getEducOdjectsById() {
        return educOdjectsById;
    }

    public void setEducOdjectsById(Collection<EducOdjectEntity> educOdjectsById) {
        this.educOdjectsById = educOdjectsById;
    }

    @OneToMany(mappedBy = "classifierByIdClassifier")
    public Collection<ValidClassEntity> getValidClassesById() {
        return validClassesById;
    }

    public void setValidClassesById(Collection<ValidClassEntity> validClassesById) {
        this.validClassesById = validClassesById;
    }

    @OneToMany(mappedBy = "classifierByIdValidClass")
    public Collection<ValidClassEntity> getValidClassesById_0() {
        return validClassesById_0;
    }

    public void setValidClassesById_0(Collection<ValidClassEntity> validClassesById_0) {
        this.validClassesById_0 = validClassesById_0;
    }
}
