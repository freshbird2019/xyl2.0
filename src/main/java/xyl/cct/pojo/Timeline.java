package xyl.cct.pojo;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Timeline {
    private int timelineid;
    private Timestamp ttime;
    private String description;
    private int type;
    private int tid;

    private Xy xyByTid;

    @Id
    @Column(name = "timelineid")
    public int getTimelineid() {
        return timelineid;
    }

    public void setTimelineid(int timelineid) {
        this.timelineid = timelineid;
    }

    @Basic
    @Column(name = "ttime")
    public Timestamp getTtime() {
        return ttime;
    }

    public void setTtime(Timestamp ttime) {
        this.ttime = ttime;
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
    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "tid")
    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Timeline timeline = (Timeline) o;

        if (timelineid != timeline.timelineid) return false;
        if (type != timeline.type) return false;
        if (tid != timeline.tid) return false;
        if (ttime != null ? !ttime.equals(timeline.ttime) : timeline.ttime != null) return false;
        if (description != null ? !description.equals(timeline.description) : timeline.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = timelineid;
        result = 31 * result + (ttime != null ? ttime.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + type;
        result = 31 * result + tid;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "tid", referencedColumnName = "xid", nullable = false)
    public Xy getXyByTid() {
        return xyByTid;
    }

    public void setXyByTid(Xy xyByTid) {
        this.xyByTid = xyByTid;
    }
}
