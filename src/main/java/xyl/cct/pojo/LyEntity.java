package xyl.cct.pojo;

import javax.persistence.*;

@Entity
@Table(name = "ly", schema = "dbo", catalog = "master")
public class LyEntity {
    private int lyId;
    private String lyDate;
    private String lyLyr;
    private String lyInfo;

    @Id
    @Column(name = "ly_id", nullable = false)
    public int getLyId() {
        return lyId;
    }

    public void setLyId(int lyId) {
        this.lyId = lyId;
    }

    @Basic
    @Column(name = "ly_date", nullable = true, length = 20)
    public String getLyDate() {
        return lyDate;
    }

    public void setLyDate(String lyDate) {
        this.lyDate = lyDate;
    }

    @Basic
    @Column(name = "ly_lyr", nullable = true, length = 20)
    public String getLyLyr() {
        return lyLyr;
    }

    public void setLyLyr(String lyLyr) {
        this.lyLyr = lyLyr;
    }

    @Basic
    @Column(name = "ly_info", nullable = true, length = 50)
    public String getLyInfo() {
        return lyInfo;
    }

    public void setLyInfo(String lyInfo) {
        this.lyInfo = lyInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LyEntity lyEntity = (LyEntity) o;

        if (lyId != lyEntity.lyId) return false;
        if (lyDate != null ? !lyDate.equals(lyEntity.lyDate) : lyEntity.lyDate != null) return false;
        if (lyLyr != null ? !lyLyr.equals(lyEntity.lyLyr) : lyEntity.lyLyr != null) return false;
        if (lyInfo != null ? !lyInfo.equals(lyEntity.lyInfo) : lyEntity.lyInfo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lyId;
        result = 31 * result + (lyDate != null ? lyDate.hashCode() : 0);
        result = 31 * result + (lyLyr != null ? lyLyr.hashCode() : 0);
        result = 31 * result + (lyInfo != null ? lyInfo.hashCode() : 0);
        return result;
    }
}
