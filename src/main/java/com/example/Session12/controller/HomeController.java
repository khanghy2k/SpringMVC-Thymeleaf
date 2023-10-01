package com.example.Session12.controller;

import com.example.Session12.model.LoginModel;
import com.example.Session12.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    private List<User> data;

    public HomeController() {
        this.data = new ArrayList<>(Arrays.asList(
                new User("admin1", "0987654321", true),
                new User("admin2", "0987654321", false),
                new User("admin3", "0987654321", true),
                new User("admin4", "0987654321", false),
                new User("admin5", "0987654321", true),
                new User("admin6", "0987654321", false)
        ));
    }

    @GetMapping("/home")
    public String home(Model model) {
        return "home/home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        return "home/about";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("login", new LoginModel());
        return "home/login";
    }

    @PostMapping("/login")
    public String login(@Valid LoginModel login, BindingResult bindingResult,HttpServletRequest request, Model model) {
       if (bindingResult.hasErrors()){
           return "home/login";
       }
        if (login.getUsername().equals("admin") && login.getPassword().equals("1234")) {
            HttpSession session = request.getSession();
            session.setAttribute("user", login.getUsername());
            return "redirect:/home/home";
        } else {
            return "home/login";
        }
    }


    @GetMapping("")
    public String index(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/home/login";
        }
        model.addAttribute("fullName","hy");
        model.addAttribute("user",new User("admin","043943342",false));
        model.addAttribute("data",data);
        return "home/index";
    }


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User("default", "0000000000", true));
        return "home/create";
    }

    @PostMapping("/create")
    public String create(User user, Model model) {
        data.add(user);
        return "redirect:/home";
    }
}
