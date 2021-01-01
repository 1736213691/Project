package bean;

import java.sql.Date;
import java.sql.Timestamp;

public class UserVote {
    private String name;
    private Integer votes_id;
    private Timestamp date;

    public void setName(String name) {
        this.name = name;
    }

    public void setVotes_id(Integer votes_id) {
        this.votes_id = votes_id;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public Integer getVotes_id() {
        return votes_id;
    }

    public Timestamp getDate() {
        return date;
    }
}
