package myboard.article.view;

import myboard.article.entity.Article;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ArticleView {
    Scanner scan = new Scanner(System.in);

    public void printArticleList(ArrayList<Article> list) {
        System.out.println("====================");
        for(int i = 0; i < list.size(); i++) {
            Article article = list.get(i);

            System.out.printf("번호 : %d\n", article.getId() );
            System.out.printf("제목 : %s\n", article.getTitle() );
            System.out.println("====================");
        }
    }

    public HashMap<String, Object> addView() {
        System.out.printf("게시물 제목을 입력해주세요 : ");
        String title = scan.nextLine();
        System.out.printf("게시물 내용을 입력해주세요 : ");
        String body = scan.nextLine();

        // v1
//        Article article = new Article();
//        article.setTitle(title);
//        article.setBody(body);

        // v2
        HashMap<String, Object> param = new HashMap<>();
        param.put("title", title);
        param.put("body", body);

        return param;
    }

}
