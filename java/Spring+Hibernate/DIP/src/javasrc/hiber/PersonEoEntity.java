package javasrc.hiber;

import javax.persistence.*;

/**
 * Created by artem on 23.05.2017.
 */
@Entity
@Table(name = "person_eo", schema = "public", catalog = "DbFD")
public class PersonEoEntity {
    private int id;
    private Integer idPerson;
    private Integer idEo;
    private Integer idPos;
    private Integer idSubdivision;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_person", nullable = true)
    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    @Basic
    @Column(name = "id_eo", nullable = true)
    public Integer getIdEo() {
        return idEo;
    }

    public void setIdEo(Integer idEo) {
        this.idEo = idEo;
    }

    @Basic
    @Column(name = "id_pos", nullable = true)
    public Integer getIdPos() {
        return idPos;
    }

    public void setIdPos(Integer idPos) {
        this.idPos = idPos;
    }

    @Basic
    @Column(name = "id_subdivision", nullable = true)
    public Integer getIdSubdivision() {
        return idSubdivision;
    }

    public void setIdSubdivision(Integer idSubdivision) {
        this.idSubdivision = idSubdivision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonEoEntity that = (PersonEoEntity) o;

        if (id != that.id) return false;
        if (idPerson != null ? !idPerson.equals(that.idPerson) : that.idPerson != null) return false;
        if (idEo != null ? !idEo.equals(that.idEo) : that.idEo != null) return false;
        if (idPos != null ? !idPos.equals(that.idPos) : that.idPos != null) return false;
        if (idSubdivision != null ? !idSubdivision.equals(that.idSubdivision) : that.idSubdivision != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idPerson != null ? idPerson.hashCode() : 0);
        result = 31 * result + (idEo != null ? idEo.hashCode() : 0);
        result = 31 * result + (idPos != null ? idPos.hashCode() : 0);
        result = 31 * result + (idSubdivision != null ? idSubdivision.hashCode() : 0);
        return result;
    }

}
