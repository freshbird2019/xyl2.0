package xyl.cct.pojo;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class FindNotice {
    private int noticeid;
    private int fid;
    private Timestamp ftime;
    private String ftitle;
    private String description;
    private int showstate;

    private Xy xyByFid;

    @Id
    @Column(name = "noticeid")
    public int getNoticeid() {
        return noticeid;
    }

    public void setNoticeid(int noticeid) {
        this.noticeid = noticeid;
    }

    @Basic
    @Column(name = "fid")
    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    @Basic
    @Column(name = "ftime")
    public Timestamp getFtime() {
        return ftime;
    }

    public void setFtime(Timestamp ftime) {
        this.ftime = ftime;
    }

    @Basic
    @Column(name = "ftitle")
    public String getFtitle() {
        return ftitle;
    }

    public void setFtitle(String ftitle) {
        this.ftitle = ftitle;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "showstate")
    public int getShowstate() {
        return showstate;
    }

    public void setShowstate(int showstate) {
        this.showstate = showstate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FindNotice that = (FindNotice) o;

        if (noticeid != that.noticeid) return false;
        if (fid != that.fid) return false;
        if (showstate != that.showstate) return false;
        if (ftime != null ? !ftime.equals(that.ftime) : that.ftime != null) return false;
        if (ftitle != null ? !ftitle.equals(that.ftitle) : that.ftitle != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noticeid;
        result = 31 * result + fid;
        result = 31 * result + (ftime != null ? ftime.hashCode() : 0);
        result = 31 * result + (ftitle != null ? ftitle.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + showstate;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "fid", referencedColumnName = "xid", nullable = false)
    public Xy getXyByFid() {
        return xyByFid;
    }

    public void setXyByFid(Xy xyByFid) {
        this.xyByFid = xyByFid;
    }
}
