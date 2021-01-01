package bean;

import java.sql.Date;
import java.sql.Timestamp;

public class Vote {
    private Integer id;
    private String title;
    private Integer count;
    private String name;
    private String content;
    private Timestamp date;

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    public Integer getCount() {
        return count;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return id + "\t" + title + "\t" + count + "\n";
    }
}
