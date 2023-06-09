package myboard;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        ArrayList<Integer> ids = new ArrayList<>();
//        ArrayList<String> titles = new ArrayList<>();
//        ArrayList<String> bodies = new ArrayList<>();
        ArrayList<Article> articles = new ArrayList<>();
        int id = 1;

        while (true) {

            System.out.printf("명령어 : ");
            String cmd = scan.nextLine();

            if (cmd.equals("exit")) {

                System.out.println("프로그램을 종료합니다.");
                break;

            } else if (cmd.equals("add")) {

                System.out.printf("게시물 제목을 입력해주세요 : ");
                String title = scan.nextLine();
                System.out.printf("게시물 내용을 입력해주세요 : ");
                String body = scan.nextLine();

//                titles.add(title);
//                bodies.add(body);
//                ids.add(id);

                Article article = new Article(id, title, body);
                articles.add(article);

                id++;

                System.out.println("게시물이 등록되었습니다.");

            } else if (cmd.equals("list")) {
                if(articles.size() == 0) {
                    System.out.println("등록된 게시물이 없습니다.");
                    continue;
                }
                System.out.println("====================");
                for(int i = 0; i < articles.size(); i++) {
                    Article article = articles.get(i);

                    System.out.printf("번호 : %d\n", article.getNo() );
                    System.out.printf("제목 : %s\n", article.getTitle() );
                    System.out.println("====================");
                }
            } else if(cmd.equals("update")) {
                System.out.printf("수정할 게시물 번호 : ");
                int target = scan.nextInt();
                scan.nextLine(); // 버퍼 비우기용

                int targetIdx = -1;

                // 전체 탐색
                for(int i = 0; i < articles.size(); i++) {
                    Article a = articles.get(i);

                    if(a.getNo() == target) {
                        targetIdx = i;
                        break;
                    }
                }

                if(targetIdx == -1) {
                    System.out.println("없는 게시물 번호입니다.");
                    continue;
                }

                System.out.printf("제목 : ");
                String title = scan.nextLine();
                System.out.printf("내용 : ");
                String body = scan.nextLine();

                Article article = new Article(target, title, body);
                articles.set(targetIdx, article);

            } else if(cmd.equals("delete")) {
                System.out.printf("삭제할 게시물 번호 : ");
                int target = scan.nextInt();
                scan.nextLine(); // 버퍼 비우기용

                int targetIdx = -1;

                // 전체 탐색
                for(int i = 0; i < articles.size(); i++) {
                    Article a = articles.get(i);

                    if(a.getNo() == target) {
                        targetIdx = i;
                        break;
                    }
                }

                if(targetIdx == -1) {
                    System.out.println("없는 게시물 번호입니다.");
                    continue;
                }
                articles.remove(targetIdx);
                System.out.printf("%d번 게시물이 삭제되었습니다.\n", target);
            }
        }
    }
}

// 클래스 -> 같은 개념을 표현하는 데이터의 묶음
