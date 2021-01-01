package utils;

import bean.UserVote;
import com.mysql.cj.xdevapi.DbDoc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserVoteUtils {
    public synchronized static void setVote(String name, String votes_id) {
        String sql = "insert into uservotes(name,votes_id,date) values(?,?,now())";
        DBUtils.insert(sql, name, votes_id);
    }

    public synchronized static List<UserVote> getList(String id){
        String sql = "select * from uservotes where votes_id=? order by date desc limit 20  ";
        return DBUtils.selectList(UserVote.class, sql, id);
    }
}
