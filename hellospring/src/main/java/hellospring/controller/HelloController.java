package hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "/WEB-INF/views/hello.jsp";
    }

    @RequestMapping("/hello2")
    public ModelAndView hello2(@RequestParam String name){
        ModelAndView mav = new ModelAndView();
        mav.addObject("hello","Hello" + name);
        mav.setViewName("/WEB-INF/views/hello.jsp");
        return mav;
    }
}
