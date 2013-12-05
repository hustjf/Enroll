package Dao;

import JavaBean.CourseEntity;
import JavaBean.UserEntity;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 13-11-9
 * Time: 上午1:12
 * To change this template use File | Settings | File Templates.
 */
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {
    @Override
    public List<CourseEntity> findcourseByStuid(int stuid) {
        List result = this.getHibernateTemplate().find("from CourseEntity course where course.stuid = ?",new Integer(stuid));
        if (result.size()>0) return (List<CourseEntity>) result;
        else return null;
    }

    @Override
    public UserEntity finduserByUsernamePassword(String username, String password) {
        List result = this.getHibernateTemplate().find("from UserEntity user where user.username = ? and user.password = ?",username,password);
        if (result.size()>0) return (UserEntity) result.get(0);
        else return null;
    }

    @Override
    public void addCourse(int coursenumber, String coursename, int stuid) {
        CourseEntity course = new CourseEntity();
        course.setStuid(stuid);
        course.setCoursename(coursename);
        course.setCoursenumber(coursenumber);
        this.getHibernateTemplate().save(course);
    }

    @Override
    public void deleteCourse(String[] deletecourse, int stuid) {
        for (String deletecourseName:deletecourse){
            List result = this.getHibernateTemplate().find("from CourseEntity course where course.coursename = ? and course.stuid = ?",deletecourseName ,new Integer(stuid));
            this.getHibernateTemplate().delete(result.get(0));
        }
    }
}
