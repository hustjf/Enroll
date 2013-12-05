package JavaBean;

import javax.persistence.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 13-11-2
 * Time: 下午1:37
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "user", schema = "", catalog = "info")
@Entity
public class UserEntity {
    private String username;
    private String password;
    private int stuid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }
}
