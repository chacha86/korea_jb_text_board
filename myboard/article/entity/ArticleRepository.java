package myboard.article.entity;

import myboard.util.Util;

import java.util.ArrayList;

public class ArticleRepository {
    private ArrayList<Article> articles = new ArrayList<>();
    private int lastId = 4;

    public ArticleRepository() {
        testInit();
    }

    public void testInit() {
        Article article1 = new Article(1, "안녕하세요 반갑습니다. 자바 공부중이에요.", "자바 너무 재밌어요", Util.getCurrentDate());
        Article article2 = new Article(2, "자바 질문좀 할게요~", "MVC 패턴이 뭐에요?", Util.getCurrentDate());
        Article article3 = new Article(3, "정처기 따야되나요?", "이거 따야 돼요?", Util.getCurrentDate());

        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
    }

    public void insert(String title, String body, String regDate) {
        Article article = new Article(lastId, title, body, regDate);
        articles.add(article);
        lastId++;
    }

    public ArrayList<Article> getArticleList() {
        return articles;
    }

    public void update(Article article, String title, String body) {
        article.setTitle(title);
        article.setBody(body);
    }

    public void delete(Article article) {
        articles.remove(article);
    }

    public ArrayList<Article> search(String keyword) {
        ArrayList<Article> searchedArticles = new ArrayList<>();

        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            if (article.getTitle().contains(keyword)) {
                searchedArticles.add(article);
            }
        }

        return searchedArticles;

    }

    public Article findArticleById(int target) {

//        int targetIdx = -1;
        Article article = null;

        // 전체 탐색
        for(int i = 0; i < articles.size(); i++) {
            Article a = articles.get(i);

            if(a.getId() == target) {
                article = articles.get(i);
                break;
            }
        }

        return article;
    }
}
