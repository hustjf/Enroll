package JavaBean;

import org.apache.struts.action.ActionForm;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 13-11-25
 * Time: 下午1:07
 * To change this template use File | Settings | File Templates.
 */
public class OperationActionForm extends ActionForm {
    private String[] checkdelete;
    private String addcourse;
    private int addnum;

    public String[] getCheckdelete() {
        return checkdelete;
    }

    public void setCheckdelete(String[] checkdelete) {
        this.checkdelete = checkdelete;
    }

    public String getAddcourse() {
        return addcourse;
    }

    public void setAddcourse(String addcourse) {
        this.addcourse = addcourse;
    }

    public int getAddnum() {
        return addnum;
    }

    public void setAddnum(int addnum) {
        this.addnum = addnum;
    }


}
