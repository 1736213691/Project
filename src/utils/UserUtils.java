package utils;

import bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserUtils {

    public synchronized  static boolean updatePass(String name, String pass) {
        String sql = "update userinfo set password=? where name=?";
        return DBUtils.insert(sql, pass, name);
    }

    public synchronized static boolean isVote(String name, String id) {
        String sql = "select name from uservotes where name=? and votes_id=?";
        User user = DBUtils.selectOne(User.class, sql, name, id);
        if(user == null) {
            return true;
        }
        return false;
    }

    public static boolean isExist(String name) {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "select password from userinfo where name = ?";

        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if(!rs.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtils.close(con, ps, rs);
        }
        return true;
    }

    public static int identify(String name, String password){
        User user = DBUtils.selectOne(User.class, "select * from userinfo where name = ?" , name);
        if(user!=null && user.getPassword().equals(password)){
            if(user.getState().equals("管理员")) {
                return 10;
            } else return 1;
        }
        return -1;
    }

    public static boolean register(String name, String password){
        String sql = "insert into userinfo(name,password) values(?,?)";
        return DBUtils.insert(sql,name,password);
    }
}
