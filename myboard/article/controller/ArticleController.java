package myboard.article.controller;

import myboard.article.entity.Article;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {

    Scanner scan = new Scanner(System.in);
    ArrayList<Article> articles = new ArrayList<>();
    int lastId = 1;

    public void add() {
        System.out.printf("게시물 제목을 입력해주세요 : ");
        String title = scan.nextLine();
        System.out.printf("게시물 내용을 입력해주세요 : ");
        String body = scan.nextLine();

        Article article = new Article(lastId, title, body);
        articles.add(article);
        lastId++;

        System.out.println("게시물이 등록되었습니다.");
    }

    public void list() {
        if(articles.size() == 0) {
            System.out.println("등록된 게시물이 없습니다.");
            return;
        }

        System.out.println("====================");
        for(int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);

            System.out.printf("번호 : %d\n", article.getId() );
            System.out.printf("제목 : %s\n", article.getTitle() );
            System.out.println("====================");
        }
    }

    public void update() {
        System.out.printf("수정할 게시물 번호 : ");
        int target = scan.nextInt();
        scan.nextLine(); // 버퍼 비우기용

        int targetIdx = findArticleIndex(articles, target);

        if(targetIdx == -1) {
            System.out.println("없는 게시물 번호입니다.");
            return;
        }

        System.out.printf("제목 : ");
        String title = scan.nextLine();
        System.out.printf("내용 : ");
        String body = scan.nextLine();

        Article article = new Article(target, title, body);
        articles.set(targetIdx, article);
        System.out.println("수정이 완료되었습니다.");
    }

    public void delete() {
        System.out.printf("삭제할 게시물 번호 : ");
        int target = scan.nextInt();
        scan.nextLine(); // 버퍼 비우기용

        int targetIdx = findArticleIndex(articles, target);

        if(targetIdx == -1) {
            System.out.println("없는 게시물 번호입니다.");
            return;
        }
        articles.remove(targetIdx);
        System.out.printf("%d번 게시물이 삭제되었습니다.\n", target);
    }

    public int findArticleIndex(ArrayList<Article> articles, int target) {

        int targetIdx = -1;

        // 전체 탐색
        for(int i = 0; i < articles.size(); i++) {
            Article a = articles.get(i);

            if(a.getId() == target) {
                targetIdx = i;
            }
        }

        return targetIdx;
    }
}