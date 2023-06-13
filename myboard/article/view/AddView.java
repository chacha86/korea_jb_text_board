package myboard.article.view;

import myboard.BoardApp;
import myboard.article.controller.ArticleController;
import myboard.common.Request;

import java.util.Scanner;

public class AddView {
    Scanner scan;
    Request request;
    ArticleController articleController;

    public AddView() {
        scan = new Scanner(System.in);
        articleController = new ArticleController();
        request = new Request();
    }

    public void render() {
        System.out.printf("게시물 제목을 입력해주세요 : ");
        String title = scan.nextLine();
        System.out.printf("게시물 내용을 입력해주세요 : ");
        String body = scan.nextLine();

        request.setParameter("title", title);
        request.setParameter("body", body);
        articleController.add(request);

    }
}
