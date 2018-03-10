package co.selim.blog.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by Selim on 10.03.2018.
 */
public class AbstractController {
    @Value("${app.title}")
    private String title;

    @ModelAttribute("title")
    public String title() {
        return title;
    }
}
