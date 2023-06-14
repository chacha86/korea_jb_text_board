package myboard;

import myboard.article.controller.ArticleController;
import myboard.article.view.View;
import myboard.common.Request;
import myboard.common.ViewFactory;
import myboard.system.controller.SystemController;

import java.util.Scanner;

public class BoardApp {
    Scanner scan;
    ArticleController articleController;
    SystemController systemController;
    ViewFactory viewFactory;
    View requestView;
    View responseView;

    public BoardApp() {
        this.scan = new Scanner(System.in);
        articleController = new ArticleController();
        systemController = new SystemController();
        viewFactory = new ViewFactory();
    }
    public void run() {

        while (true) {
            Request req = requestView.getRequest();
            Response req = requestView.getResponse();
            String cmd = req.getActionCode();

            if (cmd.equals("exit")) {
                systemController.exit();
                break;

            } else if (cmd.equals("add")) {
                Request resp = articleController.add(req);
                responseView = viewFactory.getView(resp.getActionCode(), resp);

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
