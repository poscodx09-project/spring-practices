package locale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LocaleController {
    private LocaleResolver localeResolver;
    public LocaleController(LocaleResolver localeResolver){
        this.localeResolver = localeResolver;
    }
    @RequestMapping("")
    public String index(HttpServletRequest request, Model model) {

        String lang = localeResolver.resolveLocale(request).getLanguage();
        model.addAttribute("lang",lang);

        System.out.println("[Chrome Language] : " + localeResolver.resolveLocale(request).getLanguage());
        return "index";
    }
}
