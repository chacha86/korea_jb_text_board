package myboard.article.view;

import myboard.article.controller.ArticleController;
import myboard.article.entity.Article;
import myboard.common.Request;

import java.util.ArrayList;
import java.util.Scanner;

public class MyListView implements View {
    Scanner scan;
    Request request;
    ArticleController articleController;

    public MyListView(Request request) {
        scan = new Scanner(System.in);
        articleController = new ArticleController();
        this.request = request;
    }

    public void render() {
        ArrayList<Article> list = (ArrayList<Article>)request.getParameter("list");
        System.out.println("====================");
        for(int i = 0; i < list.size(); i++) {
            Article article = list.get(i);

            System.out.printf("번호 : %d\n", article.getId() );
            System.out.printf("제목 : %s\n", article.getTitle() );
            System.out.println("====================");
        }
    }

    public Request getRequest() {
        return this.request;
    }
}