package myboard.article.view;

import myboard.article.entity.Article;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ArticleView {
    Scanner scan = new Scanner(System.in);

    public void printArticleList(ArrayList<Article> list) {

        if(list.size() == 0) {
            System.out.println("등록된 게시물이 없습니다.");
            return;
        }

        System.out.println("====================");
        for(int i = 0; i < list.size(); i++) {
            Article article = list.get(i);

            System.out.printf("번호 : %d\n", article.getId() );
            System.out.printf("제목 : %s\n", article.getTitle() );
            System.out.println("====================");
        }
    }

    public HashMap<String, Object> updateTargetView() {
        System.out.printf("수정할 게시물 번호 : ");
        int target = scan.nextInt();
        scan.nextLine(); // 버퍼 비우기용

        HashMap<String, Object> param = new HashMap<>();
        param.put("target", target);

        return param;
    }

    public HashMap<String, Object> updateInputView() {
        System.out.printf("제목 : ");
        String title = scan.nextLine();
        System.out.printf("내용 : ");
        String body = scan.nextLine();

        HashMap<String, Object> param = new HashMap<>();
        param.put("title", title);
        param.put("body", body);

        return param;
    }

    public void updateReultView(Article article) {

        if(article == null) {
            System.out.println("없는 게시물 번호입니다.");
            return;
        }

        System.out.println("수정이 완료되었습니다.");
    }

    public HashMap<String, Object> deleteTargetView() {
        System.out.printf("삭제할 게시물 번호 : ");
        int target = scan.nextInt();
        scan.nextLine(); // 버퍼 비우기용

        HashMap<String, Object> param = new HashMap<>();
        param.put("target", target);

        return param;
    }

    public void deleteResultView(Article article) {
        if(article == null) {
            System.out.println("없는 게시물 번호입니다.");
            return;
        }
        System.out.printf("%d번 게시물이 삭제되었습니다.\n", article.getId());
    }

    public HashMap<String, Object> detailTargetView() {
        System.out.println("게시물 번호를 입력해주세요.");
        int target = scan.nextInt();
        scan.nextLine();

        HashMap<String, Object> param = new HashMap<>();
        param.put("target", target);

        return param;
    }

    public void detailResultView(Article article) {
        if (article == null) {
            System.out.println("없는 게시물입니다.");
        } else {
            System.out.println("======== 게시물 상세 ========");
            System.out.println("번호   : " + article.getId());
            System.out.println("제목   : " + article.getTitle());
            System.out.println("내용   : " + article.getBody());
            System.out.println("등록날짜   : " + article.getRegDate());
            System.out.println("조회수   : " + article.getHit());
            System.out.println("==============================");
        }
    }

    public HashMap<String, Object> searchInputView() {
        System.out.printf("검색어를 입력해주세요 : ");
        String keyword = scan.nextLine();

        HashMap<String, Object> param = new HashMap<>();
        param.put("keyword", keyword);

        return param;
    }

    public void searchResultView(ArrayList<Article> searchedArticles) {
        if(searchedArticles.size() == 0) {
            System.out.println("검색 결과가 없습니다.");
            return;
        }
        printArticleList(searchedArticles);
    }

    public HashMap<String, Object> addInputView() {
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

    public void addResultView() {
        System.out.println("게시물이 등록되었습니다.");
    }
}
