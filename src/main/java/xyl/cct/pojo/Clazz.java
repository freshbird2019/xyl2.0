package xyl.cct.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "class", schema = "xyl")
public class Clazz {
    @JsonProperty(value = "Cid")
    private int cid;
    @JsonProperty(value = "Name")
    private String name;
    @JsonProperty(value = "Year")
    private String year;
    @JsonProperty(value = "Major")
    private String major;
    @JsonProperty(value = "College")
    private String college;

    @Id
    @Column(name = "cid", nullable = false)
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "year", nullable = false, length = 20)
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Basic
    @Column(name = "major", nullable = false, length = 20)
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Basic
    @Column(name = "college", nullable = false, length = 20)
    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clazz clazz = (Clazz) o;

        if (cid != clazz.cid) return false;
        if (name != null ? !name.equals(clazz.name) : clazz.name != null) return false;
        if (year != null ? !year.equals(clazz.year) : clazz.year != null) return false;
        if (major != null ? !major.equals(clazz.major) : clazz.major != null) return false;
        if (college != null ? !college.equals(clazz.college) : clazz.college != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (college != null ? college.hashCode() : 0);
        return result;
    }
}
