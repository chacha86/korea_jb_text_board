package myboard.article.entity;

public class Article {
    private int id;
    private String title;
    private String body;

    public Article(){}
    public Article(int no, String title, String body) {
        this.id = no;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
