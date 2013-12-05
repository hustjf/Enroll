package Dao;

import JavaBean.CourseEntity;
import JavaBean.UserEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 13-11-9
 * Time: 上午12:59
 * To change this template use File | Settings | File Templates.
 */
public interface UserDAO {
    public UserEntity finduserByUsernamePassword(String username,String password);
    public List<CourseEntity> findcourseByStuid(int stuid);
    public void addCourse(int coursenumber,String coursename,int stuid);
    public void deleteCourse(String[] deletecourse,int stuid);
}
