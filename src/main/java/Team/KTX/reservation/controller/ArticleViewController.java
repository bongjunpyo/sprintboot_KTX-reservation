package Team.KTX.reservation.controller;

import Team.KTX.reservation.domain.Article;
import Team.KTX.reservation.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ArticleViewController {

    @Autowired
    ArticleService articleService;
    @GetMapping("/KTX_Reservation/Center")
    public ModelAndView getArticle(){

        ModelAndView mav = new ModelAndView();
        List<Article> articles = articleService.findAll();
        mav.addObject("articles", articles);
        mav.setViewName("KTX_articleList");

        return mav;
    }
    @GetMapping("/KTX_article")
    public ModelAndView plusArticle(){
        ModelAndView mav = new ModelAndView();
        List<Article> articles = articleService.findAll();
        mav.addObject("articles", articles);
        mav.setViewName("ArticleNoLogin");

        return mav;
    }

    @GetMapping("/KTX_Reservation/Center/{id}")
    public ModelAndView getArticle(@PathVariable long id){

        ModelAndView mav = new ModelAndView();
        Article article = articleService.findOne(id);
        mav.addObject("article", article);
        mav.setViewName("KTX_article");
        return mav;
    }

    @GetMapping("/KTX_Reservation/KTX_new-article")
    public String createArticle(){

        return "newArticle";
    }

    @GetMapping("/KTX_Reservation/modify/{id}")
    public ModelAndView modifyArticle(@PathVariable long id){
        ModelAndView mav = new ModelAndView();
        Article article = articleService.findOne(id);
        mav.addObject("article", article);
        mav.setViewName("KTX_articleModify");

        return mav;
    }


}
