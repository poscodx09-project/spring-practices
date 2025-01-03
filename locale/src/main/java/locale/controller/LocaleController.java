package locale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LocaleController {
    private LocaleResolver localeResolver;
    public LocaleController(LocaleResolver localeResolver){
        this.localeResolver = localeResolver;
    }
    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        System.out.println(localeResolver.resolveLocale(request).getLanguage());
        return "index";
    }
}
