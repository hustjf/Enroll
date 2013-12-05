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
 * Date: 13-11-25
 * Time: 下午1:12
 * To change this template use File | Settings | File Templates.
 */
public class OperationAction extends Action {
    private String contextConfigLocation = "classpath:springcfg.xml";
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        OperationActionForm operationActionForm = (OperationActionForm) form;
        String[] deletecoursename = operationActionForm.getCheckdelete();
        String addcoursename = operationActionForm.getAddcourse();
        HttpSession session = request.getSession();
        CourseInfo courseinfo = new CourseInfo();
        UserInfo userinfo = (UserInfo) session.getAttribute("userinfo");
        BeanFactory factory = new ClassPathXmlApplicationContext(contextConfigLocation);
        UserDAO userDAO = (UserDAO) factory.getBean("UserDao");
        try {
            if (!addcoursename.trim().isEmpty()){
                int addnum = operationActionForm.getAddnum();
                userDAO.addCourse(addnum,new String(addcoursename.getBytes("ISO-8859-1"),"UTF-8"),userinfo.getStuid());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            if (deletecoursename!=null){
                for (int i =0;i<deletecoursename.length;i++){
                    deletecoursename[i] = new String(deletecoursename[i].getBytes("ISO-8859-1"),"UTF-8");
                }
                userDAO.deleteCourse(deletecoursename,userinfo.getStuid());
            }
            }catch (Exception e){
        e.printStackTrace();
        }
        List<String> coursename = courseinfo.getCoursename();
        List<Integer> coursenumber = courseinfo.getCoursenumber();
        List<CourseEntity> course = userDAO.findcourseByStuid(userinfo.getStuid());
        for (CourseEntity cn:course){
            coursename.add(cn.getCoursename());
            coursenumber.add(cn.getCoursenumber());
        }
        courseinfo.setCoursename(coursename);
        courseinfo.setCoursenumber(coursenumber);
        request.setAttribute("courseinfo",courseinfo);
        return mapping.findForward("operate");
    }
}
