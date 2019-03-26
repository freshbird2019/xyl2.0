package xyl.dyx.POJO;

import javax.persistence.*;

@Entity
@Table(name = "activity", schema = "xyl")
public class ActivityEntity {
    private int aid;
    private String name;
    private String time;
    private String location;
    private int num;
    private String description;

    @Id
    @Column(name = "aid")
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "num")
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityEntity entity = (ActivityEntity) o;

        if (aid != entity.aid) return false;
        if (num != entity.num) return false;
        if (name != null ? !name.equals(entity.name) : entity.name != null) return false;
        if (time != null ? !time.equals(entity.time) : entity.time != null) return false;
        if (location != null ? !location.equals(entity.location) : entity.location != null) return false;
        if (description != null ? !description.equals(entity.description) : entity.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + num;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
