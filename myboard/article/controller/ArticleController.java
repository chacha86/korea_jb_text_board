package myboard.article.controller;

import myboard.article.entity.Article;
import myboard.article.entity.ArticleRepository;
import myboard.article.view.ArticleView;
import myboard.util.Util;

import java.util.ArrayList;
import java.util.HashMap;

public class ArticleController {

    ArticleRepository articleRepository;
    ArticleView articleview;

    public ArticleController() {
        articleRepository = new ArticleRepository();
        articleview = new ArticleView();
    }

    public void add() {

        HashMap<String, Object> param = articleview.addInputView();
        String title = (String)param.get("title");
        String body = (String)param.get("body");
        articleRepository.insert(title, body, Util.getCurrentDate());

        articleview.addResultView();
    }


    public void list() {
        ArrayList<Article> articles = articleRepository.getArticleList();
        articleview.printArticleList(articles);
    }

    public void update() {

        HashMap<String, Object> targetParams = articleview.updateTargetView();
        int target = (int)targetParams.get("target");
        Article article = articleRepository.findArticleById(target);

        HashMap<String, Object> inputParams = articleview.updateInputView();
        String title = (String)inputParams.get("title");
        String body = (String)inputParams.get("body");

        articleRepository.update(article, title, body);
        articleview.updateReultView(article);
    }

    public void delete() {

        HashMap<String, Object> targetParams = articleview.deleteTargetView();
        int target = (int)targetParams.get("target");

        Article article = articleRepository.findArticleById(target);

        articleRepository.delete(article);
        articleview.deleteResultView(article);
    }

    public void detail() {

        HashMap<String, Object> targetParams = articleview.detailTargetView();
        int target = (int)targetParams.get("target");

        Article article = articleRepository.findArticleById(target);

        if(article != null) {
            articleRepository.increaseArticleHit(article);
        }

        articleview.detailResultView(article);
    }

    public void search() {

        HashMap<String, Object> inputParams = articleview.searchInputView();
        String keyword = (String)inputParams.get("keyword");

        ArrayList<Article> searchedArticles = articleRepository.search(keyword);

        if(searchedArticles.size() == 0) {

            return;
        }
        articleview.searchResultView(searchedArticles);
    }

}
