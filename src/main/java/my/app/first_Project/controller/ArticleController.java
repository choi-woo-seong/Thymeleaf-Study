package my.app.first_Project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/articles")
public class ArticleController {
    @GetMapping({"/", ""})
    public String mainPage() {
        return "/articles/main";
    }

    @GetMapping("/listAll")
    public String listAll() {
        return "/articles/article/list_all";
    }

    @GetMapping("{id}")
    public String listOne(
            @PathVariable("id") int id,
            Model model
    ) {
        model.addAttribute("id", id);
        return "/articles/article/list_one";
    }

    @GetMapping("create")
    public String createArticle(
            @RequestParam("name")String name,
            @RequestParam("weight")int weight,
            @RequestParam("height")int height,
            Model model
    ) {
        model.addAttribute("name", name);
        model.addAttribute("weight", weight);
        model.addAttribute("height", height);
        return "/articles/article/new";
    }

    @GetMapping("update")
    public String update() {
        return "/articles/article/update_ok";
    }

    @GetMapping("{id}/update")
    public String updateForm(
            @PathVariable("id") int id,
            Model model
    ) {
        model.addAttribute("id", id);
        return  "/articles/article/update";
    }

    @GetMapping("{id}/delete")
    public String deleteArticle(@PathVariable("id")int id
        , Model model) {
        model.addAttribute("id", id);
        return "/articles/article/delete_ok";
    }
}
