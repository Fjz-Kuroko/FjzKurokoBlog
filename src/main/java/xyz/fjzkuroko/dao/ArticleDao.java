package xyz.fjzkuroko.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xyz.fjzkuroko.entity.Article;
import xyz.fjzkuroko.vo.ViewAlertCard;
import xyz.fjzkuroko.vo.ViewArticle;

import java.util.List;

@Repository
@Mapper
public interface ArticleDao {
    List<Article> selectAllArticle();
    List<Article> selectAllAid(String keyword);
    Article selectArticleByAid(int aid);
    List<ViewAlertCard> selectArticleCommentNumTop4();
    List<ViewArticle> selectArticleArchives();
    List<Article> selectAidByLabel(int label);
}
