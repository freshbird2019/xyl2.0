package xyl.dyx.POJO;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name = "joinAc", schema = "xyl")
public class JoinAcEntity implements Serializable {

    private static final long serialVersionUID = 1l;

    private int aid;
    private int xid;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getXid() {
        return xid;
    }

    public void setXid(int xid) {
        this.xid = xid;
    }
}