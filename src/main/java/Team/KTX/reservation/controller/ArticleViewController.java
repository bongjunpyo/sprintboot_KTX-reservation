package Team.KTX.reservation.controller;

import Team.KTX.reservation.domain.Article;
import Team.KTX.reservation.domain.User;
import Team.KTX.reservation.service.ArticleService;
import Team.KTX.reservation.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
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
    @GetMapping("/Center")
    public ModelAndView getArticle(Model model, HttpServletRequest httpServletRequest, HttpSession session){
        session = httpServletRequest.getSession(true);
        String userEmail = (String)session.getAttribute("userId");
        User user = userService.findByEmail(userEmail);
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        ModelAndView mav = new ModelAndView();
        List<Article> articles = articleService.findAll();

        boolean isLoggedIn = session.getAttribute("userId") !=null;
        mav.addObject("isLoggedIn",isLoggedIn);
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

    @GetMapping("/Center/{id}")
    public ModelAndView getArticle(Model model, HttpServletRequest httpServletRequest, HttpSession session, @PathVariable long id){
        session = httpServletRequest.getSession(true);
        String userEmail = (String)session.getAttribute("userId");
        User user = userService.findByEmail(userEmail);
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        ModelAndView mav = new ModelAndView();
        Article article = articleService.findOne(id);
        mav.addObject("article", article);
        boolean isLoggedIn = session.getAttribute("userId") !=null;
        mav.addObject("isLoggedIn",isLoggedIn);
        mav.setViewName("KTX_article");
        return mav;
    }

    @GetMapping("/KTX_new-article")
    public String createArticle(Model model, HttpSession session){

        String userEmail=(String) session.getAttribute("userId");
        User user = userService.findByEmail(userEmail);
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        List<Article> articles = articleService.findAll();
        model.addAttribute("articles", articles);
        return "newArticle";
    }

    @GetMapping("/modify/{id}")
    public ModelAndView modifyArticle(Model model, HttpServletRequest httpServletRequest, HttpSession session, @PathVariable long id){
        session = httpServletRequest.getSession(true);
        String userEmail = (String)session.getAttribute("userId");
        User user = userService.findByEmail(userEmail);
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        ModelAndView mav = new ModelAndView();
        Article article = articleService.findOne(id);
        mav.addObject("article", article);
        boolean isLoggedIn = session.getAttribute("userId") !=null;
        mav.addObject("isLoggedIn",isLoggedIn);
        mav.setViewName("KTX_articleModify");
        return mav;
    }

    @GetMapping("/KTX_Articles")
    public String articleList(Model model, HttpSession session){

        String userEmail=(String) session.getAttribute("userId");
        User user = userService.findByEmail(userEmail);
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        List<Article> articles = articleService.findAll();
        model.addAttribute("articles", articles);
        return "ArticleLogined";
    }


}
