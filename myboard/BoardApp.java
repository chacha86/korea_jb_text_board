package myboard;

import myboard.system.controller.SystemController;

import java.util.Scanner;

public class BoardApp {
    Scanner scan;
    BoardController boardController;
    SystemController systemController;
    public BoardApp() {
        this.scan = new Scanner(System.in);
        boardController = new BoardController();
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
                boardController.add();
            } else if (cmd.equals("list")) {
                boardController.list();
            } else if(cmd.equals("update")) {
                boardController.update();
            } else if(cmd.equals("delete")) {
                boardController.delete();
            }
        }
    }
}
