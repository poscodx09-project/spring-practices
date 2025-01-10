package validation.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import validation.domain.User;

import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/result")
    public String result() {
        return "result";
    }

    @GetMapping("/ex01")
    public String ex01() {
        return "form/ex01";
    }

    @PostMapping("/ex01")
    public String ex01(@ModelAttribute @Valid User user, BindingResult result, Model model) {
        if(result.hasErrors()) {
            // List<ObjectError> errors = result.getAllErrors();
            // for(ObjectError error : errors) {
            //	System.out.println(error);
            // }

            Map<String, Object> map = result.getModel();
            // Set<String> s = map.keySet();
            // for(String key : s) {
            //	model.addAttribute(key, map.get(key));
            // }
            model.addAllAttributes(map);
            return "form/ex01";
        }

        return "redirect:/result";
    }

    @GetMapping("/ex02")
    public String ex02() {
        return "form/ex02";
    }

    @PostMapping("/ex02")
    public String ex02(@ModelAttribute @Valid User user, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAllAttributes(result.getModel());
            return "form/ex02";
        }

        return "redirect:/result";
    }

    @GetMapping("/ex03")
    public String ex03(@ModelAttribute User user) {
        return "form/ex03";
    }

    @PostMapping("/ex03")
    public String ex03(@ModelAttribute @Valid User user, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAllAttributes(result.getModel());
            return "form/ex03";
        }

        return "redirect:/result";
    }
}