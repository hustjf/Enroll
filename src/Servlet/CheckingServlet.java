package Servlet;

import Dao.UserDAO;
import JavaBean.CourseEntity;
import JavaBean.CourseInfo;
import JavaBean.UserEntity;
import JavaBean.UserInfo;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 13-10-30
 * Time: 下午4:59
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "CheckingServlet")
public class CheckingServlet extends HttpServlet {
    private String contextConfigLocation;
    @Override
    public void init() throws ServletException {
        contextConfigLocation = this.getInitParameter("contextConfigLocation");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserInfo userinfo = new UserInfo();
        CourseInfo courseinfo = new CourseInfo();
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session ss = sessionFactory.openSession();
//        Transaction transaction = ss.beginTransaction();
//        String userhql = "from UserEntity user where user.username = :username and user.password = :password";
//        Query userquery = ss.createQuery(userhql);
//        userquery.setParameter("username",username);
//        userquery.setParameter("password",password);
//        List userlist =  userquery.list();
//        Iterator useriterator = userlist.iterator();
        BeanFactory factory = new ClassPathXmlApplicationContext(contextConfigLocation);
        UserDAO userDAO = (UserDAO) factory.getBean("UserDao");
        UserEntity user = userDAO.finduserByUsernamePassword(username,password);
        if (user!=null){
            userinfo.setUsername(username);
            userinfo.setPassword(password);
            userinfo.setIsright(true);
            userinfo.setStuid(user.getStuid());
//            String coursehql = "from CourseEntity course where course.stuid = :stuid";
//            Query coursequery = ss.createQuery(coursehql);
//            coursequery.setParameter("stuid",user.getStuid());
//            List courselist = coursequery.list();
//            Iterator courseiterator = courselist.iterator();
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
//        transaction.commit();
//        ss.close();
        request.setAttribute("courseinfo",courseinfo);
        HttpSession session = request.getSession();
        session.setAttribute("userinfo",userinfo);
        request.getRequestDispatcher("enroll.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
