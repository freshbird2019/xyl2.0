package xyl.cct.pojo;

import javax.persistence.*;

@Entity
@Table(name = "xy", schema = "dbo", catalog = "master")
public class XyEntity {
    private int xyId;
    private String xyUsername;
    private String xyPassword;
    private String xyAge;
    private String xySex;
    private String xyEmail;
    private String xyPhone;

    @Id
    @Column(name = "xy_id", nullable = false)
    public int getXyId() {
        return xyId;
    }

    public void setXyId(int xyId) {
        this.xyId = xyId;
    }

    @Basic
    @Column(name = "xy_username", nullable = true, length = 20)
    public String getXyUsername() {
        return xyUsername;
    }

    public void setXyUsername(String xyUsername) {
        this.xyUsername = xyUsername;
    }

    @Basic
    @Column(name = "xy_password", nullable = true, length = 20)
    public String getXyPassword() {
        return xyPassword;
    }

    public void setXyPassword(String xyPassword) {
        this.xyPassword = xyPassword;
    }

    @Basic
    @Column(name = "xy_age", nullable = true, length = 5)
    public String getXyAge() {
        return xyAge;
    }

    public void setXyAge(String xyAge) {
        this.xyAge = xyAge;
    }

    @Basic
    @Column(name = "xy_sex", nullable = true, length = 5)
    public String getXySex() {
        return xySex;
    }

    public void setXySex(String xySex) {
        this.xySex = xySex;
    }

    @Basic
    @Column(name = "xy_email", nullable = true, length = 20)
    public String getXyEmail() {
        return xyEmail;
    }

    public void setXyEmail(String xyEmail) {
        this.xyEmail = xyEmail;
    }

    @Basic
    @Column(name = "xy_phone", nullable = true, length = 20)
    public String getXyPhone() {
        return xyPhone;
    }

    public void setXyPhone(String xyPhone) {
        this.xyPhone = xyPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XyEntity xyEntity = (XyEntity) o;

        if (xyId != xyEntity.xyId) return false;
        if (xyUsername != null ? !xyUsername.equals(xyEntity.xyUsername) : xyEntity.xyUsername != null) return false;
        if (xyPassword != null ? !xyPassword.equals(xyEntity.xyPassword) : xyEntity.xyPassword != null) return false;
        if (xyAge != null ? !xyAge.equals(xyEntity.xyAge) : xyEntity.xyAge != null) return false;
        if (xySex != null ? !xySex.equals(xyEntity.xySex) : xyEntity.xySex != null) return false;
        if (xyEmail != null ? !xyEmail.equals(xyEntity.xyEmail) : xyEntity.xyEmail != null) return false;
        if (xyPhone != null ? !xyPhone.equals(xyEntity.xyPhone) : xyEntity.xyPhone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = xyId;
        result = 31 * result + (xyUsername != null ? xyUsername.hashCode() : 0);
        result = 31 * result + (xyPassword != null ? xyPassword.hashCode() : 0);
        result = 31 * result + (xyAge != null ? xyAge.hashCode() : 0);
        result = 31 * result + (xySex != null ? xySex.hashCode() : 0);
        result = 31 * result + (xyEmail != null ? xyEmail.hashCode() : 0);
        result = 31 * result + (xyPhone != null ? xyPhone.hashCode() : 0);
        return result;
    }
}
