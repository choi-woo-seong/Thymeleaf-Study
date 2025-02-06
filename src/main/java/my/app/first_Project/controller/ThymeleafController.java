package my.app.first_Project.controller;

import my.app.first_Project.dto.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/basic")
public class ThymeleafController {
    @GetMapping("text-basic")
    public String textBasic(Model model){
        model.addAttribute("name", "안유진");
        model.addAttribute("mylove", "love");
        return "/basic/text-basic";
    }

    @GetMapping("variables")
    public String variables(Model model){

//        UserData userData = new UserData("장원영",20,"서울");

        UserData userData = new UserData();
        userData.setUserName("안유진");
        userData.setUserAge(22);
        userData.setUserAddress("제주");


        System.out.println(userData);

        model.addAttribute("userData",userData);
        model.addAttribute("data","장원영");

        return "/basic/variables";
    }
}
