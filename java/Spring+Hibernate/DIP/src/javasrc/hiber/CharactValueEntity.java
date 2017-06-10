package javasrc.hiber;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by artem on 23.05.2017.
 */
@Entity
@Table(name = "charact_value", schema = "public", catalog = "DbFD")
public class CharactValueEntity {
    private int id;
    private Integer intValue;
    private Date dateValue;
    private String transferValue;
    private String strValue;
    private Integer idCharact;
    private Integer idEo;
    private String linkValue;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "int_value", nullable = true)
    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    @Basic
    @Column(name = "date_value", nullable = true)
    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    @Basic
    @Column(name = "transfer_value", nullable = true, length = -1)
    public String getTransferValue() {
        return transferValue;
    }

    public void setTransferValue(String transferValue) {
        this.transferValue = transferValue;
    }

    @Basic
    @Column(name = "str_value", nullable = true, length = -1)
    public String getStrValue() {
        return strValue;
    }

    public void setStrValue(String strValue) {
        this.strValue = strValue;
    }

    @Basic
    @Column(name = "id_charact", nullable = true)
    public Integer getIdCharact() {
        return idCharact;
    }

    public void setIdCharact(Integer idCharact) {
        this.idCharact = idCharact;
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
    @Column(name = "link_value", nullable = true, length = -1)
    public String getLinkValue() {
        return linkValue;
    }

    public void setLinkValue(String linkValue) {
        this.linkValue = linkValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharactValueEntity that = (CharactValueEntity) o;

        if (id != that.id) return false;
        if (intValue != null ? !intValue.equals(that.intValue) : that.intValue != null) return false;
        if (dateValue != null ? !dateValue.equals(that.dateValue) : that.dateValue != null) return false;
        if (transferValue != null ? !transferValue.equals(that.transferValue) : that.transferValue != null)
            return false;
        if (strValue != null ? !strValue.equals(that.strValue) : that.strValue != null) return false;
        if (idCharact != null ? !idCharact.equals(that.idCharact) : that.idCharact != null) return false;
        if (idEo != null ? !idEo.equals(that.idEo) : that.idEo != null) return false;
        if (linkValue != null ? !linkValue.equals(that.linkValue) : that.linkValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (intValue != null ? intValue.hashCode() : 0);
        result = 31 * result + (dateValue != null ? dateValue.hashCode() : 0);
        result = 31 * result + (transferValue != null ? transferValue.hashCode() : 0);
        result = 31 * result + (strValue != null ? strValue.hashCode() : 0);
        result = 31 * result + (idCharact != null ? idCharact.hashCode() : 0);
        result = 31 * result + (idEo != null ? idEo.hashCode() : 0);
        result = 31 * result + (linkValue != null ? linkValue.hashCode() : 0);
        return result;
    }

}
