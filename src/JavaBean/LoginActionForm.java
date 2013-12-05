package JavaBean;

import org.apache.struts.action.ActionForm;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 13-11-24
 * Time: 上午10:54
 * To change this template use File | Settings | File Templates.
 */
public class LoginActionForm extends ActionForm{
    private String username;
    private String password;

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
}
