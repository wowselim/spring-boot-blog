package co.selim.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Serves the initial SPA page.
 * Created by Selim on 10.03.2018.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public String index(Map<String, Object> model) {
        model.put("title", "selim.co");
        return "index";
    }
}
