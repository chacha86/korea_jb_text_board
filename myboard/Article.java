package myboard;

import java.util.ArrayList;

public class Article {
    private int no;
    private String title;
    private String body;

    public Article(){}
    public Article(int no, String title, String body) {
        this.no = no;
        this.title = title;
        this.body = body;
    }

    public int getNo() {
        return no;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
