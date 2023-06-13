package myboard;

import myboard.article.controller.ArticleController;
import myboard.system.controller.SystemController;

import java.util.Scanner;

public class BoardApp {
    Scanner scan;
    ArticleController articleController;
    SystemController systemController;
    public BoardApp() {
        this.scan = new Scanner(System.in);
        articleController = new ArticleController();
        systemController = new SystemController();
    }
    public void run() {
        while (true) {
            System.out.printf("명령어 : ");
            String cmd = scan.nextLine();

            if (cmd.equals("exit")) {
                systemController.exit();
                break;

            } else if (cmd.equals("add")) {
                articleController.add();
            } else if (cmd.equals("list")) {
                articleController.list();
            } else if(cmd.equals("update")) {
                articleController.update();
            } else if(cmd.equals("delete")) {
                articleController.delete();
            } else if(cmd.equals("detail")) {
                articleController.detail();
            } else if(cmd.equals("search")) {
                articleController.search();
            }
        }
    }
}
