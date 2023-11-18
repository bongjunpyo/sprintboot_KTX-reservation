package Team.KTX.reservation.controller;

import Team.KTX.reservation.domain.Article;
import Team.KTX.reservation.dto.AddArticleRequest;
import Team.KTX.reservation.dto.UpdateArticleRequest;
import Team.KTX.reservation.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
        Article savedarticle = articleService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedarticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<Article>> findAllArticle(){

        List<Article> articles = articleService.findAll();
        return ResponseEntity.ok().body(articles);

    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<Article> findArticle(@PathVariable long id){

        Article article = articleService.findOne(id);
        return ResponseEntity.ok().body(article);
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id){
        articleService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody UpdateArticleRequest updateArticle){

        Article article = articleService.update(id,updateArticle);
        return ResponseEntity.ok().body(article);

    }
}
