package javasrc.hiber;

import javax.persistence.*;

/**
 * Created by artem on 23.05.2017.
 */
@Entity
@Table(name = "valid_class", schema = "public", catalog = "DbFD")
public class ValidClassEntity {
    private int id;
    private Integer idClassifier;
    private Integer idValidClass;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_classifier", nullable = true)
    public Integer getIdClassifier() {
        return idClassifier;
    }

    public void setIdClassifier(Integer idClassifier) {
        this.idClassifier = idClassifier;
    }

    @Basic
    @Column(name = "id_valid_class", nullable = true)
    public Integer getIdValidClass() {
        return idValidClass;
    }

    public void setIdValidClass(Integer idValidClass) {
        this.idValidClass = idValidClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValidClassEntity that = (ValidClassEntity) o;

        if (id != that.id) return false;
        if (idClassifier != null ? !idClassifier.equals(that.idClassifier) : that.idClassifier != null) return false;
        if (idValidClass != null ? !idValidClass.equals(that.idValidClass) : that.idValidClass != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idClassifier != null ? idClassifier.hashCode() : 0);
        result = 31 * result + (idValidClass != null ? idValidClass.hashCode() : 0);
        return result;
    }


}
