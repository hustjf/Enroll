package TagClasses;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 13-10-16
 * Time: 下午3:42
 * To change this template use File | Settings | File Templates.
 */
public class SetColor extends SimpleTagSupport{
    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspFragment body = getJspBody();
        StringWriter oldbody = new StringWriter();
        String newbody;
        body.invoke(oldbody);
        if (color.equals("GREEN")){
            newbody = "<font color='green'>"+oldbody.toString()+"</font>";
        }else if (color.equals("RED")){
            newbody = "<font color='red'>"+oldbody.toString()+"</font>";
        }else if (color.equals("BLUE")){
            newbody = "<font color='blue'>"+oldbody.toString()+"</font>";
        }else if (color.equals("YELLOW")){
            newbody = "<font color='yellow'>"+oldbody.toString()+"</font>";
        }else {
            newbody = oldbody.toString();
        }
        JspWriter out = getJspContext().getOut();
        out.write(newbody);
        }
}
