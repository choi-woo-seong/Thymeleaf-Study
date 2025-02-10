package my.app.first_Project.controller;

import my.app.first_Project.dto.Animal;
import my.app.first_Project.dto.Fruits;
import my.app.first_Project.dto.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/basic")
public class ThymeleafController {
    @GetMapping("/date")
    public String date(Model model) {
        model.addAttribute("nowDateTime",
                LocalDateTime.now());
        return "/utility/date";
    }

    //     http://localhost:8080/basic/text-basic
    @GetMapping("text-basic")
    public String textBasic(Model model) {
        model.addAttribute("name", "안유진");
        model.addAttribute("mylove", "형민이");
        return "/basic/text-basic";
    }

    @GetMapping("variables")
    public String variables(Model model) {

//        UserData userData = new UserData("장원영",
//                    20, "서울");
        UserData userData = new UserData();
        userData.setUserName("안유진");
        userData.setUserAge(22);
        userData.setUserAddress("제주");
//        UserData userData = new UserData("홍길동", 10);
        System.out.println(userData);
        model.addAttribute("userData", userData);
        model.addAttribute("data", "장원영");

//      리스트 작업하기
        List<Fruits> fruits = new ArrayList<>();
        Fruits apple = new Fruits("사과", "신맛");
        Fruits mango = new Fruits("망고", "노란맛");

        fruits.add(apple);
        fruits.add(mango);

        model.addAttribute("fruits", fruits);
        System.out.println(fruits);

//        맵으로 작업하기
        Map<String, Animal> animalMap = new HashMap<>();
        Animal dog = new Animal();
        dog.setName("멍멍이");
        dog.setSound("멍멍");

        Animal cat = new Animal();
        cat.setName("야옹이");
        cat.setSound("야옹");

        animalMap.put("dog", dog);
        animalMap.put("cat", cat);
        model.addAttribute("map", animalMap);
        return "/basic/variables";
    }

    @GetMapping("/literal")
    public String literal(Model model) {
        model.addAttribute("data", "Spring!");
        return "/basic/literal";
    }

    @GetMapping("/operation")
    public String operation(Model model) {
        model.addAttribute("a", 10);
        model.addAttribute("b", 3);
        model.addAttribute("nullData", null);
        model.addAttribute("name", "리사");
        return "/basic/operation";
    }

    @GetMapping("/attribute")
    public String attribute() {
        return "/basic/attribute";
    }

    @GetMapping("/for")
    public String forOperation(Model model){
        addUser(model);
        return "/basic/for_opr";
    }

    @GetMapping("/ive")
    public String details(
            @RequestParam("name")String name,
            @RequestParam("age")int age,
            @RequestParam("addr")String addr,
            Model model) {
        model.addAttribute("selectUser",
                UserData.fromParams(name, age, addr));
        return "/basic/detail";
    }


    private void addUser(Model model) {
        List<UserData> userList = new ArrayList<>(
                Arrays.asList(
                        new UserData("장원영", 21, "서울"),
                        new UserData("안유진", 23, "대구"),
                        new UserData("이서", 19, "부산"),
                        new UserData("가을", 24, "광주"),
                        new UserData("리즈", 22, "울산"),
                        new UserData("레이", 22, "부산"),
                        new UserData("홍길동", 40, "제주")
                )
        );
        model.addAttribute("userList",userList);
        System.out.println(userList);
    }

    @GetMapping("/condition")
    public String condition(Model model) {
        addUser(model);
        return "/basic/condition";
    }
}
