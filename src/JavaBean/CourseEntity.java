package JavaBean;

import javax.persistence.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 13-11-2
 * Time: 下午1:37
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "course", schema = "", catalog = "info")
@Entity
public class CourseEntity {
    private int coursenumber;
    private String coursename;
    private int stuid;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public int getCoursenumber() {
        return coursenumber;
    }

    public void setCoursenumber(int coursenumber) {
        this.coursenumber = coursenumber;
    }
}
