package co.selim.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * Created by Selim on 10.03.2018.
 */
@Controller
public class PageController extends AbstractController {
    @GetMapping("/index")
    public String index(Map<String, Object> model) {
        return "index";
    }
}
