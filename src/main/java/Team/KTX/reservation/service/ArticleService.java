package Team.KTX.reservation.service;

import Team.KTX.reservation.domain.Article;
import Team.KTX.reservation.dto.AddArticleRequest;
import Team.KTX.reservation.dto.UpdateArticleRequest;
import Team.KTX.reservation.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Article save(AddArticleRequest request){

        return articleRepository.save(request.toEntity());
    }

    public List<Article> findAll(){

        List<Article> articles = articleRepository.findAll();
        return articles;
    }

    public Article findOne(long id){

        Article article = articleRepository.findById(id).orElseThrow();
        return article;
    }

    public void delete(long id){
        articleRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request){

        Article article = articleRepository.findById(id).orElseThrow();
        article.update(request.getTitle(), request.getContent());
        return article;
    }
}
