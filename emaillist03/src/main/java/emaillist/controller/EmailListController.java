package emaillist.controller;

import java.util.List;

import emaillist.repository.EmailListRepository;
import emaillist.vo.EmailListVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmailListController {
    private EmailListRepository emaillistRepository;

    public EmailListController(EmailListRepository emaillistRepository) {
        this.emaillistRepository = emaillistRepository;
    }

    @RequestMapping("/")
    public String index(Model model) {
        List<EmailListVo> list = emaillistRepository.findAll();
        model.addAttribute("list", list);
        return "index";
    }

    @RequestMapping("/form")
    public String form() {
        return "form";
    }

    @RequestMapping("/add")
    public String add(EmailListVo vo) {
        emaillistRepository.insert(vo);
        return "redirect:/";
    }
}