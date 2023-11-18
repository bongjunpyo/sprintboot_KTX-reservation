package Team.KTX.reservation.dto;

import Team.KTX.reservation.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {

    private String title;
    private String content;

    public Article toEntity(){

        Article article = new Article(title,content);
        return article;
    }
}
