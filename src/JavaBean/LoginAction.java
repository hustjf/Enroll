package JavaBean;

import Dao.UserDAO;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 13-11-24
 * Time: 上午10:59
 * To change this template use File | Settings | File Templates.
 */
public class LoginAction extends Action {
    private String contextConfigLocation = "classpath:springcfg.xml";
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LoginActionForm loginActionForm = (LoginActionForm) form;
        String username = loginActionForm.getUsername();
        String password = loginActionForm.getPassword();
        UserInfo userinfo = new UserInfo();
        CourseInfo courseinfo = new CourseInfo();
        BeanFactory factory = new ClassPathXmlApplicationContext(contextConfigLocation);
        UserDAO userDAO = (UserDAO) factory.getBean("UserDao");
        UserEntity user = userDAO.finduserByUsernamePassword(username,password);
        if (user!=null){
            userinfo.setUsername(username);
            userinfo.setPassword(password);
            userinfo.setIsright(true);
            userinfo.setStuid(user.getStuid());
            List<CourseEntity> course = userDAO.findcourseByStuid(user.getStuid());
            List<String> coursename = courseinfo.getCoursename();
            List<Integer> coursenumber = courseinfo.getCoursenumber();
            for (CourseEntity cn:course){
                coursename.add(cn.getCoursename());
                coursenumber.add(cn.getCoursenumber());
            }
            courseinfo.setCoursename(coursename);
            courseinfo.setCoursenumber(coursenumber);
        }else {
            userinfo.setIsright(false);
        }
        request.setAttribute("courseinfo",courseinfo);
        HttpSession session = request.getSession();
        session.setAttribute("userinfo",userinfo);
        return mapping.findForward("login");
    }
}
