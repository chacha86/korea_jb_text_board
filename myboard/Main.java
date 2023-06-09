package myboard;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String title = "";
        String body = "";

        while (true) {
            System.out.printf("명령어 : ");
            String cmd = scan.nextLine();

            if (cmd.equals("exit")) {

                System.out.println("프로그램을 종료합니다.");
                break;

            } else if (cmd.equals("add")) {

                System.out.printf("게시물 제목을 입력해주세요 : ");
                title = scan.nextLine();
                System.out.printf("게시물 내용을 입력해주세요 : ");
                body = scan.nextLine();
                System.out.println("게시물이 등록되었습니다.");

            } else if (cmd.equals("list")) {
                System.out.println("====================");
                System.out.printf("제목 : %s\n", title);
                System.out.printf("내용 : %s\n", body);
                System.out.println("====================");
            }
        }
    }
}
