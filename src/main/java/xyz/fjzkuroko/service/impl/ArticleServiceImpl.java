package xyz.fjzkuroko.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.fjzkuroko.dao.ArticleDao;
import xyz.fjzkuroko.entity.Article;
import xyz.fjzkuroko.service.ArticleService;
import xyz.fjzkuroko.vo.ViewAlertCard;
import xyz.fjzkuroko.vo.ViewArticle;

import java.util.List;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<Article> selectAllArticle() {
        return articleDao.selectAllArticle();
    }

    @Override
    public List<Article> selectAllAid(String keyword) {
        return articleDao.selectAllAid(keyword);
    }

    @Override
    public Article selectArticleByAid(int aid) {
        return articleDao.selectArticleByAid(aid);
    }

    @Override
    public List<ViewAlertCard> selectArticleCommentNumTop4() {
        return articleDao.selectArticleCommentNumTop4();
    }

    @Override
    public List<ViewArticle> selectArticleArchives() {
        return articleDao.selectArticleArchives();
    }

    @Override
    public List<Article> selectAidByLabel(int label) {
        return articleDao.selectAidByLabel(label);
    }
}
