package my.app.first_Project.controller;

import my.app.first_Project.dto.Animals;
import my.app.first_Project.dto.Fruits;
import my.app.first_Project.dto.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

@RequestMapping("/basic")
public class ThymeleafController {

    @GetMapping("/date")
    public String date(Model model) {
        model.addAttribute("nowDateTime", LocalDateTime.now());
        return "/utility/date";
    }

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

        List<Fruits> fruits = new ArrayList<>();

        Fruits apple = new Fruits("사과","신맛");
        Fruits mango = new Fruits("망고","노란맛");

        fruits.add(apple);
        fruits.add(mango);

        model.addAttribute("fruits",fruits);
        System.out.println(fruits);

        Map<String, Animals> animalsMap = new HashMap<>();

        Animals dog = new Animals();

        dog.setName("멍멍이");
        dog.setSound("멍멍");

        Animals cat = new Animals();

        cat.setName("야옹이");
        cat.setSound("야옹");

        animalsMap.put("dog",dog);
        animalsMap.put("cat",cat);

        model.addAttribute("map",animalsMap);

        return "/basic/variables";
    }
}
