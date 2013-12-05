package JavaBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 13-10-15
 * Time: 下午4:18
 * To change this template use File | Settings | File Templates.
 */
public class CourseInfo {
    private List<String> coursename = new ArrayList<String>();
    private List<Integer> coursenumber = new ArrayList<Integer>();
//    private Connection conn;
//    private PreparedStatement ps;
//    private ResultSet rs;

//    public CourseInfo(int stuid){
//        coursename = new ArrayList<String>();
//        coursenumber = new ArrayList<Integer>();
//        try {
//            conn = new ConnectDB().getConnection();
//            ps = conn.prepareStatement("select coursenumber,coursename from course where stuid =?");
//            ps.setInt(1,stuid);
//            rs = ps.executeQuery();
//            while (rs.next()){
//                coursename.add(rs.getString("coursename"));
//                coursenumber.add(rs.getInt("coursenumber"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                if (conn != null)
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            try {
//                if (ps != null)
//                ps.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            try {
//                if (rs != null)
//                rs.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    public List<String> getCoursename() {
        return coursename;
    }
    public void setCoursename(List<String> coursename) {
        this.coursename = coursename;
    }
    public List<Integer> getCoursenumber() {
        return coursenumber;
    }
    public void setCoursenumber(List<Integer> coursenum) {
        this.coursenumber = coursenum;
    }
}
