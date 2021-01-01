package utils;

import bean.Vote;

import java.sql.SQLException;
import java.util.List;

public class VoteUtils {

    public static boolean addVote(String title, String name, String content) {
        String sql = "insert into votes(title,name,content,date) values(?,?,?,now())";
        return DBUtils.insert(sql, title, name, content);
    }

    public static boolean updateVote(String title, Integer id, String content){
        String sql = "update votes set title=?,content=? where id=?";
        return DBUtils.insert(sql, title, content, id);
    }

    public static int getVotesNum(String key, String by){
        String sql = "select count(*) from votes where " + by + " like ?";
        return DBUtils.getCount(Vote.class, sql, "%"+key+"%");
    }

    public static int getUserVotes(String name){
        String sql = "select count(*) from uservotes where name=?";
        return DBUtils.getCount(Vote.class, sql, name);
    }

    public static boolean addVoteCount(Integer id){
        return DBUtils.add(id);
    }

    public static Vote selectOne(Integer id) {
        String sql = "select * from votes where id=?";
        return DBUtils.selectOne(Vote.class, sql, id);
    }

    public static List<Vote> searchVoteList(String key, String by, Integer n, Integer pageN) {
        String sql = "select * from votes where " + by + " like ? order by count desc limit ?," + pageN;
        return DBUtils.selectList(Vote.class, sql, "%"+key+"%", (n-1)*pageN);
    }

    public static boolean deleteVote(int id) {
        String sql = "delete from uservotes where votes_id=?";
        String sql2 = "delete from votes where id=?";
        return DBUtils.insert(sql, id) && DBUtils.insert(sql2, id);

    }
}
