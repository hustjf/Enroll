package JavaBean;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 13-10-30
 * Time: 下午5:07
 * To change this template use File | Settings | File Templates.
 */
public class UserInfo {
    private String username;
    private String password;
    private boolean isright;
    private int stuid;
//    private Connection conn;
//    private PreparedStatement ps;
//    private ResultSet rs;

//    public UserInfo(String username,String password){
//        try {
//            this.username = username;
//            this.password = password;
//            conn = new ConnectDB().getConnection();
//            ps = conn.prepareStatement("select * from user where username=? and password=?");
//            ps.setString(1,username);
//            ps.setString(2,password);
//            rs = ps.executeQuery();
//            isright=rs.next();
//            if (isright)
//                stuid=rs.getInt("stuid");
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            try {
//                ps.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            try {
//                rs.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIsright(boolean ir){
        this.isright = ir;
    }

    public boolean getIsright(){
        return isright;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

}
