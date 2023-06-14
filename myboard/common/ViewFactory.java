package myboard.common;

import myboard.article.view.AddView;
import myboard.article.view.MyListView;
import myboard.article.view.View;

public class ViewFactory {
    public View getView(String name, Request req) {
        View targetView = null;
        switch (name) {
            case "list":
                targetView = new MyListView(req);
            break;
            case "add":
                targetView = new AddView(req);
            break;
        }

        return targetView;
    }
}
