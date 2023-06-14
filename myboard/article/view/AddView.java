package myboard.article.view;

import myboard.BoardApp;
import myboard.article.controller.ArticleController;
import myboard.common.Request;

import java.util.Scanner;

public class AddView implements View {
    Scanner scan;
    Request request;
    ArticleController articleController;

    public AddView(Request request) {
        scan = new Scanner(System.in);
        articleController = new ArticleController();
        this.request = request;
    }

    public void render() {
        System.out.printf("게시물 제목을 입력해주세요 : ");
        String title = scan.nextLine();
        System.out.printf("게시물 내용을 입력해주세요 : ");
        String body = scan.nextLine();

        request.setParameter("title", title);
        request.setParameter("body", body);
        request.setActionCode("list");
    }

    public Request getRequest() {
        return this.request;
    }
}
