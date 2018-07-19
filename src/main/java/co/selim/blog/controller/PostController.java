package co.selim.blog.controller;

import co.selim.blog.model.BlogPost;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    @GetMapping("/posts")
    public List<BlogPost> getPosts() {
        return Arrays.asList(
                BlogPost.BlogPostBuilder.aBlogPost()
                        .withTitle("Spring Boot")
                        .withText("Spring Boot is awesome!")
                        .withDate(LocalDate.now())
                        .build(),
                BlogPost.BlogPostBuilder.aBlogPost()
                        .withTitle("Mithril JS")
                        .withText("Playing around with Mithril JS")
                        .withDate(LocalDate.now().minusDays(1))
                        .build()
        );
    }
}
