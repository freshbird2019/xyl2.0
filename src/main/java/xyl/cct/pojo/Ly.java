package xyl.cct.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Ly {
    private int lid;
    private Timestamp lydate;
    private String info;
    private int state;
    private int best;
    @JsonIgnore
    private Xy xyByLyxid;

    @Id
    @Column(name = "lid", nullable = false)
    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    @Basic
    @Column(name = "lyd", nullable = false)
    @Temporal(TemporalType.DATE) //为了以防java和mysql冲突，我先加上去
    public Timestamp getLydate() {
        return lydate;
    }
    public void setLydate(Timestamp lydate) {
        this.lydate = lydate;
    }

    @Basic
    @Column(name = "info", nullable = false, length = 100)
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Basic
    @Column(name = "state", nullable = false)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Basic
    @Column(name = "best")
    public int getBest() {
        return best;
    }

    public void setBest(int best) {
        this.best = best;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ly ly = (Ly) o;

        if (lid != ly.lid) return false;
        if (state != ly.state) return false;
        if (lydate != null ? !lydate.equals(ly.lydate) : ly.lydate != null) return false;
        if (info != null ? !info.equals(ly.info) : ly.info != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lid;
        result = 31 * result + (lydate != null ? lydate.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + state;

        return result;
    }

    @ManyToOne
    @JoinColumn(name = "lyxid", referencedColumnName = "xid", nullable = false)
    public Xy getXyByLyxid() {
        return xyByLyxid;
    }

    public void setXyByLyxid(Xy xyByLyxid) {
        this.xyByLyxid = xyByLyxid;
    }

}
