package xyz.fjzkuroko.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.fjzkuroko.dto.ResponseMessage;
import xyz.fjzkuroko.entity.Article;
import xyz.fjzkuroko.service.ArticleService;
import xyz.fjzkuroko.vo.ViewArticle;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/allAid")
    public ResponseMessage all(String keyword, int pageNum, int pageSize) {
        // 1.通过调用 PageHelper 的静态方法开始获取分页数据
        // 指定当前第几页以及每页显示的条数
        PageHelper.startPage(pageNum, pageSize);
        // 2.根据条件查询符合的商品信息
        List<Article> articles = articleService.selectAllAid(keyword);
        // 3.获得当前的分页对象
        PageInfo<Article> pageInfo = new PageInfo<>(articles);
        return ResponseMessage.newOkInstance(pageInfo);
    }

    @RequestMapping("/allForPage")
    public ResponseMessage allForPage(int pageNum, int pageSize) {
        // 1.通过调用 PageHelper 的静态方法开始获取分页数据
        // 指定当前第几页以及每页显示的条数
        PageHelper.startPage(pageNum, pageSize);
        // 2.根据条件查询符合的商品信息
        List<Article> articles = articleService.selectAllArticle();
        // 3.获得当前的分页对象
        PageInfo<Article> pageInfo = new PageInfo<>(articles);
        return ResponseMessage.newOkInstance(pageInfo);
    }

    @RequestMapping("/detail")
    public ResponseMessage detail(@RequestParam("aid") int aid) {
        return ResponseMessage.newOkInstance(articleService.selectArticleByAid(aid));
    }

    @RequestMapping("/commentNumTop4")
    public ResponseMessage commentNumTop4() {
        return ResponseMessage.newOkInstance(articleService.selectArticleCommentNumTop4());
    }

    @RequestMapping("/archives")
    public ResponseMessage archives(int pageNum, int pageSize) {
        // 1.通过调用 PageHelper 的静态方法开始获取分页数据
        // 指定当前第几页以及每页显示的条数
        PageHelper.startPage(pageNum, pageSize);
        // 2.根据条件查询符合的商品信息
        List<ViewArticle> viewArticles = articleService.selectArticleArchives();
        // 3.获得当前的分页对象
        PageInfo<ViewArticle> pageInfo = new PageInfo<>(viewArticles);
        return ResponseMessage.newOkInstance(pageInfo);
    }

    @RequestMapping("/getAidByLabel")
    public ResponseMessage getAidByLabel(int label, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Article> articles = articleService.selectAidByLabel(label);
        PageInfo<Article> pageInfo = new PageInfo<>(articles);
        return ResponseMessage.newOkInstance(pageInfo);
    }

}
