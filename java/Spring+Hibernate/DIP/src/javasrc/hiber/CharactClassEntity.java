package javasrc.hiber;

import javax.persistence.*;

/**
 * Created by artem on 23.05.2017.
 */
@Entity
@Table(name = "charact_class", schema = "public", catalog = "DbFD")
public class CharactClassEntity {
    private int id;
    private Integer idClassifier;
    private Integer idCharact;

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
    @Column(name = "id_charact", nullable = true)
    public Integer getIdCharact() {
        return idCharact;
    }

    public void setIdCharact(Integer idCharact) {
        this.idCharact = idCharact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharactClassEntity that = (CharactClassEntity) o;

        if (id != that.id) return false;
        if (idClassifier != null ? !idClassifier.equals(that.idClassifier) : that.idClassifier != null) return false;
        if (idCharact != null ? !idCharact.equals(that.idCharact) : that.idCharact != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idClassifier != null ? idClassifier.hashCode() : 0);
        result = 31 * result + (idCharact != null ? idCharact.hashCode() : 0);
        return result;
    }
}
