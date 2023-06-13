package myboard.article.controller;

import myboard.article.entity.Article;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {

    Scanner scan = new Scanner(System.in);
    ArrayList<Article> articles = new ArrayList<>();
    int lastId = 4;

    public void add() {
        System.out.printf("게시물 제목을 입력해주세요 : ");
        String title = scan.nextLine();
        System.out.printf("게시물 내용을 입력해주세요 : ");
        String body = scan.nextLine();

        Article article = new Article(lastId, title, body, getCurrentDate());
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

        int targetIdx = findArticleIndex(target);

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

        int targetIdx = findArticleIndex(target);

        if(targetIdx == -1) {
            System.out.println("없는 게시물 번호입니다.");
            return;
        }
        articles.remove(targetIdx);
        System.out.printf("%d번 게시물이 삭제되었습니다.\n", target);
    }

    public void detail() {
        System.out.println("게시물 번호를 입력해주세요.");
        int target = scan.nextInt();
        scan.nextLine();
        int targetId = findArticleIndex(target);

        if (targetId == -1) {
            System.out.println("없는 게시물입니다.");
        } else {
            Article article = articles.get(targetId);
            System.out.println("======== 게시물 상세 ========");
            System.out.println("번호   : " + article.getId());
            System.out.println("제목   : " + article.getTitle());
            System.out.println("내용   : " + article.getBody());
            System.out.println("등록날짜   : " + article.getRegDate());
            System.out.println("==============================");
        }
    }

    public void testInit() {
        Article article1 = new Article(1, "안녕하세요 반갑습니다. 자바 공부중이에요.", "자바 너무 재밌어요", getCurrentDate());
        Article article2 = new Article(2, "자바 질문좀 할게요~", "MVC 패턴이 뭐에요?", getCurrentDate());
        Article article3 = new Article(3, "정처기 따야되나요?", "이거 따야 돼요?", getCurrentDate());

        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
    }

    public String getCurrentDate() {
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        String formattedDate = currentDate.format(formatter);

        return formattedDate;
    }

    public int findArticleIndex(int target) {

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
