package Team.KTX.reservation.controller;

import Team.KTX.reservation.domain.Article;
import Team.KTX.reservation.domain.User;
import Team.KTX.reservation.service.ArticleService;
import Team.KTX.reservation.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ArticleViewController {

    @Autowired
    ArticleService articleService;

    @Autowired
    UserService userService;
    @GetMapping("/KTX_Reservation/Center")
    public ModelAndView getArticle(){

        ModelAndView mav = new ModelAndView();
        List<Article> articles = articleService.findAll();
        mav.addObject("articles", articles);
        mav.setViewName("KTX_articleList");

        return mav;
    }
    @GetMapping("/KTX_article")
    public ModelAndView plusArticle(Model model, HttpSession session){
        ModelAndView mav = new ModelAndView();

        // 코드 추가: 세션에서 현재 로그인된 사용자의 이메일을 가져옴
        String userEmail = (String) session.getAttribute("userId");
        User user = userService.findByEmail(userEmail);

        if (user != null) {
            // 코드 추가: 사용자가 로그인되어 있으면 모델에 사용자 이름을 추가
            model.addAttribute("userName", user.getName());
        }

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
