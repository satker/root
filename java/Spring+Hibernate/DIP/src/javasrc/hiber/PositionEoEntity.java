package javasrc.hiber;

import javax.persistence.*;

/**
 * Created by artem on 23.05.2017.
 */
@Entity
@Table(name = "position_eo", schema = "public", catalog = "DbFD")
public class PositionEoEntity {
    private int id;
    private Integer idEo;
    private Integer idInEo;
    private Integer numPosition;


    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "id_in_eo", nullable = true)
    public Integer getIdInEo() {
        return idInEo;
    }

    public void setIdInEo(Integer idInEo) {
        this.idInEo = idInEo;
    }

    @Basic
    @Column(name = "num_position", nullable = true)
    public Integer getNumPosition() {
        return numPosition;
    }

    public void setNumPosition(Integer numPosition) {
        this.numPosition = numPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PositionEoEntity that = (PositionEoEntity) o;

        if (id != that.id) return false;
        if (idEo != null ? !idEo.equals(that.idEo) : that.idEo != null) return false;
        if (idInEo != null ? !idInEo.equals(that.idInEo) : that.idInEo != null) return false;
        if (numPosition != null ? !numPosition.equals(that.numPosition) : that.numPosition != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idEo != null ? idEo.hashCode() : 0);
        result = 31 * result + (idInEo != null ? idInEo.hashCode() : 0);
        result = 31 * result + (numPosition != null ? numPosition.hashCode() : 0);
        return result;
    }


}
