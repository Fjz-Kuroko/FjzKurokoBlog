package xyz.fjzkuroko.service;

import xyz.fjzkuroko.entity.Article;
import xyz.fjzkuroko.vo.ViewAlertCard;
import xyz.fjzkuroko.vo.ViewArticle;

import java.util.List;

public interface ArticleService {
    List<Article> selectAllArticle();
    List<Article> selectAllAid(String keyword);
    Article selectArticleByAid(int aid);
    List<ViewAlertCard> selectArticleCommentNumTop4();
    List<ViewArticle> selectArticleArchives();
    List<Article> selectAidByLabel(int label);
}
