package xyl.cct.pojo;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Xy {
    private int xid;
    private String name;
    private String sex;
    private String phone;
    private String mail;
    private String pw;
    private int state;
    private Collection<Ly> liesByXid;
    private Clazz clazzByClassid;

    @Id
    @Column(name = "xid", nullable = false)
    public int getXid() {
        return xid;
    }

    public void setXid(int xid) {
        this.xid = xid;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sex", nullable = false, length = 1)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "phone", nullable = false, precision = 0)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "mail", nullable = false, length = 50)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "pw", nullable = false, length = 20)
    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    @Basic
    @Column(name = "state", nullable = false)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Xy xy = (Xy) o;

        if (xid != xy.xid) return false;
        if (phone != xy.phone) return false;
        if (state != xy.state) return false;
        if (name != null ? !name.equals(xy.name) : xy.name != null) return false;
        if (sex != null ? !sex.equals(xy.sex) : xy.sex != null) return false;
        if (mail != null ? !mail.equals(xy.mail) : xy.mail != null) return false;
        if (pw != null ? !pw.equals(xy.pw) : xy.pw != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = xid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (phone!= null ? sex.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (pw != null ? pw.hashCode() : 0);
        result = 31 * result + state;
        return result;
    }

    @OneToMany(mappedBy = "xyByLyxid")
    public Collection<Ly> getLiesByXid() {
        return liesByXid;
    }

    public void setLiesByXid(Collection<Ly> liesByXid) {
        this.liesByXid = liesByXid;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "classid", referencedColumnName = "cid")
    public Clazz getClazzByClassid() {
        return clazzByClassid;
    }

    public void setClazzByClassid(Clazz clazzByClassid) {
        this.clazzByClassid = clazzByClassid;
    }
}
