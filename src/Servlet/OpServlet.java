package Servlet;

import Dao.UserDAO;
import JavaBean.CourseEntity;
import JavaBean.CourseInfo;
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
 * Date: 13-10-15
 * Time: 下午4:21
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "OpServlet")
public class OpServlet extends HttpServlet {
    private String contextConfigLocation;

    @Override
    public void init() throws ServletException {
        contextConfigLocation = this.getInitParameter("contextConfigLocation");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deletecourse[] = request.getParameterValues("checkdelete");
        String addcoursename = request.getParameter("addcourse");
        HttpSession session = request.getSession();
        CourseInfo courseinfo = new CourseInfo();
        UserInfo userinfo = (UserInfo) session.getAttribute("userinfo");
        BeanFactory factory = new ClassPathXmlApplicationContext(contextConfigLocation);
        UserDAO userDAO = (UserDAO) factory.getBean("UserDao");
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session ss = sessionFactory.openSession();
//        Transaction transaction = ss.beginTransaction();
        try {
            if (!addcoursename.trim().isEmpty()){
                int addnum = Integer.parseInt(request.getParameter("addnum"));
//            CourseEntity course = new CourseEntity();
//            course.setCoursename(new String(addcoursename.getBytes("ISO-8859-1"),"UTF-8"));
//            course.setCoursenumber(addnum);
//            course.setStuid(userinfo.getStuid());
//            ss.save(course);
                userDAO.addCourse(addnum,new String(addcoursename.getBytes("ISO-8859-1"),"UTF-8"),userinfo.getStuid());
            }
//            if (!addcoursename.trim().isEmpty()){
//                Connection conn = new ConnectDB().getConnection();
//                PreparedStatement ps = conn.prepareStatement("insert into course(coursenumber,coursename,stuid)values (?,?,?)");
//                ps.setInt(1,addnum);
//                ps.setString(2, new String(addcoursename.getBytes("ISO-8859-1"), "UTF-8"));
//                ps.setInt(3,userinfo.getStuid());
//                ps.executeUpdate();
//                    try {
//                            conn.close();
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//                    try {
//                            ps.close();
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            if (deletecourse!=null){
//                String deletehql = "delete CourseEntity course where course.coursename = :coursename and course.stuid = :stuid";
//                Query coursequery = ss.createQuery(deletehql);
//                for (String deletecoursename : deletecourse) {
//                    coursequery.setParameter("coursename",new String(deletecoursename.getBytes("ISO-8859-1"),"UTF-8"));
//                    coursequery.setParameter("stuid",userinfo.getStuid());
//                    coursequery.executeUpdate();
                for (int i =0;i<deletecourse.length;i++){
                   deletecourse[i] = new String(deletecourse[i].getBytes("ISO-8859-1"),"UTF-8");
                }
                userDAO.deleteCourse(deletecourse,userinfo.getStuid());
                }
//                for (int i=0;i<deletecourse.length;i++){
//                    Connection conn = new ConnectDB().getConnection();
//                    PreparedStatement ps = conn.prepareStatement("delete from course where coursename=?");
//                    ps.setString(1,new String(deletecourse[i].getBytes("ISO-8859-1"),"UTF-8"));
//                    ps.executeUpdate();
//                    try {
//                            conn.close();
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//                    try {
//                            ps.close();
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//                }
        }catch (Exception e){
            e.printStackTrace();
        }
//        String coursehql = "from CourseEntity course where course.stuid = :stuid";
//        Query coursequery = ss.createQuery(coursehql);
//        coursequery.setParameter("stuid",userinfo.getStuid());
//        List courselist = coursequery.list();
//        Iterator courseiterator = courselist.iterator();
        List<String> coursename = courseinfo.getCoursename();
        List<Integer> coursenumber = courseinfo.getCoursenumber();
        List<CourseEntity> course = userDAO.findcourseByStuid(userinfo.getStuid());
//        while (courseiterator.hasNext()){
//            CourseEntity course = (CourseEntity) courseiterator.next();
//            coursename.add(course.getCoursename());
//            coursenumber.add(course.getCoursenumber());
//        }
        for (CourseEntity cn:course){
            coursename.add(cn.getCoursename());
            coursenumber.add(cn.getCoursenumber());
        }
        courseinfo.setCoursename(coursename);
        courseinfo.setCoursenumber(coursenumber);
//        transaction.commit();
//        ss.close();
        request.setAttribute("courseinfo",courseinfo);
        request.getRequestDispatcher("afteroperation.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
